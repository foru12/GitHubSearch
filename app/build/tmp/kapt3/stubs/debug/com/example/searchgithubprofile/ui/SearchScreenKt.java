package com.example.searchgithubprofile.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.TextFieldValue;
import com.example.searchgithubprofile.model.SearchItem;
import com.example.searchgithubprofile.model.repo.RepositoryData;
import com.example.searchgithubprofile.model.users.UserData;
import com.example.searchgithubprofile.viewmodel.SearchViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"SearchScreen", "", "handleUserClick", "Lkotlin/Function1;", "Lcom/example/searchgithubprofile/model/SearchItem$User;", "handleRepositoryClick", "Lcom/example/searchgithubprofile/model/SearchItem$Repository;", "viewModel", "Lcom/example/searchgithubprofile/viewmodel/SearchViewModel;", "app_debug"})
public final class SearchScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable
    public static final void SearchScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.searchgithubprofile.model.SearchItem.User, kotlin.Unit> handleUserClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.searchgithubprofile.model.SearchItem.Repository, kotlin.Unit> handleRepositoryClick, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.SearchViewModel viewModel) {
    }
}