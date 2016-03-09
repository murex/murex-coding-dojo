package murex.dojo.hellobooks.providers;

import static murex.dojo.hellobooks.app.Constants.BOOKS_FETCHED_RESULT_CODE;

import java.util.ArrayList;
import java.util.List;

import murex.dojo.hellobooks.app.Book;
import murex.dojo.hellobooks.app.MyResultReceiver.Receiver;

import android.content.Context;

public class ProxyDisabledProvider extends BooksProvider {

   @Override
   public void fetchBooks(Context context, Receiver receiver) {
      List<Book> books = new ArrayList<Book>();
      books.add(new Book("Book1", "url1"));
      books.add(new Book("Book2", "url2"));

      receiver.onReceiveResult(BOOKS_FETCHED_RESULT_CODE, books);
   }

}
