package ir.kidzyland.domain.usecase

import ir.kidzyland.domain.model.Message
import ir.kidzyland.domain.repository.IChatRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ChatUseCase @Inject constructor(
    private val iChatRepository: IChatRepository
) {
    fun sendMessage(content: String, sender: String) =
        iChatRepository.sendMessage(content, sender)

    fun getMessages(): StateFlow<List<Message>> =   iChatRepository.getMessages()
}