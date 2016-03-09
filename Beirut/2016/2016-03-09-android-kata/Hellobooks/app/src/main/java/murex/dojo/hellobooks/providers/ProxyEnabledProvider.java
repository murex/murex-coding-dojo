package murex.dojo.hellobooks.providers;

import static murex.dojo.hellobooks.app.Constants.BOOKS_FETCHED_RESULT_CODE;

import java.util.List;

import murex.dojo.hellobooks.app.Book;
import murex.dojo.hellobooks.app.BooksJsonParser;
import murex.dojo.hellobooks.app.Constants;
import murex.dojo.hellobooks.app.MyResultReceiver.Receiver;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;
import android.util.Log;

public class ProxyEnabledProvider extends BooksProvider {

   @Override
   public void fetchBooks(Context context, final Receiver receiver) {
      RequestQueue queue = Volley.newRequestQueue(context);
      queue.add(new StringRequest(Request.Method.GET, Constants.BOOKS_URL,
        new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
              List<Book> booksList = BooksJsonParser.parseJsonStringIntoBooksList(response);
              receiver.onReceiveResult(BOOKS_FETCHED_RESULT_CODE, booksList);
           }
        }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
            Log.d("error", error.getMessage());
         }

      }));
   }

}