package me.nalam.luas.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import me.nalam.luas.entity.LuasForecastEntity;
import me.nalam.luas.repository.LuasForecastRepository;

public class LuasForecastViewModel extends AndroidViewModel {

  private LuasForecastRepository mLuasForecastRepo;

  private LiveData<List<LuasForecastEntity>> mAllLuasForecast;

  public LuasForecastViewModel(Application application) {
    super(application);
    this.mLuasForecastRepo = new LuasForecastRepository(application);
    this.mAllLuasForecast = mLuasForecastRepo.getAllLuasForecasts();
  }

  public LiveData<List<LuasForecastEntity>> getAllLuasForecast() {
    return mAllLuasForecast;
  }

  public void insert(LuasForecastEntity luasForecastEntity) {
    mLuasForecastRepo.insert(luasForecastEntity);
  }

}
