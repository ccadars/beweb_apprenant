package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by ccadars on 06/07/17.
 */
////adapter permettant de convertir les données skills dans l'affichage du détail apprenant
public class SkillAdapter extends ArrayAdapter {

    private final Activity activity;
    private final int resource = R.layout.skills_item;
    private final JSONArray skills;


    //déclaration de l'adapter et des variables utiles pour celui ci
    public SkillAdapter(@NonNull Activity activity, @LayoutRes int resource,JSONArray liste) {
        super(activity.getApplicationContext(), resource);
        this.activity = activity;
        this.skills = liste;
    }

    //on compte les objets de la liste pour afficher le bon nombre
    @Override
    public int getCount() { return skills.length();}


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int index = position;
        //on convertie les données du tableau pour qu'elles puissent s'afficher dans le layout
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        //on définit la variable qui stocke les données à afficher dans l'item adéquate
        TextView textTitre = (TextView) convertView.findViewById((R.id.sItem_textView_nom));


        //on affiche les données stockées dans la variable à la bonne position du layout
        try {
            textTitre.setText(skills.getJSONObject(position).getString("titre"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }

}
