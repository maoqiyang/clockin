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
import com.habittracker.app.data.model.MotivationContent;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MotivationContentDao_Impl implements MotivationContentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MotivationContent> __insertionAdapterOfMotivationContent;

  private final EntityDeletionOrUpdateAdapter<MotivationContent> __deletionAdapterOfMotivationContent;

  private final EntityDeletionOrUpdateAdapter<MotivationContent> __updateAdapterOfMotivationContent;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFavoriteStatus;

  private final SharedSQLiteStatement __preparedStmtOfClearNonFavoriteNetworkContent;

  public MotivationContentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMotivationContent = new EntityInsertionAdapter<MotivationContent>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `motivation_content` (`id`,`imageUrl`,`localImagePath`,`quote`,`author`,`isFavorite`,`isFromNetwork`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final MotivationContent entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getImageUrl() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getImageUrl());
        }
        if (entity.getLocalImagePath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLocalImagePath());
        }
        if (entity.getQuote() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getQuote());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAuthor());
        }
        final int _tmp = entity.isFavorite() ? 1 : 0;
        statement.bindLong(6, _tmp);
        final int _tmp_1 = entity.isFromNetwork() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
        statement.bindLong(8, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfMotivationContent = new EntityDeletionOrUpdateAdapter<MotivationContent>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `motivation_content` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final MotivationContent entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfMotivationContent = new EntityDeletionOrUpdateAdapter<MotivationContent>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `motivation_content` SET `id` = ?,`imageUrl` = ?,`localImagePath` = ?,`quote` = ?,`author` = ?,`isFavorite` = ?,`isFromNetwork` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final MotivationContent entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getImageUrl() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getImageUrl());
        }
        if (entity.getLocalImagePath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLocalImagePath());
        }
        if (entity.getQuote() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getQuote());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAuthor());
        }
        final int _tmp = entity.isFavorite() ? 1 : 0;
        statement.bindLong(6, _tmp);
        final int _tmp_1 = entity.isFromNetwork() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
        statement.bindLong(8, entity.getCreatedAt());
        statement.bindLong(9, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateFavoriteStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE motivation_content SET isFavorite = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearNonFavoriteNetworkContent = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM motivation_content WHERE isFromNetwork = 1 AND isFavorite = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertContent(final MotivationContent content,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfMotivationContent.insertAndReturnId(content);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteContent(final MotivationContent content,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMotivationContent.handle(content);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateContent(final MotivationContent content,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMotivationContent.handle(content);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateFavoriteStatus(final long id, final boolean isFavorite,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFavoriteStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isFavorite ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdateFavoriteStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object clearNonFavoriteNetworkContent(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearNonFavoriteNetworkContent.acquire();
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
          __preparedStmtOfClearNonFavoriteNetworkContent.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<MotivationContent>> getAllContent() {
    final String _sql = "SELECT * FROM motivation_content ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"motivation_content"}, false, new Callable<List<MotivationContent>>() {
      @Override
      @Nullable
      public List<MotivationContent> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfLocalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localImagePath");
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsFromNetwork = CursorUtil.getColumnIndexOrThrow(_cursor, "isFromNetwork");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<MotivationContent> _result = new ArrayList<MotivationContent>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MotivationContent _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpLocalImagePath;
            if (_cursor.isNull(_cursorIndexOfLocalImagePath)) {
              _tmpLocalImagePath = null;
            } else {
              _tmpLocalImagePath = _cursor.getString(_cursorIndexOfLocalImagePath);
            }
            final String _tmpQuote;
            if (_cursor.isNull(_cursorIndexOfQuote)) {
              _tmpQuote = null;
            } else {
              _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsFromNetwork;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFromNetwork);
            _tmpIsFromNetwork = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new MotivationContent(_tmpId,_tmpImageUrl,_tmpLocalImagePath,_tmpQuote,_tmpAuthor,_tmpIsFavorite,_tmpIsFromNetwork,_tmpCreatedAt);
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
  public LiveData<List<MotivationContent>> getFavoriteContent() {
    final String _sql = "SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"motivation_content"}, false, new Callable<List<MotivationContent>>() {
      @Override
      @Nullable
      public List<MotivationContent> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfLocalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localImagePath");
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsFromNetwork = CursorUtil.getColumnIndexOrThrow(_cursor, "isFromNetwork");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<MotivationContent> _result = new ArrayList<MotivationContent>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MotivationContent _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpLocalImagePath;
            if (_cursor.isNull(_cursorIndexOfLocalImagePath)) {
              _tmpLocalImagePath = null;
            } else {
              _tmpLocalImagePath = _cursor.getString(_cursorIndexOfLocalImagePath);
            }
            final String _tmpQuote;
            if (_cursor.isNull(_cursorIndexOfQuote)) {
              _tmpQuote = null;
            } else {
              _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsFromNetwork;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFromNetwork);
            _tmpIsFromNetwork = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new MotivationContent(_tmpId,_tmpImageUrl,_tmpLocalImagePath,_tmpQuote,_tmpAuthor,_tmpIsFavorite,_tmpIsFromNetwork,_tmpCreatedAt);
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
  public Object getRandomContent(final Continuation<? super MotivationContent> $completion) {
    final String _sql = "SELECT * FROM motivation_content ORDER BY RANDOM() LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MotivationContent>() {
      @Override
      @Nullable
      public MotivationContent call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfLocalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localImagePath");
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsFromNetwork = CursorUtil.getColumnIndexOrThrow(_cursor, "isFromNetwork");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final MotivationContent _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpLocalImagePath;
            if (_cursor.isNull(_cursorIndexOfLocalImagePath)) {
              _tmpLocalImagePath = null;
            } else {
              _tmpLocalImagePath = _cursor.getString(_cursorIndexOfLocalImagePath);
            }
            final String _tmpQuote;
            if (_cursor.isNull(_cursorIndexOfQuote)) {
              _tmpQuote = null;
            } else {
              _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsFromNetwork;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFromNetwork);
            _tmpIsFromNetwork = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new MotivationContent(_tmpId,_tmpImageUrl,_tmpLocalImagePath,_tmpQuote,_tmpAuthor,_tmpIsFavorite,_tmpIsFromNetwork,_tmpCreatedAt);
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

  @Override
  public Object getRandomFavoriteContent(
      final Continuation<? super MotivationContent> $completion) {
    final String _sql = "SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY RANDOM() LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MotivationContent>() {
      @Override
      @Nullable
      public MotivationContent call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfLocalImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localImagePath");
          final int _cursorIndexOfQuote = CursorUtil.getColumnIndexOrThrow(_cursor, "quote");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final int _cursorIndexOfIsFromNetwork = CursorUtil.getColumnIndexOrThrow(_cursor, "isFromNetwork");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final MotivationContent _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpLocalImagePath;
            if (_cursor.isNull(_cursorIndexOfLocalImagePath)) {
              _tmpLocalImagePath = null;
            } else {
              _tmpLocalImagePath = _cursor.getString(_cursorIndexOfLocalImagePath);
            }
            final String _tmpQuote;
            if (_cursor.isNull(_cursorIndexOfQuote)) {
              _tmpQuote = null;
            } else {
              _tmpQuote = _cursor.getString(_cursorIndexOfQuote);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            final boolean _tmpIsFromNetwork;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsFromNetwork);
            _tmpIsFromNetwork = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new MotivationContent(_tmpId,_tmpImageUrl,_tmpLocalImagePath,_tmpQuote,_tmpAuthor,_tmpIsFavorite,_tmpIsFromNetwork,_tmpCreatedAt);
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

  @Override
  public Object getContentCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM motivation_content";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
