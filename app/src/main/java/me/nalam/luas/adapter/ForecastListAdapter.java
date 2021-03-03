package me.nalam.luas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.nalam.luas.R;
import me.nalam.luas.entity.LuasForecastEntity;

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {

  private static final String TAG = ForecastListAdapter.class.getSimpleName();
  private final LayoutInflater mInflater;
  private List<LuasForecastEntity> mLuasForecastEntities;

  public ForecastListAdapter(Context context) {
    this.mInflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View forecastItemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
    return new ForecastViewHolder(forecastItemView);
  }

  @Override
  public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
    if (mLuasForecastEntities != null) {
      LuasForecastEntity currentForecastItem = mLuasForecastEntities.get(position);
//      holder.mMessageTv.setText(currentForecastItem.getMessage());
//      holder.mBoundTv.setText(currentForecastItem.getDirectionName());
      holder.mDestinationTv.setText(currentForecastItem.getDestination());
      holder.mDueMinsTv.setText(currentForecastItem.getDueMins());
    } else {
      Log.i(TAG, "No forecasts available");
//      holder.mBoundTv.setText("No trams forecast");
    }
  }

  @Override
  public int getItemCount() {
    return mLuasForecastEntities != null ? mLuasForecastEntities.size() : 0;
  }

  public void setLuasForecasts(List<LuasForecastEntity> luasForecastEntities) {
    this.mLuasForecastEntities = luasForecastEntities;
    notifyDataSetChanged();
  }

  public class ForecastViewHolder extends RecyclerView.ViewHolder {

//    private final TextView mMessageTv;
//    private final TextView mBoundTv;
    private final TextView mDestinationTv;
    private final TextView mDueMinsTv;

    private ForecastViewHolder(View itemView) {
      super(itemView);
//      mMessageTv = itemView.findViewById(R.id.tv_message);
//      mBoundTv = itemView.findViewById(R.id.tv_bound);
      mDestinationTv = itemView.findViewById(R.id.tv_destination);
      mDueMinsTv = itemView.findViewById(R.id.tv_duration);
    }
  }
}
