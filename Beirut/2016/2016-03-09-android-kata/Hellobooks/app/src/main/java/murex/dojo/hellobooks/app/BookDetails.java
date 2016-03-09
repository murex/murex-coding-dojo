package murex.dojo.hellobooks.app;

import static android.widget.Toast.LENGTH_LONG;
import static murex.dojo.hellobooks.app.Constants.ID;
import static murex.dojo.hellobooks.app.Constants.LIKE_BROADCAST;
import static murex.dojo.hellobooks.app.Constants.NAME;
import static murex.dojo.hellobooks.app.Constants.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import murex.dojo.hellobooks.observers.BroadcastObserver;
import murex.dojo.hellobooks.observers.LikeObserver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class BookDetails extends Activity {

   private List<Observer> observers = new ArrayList<Observer>();
   private BroadcastReceiver likeBroadcastReceiver;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final String bookName = getIntent().getStringExtra(NAME);

      setContentView(R.layout.activity_book_details);

      likeBroadcastReceiver = new BroadcastReceiver() {
         @Override
         public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, bookName + " inserted!", LENGTH_LONG).show();
         }
      };
      registerReceiver(likeBroadcastReceiver, new IntentFilter(LIKE_BROADCAST));

      observers.add(new BroadcastObserver(this));
      observers.add(new LikeObserver(this));

      final TextView message = (TextView) findViewById(R.id.message);
      message.setText(bookName);
   }

   public void update(View view) {
      final String bookName = getIntent().getStringExtra(NAME);
      for (Observer observer : observers) {
         observer.update(null, bookName);
      }
   }

   public void showAllBooks(View view) {
      Cursor c = getContentResolver().query(Uri.parse(URL), null, null, null, null);
      String result = "";

      if (!c.moveToFirst()) {
         Toast.makeText(this, result + " no content yet!", LENGTH_LONG).show();
      } else {
         do {
            result = result + "\n" + " id " + c.getString(c.getColumnIndex(ID)) + ", name " + c.getString(c.getColumnIndex(NAME));
         } while (c.moveToNext());
         Toast.makeText(this, result, LENGTH_LONG).show();
      }
   }

   public void close(View view) {
      this.finish();
   }

   @Override
   protected void onStop() {
      super.onStop();
      unregisterReceiver(likeBroadcastReceiver);
   }
}
