package ir.kidzyland.data.mapper

import ir.kidzyland.data.model.entity.MessageEntity
import ir.kidzyland.domain.model.Message

fun MessageEntity.toDomain(): Message {
    return Message(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp
    )
}