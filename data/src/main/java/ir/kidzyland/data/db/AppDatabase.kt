package ir.kidzyland.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.kidzyland.data.db.dao.MessageDao
import ir.kidzyland.data.model.entity.MessageEntity

@Database(entities = [MessageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}