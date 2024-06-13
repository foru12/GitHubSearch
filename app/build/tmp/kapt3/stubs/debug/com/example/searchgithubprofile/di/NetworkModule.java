package com.example.searchgithubprofile.di;

import com.example.searchgithubprofile.network.GithubService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.ktor.client.*;
import io.ktor.client.engine.cio.*;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.plugins.logging.LogLevel;
import io.ktor.client.plugins.logging.Logger;
import io.ktor.client.request.*;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/searchgithubprofile/di/NetworkModule;", "", "()V", "BASE_URL", "", "provideGithubService", "Lcom/example/searchgithubprofile/network/GithubService;", "client", "Lio/ktor/client/HttpClient;", "provideHttpClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "https://api.github.com/";
    @org.jetbrains.annotations.NotNull
    public static final com.example.searchgithubprofile.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final io.ktor.client.HttpClient provideHttpClient() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.searchgithubprofile.network.GithubService provideGithubService(@org.jetbrains.annotations.NotNull
    io.ktor.client.HttpClient client) {
        return null;
    }
}