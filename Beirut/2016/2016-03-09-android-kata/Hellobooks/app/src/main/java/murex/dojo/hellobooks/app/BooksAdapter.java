package murex.dojo.hellobooks.app;

import static murex.dojo.hellobooks.app.Constants.NAME;

import java.util.List;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> implements View.OnClickListener {

   private final List<Book> booksList;
   private final Context context;
   private final RecyclerView mRecyclerView;

   public BooksAdapter(List<Book> booksList, Context context, RecyclerView mRecyclerView) {
      this.booksList = booksList;
      this.context = context;
      this.mRecyclerView = mRecyclerView;
   }

   @Override
   public void onClick(View view) {
      int itemPosition = mRecyclerView.getChildPosition(view);
      String bookName = booksList.get(itemPosition).title();
      showBookDetails(bookName);
   }

   private void showBookDetails(String bookName) {
      final Intent detailsIntent = new Intent(context, BookDetails.class);
      detailsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      detailsIntent.putExtra(NAME, bookName);
      context.startActivity(detailsIntent);
   }

   @Override
   public BooksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list_item, parent, false);
      v.setOnClickListener(this);
      return new ViewHolder(v);
   }

   @Override
   public void onBindViewHolder(BooksAdapter.ViewHolder holder, int position) {
      holder.titleTextView.setText(booksList.get(position).title());
      Glide.with(context).load(booksList.get(position).imageUrl()).into(holder.thumbnailImageView);
   }

   @Override
   public int getItemCount() {
      return booksList.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {

      public TextView titleTextView;
      public ImageView thumbnailImageView;

      public ViewHolder(View itemView) {
         super(itemView);

         titleTextView = (TextView) itemView.findViewById(R.id.book_title_text_view);
         thumbnailImageView = (ImageView) itemView.findViewById(R.id.book_thumbnail_image_view);
      }
   }
}
