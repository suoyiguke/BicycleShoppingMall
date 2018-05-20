package com.yinkai.dao;

import com.yinkai.common.PageBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {


    Map<String, Object> findOneMap(String sql, Object[] params) throws SQLException;


    T findOneBean(String sql, Object[] params) throws SQLException;


    List<Map<String, Object>> findAllMap(String sql, Object[] params) throws SQLException;


    List<T> findAllBean(String sql, Object[] params) throws SQLException;


    List findAllBean(String sql, Object[] params, Class clazz) throws SQLException;


    Object findOneCol(String sql, Object[] params, String colName) throws SQLException;


    int insert1(String sql, Object[] params) throws SQLException;


    Map<String, Object> insert2(String sql, Object[] params) throws SQLException;


    T insert3(String sql, Object[] params) throws SQLException;


    Object insert4(String sql, Object[] params, Class clazz) throws SQLException;

    void insertBatch(String sql, Object[][] params) throws SQLException;


    int update(String sql, Object[] params) throws SQLException;


    int[] updateBatch(String sql, Object[][] params) throws SQLException;


    int delete(String sql, Object[] params) throws SQLException;

    int[] deleteBatch(String sql, Object[][] params) throws SQLException;

    void pageQuery(String sql, PageBean pageBean) throws SQLException;
}

