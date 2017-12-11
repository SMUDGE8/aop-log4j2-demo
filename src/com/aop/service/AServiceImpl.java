package com.aop.service;

/**
 * @Author Zhang Lei
 * @Date 2017/12/11
 */
public class AServiceImpl implements AService {
    @Override
    public void cool(String _msg) {
        System.out.println("1111"+_msg);
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public void cool() {
        System.out.println("2222");
    }
}
