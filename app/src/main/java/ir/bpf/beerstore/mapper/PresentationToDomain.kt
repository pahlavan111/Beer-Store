package ir.bpf.beerstore.mapper

import ir.bpf.domain.model.Message
import ir.bpf.beerstore.models.MessageModel

fun MessageModel.toDomain(): Message {
    return Message(
        id = id,
        content = content,
        sender = sender,
        timestamp = timestamp,
    )
}