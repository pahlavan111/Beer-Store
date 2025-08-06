package ir.kidzyland.domain.model

data class Message(
    val id: Int?,
    val content: String,
    val sender: String,
    val timestamp: Long
)