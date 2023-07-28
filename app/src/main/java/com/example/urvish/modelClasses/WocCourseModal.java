package com.example.urvish.modelClasses;

public class WocCourseModal {

    String s;
    String sendername;
    String usermassage;
    String strDate;
    String imagesss;
    int setgrvity;
    long dateee;

    public WocCourseModal(String s, String sendername, String usermassage, String strDate, String imagesss, int setgrvity, long dateee) {
        this.s = s;
        this.sendername = sendername;
        this.usermassage = usermassage;
        this.strDate = strDate;
        this.imagesss = imagesss;
        this.setgrvity = setgrvity;
        this.dateee = dateee;
    }

    public long getDateee() {
        return dateee;
    }

    public void setDateee(long dateee) {
        this.dateee = dateee;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getUsermassage() {
        return usermassage;
    }

    public void setUsermassage(String usermassage) {
        this.usermassage = usermassage;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getImagesss() {
        return imagesss;
    }

    public void setImagesss(String imagesss) {
        this.imagesss = imagesss;
    }

    public int getSetgrvity() {
        return setgrvity;
    }

    public void setSetgrvity(int setgrvity) {
        this.setgrvity = setgrvity;
    }

    @Override
    public String toString() {
        return "CourseModal{" +
                "s='" + s + '\'' +
                ", sendername='" + sendername + '\'' +
                ", usermassage='" + usermassage + '\'' +
                ", strDate='" + strDate + '\'' +
                ", imagesss='" + imagesss + '\'' +
                ", setgrvity=" + setgrvity +
                '}';
    }
}



