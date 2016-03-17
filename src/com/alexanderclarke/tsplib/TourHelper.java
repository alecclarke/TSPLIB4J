package com.alexanderclarke.tsplib;

import java.util.ArrayList;

/**
 * Created by alexanderclarke on 2016-03-15.
 */
public class TourHelper {
    public static int[] toArray(ArrayList<Integer> list){
        int[] intArray = new int[list.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = list.get(i);
        }
        return intArray;
    }

    public static ArrayList<Integer> toArrayList(int[] intArray){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < intArray.length; i++) {
            list.add(intArray[i]);
        }
        return list;
    }
}
