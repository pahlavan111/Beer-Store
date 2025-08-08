package ir.bpf.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.bpf.data.db.AppDatabase
import ir.bpf.data.db.dao.MessageDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val dbName = "bpf.db"

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            dbName
        ).build()
    }

    @Provides
    fun provideMessageDao(database: AppDatabase): MessageDao {
        return database.messageDao()
    }
}