package com.example.sisig.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/sisig/data/ProductStockDao;", "", "delete", "", "productStock", "Lcom/example/sisig/data/ProductStock;", "getAllProductStock", "Lkotlinx/coroutines/flow/Flow;", "", "getProductStockByName", "name", "", "insert", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface ProductStockDao {
    
    @androidx.room.Query(value = "SELECT * FROM product_stock")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.sisig.data.ProductStock>> getAllProductStock();
    
    @androidx.room.Query(value = "SELECT * FROM product_stock WHERE productName = :name")
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.sisig.data.ProductStock getProductStockByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.ProductStock productStock);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.ProductStock productStock);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.ProductStock productStock);
}