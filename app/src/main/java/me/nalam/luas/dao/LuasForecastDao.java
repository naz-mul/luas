package me.nalam.luas.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import me.nalam.luas.entity.LuasForecastEntity;

@Dao
public interface LuasForecastDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(LuasForecastEntity luasForecastEntity);

  @Query("DELETE FROM luas_forecast")
  void deleteAll();

  @Query("SELECT * from luas_forecast ORDER BY direction ASC")
  LiveData<List<LuasForecastEntity>> getAllForecasts();
}
