package com.example.sisig.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ProductStockDao _productStockDao;

  private volatile OrderDao _orderDao;

  private volatile OrderItemDao _orderItemDao;

  private volatile ProductDao _productDao;

  private volatile StockDao _stockDao;

  private volatile AllOrderDao _allOrderDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `orders` (`uniqueOrderNo` TEXT NOT NULL, `orderDate` TEXT NOT NULL, `totalAmount` REAL NOT NULL, `status` TEXT NOT NULL, `paymentMethod` TEXT NOT NULL, `createdAt` TEXT NOT NULL, `updatedAt` TEXT NOT NULL, PRIMARY KEY(`uniqueOrderNo`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `order_items` (`orderItemId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uniqueOrderNo` TEXT NOT NULL, `productId` TEXT NOT NULL, `productName` TEXT NOT NULL, `productPrice` REAL NOT NULL, `quantity` INTEGER NOT NULL, `totalPrice` REAL NOT NULL, FOREIGN KEY(`uniqueOrderNo`) REFERENCES `orders`(`uniqueOrderNo`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`productId`) REFERENCES `product`(`productId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_order_items_uniqueOrderNo` ON `order_items` (`uniqueOrderNo`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_order_items_productId` ON `order_items` (`productId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `product` (`productId` TEXT NOT NULL, `productName` TEXT NOT NULL, `productDescription` TEXT, `productPrice` REAL NOT NULL, PRIMARY KEY(`productId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `stock` (`stockId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `totalStock` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `all_orders` (`orderId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderDetail` TEXT NOT NULL, `totalAmount` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `product_stock` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productName` TEXT NOT NULL, `quantity` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cee71afae576b7ab84b9f0b81774ec2d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `orders`");
        _db.execSQL("DROP TABLE IF EXISTS `order_items`");
        _db.execSQL("DROP TABLE IF EXISTS `product`");
        _db.execSQL("DROP TABLE IF EXISTS `stock`");
        _db.execSQL("DROP TABLE IF EXISTS `all_orders`");
        _db.execSQL("DROP TABLE IF EXISTS `product_stock`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsOrders = new HashMap<String, TableInfo.Column>(7);
        _columnsOrders.put("uniqueOrderNo", new TableInfo.Column("uniqueOrderNo", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("orderDate", new TableInfo.Column("orderDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("totalAmount", new TableInfo.Column("totalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("paymentMethod", new TableInfo.Column("paymentMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("updatedAt", new TableInfo.Column("updatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrders = new TableInfo("orders", _columnsOrders, _foreignKeysOrders, _indicesOrders);
        final TableInfo _existingOrders = TableInfo.read(_db, "orders");
        if (! _infoOrders.equals(_existingOrders)) {
          return new RoomOpenHelper.ValidationResult(false, "orders(com.example.sisig.data.Order).\n"
                  + " Expected:\n" + _infoOrders + "\n"
                  + " Found:\n" + _existingOrders);
        }
        final HashMap<String, TableInfo.Column> _columnsOrderItems = new HashMap<String, TableInfo.Column>(7);
        _columnsOrderItems.put("orderItemId", new TableInfo.Column("orderItemId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("uniqueOrderNo", new TableInfo.Column("uniqueOrderNo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("productName", new TableInfo.Column("productName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("productPrice", new TableInfo.Column("productPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("totalPrice", new TableInfo.Column("totalPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrderItems = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysOrderItems.add(new TableInfo.ForeignKey("orders", "CASCADE", "NO ACTION",Arrays.asList("uniqueOrderNo"), Arrays.asList("uniqueOrderNo")));
        _foreignKeysOrderItems.add(new TableInfo.ForeignKey("product", "CASCADE", "NO ACTION",Arrays.asList("productId"), Arrays.asList("productId")));
        final HashSet<TableInfo.Index> _indicesOrderItems = new HashSet<TableInfo.Index>(2);
        _indicesOrderItems.add(new TableInfo.Index("index_order_items_uniqueOrderNo", false, Arrays.asList("uniqueOrderNo"), Arrays.asList("ASC")));
        _indicesOrderItems.add(new TableInfo.Index("index_order_items_productId", false, Arrays.asList("productId"), Arrays.asList("ASC")));
        final TableInfo _infoOrderItems = new TableInfo("order_items", _columnsOrderItems, _foreignKeysOrderItems, _indicesOrderItems);
        final TableInfo _existingOrderItems = TableInfo.read(_db, "order_items");
        if (! _infoOrderItems.equals(_existingOrderItems)) {
          return new RoomOpenHelper.ValidationResult(false, "order_items(com.example.sisig.data.OrderItem).\n"
                  + " Expected:\n" + _infoOrderItems + "\n"
                  + " Found:\n" + _existingOrderItems);
        }
        final HashMap<String, TableInfo.Column> _columnsProduct = new HashMap<String, TableInfo.Column>(4);
        _columnsProduct.put("productId", new TableInfo.Column("productId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("productName", new TableInfo.Column("productName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("productDescription", new TableInfo.Column("productDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("productPrice", new TableInfo.Column("productPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProduct = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProduct = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProduct = new TableInfo("product", _columnsProduct, _foreignKeysProduct, _indicesProduct);
        final TableInfo _existingProduct = TableInfo.read(_db, "product");
        if (! _infoProduct.equals(_existingProduct)) {
          return new RoomOpenHelper.ValidationResult(false, "product(com.example.sisig.data.Product).\n"
                  + " Expected:\n" + _infoProduct + "\n"
                  + " Found:\n" + _existingProduct);
        }
        final HashMap<String, TableInfo.Column> _columnsStock = new HashMap<String, TableInfo.Column>(3);
        _columnsStock.put("stockId", new TableInfo.Column("stockId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("totalStock", new TableInfo.Column("totalStock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStock.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStock = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStock = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStock = new TableInfo("stock", _columnsStock, _foreignKeysStock, _indicesStock);
        final TableInfo _existingStock = TableInfo.read(_db, "stock");
        if (! _infoStock.equals(_existingStock)) {
          return new RoomOpenHelper.ValidationResult(false, "stock(com.example.sisig.data.Stock).\n"
                  + " Expected:\n" + _infoStock + "\n"
                  + " Found:\n" + _existingStock);
        }
        final HashMap<String, TableInfo.Column> _columnsAllOrders = new HashMap<String, TableInfo.Column>(3);
        _columnsAllOrders.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAllOrders.put("orderDetail", new TableInfo.Column("orderDetail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAllOrders.put("totalAmount", new TableInfo.Column("totalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAllOrders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAllOrders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAllOrders = new TableInfo("all_orders", _columnsAllOrders, _foreignKeysAllOrders, _indicesAllOrders);
        final TableInfo _existingAllOrders = TableInfo.read(_db, "all_orders");
        if (! _infoAllOrders.equals(_existingAllOrders)) {
          return new RoomOpenHelper.ValidationResult(false, "all_orders(com.example.sisig.data.AllOrder).\n"
                  + " Expected:\n" + _infoAllOrders + "\n"
                  + " Found:\n" + _existingAllOrders);
        }
        final HashMap<String, TableInfo.Column> _columnsProductStock = new HashMap<String, TableInfo.Column>(3);
        _columnsProductStock.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductStock.put("productName", new TableInfo.Column("productName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductStock.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductStock = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductStock = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductStock = new TableInfo("product_stock", _columnsProductStock, _foreignKeysProductStock, _indicesProductStock);
        final TableInfo _existingProductStock = TableInfo.read(_db, "product_stock");
        if (! _infoProductStock.equals(_existingProductStock)) {
          return new RoomOpenHelper.ValidationResult(false, "product_stock(com.example.sisig.data.ProductStock).\n"
                  + " Expected:\n" + _infoProductStock + "\n"
                  + " Found:\n" + _existingProductStock);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "cee71afae576b7ab84b9f0b81774ec2d", "4cbc12704c2c9d9b622f711b7bcf5367");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "orders","order_items","product","stock","all_orders","product_stock");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `orders`");
      _db.execSQL("DELETE FROM `order_items`");
      _db.execSQL("DELETE FROM `product`");
      _db.execSQL("DELETE FROM `stock`");
      _db.execSQL("DELETE FROM `all_orders`");
      _db.execSQL("DELETE FROM `product_stock`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProductStockDao.class, ProductStockDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderItemDao.class, OrderItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StockDao.class, StockDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AllOrderDao.class, AllOrderDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ProductStockDao getProductStockDao() {
    if (_productStockDao != null) {
      return _productStockDao;
    } else {
      synchronized(this) {
        if(_productStockDao == null) {
          _productStockDao = new ProductStockDao_Impl(this);
        }
        return _productStockDao;
      }
    }
  }

  @Override
  public OrderDao getOrderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public OrderItemDao getOrderItemDao() {
    if (_orderItemDao != null) {
      return _orderItemDao;
    } else {
      synchronized(this) {
        if(_orderItemDao == null) {
          _orderItemDao = new OrderItemDao_Impl(this);
        }
        return _orderItemDao;
      }
    }
  }

  @Override
  public ProductDao getProductDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public StockDao getStockDao() {
    if (_stockDao != null) {
      return _stockDao;
    } else {
      synchronized(this) {
        if(_stockDao == null) {
          _stockDao = new StockDao_Impl(this);
        }
        return _stockDao;
      }
    }
  }

  @Override
  public AllOrderDao getAllOrderDao() {
    if (_allOrderDao != null) {
      return _allOrderDao;
    } else {
      synchronized(this) {
        if(_allOrderDao == null) {
          _allOrderDao = new AllOrderDao_Impl(this);
        }
        return _allOrderDao;
      }
    }
  }
}
