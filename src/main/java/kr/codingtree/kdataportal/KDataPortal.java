package kr.codingtree.kdataportal;

import kr.codingtree.kdataportal.service.BusService;
import kr.codingtree.kdataportal.service.CityService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class KDataPortal {

    @Getter
    @Setter
    public boolean debugMode = false;

    public final String CITY_CODE_LIST_SERVICE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCtyCodeList";


    // GPS 기반 근처 500m 안 정류장 검색  :  https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098534
    public final String BUS_STTN_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getCrdntPrxmtSttnList";

    // 정류장 경유 노선 조회
    public final String BUS_ROUTES_BY_STATION_URL = "http://apis.data.go.kr/1613000/BusSttnInfoInqireService/getSttnThrghRouteList";


    // 버스 노선 기본 정보 조회  :  https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098529
    public final String BUS_ROUTE_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteInfoIem";


    // 정류장 실시간 도착예정정보  :  https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098530
    public final String BUS_ARRIVAL_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList";

    // 정류장 특정노선 실시간 도착예정정보
    public final String BUS_SPECIFIC_ROUTE_ARRIVAL_INFO_URL = "http://apis.data.go.kr/1613000/ArvlInfoInqireService/getSttnAcctoSpcifyRouteBusArvlPrearngeInfoList";


    // 버스 노선 GPS 위치 정보 목록 조회  :  https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098533
    public final String BUS_LOCATION_INFO_SERVICE_URL = "http://apis.data.go.kr/1613000/BusLcInfoInqireService/getRouteAcctoBusLcList";


    @Getter
    private BusService busService = new BusService();

    @Getter
    private CityService cityService = new CityService();

}
