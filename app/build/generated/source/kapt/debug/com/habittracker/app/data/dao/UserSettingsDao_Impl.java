package com.habittracker.app.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.habittracker.app.data.model.UserSettings;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserSettingsDao_Impl implements UserSettingsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserSettings> __insertionAdapterOfUserSettings;

  private final EntityDeletionOrUpdateAdapter<UserSettings> __updateAdapterOfUserSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReminderTime;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReminderEnabled;

  public UserSettingsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserSettings = new EntityInsertionAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_settings` (`id`,`reminderTime`,`isReminderEnabled`,`lastSyncTime`,`updatedAt`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final UserSettings entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getReminderTime() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getReminderTime());
        }
        final int _tmp = entity.isReminderEnabled() ? 1 : 0;
        statement.bindLong(3, _tmp);
        statement.bindLong(4, entity.getLastSyncTime());
        statement.bindLong(5, entity.getUpdatedAt());
      }
    };
    this.__updateAdapterOfUserSettings = new EntityDeletionOrUpdateAdapter<UserSettings>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_settings` SET `id` = ?,`reminderTime` = ?,`isReminderEnabled` = ?,`lastSyncTime` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final UserSettings entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getReminderTime() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getReminderTime());
        }
        final int _tmp = entity.isReminderEnabled() ? 1 : 0;
        statement.bindLong(3, _tmp);
        statement.bindLong(4, entity.getLastSyncTime());
        statement.bindLong(5, entity.getUpdatedAt());
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateReminderTime = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET reminderTime = ? WHERE id = 1";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReminderEnabled = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_settings SET isReminderEnabled = ? WHERE id = 1";
        return _query;
      }
    };
  }

  @Override
  public Object insertSettings(final UserSettings settings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserSettings.insert(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSettings(final UserSettings settings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserSettings.handle(settings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateReminderTime(final String time,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReminderTime.acquire();
        int _argIndex = 1;
        if (time == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, time);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateReminderTime.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateReminderEnabled(final boolean enabled,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReminderEnabled.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateReminderEnabled.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<UserSettings> getSettings() {
    final String _sql = "SELECT * FROM user_settings WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"user_settings"}, false, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReminderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTime");
          final int _cursorIndexOfIsReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isReminderEnabled");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpReminderTime;
            if (_cursor.isNull(_cursorIndexOfReminderTime)) {
              _tmpReminderTime = null;
            } else {
              _tmpReminderTime = _cursor.getString(_cursorIndexOfReminderTime);
            }
            final boolean _tmpIsReminderEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReminderEnabled);
            _tmpIsReminderEnabled = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new UserSettings(_tmpId,_tmpReminderTime,_tmpIsReminderEnabled,_tmpLastSyncTime,_tmpUpdatedAt);
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
  public Object getSettingsSync(final Continuation<? super UserSettings> $completion) {
    final String _sql = "SELECT * FROM user_settings WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserSettings>() {
      @Override
      @Nullable
      public UserSettings call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfReminderTime = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderTime");
          final int _cursorIndexOfIsReminderEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isReminderEnabled");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final UserSettings _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpReminderTime;
            if (_cursor.isNull(_cursorIndexOfReminderTime)) {
              _tmpReminderTime = null;
            } else {
              _tmpReminderTime = _cursor.getString(_cursorIndexOfReminderTime);
            }
            final boolean _tmpIsReminderEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReminderEnabled);
            _tmpIsReminderEnabled = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new UserSettings(_tmpId,_tmpReminderTime,_tmpIsReminderEnabled,_tmpLastSyncTime,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
