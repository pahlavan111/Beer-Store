package ir.bpf.data.datasource.local

import ir.bpf.data.db.dao.MessageDao
import ir.bpf.data.mapper.toDomain
import ir.bpf.data.mapper.toEntity
import ir.bpf.domain.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChatCachedDataSource @Inject constructor(
    private val messageDao: MessageDao
) {

    fun getMessages(): Flow<List<Message>> {
        return messageDao.getAllMessages().map { messageList ->
            messageList.map { messageEntity ->
                messageEntity.toDomain()
            }
        }
    }

    suspend fun sendMessage(message: Message) {
        messageDao.insertMessage(message.toEntity())
    }
}