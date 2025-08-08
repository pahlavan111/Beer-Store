package ir.bpf.beerstore.mapper

import ir.bpf.domain.model.Message
import ir.bpf.beerstore.models.MessageModel

fun Message.toMessageModel(): MessageModel {
    return MessageModel(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}