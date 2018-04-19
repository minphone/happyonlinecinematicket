package co.minphone.happyonlinecinematicket.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.LogInView;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.presenter.LogInPresenter;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import dagger.android.AndroidInjection;
import java.io.IOException;
import java.util.Arrays;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends BaseActivity<LogInPresenter>
    implements TextureView.SurfaceTextureListener, LogInView<LogInPresenter> {

  @BindView(R.id.trailer) TextureView trailer;
  @BindView(R.id.btn_facebook) Button btnFacebook;

  private MediaPlayer mediaPlayer;
  private CallbackManager callbackManager;

  @Inject @Override public void injectPresenter(LogInPresenter presenter) {
    super.injectPresenter(presenter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
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
    if (mediaPlayer != null) {
      mediaPlayer = null;
    }
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_login;
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    callbackManager.onActivityResult(requestCode, resultCode, data);
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

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void renderError(String message) {
    showSnakeBar(message);
  }

  @Override public void renderHomeScreen() {
    MoviesActivity.start(this);
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
                        String profilePic = "";
                        if (object.has("picture")) {
                          profilePic = object.getJSONObject("picture")
                              .getJSONObject("data")
                              .getString("url");
                        }
                        presenter.logInUser(AccessToken.getCurrentAccessToken().getUserId(),
                            object.getString("name"), object.getString("email"),
                            object.getString("gender"), profilePic);
                        /*RegisterActivity.start(LogInActivity.this, object.getString("name"),
                            object.getString("email"), object.getString("gender"));*/
                      } catch (JSONException e) {
                        e.fillInStackTrace();
                      }
                    }
                  });
              Bundle parameters = new Bundle();
              parameters.putString("fields", "id,name,email,gender,picture.type(large)");
              request.setParameters(parameters);
              request.executeAsync();
            }
          }

          @Override public void onCancel() {
            Log.d("Cancel", "Testing");
          }

          @Override public void onError(FacebookException error) {
            Log.d("Error", error.getMessage());
            showSnakeBar("Check Your Internet Connection");
          }
        });
  }

  private void showSnakeBar(String msg) {
    Snackbar.make(trailer, msg, Snackbar.LENGTH_LONG).show();
  }
}
