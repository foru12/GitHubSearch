package com.example.searchgithubprofile.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.compose.runtime.Composable;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/NetworkUtils;", "", "()V", "isOnline", "", "context", "Landroid/content/Context;", "app_debug"})
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.searchgithubprofile.viewmodel.NetworkUtils INSTANCE = null;
    
    private NetworkUtils() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final boolean isOnline(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
}