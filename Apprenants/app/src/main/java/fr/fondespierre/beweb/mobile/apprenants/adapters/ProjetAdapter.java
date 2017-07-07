package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import fr.fondespierre.beweb.mobile.apprenants.DetailApprenantActivity;
import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by ccadars on 06/07/17.
 */

public class ProjetAdapter extends ArrayAdapter {

    private final Activity activity;
    private final int resource = R.layout.projets_item;
    private final JSONArray projets;

    public ProjetAdapter(@NonNull Activity activity, @LayoutRes int resource,JSONArray liste) {
        super(activity.getApplicationContext(), resource);
        this.activity = activity;
        this.projets = liste;
        }
        @Override
        public int getCount() { return projets.length();}

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final int index = position;
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(resource,null);

            TextView textTitre = (TextView) convertView.findViewById((R.id.pItem_textView_nomProjet));


                    try {
                        textTitre.setText(projets.getJSONObject(position).getString("titre"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            return convertView;
        }

}
