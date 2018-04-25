package co.minphone.happyonlinecinematicket.Viewable;

import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;

public interface LogInView<T extends Presentable> extends Viewable<T> {
  void renderError(String message);

  void renderHomeScreen();

  void renderRegistrationScreen(String userId, String name, String email, String gender,
      String profilePic);
}
