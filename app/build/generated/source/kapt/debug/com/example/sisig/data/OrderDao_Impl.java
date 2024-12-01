package com.example.sisig.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OrderDao_Impl implements OrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Order> __insertionAdapterOfOrder;

  public OrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrder = new EntityInsertionAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `orders` (`uniqueOrderNo`,`orderDate`,`totalAmount`,`status`,`paymentMethod`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        if (value.getUniqueOrderNo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUniqueOrderNo());
        }
        if (value.getOrderDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOrderDate());
        }
        stmt.bindDouble(3, value.getTotalAmount());
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
        if (value.getPaymentMethod() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPaymentMethod());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUpdatedAt());
        }
      }
    };
  }

  @Override
  public void insert(final Order order) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOrder.insert(order);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<Order> getById(final String orderNo) {
    final String _sql = "SELECT * FROM orders WHERE uniqueOrderNo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (orderNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, orderNo);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"orders"}, new Callable<Order>() {
      @Override
      public Order call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUniqueOrderNo = CursorUtil.getColumnIndexOrThrow(_cursor, "uniqueOrderNo");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Order _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUniqueOrderNo;
            if (_cursor.isNull(_cursorIndexOfUniqueOrderNo)) {
              _tmpUniqueOrderNo = null;
            } else {
              _tmpUniqueOrderNo = _cursor.getString(_cursorIndexOfUniqueOrderNo);
            }
            final String _tmpOrderDate;
            if (_cursor.isNull(_cursorIndexOfOrderDate)) {
              _tmpOrderDate = null;
            } else {
              _tmpOrderDate = _cursor.getString(_cursorIndexOfOrderDate);
            }
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
            }
            final String _tmpUpdatedAt;
            if (_cursor.isNull(_cursorIndexOfUpdatedAt)) {
              _tmpUpdatedAt = null;
            } else {
              _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
            }
            _result = new Order(_tmpUniqueOrderNo,_tmpOrderDate,_tmpTotalAmount,_tmpStatus,_tmpPaymentMethod,_tmpCreatedAt,_tmpUpdatedAt);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
