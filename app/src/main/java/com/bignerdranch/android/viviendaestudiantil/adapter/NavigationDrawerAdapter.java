package com.bignerdranch.android.viviendaestudiantil.adapter;

import android.content.Context;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.viviendaestudiantil.R;
import com.bignerdranch.android.viviendaestudiantil.model.NavigationDrawerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 22/08/2017.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewModel> {

    List<NavigationDrawerModel> list = new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    public NavigationDrawerAdapter(Context context, List<NavigationDrawerModel> list) {

        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public ViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.drawer_list_item,parent,false);
        ViewModel holder = new ViewModel(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewModel holder, int position) {

        NavigationDrawerModel nav = list.get(position);
        holder.drawerTitle.setText(nav.getTitle());
        holder.drawerImage.setImageResource(nav.getImageId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,holder.drawerTitle.getText().toString(),Toast.LENGTH_SHORT).show();
                switch (holder.drawerTitle.getText().toString()) {
                    case "Home":
                        Toast.makeText(context,holder.drawerTitle.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("ya",list.size()+"");
        return list.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {

        TextView drawerTitle;
        ImageView drawerImage;

        public ViewModel(View itemView) {
            super(itemView);
            drawerTitle = (TextView) itemView.findViewById(R.id.drawerTitle);
            drawerImage = (ImageView) itemView.findViewById(R.id.drawerImage);

        }
    }
}
