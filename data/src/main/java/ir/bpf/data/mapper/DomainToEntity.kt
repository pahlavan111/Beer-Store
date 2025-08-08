package ir.bpf.data.mapper

import ir.bpf.data.model.entity.MessageEntity
import ir.bpf.domain.model.Message

fun Message.toEntity(): MessageEntity {
    return MessageEntity(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp
    )
}