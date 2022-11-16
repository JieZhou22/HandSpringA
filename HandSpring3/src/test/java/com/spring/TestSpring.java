package com.spring;

import com.spring.bean.UserService;
import com.spring.factory.config.BeanDefinition;
import com.spring.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:50
 * @Description:
 */
public class TestSpring {
/*  first test
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

 */

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小磊哥");
        userService.queryUserInfo();

//        // 4.第二次获取 bean from Singleton
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService","小磊哥");
//        userService_singleton.queryUserInfo();
    }
}
