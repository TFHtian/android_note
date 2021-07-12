package com.android_note.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android_note.client.R
import kotlinx.android.synthetic.main.activity_custom_kotlin.*
import java.util.*

/**
 * @author fenghui
 * @date 2021/7/12.
 * @description kotlin基础
 */
class CustomKotlinActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_kotlin)
        initView()
    }

    private fun initView() {
        btn1.setOnClickListener {

        }
    }

    /**
     * kt数组：
     *  创建数组方式：
     *     1.arrayOf 函数创建一个数组，包含的元素是指定为该函数的实参
     *     2.arrayOfNulls 创建一个给定大小的数组，包含的元素均为 null，只能用来创建包含元素类型可空的数组
     *     3.调用 Array 类的构造方法，传递数组的大小和一个 lambda 表达式，调用 lambda 表达式来创建每一个数组元素
     *  创建可用lambda进行初始化元素
     */
    private fun array() {
        //创建即携带参数
        val arrayStr = arrayOf("1","2","3")
        //实参都是null，指定大小
        val arrayStrNUll = arrayOfNulls<String>(10)
        //创建从 “a” 到 “z” 的字符串数组（Array 构造方法创建）
        val array = Array(26) { i -> ('a' + i).toString() }

        //基本数据类型数组
        val intArray = IntArray(5)//指定大小
        //指定数组大小以及用于初始化每个元素的 lambda
        val doubleArray = DoubleArray(5) { Random().nextDouble() }
        //接收变长参数的值来创建存储这些值的数组
        val charArray = charArrayOf('H', 'e', 'l', 'l', 'o')
    }

    /**
     * kt函数：
     *     包含：1 命名参数  、2 默认参数 、3 可变参数 、4 局部函数
     */
    private fun function(){
        //命名参数  ->*在指定了一个参数的名称后，之后的所有参数都需要标明名称(命名参数，可以省略任何有默认值的参数，而且也可以按照任意顺序传入需要的参数)
        //即下面形式错误
        //compute1(index = 1,"2")
        compute1(index = 1,value = "2")
        compute1(1,value = "2")
        //默认参数
        compute2(2)
        compute2(2,"leavesB")
        //可变参数
        compute3("leavesC", "leavesB")
    }

    private fun compute1(index: Int, value: String) {

    }

    //默认参数 ：声明函数的时候指定参数的默认值，从而避免创建重载的函数
    private fun compute2(age: Int, name: String = "leavesC") {

    }

    //可变参数 ：改为通过使用 varage 关键字声明可变参数
    private fun compute3(vararg name: String) {

    }

    //局部参数：函数中嵌套函数，被嵌套的函数称为局部函数
    private fun compute4(name: String, country: String) {
        fun check(string: String) {
            if (string.isEmpty()) {
                throw IllegalArgumentException("参数错误")
            }
        }
        check(name)
        check(country)
    }

    /**
     * 循环与区间
     */
    private fun looper(){
        val list = listOf(1, 4, 10, 20)
        //方式1 in (取出元素)
        for (value in list){
            println("----1---$value")
        }
        //方式2 通过索引遍历
        for (index in list.indices){

        }
        //索引与值
        for ((index,value) in list.withIndex()){

        }
        //通过foreach
        list.forEach {
            println("----2---$it")
        }
        //自定义循环区间
        for (index in 2..5){

        }
        //倒序元素
        for (value in list.reversed()){

        }

        /**********------区间-----*********/
        var index = 5
        //三种方式 等价
        if (index >= 0 && index <= 10) {

        }
        if (index in 0..10){

        }
        if (index in 0.rangeTo(10)){

        }
        //ranges  迭代 默认为自增，要递减则：downTo
        for (index in 0..10){

        }
        for (index in 10.downTo(0)){

        }
        //使用步长step
        for (index in 1..8 step 2){
            println(index)
        }
        //开区间 使用until
        for (index in 0 until 4){

        }

    }

    /**
     * kt类：
     *      类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成，类头与类体都是可选的，如果一个类没有类体，可以省略花括号
     *      区分了主构造方法（在类体外部声明）和次构造方法（在类体内部声明），一个类可以有一个主构造函数和多个次构造函数，此外也允许在初始化代码块中 init 添加额外的初始化逻辑
     *
     * 分类：
     *  1.抽象类:  abstract 的类内部可以包含没有实现体的成员方法，且该成员方法也用 abstract 标记
     *  2.数据类：通常只提供了用于访问它们属性的简单的 getter 和 setter （data修饰）
     *  3.密封类：Sealed 类（密封类）用于对类可能创建的子类进行限制，用 Sealed 修饰的类的直接子类只允许被定义在 Sealed 类所在的文件中(View)
     *  4.枚举类：（Error）
     *  5.嵌套类：在类里面再定义的类默认是嵌套类，此时嵌套类不会包含对外部类的隐式引用
     *  6.内部类：如果需要去访问外部类的成员，需要用 inner 修饰符来标注被嵌套的类，这称为内部类。内部类会隐式持有对外部类的引用
     *  7.内联类：使用 inline 修饰的类就称为内联类，内联类必须含有唯一的一个属性在主构造函数中初始化，
     *                在运行时将使用这个唯一属性来表示内联类的实例，从而避免了包装类在运行时的额外开销
     *
     */
    private fun classKt(){
        //基础类
        Point(1,2)
    }

    /**
     * kt集合：分有只读集合与可变集合
     *
     */
    private fun list(){
        //创建只读类型集合 listOf setOf mapOf
        val list = listOf(10, 20, 30, 40)
        //创建可变类型集合 mutableListOf、arrayListOf  mutableSetOf、hashSetOf mutableMapOf、hashMapOf
        val mutableList = mutableListOf("1", "2", "3")
        val arrayList = arrayListOf<String>()
        val lists: List<String> = ArrayList()
        var pagerList = mutableListOf<String>()
    }

    /**
     * kt扩展函数：扩展函数用于为一个类增加一种新的行为，这是为缺少有用函数的类进行扩展的途径。
     *                  扩展函数的用途就类似于在 Java 中实现的静态工具方法
     */
    private fun extend(){
        val name = "leavesC"
        println("$name lastChar is: " + name.lastChar())

        val age = 24
        println("$age doubleValue is: " + age.doubleValue())
    }

    //为 String 类声明一个扩展函数 lastChar() ，用于返回字符串的最后一个字符
    //get方法是 String 类的内部方法，length 是 String 类的内部成员变量，在此处可以直接调用
    private fun String.lastChar() = get(length - 1)

    //为 Int 类声明一个扩展函数 doubleValue() ，用于返回其两倍值
    //this 关键字代表了 Int 值本身
    private fun Int.doubleValue() = this * 2

}