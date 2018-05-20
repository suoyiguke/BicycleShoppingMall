package com.yinkai.test;

import com.yinkai.common.PageBean;
import com.yinkai.model.User;
import com.yinkai.service.UserService;
import com.yinkai.utils.FastJsonUtils;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/1222:39
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-dao.xml"})
@Rollback(value=true)//回滚
@Transactional(transactionManager="transactionManager")
public class Test {

    @Resource
    UserService userService;



    @org.junit.Test
    public void test() throws SQLException {
        List<User> allUser = userService.findAllUser();



        System.out.println(FastJsonUtils.toJSONString(allUser));

    }

    /**
     * 回滚操作成功！
     * @throws SQLException
     */
    @org.junit.Test
    public void insert() throws SQLException {

        User user = new User(113,"3xaxsx",405,"独钓航x俭学","男","嘻嘻嘻嘻嘻嘻嘻",123);

        userService.addUser(user);


    }


    /**
     * f分页
     * @throws SQLException
     */
    @org.junit.Test
    public void fenye() throws SQLException {

        int currentPage =1;
        int pageSize =5;

        PageBean pageBean = new PageBean();
        pageBean.getPram().add("%凯%");
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);







        userService.pageQuery("select * from user where nickname like ?", pageBean);


        System.out.println(FastJsonUtils.toJSONString(pageBean));


    }
}
