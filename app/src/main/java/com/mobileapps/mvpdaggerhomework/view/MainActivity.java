package com.mobileapps.mvpdaggerhomework.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.mobileapps.mvpdaggerhomework.InitApplication;
import com.mobileapps.mvpdaggerhomework.MainContract;
import com.mobileapps.mvpdaggerhomework.R;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.component.DaggerActivityComponent;
import com.mobileapps.mvpdaggerhomework.dependencyinjection.module.MvpModule;
import com.mobileapps.mvpdaggerhomework.model.Model;

import javax.inject.Inject;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainContract.ViewCallBack {

ImageView ivImage;

    @Inject
    MainContract.PresenterCallBack presenterCallBack;

    @Inject
    Context mContext;

    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this).component())
                .mvpModule(new MvpModule(this))
                .build()
                .inject(this);

        ivImage=findViewById(R.id.ivSomeImage);

        Glide.with(this).load("https://i.imgflip.com/1b4vbo.jpg").into(ivImage);
        Glide.with(this).load("https://media.mnn.com/assets/images/2016/01/WaterFromPitcherPouredIntoGlass.jpg.653x0_q80_crop-smart.jpg").into(ivImage);
        Glide.with(this).load("https://i.redd.it/my01awg0m3b01.jpg").into(ivImage);
        Glide.with(this).load("https://pics.me.me/yall-better-be-drinking-water-be-healthy-21984980.png").into(ivImage);
        Glide.with(this).load("https://dailylolpics.com/34-funny-pictures-of-the-day-10").into(ivImage);

        }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
        Toast.makeText(mContext, "Quote Updated", Toast.LENGTH_SHORT).show();
    }
}
