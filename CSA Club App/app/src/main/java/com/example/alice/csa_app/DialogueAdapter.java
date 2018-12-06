package com.example.alice.csa_app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class DialogueAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<Dialogue> alCustom;

    public DialogueAdapter(Activity context, ArrayList<Dialogue> alCustom) {
        this.context = context;
        this.alCustom = alCustom;

    }

    @Override
    public int getCount() {
        return alCustom.size();

    }

    @Override
    public Object getItem(int i) {
        return alCustom.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.row_addapt, null, true);

        TextView textviewTitle=(TextView)listViewItem.findViewById(R.id.tv_name);
        TextView textviewLocation=(TextView)listViewItem.findViewById(R.id.tv_type);
        TextView textviewDate=(TextView)listViewItem.findViewById(R.id.tv_desc);
        TextView textviewDescription=(TextView)listViewItem.findViewById(R.id.tv_class);

        textviewTitle.setText("Title : "+alCustom.get(position).getTitles());
        textviewLocation.setText("Location : "+alCustom.get(position).getLocation());
        textviewDate.setText("Date : "+alCustom.get(position).getDates());
        textviewDescription.setText("Description : "+alCustom.get(position).getDescripts());

        return  listViewItem;
    }

}
