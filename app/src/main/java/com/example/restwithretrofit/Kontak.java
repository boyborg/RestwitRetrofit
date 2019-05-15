package com.example.restwithretrofit;

import com.google.gson.annotations.SerializedName;

public class Kontak {
    //klik kana->generate :membuat konstraktor

    public Kontak(String nama, String email, String phone, String alamat) {
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.alamat = alamat;
    }

    @SerializedName("id")
    private String idKontak;

    @SerializedName("nama")
    private String nama;

    @SerializedName("email")
    private String email;

    @SerializedName("nohp")
    private String phone;

    @SerializedName("alamat")
    private String alamat;

    public String dapatkanKontakId(){
        return idKontak;
    }

    public void setIdKontak(String idKontak){
        this.idKontak=idKontak;
    }

    public String getName(){
        return nama;
    }

    public void setName(String nama){
        this.nama = nama;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return phone;
    }

    public void setUsername(String nohp){
        this.phone = nohp;
    }

    public String getAddress(){
        return alamat;
    }

    public void setAddress(String address){
        this.alamat = address;
    }
}
