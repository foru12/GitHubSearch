package com.example.searchgithubprofile.navigation;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0002\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/searchgithubprofile/navigation/BottomNavItem;", "", "title", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "route", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getRoute", "()Ljava/lang/String;", "getTitle", "About", "Search", "Lcom/example/searchgithubprofile/navigation/BottomNavItem$About;", "Lcom/example/searchgithubprofile/navigation/BottomNavItem$Search;", "app_debug"})
public abstract class BottomNavItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private BottomNavItem(java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/searchgithubprofile/navigation/BottomNavItem$About;", "Lcom/example/searchgithubprofile/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class About extends com.example.searchgithubprofile.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.example.searchgithubprofile.navigation.BottomNavItem.About INSTANCE = null;
        
        private About() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/searchgithubprofile/navigation/BottomNavItem$Search;", "Lcom/example/searchgithubprofile/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Search extends com.example.searchgithubprofile.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.example.searchgithubprofile.navigation.BottomNavItem.Search INSTANCE = null;
        
        private Search() {
        }
    }
}