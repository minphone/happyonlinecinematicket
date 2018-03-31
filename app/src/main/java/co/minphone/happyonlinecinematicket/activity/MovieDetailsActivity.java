package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseActivity;

public class MovieDetailsActivity extends BaseActivity {

  public static void start(Context context) {
      Intent starter = new Intent(context, MovieDetailsActivity.class);
      context.startActivity(starter);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_movie_detail;
  }
}
