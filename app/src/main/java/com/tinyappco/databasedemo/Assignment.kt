package com.tinyappco.databasedemo

import java.io.Serializable
import java.util.*

class Assignment(var id: Int?, var title:String, var weight: Int, var deadline: Date, var module:Module) : Comparable<Assignment>, Serializable {

    override fun compareTo(other: Assignment): Int {
        return deadline.compareTo(other.deadline)
    }


    override fun toString(): String {
        return "${deadline.shortDate()} ${module.code}: $title ($weight%)"
    }
}