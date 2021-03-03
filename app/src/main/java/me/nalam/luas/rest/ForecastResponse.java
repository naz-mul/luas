package me.nalam.luas.rest;

import me.nalam.luas.entity.LuasForecastEntity;
import org.simpleframework.xml.Root;

@Root(name = "stopInfo", strict = false)
public class ForecastResponse {
  private LuasForecastEntity luasForecastEntity;

  private String error;
}
