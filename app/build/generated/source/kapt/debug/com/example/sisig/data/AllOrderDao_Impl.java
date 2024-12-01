package com.example.sisig.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.sisig.MenuItem;
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
public final class AllOrderDao_Impl implements AllOrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AllOrder> __insertionAdapterOfAllOrder;

  private final Converters __converters = new Converters();

  public AllOrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAllOrder = new EntityInsertionAdapter<AllOrder>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `all_orders` (`orderId`,`orderDetail`,`totalAmount`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AllOrder value) {
        stmt.bindLong(1, value.getOrderId());
        final String _tmp = __converters.fromMenuItemList(value.getOrderDetail());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        stmt.bindDouble(3, value.getTotalAmount());
      }
    };
  }

  @Override
  public long insert(final AllOrder allOrder) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAllOrder.insertAndReturnId(allOrder);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<AllOrder>> getAllOrders() {
    final String _sql = "SELECT * FROM all_orders";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"all_orders"}, new Callable<List<AllOrder>>() {
      @Override
      public List<AllOrder> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
          final int _cursorIndexOfOrderDetail = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDetail");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final List<AllOrder> _result = new ArrayList<AllOrder>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AllOrder _item;
            final long _tmpOrderId;
            _tmpOrderId = _cursor.getLong(_cursorIndexOfOrderId);
            final List<MenuItem> _tmpOrderDetail;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfOrderDetail)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfOrderDetail);
            }
            _tmpOrderDetail = __converters.toMenuItemList(_tmp);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            _item = new AllOrder(_tmpOrderId,_tmpOrderDetail,_tmpTotalAmount);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
