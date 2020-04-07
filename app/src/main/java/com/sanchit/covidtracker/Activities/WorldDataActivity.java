package com.sanchit.covidtracker.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.Network.WorldSoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.databinding.ActivityWorldDataBinding;
import com.sanchit.covidtracker.response.WorldSummary.CountriesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldDataActivity extends AppCompatActivity {

    private ActivityWorldDataBinding binding;
    private Context context;
    private Animation rotateAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_world_data);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = this;
      //  getData();


        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.imgVirus.startAnimation(rotateAnimation);


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }






    private void getData() {
        Call<CountriesResponse> call = WorldSoleInstance.getApiServiceInstance().getSummary();

        call.enqueue(new Callback<CountriesResponse>() {
            @Override
            public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
                if(response !=null)
                {
                    if(response.body() !=null)
                    {
                        Toast.makeText(WorldDataActivity.this, ""+response.body().getCountries().size(), Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(WorldDataActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(WorldDataActivity.this, "null response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CountriesResponse> call, Throwable t) {
                Toast.makeText(WorldDataActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
