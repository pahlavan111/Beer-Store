package ir.bpf.domain.repository

import ir.bpf.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    suspend fun sendMessage(message: Message)
    fun getMessages(): Flow<List<Message>>
}