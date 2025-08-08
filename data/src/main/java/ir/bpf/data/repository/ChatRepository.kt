package ir.bpf.data.repository

import ir.bpf.data.datasource.ChatDataSource
import ir.bpf.domain.model.Message
import ir.bpf.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
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