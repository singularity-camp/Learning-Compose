package kz.singularity.data.di

import androidx.room.Room
import kz.singularity.data.db.room.AppRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomDatabaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppRoomDatabase::class.java, name = ROOM_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    factory {
        val appRoomDatabase: AppRoomDatabase = get()
        appRoomDatabase.postDao()
    }

    factory {
        val appRoomDatabase: AppRoomDatabase = get()
        appRoomDatabase.commentDao()
    }
    factory {
        val appRoomDatabase: AppRoomDatabase = get()
        appRoomDatabase.userDao()
    }

    factory {
        val appRoomDatabase: AppRoomDatabase = get()
        appRoomDatabase.albumDao()
    }
}

private const val ROOM_DB_NAME = "AppRoomDatabase"