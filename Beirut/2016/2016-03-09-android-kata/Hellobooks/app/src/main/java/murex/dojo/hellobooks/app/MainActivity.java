package murex.dojo.hellobooks.app;

import static murex.dojo.hellobooks.app.Constants.BOOKS_FETCHED_RESULT_CODE;
import static murex.dojo.hellobooks.app.Constants.DEFAULT_RESULT_CODE;
import static murex.dojo.hellobooks.app.Constants.RECEIVER_TAG;
import static murex.dojo.hellobooks.app.Constants.SERVICE_TAG;
import static murex.dojo.hellobooks.providers.BooksProvider.booksProvider;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements MyResultReceiver.Receiver {

   public static boolean PROXY_ENABLED = true;
   private RecyclerView mRecyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      startTimerService();
      setupRecyclerView();
   }

   private void startTimerService() {
      MyResultReceiver mReceiver = new MyResultReceiver(new Handler());
      mReceiver.setReceiver(this);

      Intent timerIntent = new Intent(this, TimerService.class);
      timerIntent.putExtra(RECEIVER_TAG, mReceiver);
      startService(timerIntent);
   }

   private void setupRecyclerView() {
      mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
      mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
      booksProvider().fetchBooks(this,this);
   }

   @Override
   public void onReceiveResult(int resultCode, Object resultData) {
      switch (resultCode) {
      case BOOKS_FETCHED_RESULT_CODE:
         final Adapter mAdapter = new BooksAdapter((List<Book>) resultData, this, mRecyclerView);
         mRecyclerView.setAdapter(mAdapter);
         break;
      case DEFAULT_RESULT_CODE:
         final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
         bar.setProgress(Integer.valueOf(((Bundle) resultData).getString(SERVICE_TAG)));
         break;
      }
   }
}