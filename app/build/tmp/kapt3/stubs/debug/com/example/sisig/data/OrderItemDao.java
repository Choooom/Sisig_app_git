package com.example.sisig.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/sisig/data/OrderItemDao;", "", "delete", "", "orderItem", "Lcom/example/sisig/data/OrderItem;", "deleteByOrderId", "", "orderNo", "", "getByOrderId", "", "insert", "insertAll", "orderItems", "app_debug"})
@androidx.room.Dao()
public abstract interface OrderItemDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.OrderItem orderItem);
    
    @androidx.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.sisig.data.OrderItem> orderItems);
    
    @androidx.room.Query(value = "SELECT * FROM order_items WHERE uniqueOrderNo = :orderNo")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.sisig.data.OrderItem> getByOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String orderNo);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.OrderItem orderItem);
    
    @androidx.room.Query(value = "DELETE FROM order_items WHERE uniqueOrderNo = :orderNo")
    public abstract int deleteByOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String orderNo);
}