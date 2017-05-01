package com.hemant.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import net.pubnative.library.interstitial.PubnativeInterstitial;
import net.pubnative.library.request.PubnativeRequest;
import net.pubnative.library.request.model.PubnativeAdModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        PubnativeRequest request = new PubnativeRequest();
        request.setParameter(PubnativeRequest.Parameters.APP_TOKEN, "0b9534060b782e80413bb7d7008ffd6d50b319b43f11710de3319f23893e091f");
        request.setParameter(PubnativeRequest.Parameters.ZONE_ID, "1");
        request.setTestMode(true);
        request.start(this, new PubnativeRequest.Listener() {
            @Override
            public void onPubnativeRequestSuccess(PubnativeRequest request, List<PubnativeAdModel> ads) {
                // TODO Auto-generated method stub
                PubnativeInterstitial interstitial = new PubnativeInterstitial();
                interstitial.setListener(new PubnativeInterstitial.Listener() {
                    @Override
                    public void onPubnativeInterstitialLoadFinish(PubnativeInterstitial interstitial) {
                        interstitial.show();
                    }

                    @Override
                    public void onPubnativeInterstitialLoadFail(PubnativeInterstitial interstitial, Exception exception) {

                    }

                    @Override
                    public void onPubnativeInterstitialShow(PubnativeInterstitial interstitial) {

                    }

                    @Override
                    public void onPubnativeInterstitialImpressionConfirmed(PubnativeInterstitial interstitial) {

                    }

                    @Override
                    public void onPubnativeInterstitialClick(PubnativeInterstitial interstitial) {

                    }

                    @Override
                    public void onPubnativeInterstitialHide(PubnativeInterstitial interstitial) {

                    }
                });
                interstitial.load(MainActivity.this, "0b9534060b782e80413bb7d7008ffd6d50b319b43f11710de3319f23893e091f", "1");

            }

            @Override
            public void onPubnativeRequestFailed(PubnativeRequest request, Exception ex) {
                // TODO Auto-generated method stub
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
