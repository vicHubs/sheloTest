package com.bignerdranch.android.viviendaestudiantil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victor on 18/08/2017.
 */

public class Home extends Fragment {
    List<CardObject> list = new ArrayList<>();
    int pos=0;
    public  static  Home getInstance() {
        return new Home();
    }
    RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadData();
        list = CardObject.getSheloData();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.mRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CardAdapter(list));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);


        return v;
    }

    private void loadData() {

        String js = "[{\"id\":\"A1\",\"name\":\"Jabon leche de burra\"},{\"id\":\"A2\",\"name\":\"Clorofila\"},{\"id\":\"A3\",\"name\":\"Colageno\"}]";
        try {
            JSONArray jsonArray = new JSONArray(js);
            Log.d("ch",jsonArray.toString());
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                CardObject cv = new CardObject();
                cv.setId(jsonObject.get("id").toString());
                cv.setName(jsonObject.get("name").toString());
                list.add(cv);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class Cards extends RecyclerView.ViewHolder{
        TextView mName,mProductId,mDescription;
        ImageView mImageView;
        RelativeLayout mRelative;

    public Cards(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(R.id.mProductName);
        mProductId = (TextView) itemView.findViewById(R.id.mProductId);
        mImageView = (ImageView) itemView.findViewById(R.id.mProductIcon);
        mDescription = (TextView) itemView.findViewById(R.id.mProductDescription);
        mRelative = (RelativeLayout) itemView.findViewById(R.id.mRelative);

    }

    public void bind(final CardObject obj){
        mImageView.setImageDrawable(null);
        mName.setText(obj.getName());
        mProductId.setText(obj.getId());
        mDescription.setText(obj.getDescription());

        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mImageView.setImageResource(obj.getImage());
            }
        });
        mRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ActivityOptionsCompat opt = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity());
                Intent i = new Intent(getActivity(),TransitionFragment.class);
                i.putExtra(Constants.ID, list.get(getAdapterPosition()).getId());
                i.putExtra(Constants.NAME, list.get(getAdapterPosition()).getName());
                i.putExtra(Constants.IMAGE, list.get(getAdapterPosition()).getImage());
                i.putExtra(Constants.DESCRIPTION, list.get(getAdapterPosition()).getDescription());
                startActivity(i, opt.toBundle());*/

                Bundle bundle = new Bundle();
                bundle.putString(Constants.ID, list.get(getAdapterPosition()).getId());
                bundle.putString(Constants.NAME, list.get(getAdapterPosition()).getName());
                bundle.putInt(Constants.IMAGE, list.get(getAdapterPosition()).getImage());
                bundle.putString(Constants.DESCRIPTION, list.get(getAdapterPosition()).getDescription());

                TransitionFragment trans = TransitionFragment.getInstance();
                trans.setArguments(bundle);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container,trans,"transFragment");
                transaction.addToBackStack("transFragment");
                transaction.commit();

            }
        });

    }


    }

private class CardAdapter extends RecyclerView.Adapter<Cards> {
    private List<CardObject> list;

    public CardAdapter (List<CardObject> list) {
        this.list = list;
    }

    @Override
    public Cards onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyclerview_items,parent, false);
        return new Cards(v);
    }

    @Override
    public void onBindViewHolder(Cards holder, int position) {

        CardObject co = list.get(position);

        holder.bind(co);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

}
