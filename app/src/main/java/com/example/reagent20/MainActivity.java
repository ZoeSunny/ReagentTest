package com.example.reagent20;

import java.util.*;

import android.app.AlertDialog;
//import android.support.v4.content.*;
import android.support.v4.app.*;
import android.app.*;
import java.io.*;
import android.view.*;
import android.content.*;
import android.os.*;
import android.annotation.*;
//import android.support.annotation.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity
{
    private static int reagent_strip_type;
    private static int reagent_type;
    private static int rgtstypelen;
    private static int rgtypelen;
    private long exitTime;
    private Spinner getSpinner_reagent_strip;
    Handler handler1;
    List<String> mPermissionList;
    private final int mRequestCode;
    String[] permissions;
    private Spinner spinner_reagent;

    static {
        MainActivity.rgtypelen = 0;
        MainActivity.rgtstypelen = 0;
        MainActivity.reagent_type = -1;
        MainActivity.reagent_strip_type = -1;
    }

    public MainActivity() {
        this.mRequestCode = 100;
        this.permissions = new String[] { "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE" };
        this.mPermissionList = new ArrayList<String>();
        this.exitTime = 0L;
        this.handler1 = new Handler() {
            public void handleMessage(final Message message) {
                super.handleMessage(message);
                final String s = (String)message.obj;
                final TreeMap<Integer, String> treeMap = (TreeMap<Integer, String>)new TreeMap<Integer, String>();
                final TreeMap<Integer, String> treeMap2 = (TreeMap<Integer, String>)new TreeMap<Integer, String>();
                final String[] split = s.split(",");
                for (int i = 0; i < split.length; ++i) {
                    final String[] split2 = split[i].split("=");
                    if (Integer.parseInt(split2[0].trim()) < 10000) {
                        treeMap.put(Integer.parseInt(split2[0].trim()), split2[1].trim());
                    }
                    else {
                        treeMap2.put(Integer.parseInt(split2[0].trim()) - 10000, split2[1].trim());
                    }
                }
                final ArrayList list = new ArrayList<Object>();
                for (int j = 1; j <= treeMap.size(); ++j) {
                    list.add(treeMap.get(j));
                }
                list.add("\u8bd5\u5242\u7c7b\u522b");
                final simpleArrayAdapter adapter = new simpleArrayAdapter(MainActivity.this.getApplicationContext(), 17367048, list);
                MainActivity.rgtypelen = adapter.getCount();
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);//17367049
                MainActivity.this.spinner_reagent.setAdapter((SpinnerAdapter)adapter);
                if (MainActivity.reagent_type != -1) {
                    MainActivity.this.spinner_reagent.setSelection(MainActivity.reagent_type, true);
                }
                else {
                    MainActivity.this.spinner_reagent.setSelection(list.size() - 1, true);
                }
                final ArrayList list2 = new ArrayList<Object>();
                for (int k = 1; k <= treeMap2.size(); ++k) {
                    list2.add(treeMap2.get(k));
                }
                list2.add("\u8bd5\u5242\u6761\u7c7b\u522b");
                final simpleArrayAdapter adapter2 = new simpleArrayAdapter(MainActivity.this.getApplicationContext(), 17367048, list2);
                MainActivity.rgtstypelen = adapter2.getCount();
                adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);//17367049
                MainActivity.this.getSpinner_reagent_strip.setAdapter((SpinnerAdapter)adapter2);
                if (MainActivity.reagent_strip_type != -1) {
                    MainActivity.this.getSpinner_reagent_strip.setSelection(MainActivity.reagent_strip_type, true);
                    return;
                }
                MainActivity.this.getSpinner_reagent_strip.setSelection(list2.size() - 1, true);
            }
        };
    }

    private void initPermission() {
        this.mPermissionList.clear();
        for (int i = 0; i < this.permissions.length; ++i) {
            if (ContextCompat.checkSelfPermission((Context)this, this.permissions[i]) != 0) {
                this.mPermissionList.add(this.permissions[i]);
            }
        }
        if (this.mPermissionList.size() > 0) {
            ActivityCompat.requestPermissions((Activity)this, this.permissions, 100);
        }
    }

    public void copyFilesFassets(final Context context, final String s, final String s2) throws IOException {
        InputStream open = null;
        FileOutputStream fileOutputStream = null;
        Label_0173: {
            try {
                final String[] list = context.getAssets().list(s);
                if (list.length > 0) {
                    new File(s2).mkdirs();
                    for (int length = list.length, i = 0; i < length; ++i) {
                        final String s3 = list[i];
                        this.copyFilesFassets(context, s + "/" + s3, s2 + "/" + s3);
                    }
                }
                else {
                    open = context.getAssets().open(s);
                    fileOutputStream = new FileOutputStream(new File(s2));
                    final byte[] array = new byte[1024];
                    while (true) {
                        final int read = open.read(array);
                        if (read == -1) {
                            break Label_0173;
                        }
                        fileOutputStream.write(array, 0, read);
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }
        fileOutputStream.flush();
        open.close();
        fileOutputStream.close();
    }

    public void onClick(final View view) throws IOException {
        switch (view.getId()) {
            default: {
                Toast.makeText((Context)this, (CharSequence)"\u6309\u94ae\u51fa\u73b0\u5f02\u5e38", Toast.LENGTH_SHORT).show();
                break;
            }
            case 2131230892: {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u786e\u8ba4\u5df2\u7ecf\u63d2\u5165SD\u5361", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_type != MainActivity.rgtypelen && MainActivity.reagent_strip_type != MainActivity.rgtstypelen) {
                    final Intent intent = new Intent();
                    intent.putExtra("reagent_type", MainActivity.reagent_type + 1);
                    intent.putExtra("reagent_strip_type", MainActivity.reagent_strip_type + 1);
                    intent.setClass((Context)this, (Class)StandardActivity.class);
                    //intent.setFlags();//67108864
                    this.startActivity(intent);
                    return;
                }
                if (MainActivity.reagent_type == MainActivity.rgtypelen && MainActivity.reagent_strip_type == MainActivity.rgtstypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u7c7b\u522b\u4e0e\u8bd5\u5242\u6761\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_type == MainActivity.rgtypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_strip_type == MainActivity.rgtstypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u6761\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            }
            case 2131230763: {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u786e\u8ba4\u5df2\u7ecf\u63d2\u5165SD\u5361", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_type != MainActivity.rgtypelen && MainActivity.reagent_strip_type != MainActivity.rgtstypelen) {
                    final Intent intent2 = new Intent();
                    intent2.putExtra("standard_Value", "");
                    intent2.putExtra("reagent_type", MainActivity.reagent_type + 1);
                    intent2.putExtra("reagent_strip_type", MainActivity.reagent_strip_type + 1);
                    intent2.setClass((Context)this, (Class)CameraActivity.class);
                    // intent2.setFlags(67108864);
                    this.startActivity(intent2);
                    return;
                }
                if (MainActivity.reagent_type == MainActivity.rgtypelen && MainActivity.reagent_strip_type == MainActivity.rgtstypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u7c7b\u522b\u4e0e\u8bd5\u5242\u6761\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_type == MainActivity.rgtypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MainActivity.reagent_strip_type == MainActivity.rgtstypelen) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u8bf7\u9009\u62e9\u8bd5\u5242\u6761\u7c7b\u522b", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            }
            case 2131230799: {
                this.copyFilesFassets((Context)this, "cfg", "/sdcard/yolo/cfg");
                this.copyFilesFassets((Context)this, "data", "/sdcard/yolo/data");
                this.copyFilesFassets((Context)this, "weights", "/sdcard/yolo/weights");
                this.copyFilesFassets((Context)this, "standardImg", "/sdcard/yolo/standardImg");
                this.copyFilesFassets((Context)this, "testImg", "/sdcard/yolo/testImg");
                Toast.makeText(this.getApplicationContext(), (CharSequence)"\u89e3\u538b\u5b8c\u6210", Toast.LENGTH_SHORT).show();
            }
            case 2131230814: {
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((Context)this);
                alertDialogBuilder.setIcon(R.drawable.yologo_1);
                alertDialogBuilder.setTitle((CharSequence)"\u8bf4\u660e");
                alertDialogBuilder.setMessage((CharSequence)"\u8bd5\u5242\u6d53\u5ea6\u68c0\u6d4b\u7a0b\u5e8f \n\u82e5\u8981\u4f7f\u7528\u6b64\u8f6f\u4ef6\n\u8bf7\u5f00\u542f\u5b58\u50a8\u6743\u9650\u4ee5\u53ca\u76f8\u673a\u6743\u9650\n\u8c22\u8c22\u60a8\u7684\u4f7f\u7528\n");
                alertDialogBuilder.setPositiveButton((CharSequence)"Back", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialogInterface, final int n) {
                    }
                });
                alertDialogBuilder.show();
            }
            case 2131230753: {
                if (System.currentTimeMillis() - this.exitTime > 2000L) {
                    Toast.makeText(this.getApplicationContext(), (CharSequence)"\u518d\u6309\u4e00\u6b21\u9000\u51fa\u7a0b\u5e8f\uff01", Toast.LENGTH_SHORT).show();
                    this.exitTime = System.currentTimeMillis();
                    return;
                }
                this.finish();
                System.exit(0);
            }
        }
    }

    @TargetApi(23)
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 23) {
            this.initPermission();
        }
        this.spinner_reagent = (Spinner)this.findViewById(R.id.spinner_reagent);
        this.getSpinner_reagent_strip = (Spinner)this.findViewById(R.id.spinner_reagent_strip);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Message message = new Message();
                    message.obj = "1=\u7626\u8089\u7cbe, 10001=\u4e09\u65b9\u6e90, 2=\u9152\u9a7e, 10002=\u56db\u65b9\u6e90";
                    MainActivity.this.handler1.sendMessage(message);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        this.spinner_reagent.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new ProvOnItemSelectedListener());
        this.getSpinner_reagent_strip.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new ProvOnItemSelectedListener());
    }

    public void onRequestPermissionsResult(int i, final String[] array, final int[] array2) {//@NonNull
        super.onRequestPermissionsResult(i, array, array2);
        boolean b = false;
        if (100 == i) {
            for (i = 0; i < array2.length; ++i) {
                if (array2[i] == -1) {
                    b = true;
                }
            }
            if (b) {
                Toast.makeText(this.getApplicationContext(), (CharSequence)"\u82e5\u8981\u4f7f\u7528\u6b64\u8f6f\u4ef6\uff0c\u8bf7\u5f00\u542f\u6743\u9650", Toast.LENGTH_SHORT).show();
                this.initPermission();
            }
        }
    }

    private class ProvOnItemSelectedListener implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
            switch (adapterView.getId()) {
                default: {}
                case 2131230883: {
                    MainActivity.reagent_type = n;
                }
                case 2131230884: {
                    MainActivity.reagent_strip_type = n;
                }
            }
        }

        public void onNothingSelected(final AdapterView<?> adapterView) {
            Toast.makeText(MainActivity.this.getApplicationContext(), (CharSequence)"\u4ec0\u4e48\u4e5f\u6ca1\u9009\uff01", Toast.LENGTH_SHORT).show();
        }
    }

    public class simpleArrayAdapter<T> extends ArrayAdapter
    {
        public simpleArrayAdapter(final Context context, final int n, final List<T> list) {
            super(context, n, (List)list);
        }

        public int getCount() {
            int count;
            final int n = count = super.getCount();
            if (n > 0) {
                count = n - 1;
            }
            return count;
        }
    }
}
