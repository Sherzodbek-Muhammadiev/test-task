package uz.xsoft.taskapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.xsoft.taskapp.room.dao.ItemDao
import uz.xsoft.taskapp.room.dao.UserDao
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData
import java.util.*

@Database(entities = [UserData::class, ItemData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    withContext(Dispatchers.IO){
                        val calendar = Calendar.getInstance()
                        val userDao = database.userDao()
                        for (i in 1..100) {
                            val user = UserData(i.toLong(), "User $i", calendar.timeInMillis)
                            userDao.insert(user)
                        }
                        val itemDao = database.itemDao()
                        for (i in 1..100) {
                            val item = ItemData(i.toLong(), "User $i", calendar.timeInMillis)
                            itemDao.insert(item)
                        }
                        println("FINISH--------------")
                    }

                }
            }
        }
    }
}
