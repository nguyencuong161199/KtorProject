package com.example.gstktor.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","

    // Convert list data thành 1 chuỗi data
    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(separator)
        }
        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    // Tách chuỗi data thành các đoạn
    @TypeConverter
    fun convertStringToList(string: String): List<String> = string.split(separator)
}
