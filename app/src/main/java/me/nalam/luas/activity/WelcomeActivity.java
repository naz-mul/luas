package me.nalam.luas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import me.nalam.luas.R;
import me.nalam.luas.util.DateUtil;

public class WelcomeActivity extends BaseActivity {

  private final String TAG = WelcomeActivity.class.getSimpleName();
  public static final String AM_FORECAST = "AM_FORECAST";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.i(TAG, "onCreate");
    super.onCreate(savedInstanceState);

    new Handler().postDelayed(() -> {
      Log.i(TAG, "waited 2 secs to start LuasForecastActivity");
      startMainActivity();
    }, 1000);
  }

  @Override
  protected void onPause() {
    Log.i(TAG, "onPause");
    super.onPause();
    if (isFinishing()) {
      overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
  }

  @Override
  public void onDisconnected() {
    Log.i(TAG, "Network disconnected");
  }

  private boolean isMorningLuasForecast() {
    return DateUtil.checkBetween(DateUtil.getCurrentTime(), "00:00:00.000", "12:00:59.999");
  }

  private void startMainActivity() {
    Intent luasActivity = new Intent(this, LuasForecastActivity.class);
    luasActivity.putExtra(AM_FORECAST, isMorningLuasForecast());
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    startActivity(luasActivity);
    finish();
  }
}
