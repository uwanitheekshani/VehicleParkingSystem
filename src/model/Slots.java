package model;

public class Slots {
    private String slotNum;
    private String slotvehicleType;
    private String slotStuatus;

    public Slots() {
    }

    public Slots(String slotNum, String slotvehicleType, String slotStuatus) {
        this.slotNum = slotNum;
        this.slotvehicleType = slotvehicleType;
        this.slotStuatus = slotStuatus;
    }

    public String getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(String slotNum) {
        this.slotNum = slotNum;
    }

    public String getSlotvehicleType() {
        return slotvehicleType;
    }

    public void setSlotvehicleType(String slotvehicleType) {
        this.slotvehicleType = slotvehicleType;
    }

    public String getSlotStuatus() {
        return slotStuatus;
    }

    public void setSlotStuatus(String slotStuatus) {
        this.slotStuatus = slotStuatus;
    }
}
