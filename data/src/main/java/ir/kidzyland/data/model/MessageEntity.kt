package ir.kidzyland.data.model

data class MessageEntity(
    val id: Long = System.currentTimeMillis(),
    val content: String,
    val sender: String,
    val timestamp: Long = System.currentTimeMillis()
)