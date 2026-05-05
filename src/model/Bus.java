package model;

import java.time.LocalDateTime;

public class Bus {
    private int busId;
    private String busNo;
    private LocalDateTime departure;
    private int seatingCapacity;
    private String startingPoint;
    private String endingPoint;
    private boolean available;

    public Bus() {
    }

    public Bus(String busNo, LocalDateTime departure, int seatingCapacity, String startingPoint, String endingPoint) {
        this.busNo = busNo;
        this.departure = departure;
        this.seatingCapacity = seatingCapacity;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.available = true;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", busNo='" + busNo + '\'' +
                ", departure=" + departure +
                ", seatingCapacity=" + seatingCapacity +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", available=" + available +
                '}';
    }
}
