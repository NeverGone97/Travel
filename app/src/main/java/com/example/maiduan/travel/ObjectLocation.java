package com.example.maiduan.travel;

/**
 * Created by Mai Duan on 24/01/2017.
 */

public class ObjectLocation {
    public ObjectLatLng mObjLatLng;

    public String nameLocation;
    public String addVenues;
    public String linkIcon;
    public String linkimg;
    public String linkimg_Big;
    public String linkimg_Small;
    public int phone;
    public String des;
    public String desOfTitle;

    public ObjectLocation() {
        super();
    }

    public ObjectLocation(ObjectLatLng mObjLatLng, String nameLocation, String addVenues, String linkIcon, String linkimg, String linkimg_Big, String linkimg_Small, int phone, String des, String desOfTitle) {
        this.mObjLatLng = mObjLatLng;
        this.nameLocation = nameLocation;
        this.addVenues = addVenues;
        this.linkIcon = linkIcon;
        this.linkimg = linkimg;
        this.linkimg_Big = linkimg_Big;
        this.linkimg_Small = linkimg_Small;
        this.phone = phone;
        this.des = des;
        this.desOfTitle = desOfTitle;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getAddVenues() {
        return addVenues;
    }

    public void setAddVenues(String addVenues) {
        this.addVenues = addVenues;
    }

    public String getLinkIcon() {
        return linkIcon;
    }

    public void setLinkIcon(String linkIcon) {
        this.linkIcon = linkIcon;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }

    public String getLinkimg_Big() {
        return linkimg_Big;
    }

    public void setLinkimg_Big(String linkimg_Big) {
        this.linkimg_Big = linkimg_Big;
    }

    public String getLinkimg_Small() {
        return linkimg_Small;
    }

    public void setLinkimg_Small(String linkimg_Small) {
        this.linkimg_Small = linkimg_Small;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDesOfTitle() {
        return desOfTitle;
    }

    public void setDesOfTitle(String desOfTitle) {
        this.desOfTitle = desOfTitle;
    }

    public ObjectLatLng getmObjLatLng() {
        return mObjLatLng;
    }

    public void setmObjLatLng(ObjectLatLng mObjLatLng) {
        this.mObjLatLng = mObjLatLng;
    }
}
