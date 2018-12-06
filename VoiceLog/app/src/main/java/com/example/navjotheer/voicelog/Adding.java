package com.example.navjotheer.voicelog;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Adding extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    static final public String WEBPAGE_NOTHING = "about:blank";
    static final public String PREF_URL = "restore_url";
    static final public String MYPREFS = "myprefs";
    static final public String MY_WEBPAGE = "https://users.soe.ucsc.edu/~dustinadams/CMPS121/assignment3/www/index.html";
    static final public String LOG_TAG = "webview_example";
    WebView myWebView;

    //added
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder;
    Random random;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer;


    @SuppressLint({"SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_adding);

        myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.addJavascriptInterface(new Adding.JavaScriptInterface(this), "Android");
        myWebView.loadUrl(MY_WEBPAGE);

        //added
        random = new Random(); // random object for filename

    }


    public class JavaScriptInterface {
        Context mContext;

        JavaScriptInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void record() {
            Log.i(LOG_TAG, "I am in the javascript call>");
            runOnUiThread(new Runnable() {
                public void run() {
                    //  Toast.makeText(Adding.this, "Recording",
                    //          Toast.LENGTH_LONG).show();
                    if (checkPermission()) {

                        // the path we'll be saving the file to. Notice it is from the external storage
                        // directory
                        AudioSavePathInDevice =
                                Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
                                        CreateRandomAudioFileName(5) + "AudioRecording.3gp";

                        MediaRecorderReady();

                        try {
                            // recording starts
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                        Toast.makeText(Adding.this, "Recording started",
                                Toast.LENGTH_LONG).show();
                    } else {
                        requestPermission();
                    }

                }

            });

        }


        @JavascriptInterface
        public void stop() {
            Log.i(LOG_TAG, "I am in the javascript call>");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Adding.this, "Stopping",
                            Toast.LENGTH_LONG).show();
                    mediaRecorder.stop(); // recording stops
                }
            });

        }

        @JavascriptInterface
        public void play() {
            Log.i(LOG_TAG, "I am in the javascript call> ");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Toast.makeText(Adding.this, "Playing",
                    //       Toast.LENGTH_LONG).show();
                    // object to play the audio
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(AudioSavePathInDevice);
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer.start();// play the audio
                    Toast.makeText(Adding.this, "Recording Playing",
                            Toast.LENGTH_LONG).show();
                }

            });
        }

        @JavascriptInterface
        public void stoprec() {
            Log.i(LOG_TAG, "I am in the javascript call> ");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Adding.this, "Stopping recording",
                            Toast.LENGTH_LONG).show();

                    if (mediaPlayer != null) {
                        mediaPlayer.stop(); // stop audio
                        mediaPlayer.release(); // free up memory
                        MediaRecorderReady();
                    }
                }
            });
        }

        @JavascriptInterface
        public void exit() {
            Log.i(LOG_TAG, "I am in the javascript call> ");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Adding.this, "Exiting",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Adding.this, MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }
            });
        }


        // initialize recorder object
        public void MediaRecorderReady() {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            mediaRecorder.setOutputFile(AudioSavePathInDevice);
        }
    }
    // method to create a random file name
    public String CreateRandomAudioFileName(int string){
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++ ;
        }
        return stringBuilder.toString();
    }
    // permissions from user
    private void requestPermission() {
        ActivityCompat.requestPermissions(Adding.this, new
                String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }
    // callback method
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(Adding.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Adding.this,"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }



}







