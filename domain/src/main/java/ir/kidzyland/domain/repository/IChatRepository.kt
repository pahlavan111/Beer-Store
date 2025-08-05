package ir.kidzyland.domain.repository

import ir.kidzyland.domain.model.Message
import kotlinx.coroutines.flow.StateFlow

interface IChatRepository {
    fun sendMessage(content: String, sender: String)
    fun getMessages(): StateFlow<List<Message>>
}