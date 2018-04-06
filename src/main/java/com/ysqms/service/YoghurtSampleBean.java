package com.ysqms.service;

import com.sun.rowset.JdbcRowSetImpl;
import com.ysqms.model.YoghurtSample;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;

public class YoghurtSampleBean {
    static final String JDBC_DRIVER =
            "com.mysql.jdbc.Driver";
    static final String DB_URL =
            "jdbc:mysql://localhost:3306/ysqms";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    private JdbcRowSet rowSet = null;

    public YoghurtSampleBean() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM YoghurtSample");
            rowSet.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public YoghurtSample create(YoghurtSample sample) {
        try {
            rowSet.moveToInsertRow();

            rowSet.updateFloat("BostwickValue", sample.getBostwick_Value());
            rowSet.updateDouble("CriticalTemperature", sample.getCriticalTemperature());
            rowSet.updateDouble("Ph%", sample.getPhPercent());
            rowSet.updateDouble("TotalSolids", sample.getTotalSolids());
            rowSet.updateDouble("SQRGV", sample.getSqrgv());
            rowSet.updateDouble("ShelfQualityLoss", sample.getShelfQualityLoss());
            rowSet.updateDouble("SQRCV", sample.getSqrcv());
            rowSet.updateDouble("LABBQ%", sample.getLabbqPercent());
            rowSet.updateDouble("FFI%", sample.getFfiPercent());
            rowSet.updateDouble("PH", sample.getPh());
            rowSet.updateInt("ShelfTime", sample.getShelfTime());
            rowSet.updateDouble("Temperature",sample.getTemperature());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
                sample = null;
            } catch (SQLException ignored) {

            }
            ex.printStackTrace();
        }
        return sample;
    }

    public YoghurtSample update(YoghurtSample sample) {
        try {
            rowSet.updateFloat("BostwickValue", sample.getBostwick_Value());
            rowSet.updateDouble("CriticalTemperature", sample.getCriticalTemperature());
            rowSet.updateDouble("TotalSolids", sample.getTotalSolids());
            rowSet.updateDouble("SQRGV", sample.getSqrgv());
            rowSet.updateDouble("ShelfQualityLoss", sample.getShelfQualityLoss());
            rowSet.updateDouble("SQRCV", sample.getSqrcv());
            rowSet.updateDouble("LABBQ%", sample.getLabbqPercent());
            rowSet.updateDouble("FFI%", sample.getFfiPercent());
            rowSet.updateDouble("PH", sample.getPh());
            rowSet.updateDouble("Ph%", sample.getPhPercent());

            rowSet.updateInt("ShelfTime", sample.getShelfTime());
            rowSet.updateRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
            } catch (SQLException e) {

            }
            ex.printStackTrace();
        }
        return sample;
    }

    public void delete() {
        try {
            rowSet.moveToCurrentRow();
            rowSet.deleteRow();
        } catch (SQLException ex) {
            try {
                rowSet.rollback();
            } catch (SQLException e) {
            }
            ex.printStackTrace();
        }

    }

    public YoghurtSample moveFirst() {
        YoghurtSample sample = new YoghurtSample();
        try {
            rowSet.first();
            sample.setId(rowSet.getInt("id"));
            sample.setTemperature(rowSet.getDouble("Temperature"));
            sample.setBostwick_Value(rowSet.getFloat("BostwickValue"));
            sample.setCriticalTemperature(rowSet.getDouble("CriticalTemperature"));
            sample.setPh(rowSet.getDouble("PH"));
            sample.setTotalSolids(rowSet.getDouble("TotalSolids"));
            sample.setShelfQualityLoss(rowSet.getDouble("ShelfQualityLoss"));
            sample.setShelfTime(rowSet.getInt("ShelfTime"));
            sample.setSqrcv(rowSet.getDouble("SQRCV"));
            sample.setSqrgv(rowSet.getDouble("SQRGV"));
            sample.setLabbqPercent(rowSet.getDouble("LABBQ%"));
            sample.setPhPercent(rowSet.getDouble("Ph%"));
            sample.setFfiPercent(rowSet.getDouble("FFI%"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sample;
    }

    public YoghurtSample moveLast() {
        YoghurtSample sample = new YoghurtSample();
        try {
            rowSet.last();
            sample.setId(rowSet.getInt("id"));
            sample.setTemperature(rowSet.getDouble("Temperature"));
            sample.setBostwick_Value(rowSet.getFloat("BostwickValue"));
            sample.setCriticalTemperature(rowSet.getDouble("CriticalTemperature"));
            sample.setPh(rowSet.getDouble("PH"));
            sample.setTotalSolids(rowSet.getDouble("TotalSolids"));
            sample.setShelfQualityLoss(rowSet.getDouble("ShelfQualityLoss"));
            sample.setShelfTime(rowSet.getInt("ShelfTime"));
            sample.setSqrcv(rowSet.getDouble("SQRCV"));
            sample.setSqrgv(rowSet.getDouble("SQRGV"));
            sample.setLabbqPercent(rowSet.getDouble("LABBQ%"));
            sample.setPhPercent(rowSet.getDouble("Ph%"));
            sample.setFfiPercent(rowSet.getDouble("FFI%"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sample;
    }

    public YoghurtSample moveNext() {
        YoghurtSample sample = new YoghurtSample();
        try {
            if (!rowSet.next())
                rowSet.previous();
            sample.setId(rowSet.getInt("id"));
            sample.setId(rowSet.getInt("id"));
            sample.setTemperature(rowSet.getDouble("Temperature"));
            sample.setBostwick_Value(rowSet.getFloat("BostwickValue"));
            sample.setCriticalTemperature(rowSet.getDouble("CriticalTemperature"));
            sample.setPh(rowSet.getDouble("PH"));
            sample.setTotalSolids(rowSet.getDouble("TotalSolids"));
            sample.setShelfQualityLoss(rowSet.getDouble("ShelfQualityLoss"));
            sample.setShelfTime(rowSet.getInt("ShelfTime"));
            sample.setSqrcv(rowSet.getDouble("SQRCV"));
            sample.setSqrgv(rowSet.getDouble("SQRGV"));
            sample.setLabbqPercent(rowSet.getDouble("LABBQ%"));
            sample.setPhPercent(rowSet.getDouble("Ph%"));
            sample.setFfiPercent(rowSet.getDouble("FFI%"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sample;
    }

    public YoghurtSample movePrevious() {
        YoghurtSample sample = new YoghurtSample();
        try {
            if (!rowSet.previous())
                rowSet.next();
            sample.setId(rowSet.getInt("id"));
            sample.setId(rowSet.getInt("id"));
            sample.setTemperature(rowSet.getDouble("Temperature"));
            sample.setBostwick_Value(rowSet.getFloat("BostwickValue"));
            sample.setCriticalTemperature(rowSet.getDouble("CriticalTemperature"));
            sample.setPh(rowSet.getDouble("PH"));
            sample.setTotalSolids(rowSet.getDouble("TotalSolids"));
            sample.setShelfQualityLoss(rowSet.getDouble("ShelfQualityLoss"));
            sample.setShelfTime(rowSet.getInt("ShelfTime"));
            sample.setSqrcv(rowSet.getDouble("SQRCV"));
            sample.setSqrgv(rowSet.getDouble("SQRGV"));
            sample.setLabbqPercent(rowSet.getDouble("LABBQ%"));
            sample.setPhPercent(rowSet.getDouble("Ph%"));
            sample.setFfiPercent(rowSet.getDouble("FFI%"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sample;
    }

    public YoghurtSample getCurrent() {
        YoghurtSample sample = new YoghurtSample();
        try {
            rowSet.moveToCurrentRow();
            sample.setId(rowSet.getInt("id"));
            sample.setId(rowSet.getInt("id"));
            sample.setTemperature(rowSet.getDouble("Temperature"));
            sample.setBostwick_Value(rowSet.getFloat("BostwickValue"));
            sample.setCriticalTemperature(rowSet.getDouble("CriticalTemperature"));
            sample.setPh(rowSet.getDouble("PH"));
            sample.setTotalSolids(rowSet.getDouble("TotalSolids"));
            sample.setShelfQualityLoss(rowSet.getDouble("ShelfQualityLoss"));
            sample.setShelfTime(rowSet.getInt("ShelfTime"));
            sample.setSqrcv(rowSet.getDouble("SQRCV"));
            sample.setSqrgv(rowSet.getDouble("SQRGV"));
            sample.setLabbqPercent(rowSet.getDouble("LABBQ%"));
            sample.setPhPercent(rowSet.getDouble("Ph%"));
            sample.setFfiPercent(rowSet.getDouble("FFI%"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sample;
    }
}

