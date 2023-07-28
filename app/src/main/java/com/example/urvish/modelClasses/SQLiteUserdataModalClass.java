package com.example.urvish.modelClasses;

public class SQLiteUserdataModalClass {

    int id;
    public String sqlname;
    String sqlemail;
    String sqlage;
    String sqlnumber;
    String sqlgender;
    public String sqlimage;

    public SQLiteUserdataModalClass(int id, String sqlname, String sqlemail, String sqlage, String sqlnumber, String sqlgender, String sqlimage) {
        this.id = id;
        this.sqlname = sqlname;
        this.sqlemail = sqlemail;
        this.sqlage = sqlage;
        this.sqlnumber = sqlnumber;
        this.sqlgender = sqlgender;
        this.sqlimage = sqlimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSqlname() {
        return sqlname;
    }

    public void setSqlname(String sqlname) {
        this.sqlname = sqlname;
    }

    public String getSqlemail() {
        return sqlemail;
    }

    public void setSqlemail(String sqlemail) {
        this.sqlemail = sqlemail;
    }

    public String getSqlage() {
        return sqlage;
    }

    public void setSqlage(String sqlage) {
        this.sqlage = sqlage;
    }

    public String getSqlnumber() {
        return sqlnumber;
    }

    public void setSqlnumber(String sqlnumber) {
        this.sqlnumber = sqlnumber;
    }

    public String getSqlgender() {
        return sqlgender;
    }

    public void setSqlgender(String sqlgender) {
        this.sqlgender = sqlgender;
    }

    public String getSqlimage() {
        return sqlimage;
    }

    public void setSqlimage(String sqlimage) {
        this.sqlimage = sqlimage;
    }

    @Override
    public String toString() {
        return "Userdata{" +
                "id=" + id +
                ", sqlname='" + sqlname + '\'' +
                ", sqlemail='" + sqlemail + '\'' +
                ", sqlage='" + sqlage + '\'' +
                ", sqlnumber='" + sqlnumber + '\'' +
                ", sqlgender='" + sqlgender + '\'' +
                ", sqlimage='" + sqlimage + '\'' +
                '}';
    }
}
