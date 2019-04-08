package com.example.stackapplication.logic

class Stack <T> {
    class Node<T>(val data: T, var prev: Node<T>?)

    var last: Node<T>? = null

    fun push(t: T) {
        last = Node(t, last)
    }

    fun pop(): T? {
        if(last != null) {
            val result = last!!.data
            last = last!!.prev
            return result
        }
        return null
    }

    fun top(): T? = if(last != null) last!!.data else null

    override fun toString(): String {
        val builder = StringBuilder()
        var node = last
        if (node != null){
            builder.append(node.data.toString())
            node = node.prev
        }
        while (node !=null){
            builder.append(" -> ")
            builder.append(node.data.toString())
            node = node.prev
        }
        return builder.toString()
    }
}