package com.habittracker.app.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJI\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/habittracker/app/network/UnsplashApiService;", "", "getRandomPhoto", "Lretrofit2/Response;", "Lcom/habittracker/app/network/UnsplashPhoto;", "clientId", "", "query", "orientation", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface UnsplashApiService {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://api.unsplash.com/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEMO_BASE_URL = "https://picsum.photos/";
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.network.UnsplashApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "photos/random")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRandomPhoto(@retrofit2.http.Query(value = "client_id")
    @org.jetbrains.annotations.NotNull
    java.lang.String clientId, @retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @retrofit2.http.Query(value = "orientation")
    @org.jetbrains.annotations.NotNull
    java.lang.String orientation, @retrofit2.http.Query(value = "w")
    int width, @retrofit2.http.Query(value = "h")
    int height, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.habittracker.app.network.UnsplashPhoto>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/habittracker/app/network/UnsplashApiService$Companion;", "", "()V", "BASE_URL", "", "DEMO_BASE_URL", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BASE_URL = "https://api.unsplash.com/";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String DEMO_BASE_URL = "https://picsum.photos/";
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}