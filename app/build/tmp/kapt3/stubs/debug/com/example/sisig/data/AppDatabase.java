package com.example.sisig.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lcom/example/sisig/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "allOrderDao", "Lcom/example/sisig/data/AllOrderDao;", "getAllOrderDao", "()Lcom/example/sisig/data/AllOrderDao;", "orderDao", "Lcom/example/sisig/data/OrderDao;", "getOrderDao", "()Lcom/example/sisig/data/OrderDao;", "orderItemDao", "Lcom/example/sisig/data/OrderItemDao;", "getOrderItemDao", "()Lcom/example/sisig/data/OrderItemDao;", "productDao", "Lcom/example/sisig/data/ProductDao;", "getProductDao", "()Lcom/example/sisig/data/ProductDao;", "productStockDao", "Lcom/example/sisig/data/ProductStockDao;", "getProductStockDao", "()Lcom/example/sisig/data/ProductStockDao;", "stockDao", "Lcom/example/sisig/data/StockDao;", "getStockDao", "()Lcom/example/sisig/data/StockDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.sisig.data.Order.class, com.example.sisig.data.OrderItem.class, com.example.sisig.data.Product.class, com.example.sisig.data.Stock.class, com.example.sisig.data.AllOrder.class, com.example.sisig.data.ProductStock.class}, version = 4, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.sisig.data.Converters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.sisig.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_3_4 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.sisig.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.ProductStockDao getProductStockDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.OrderDao getOrderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.OrderItemDao getOrderItemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.ProductDao getProductDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.StockDao getStockDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.sisig.data.AllOrderDao getAllOrderDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/sisig/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/sisig/data/AppDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_1_2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_2_3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_3_4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.sisig.data.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}