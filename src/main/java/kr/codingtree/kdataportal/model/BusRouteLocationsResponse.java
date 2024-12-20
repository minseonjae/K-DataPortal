package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BusRouteLocationsResponse {

    @SerializedName("items")
    public BusLocationItems items;

    @SerializedName("numOfRows")
    public int numOfRows;

    @SerializedName("pageNo")
    public int pageNo;

    @SerializedName("totalCount")
    public int totalCount;

    @Getter
    @ToString
    public static class BusLocationItems {

        @SerializedName("item")
        private List<BusRouteLocationItem> list;

    }
}
