package com.example.alice.csa_app;

public class Dialogue {
    private String titles;
    private String subjects;
    private String date;
    private String descripts;

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public void setLocation(String subjects) {
        this.subjects = subjects;
    }

    public void setdates(String date) {
        this.date = date;
    }

    public void setDescripts(String descripts) {
        this.descripts = descripts;
    }

    public String getTitles() {
        return titles;
    }

    public String getLocation() {
        return subjects;
    }

    public String getDates() {
        return date;
    }

    public String getDescripts() {
        return descripts;
    }
}
