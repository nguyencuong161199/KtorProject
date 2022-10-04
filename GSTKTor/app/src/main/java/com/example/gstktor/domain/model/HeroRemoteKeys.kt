package com.example.gstktor.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gstktor.util.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

// Cần triển khai dàn xếp từ xa nên sẽ cần sử dụng remote keys để phân trang dữ liệu 1 cách chính xác => có thể nhận thêm dữ liệu bất cứ khi nào cần
// => Lưu trữ dữ liệu nhân vật từ các API
@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long? = null
)
