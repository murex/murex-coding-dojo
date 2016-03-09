package murex.dojo.hellobooks.app;

import static murex.dojo.hellobooks.app.Constants.RECEIVER_TAG;
import static murex.dojo.hellobooks.app.Constants.SERVICE_TAG;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class TimerService extends IntentService {


   public TimerService() {
      super("TimerService");
   }

   @Override
   protected void onHandleIntent(Intent intent) {

      final ResultReceiver rec = intent.getParcelableExtra(RECEIVER_TAG);

      new Thread() {
         int seconds;

         @Override
         public void run() {
            while (seconds < 100) {
               Bundle b = new Bundle();
               b.putString(SERVICE_TAG, String.valueOf(seconds++));
               rec.send(0, b);
               try {
                  sleep(1000);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      }.start();


   }

}