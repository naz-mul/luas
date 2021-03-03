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

public class LuasAdapterDelegate extends AdapterDelegate<List<Tram>> {

  private final LayoutInflater inflater;

  public LuasAdapterDelegate(LayoutInflater inflater, int viewType) {
    super();
    this.inflater = inflater;
  }

  @Override
  public boolean isForViewType(@NonNull List<Tram> trams, int position) {
    Tram tram = trams.get(position);
    return !tram.getDestination().isEmpty();
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
    return new LuasViewHolder(inflater.inflate(R.layout.row_stop, parent, false));
  }

  @Override
  protected void onBindViewHolder(@NonNull List<Tram> trams, int position, @NonNull ViewHolder viewHolder,
      @NonNull List<Object> payloads) {
    LuasViewHolder holder = (LuasViewHolder) viewHolder;
    Tram tram = trams.get(position);

    holder.destination.setText(tram.getDestination());
    holder.time.setText(tram.getDueTime());
  }

  public static class LuasViewHolder extends RecyclerView.ViewHolder {

    public final TextView destination;
    public final TextView time;

    public LuasViewHolder(View v) {
      super(v);
      destination = v.findViewById(R.id.destination);
      time = v.findViewById(R.id.time);
    }
  }
}

