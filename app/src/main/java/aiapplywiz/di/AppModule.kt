package aiapplywiz.di

import android.content.Context
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import aiapplywiz.MainViewModel
import aiapplywiz.util.AD_ID
import aiapplywiz.util.PREFERENCE_NAME
import aiapplywiz.util.REFRESH_TIMEOUT
import aiapplywiz.util.RateLimiter
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import aiapplywiz.HomeViewModel
import aiapplywiz.api.ZZZGuidesService
import aiapplywiz.repository.HomeRepository
import aiapplywiz.ui.character.CharacterViewModel
import aiapplywiz.ui.characterdetail.CharacterDetailsViewModel
import aiapplywiz.ui.bangboos.BangbooViewModel
import aiapplywiz.ui.homedata.HomeDataViewModel
import aiapplywiz.ui.wengines.WEngineViewModel
import aiapplywiz.util.ZZZGuide_URL
import java.util.concurrent.TimeUnit

val appModule = module {

    factory {
        AdRequest.Builder().build()
    }

    single {
        AdLoader.Builder(androidContext(), AD_ID)
    }

    single {
        Retrofit.Builder()
            .baseUrl(ZZZGuide_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZZZGuidesService::class.java)
    }

//    single {
//        val db = get<NewsDatabase>()
//        db.videosDao()
//    }

    single {
        androidContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    single {
        RateLimiter<String>(REFRESH_TIMEOUT, TimeUnit.MINUTES)
    }

    single {
        HomeRepository(get())
    }

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        BangbooViewModel(get())
    }

    viewModel {
        CharacterDetailsViewModel(get())
    }

    viewModel {
        HomeDataViewModel(get())
    }

    viewModel {
        CharacterViewModel(get())
    }

    viewModel {
        WEngineViewModel(get())
    }

    viewModel {
        MainViewModel()
    }

}