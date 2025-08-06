package ir.kidzyland.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.kidzyland.data.datasource.ChatDataSource
import ir.kidzyland.data.datasource.local.ChatCachedDataSource

@Module
@InstallIn(ViewModelComponent::class)
class ChatModule {

    @Provides
    fun provideChatCachedDataSource() = ChatCachedDataSource()

    @Provides
    fun provideChatDataSource(
        chatCachedDataSource: ChatCachedDataSource
    ) = ChatDataSource(chatCachedDataSource)

}