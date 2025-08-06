package ir.kidzyland.data.repository

import ir.kidzyland.data.datasource.ChatDataSource
import ir.kidzyland.data.model.MessageEntity
import ir.kidzyland.domain.model.Message
import ir.kidzyland.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val chatDataSource: ChatDataSource
) : IChatRepository {

    override suspend fun sendMessage(message: Message) {
        chatDataSource.sendMessage(message)
    }

    override fun getMessages(): Flow<List<Message>> {
        return chatDataSource.getMessages()
    }
}