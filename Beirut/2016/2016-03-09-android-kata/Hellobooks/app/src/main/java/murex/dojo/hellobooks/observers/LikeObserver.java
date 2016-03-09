package murex.dojo.hellobooks.observers;

import static murex.dojo.hellobooks.app.Constants.CONTENT_URI;
import static murex.dojo.hellobooks.app.Constants.NAME;

import java.util.Observable;
import java.util.Observer;

import android.content.ContentValues;
import android.content.Context;

public class LikeObserver implements Observer {
   private Context context;

   public LikeObserver(Context context) {
      this.context = context;
   }

   @Override
   public void update(Observable observable, Object bookName) {
      ContentValues values = new ContentValues();
      values.put(NAME, (String) bookName);
      context.getContentResolver().insert(CONTENT_URI, values);
   }
}
