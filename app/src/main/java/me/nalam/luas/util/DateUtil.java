package me.nalam.luas.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

  private static final String TAG = DateUtil.class.getSimpleName();
  private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss.SSS";

  private DateUtil() {
  }

  private static SimpleDateFormat getSimpleDateFormat() {
    return new SimpleDateFormat(DEFAULT_TIME_FORMAT, Locale.UK);
  }

  public static String getCurrentTime() {
    return getSimpleDateFormat().format(new Date());
  }

  public static boolean checkBetween(@Nullable String currentTime, @NonNull String startTime, @NonNull String endTime) {
    boolean res = false;
    try {
      Date requestDate;
      if (TextUtils.isEmpty(currentTime))
        requestDate = getSimpleDateFormat().parse(getCurrentTime());
      else
        requestDate = getSimpleDateFormat().parse(currentTime);

      Date fromDate = getSimpleDateFormat().parse(startTime);
      Date toDate = getSimpleDateFormat().parse(endTime);
      res = requestDate.compareTo(fromDate) >= 0 && requestDate.compareTo(toDate) <= 0;
    } catch (ParseException pex) {
      Log.e(TAG, "parsing error", pex);
    }
    return res;
  }
}
