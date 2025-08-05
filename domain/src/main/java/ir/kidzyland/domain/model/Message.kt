package ir.kidzyland.domain.model

data class Message(
    val id: Long = System.currentTimeMillis(),
    val content: String,
    val sender: String,
    val timestamp: Long = System.currentTimeMillis()
)