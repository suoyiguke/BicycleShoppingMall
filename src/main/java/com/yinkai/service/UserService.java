package com.yinkai.service;

import com.yinkai.common.PageBean;
import com.yinkai.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/1221:18
 */
public interface   UserService {


    List<User> findAllUser() throws SQLException;

    int addUser(User user)throws SQLException;

    void pageQuery(String sql, PageBean pageBean) throws SQLException;

    String checkUser(String code) throws Exception;
}
