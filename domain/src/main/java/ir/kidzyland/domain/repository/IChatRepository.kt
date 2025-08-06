package ir.kidzyland.domain.repository

import ir.kidzyland.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    suspend fun sendMessage(message: Message)
    fun getMessages(): Flow<List<Message>>
}