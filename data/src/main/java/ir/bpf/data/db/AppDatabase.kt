package ir.bpf.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.bpf.data.db.dao.MessageDao
import ir.bpf.data.model.entity.MessageEntity


@Database(entities = [MessageEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}