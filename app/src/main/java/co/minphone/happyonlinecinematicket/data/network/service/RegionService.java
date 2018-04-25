package co.minphone.happyonlinecinematicket.data.network.service;

import co.minphone.happyonlinecinematicket.data.network.URL;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RegionService {
  @GET(URL.GETREGIONS) Call<List<RegionVO>> getRegions();
}
