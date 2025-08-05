package ir.kidzyland.data.repository

import ir.kidzyland.domain.model.Message
import ir.kidzyland.domain.repository.IChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ChatRepository @Inject constructor() : IChatRepository {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())

    override fun sendMessage(content: String, sender: String) {
        val newMessage = Message(content = content, sender = sender)
        _messages.value = _messages.value + newMessage
    }

    override fun getMessages(): StateFlow<List<Message>> {
        return _messages.asStateFlow()
    }
}