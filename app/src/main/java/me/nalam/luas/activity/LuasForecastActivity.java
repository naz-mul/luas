package me.nalam.luas.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import me.nalam.luas.R;
import me.nalam.luas.adapter.ForecastListAdapter;
import me.nalam.luas.viewmodel.LuasForecastViewModel;

public class LuasForecastActivity extends BaseActivity {

  private static final String TAG = LuasForecastActivity.class.getSimpleName();
  private LuasForecastViewModel mLuasForecastViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    CollapsingToolbarLayout toolBarLayout = findViewById(R.id.toolbar_layout);
    toolBarLayout.setTitle(getTitle());

    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    final ForecastListAdapter adapter = new ForecastListAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    mLuasForecastViewModel = new ViewModelProvider(this).get(LuasForecastViewModel.class);
    mLuasForecastViewModel.getAllLuasForecast().observe(this, adapter::setLuasForecasts);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> Toast.makeText(this, "Refreshed forecast", Toast.LENGTH_SHORT).show());

    Bundle bundle = getIntent().getExtras();
    boolean morningLuasForecast = bundle.getBoolean(WelcomeActivity.AM_FORECAST, false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}