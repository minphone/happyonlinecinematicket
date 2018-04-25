package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.TextureView;
import android.widget.Button;
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
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends BaseActivity<LogInPresenter>
    implements LogInView<LogInPresenter> {

  @BindView(R.id.btn_facebook) Button btnFacebook;

  private MediaPlayer mediaPlayer;
  private CallbackManager callbackManager;

  public static void start(Context context) {
    Intent starter = new Intent(context, LogInActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
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
    Snackbar.make(btnFacebook, msg, Snackbar.LENGTH_LONG).show();
  }
}
