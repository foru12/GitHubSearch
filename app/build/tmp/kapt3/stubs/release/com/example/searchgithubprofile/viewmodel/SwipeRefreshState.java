package com.example.searchgithubprofile.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/searchgithubprofile/viewmodel/SwipeRefreshState;", "", "isRefreshing", "", "(Z)V", "_isRefreshing", "Landroidx/compose/runtime/MutableState;", "_refreshListeners", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function0;", "", "()Landroidx/compose/runtime/MutableState;", "refreshListeners", "", "getRefreshListeners", "()Ljava/util/List;", "addRefreshListener", "listener", "clearRefreshListeners", "isRefreshingChanged", "newValue", "removeRefreshListener", "app_release"})
public final class SwipeRefreshState {
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.snapshots.SnapshotStateList<kotlin.jvm.functions.Function0<kotlin.Unit>> _refreshListeners = null;
    
    public SwipeRefreshState(boolean isRefreshing) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>> getRefreshListeners() {
        return null;
    }
    
    public final void isRefreshingChanged(boolean newValue) {
    }
    
    public final void addRefreshListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    public final void removeRefreshListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> listener) {
    }
    
    public final void clearRefreshListeners() {
    }
    
    public SwipeRefreshState() {
        super();
    }
}