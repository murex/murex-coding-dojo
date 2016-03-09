package murex.dojo.hellobooks.app;

import static murex.dojo.hellobooks.app.Constants.*;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class BookContentProvider extends ContentProvider {

   private SQLiteDatabase database;

   @Override
   public boolean onCreate() {
      database = new DBInstance(getContext()).getWritableDatabase();
      return database != null;
   }

   @Override
   public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

      SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
      queryBuilder.setTables(TABLE_NAME);

      Cursor cursor = queryBuilder.query(database, projection, selection, selectionArgs, null, null, sortOrder);
      cursor.setNotificationUri(getContext().getContentResolver(), uri);
      return cursor;
   }

   @Override
   public Uri insert(Uri uri, ContentValues values) {
      long row = database.insert(TABLE_NAME, "", values);

      if (row > 0) {
         Uri newUri = ContentUris.withAppendedId(CONTENT_URI, row);
         getContext().getContentResolver().notifyChange(newUri, null);
         return newUri;
      }
      throw new SQLException("Fail to add a new record into " + uri);
   }

   @Override
   public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
      throw new UnsupportedOperationException("Update not supported");
   }

   @Override
   public int delete(Uri uri, String selection, String[] selectionArgs) {
      throw new UnsupportedOperationException("Delete not supported");

   }

   @Override
   public String getType(Uri uri) {
      throw new UnsupportedOperationException("GetType not supported");
   }

   private static class DBInstance extends SQLiteOpenHelper {

      public DBInstance(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
         db.execSQL(CREATE_TABLE);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         throw new UnsupportedOperationException("onUpgrade not supported");
      }
   }


}