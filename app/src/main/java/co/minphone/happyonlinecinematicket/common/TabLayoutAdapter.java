package co.minphone.happyonlinecinematicket.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinPhone on 3/18/18.
 */

public class TabLayoutAdapter extends FragmentStatePagerAdapter {

  private List<Fragment> fragmentList = new ArrayList<>();
  private List<String> titleList = new ArrayList<>();

  public TabLayoutAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return fragmentList.get(position);
  }

  @Override public int getCount() {
    return fragmentList.size();
  }

  @Override public CharSequence getPageTitle(int position) {
    return titleList.get(position);
  }

  public void addTab(Fragment fragment, String title) {
    fragmentList.add(fragment);
    titleList.add(title);
  }
}
