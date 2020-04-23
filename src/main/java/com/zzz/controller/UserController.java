package com.zzz.controller;

import com.zzz.entity.RestEntity;
import com.zzz.model.User;
import com.zzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
     * 获取用户列表
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    /* 了解：可以使用params和headers来更加精确的映射请求，params和headers支持简单的表达式
    * 请求路径里可以用通配符*
    * 用@PathVariable取路径里的参数值
    * 用@RequestParam取get方法中的请求参数
    * 了解：用@RequestHeader映射请求头，可以取出请求头里的信息 */
    @GetMapping("/users")
    public RestEntity<List<User>> getUsers() throws Exception {

        List<User> users = userService.getUsers();

        return new RestEntity<List<User>>(users);
    }

    /*
     * 新增用户信息
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/users")
    public RestEntity insertUser(@RequestBody User user) throws Exception {

        int result = userService.insertUser(user);

        if (result > 0) {
            return new RestEntity();
        } else {
            return new RestEntity("新增失败");
        }
    }

    /*
     * 获取用户信息
     *
     * @param id 用户id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/users/{id}")
    public RestEntity<User> getUser(@PathVariable Integer id) throws Exception {

        User user = userService.getUser(id);

        return new RestEntity<User>(user);
    }

    /*
     * 修改用户信息
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PutMapping("/users/{id}")
    public RestEntity updateUser(@PathVariable Integer id, @RequestBody User user) throws Exception {

        user.setId(id);
        int result = userService.updateUser(user);

        if (result > 0) {
            return new RestEntity();
        } else {
            return new RestEntity("修改失败");
        }

    }

    /*
     * 删除用户信息
     *
     * @param id 用户id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @DeleteMapping("/users/{id}")
    public RestEntity deleteUser(@PathVariable Integer id) throws Exception {

        int result = userService.deleteUser(id);

        if (result > 0) {
            return new RestEntity();
        } else {
            return new RestEntity("删除失败");
        }
    }
}
