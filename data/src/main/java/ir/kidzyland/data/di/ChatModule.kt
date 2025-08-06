package ir.kidzyland.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.kidzyland.data.datasource.ChatDataSource
import ir.kidzyland.data.datasource.local.ChatCachedDataSource
import ir.kidzyland.data.db.dao.MessageDao

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