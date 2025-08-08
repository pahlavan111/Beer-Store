package ir.bpf.data.mapper

import ir.bpf.data.model.entity.MessageEntity
import ir.bpf.domain.model.Message

fun MessageEntity.toDomain(): Message {
    return Message(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp
    )
}