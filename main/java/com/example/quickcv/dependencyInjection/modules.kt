package com.example.quickcv.dependencyInjection

import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.quickcv.data.ktor.RemoteApi
//import com.example.quickcv.data.ktor.RemoteApi
import com.example.quickcv.data.localRepository.LocalRepository
//import com.example.quickcv.data.localRepository.LocalRepositoryPrimary
import com.example.quickcv.data.rooms.AppDatabase
import com.example.quickcv.data.rooms.PrimaryCardEntity
import com.example.quickcv.data.rooms.ResumeDoa
import com.example.quickcv.ui.Main.home.homeviewmodel
import com.example.quickcv.ui.Main.search.searchviewmodel
import com.example.quickcv.ui.cvform.cvfromviewmodel
import com.example.quickcv.ui.splash.splashviewmodel
import com.example.quickcv.ui.welcome.welcomeviewmodel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module





val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(

            """
                CREATE TABLE IF NOT EXISTS PrimaryCardEntity(
                                      id INTEGER PRIMARY KEY AUTOINCREMENT ,
                                      code TEXT,
                                      views TEXT ,
                                      jobtitle TEXT)
                                      """
        )

    }
}
val appmodules = module {
    viewModel { splashviewmodel() }
    viewModel { welcomeviewmodel() }

    single {
        Room.databaseBuilder(androidContext(),
            AppDatabase::class.java,
            "ResumeTable")
            .addMigrations(                MIGRATION_1_2            )
            .build()
    }
    single{get<AppDatabase>().resumedoa()}
   single{get<AppDatabase>().primarydoa()}
    single { LocalRepository(get()) }
//    single{ LocalRepositoryPrimary(get()) }
    viewModel { cvfromviewmodel(get()) }


    single{
    }

//    single{ RemoteApi() }
    viewModel { searchviewmodel() }
    viewModel { homeviewmodel(get(),get()) }

}

