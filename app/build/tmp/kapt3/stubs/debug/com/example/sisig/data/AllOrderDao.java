package com.example.sisig.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/sisig/data/AllOrderDao;", "", "getAllOrders", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/sisig/data/AllOrder;", "insert", "", "allOrder", "app_debug"})
@androidx.room.Dao()
@androidx.room.TypeConverters(value = {com.example.sisig.data.Converters.class})
public abstract interface AllOrderDao {
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.AllOrder allOrder);
    
    @androidx.room.Query(value = "SELECT * FROM all_orders")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.sisig.data.AllOrder>> getAllOrders();
}