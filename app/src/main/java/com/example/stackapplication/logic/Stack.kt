package com.example.stackapplication.logic

class Stack<T>(private var initialCapacity: Int = 10) {
    private var array: Array<T?>? = null
    private var capacity = 0
    private var size = 0

    fun push(t: T) {
        if(array == null){
            if(initialCapacity < 0)
                initialCapacity = 17
            capacity = initialCapacity
            array = arrayOfNulls<Any>(capacity) as Array<T?>
        } else if (size == capacity){
            capacity = (capacity * 1.5).toInt()
            array = array!!.copyOf(capacity)
        }
        array!![size++] = t
    }

    fun pop() = if( size == 0) null else array!![size-- - 1]

    fun top() = if( size == 0) null else array!![size - 1]

    override fun toString(): String {
        val builder = StringBuilder()
        var i = size - 1
        if (size >= 1){
            builder.append(array!![i--])
        }
        while (i >= 0){
            builder.append(" -> ")
            builder.append(array!![i--])
        }
        return builder.toString()
    }
}