package model;

public class Passenger {
    private int passId;
    private String name;
    private int age;
    private double amount;
    private int busId;
    private String source;
    private String dest;

    public Passenger() {
    }

    public Passenger(String name, int age, double amount, int busId, String source, String dest) {
        this.name = name;
        this.age = age;
        this.amount = amount;
        this.busId = busId;
        this.source = source;
        this.dest = dest;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passId=" + passId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                ", busId=" + busId +
                ", source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
