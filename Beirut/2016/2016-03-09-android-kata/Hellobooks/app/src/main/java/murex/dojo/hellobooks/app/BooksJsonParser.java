package murex.dojo.hellobooks.app;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class BooksJsonParser {

    public static List<Book> parseJsonStringIntoBooksList(String jsonString) {
        ArrayList<Book> booksListFromJson = new ArrayList<Book>();
        try {
            JSONObject jsonStringAsObject = new JSONObject(jsonString);
            JSONArray itemsJsonArray = jsonStringAsObject.getJSONArray("items");
            for (int i = 0; i < itemsJsonArray.length(); i++) {
                JSONObject volumeInfoObject = itemsJsonArray.getJSONObject(i).getJSONObject("volumeInfo");
                String bookTitle = volumeInfoObject.getString("title");

                JSONObject imageLinksObject = volumeInfoObject.getJSONObject("imageLinks");
                String imageUrl = imageLinksObject.getString("thumbnail");

                Book book = new Book(bookTitle, imageUrl);
                booksListFromJson.add(book);
            }
        } catch (JSONException ex) {
            Log.d("JSON Exception", ex.getMessage());
        }
        return booksListFromJson;
    }
}
