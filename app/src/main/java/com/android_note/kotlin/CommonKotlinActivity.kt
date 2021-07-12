package com.android_note.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android_note.client.R
import kotlinx.android.synthetic.main.activity_common_kotlin.*

/**
 * @author fenghui
 * @date 2021/7/12.
 * @description kotlin 基础应用
 */
class CommonKotlinActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_kotlin)
        initView()
    }

    private fun initView() {
        btn1.setOnClickListener {
            singleton()
        }
    }

    /**
     * 懒初始化bylazy和延迟初始化lateinit
     *
     *      1.懒初始化by lazy ：懒初始化是指推迟一个变量的初始化时机，变量在使用的时候才去实例化，这样会更加的高效。因为我们通常会遇到这样的情况，
     *                                  一个变量直到使用时才需要被初始化，或者仅仅是它的初始化依赖于某些无法立即获得的上下文
     *
     *      2.延迟初始化lateinit：对于var的变量，如果类型是非空的，是必须初始化的，不然编译不通过，这时候需要用到lateinit延迟初始化，使用的时候再去实例化。
     *
     * 二者区别：
     *  by lazy 修饰val的变量
     *  lateinit 修饰var的变量，且变量是非空的类型
     *
     */
    lateinit var points: Point
    private fun init(){
        //懒初始化
        val point: Point by lazy { Point(1,2) }
        //延迟初始化 （必须初始化）
        points = Point(1,2)
        //判断是否初始化
        if(this::points.isInitialized){

        }
    }

    /**
     * 高阶函数：如果一个函数接受另外一个函数作为参数，或者返回值的类型是另外一个函数，那么该函数称为高阶函数
     *
     * 函数规则：
     *               -> 左边部分是用来声明该函数接收什么参数，多个参数可用逗号隔开，若不接收参数则写空括号即可
     *               -> 右边部分是用来声明该函数的返回值是什么类型，若没有返回值就使用 Unit (类似Java中的void)
     *              (String, Int) -> Unit
     *
     */
    private fun function(){
        example1{ a, b ->
            println(a+b)
        }
        example2 {
            println("-----无惨-----")
        }
        var value = example3{ a, b -> a + b }
        println("$value")
    }

    //方法带参数 无返回值
    private fun example1(func :(String, Int) ->Unit){
        func("hello",1)
    }

    //方法不带参数 无返回值
    private fun example2(func :() ->Unit){
        func()
    }

    //带返回值
    private fun example3(result: (Int, Int) -> Int): Int {
        return result(1,2)
    }

    /**
     * kt Object 单例 ：用法
     *      1.对象声明 —— 一个关键字实现单例
     *      2.伴生对象 —— static 的代替者
     *      3.对象表达式 —— Kotlin 的匿名内部类
     *
     */
    private fun singleton(){
        //object类创建单例
        Singleton.create()
        //伴生对象（fragment中应用）
        User.newInstance("灰灰")

    }

}