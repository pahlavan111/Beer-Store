package ir.bpf.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val content: String,
    val sender: String,
    val timestamp: Long
)