package ir.kidzyland.data.repository

import ir.kidzyland.data.datasource.ChatDataSource
import ir.kidzyland.domain.model.Message
import ir.kidzyland.domain.repository.IChatRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val chatDataSource: ChatDataSource
) : IChatRepository {

    override fun sendMessage(content: String, sender: String) {
        chatDataSource.sendMessage(content, sender)
    }

    override fun getMessages(): StateFlow<List<Message>> {
        return chatDataSource.getMessages()
    }
}