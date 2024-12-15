package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusArrivalInfoItem {

    @SerializedName("arrprevstationcnt")
    public int arrPrevStationCnt;

    @SerializedName("arrtime")
    public int arrTime;

    @SerializedName("nodeid")
    public String nodeId;

    @SerializedName("nodenm")
    public String nodeName;

    @SerializedName("routeid")
    public String routeId;

    @SerializedName("routeno")
    public String routeNo;

    @SerializedName("routetp")
    public String routeType;

    @SerializedName("vehicletp")
    public String vehicleType;

}
