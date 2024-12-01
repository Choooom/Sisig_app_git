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
public final class ProductStockDao_Impl implements ProductStockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProductStock> __insertionAdapterOfProductStock;

  private final EntityDeletionOrUpdateAdapter<ProductStock> __deletionAdapterOfProductStock;

  private final EntityDeletionOrUpdateAdapter<ProductStock> __updateAdapterOfProductStock;

  public ProductStockDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductStock = new EntityInsertionAdapter<ProductStock>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `product_stock` (`id`,`productName`,`quantity`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductStock value) {
        stmt.bindLong(1, value.getId());
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        stmt.bindLong(3, value.getQuantity());
      }
    };
    this.__deletionAdapterOfProductStock = new EntityDeletionOrUpdateAdapter<ProductStock>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `product_stock` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductStock value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfProductStock = new EntityDeletionOrUpdateAdapter<ProductStock>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `product_stock` SET `id` = ?,`productName` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductStock value) {
        stmt.bindLong(1, value.getId());
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        stmt.bindLong(3, value.getQuantity());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insert(final ProductStock productStock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductStock.insert(productStock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ProductStock productStock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProductStock.handle(productStock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ProductStock productStock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProductStock.handle(productStock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<ProductStock>> getAllProductStock() {
    final String _sql = "SELECT * FROM product_stock";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"product_stock"}, new Callable<List<ProductStock>>() {
      @Override
      public List<ProductStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final List<ProductStock> _result = new ArrayList<ProductStock>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProductStock _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item = new ProductStock(_tmpId,_tmpProductName,_tmpQuantity);
            _result.add(_item);
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
  public ProductStock getProductStockByName(final String name) {
    final String _sql = "SELECT * FROM product_stock WHERE productName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final ProductStock _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpProductName;
        if (_cursor.isNull(_cursorIndexOfProductName)) {
          _tmpProductName = null;
        } else {
          _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
        }
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _result = new ProductStock(_tmpId,_tmpProductName,_tmpQuantity);
      } else {
        _result = null;
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
