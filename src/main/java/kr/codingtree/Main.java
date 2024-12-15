package kr.codingtree;

import kr.codingtree.kdataportal.KDataPortal;

public class Main {

    public static void main(String[] args) {
//        String json = KDataPortal.getCityService().getCityCodes();
//
//        System.out.println(json);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        System.out.println(gson.toJson(json));

//        KDataPortal.getCityService().getCityCodes().forEach((key, value) -> {
//            System.out.println(key + " :: " + value);
//        });

//        System.out.println(KDataPortal.getBusService().getRouteArrivalInfo(1, 10, 31100, "GGB219000204", "GGB218000018"));
//        System.out.println(KDataPortal.getBusService().getNearbyStations(1, 10, 37.67777, 126.79619));
        System.out.println(KDataPortal.getBusService().getRouteInfo(31100, "GGB218000018"));
    }

}