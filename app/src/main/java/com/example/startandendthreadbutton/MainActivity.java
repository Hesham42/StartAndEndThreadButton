package com.example.startandendthreadbutton;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View view) {
        startNewActivity(this,"com.example.threadbackgroundstratandendthread");
        final Intent i;
        i = new Intent();
        i.putExtra("Start",true);
        i.setAction("com.pkg.perform.Ruby");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        this.sendBroadcast(i);
    }
    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }




    public void stop(View view) {
        startNewActivity(this,"com.example.threadbackgroundstratandendthread");
        final Intent i;
        i = new Intent();
        i.putExtra("Start",false);
        i.setAction("com.pkg.perform.Ruby");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        this.sendBroadcast(i);
    }


    }

