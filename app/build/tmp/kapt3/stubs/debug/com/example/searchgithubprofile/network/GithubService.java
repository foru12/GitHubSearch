package com.example.searchgithubprofile.network;

import com.example.searchgithubprofile.model.ProfileData;
import com.example.searchgithubprofile.model.SearchDataResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J/\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/searchgithubprofile/network/GithubService;", "", "getLanguages", "", "", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserDetails", "Lcom/example/searchgithubprofile/model/ProfileData;", "username", "searchRepositories", "Lcom/example/searchgithubprofile/model/SearchDataResponse;", "query", "page", "pageSize", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GithubService {
    
    @retrofit2.http.GET(value = "search/repositories")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchRepositories(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "per_page")
    int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.searchgithubprofile.model.SearchDataResponse> $completion);
    
    @retrofit2.http.GET(value = "users/{username}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserDetails(@retrofit2.http.Path(value = "username")
    @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.searchgithubprofile.model.ProfileData> $completion);
    
    @retrofit2.http.GET
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLanguages(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.Integer>> $completion);
}