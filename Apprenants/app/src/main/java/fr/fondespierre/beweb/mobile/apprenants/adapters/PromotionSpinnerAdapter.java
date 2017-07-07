package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by ccadars on 07/07/17.
 */
//adapter permettant de convertir les données promotion dans l'item spinner
public class PromotionSpinnerAdapter extends ArrayAdapter {



    public PromotionSpinnerAdapter(@NonNull Context context, @LayoutRes int resource){
        super(context, resource);
    }
}