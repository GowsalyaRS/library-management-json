package com.zsgs.librarymanagement.model;

public class User 
{
    private String name;
    private String email;
    private long phoneNo;
    private String address;
    public User()
    {
    }
    public User(String name, String email, long phoneNo, String address) 
    {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String toString()
    {
        return  "User name      : " + name +
              "\nEmail          : " + email +
              "\nPhone no       : " + phoneNo +
              "\nAddress        : " + address;
    }
}
