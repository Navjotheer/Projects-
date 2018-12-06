package com.example.alice.csa_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Tab3 extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab3, container, false);
        //fb button
        ImageButton facebookB = (ImageButton) rootView.findViewById(R.id.FacebookButton);
        facebookB.setOnClickListener(this);
        ImageButton instaB = (ImageButton) rootView.findViewById(R.id.InstagramButton);
        instaB.setOnClickListener(this);
        /*facebookB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

            }
        });*/
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.FacebookButton:
                String FBurl = "https://www.facebook.com/CSAUCSC/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(FBurl));
                startActivity(i);
            case R.id.InstagramButton:
                String InstaUrl = "https://www.instagram.com/csa_ucsc/?hl=en";
                Intent instaIntent = new Intent(Intent.ACTION_VIEW);
                instaIntent.setData(Uri.parse(InstaUrl));
                startActivity(instaIntent);
        }

    }
}
