package fr.fondespierre.beweb.mobile.apprenants;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeApprenantAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer.Datas;

/**
 * Created by ccadars on 04/07/17.
 */

public class ListeApprenantsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_apprenants);
        //déclaration des variables utiles pour l'affichage de la liste apprenant
        final ListView listeApprenant = (ListView)findViewById(R.id.lA_listeView_apprenants);
        final Activity activity = this;
        JSONArray listeDatas = null;
        //déclaration des JSONArray pour Promotion, Session et Skills


        //Déclaration de la variable request qui permettra de récupérer les données à partir de l'url
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        String url = "http://192.168.1.48/beweb_api/index.php/";

        //On déclare la variable jr sous forme d'un tableau json
        //et on y stocke les données des objets apprenants provenant de l'url lié précédement
        JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, url + "apprenants", listeDatas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Utilisation d'un adapter pour convertir un objet apprenant de la liste
                //pour les afficher dans le layout liste apprenant item
                ListeApprenantAdapter adapter = new ListeApprenantAdapter(activity,R.layout.liste_apprenants_item,response);
                //appel de l'adapter
                listeApprenant.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        //exécution de la requete exprimant la variable jr qui contient le tableau json contenant
        // la liste d'apprenant et permettant son affichage
        request.add(jr);


//
//        try {
//            listeDatas = Datas.getApprenant();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        ListeApprenantAdapter adapter = new ListeApprenantAdapter(this,R.layout.liste_apprenants_item,listeDatas);
//
//        listeApprenant.setAdapter(adapter);
    }
}

