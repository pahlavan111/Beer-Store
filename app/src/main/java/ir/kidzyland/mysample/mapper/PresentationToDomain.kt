package ir.kidzyland.mysample.mapper

import ir.kidzyland.domain.model.Message
import ir.kidzyland.mysample.models.MessageModel

fun MessageModel.toMessageModel(): Message {
    return Message(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}