package com.tingyuan.kotlindemo.grammersugar

import com.tingyuan.kotlindemo.grammersugar.Extension.lastChar

/**
 *    @date :2020/8/17
 *    @author:yuanting
 *    @des:lambda相关
 */
object  Lambda {

    /**
     * ->无参数的情况
     * val/var 变量名 = { 操作的代码 }
     */
    fun test() {
       var t = { print("无参数的情况")}
    }

    /**
     *  ->有参数的情况
     *  val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
     */
    fun test1() {
        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3
    }

    /**
     * -> lambda表达式作为函数中的参数的时候，这里举一个例子：
    fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){
    ...
    }
     */
    fun testFunParam(param1:Int, funcParam: String.(i:Int, j:String) -> Int) {

        val default = "200"

        println( param1 + "".funcParam(param1, default) )

    }

}


fun main(args: Array<String>) {
    print("kotlin".lastChar())

}