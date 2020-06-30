package model;

import java.util.Date;

public class SysUser {

    private int id;
    private int org_id;
    private int client_id;
    private String userName;
    private String password;
    private String realName;
    private String sex;
    private String email;
    private String phone;
    private String mobile;
    private String description;
    private char isActive;
    private Date created;
    private int createby;
    private Date updated;
    private int updateby;
    private char remove;
    private String datafilter;
    private String theme;
    private String defaultpage;
    private String logoimage;
    private String qqopenid;
    private char appversion;
    private String jsonauth;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
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

    public String getDatafilter() {
        return datafilter;
    }

    public void setDatafilter(String datafilter) {
        this.datafilter = datafilter;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDefaultpage() {
        return defaultpage;
    }

    public void setDefaultpage(String defaultpage) {
        this.defaultpage = defaultpage;
    }

    public String getLogoimage() {
        return logoimage;
    }

    public void setLogoimage(String logoimage) {
        this.logoimage = logoimage;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public char getAppversion() {
        return appversion;
    }

    public void setAppversion(char appversion) {
        this.appversion = appversion;
    }

    public String getJsonauth() {
        return jsonauth;
    }

    public void setJsonauth(String jsonauth) {
        this.jsonauth = jsonauth;
    }

}
