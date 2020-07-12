package model;

import java.util.Date;

public class Volunteer {
    private int id;
    private int org_id;
    private int client_id;
    private String userName;
    private String gender;
    private String phone;
    private String id_card;
    private int age;
    private Date checkin_date;
    private Date checkout_date;
    private String imgset_dir;
    private String profile_photo;
    private String DESCRIPTION;
    private char ISACTIVE;
    private Date created;
    private int createby;
    private Date updated;
    private int updateby;
    private char remove;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }

    public String getImgset_dir() {
        return imgset_dir;
    }

    public void setImgset_dir(String imgset_dir) {
        this.imgset_dir = imgset_dir;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public char getISACTIVE() {
        return ISACTIVE;
    }

    public void setISACTIVE(char ISACTIVE) {
        this.ISACTIVE = ISACTIVE;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCreateby() {
        return createby;
    }

    public void setCreateby(int createby) {
        this.createby = createby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getUpdateby() {
        return updateby;
    }

    public void setUpdateby(int updateby) {
        this.updateby = updateby;
    }

    public char getRemove() {
        return remove;
    }

    public void setRemove(char remove) {
        this.remove = remove;
    }


}
