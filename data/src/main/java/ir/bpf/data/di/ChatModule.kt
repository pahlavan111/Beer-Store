package ir.bpf.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.bpf.data.datasource.ChatDataSource
import ir.bpf.data.datasource.local.ChatCachedDataSource
import ir.bpf.data.db.dao.MessageDao

@Module
@InstallIn(ViewModelComponent::class)
class ChatModule {

    @Provides
    fun provideChatCachedDataSource(messageDao: MessageDao) =
        ChatCachedDataSource(messageDao)

    @Provides
    fun provideChatDataSource(
        chatCachedDataSource: ChatCachedDataSource
    ) = ChatDataSource(chatCachedDataSource)

}