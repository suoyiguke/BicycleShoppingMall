package com.yinkai.controller;

import com.yinkai.common.CheckBean;
import com.yinkai.service.UserService;
import com.yinkai.utils.FastJsonUtils;
import com.yinkai.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class UserController {

    @Resource
    private UserService userService;


    @Resource
    private JedisClient jedisClient;

    @Value("${SESSION_TIME}")
    private Integer SESSION_TIME;





    /**
     * 小程序----用户验证
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.GET)
    public void checkUser(HttpServletResponse response, @RequestParam(value = "js_code", required = false) String code) throws Exception {

        String checkString = userService.checkUser(code);
        CheckBean checkBean = FastJsonUtils.getSingleBean(checkString, CheckBean.class);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        //存入redis，模拟session
        //z
        jedisClient.set(uuid, checkBean.getOpenid());
        jedisClient.expire(uuid, SESSION_TIME);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println("{\"sessionId\":\"" + uuid + "\"}");//将sessionid返回

    }












}
