package com.example.sisig.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/sisig/data/StockDao;", "", "delete", "", "stock", "Lcom/example/sisig/data/Stock;", "getAll", "", "getById", "id", "", "insert", "updateStock", "newStock", "app_debug"})
@androidx.room.Dao()
public abstract interface StockDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.Stock stock);
    
    @androidx.room.Query(value = "SELECT * FROM stock WHERE stockId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract com.example.sisig.data.Stock getById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM stock")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.sisig.data.Stock> getAll();
    
    @androidx.room.Query(value = "UPDATE stock SET totalStock = :newStock WHERE stockId = :id")
    public abstract int updateStock(int id, int newStock);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.sisig.data.Stock stock);
}