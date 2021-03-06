package com.zzz.controller;

import com.zzz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
public class SpringMVCTest {

    /* 有@ModelAttribute标记的方法，会在每个目标方法执行之前被springmvc调用 */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            User user = new User(1, "Tom", "123456", "12", "Tom@qq.com");
            System.out.println("模拟从数据库获取user:" + user);
            map.put("user", user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("修改: " + user);
        return "success";
    }

    /* @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外（使用的是value属性值），
    * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（使用的是types属性值）
    * 需要注意的是该注解只能放在类上面，不能放到方法上面 */
    @RequestMapping("/testSeesionAttributes")
    public String testSeesionAttributes(Map<String, Object> map) {
        User user = new User();
        user.setUsername("aa");
        user.setPassword("123");
        map.put("user", user);
        map.put("aaa", "aaa");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("name", Arrays.asList("aa", "bb"));
        return "success";
    }

    /* springmvc会把ModelAndView中的model即数据放到request的请求域中 */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = "success";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    @GetMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("test cookie value : sessionId:" + sessionId);
        return "success";
    }
}
