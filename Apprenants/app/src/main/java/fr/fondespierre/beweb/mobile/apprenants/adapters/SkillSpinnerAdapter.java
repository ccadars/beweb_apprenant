package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import org.json.JSONArray;

import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by ccadars on 07/07/17.
 */
//adapter permettant de convertir les données skills dans l'item spinner
public class SkillSpinnerAdapter extends ArrayAdapter {



    public SkillSpinnerAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
