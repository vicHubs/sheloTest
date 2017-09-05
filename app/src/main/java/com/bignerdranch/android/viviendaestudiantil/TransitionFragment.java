package com.bignerdranch.android.viviendaestudiantil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Victor on 24/08/2017.
 */

public class TransitionFragment extends Fragment {
Constants.AnymType type;

    ImageView mProductDetailImage;
    TextView mProductDetailId,mProductDetailName,mProductDetaiInfo;

    public static TransitionFragment getInstance() {
        return new TransitionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.transition_layout,container,false);
        mProductDetailImage = (ImageView) v.findViewById(R.id.mProductDetailImage);
        mProductDetailId = (TextView) v.findViewById(R.id.mProductDetailId);
        mProductDetailName = (TextView) v.findViewById(R.id.mProductDetailName);
        mProductDetaiInfo = (TextView) v.findViewById(R.id.mProductDetaiInfo);
        //((MainActivity)getActivity()).setSupportActionBar(toolbar);

        Bundle extras = getArguments();
        if (extras != null) {
            extras.get(Constants.ID);
            Toast.makeText(getActivity(),extras.get(Constants.ID).toString(),Toast.LENGTH_SHORT).show();
            mProductDetailImage.setImageResource((int)extras.get(Constants.IMAGE));
            mProductDetailId.setText(extras.get(Constants.ID).toString());
            mProductDetailName.setText(extras.get(Constants.NAME).toString());
            mProductDetaiInfo.setText(extras.get(Constants.DESCRIPTION).toString());
        }
        ((MainActivity)getActivity()).mDrawerToggle.setDrawerIndicatorEnabled(false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(extras.get(Constants.NAME).toString());
        ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("Information");
        ((MainActivity)getActivity()).mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).mDrawerToggle.setDrawerIndicatorEnabled(true);
                ((MainActivity)getActivity()).getSupportActionBar().setTitle("Shelo");
                ((MainActivity)getActivity()).getSupportActionBar().setSubtitle("Nabel");
                getActivity().onBackPressed();
//                Toast.makeText(getActivity(),"BACK",Toast.LENGTH_SHORT).show();
            }


    });
        return v;
    }


}
