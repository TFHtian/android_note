package com.android_note.kotlin

/**
 * @author fenghui
 * @date 2021/7/12.
 * @description 枚举类
 */
enum class Error(private val code: Int, private val err: String) {

    UNKNOWN(1000, "请求失败，请稍后再试");

    fun getValue(): String {
        return err
    }

    fun getKey(): Int {
        return code
    }

}