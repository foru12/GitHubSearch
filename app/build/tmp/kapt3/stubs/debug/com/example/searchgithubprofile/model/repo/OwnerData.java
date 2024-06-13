package com.example.searchgithubprofile.model.repo;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 {2\u00020\u0001:\u0002z{B\u00f1\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001aB\u00dd\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010[\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003\u00a2\u0006\u0002\u0010KJ\u0010\u0010e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00e6\u0001\u0010m\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0002\u0010nJ\u0013\u0010o\u001a\u00020\u00172\b\u0010p\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010q\u001a\u00020\u0003H\u00d6\u0001J\t\u0010r\u001a\u00020\u0005H\u00d6\u0001J!\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u00c7\u0001R&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R&\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b\'\u0010!R&\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R&\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R&\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R(\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u00109\u0012\u0004\b4\u0010\u001d\u001a\u0004\b5\u00106\"\u0004\b7\u00108R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R&\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R&\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!R&\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010!R(\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0002\u0010N\u0012\u0004\bI\u0010\u001d\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR&\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bO\u0010\u001d\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!R&\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bR\u0010\u001d\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010!R&\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bU\u0010\u001d\u001a\u0004\bV\u0010\u001f\"\u0004\bW\u0010!R&\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bX\u0010\u001d\u001a\u0004\bY\u0010\u001f\"\u0004\bZ\u0010!\u00a8\u0006|"}, d2 = {"Lcom/example/searchgithubprofile/model/repo/OwnerData;", "", "seen1", "", "login", "", "id", "nodeId", "avatarUrl", "gravatarId", "url", "htmlUrl", "followersUrl", "followingUrl", "gistsUrl", "starredUrl", "subscriptionsUrl", "organizationsUrl", "reposUrl", "eventsUrl", "receivedEventsUrl", "type", "siteAdmin", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAvatarUrl$annotations", "()V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getEventsUrl$annotations", "getEventsUrl", "setEventsUrl", "getFollowersUrl$annotations", "getFollowersUrl", "setFollowersUrl", "getFollowingUrl$annotations", "getFollowingUrl", "setFollowingUrl", "getGistsUrl$annotations", "getGistsUrl", "setGistsUrl", "getGravatarId$annotations", "getGravatarId", "setGravatarId", "getHtmlUrl$annotations", "getHtmlUrl", "setHtmlUrl", "getId$annotations", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLogin$annotations", "getLogin", "setLogin", "getNodeId$annotations", "getNodeId", "setNodeId", "getOrganizationsUrl$annotations", "getOrganizationsUrl", "setOrganizationsUrl", "getReceivedEventsUrl$annotations", "getReceivedEventsUrl", "setReceivedEventsUrl", "getReposUrl$annotations", "getReposUrl", "setReposUrl", "getSiteAdmin$annotations", "getSiteAdmin", "()Ljava/lang/Boolean;", "setSiteAdmin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStarredUrl$annotations", "getStarredUrl", "setStarredUrl", "getSubscriptionsUrl$annotations", "getSubscriptionsUrl", "setSubscriptionsUrl", "getType$annotations", "getType", "setType", "getUrl$annotations", "getUrl", "setUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/example/searchgithubprofile/model/repo/OwnerData;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "app_debug"})
public final class OwnerData {
    @org.jetbrains.annotations.Nullable
    private java.lang.String login;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nodeId;
    @org.jetbrains.annotations.Nullable
    private java.lang.String avatarUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String gravatarId;
    @org.jetbrains.annotations.Nullable
    private java.lang.String url;
    @org.jetbrains.annotations.Nullable
    private java.lang.String htmlUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String followersUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String followingUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String gistsUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String starredUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String subscriptionsUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String organizationsUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String reposUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String eventsUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String receivedEventsUrl;
    @org.jetbrains.annotations.Nullable
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean siteAdmin;
    @org.jetbrains.annotations.NotNull
    public static final com.example.searchgithubprofile.model.repo.OwnerData.Companion Companion = null;
    
    public OwnerData(@org.jetbrains.annotations.Nullable
    java.lang.String login, @org.jetbrains.annotations.Nullable
    java.lang.Integer id, @org.jetbrains.annotations.Nullable
    java.lang.String nodeId, @org.jetbrains.annotations.Nullable
    java.lang.String avatarUrl, @org.jetbrains.annotations.Nullable
    java.lang.String gravatarId, @org.jetbrains.annotations.Nullable
    java.lang.String url, @org.jetbrains.annotations.Nullable
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable
    java.lang.String followersUrl, @org.jetbrains.annotations.Nullable
    java.lang.String followingUrl, @org.jetbrains.annotations.Nullable
    java.lang.String gistsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String starredUrl, @org.jetbrains.annotations.Nullable
    java.lang.String subscriptionsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String organizationsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String reposUrl, @org.jetbrains.annotations.Nullable
    java.lang.String eventsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String receivedEventsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.Boolean siteAdmin) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLogin() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "login")
    @java.lang.Deprecated
    public static void getLogin$annotations() {
    }
    
    public final void setLogin(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getId() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "id")
    @java.lang.Deprecated
    public static void getId$annotations() {
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNodeId() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "node_id")
    @java.lang.Deprecated
    public static void getNodeId$annotations() {
    }
    
    public final void setNodeId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAvatarUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "avatar_url")
    @java.lang.Deprecated
    public static void getAvatarUrl$annotations() {
    }
    
    public final void setAvatarUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGravatarId() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "gravatar_id")
    @java.lang.Deprecated
    public static void getGravatarId$annotations() {
    }
    
    public final void setGravatarId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "url")
    @java.lang.Deprecated
    public static void getUrl$annotations() {
    }
    
    public final void setUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getHtmlUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "html_url")
    @java.lang.Deprecated
    public static void getHtmlUrl$annotations() {
    }
    
    public final void setHtmlUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFollowersUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "followers_url")
    @java.lang.Deprecated
    public static void getFollowersUrl$annotations() {
    }
    
    public final void setFollowersUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFollowingUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "following_url")
    @java.lang.Deprecated
    public static void getFollowingUrl$annotations() {
    }
    
    public final void setFollowingUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGistsUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "gists_url")
    @java.lang.Deprecated
    public static void getGistsUrl$annotations() {
    }
    
    public final void setGistsUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStarredUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "starred_url")
    @java.lang.Deprecated
    public static void getStarredUrl$annotations() {
    }
    
    public final void setStarredUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSubscriptionsUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "subscriptions_url")
    @java.lang.Deprecated
    public static void getSubscriptionsUrl$annotations() {
    }
    
    public final void setSubscriptionsUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOrganizationsUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "organizations_url")
    @java.lang.Deprecated
    public static void getOrganizationsUrl$annotations() {
    }
    
    public final void setOrganizationsUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReposUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "repos_url")
    @java.lang.Deprecated
    public static void getReposUrl$annotations() {
    }
    
    public final void setReposUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEventsUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "events_url")
    @java.lang.Deprecated
    public static void getEventsUrl$annotations() {
    }
    
    public final void setEventsUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReceivedEventsUrl() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "received_events_url")
    @java.lang.Deprecated
    public static void getReceivedEventsUrl$annotations() {
    }
    
    public final void setReceivedEventsUrl(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "type")
    @java.lang.Deprecated
    public static void getType$annotations() {
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getSiteAdmin() {
        return null;
    }
    
    @kotlinx.serialization.SerialName(value = "site_admin")
    @java.lang.Deprecated
    public static void getSiteAdmin$annotations() {
    }
    
    public final void setSiteAdmin(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    public OwnerData() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.searchgithubprofile.model.repo.OwnerData copy(@org.jetbrains.annotations.Nullable
    java.lang.String login, @org.jetbrains.annotations.Nullable
    java.lang.Integer id, @org.jetbrains.annotations.Nullable
    java.lang.String nodeId, @org.jetbrains.annotations.Nullable
    java.lang.String avatarUrl, @org.jetbrains.annotations.Nullable
    java.lang.String gravatarId, @org.jetbrains.annotations.Nullable
    java.lang.String url, @org.jetbrains.annotations.Nullable
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable
    java.lang.String followersUrl, @org.jetbrains.annotations.Nullable
    java.lang.String followingUrl, @org.jetbrains.annotations.Nullable
    java.lang.String gistsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String starredUrl, @org.jetbrains.annotations.Nullable
    java.lang.String subscriptionsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String organizationsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String reposUrl, @org.jetbrains.annotations.Nullable
    java.lang.String eventsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String receivedEventsUrl, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.Boolean siteAdmin) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void write$Self(@org.jetbrains.annotations.NotNull
    com.example.searchgithubprofile.model.repo.OwnerData self, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"com/example/searchgithubprofile/model/repo/OwnerData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/example/searchgithubprofile/model/repo/OwnerData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<com.example.searchgithubprofile.model.repo.OwnerData> {
        @org.jetbrains.annotations.NotNull
        public static final com.example.searchgithubprofile.model.repo.OwnerData.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.example.searchgithubprofile.model.repo.OwnerData deserialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override
        public void serialize(@org.jetbrains.annotations.NotNull
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull
        com.example.searchgithubprofile.model.repo.OwnerData value) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/example/searchgithubprofile/model/repo/OwnerData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/example/searchgithubprofile/model/repo/OwnerData;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.example.searchgithubprofile.model.repo.OwnerData> serializer() {
            return null;
        }
    }
}