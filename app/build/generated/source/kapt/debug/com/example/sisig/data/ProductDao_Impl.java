package com.example.sisig.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Product> __insertionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __deletionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __updateAdapterOfProduct;

  public ProductDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `product` (`productId`,`productName`,`productDescription`,`productPrice`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.getProductId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProductId());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        if (value.getProductDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductDescription());
        }
        stmt.bindDouble(4, value.getProductPrice());
      }
    };
    this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `product` WHERE `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.getProductId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProductId());
        }
      }
    };
    this.__updateAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `product` SET `productId` = ?,`productName` = ?,`productDescription` = ?,`productPrice` = ? WHERE `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.getProductId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProductId());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        if (value.getProductDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductDescription());
        }
        stmt.bindDouble(4, value.getProductPrice());
        if (value.getProductId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProductId());
        }
      }
    };
  }

  @Override
  public void insert(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduct.insert(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<Product> products) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduct.insert(products);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProduct.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProduct.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<Product> getById(final String id) {
    final String _sql = "SELECT * FROM product WHERE productId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"product"}, new Callable<Product>() {
      @Override
      public Product call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfProductDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "productDescription");
          final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "productPrice");
          final Product _result;
          if(_cursor.moveToFirst()) {
            final String _tmpProductId;
            if (_cursor.isNull(_cursorIndexOfProductId)) {
              _tmpProductId = null;
            } else {
              _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            }
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final String _tmpProductDescription;
            if (_cursor.isNull(_cursorIndexOfProductDescription)) {
              _tmpProductDescription = null;
            } else {
              _tmpProductDescription = _cursor.getString(_cursorIndexOfProductDescription);
            }
            final double _tmpProductPrice;
            _tmpProductPrice = _cursor.getDouble(_cursorIndexOfProductPrice);
            _result = new Product(_tmpProductId,_tmpProductName,_tmpProductDescription,_tmpProductPrice);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Product> getAll() {
    final String _sql = "SELECT * FROM product";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
      final int _cursorIndexOfProductDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "productDescription");
      final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "productPrice");
      final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Product _item;
        final String _tmpProductId;
        if (_cursor.isNull(_cursorIndexOfProductId)) {
          _tmpProductId = null;
        } else {
          _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
        }
        final String _tmpProductName;
        if (_cursor.isNull(_cursorIndexOfProductName)) {
          _tmpProductName = null;
        } else {
          _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
        }
        final String _tmpProductDescription;
        if (_cursor.isNull(_cursorIndexOfProductDescription)) {
          _tmpProductDescription = null;
        } else {
          _tmpProductDescription = _cursor.getString(_cursorIndexOfProductDescription);
        }
        final double _tmpProductPrice;
        _tmpProductPrice = _cursor.getDouble(_cursorIndexOfProductPrice);
        _item = new Product(_tmpProductId,_tmpProductName,_tmpProductDescription,_tmpProductPrice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
