package co.minphone.happyonlinecinematicket.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.minphone.happyonlinecinematicket.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity
    implements TextureView.SurfaceTextureListener {

  @BindView(R.id.trailer) TextureView trailer;

  private static final String EMAIL = "email";

  private Unbinder unbinder;
  private MediaPlayer mediaPlayer;
  private CallbackManager callbackManager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    unbinder = ButterKnife.bind(this, this);
    trailer.setSurfaceTextureListener(this);
    registerFacebook();
  }

  @Override protected void onResume() {
    super.onResume();
    if (mediaPlayer != null) {
      mediaPlayer.start();
    }
  }

  @Override protected void onPause() {
    super.onPause();
    if (mediaPlayer != null) {
      mediaPlayer.stop();
    }
  }

  @Override protected void onStop() {
    super.onStop();
    unbinder.unbind();
    if (mediaPlayer != null) {
      mediaPlayer = null;
    }
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
    Surface s = new Surface(surface);

    try {
      mediaPlayer = new MediaPlayer();
      mediaPlayer.setDataSource(getApplicationContext(),
          Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.trailer));
      mediaPlayer.setSurface(s);
      mediaPlayer.prepare();
      mediaPlayer.setLooping(true);
      mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
      scaleVideo(mediaPlayer);
      mediaPlayer.start();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

  }

  @Override public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
    return false;
  }

  @Override public void onSurfaceTextureUpdated(SurfaceTexture surface) {

  }

  @OnClick(R.id.btn_facebook) void onFacebookClick() {
    LoginManager.getInstance().logOut();
    LoginManager.getInstance()
        .logInWithReadPermissions(this, Arrays.asList("public_profile, email"));
  }

  private void scaleVideo(MediaPlayer mediaPlayer) {
    RelativeLayout.LayoutParams videoParams = (RelativeLayout.LayoutParams) trailer
        .getLayoutParams();
    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay()
        .getMetrics(dm);

    final int height = dm.heightPixels;
    final int width = dm.widthPixels;
    int videoHeight = mediaPlayer.getVideoHeight();
    int videoWidth = mediaPlayer.getVideoWidth();
    double hRatio = 1;

    hRatio = (height * 1.0 / videoHeight) / (width * 1.0 / videoWidth);
    videoParams.width = (int) (hRatio <= 1 ? 0 : Math.round((-(hRatio - 1) / 2)
        * width));
    videoParams.height = (int) (hRatio >= 1 ? 0 : Math
        .round((((-1 / hRatio) + 1) / 2) * height));
    videoParams.width = width - videoParams.width - videoParams.width;
    videoParams.height = height - videoParams.height - videoParams.height;
    trailer.setScaleX(
        1.00001f);
    trailer.requestLayout();
    trailer.invalidate();
  }

  private void registerFacebook() {
    callbackManager = CallbackManager.Factory.create();

    LoginManager.getInstance().registerCallback(callbackManager,
        new FacebookCallback<LoginResult>() {
          @Override public void onSuccess(LoginResult loginResult) {
            if (loginResult.getAccessToken() != null) {
              GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                  new GraphRequest.GraphJSONObjectCallback() {
                    @Override public void onCompleted(JSONObject object, GraphResponse response) {
                      try {
                        Toast.makeText(getApplicationContext(),
                            "Id "
                                + object.getString("id")
                                + " Name "
                                + object.getString("name")
                                + " Email "
                                + object.getString("email"),
                            Toast.LENGTH_LONG).show();
                      } catch (JSONException e) {
                        e.fillInStackTrace();
                      }
                    }
                  });
            }
          }

          @Override public void onCancel() {

          }

          @Override public void onError(FacebookException error) {

          }
        });
  }
}
