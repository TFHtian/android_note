package com.android_note.kotlin

/**
 * @author fenghui
 * @date 2021/7/12.
 * @description 密封类
 *
 */
sealed class View {

    fun click() {

    }

}


class Button : View() {

}

class TextView : View() {

}