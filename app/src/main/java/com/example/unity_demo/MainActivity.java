package com.example.unity_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;

public class MainActivity extends AppCompatActivity {
    Button button1;
    String placementId = "Interstitial_Android";
    private String unityGameID = "4929839";  //your id
    private boolean testMode = false;

    IUnityAdsInitializationListener myAdsListener = new IUnityAdsInitializationListener() {
        @Override
        public void onInitializationComplete() {

            // ad load
            UnityAds.load(placementId ,loadListener);
            Toast.makeText(MainActivity.this, "Ad Initialized ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String s) {

        }
    };

    IUnityAdsLoadListener loadListener = new IUnityAdsLoadListener() {
        @Override
        public void onUnityAdsAdLoaded(String s) {

            Toast.makeText(MainActivity.this,
                    "AD LOADED ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUnityAdsFailedToLoad(String s, UnityAds.UnityAdsLoadError unityAdsLoadError, String s1) {

        }
    };

    IUnityAdsShowListener showListener = new IUnityAdsShowListener() {
        @Override
        public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {

            Toast.makeText(MainActivity.this, "AD not loaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUnityAdsShowStart(String s) {

            Toast.makeText(MainActivity.this, "Ad showing ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUnityAdsShowClick(String s) {

        }

        @Override
        public void onUnityAdsShowComplete(String s, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {

            // STEP 4
            UnityAds.load(placementId ,loadListener);
            Toast.makeText(MainActivity.this, "Ad Complete", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize(_savedInstanceState);

        UnityAds.initialize(getApplicationContext(), unityGameID, testMode, myAdsListener);

    }
    private void initialize(Bundle _savedInstanceState) {

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UnityAds.show(MainActivity.this, placementId,showListener);
                Toast.makeText(MainActivity.this, "Show btn clicked ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
