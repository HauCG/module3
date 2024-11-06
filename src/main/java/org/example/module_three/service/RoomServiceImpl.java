package org.example.module_three.service;

import org.example.module_three.model.Room;
import org.example.module_three.service.RoomService;
import org.example.module_three.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final Connection connection;

    public RoomServiceImpl() throws SQLException {
        this.connection = new DatabaseConnection().getConnection();
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            String query = "SELECT r.Room_Id, r.Renter_Name, r.Renter_Name_Phone_Number, r.Rent_Start_Date, " +
                    "r.Payment_Method_Id, r.Note, p.Payment_Method_Name " +
                    "FROM Room r INNER JOIN Payment p ON r.Payment_Method_Id = p.Payment_Method_Id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("Room_Id"));
                room.setRenterName(rs.getString("Renter_Name"));
                room.setRenterPhoneNumber(rs.getString("Renter_Name_Phone_Number"));
                room.setRentStartDate(rs.getDate("Rent_Start_Date"));
                room.setPaymentMethodName(rs.getString("Payment_Method_Name"));
                room.setNote(rs.getString("Note"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        Room room = null;
        try {
            String query = "SELECT r.Room_Id, r.Renter_Name, r.Renter_Name_Phone_Number, r.Rent_Start_Date, " +
                    "r.Payment_Method_Id, r.Note, p.Payment_Method_Name " +
                    "FROM Room r INNER JOIN Payment p ON r.Payment_Method_Id = p.Payment_Method_Id WHERE r.Room_Id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setRoomId(rs.getInt("Room_Id"));
                room.setRenterName(rs.getString("Renter_Name"));
                room.setRenterPhoneNumber(rs.getString("Renter_Name_Phone_Number"));
                room.setRentStartDate(rs.getDate("Rent_Start_Date"));
                room.setPaymentMethodId(rs.getInt("Payment_Method_Id"));
                room.setNote(rs.getString("Note"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public boolean createRoom(Room room) {
        try {
            String query = "INSERT INTO Room (Renter_Name, Renter_Name_Phone_Number, Rent_Start_Date, Payment_Method_Id, Note) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, room.getRenterName());
            stmt.setString(2, room.getRenterPhoneNumber());
            stmt.setDate(3, new java.sql.Date(room.getRentStartDate().getTime()));
            stmt.setInt(4, room.getPaymentMethodId());
            stmt.setString(5, room.getNote());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        try {
            String query = "DELETE FROM Room WHERE Room_Id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, roomId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
