package com.jzheadley.rideshareu;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private final String URL = "jdbc:mysql://191.237.45.19/RideShare";
    private final String USER = "root";
    private final String PASS = "asdf";
    Statement stmt = null;
    private Connection connection = null;

    public Database() throws IllegalAccessException, InstantiationException {
        // Initialize the database driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        // Connect to the Database
        try {
            connection = (Connection) DriverManager.getConnection(URL, USER, PASS);
            if (connection != null) {
                Log.d("RideShareU", "Connected to database!");
            } else {
                Log.d("RideShareU", "Failed to make connection!");
            }

        } catch (SQLException e) {
            for (Throwable ex : e) {
                Log.wtf("RideShareU", "Error occurred " + ex);
            }
            e.printStackTrace();
        }

    }

    public void setUserName(String name) {
        try {
            // Statement sql = connection.createStatement();
            String query = "INSERT INTO User (name)" + " VALUES (?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);

            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        } catch (SQLException e) {
            for (Throwable ex : e) {
                Log.wtf("RideShareU", "Error occurred " + ex);
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    public void setTrip(String departureDate, String returnDate, String departureTime, String returnTime, int seats,
                        String source, String destination) {
        try {

            String query = "INSERT INTO Vehicle (NumSeats) VALUES (?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, seats);
            preparedStmt.execute();

            Statement stmt = connection.createStatement();

            // Execute the SQL statement and get the results in a Resultset
            ResultSet rs = stmt.executeQuery("SELECT id FROM Vehicle");

            int num = 0;

            while (rs.next()) {
                num = (rs.getInt("id"));
            }

            if (seats == 4) {
                String query2 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query2);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query3 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query3);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query4 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query4);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query5 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query5);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
            } else if (seats == 7) {
                String query6 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query6);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query7 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query7);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query8 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query8);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query9 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query9);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query10 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query10);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query11 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query11);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
                String query12 = "INSERT INTO Seat (vehicle, valueFactor)" + " VALUES (?, ?)";
                preparedStmt = connection.prepareStatement(query12);
                preparedStmt.setInt(1, num);
                preparedStmt.setInt(2, 1);
                preparedStmt.execute();
            }

            ResultSet rs2 = stmt.executeQuery("SELECT SUM(valueFactor) FROM Seat WHERE vehicle =" + num);

            double value2 = 0;

            while (rs2.next()) {
                value2 = (rs2.getDouble("SUM(valueFactor)"));
            }

            String sleep = "INSERT INTO Trip (departureTime, returnTime, source, destination, value, driver, departureDate, returnDate, vehicle)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt2 = connection.prepareStatement(sleep);
            preparedStmt2.setString(1, departureTime);
            preparedStmt2.setString(2, returnTime);
            preparedStmt2.setString(3, source);
            preparedStmt2.setString(4, destination);
            preparedStmt2.setDouble(5, value2);
            preparedStmt2.setInt(6, num);
            preparedStmt2.setString(7, departureDate);
            preparedStmt2.setString(8, returnDate);
            preparedStmt2.setInt(9, num);
            preparedStmt2.execute();

            connection.close();
        } catch (SQLException e) {
            for (Throwable ex : e) {
                Log.wtf("RideShareU", "Error occurred " + ex);
            }
            e.printStackTrace();
        }
    }


}