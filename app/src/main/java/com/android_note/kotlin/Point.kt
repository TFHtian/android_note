package com.android_note.kotlin

/**
 * 类基础：类名，类头 类体
 *  1：constructor(val x: Int, val y: Int) {} constructor与{}可省略 参数可以是只读val 与可变var
 *      主构造函数是类头的一部分，跟在类名（和可选的类型参数）后，主构造函数的参数可以是可变的（var）或只读的（val）
 *      如果构造函数有注解或可见性修饰符，则 constructor 关键字是必需的，并且这些修饰符在它前面
 *
 *  2：主构造函数不能包含任何的代码，初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中，
 *      初始化块包含了在类被创建时执行的代码，主构造函数的参数可以在初始化块中使用
 *      造函数的参数如果用 val/var 进行修饰，则相当于在类内部声明了一个同名的全局属性。
 *      如果不加 val/var 进行修饰，则构造函数只能在 init 函数块和全局属性初始化时进行引用
 *      主构造函数的参数也可以在类体内声明的属性初始化器中使用
 *
 *  3：次构造函数：声明包含前缀 constructor 的次构造函数。如果类有一个主构造函数，
 *      每个次构造函数都需要直接委托给主构造函数或者委托给另一个次构造函数以此进行间接委托，用 this 关键字来进行指定即可
 *
 *  4：所有初始化块中的代码都会在次构造函数体之前执行
 *
 */
class Point constructor(val x: Int, val y: Int) {

    private val localX = x + 1
    private val localY = y + 1

    init {
        println("initializer----, x value is: $x , y value is: $y")
        println("initializer----, localX value is: $localX , localY value is: $localY")
    }

    constructor(base: Int) : this(base + 1, base + 1) {
        println("constructor(base: Int)")
    }

    constructor(base: Long) : this(base.toInt()) {
        println("constructor(base: Long)")
    }

}