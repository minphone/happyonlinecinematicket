package co.minphone.happyonlinecinematicket.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import co.minphone.happyonlinecinematicket.R;

public class SplashActivity extends AppCompatActivity {

  private Unbinder unbinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    unbinder = ButterKnife.bind(this, this);
  }

  @Override protected void onStop() {
    super.onStop();
    unbinder.unbind();
  }
}
