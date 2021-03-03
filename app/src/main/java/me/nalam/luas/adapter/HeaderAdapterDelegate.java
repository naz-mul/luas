package me.nalam.luas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate;
import java.util.List;
import me.nalam.luas.R;
import me.nalam.luas.rest.model.Tram;

public class HeaderAdapterDelegate extends AdapterDelegate<List<Tram>> {

  private final LayoutInflater inflater;

  public HeaderAdapterDelegate(LayoutInflater inflater, int viewType) {
    super();
    this.inflater = inflater;
  }

  @Override
  public boolean isForViewType(@NonNull List<Tram> trams, int position) {
    Tram tram = trams.get(position);
    return !tram.getDueTime().isEmpty() && tram.getDestination().isEmpty();
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
    return new HeaderViewHolder(inflater.inflate(R.layout.row_header, parent, false));
  }

  @Override
  protected void onBindViewHolder(@NonNull List<Tram> trams, int position, @NonNull ViewHolder viewHolder,
      @NonNull List<Object> payloads) {
    HeaderViewHolder holder = (HeaderViewHolder) viewHolder;
    Tram tram = trams.get(position);

    holder.message.setText(tram.getDueTime());
  }

  public static class HeaderViewHolder extends RecyclerView.ViewHolder {

    public final TextView message;

    public HeaderViewHolder(View v) {
      super(v);
      message = v.findViewById(R.id.destination);
    }
  }
}
