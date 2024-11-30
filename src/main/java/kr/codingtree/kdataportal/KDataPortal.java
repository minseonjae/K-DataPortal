package kr.codingtree.kdataportal;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kr.codingtree.kdataportal.data.DataFetcher;
import kr.codingtree.kdataportal.service.BusService;
import kr.codingtree.kdataportal.service.CityService;
import kr.codingtree.kdataportal.util.URLBuilder;
import kr.codingtree.kdataportal.key.DataPortalKey;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.HashMap;

@UtilityClass
public class KDataPortal {

    public final String CITY_CODE_LIST_SERVICE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCtyCodeList";
    public final String BUS_STTN_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";
    public final String BUS_ROUTE_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteInfoIem";
    public final String BUS_LOCATION_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusLcInfoInqireService/getRouteAcctoBusLcList";
    public final String BUS_ARRIVAL_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList";

    @Getter
    private BusService busService = new BusService();

    @Getter
    private CityService cityService = new CityService();

    public String getRouteInfo(int cityCode, String routeId) {
        URLBuilder builder = new URLBuilder(BUS_ROUTE_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("cityCode", String.valueOf(cityCode))  // 도시 코드
                .append("routeId", routeId);                   // 노선 ID

        return DataFetcher.fetchData(builder);
    }

    public String getLocationInfo(int pageNo, int numOfRows, int cityCode, String routeId) {
        URLBuilder builder = new URLBuilder(BUS_LOCATION_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", String.valueOf(pageNo))        // 페이지 번호
                .append("numOfRows", String.valueOf(numOfRows))  // 한 페이지 결과 수
                .append("cityCode", String.valueOf(cityCode))    // 도시 코드
                .append("routeId", routeId);                     // 노선 ID

        return DataFetcher.fetchData(builder);
    }

    public String getArrivalInfo() {
        URLBuilder builder = new URLBuilder(BUS_ARRIVAL_INFO_SERVICE_URL);
        builder.append("serviceKey", DataPortalKey.USER_KEY).append("_type", "json")
                .append("pageNo", "1")           // 페이지 번호
                .append("numOfRows", "10")       // 한 페이지 결과 수
                .append("cityCode", "25")        // 도시 코드
                .append("nodeId", "DJB8001793"); // 정류장 ID

        return DataFetcher.fetchData(builder);
    }
}
