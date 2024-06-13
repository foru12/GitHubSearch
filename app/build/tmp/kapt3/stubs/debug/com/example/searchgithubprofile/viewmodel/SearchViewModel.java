package com.example.searchgithubprofile.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData;
import com.example.searchgithubprofile.model.SearchItem;
import com.example.searchgithubprofile.model.repo.RepositoryData;
import com.example.searchgithubprofile.repo.GithubRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.ktor.util.network.UnresolvedAddressException;
import io.ktor.utils.io.errors.IOException;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0014\u0010 \u001a\u00020\u001d2\n\u0010!\u001a\u00060\"j\u0002`#H\u0002J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u001dR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R/\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f0\f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/searchgithubprofile/repo/GithubRepository;", "(Lcom/example/searchgithubprofile/repo/GithubRepository;)V", "_errorMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isLoading", "", "_isRefreshing", "_languagesMap", "", "", "_newSearchResults", "Landroidx/paging/PagingData;", "Lcom/example/searchgithubprofile/model/SearchItem;", "_query", "errorMessage", "Lkotlinx/coroutines/flow/StateFlow;", "getErrorMessage", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "isRefreshing", "languagesMap", "getLanguagesMap", "newSearchResults", "getNewSearchResults", "fetchLanguages", "", "repositoryId", "languagesUrl", "handleRefreshError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onQueryChanged", "newQuery", "refresh", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.searchgithubprofile.repo.GithubRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _query = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> _languagesMap = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.SearchItem>> _newSearchResults = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> languagesMap = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.SearchItem>> newSearchResults = null;
    
    @javax.inject.Inject
    public SearchViewModel(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.repo.GithubRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> getLanguagesMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.SearchItem>> getNewSearchResults() {
        return null;
    }
    
    private final void handleRefreshError(java.lang.Exception exception) {
    }
    
    public final void refresh() {
    }
    
    public final void fetchLanguages(@org.jetbrains.annotations.NotNull
    java.lang.String repositoryId, @org.jetbrains.annotations.NotNull
    java.lang.String languagesUrl) {
    }
    
    public final void onQueryChanged(@org.jetbrains.annotations.NotNull
    java.lang.String newQuery) {
    }
}