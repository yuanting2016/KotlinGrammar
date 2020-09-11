package com.tingyuan.kotlindemo;

import com.tingyuan.kotlindemo.grammersugar.Extension;

/**
 * @description:
 * @author: tingyuan
 * @date: 2020/8/18
 */
public class TestJavaEntrance {

    public static void main(String[] args){
       javaEntry(null);
    }

    public static void javaEntry(String a){
        Extension.INSTANCE.a(a);
    }
}
