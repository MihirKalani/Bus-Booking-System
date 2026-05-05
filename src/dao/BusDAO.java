package dao;

import db.DBConnection;
import model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    public void addBus(Bus bus) throws SQLException {
        String query = "INSERT INTO bus(bus_no, departure, seating_capacity, starting_point, ending_point) VALUES (?, ?, ?, ?, ?)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, bus.getBusNo());
        ps.setTimestamp(2, Timestamp.valueOf(bus.getDeparture()));
        ps.setInt(3, bus.getSeatingCapacity());
        ps.setString(4, bus.getStartingPoint());
        ps.setString(5, bus.getEndingPoint());

        ps.executeUpdate();
        con.close();
    }

    public List<Bus> getAllBuses() throws SQLException {
        List<Bus> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM bus");

        while (rs.next()) {
            Bus bus = mapRow(rs);
            list.add(bus);
        }
        con.close();
        return list;
    }

    public void updateSeats(int busId, int newSeats) throws SQLException {
        String sql = "UPDATE bus SET seating_capacity = ?, bus_available = ? WHERE bus_id = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, newSeats);
        ps.setBoolean(2, newSeats > 0);
        ps.setInt(3, busId);

        ps.executeUpdate();
        con.close();
    }

    public Bus getBusById(int busId) throws SQLException {
        String sql = "SELECT * FROM bus WHERE bus_id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, busId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Bus bus = mapRow(rs);
            con.close();
            return bus;
        }
        con.close();
        return null;
    }

    private Bus mapRow(ResultSet rs) throws SQLException {
        Bus bus = new Bus();
        bus.setBusId(rs.getInt("bus_id"));
        bus.setBusNo(rs.getString("bus_no"));
        bus.setDeparture(rs.getTimestamp("departure").toLocalDateTime());
        bus.setSeatingCapacity(rs.getInt("seating_capacity"));
        bus.setStartingPoint(rs.getString("starting_point"));
        bus.setEndingPoint(rs.getString("ending_point"));
        bus.setAvailable(rs.getBoolean("bus_available"));
        return bus;
    }
}
