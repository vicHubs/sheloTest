package com.bignerdranch.android.viviendaestudiantil.model;

import com.bignerdranch.android.viviendaestudiantil.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 22/08/2017.
 */

public class NavigationDrawerModel {
    String title;
    int ImageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return ImageId;
    }



    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    private static int[] getImages() {

        return new int[] {R.drawable.drawer_home, R.drawable.drawer_client,
                          R.drawable.drawer_order,R.drawable.drawer_products,
                          R.drawable.drawer_route,R.drawable.drawer_exit};
    }

    private static String[] getTitles() {

        return new String[] {
            "Home","Client","Orders","Products","Routes","Exit"
        };
    }

    public static List<NavigationDrawerModel> drawerList () {
        List<NavigationDrawerModel> list = new ArrayList<>();
        String[] navTitles = getTitles();
        int[] imgIds= getImages();
        for (int i=0; i<navTitles.length; i++) {
            NavigationDrawerModel nav = new NavigationDrawerModel();
            nav.setTitle(navTitles[i]);
            nav.setImageId(imgIds[i]);
            list.add(nav);
        }

        return list;
    }


}
