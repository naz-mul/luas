package me.nalam.luas.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import me.nalam.luas.dao.LuasForecastDao;
import me.nalam.luas.db.LuasForecastRoomDb;
import me.nalam.luas.entity.LuasForecastEntity;

public class LuasForecastRepository {

  private LuasForecastDao mLuasForecastDao;
  private LiveData<List<LuasForecastEntity>> mAllLuasForecasts;

  public LuasForecastRepository(Application application) {
    LuasForecastRoomDb db = LuasForecastRoomDb.getDatabase(application);
    this.mLuasForecastDao = db.luasForecastDao();
    this.mAllLuasForecasts = mLuasForecastDao.getAllForecasts();
  }

  public LiveData<List<LuasForecastEntity>> getAllLuasForecasts() {
    return mAllLuasForecasts;
  }

  public void insert(LuasForecastEntity luasForecastEntity) {
    LuasForecastRoomDb.databaseWriteExecutor.execute(() -> mLuasForecastDao.insert(luasForecastEntity));
  }

}
