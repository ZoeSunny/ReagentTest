package com.example.reagent20;


import android.app.*;
import com.example.detectct.*;
import android.view.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import com.example.yolo_v3.*;

public class TestActivity extends Activity
{
    private static final int COPY_FALSE = -1;
    private static final int DETECT_FINISH = 1;
    private Handler mHandler;
    private ProgressDialog pd;
    private int reagent_strip_type;
    private int reagent_type;
    Bitmap srcimg;
    String srcimgpath;
    ImageView view_srcimg;
    TextView view_status;

    public TestActivity() {
        this.pd = null;
        this.mHandler = new Handler() {
            public void handleMessage(final Message message) {
                Label_0337: {
                    if (message.what != 1) {
                        break Label_0337;
                    }
                    final double[] array = (double[])message.obj;
                    System.out.println("..............." + array[0] + " " + array[1] + " " + array[2]);
                    try {
                        final String value = String.valueOf(Main.startProcess(null, TestActivity.this.srcimgpath, 0, String.valueOf(TestActivity.this.reagent_type), String.valueOf(TestActivity.this.reagent_strip_type), array));
                        if (value == null) {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u8bd5\u5242\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20", 0).show();
                        }
                        else if (value.equals("-1.0")) {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u8bd5\u5242\u68c0\u6d4b\u6210\u529f", 0).show();
                            TestActivity.this.view_status.setText((CharSequence)"\u68c0\u6d4b\u6d53\u5ea6\uff1a\u9ad8\u6d53\u5ea6");
                        }
                        else if (value.equals("-2.0")) {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u68c0\u6d4bC\u7ebf\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20\u8bd5\u5242", 0).show();
                        }
                        else if (value.equals("-3.0")) {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u8bd5\u5242\u8bc6\u522b\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u4e0a\u4f20\u8bd5\u5242", 0).show();
                        }
                        else if (value.equals("-4.0")) {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u4e0d\u5b58\u5728\u9009\u62e9\u7c7b\u578b\u6807\u51c6\u7ec4\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9\u7c7b\u578b", 1).show();
                        }
                        else {
                            Toast.makeText(TestActivity.this.getApplicationContext(), (CharSequence)"\u8bd5\u5242\u68c0\u6d4b\u6210\u529f", 0).show();
                            TestActivity.this.view_status.setText((CharSequence)("\u68c0\u6d4b\u6d53\u5ea6\uff1a" + value));
                        }
                        TestActivity.this.view_status.setText((CharSequence)("\u68c0\u6d4b\u6d53\u5ea6\u7ed3\u679c:" + value));
                        TestActivity.this.pd.dismiss();
                        return;
//                        Label_0345: {
//                            return;
//                        }
                    }
                    // iftrue(Label_0345:, message.what != -1)
                    catch (Exception ex) {}
                }
            }
        };
    }

    public void onClick(final View view) {
        switch (view.getId()) {
            default: {}
            case 2131230755: {
                final Intent intent = new Intent();
                intent.setClass((Context)this, (Class)MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
            }
            case 2131230817: {
                final Intent intent2 = new Intent();
                intent2.putExtra("standard_Value", "");
                intent2.putExtra("reagent_type", this.reagent_type);
                intent2.putExtra("reagent_strip_type", this.reagent_strip_type);
                intent2.setClass((Context)this, (Class)CameraActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent2);
            }
        }
    }

    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_test);
        (this.pd = new ProgressDialog((Context)this)).setTitle((CharSequence)"\u63d0\u793a");
        this.pd.setIcon(R.mipmap.ic_launcher);
        this.pd.setMessage((CharSequence)"\u8bd5\u5242\u68c0\u6d4b\u4e2d\uff0c\u8bf7\u7a0d\u540e...");
        this.pd.setCanceledOnTouchOutside(false);
        this.pd.setIndeterminate(false);
        this.pd.setProgressStyle(0);
        this.view_srcimg = (ImageView)this.findViewById(R.id.srcimg);
        this.view_status = (TextView)this.findViewById(R.id.status);
        this.view_srcimg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        final Intent intent = this.getIntent();
        final String stringExtra = intent.getStringExtra("Take_Photo_Path");
        this.reagent_type = intent.getIntExtra("reagent_type", -1);
        this.reagent_strip_type = intent.getIntExtra("reagent_strip_type", -1);
        if (stringExtra != null) {
            this.srcimgpath = stringExtra;
            this.srcimg = BitmapFactory.decodeFile(this.srcimgpath);
            this.view_srcimg.setImageBitmap(this.srcimg);
            this.yoloDetect();
        }
    }

    public void yoloDetect() {
        this.pd.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final double[] testyolo = new Yolo().testyolo(TestActivity.this.srcimgpath);
                final double[] obj = { 0.0, 0.0, testyolo[2] * TestActivity.this.srcimg.getWidth(), testyolo[3] * TestActivity.this.srcimg.getHeight() };
                obj[0] = testyolo[0] * TestActivity.this.srcimg.getWidth() + 1.0 - obj[2] / 2.0;
                obj[1] = testyolo[1] * TestActivity.this.srcimg.getHeight() + 1.0 - obj[3] / 2.0;
                obj[2] += obj[0];
                obj[3] += obj[1];
                final Message message = new Message();
                message.what = 1;
                message.obj = obj;
                TestActivity.this.mHandler.sendMessage(message);
            }
        }).start();
    }
}
