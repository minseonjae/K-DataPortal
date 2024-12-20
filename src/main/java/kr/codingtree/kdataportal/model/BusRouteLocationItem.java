package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusRouteLocationItem {

    @SerializedName("gpslati")
    public double gpsLati;

    @SerializedName("gpslong")
    public double gpsLong;

    @SerializedName("nodeid")
    public String nodeId;

    @SerializedName("nodenm")
    public String nodeName;

    @SerializedName("nodeord")
    public int nodeOrder;

    @SerializedName("routenm")
    public String routeName;

    @SerializedName("routetp")
    public String routeType;

    @SerializedName("vehicleno")
    public String vehicleNo;

}
