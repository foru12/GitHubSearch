package com.example.searchgithubprofile.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData;
import com.example.searchgithubprofile.model.RepositoryData;
import com.example.searchgithubprofile.repo.GithubRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR/\u0010\u0010\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/searchgithubprofile/repo/GithubRepository;", "(Lcom/example/searchgithubprofile/repo/GithubRepository;)V", "_isRefreshing", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_languagesMap", "", "", "", "_query", "isRefreshing", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "languagesMap", "getLanguagesMap", "searchResults", "Landroidx/paging/PagingData;", "Lcom/example/searchgithubprofile/model/RepositoryData;", "getSearchResults", "setSearchResults", "(Lkotlinx/coroutines/flow/StateFlow;)V", "fetchLanguages", "", "repositoryId", "languagesUrl", "onQueryChanged", "newQuery", "refresh", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.searchgithubprofile.repo.GithubRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _query = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> _languagesMap = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> languagesMap = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.RepositoryData>> searchResults;
    
    @javax.inject.Inject
    public SearchViewModel(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.repo.GithubRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>>> getLanguagesMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.RepositoryData>> getSearchResults() {
        return null;
    }
    
    public final void setSearchResults(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.searchgithubprofile.model.RepositoryData>> p0) {
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