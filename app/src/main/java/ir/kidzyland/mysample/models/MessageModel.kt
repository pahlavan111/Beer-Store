package ir.kidzyland.mysample.models

data class MessageModel(
    val id: Long,
    val content: String,
    val sender: String,
    val timestamp: Long
)
