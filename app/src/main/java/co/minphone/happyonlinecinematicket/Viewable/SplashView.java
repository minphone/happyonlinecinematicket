package co.minphone.happyonlinecinematicket.Viewable;

import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;

public interface SplashView<T extends Presentable> extends Viewable<T> {
  void renderData(Boolean aBoolean);

  void renderError(String message);
}
