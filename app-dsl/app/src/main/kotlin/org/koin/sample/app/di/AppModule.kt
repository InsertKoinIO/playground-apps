package org.koin.sample.app.di

import android.util.Log
import androidx.activity.ComponentActivity
import org.koin.androidx.scope.dsl.activityScope
import org.koin.dsl.module
import org.koin.plugin.module.dsl.factory
import org.koin.plugin.module.dsl.scoped
import org.koin.plugin.module.dsl.viewModel
import org.koin.sample.analytics.di.analyticsModule
import org.koin.sample.app.MainActivityViewModel
import org.koin.sample.common.di.dispatchersModule
import org.koin.sample.data.di.dataModule
import org.koin.sample.database.di.databaseModule
import org.koin.sample.datastore.di.dataStoreModule
import org.koin.sample.domain.GetFollowableTopicsUseCase
import org.koin.sample.domain.GetRecentSearchesUseCase
import org.koin.sample.domain.GetSearchContentsUseCase
import org.koin.sample.feature.bookmarks.BookmarksViewModel
import org.koin.sample.feature.detail.DetailViewModel
import org.koin.sample.feature.home.HomeViewModel
import org.koin.sample.feature.settings.SettingsViewModel
import org.koin.sample.network.di.networkModule
import org.koin.sample.notifications.di.notificationsModule
import org.koin.sample.sync.di.syncModule

val appModule = module {
    includes(
        dispatchersModule,
        databaseModule,
        dataStoreModule,
        networkModule,
        analyticsModule,
        notificationsModule,
        dataModule,
        syncModule
    )

    // Domain use cases
    factory<GetFollowableTopicsUseCase>()
    factory<GetRecentSearchesUseCase>()
    factory<GetSearchContentsUseCase>()

    viewModel<MainActivityViewModel>()

    // Feature ViewModels
    viewModel<HomeViewModel>()
    viewModel<BookmarksViewModel>()
    viewModel<DetailViewModel>()
    viewModel<SettingsViewModel>()

    activityScope {
        scoped<ActivityTracker>()
    }
}


class ActivityTracker(private val activity: ComponentActivity) {
    fun trackScreen(name: String) {
        Log.d("ActivityTracker", "Screen viewed: $name in ${activity.localClassName}")
    }
}