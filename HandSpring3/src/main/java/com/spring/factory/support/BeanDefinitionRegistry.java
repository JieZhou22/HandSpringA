package com.spring.factory.support;

import com.spring.factory.config.BeanDefinition;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午11:17
 * @Description:
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
