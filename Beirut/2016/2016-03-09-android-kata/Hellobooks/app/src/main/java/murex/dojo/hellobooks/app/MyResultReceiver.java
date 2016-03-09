package murex.dojo.hellobooks.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MyResultReceiver extends ResultReceiver {

   private Receiver mReceiver;

   public MyResultReceiver(Handler handler) {
      super(handler);
   }

   public interface Receiver {
      void onReceiveResult(int resultCode, Object resultData);
   }

   public void setReceiver(Receiver receiver) {
      mReceiver = receiver;
   }

   @Override
   protected void onReceiveResult(int resultCode, Bundle resultData) {
      if (mReceiver != null) {
         mReceiver.onReceiveResult(resultCode, resultData);
      }
   }

}