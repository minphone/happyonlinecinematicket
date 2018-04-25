package co.minphone.happyonlinecinematicket.Viewable;

import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;
import java.util.List;

public interface RegisterView<T extends Presentable> extends Viewable<T> {
  void renderRegion(List<RegionVO> regionVO);

  void renderError(String message);

  void renderHomeScreen();
}
