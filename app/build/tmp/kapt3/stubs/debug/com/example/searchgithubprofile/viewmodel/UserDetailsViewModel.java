package com.example.searchgithubprofile.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.searchgithubprofile.model.repo.ProfileData;
import com.example.searchgithubprofile.repo.GithubRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/UserDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/searchgithubprofile/repo/GithubRepository;", "(Lcom/example/searchgithubprofile/repo/GithubRepository;)V", "_username", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "userDetails", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/searchgithubprofile/model/repo/ProfileData;", "getUserDetails", "()Lkotlinx/coroutines/flow/StateFlow;", "username", "getUsername", "setUsername", "", "newUsername", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class UserDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.searchgithubprofile.repo.GithubRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _username = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> username = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.searchgithubprofile.model.repo.ProfileData> userDetails = null;
    
    @javax.inject.Inject
    public UserDetailsViewModel(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.repo.GithubRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.searchgithubprofile.model.repo.ProfileData> getUserDetails() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull
    java.lang.String newUsername) {
    }
}