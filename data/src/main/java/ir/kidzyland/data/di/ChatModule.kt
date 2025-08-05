package ir.kidzyland.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ChatModule {

//    @Provides
//    fun provideMessageDataSource(
//        messageApiService: MessageApiService
//    ) = MessageDataSource(messageApiService)

}