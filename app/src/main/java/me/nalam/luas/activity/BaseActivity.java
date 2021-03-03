package me.nalam.luas.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ir.drax.netwatch.NetWatch;
import ir.drax.netwatch.cb.NetworkChangeReceiver_navigator;
import me.nalam.luas.R;

public abstract class BaseActivity extends AppCompatActivity
    implements NetworkChangeReceiver_navigator {
  private final String TAG = BaseActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.i(TAG, "onCreate");
    super.onCreate(savedInstanceState);

    NetWatch.builder(this)
        .setCallBack(this)
        .setNotificationEnabled(false)
        .build();
  }

  @Override
  public void onConnected(int source) {
    Log.i(TAG, "Network connected");
  }

  @Override
  public void onDisconnected() {
    Log.i(TAG, "Network disconnected");
    Toast.makeText(this, getString(R.string.netwatch_lost_connection), Toast.LENGTH_SHORT).show();
  }
}
