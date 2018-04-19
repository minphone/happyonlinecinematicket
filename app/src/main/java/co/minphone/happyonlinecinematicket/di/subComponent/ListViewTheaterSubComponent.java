package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.fragment.ListViewTheaterFragment;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface ListViewTheaterSubComponent
    extends AndroidInjector<ListViewTheaterFragment> {
  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<ListViewTheaterFragment> {
  }
}
