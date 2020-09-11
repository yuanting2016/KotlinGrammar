package com.tingyuan.kotlindemo.grammersugar

import java.sql.DriverManager.println

/**
 *    @date :2020/8/17
 *    @author:yuanting
 *    @des:字符串相关
 */
 object Strings {

    /**
     * 三个引号 """ 扩起来的字符串，支持多行字符串
     */
    fun test(){
        val text = """
            多行字符串 \adhde
            多行字符串de 
              """
        println(text)   // 输出有一些前置空格
    }

    /**
     * 字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中
     */
    fun test1(){
        val i = 10
        val s = "i = $i" // 求值结果为 "i = 10"
        println(s)

        /**
         * 用{}括起来的任意表达式
         */
            val s1 = "runoob"
            val str = "$s1.length is ${s1.length}" // 求值结果为 "runoob.length is 6"
            println(str)
    }

    /**
     *  如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义）
     */
    fun test2(){
        val price = """
             ${'$'}9.99
              """
        println(price)
    }
}

fun main(args: Array<String>) {
    Strings.test1()
}