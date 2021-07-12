package com.android_note.kotlin

/**
 * @author fenghui
 * @date 2021/7/12.
 * @description (伴生对象生成单例)
 */
class User{

    companion object {

        @JvmStatic
        fun newInstance(name: String){
            println(name)
        }
    }

}