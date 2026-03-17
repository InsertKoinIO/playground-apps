package org.koin.sample.app.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinViewModel
import org.koin.core.annotation.Module
import org.koin.sample.app.MainActivityViewModel
import org.koin.sample.data.repository.UserDataRepository

@Module(includes = [FeaturesModule::class, DomainModule::class])
@Configuration
@ComponentScan("org.koin.sample.app")
class AppModule {

    @KoinViewModel
    fun mainActivityViewModel(userDataRepository: UserDataRepository) =
        MainActivityViewModel(userDataRepository)
}
