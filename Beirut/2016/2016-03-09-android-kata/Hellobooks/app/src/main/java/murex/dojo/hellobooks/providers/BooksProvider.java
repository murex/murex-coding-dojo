package murex.dojo.hellobooks.providers;

import static murex.dojo.hellobooks.app.MainActivity.PROXY_ENABLED;

import murex.dojo.hellobooks.app.MyResultReceiver.Receiver;

import android.content.Context;

public abstract class BooksProvider {

   public static BooksProvider booksProvider() {
      return PROXY_ENABLED ? new ProxyEnabledProvider() : new ProxyDisabledProvider();
   }

   public abstract void fetchBooks(Context context, Receiver receiver);
}
