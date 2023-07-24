package com.example.unity_demo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class Unity_main extends AppCompatActivity {

    Button button1;
    LinearLayout linearLayout;
    String Bannerid="Banner_Android";
    String placementId = "Interstitial_Android";
    private String unityGameID = "5057295";  //your id
    private boolean testMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unity_add);
        button1=findViewById(R.id.btn);
        linearLayout=findViewById(R.id.bannerAds);
        UnityAds.initialize(this, unityGameID, testMode);
        BannerView view=new BannerView(this,Bannerid,new UnityBannerSize(380,80));

                view.load();
        linearLayout.addView(view);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnityAds.show(Unity_main.this,placementId);
            }
        });
    }
}