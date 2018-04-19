package co.minphone.happyonlinecinematicket.data.internalStorage;

import android.content.Context;
import android.content.SharedPreferences;

public class InternalStorageManagerImpl implements InternalStorageManager {

  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor editor;
  private static final String PREF_KEY_FIRST = "first";

  public InternalStorageManagerImpl(Context context) {
    sharedPreferences = context.getSharedPreferences("SharedPerences", Context.MODE_PRIVATE);
    editor = sharedPreferences.edit();
  }

  @Override public void updateFirstTime() {
    editor.putBoolean(PREF_KEY_FIRST, true).apply();
  }

  @Override public boolean getFirstTime() {
    return sharedPreferences.getBoolean(PREF_KEY_FIRST, false);
  }
}
