package com.example.searchgithubprofile.ui;

import android.util.Log;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.example.searchgithubprofile.model.file.FileItem;
import com.example.searchgithubprofile.viewmodel.RepositoryDetailsViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a6\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0007\u00a8\u0006\u0012"}, d2 = {"FileList", "", "files", "", "Lcom/example/searchgithubprofile/model/file/FileItem;", "viewModel", "Lcom/example/searchgithubprofile/viewmodel/RepositoryDetailsViewModel;", "navigateToWebView", "Lkotlin/Function1;", "", "FileListItem", "file", "RepositoryDetailsScreen", "owner", "repository", "getFileIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "type", "app_debug"})
public final class RepositoryDetailsScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void FileListItem(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.model.file.FileItem file, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.RepositoryDetailsViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToWebView) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RepositoryDetailsScreen(@org.jetbrains.annotations.NotNull
    java.lang.String owner, @org.jetbrains.annotations.NotNull
    java.lang.String repository, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToWebView, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.RepositoryDetailsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FileList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.searchgithubprofile.model.file.FileItem> files, @org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.viewmodel.RepositoryDetailsViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navigateToWebView) {
    }
    
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.graphics.vector.ImageVector getFileIcon(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
}