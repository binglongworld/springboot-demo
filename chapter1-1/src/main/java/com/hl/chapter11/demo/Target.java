package com.hl.chapter11.demo;

/**
 * 需要动态代理的接口
 */
public interface Target {
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name);

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye();

}
