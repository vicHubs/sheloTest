package com.bignerdranch.android.viviendaestudiantil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Victor on 20/08/2017.
 */

public class CardObject {
    int image;
    String name;
    String id;
    String description;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int[] getSheloImages() {
        return new int[]{
                R.drawable.shelo_baba_caracol,R.drawable.shelo_clorofila,
                R.drawable.shelo_colageno,R.drawable.shelo_fibra,
                R.drawable.shelo_gel_antibacterial,R.drawable.shelo_jabon,
                R.drawable.shelo_leche,R.drawable.shelo_reishi,
                R.drawable.shelo_soya,R.drawable.shelo_gel_golpes
        };
    }
    public static String[] getSheloNames() {
        return new String[] {
            "Baba de Caracol","Clorofila","Colageno","Fibra","Gel Antibacterial","Jabon Azufre","Leche Coco",
                "Reishi","Soya","Gel Golpes"
        };
    }

    public static String[] getSheloIds() {
        return new String[] {
                "A101","A201","A301","A401","A501","A601","A701","A801","A901","A1010"
        };
    }

    public static String[] getSheloDescription() {
        return new String[] {
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC"
        };
    }


    public static List<CardObject> getSheloData(){
        List<CardObject> list = new ArrayList<>();
        int[] images = getSheloImages();
        String[] names = getSheloNames();
        String[] description = getSheloDescription();
        String[] ids = getSheloIds();
        for (int i=0; i < getSheloIds().length; i++) {
            CardObject co = new CardObject();
            co.setImage(images[i]);
            co.setName(names[i]);
            co.setId(ids[i]);
            co.setDescription(description[0]);
            list.add(co);
        }
        return list;
    }

}