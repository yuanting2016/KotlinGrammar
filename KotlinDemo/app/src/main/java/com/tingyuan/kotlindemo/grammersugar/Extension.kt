package com.tingyuan.kotlindemo.grammersugar

import com.tingyuan.kotlindemo.DataModel
import com.tingyuan.kotlindemo.TestJavaEntrance
import com.tingyuan.kotlindemo.grammersugar.Extension.also
import com.tingyuan.kotlindemo.grammersugar.Extension.lastChar
import com.tingyuan.kotlindemo.grammersugar.Extension.let
import com.tingyuan.kotlindemo.grammersugar.Extension.test

/**
 *    @date :2020/8/17
 *    @author:yuanting
 *    @des:
 *    扩展函数可以作为类成员进行调用的函数，定义在类的外部，为一个已经存在的类添加额外的方法。
 *    so,我们可以摒弃utils的方式对已存在的类进行功能的扩展
 *
 *    扩展函数 run let also apply
 *
 *          返回闭包执行结果             是否有闭包参数
 *  let       ☑️                       ☑️
 *  run       ☑️                       ❌
 *  also      ❌                          ☑️
 *  apply     ❌                          ❌
 */

object Extension {

    //---------------------------------------扩展函数---------------------------------------------------------------//
    /**
     * 为String类型添加一个返回这个字符串最后一个字符的方法
     * 使用时导入的路径 com.tingyuan.kotlindemo.grammersugar.Extension.lastChar
     */
    fun String.lastChar(): Char {
       return this.get(this.length - 1)
    }


    fun String?.isNoEmpty(): Boolean{
        return this?.isNotEmpty()?:true
    }

    /**
     * 对扩展函数进行范型化。
     */
    fun <T> Collection<T>.joinString(separator: String = "",
    prefix:String = "" ,postfix: String = ""):String {
        val result = StringBuilder(prefix)
        for ((index, value) in this.withIndex()) {
            if (index > 0) {
                result.append(separator)
            }
            result.append(value)
        }
        result.append(postfix)
        return result.toString()
    }

    //------------------------------------常见的几个扩展函数--------------------------------------------------------//
    fun run() {

        /**
         * 调用run函数块。返回值为函数块最后一行，或者指定return表达式。
         */
        fun test1(){
            val a = run {
                println("run")
                return@run 3
            }
            println(a)
        }

        /**
         * 调用某对象的run函数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
         */
        fun test2(){
            val a = "string".run {
                var i = length
                println(this)
               return@run 3
            }
            println(a)
        }
    }

    /**
     * 调用某对象的let函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。
     * 返回值为函数块的最后一行或指定return表达式。
     */
    fun let() {
        val a = "string".let { it ->
            println(it)
            "sssss"
        }
        println(a)
    }

    /**
     * 调用某对象的also函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。返回值为该对象自己。
     */
    fun also() {
        var a = "string".also { it ->
            val s = "aaaaa"
            println(s)
        }
        println(a)
    }

    /**
     * 调用某对象的apply函数，在函数块内可以通过 this 指代该对象。返回值为该对象自己。
     */
    fun apply() {
        val a = "aaaaa".apply {
            println(this)
        }
        println(a)
    }


    /**
     * with函数和前面的几个函数使用方式略有不同，因为它不是以扩展的形式存在的。
     * 它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
     */
    fun with() {
        val a = with("string") {
            println(this)
            3
        }
        println(a)
    }

    inline fun test(p1:Int, noinline p2:()->Unit){

        p2()
    }

    //  todo 内联函数：先把参数表达式进行运算求值，然后把表达式的值传递给形参，旨在节约原本函数调用时的空间开销。
    //  todo 注意：内联函数，函数体必须足够简单，不能包含复杂的循环、条件、选择等结构。
    //  todo 节约时间，但会使代码变得更庞大，时间、空间上的平衡

    fun a (ass:String){
        TestJavaEntrance.javaEntry(ass)
    }

}

inline  fun test2(){}
fun main(args: Array<String>) {
//    test(1,test2)
//    also()
//        println("Kotlin".lastChar())
//
//
//
//    println(listOf("a", "b", "c").joinToString(prefix = "[", postfix = "]"))
//
//    var dataModel  = DataModel("jocelyn",18,2)
//    dataModel?.let {
//
//    }
//    dataModel?.also {
//
//    }
//
//    dataModel?.apply {
//
//    }
//
//    dataModel?.run {
//
//    }


}
