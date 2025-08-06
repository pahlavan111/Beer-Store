package ir.kidzyland.data.datasource

import ir.kidzyland.data.datasource.local.ChatCachedDataSource
import ir.kidzyland.domain.model.Message
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatDataSource @Inject constructor(
    private val chatCachedDataSource: ChatCachedDataSource
) : BaseDataSource() {

    fun sendMessage(content: String, sender: String) {
        chatCachedDataSource.sendMessage(content, sender)
    }

    fun getMessages(): StateFlow<List<Message>> {
        return chatCachedDataSource.getMessages()
    }
}