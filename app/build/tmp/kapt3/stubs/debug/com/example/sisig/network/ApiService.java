package com.example.sisig.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J4\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/sisig/network/ApiService;", "", "addInventory", "Lretrofit2/Response;", "", "", "item", "Lcom/example/sisig/model/InventoryItem;", "(Lcom/example/sisig/model/InventoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInventory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/example/sisig/model/LoginResponse;", "loginRequest", "Lcom/example/sisig/model/LoginRequest;", "(Lcom/example/sisig/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "Lcom/example/sisig/model/ResetPasswordResponse;", "resetRequest", "Lcom/example/sisig/model/ResetPasswordRequest;", "(Lcom/example/sisig/model/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInventory", "id", "", "(ILcom/example/sisig/model/InventoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.sisig.model.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.sisig.model.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "/reset-password")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resetPassword(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.sisig.model.ResetPasswordRequest resetRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.sisig.model.ResetPasswordResponse>> $completion);
    
    @retrofit2.http.GET(value = "/inventory")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInventory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.sisig.model.InventoryItem>>> $completion);
    
    @retrofit2.http.POST(value = "/inventory")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addInventory(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.sisig.model.InventoryItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
    
    @retrofit2.http.PUT(value = "/inventory/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateInventory(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.sisig.model.InventoryItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
}