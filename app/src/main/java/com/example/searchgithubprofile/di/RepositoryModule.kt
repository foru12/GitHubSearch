package com.example.searchgithubprofile.di

import com.example.searchgithubprofile.network.GithubService
import com.example.searchgithubprofile.repo.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubRepository(service: GithubService): GithubRepository {
        return GithubRepository(service)
    }
}