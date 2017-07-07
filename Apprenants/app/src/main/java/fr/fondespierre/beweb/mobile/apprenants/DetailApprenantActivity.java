package fr.fondespierre.beweb.mobile.apprenants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ProjetAdapter;
import fr.fondespierre.beweb.mobile.apprenants.adapters.SkillAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer.Datas;

import static fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer.Datas.apprenant;

/**
 * Created by ccadars on 04/07/17.
 */
//activité permettant d'afficher les détails dans le layout detail_apprenant
public class DetailApprenantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //on définit dans quel layout les données seront affichées
        setContentView(R.layout.detail_apprenant);

        try {

        //on définit les données qui seront affichées dans les différents item en fonstion de l'id
        JSONObject apprenant = Datas.apprenant;

        ((TextView)findViewById(R.id.detailA_textView_nom)).setText(apprenant.getString("nom"));
        ((TextView)findViewById(R.id.detailA_textView_prenom)).setText(apprenant.getString("prenom"));
        ((TextView)findViewById(R.id.detailA_textView_age)).setText(apprenant.getString("age"));


        JSONArray skills = null;

            skills = apprenant.getJSONArray("skills");

        //utilisation de l'adapter pour convertir les données et les afficher dans le layout
        //pour les skills
        SkillAdapter adapter1 = new SkillAdapter(this,0,skills);
        ListView listeSkills = (ListView)findViewById(R.id.detailA_listView_listeSkills);
        listeSkills.setAdapter(adapter1);


        JSONArray projets = null;

            projets = apprenant.getJSONArray("projets");

        //utilisation de l'adapter pour convertir les données et les afficher dans le layout
        //pour les projets
        ProjetAdapter adapter2 = new ProjetAdapter(this,0,projets);
        ListView listeProjets = (ListView)findViewById(R.id.detailA_listView_listeProjets);
        listeProjets.setAdapter(adapter2);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
