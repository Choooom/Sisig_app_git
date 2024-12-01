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
public final class OrderItemDao_Impl implements OrderItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderItem> __insertionAdapterOfOrderItem;

  private final EntityDeletionOrUpdateAdapter<OrderItem> __deletionAdapterOfOrderItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByOrderId;

  public OrderItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderItem = new EntityInsertionAdapter<OrderItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `order_items` (`orderItemId`,`uniqueOrderNo`,`productId`,`productName`,`productPrice`,`quantity`,`totalPrice`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderItem value) {
        stmt.bindLong(1, value.getOrderItemId());
        if (value.getUniqueOrderNo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUniqueOrderNo());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductId());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProductName());
        }
        stmt.bindDouble(5, value.getProductPrice());
        stmt.bindLong(6, value.getQuantity());
        stmt.bindDouble(7, value.getTotalPrice());
      }
    };
    this.__deletionAdapterOfOrderItem = new EntityDeletionOrUpdateAdapter<OrderItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `order_items` WHERE `orderItemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderItem value) {
        stmt.bindLong(1, value.getOrderItemId());
      }
    };
    this.__preparedStmtOfDeleteByOrderId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM order_items WHERE uniqueOrderNo = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final OrderItem orderItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOrderItem.insert(orderItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<OrderItem> orderItems) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOrderItem.insert(orderItems);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final OrderItem orderItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOrderItem.handle(orderItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteByOrderId(final String orderNo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByOrderId.acquire();
    int _argIndex = 1;
    if (orderNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, orderNo);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByOrderId.release(_stmt);
    }
  }

  @Override
  public List<OrderItem> getByOrderId(final String orderNo) {
    final String _sql = "SELECT * FROM order_items WHERE uniqueOrderNo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (orderNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, orderNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfOrderItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderItemId");
      final int _cursorIndexOfUniqueOrderNo = CursorUtil.getColumnIndexOrThrow(_cursor, "uniqueOrderNo");
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
      final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "productPrice");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
      final List<OrderItem> _result = new ArrayList<OrderItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OrderItem _item;
        final int _tmpOrderItemId;
        _tmpOrderItemId = _cursor.getInt(_cursorIndexOfOrderItemId);
        final String _tmpUniqueOrderNo;
        if (_cursor.isNull(_cursorIndexOfUniqueOrderNo)) {
          _tmpUniqueOrderNo = null;
        } else {
          _tmpUniqueOrderNo = _cursor.getString(_cursorIndexOfUniqueOrderNo);
        }
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
        final double _tmpProductPrice;
        _tmpProductPrice = _cursor.getDouble(_cursorIndexOfProductPrice);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        final double _tmpTotalPrice;
        _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
        _item = new OrderItem(_tmpOrderItemId,_tmpUniqueOrderNo,_tmpProductId,_tmpProductName,_tmpProductPrice,_tmpQuantity,_tmpTotalPrice);
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
