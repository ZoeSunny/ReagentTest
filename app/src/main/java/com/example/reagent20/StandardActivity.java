package com.example.reagent20;



import android.app.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import com.example.detectct.*;
import android.os.*;

public class StandardActivity extends Activity
{
    EditText edit;
    TextView lblTitle;
    private ProgressDialog pd;
    private int reagent_strip_type;
    private int reagent_type;

    public StandardActivity() {
        this.pd = null;
    }

    public void onClick(final View view) {
        switch (view.getId()) {
            default: {
                Toast.makeText((Context)this, (CharSequence)"\u6309\u94ae\u51fa\u73b0\u5f02\u5e38", Toast.LENGTH_SHORT).show();
            }
            case 2131230754: {
                final Intent intent = new Intent();
                intent.setClass((Context)this, (Class)MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//Intent.FLAG_ACTIVITY_CLEAR_TOP
                this.startActivity(intent);
            }
            case 2131230776: {
                try {
                    this.pd.show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Main.startProcess(StandardActivity.this.pd, "", 1, String.valueOf(StandardActivity.this.reagent_type), String.valueOf(StandardActivity.this.reagent_strip_type), null);
                            }
                            catch (Exception ex) {}
                        }
                    }).start();
                }
                catch (Exception ex) {}
            }
            case 2131230900: {
                final String trim = this.edit.getText().toString().trim();
                if (trim.equals("")) {
                    Toast.makeText((Context)this, (CharSequence)"\u8bf7\u8f93\u5165\u6d53\u5ea6",  Toast.LENGTH_SHORT).show();
                    return;
                }
                final Intent intent2 = new Intent();
                intent2.putExtra("standard_Value", trim);
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
        this.setContentView(R.layout.activity_standard);
        final Intent intent = this.getIntent();
        this.reagent_type = intent.getIntExtra("reagent_type", -1);
        this.reagent_strip_type = intent.getIntExtra("reagent_strip_type", -1);
        (this.lblTitle = (TextView)this.findViewById(R.id.displaytextview)).setText((CharSequence)"\u8bf7\u8f93\u5165\u6d53\u5ea6\uff1a");
        (this.pd = new ProgressDialog((Context)this)).setTitle((CharSequence)"\u63d0\u793a");
        this.pd.setIcon(R.mipmap.ic_launcher);
        this.pd.setMessage((CharSequence)"\u6807\u51c6\u7ec4\u8ba1\u7b97\u4e2d...");
        this.pd.setCanceledOnTouchOutside(false);
        this.pd.setIndeterminate(false);
        this.pd.setProgressStyle(1);
        this.pd.setMax(5);
        this.edit = (EditText)this.findViewById(R.id.nongduvalue);
    }
}
