package ir.kidzyland.mysample.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.kidzyland.domain.usecase.ChatUseCase
import ir.kidzyland.mysample.mapper.toMessageModel
import ir.kidzyland.mysample.models.MessageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatUseCase: ChatUseCase
) : ViewModel() {
    private val _messages = MutableStateFlow<List<MessageModel>>(emptyList())
    val messages: StateFlow<List<MessageModel>> = _messages.asStateFlow()

    val messageInput = mutableStateOf("")

    init {
        getMessages()
    }


    fun sendMessage() {
        if (messageInput.value.isNotBlank()) {
            chatUseCase.sendMessage(messageInput.value, sender = "User")
            messageInput.value = ""
        }
    }

    private fun getMessages() {
        viewModelScope.launch {
            chatUseCase.getMessages().collect { messageList ->
                _messages.value = messageList.map { it.toMessageModel() }
            }
        }
    }
}
