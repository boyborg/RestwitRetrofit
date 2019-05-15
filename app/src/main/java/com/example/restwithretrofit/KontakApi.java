package com.example.restwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface KontakApi {
    String BASE_URL= "http://192.168.6.200/api/";

    @GET("kontak")
    Call<List<Kontak>> getSemuaKontak();

    @GET("kontak/{id}")
    Call<Kontak> dapatkanKontak(@Path("id") int contacId);

    @POST("kontak")
    Call<Kontak> simpanKontak(@Body Kontak kontak);

    @FormUrlEncoded
    @POST("kontak")
    Call<Kontak> simpanKontak(@Field("nama")String nama,
                             @Field("email") String email,
                             @Field("nohp") String phone,
                             @Field("alamat") String alamat);

    @PUT("kontak/{id}")
    Call<Kontak> putKontak(@Path("id")int contacId,@Body Kontak kontak);

    @DELETE("kontak/{id}")
    Call<Void> hapusNow(@Path("id")int contacId);


}
