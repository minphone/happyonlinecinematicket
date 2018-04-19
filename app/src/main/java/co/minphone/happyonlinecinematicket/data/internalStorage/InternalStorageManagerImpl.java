package co.minphone.happyonlinecinematicket.data.internalStorage;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;

public class InternalStorageManagerImpl implements InternalStorageManager {

  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor editor;
  private static final String PREF_KEY_FIRST = "first";

  @Inject public InternalStorageManagerImpl(Context context) {
    sharedPreferences = context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
    editor = sharedPreferences.edit();
  }

  @Override public void updateFirstTime() {
    editor.putBoolean(PREF_KEY_FIRST, true).apply();
  }

  @Override public boolean getIsFirstTime() {
    return sharedPreferences.getBoolean(PREF_KEY_FIRST, false);
  }
}
