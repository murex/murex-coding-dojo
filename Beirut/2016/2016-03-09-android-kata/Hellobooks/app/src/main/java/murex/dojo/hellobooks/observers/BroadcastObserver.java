package murex.dojo.hellobooks.observers;

import static murex.dojo.hellobooks.app.Constants.LIKE_BROADCAST;
import static murex.dojo.hellobooks.app.Constants.NAME;

import java.util.Observable;
import java.util.Observer;

import android.content.Context;
import android.content.Intent;

public class BroadcastObserver implements Observer {
   private Context context;

   public BroadcastObserver(Context context) {
      this.context = context;
   }

   @Override
   public void update(Observable observable, Object bookName) {
      Intent intent = new Intent(LIKE_BROADCAST);
      intent.putExtra(NAME, (String) bookName);
      context.sendBroadcast(intent);
   }
}
