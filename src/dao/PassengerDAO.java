package dao;

import db.DBConnection;
import model.Bus;
import model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    BusDAO busDAO = new BusDAO();

    public boolean bookPassenger(Passenger p) throws SQLException {
        Bus bus = busDAO.getBusById(p.getBusId());

        if (bus == null) {
            System.out.println("Bus not found!");
            return false;
        }

        if (bus.getSeatingCapacity() <= 0) {
            System.out.println("No seats available!");
            return false;
        }

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            String sql = "INSERT INTO passenger(name, age, amount, bus_id, source, dest) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setDouble(3, p.getAmount());
            ps.setInt(4, p.getBusId());
            ps.setString(5, p.getSource());
            ps.setString(6, p.getDest());
            ps.executeUpdate();

            busDAO.updateSeats(p.getBusId(), bus.getSeatingCapacity() - 1);

            con.commit();
            return true;

        } catch (Exception e) {
            con.rollback();
            System.out.println("Error booking: " + e.getMessage());
            return false;
        } finally {
            con.close();
        }
    }

    public List<Passenger> getAllPassengers() throws SQLException {
        List<Passenger> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM passenger");

        while (rs.next()) {
            list.add(mapRow(rs));
        }
        con.close();
        return list;
    }

    public List<Passenger> getPassengersByBus(int busId) throws SQLException {
        List<Passenger> list = new ArrayList<>();

        String sql = "SELECT * FROM passenger WHERE bus_id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, busId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(mapRow(rs));
        }

        con.close();
        return list;
    }

    private Passenger mapRow(ResultSet rs) throws SQLException {
        Passenger p = new Passenger();
        p.setPassId(rs.getInt("pass_id"));
        p.setName(rs.getString("name"));
        p.setAge(rs.getInt("age"));
        p.setAmount(rs.getDouble("amount"));
        p.setBusId(rs.getInt("bus_id"));
        p.setSource(rs.getString("source"));
        p.setDest(rs.getString("dest"));
        return p;
    }
}
