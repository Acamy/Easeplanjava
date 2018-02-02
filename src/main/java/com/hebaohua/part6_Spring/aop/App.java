package com.hebaohua.part6_Spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Hebh
 * @date 2018/2/2
 * @description:
 */
public class App {
    ApplicationContext ac =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    // 目标对象有实现接口，spring会自动选择“JDK代理”
    @Test
    public void testApp() {
        IUserDao userDao = (IUserDao) ac.getBean("userDao");
        System.out.println(userDao.getClass());//$Proxy001
        userDao.save();
    }

    // 目标对象没有实现接口， spring会用“cglib代理”
    @Test
    public void testCglib() {
        OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
    }

    @Deprecated
    // 共性问题：如果目标对象有实现接口，在从容器中获取目标对象的时候，只能通过接口接收对象。
    public void testApp2() {
        // 错误代码： 只能用接口接收
        UserDao userDao = (UserDao) ac.getBean("userDao");
        System.out.println(userDao.getClass());//$Proxy001
        userDao.save();
    }

    @Test
    public void testGetObj() throws Exception {
        OrderDao orderDao1 = (OrderDao) ac.getBean("orderDao");
        OrderDao orderDao2 = (OrderDao) ac.getBean("orderDao");

        System.out.println(orderDao1);
        System.out.println(orderDao2);
    }
}

interface IUserDao {
    void save();
}

//目标对象1,实现了接口
@Component        // 加入容器
class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("-----核心业务：保存！！！------");
    }
}

//目标对象1,没有实现接口
@Component   // 加入容器
@Scope("prototype")
class OrderDao{
    public void save() {
        System.out.println("-----核心业务：保存！！！------");
    }
}
