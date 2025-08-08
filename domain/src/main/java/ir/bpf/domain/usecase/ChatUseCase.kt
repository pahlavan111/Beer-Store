package ir.bpf.domain.usecase

import ir.bpf.domain.model.Message
import ir.bpf.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatUseCase @Inject constructor(
    private val iChatRepository: IChatRepository
) {
    suspend fun sendMessage(message: Message) =
        iChatRepository.sendMessage(message)

    fun getMessages(): Flow<List<Message>> = iChatRepository.getMessages()
}