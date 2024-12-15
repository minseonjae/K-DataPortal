package kr.codingtree.kdataportal.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusRouteInfoResponse {

    @SerializedName("endnodenm")
    public String endNodeName;

    @SerializedName("endvehicletime")
    public String endVehicleTime;

    @SerializedName("intervalsattime")
    public int intervalSaturdayTime;

    @SerializedName("intervalsuntime")
    public int intervalSundayTime;

    @SerializedName("intervaltime")
    public int intervalWeekdayTime;

    @SerializedName("routeid")
    public String routeId;

    @SerializedName("routeno")
    public String routeNo;

    @SerializedName("routetp")
    public String routeType;

    @SerializedName("startnodenm")
    public String startNodeName;

    @SerializedName("startvehicletime")
    public String startVehicleTime;

}
