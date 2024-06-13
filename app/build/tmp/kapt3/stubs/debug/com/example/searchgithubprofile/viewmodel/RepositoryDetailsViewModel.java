package com.example.searchgithubprofile.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.searchgithubprofile.model.file.FileItem;
import com.example.searchgithubprofile.repo.GithubRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\t0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/RepositoryDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/searchgithubprofile/repo/GithubRepository;", "(Lcom/example/searchgithubprofile/repo/GithubRepository;)V", "TAG", "", "_expandedFiles", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lcom/example/searchgithubprofile/model/file/FileItem;", "_files", "_loadingStates", "", "expandedFiles", "Lkotlinx/coroutines/flow/StateFlow;", "getExpandedFiles", "()Lkotlinx/coroutines/flow/StateFlow;", "files", "getFiles", "loadingStates", "getLoadingStates", "loadAdditionalFiles", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRepositoryContents", "", "owner", "repo", "toggleExpanded", "file", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class RepositoryDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.searchgithubprofile.repo.GithubRepository githubRepository = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "RepositoryDetailsViewModel";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.searchgithubprofile.model.file.FileItem>> _files = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.util.List<com.example.searchgithubprofile.model.file.FileItem>>> _expandedFiles = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.Boolean>> _loadingStates = null;
    
    @javax.inject.Inject
    public RepositoryDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.repo.GithubRepository githubRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.searchgithubprofile.model.file.FileItem>> getFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.List<com.example.searchgithubprofile.model.file.FileItem>>> getExpandedFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Boolean>> getLoadingStates() {
        return null;
    }
    
    public final void loadRepositoryContents(@org.jetbrains.annotations.NotNull
    java.lang.String owner, @org.jetbrains.annotations.NotNull
    java.lang.String repo) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loadAdditionalFiles(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.searchgithubprofile.model.file.FileItem>> $completion) {
        return null;
    }
    
    public final void toggleExpanded(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.model.file.FileItem file) {
    }
}