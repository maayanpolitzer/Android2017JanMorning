package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 08/03/2017.
 */
public class MaayanList<E> extends ArrayList {

    @Override
    public boolean remove(Object o) {
        boolean delete = false;
        for (int i = 0; i < size(); i++){
            if (get(i).equals(o)){
                remove(i);
                i--;
                delete = true;
            }
        }
        return delete;
    }
}
