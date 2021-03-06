package com.sanchit.covidtracker.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.eftimoff.androidplayer.Player;
import com.eftimoff.androidplayer.actions.property.PropertyAction;
import com.sanchit.covidtracker.Adapters.UpdateAdapter;
import com.sanchit.covidtracker.Network.SoleInstance;
import com.sanchit.covidtracker.Network.WorldSoleInstance;
import com.sanchit.covidtracker.R;
import com.sanchit.covidtracker.Utils.PreferencesUtil;
import com.sanchit.covidtracker.databinding.ActivityHomeBinding;
import com.sanchit.covidtracker.response.UpdatesResponse;
import com.sanchit.covidtracker.response.WorldSummary.CountriesResponse;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    Context context;
    Animation rotateAnimation;
    private List<UpdatesResponse> updateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        getData();
        animatesample(binding.iamge1, binding.iamge2, binding.btnCovidResources,binding.btnStatsAnalysis,binding.btnInformation,binding.btnEmergencyContacts, binding.iamge4);
        animation();
        getUpdates();





    }

    private void animatesample(ConstraintLayout iamge1, ConstraintLayout iamge2, Button btnCovidResources, Button btnStatsAnalysis, Button btnInformation, Button btnEmergencyContacts, LinearLayout iamge4) {

        final PropertyAction fabAction = PropertyAction.newPropertyAction(iamge2).scaleX(0).scaleY(0).duration(750).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction headerAction = PropertyAction.newPropertyAction(iamge1).interpolator(new DecelerateInterpolator()).translationY(-200).duration(550).alpha(0.4f).build();
        final PropertyAction fabAction1 = PropertyAction.newPropertyAction(btnCovidResources).scaleX(0).scaleY(0).duration(400).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction fabAction2 = PropertyAction.newPropertyAction(btnStatsAnalysis).scaleX(0).scaleY(0).duration(400).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction fabAction3 = PropertyAction.newPropertyAction(btnInformation).scaleX(0).scaleY(0).duration(400).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction fabAction4 = PropertyAction.newPropertyAction(btnEmergencyContacts).scaleX(0).scaleY(0).duration(400).interpolator(new AccelerateDecelerateInterpolator()).build();
        final PropertyAction bottomAction2 = PropertyAction.newPropertyAction(iamge4).translationY(500).duration(750).alpha(0f).build();

        Player.init().
                animate(headerAction).
                then().
                animate(fabAction).
                then().
                animate(fabAction1).
                then().
                animate(fabAction2).
                then().
                animate(fabAction3).
                then().
                animate(fabAction4).
                then().
                animate(bottomAction2).
                play();

    }


    private void getData() {
        Call<CountriesResponse> call = WorldSoleInstance.getApiServiceInstance().getSummary();

        call.enqueue(new Callback<CountriesResponse>() {
            @Override
            public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
                if (response != null) {
                    if (response.body() != null) {

                        DecimalFormat formatter = new DecimalFormat("#,##,###");
                        String get_value = formatter.format(response.body().getGlobal().getTotalConfirmed());
                        PreferencesUtil.setTotalcases(get_value);
                        binding.tvtoatalcases.setText(String.valueOf(PreferencesUtil.getTotalcases()));


                    } else {
                        binding.tvtoatalcases.setText(String.valueOf(PreferencesUtil.getTotalcases()));
                    }
                } else {


                }
            }

            @Override
            public void onFailure(Call<CountriesResponse> call, Throwable t) {
            }
        });
    }

    private void getUpdates() {

        Call<List<UpdatesResponse>> call = SoleInstance.getApiServiceInstance().getUpdates();

        call.enqueue(new Callback<List<UpdatesResponse>>() {
            @Override
            public void onResponse(Call<List<UpdatesResponse>> call, Response<List<UpdatesResponse>> response) {
                if(response.body() !=null)
                {
                    if(response.body().size() > 0)
                    {
                        updateList = response.body();
                        Collections.reverse(updateList);
                        UpdateAdapter adapter;
                        adapter = new UpdateAdapter(updateList,context);
                        binding.rvUpdates.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        binding.rvUpdates.setAdapter(adapter);
                        binding.rvUpdates.setItemViewCacheSize(updateList.size());

                        final int speedScroll = 5000;
                        final Handler handler = new Handler();
                        final Runnable runnable = new Runnable() {
                            int count = 0;
                            boolean flag = true;
                            @Override
                            public void run() {
                                if(count < updateList.size()){
                                    if(count==updateList.size()-1){
                                        flag = false;
                                    }else if(count == 0){
                                        flag = true;
                                    }
                                    if(flag) count++;
                                    else count--;

                                    binding.rvUpdates.smoothScrollToPosition(count);
                                    handler.postDelayed(this,speedScroll);
                                }
                            }
                        };

                        handler.postDelayed(runnable,speedScroll);



                    }else
                    {
                        Toast.makeText(HomeActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(HomeActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UpdatesResponse>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }







    private void animation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.imageView7.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.reverse_rotate);
        binding.imageView8.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.reverse_rotate);
        binding.imageView5.startAnimation(rotateAnimation);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        binding.imageView4.startAnimation(rotateAnimation);


    }


}
