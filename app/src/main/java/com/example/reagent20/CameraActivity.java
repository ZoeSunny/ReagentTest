package com.example.reagent20;


import android.app.*;
import android.widget.*;
import android.os.*;
import android.content.*;
import android.view.*;

public class CameraActivity extends Activity
{
    private CameraSurfaceView mCameraSurfaceView;
    private int reagent_strip_type;
    private int reagent_type;
    String standardValue;
    private ImageButton takePicBtn;

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        this.setContentView(R.layout.activity_camera);
        final Intent intent = this.getIntent();
        this.standardValue = intent.getStringExtra("standard_Value");
        this.reagent_type = intent.getIntExtra("reagent_type", -1);
        this.reagent_strip_type = intent.getIntExtra("reagent_strip_type", -1);
        System.out.println("standatdValue:" + this.standardValue);
        this.mCameraSurfaceView = (CameraSurfaceView)this.findViewById(R.id.cameraSurfaceView);
        (this.takePicBtn = (ImageButton)this.findViewById(R.id.takePic)).setOnClickListener((View.OnClickListener)new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener
    {
        public void onClick(final View view) {
            CameraActivity.this.mCameraSurfaceView.focus(CameraActivity.this.standardValue, CameraActivity.this.reagent_type, CameraActivity.this.reagent_strip_type);
        }
    }
}
