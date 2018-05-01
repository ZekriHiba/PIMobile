/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.Amal;

/**
 *
 * @author amalg
 */
public class Users {
    public enum UType {MEMBER,VETO,DRESSEUR,ADMIN}
    private  int id;
    private  int phone;
    private String login;
    private String pwd;
    private String fName;
    private String lName;
    private String image;
    private String email;
    private String address;
    private UType type;

    public int getId() {
        return id;
    }

    public Users(int id) {this.id=id;
    }
   
    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", phone=" + phone + ", login=" + login + ", pwd=" + pwd + ", fName=" + fName + ", lName=" + lName + ", image=" + image + ", email=" + email + ", address=" + address + ", type=" + type + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public UType getType() {
        return type;
    }

    public void setType(UType type) {
        this.type = type;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
