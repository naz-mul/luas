package me.nalam.luas.db;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.nalam.luas.dao.LuasForecastDao;
import me.nalam.luas.entity.LuasForecastEntity;

@Database(entities = {LuasForecastEntity.class}, version = 1, exportSchema = false)
public abstract class LuasForecastRoomDb extends RoomDatabase {

  private static volatile LuasForecastRoomDb INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;
  public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public static LuasForecastRoomDb getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (LuasForecastRoomDb.class) {
        if (INSTANCE == null) {
          INSTANCE =
              Room.databaseBuilder(
                      context.getApplicationContext(), LuasForecastRoomDb.class, "luas_forecast_db")
                  .fallbackToDestructiveMigration()
                  .addCallback(sRoomDbCallback)
                  .build();
        }
      }
    }
    return INSTANCE;
  }

  private static RoomDatabase.Callback sRoomDbCallback = new RoomDatabase.Callback() {
    //TODO change from onOpen to onCreate
    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      databaseWriteExecutor.execute(() -> {
        LuasForecastDao dao = INSTANCE.luasForecastDao();
        dao.deleteAll();

        LuasForecastEntity forecast = new LuasForecastEntity();
        for (byte i = 0; i < 2; i++) {
          dao.insert(forecast);
        }
      });
    }
  };

  public abstract LuasForecastDao luasForecastDao();
}
