package kr.codingtree.kdataportal.service;

import com.google.gson.Gson;
import kr.codingtree.kdataportal.KDataPortal;
import kr.codingtree.kdataportal.data.DataFetcher;
import kr.codingtree.kdataportal.key.DataPortalKey;
import kr.codingtree.kdataportal.model.NearbyStationsResponse;
import kr.codingtree.kdataportal.util.URLBuilder;

public class BusService {

    public NearbyStationsResponse getNearbyStations(int pageNo, int numOfRows, double gpsLati, double gpsLong) {
        URLBuilder builder = new URLBuilder(KDataPortal.BUS_STTN_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))         // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))   // 한 페이지 결과 수
                .append("gpsLati", String.valueOf(gpsLati))       // WGS84 위도 37.67777
                .append("gpsLong", String.valueOf(gpsLong));      // WGS84 경도 126.79619

        return new Gson().fromJson(DataFetcher.fetchData(builder), NearbyStationsResponse.class);
    }

}
