package me.nalam.luas.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "luas_forecast")
public class LuasForecastEntity {

  //TODO replace indexed id -- start from beginning
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  private int id;

  @NonNull
  @ColumnInfo(name = "message")
  private String message;

  @NonNull
  @ColumnInfo(name = "direction")
  private String directionName;

  @NonNull
  @ColumnInfo(name = "due")
  private String dueMins;

  @NonNull
  @ColumnInfo(name = "destination")
  private String destination;

  public LuasForecastEntity() {
    this.message = "Green Line services operating normally";
    this.directionName = "Inbound";
    this.dueMins = "4";
    this.destination = "Broombridge";
  }

  public LuasForecastEntity(@NonNull String message, @NonNull String directionName, @NonNull String dueMins,
      @NonNull String destination) {
    this.message = message;
    this.directionName = directionName;
    this.dueMins = dueMins;
    this.destination = destination;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @NonNull
  public String getMessage() {
    return message;
  }

  public void setMessage(@NonNull String message) {
    this.message = message;
  }

  public String getDirectionName() {
    return directionName;
  }

  public void setDirectionName(String directionName) {
    this.directionName = directionName;
  }

  public String getDueMins() {
    return dueMins;
  }

  public void setDueMins(String dueMins) {
    this.dueMins = dueMins;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  @Override
  public String toString() {
    return "LuasForecast{" +
        "id=" + id +
        ", message='" + message + '\'' +
        ", directionName='" + directionName + '\'' +
        ", dueMins='" + dueMins + '\'' +
        ", destination='" + destination + '\'' +
        '}';
  }
}
