package com.example.restwithretrofit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private TextView txtHasil;
    KontakApi kontakApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHasil = (TextView) findViewById(R.id.textResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KontakApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        kontakApi = retrofit.create(KontakApi.class);
        putKontak();
    }

        public void getSemua() {
            Call<List<Kontak>> call = kontakApi.getSemuaKontak();
            call.enqueue(new Callback<List<Kontak>>() {
                @Override
                public void onResponse(Call<List<Kontak>> call, Response<List<Kontak>> response) {
                    if (!response.isSuccessful()) {
                        txtHasil.setText("Code Response: " + response.code());
                        return;
                    }
                    List<Kontak> kontaks = response.body();
                    for (Kontak kontak : kontaks) {
                        String content = "";
                        content += "ID      :" + kontak.dapatkanKontakId() + "\n";
                        content += "Nama    :" + kontak.getName() + "\n";
                        content += "Email    :" + kontak.getEmail() + "\n";
                        content += "NoHp     :" + kontak.getUsername() + "\n";
                        content += "Alamat   :" + kontak.getAddress() + "\n\n";

                        txtHasil.append(content);


                    }
                }

                @Override
                public void onFailure(Call<List<Kontak>> call, Throwable t) {
                    txtHasil.setText(t.getMessage());

                }
            });
        }

        public void geID(int id){
            Call<Kontak> call = kontakApi.dapatkanKontak(id);
            call.enqueue(new Callback<Kontak>() {
                @Override
                public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                    if (!response.isSuccessful()) {
                        txtHasil.setText("Code Response: " + response.code());
                        return;
                    }
                    Kontak kontak = response.body();
                        String content = "";
                        content += "ID      :" + kontak.dapatkanKontakId() + "\n";
                        content += "Nama    :" + kontak.getName() + "\n";
                        content += "Email    :" + kontak.getEmail() + "\n";
                        content += "NoHp     :" + kontak.getUsername() + "\n";
                        content += "Alamat   :" + kontak.getAddress() + "\n\n";

                        txtHasil.append(content);



                }

                @Override
                public void onFailure(Call<Kontak> call, Throwable t) {
                    txtHasil.setText(t.getMessage());

                }
            });

        }

        public void postKontak(){
            Kontak fill=new Kontak("Boy","https://github.com/boyborg","089650805837","Cianjur");
            Call<Kontak> call = kontakApi.simpanKontak(fill);
            call.enqueue(new Callback<Kontak>() {
                @Override
                public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                    if (!response.isSuccessful()) {
                        txtHasil.setText("Code Response: " + response.code());
                        return;
                    }
                    Kontak kontak = response.body();
                    String content = "";
                    content += "ID      :" + kontak.dapatkanKontakId() + "\n";
                    content += "Nama    :" + kontak.getName() + "\n";
                    content += "Email    :" + kontak.getEmail() + "\n";
                    content += "NoHp     :" + kontak.getUsername() + "\n";
                    content += "Alamat   :" + kontak.getAddress() + "\n\n";

                    txtHasil.append(content);



                }

                @Override
                public void onFailure(Call<Kontak> call, Throwable t) {
                    txtHasil.setText(t.getMessage());

                }
            });

        }

        public void hapusKOntak(int id){
        Call<Void> call=kontakApi.hapusNow(id);
        call.enqueue(new Callback<Void>(){
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){
                    return;
                }
                txtHasil.setText("Code Response : "+response.code());

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                txtHasil.setText(t.getMessage());

            }
        });

        }

        public void putKontak(){
            Kontak fill=new Kontak("Boy","https://github.com/boyborg","089650805837","Cianjur");
            Call<Kontak> call = kontakApi.putKontak(3,fill);
            call.enqueue(new Callback<Kontak>() {
                @Override
                public void onResponse(Call<Kontak> call, Response<Kontak> response) {
                    if (!response.isSuccessful()) {
                        txtHasil.setText("Code Response: " + response.code());
                        return;
                    }
                    Kontak kontak = response.body();
                    String content = "";
                    content += "ID      :" + kontak.dapatkanKontakId() + "\n";
                    content += "Nama    :" + kontak.getName() + "\n";
                    content += "Email    :" + kontak.getEmail() + "\n";
                    content += "NoHp     :" + kontak.getUsername() + "\n";
                    content += "Alamat   :" + kontak.getAddress() + "\n\n";

                    txtHasil.append(content);



                }

                @Override
                public void onFailure(Call<Kontak> call, Throwable t) {
                    txtHasil.setText(t.getMessage());

                }
            });

        }




    //+= penambahan + sebelum "=" berguna mengganti data tanpa mengubah data sebelumnya

}
