package ir.bpf.beerstore.models

data class MessageModel(
    val id: Int? = null,
    val content: String,
    val sender: String,
    val timestamp: Long = System.currentTimeMillis()
)
