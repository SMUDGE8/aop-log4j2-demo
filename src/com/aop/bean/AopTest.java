package com.aop.bean;

import com.aop.service.AService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Zhang Lei
 * @Date 2017/12/11
 */
public class AopTest {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AService aService = (AService) factory.getBean("aService");
        aService.cool();
        aService.cool("Ȫԡ�彭");
    }
}
