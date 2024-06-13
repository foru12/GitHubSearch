package com.example.searchgithubprofile.network;

import com.example.searchgithubprofile.model.file.FileItem;
import com.example.searchgithubprofile.model.repo.ProfileData;
import com.example.searchgithubprofile.model.repo.SearchDataRepoResponse;
import com.example.searchgithubprofile.model.users.SearchDataUsersResponse;
import io.ktor.client.*;
import io.ktor.client.request.*;
import io.ktor.client.statement.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J5\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J)\u0010$\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J)\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/example/searchgithubprofile/network/GithubService;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "json", "Lkotlinx/serialization/json/Json;", "fetch", "Lio/ktor/client/statement/HttpResponse;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdditionalFiles", "", "Lcom/example/searchgithubprofile/model/file/FileItem;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguages", "", "", "getRepositoryContents", "owner", "repo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserDetails", "Lcom/example/searchgithubprofile/model/repo/ProfileData;", "username", "searchInfo", "Lkotlin/Pair;", "Lcom/example/searchgithubprofile/model/repo/SearchDataRepoResponse;", "Lcom/example/searchgithubprofile/model/users/SearchDataUsersResponse;", "query", "page", "pageSize", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRepositories", "searchUsers", "app_debug"})
public final class GithubService {
    @org.jetbrains.annotations.NotNull
    private final io.ktor.client.HttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.serialization.json.Json json = null;
    
    public GithubService(@org.jetbrains.annotations.NotNull
    io.ktor.client.HttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetch(@org.jetbrains.annotations.NotNull
    io.ktor.client.request.HttpRequestBuilder request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object searchInfo(@org.jetbrains.annotations.NotNull
    java.lang.String query, int page, int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Pair<com.example.searchgithubprofile.model.repo.SearchDataRepoResponse, com.example.searchgithubprofile.model.users.SearchDataUsersResponse>> $completion) {
        return null;
    }
    
    private final java.lang.Object searchRepositories(java.lang.String query, int page, int pageSize, kotlin.coroutines.Continuation<? super com.example.searchgithubprofile.model.repo.SearchDataRepoResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object searchUsers(java.lang.String query, int page, int pageSize, kotlin.coroutines.Continuation<? super com.example.searchgithubprofile.model.users.SearchDataUsersResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserDetails(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.searchgithubprofile.model.repo.ProfileData> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRepositoryContents(@org.jetbrains.annotations.NotNull
    java.lang.String owner, @org.jetbrains.annotations.NotNull
    java.lang.String repo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.searchgithubprofile.model.file.FileItem>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLanguages(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.Integer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAdditionalFiles(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.searchgithubprofile.model.file.FileItem>> $completion) {
        return null;
    }
}