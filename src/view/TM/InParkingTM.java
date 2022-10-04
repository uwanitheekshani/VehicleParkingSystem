package view.TM;

public class InParkingTM {
    private String vehicleNum;
    private String vehicleType;
    private String vehiSlot;
    private String time;

    public InParkingTM() {
    }


    public InParkingTM(String vehicleNum, String vehicleType, String vehiSlot, String time) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.vehiSlot = vehiSlot;
        this.time = time;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiSlot() {
        return vehiSlot;
    }

    public void setVehiSlot(String vehiSlot) {
        this.vehiSlot = vehiSlot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "InParkingTM{" +
                "vehicleNum='" + vehicleNum + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehiSlot='" + vehiSlot + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
