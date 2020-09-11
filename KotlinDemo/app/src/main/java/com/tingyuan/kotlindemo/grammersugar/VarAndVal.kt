package com.tingyuan.kotlindemo.grammersugar

/**
 *    @date :2020/8/17
 *    @author:yuanting
 *    @des:定义常量与变量相关
 *    可变变量定义：var 关键字
 *    不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
 *    Java 提供了八种基本类型：byte、short、int、long、float、double、boolean、char
 *    对标kotlin中为         Byte、Short、Int、Long、Float、Double、Boolean、Char
 *    Kotlin 中对于数字没有隐式类型自动转换,较⼩的类型不能隐式转换为较⼤的类型
 */
object VarAndVal {

    const val test = 0

    fun test(){
        val a: Int = 1
        val b = 1       // 系统自动推断变量类型为Int
        val c: Int      // 如果不在声明时初始化则必须提供变量类型
        c = 1           // 明确赋值

        var x = 5       // 系统自动推断变量类型为Int
        x += 1           // 变量可修改




    }

    /**
     * lateinit 修饰的变量为可变
     */
    lateinit var string: String

    /**
     * bylazy 修饰的变量为不可变 接受一个 lambda 并返回一个 Lazy <T> 实例的函数
     */
    val lazyValue:String by lazy {
            print("ssss")
            "test"
    }

}


fun main(args: Array<String>) {
    VarAndVal.lazyValue

}