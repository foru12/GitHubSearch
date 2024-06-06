package com.example.searchgithubprofile.mainui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.searchgithubprofile.MyApp;
import com.example.searchgithubprofile.R;
import com.example.searchgithubprofile.model.RepositoryData;
import com.example.searchgithubprofile.navigation.BottomNavItem;
import com.example.searchgithubprofile.repo.GithubRepository;
import com.example.searchgithubprofile.viewmodel.SearchViewModel;
import com.example.searchgithubprofile.viewmodel.SwipeRefreshState;
import com.example.searchgithubprofile.viewmodel.UserDetailsViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a,\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a&\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0016H\u0007\u00a8\u0006\u0017"}, d2 = {"AboutScreen", "", "BottomNavigationBar", "navController", "Landroidx/navigation/NavHostController;", "MainScreen", "NavGraph", "modifier", "Landroidx/compose/ui/Modifier;", "RepositoryItem", "repository", "Lcom/example/searchgithubprofile/model/RepositoryData;", "onClick", "Lkotlin/Function1;", "", "viewModel", "Lcom/example/searchgithubprofile/viewmodel/SearchViewModel;", "SearchScreen", "navigateToUserDetails", "SwipeRefreshCompose", "UserDetailsScreen", "username", "Lcom/example/searchgithubprofile/viewmodel/UserDetailsViewModel;", "app_debug"})
public final class MainActivityKt {
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void MainScreen() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BottomNavigationBar(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NavGraph(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable
    public static final void SearchScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToUserDetails, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.SearchViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SwipeRefreshCompose() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AboutScreen() {
    }
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void UserDetailsScreen(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.UserDetailsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RepositoryItem(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.model.RepositoryData repository, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.SearchViewModel viewModel) {
    }
}