package org.koin.sample.app.di

import android.util.Log
import androidx.activity.ComponentActivity
import org.koin.android.annotation.ActivityScope
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Scope

@Module
@Configuration
class ActivityModule {

    @ActivityScope
    fun activityTracker(activity: ComponentActivity): ActivityTracker =
        ActivityTracker(activity)
}

class ActivityTracker(private val activity: ComponentActivity) {
    fun trackScreen(name: String) {
        Log.d("ActivityTracker", "Screen viewed: $name in ${activity.localClassName}")
    }
}
