package ir.kidzyland.mysample.mapper

import ir.kidzyland.domain.model.Message
import ir.kidzyland.mysample.models.MessageModel

fun Message.toMessageModel(): MessageModel {
    return MessageModel(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}