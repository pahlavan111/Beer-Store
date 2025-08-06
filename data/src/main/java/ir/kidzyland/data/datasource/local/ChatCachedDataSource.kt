package ir.kidzyland.data.datasource.local

import ir.kidzyland.data.datasource.BaseDataSource
import ir.kidzyland.domain.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ChatCachedDataSource @Inject constructor() : BaseDataSource() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())

    fun sendMessage(content: String, sender: String) {
        val newMessage = Message(content = content, sender = sender)
        _messages.value = _messages.value + newMessage
    }

    fun getMessages(): StateFlow<List<Message>> {
        return _messages.asStateFlow()
    }
}