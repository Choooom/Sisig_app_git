package com.example.sisig.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StockDao_Impl implements StockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Stock> __insertionAdapterOfStock;

  private final EntityDeletionOrUpdateAdapter<Stock> __deletionAdapterOfStock;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStock;

  public StockDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStock = new EntityInsertionAdapter<Stock>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `stock` (`stockId`,`totalStock`,`updatedAt`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Stock value) {
        stmt.bindLong(1, value.getStockId());
        stmt.bindLong(2, value.getTotalStock());
        stmt.bindLong(3, value.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfStock = new EntityDeletionOrUpdateAdapter<Stock>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `stock` WHERE `stockId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Stock value) {
        stmt.bindLong(1, value.getStockId());
      }
    };
    this.__preparedStmtOfUpdateStock = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE stock SET totalStock = ? WHERE stockId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Stock stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStock.insert(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Stock stock) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfStock.handle(stock);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateStock(final int id, final int newStock) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStock.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, newStock);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateStock.release(_stmt);
    }
  }

  @Override
  public Stock getById(final int id) {
    final String _sql = "SELECT * FROM stock WHERE stockId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStockId = CursorUtil.getColumnIndexOrThrow(_cursor, "stockId");
      final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "totalStock");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final Stock _result;
      if(_cursor.moveToFirst()) {
        _result = new Stock();
        final int _tmpStockId;
        _tmpStockId = _cursor.getInt(_cursorIndexOfStockId);
        _result.setStockId(_tmpStockId);
        final int _tmpTotalStock;
        _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
        _result.setTotalStock(_tmpTotalStock);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _result.setUpdatedAt(_tmpUpdatedAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Stock> getAll() {
    final String _sql = "SELECT * FROM stock";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStockId = CursorUtil.getColumnIndexOrThrow(_cursor, "stockId");
      final int _cursorIndexOfTotalStock = CursorUtil.getColumnIndexOrThrow(_cursor, "totalStock");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<Stock> _result = new ArrayList<Stock>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Stock _item;
        _item = new Stock();
        final int _tmpStockId;
        _tmpStockId = _cursor.getInt(_cursorIndexOfStockId);
        _item.setStockId(_tmpStockId);
        final int _tmpTotalStock;
        _tmpTotalStock = _cursor.getInt(_cursorIndexOfTotalStock);
        _item.setTotalStock(_tmpTotalStock);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item.setUpdatedAt(_tmpUpdatedAt);
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
