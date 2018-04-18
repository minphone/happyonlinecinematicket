package co.minphone.happyonlinecinematicket.utilities;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.minphone.happyonlinecinematicket.R;
import java.util.ArrayList;
import java.util.List;

public class ImageViewPagerAdapter extends PagerAdapter {

  private List<String> imageList;

  public ImageViewPagerAdapter() {
    imageList = new ArrayList<>();
  }

  @Override public int getCount() {
    // TODO: 4/11/18 need to set imageList size
    return 4;
  }

  @Override public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
    return view == (ImageView) object;
  }

  @NonNull @Override public Object instantiateItem(@NonNull ViewGroup container, int position) {
    View itemView = LayoutInflater.from(container.getContext())
        .inflate(R.layout.view_movie_details, container, false);
    ImageView imageView = itemView.findViewById(R.id.iv_movie_details_hero);
    imageView.setImageResource(R.mipmap.movie_sample);

    container.addView(itemView);
    return itemView;
  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((ImageView) object);
  }

  public void setImageData(List<String> imageList) {
    this.imageList = imageList;
  }
}
