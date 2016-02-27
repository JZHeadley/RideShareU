package com.jzheadley.rideshareu;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;

public abstract class Model {
    protected String table = null;
    protected HashMap<String, Object> columns;
    private int id = 0;
    private Connection connection;
    private Statement statement;
    private int num;

    protected Model(String tbl) {
        this.table = tbl;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://191.237.45.19/RideShare", "root", "asdf");
            Log.d("RideShareU", "Database connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.columns = new HashMap<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    protected Object getColumn(String label) {
        return this.columns.get(label);
    }

    public int create() throws SQLException {
        String qstr = "INSERT INTO `" + table + "` (id) VALUES (null);";
        if (statement.execute(qstr)) {
            num = statement.getMoreResults() ? 1 : 0;
            return num;
        }
        return 0;
    }


    public boolean read() throws SQLException {
        if (this.num == 1) {
            ResultSet rset = statement.executeQuery("SELECT * FROM `" + this.table + " WHERE `id` = " + this.id + ";");

            /* Load all columns into this object's HashMap. */
        }
        return false;
    }

    public boolean update() throws SQLException {
        String qstr = "UPDATE `" + this.table + "` SET ";
        Set<String> keys = this.columns.keySet();
        int remaining = keys.size();

        for (String k : keys) {
            Object v = this.columns.get(k);

            if (v instanceof String)
                qstr += "`" + k + "`=\"" + v + "\"";
            else
                qstr += "`" + k + "`=" + v;
            if (--remaining > 0)
                qstr += ",";
        }
        qstr += ";";

        return statement.execute(qstr);
    }

    public boolean delete() throws SQLException {
        return statement.execute("DELETE FROM `" + this.table + "` WHERE `id` = " + this.id + ";");
    }

}

