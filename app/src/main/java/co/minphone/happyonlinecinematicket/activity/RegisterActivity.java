package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseActivity;

public class RegisterActivity extends BaseActivity {

  private static final String USERNAME = "UserName";
  private static final String EMAIL = "Email";
  private static final String GENDER = "Gender";

  private String userName;
  private String gender;
  private String email;

  @BindView(R.id.tv_email) TextView tvEmail;
  @BindView(R.id.tv_user_name) TextView tvUserName;
  @BindView(R.id.spinner_sex) AppCompatSpinner spinnerSex;
  @BindView(R.id.spinner_location) AppCompatSpinner spinnerLoaction;

  public static void start(Context context, String userName, String email, String gender) {
    Intent starter = new Intent(context, RegisterActivity.class);
    starter.putExtra(USERNAME, userName);
    starter.putExtra(EMAIL, email);
    starter.putExtra(GENDER, gender);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      userName = bundle.getString(USERNAME);
      email = bundle.getString(EMAIL);
      gender = bundle.getString(GENDER);
      bindData();
    }
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_register;
  }

  private void bindData() {
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
  }
}
