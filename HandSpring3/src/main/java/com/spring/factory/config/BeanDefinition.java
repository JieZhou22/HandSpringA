package com.spring.factory.config;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:44
 * @Description: 用于定义Bean实例化信息
 */
public class BeanDefinition {
    /* 创建简单的Bean容器
    private Object bean;

    public Object getBean() {
        return bean;
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
     */

    // 创建Class对象，把Bean的实例化操作放到容器中处理
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
