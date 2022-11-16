package com.spring.factory.support;

import com.spring.BeansException;
import com.spring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午11:10
 * @Description: 实现了Bean的实例化操作newInstance，并调用addSingleton方法存放到单例对象的缓存中去
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        // 1. 创建一个空bean
        Object bean = null;
        try {
            // 2. 利用beanDefinition获取到bean的class，然后利用newInstance()新建一个bean
//            bean = beanDefinition.getBeanClass().newInstance();
            // 不再是利用类信息实例化bean了，而是加上了+有参构造信息来实例化
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 3.将新构造的单例对象添加到缓存中去,下一次访问的时候，先进入缓存查看是否有相同beanName的单例对象
        registerSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();

        // getDeclaredConstructors()得到的是一个集合，你的所有构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            // 构造函数集合与入参信息进行比较，这里只进行数量对比，实际源码中还需要对比入参类型，否则相同数量不同入参类型的情况，就会抛异常了
            // 对比是为了找到对应的构造函数，并使用进行实例化
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
