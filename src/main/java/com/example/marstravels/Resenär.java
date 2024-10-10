package com.example.marstravels;

public class Resenär {
    private String personnr;
    private String fname;
    private String lname;
    private String adress;
    private String epost;
    private String hälsodetaljer;

    public Resenär(String personnr, String fname,String lname, String adress, String epost, String hälsodetaljer) {
        this.personnr = personnr;
        this.fname = fname;
        this.lname = lname;
        this.adress = adress;
        this.epost = epost;
        this.hälsodetaljer = hälsodetaljer;
    }

    public String getPersonnr() {return personnr;}
    public String getFname() {return fname;}
    public String getLname() {return lname;}
    public String getAdress() {return adress;}
    public String getEpost() {return epost;}
    public String getHälsodetaljer() {return hälsodetaljer;}

}
