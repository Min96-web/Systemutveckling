package com.example.marstravels;

import java.sql.*;
import java.util.ArrayList;

public class SqlQuery {
    private Connection connection = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    SqlQuery() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://10.12.6.82/SUM7?" + "user=sum7&password=Millan12");
        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public String selectColumn(String table, String attribute) {
        try {
            if (connection != null) {
                stmt = connection.createStatement();
                rs = stmt.executeQuery("SELECT pris FROM " + table + " WHERE category =\"" + attribute + "\";");
                rs.next();
                System.out.println(rs.getBigDecimal("pris"));
                return String.valueOf(rs.getBigDecimal("pris"));
            } else throw new SQLException();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return "001 FEL I SELECT COLUMN";
        }
    }

    public void insertTestbokning(String _hytt, String _mat, String _hotell, String _event){
        try {
            if (connection != null) {
                stmt = connection.createStatement();

                String iHytt = "\'" + _hytt + "\'";
                String iMat = "\'" + _mat + "\'";
                String iHotell = "\'" + _hotell + "\'";
                String iEvent = "\'" + _event + "\'";

                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO Testbokning(hytt, matpaket, hotell, event) VALUES (" + iHytt + "," + iMat + "," + iHotell + "," + iEvent + ")";
                stmt.executeUpdate(sql);
            } else throw new SQLException();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            //return "001 FEL I SELECT COLUMN";
        }
    }

    public void insertResenär(String _personnr, String _fname, String _lname, String _adress, String _epost, String _hälsodetaljer){
        try {
            if (connection != null) {
                stmt = connection.createStatement();

                String iPersonnr = "\'" + _personnr + "\'";
                String iFname = "\'" + _fname + "\'";
                String iLname = "\'" + _lname + "\'";
                String iAdress = "\'" + _adress + "\'";
                String iEpost = "\'" + _epost + "\'";
                String iHälsodetaljer = "\'" + _hälsodetaljer + "\'";

                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO Testresenäruppgift(personnummer, f_namn, l_namn, adress, e_post, hälsodetaljer) VALUES (" + iPersonnr + "," + iFname + "," + iLname + "," + iAdress + "," + iEpost + "," + iHälsodetaljer + ")";
                stmt.executeUpdate(sql);
            } else throw new SQLException();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            //return "001 FEL I SELECT COLUMN";
        }
    }
    public void insertBooking (ArrayList<String> _booking){
        try {
            if (connection != null) {
                stmt = connection.createStatement();

                String iHytt = "null";
                String iMatpaket = "null";
                String iBadhus = "null";
                String iFilm = "null";
                String iTeater = "null";
                String iKonsert = "null";
                String iHälsodetaljer = "null";
                String iBetalkort = "0";
                String iHotell = "null";
                String itillFrån = "null";

                for (String s : _booking) {
                    String[] splitArray = s.split(";");
                    if (s.charAt(0) == '1') {
                        iHytt = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '2') {
                        iMatpaket = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '3' && s.charAt(1) == 'i') {
                        iBadhus = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '4' && s.charAt(1) == 'i') {
                        iFilm = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '5' && s.charAt(1) == 'i') {
                        iTeater = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '6') {
                        iKonsert = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '7') {
                        iHälsodetaljer = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == '8') {
                        iBetalkort = splitArray[2];
                    }
                    if (s.charAt(0) == '9') {
                        iHotell = "\'" + splitArray[1] + "\'";
                    }
                    if (s.charAt(0) == 'T' || s.charAt(0) == 'F') {
                        itillFrån = "\'" + s + "\'";
                        System.out.println(s);
                    }
                }

                int hej = 0;
                while (true) {
                    try {
                        hej = Integer.parseInt(iBetalkort);
                        System.out.println("parse intat" + hej);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("MEN VAFAN GÖR RÄTT");
                        break;
                    }
                }
                // för att dubellkolla
                System.out.println("hytt " + iHytt);
                System.out.println("mat " + iMatpaket);
                System.out.println("badhus " + iBadhus);
                System.out.println("film " + iFilm);
                System.out.println("teater " + iTeater);
                System.out.println("konsert " + iKonsert);
                System.out.println("hotell " + iHotell);
                System.out.println("hälso " + iHälsodetaljer);
                System.out.println("betal " + iBetalkort);
                System.out.println("itill " + itillFrån);


                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO Booking(hytt, matpaket, badhus, film, teater, konsert, hälsodetaljer,betalkort,hotell,tillFrån) VALUES (" + iHytt + "," + iMatpaket + "," + iBadhus + "," + iFilm + "," + iTeater + "," + iKonsert + "," + iHälsodetaljer + "," + hej + "," + iHotell + "," + itillFrån + ")";
                // SAVE :                 String sql = "INSERT INTO Booking(hytt, matpaket, badhus, film, teater, konsert, hälsodetaljer,betalkort,hotell,tillFrån) VALUES (" + iHytt + "," + iMatpaket + "," + iBadhus + "," + iFilm + "," + iTeater + ","+ iKonsert + "," + iHälsodetaljer + "," + iBetalkort + "," + iHotell + "," + itillFrån + ")";
                stmt.executeUpdate(sql);
                System.out.println("Sucess!");
            } else throw new SQLException();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            //return "001 FEL I SELECT COLUMN";
        }
    }
}

