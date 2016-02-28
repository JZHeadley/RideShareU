package com.jzheadley.rideshareu;

public class Trip extends Model {
    public Trip() {
        super("Trip");

        this.columns.put("vehicle", new Integer(0));
        this.columns.put("driver", new Integer(0));
        this.columns.put("departure", new String());
        this.columns.put("arrival", new String());
        this.columns.put("value", new Double(0.0));
    }
}
