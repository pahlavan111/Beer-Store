package ir.kidzyland.data.datasource

import ir.kidzyland.data.datasource.local.ChatCachedDataSource
import ir.kidzyland.domain.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatDataSource @Inject constructor(
    private val chatCachedDataSource: ChatCachedDataSource
) : BaseDataSource() {

    suspend fun sendMessage(message: Message) {
        chatCachedDataSource.sendMessage(message)
    }

    fun getMessages(): Flow<List<Message>> {
        return chatCachedDataSource.getMessages()
    }
}