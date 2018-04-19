package co.minphone.happyonlinecinematicket.presenter;

import co.minphone.happyonlinecinematicket.Viewable.MoviesView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import javax.inject.Inject;

public class MoviesPresenter extends BasePresenter<MoviesView> {

  private final DataManager dataManager;

  @Inject public MoviesPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void test() {

  }
}

