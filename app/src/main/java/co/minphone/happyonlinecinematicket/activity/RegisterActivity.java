package co.minphone.happyonlinecinematicket.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.RegisterView;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.presenter.RegisterPresenter;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterActivity extends BaseActivity<RegisterPresenter>
    implements RegisterView<RegisterPresenter> {

  private static final String USERNAME = "UserName";
  private static final String EMAIL = "Email";
  private static final String GENDER = "Gender";
  private static final String FACEBOOKID = "facebookId";
  private static final String PROFILEURL = "profileURL";

  @SuppressLint("UseSparseArrays") private HashMap<String, Integer> regionList = new HashMap<>();
  private String userName;
  private String gender;
  private String email;
  private String facebookId;
  private String profileUrl;

  @BindView(R.id.tv_email) TextView tvEmail;
  @BindView(R.id.tv_user_name) TextView tvUserName;
  @BindView(R.id.spinner_sex) AppCompatSpinner spinnerSex;
  @BindView(R.id.spinner_location) AppCompatSpinner spinnerLoaction;
  @BindView(R.id.progress_bar) ProgressBar progressBar;

  public static void start(Context context, String facebookId, String userName, String email,
      String gender, String profileUrl) {
    Intent starter = new Intent(context, RegisterActivity.class);
    starter.putExtra(USERNAME, userName);
    starter.putExtra(EMAIL, email);
    starter.putExtra(GENDER, gender);
    starter.putExtra(FACEBOOKID, facebookId);
    starter.putExtra(PROFILEURL, profileUrl);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
    Bundle bundle = getIntent().getExtras();
    presenter.getRegions();
    if (bundle != null) {
      userName = bundle.getString(USERNAME);
      email = bundle.getString(EMAIL);
      gender = bundle.getString(GENDER);
      facebookId = bundle.getString(FACEBOOKID);
      profileUrl = bundle.getString(PROFILEURL);
    }
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_register;
  }

  @Override public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    progressBar.setVisibility(View.GONE);
  }

  @Override public void renderRegion(List<RegionVO> regionVO) {
    progressBar.setVisibility(View.GONE);
    bindData(regionVO);
  }

  @Override public void renderError(String message) {
    progressBar.setVisibility(View.GONE);
    showSnackBar(message);
  }

  @Override public void renderHomeScreen() {
    MoviesActivity.start(this);
  }

  @OnClick(R.id.btn_register) void onRegisterClick() {
    String gender = spinnerSex.getSelectedItem().toString();
    String location = spinnerLoaction.getSelectedItem().toString();
    presenter.registerUser(facebookId, userName, email, gender, regionList.get(location),
        profileUrl);
  }

  private void bindData(List<RegionVO> regionVOs) {
    if (userName != null) {
      if (userName.length() > 0) {
        tvUserName.setText(userName);
      }
    }
    if (email != null) {
      if (email.length() > 0) {
        tvEmail.setText(email);
      }
    }
    if (gender != null) {
      if (gender.equals("male")) {
        spinnerSex.setSelection(1);
      } else if (gender.equals("female")) {
        spinnerSex.setSelection(2);
      }
    }
    List<String> regionNames = new ArrayList<>();
    for (RegionVO regionVO : regionVOs) {
      regionList.put(regionVO.getRegionName(), regionVO.getId());
      regionNames.add(regionVO.getRegionName());
    }
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, regionNames);
    spinnerLoaction.setAdapter(dataAdapter);
  }

  private void showSnackBar(String msg) {
    Snackbar.make(progressBar, msg, Snackbar.LENGTH_LONG).show();
  }
}
