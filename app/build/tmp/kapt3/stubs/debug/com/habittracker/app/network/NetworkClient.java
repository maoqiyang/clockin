package com.habittracker.app.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/habittracker/app/network/NetworkClient;", "", "()V", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "unsplashApiService", "Lcom/habittracker/app/network/UnsplashApiService;", "getUnsplashApiService", "()Lcom/habittracker/app/network/UnsplashApiService;", "getDemoImageUrl", "", "width", "", "height", "app_debug"})
public final class NetworkClient {
    @org.jetbrains.annotations.NotNull
    private static final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    @org.jetbrains.annotations.NotNull
    private static final okhttp3.OkHttpClient okHttpClient = null;
    private static final retrofit2.Retrofit retrofit = null;
    @org.jetbrains.annotations.NotNull
    private static final com.habittracker.app.network.UnsplashApiService unsplashApiService = null;
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.network.NetworkClient INSTANCE = null;
    
    private NetworkClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.habittracker.app.network.UnsplashApiService getUnsplashApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDemoImageUrl(int width, int height) {
        return null;
    }
}