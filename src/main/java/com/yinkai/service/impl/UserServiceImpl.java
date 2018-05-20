package com.yinkai.service.impl;

import com.yinkai.common.PageBean;
import com.yinkai.common.ResultBean;
import com.yinkai.dao.UserDao;
import com.yinkai.model.User;
import com.yinkai.service.UserService;
import com.yinkai.utils.FastJsonUtils;
import com.yinkai.utils.HttpRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/1222:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public List<User> findAllUser() throws SQLException {

        return  userDao.findAllBean("select * from user",null);
    }


    @Override
    public int addUser(User user) throws SQLException {
        String sql ="INSERT INTO user (user_id,OPEN_id,school_id,nickname,sex,autograph,headImage_id) VALUES(?,?,?,?,?,?,?)";
        ArrayList<Object> pram = new ArrayList<Object>();
        pram.add(user.getUser_id());
        pram.add(user.getOpenId());
        pram.add(user.getSchoolId());
        pram.add(user.getNickname());
        pram.add(user.getSex());
        pram.add(user.getAutograph());
        pram.add(user.getHeadimageId());


        return  userDao.insert1(sql,pram.toArray());
    }

    @Override
    public void pageQuery(String sql, PageBean pageBean) throws SQLException {
         userDao.pageQuery( sql,  pageBean);
    }

    @Override
    public String checkUser(String code) throws Exception {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isBlank(code)) {
            resultBean.setState(0);
            resultBean.setMessage(this.getClass().getName()+"参数为空！");
            return FastJsonUtils.toJSONString(resultBean);
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String param = "appid=wx46ea0c1fbfbd6710&secret=d13b7177ca0e3e58aa4fcfa34c8c8881&js_code=" + code + "&grant_type=authorization_code";
        return HttpRequest.sendGet(url, param);

    }
}
