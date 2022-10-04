package model;

public class Drivers {
    private String name;
    private String nic;
    private String drivingLiNo;
    private String address;
    private String contact;


    public Drivers() {
    }

    public Drivers(String name, String nic, String drivingLiNo, String address, String contact) {
        this.name = name;
        this.nic = nic;
        this.drivingLiNo = drivingLiNo;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLiNo() {
        return drivingLiNo;
    }

    public void setDrivingLiNo(String drivingLiNo) {
        this.drivingLiNo = drivingLiNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
