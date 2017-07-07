package fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer.enumeration.Status;

/**
 * Created by ccadars on 05/07/17.
 */

//déclaration des différentes variables utiles à l'application
public class Datas {

        public static JSONObject apprenant;


        //déclaration fonction qui renverra tous les apprenants définit dans celle ci et celle de l'url
        public static JSONArray getApprenant() throws JSONException {
            JSONArray apprenants = new JSONArray();
            JSONObject alex = new JSONObject();
            JSONObject jc = new JSONObject();
            JSONObject marie = new JSONObject();

            alex.putOpt("id",1);
            alex.putOpt("nom","Leforestier");
            alex.putOpt("prenom","Alexandre");
            alex.putOpt("age","30");
            alex.putOpt("promotion",1);
            alex.putOpt("session",1);
            alex.putOpt("status", Status.Chomage);

            jc.putOpt("id",2);
            jc.putOpt("nom","Petetin");
            jc.putOpt("prenom","Jean-Christian");
            jc.putOpt("age","12");
            jc.putOpt("promotion",1);
            jc.putOpt("session",2);
            jc.putOpt("status",Status.Formation);

            marie.putOpt("id",3);
            marie.putOpt("nom","Urbano");
            marie.putOpt("prenom","Marie");
            marie.putOpt("age","5");
            marie.putOpt("promotion",2);
            marie.putOpt("session",1);
            marie.putOpt("status",Status.Formation);

            apprenants.put(alex);
            apprenants.put(jc);
            apprenants.put(marie);

            return apprenants;
        }

        //déclaration de la fonction qui retourne les apprenants avec leur skills et projets en
        //fonction de leur id
        public static JSONObject getApprenant(int id) throws JSONException {
            //creation de l'objet apprenant
            JSONObject apprenant = new JSONObject();
            //recuperation de tous les apprenants
            JSONArray apprenants = Datas.getApprenant();
            //on boucle dans la liste apprenants
            for(int i=0 ; i<apprenants.length(); i++){
                //on verifie que l'apprenant correspond bien à l'id
                if(apprenants.getJSONObject(i).getInt("id") == id){
                    //on stocke l'apprenant dans l'objet
                    apprenant = apprenants.getJSONObject(i);
                    //on récupère les skills et les projets en fonction de l'id recherché et on les
                    //les stocke dans l'objet apprenant
                    apprenant.putOpt("skills",Datas.getSkills(id));
                    apprenant.putOpt("projets",Datas.getProjets(id));
                }
            }

            return apprenant;
        }


        //déclaration de la fonction qui récupère les promotion
        public static JSONArray getPromotion() throws JSONException {
            JSONArray promotions = new JSONArray();
            JSONObject lunel1 = new JSONObject();
            JSONObject lunel2 = new JSONObject();
            JSONObject beziers1 = new JSONObject();

            lunel1.putOpt("id",1);
            lunel1.putOpt("ville","lunel");
            lunel1.putOpt("session",1);

            lunel2.putOpt("id",1);
            lunel2.putOpt("ville","lunel");
            lunel2.putOpt("session",2);

            beziers1.putOpt("id",1);
            beziers1.putOpt("ville","beziers");
            beziers1.putOpt("session",1);

            promotions.put(lunel1);
            promotions.put(lunel2);
            promotions.put(beziers1);

            return promotions;
        }


        //déclaration de la fonction qui récupère les projets
        public static JSONArray getProjets() throws JSONException {

            JSONArray projets = new JSONArray();
            JSONObject BeWeb = new JSONObject();
            JSONObject FindMyCoop = new JSONObject();
            JSONObject AdoptUnBoss = new JSONObject();
            JSONObject Pizzaioli = new JSONObject();

            BeWeb.putOpt("id",1);
            BeWeb.putOpt("url_github","http://github.com");
            BeWeb.putOpt("url_site","http://google.com");
            BeWeb.putOpt("nom","BeWeb");
            BeWeb.putOpt("apprenant",1);

            FindMyCoop.putOpt("id",2);
            FindMyCoop.putOpt("url_github","http://github.com");
            FindMyCoop.putOpt("url_site","http://google.com");
            FindMyCoop.putOpt("nom","FindMyCoop");
            FindMyCoop.putOpt("apprenant",2);

            AdoptUnBoss.putOpt("id",3);
            AdoptUnBoss.putOpt("url_github","http://github.com");
            AdoptUnBoss.putOpt("url_site","http://google.com");
            AdoptUnBoss.putOpt("nom","AdoptUnBoss");
            AdoptUnBoss.putOpt("apprenant",3);

            Pizzaioli.putOpt("id",4);
            Pizzaioli.putOpt("url_github","http://github.com");
            Pizzaioli.putOpt("url_site","http://google.com");
            Pizzaioli.putOpt("nom","Pizzaioli");
            Pizzaioli.putOpt("apprenant",1);

            projets.put(BeWeb);
            projets.put(FindMyCoop);
            projets.put(AdoptUnBoss);
            projets.put(Pizzaioli);

            return projets;


        }


        //déclaration de la fonction qui récupère les projets en fonction des id des apprenants
        public static JSONArray getProjets(int apprenantID) throws JSONException {
            JSONArray projets = Datas.getProjets();
            JSONArray projetsApprenant = new JSONArray();
            for(int i=0 ; i<projets.length(); i++){
                if(projets.getJSONObject(i).getInt("apprenant") == apprenantID){
                    projetsApprenant.put(projets.getJSONObject(i));
                }
            }
            return projetsApprenant;
        }


        //déclaration de la fonction qui récupère les skills
        public static JSONArray getSkills() throws JSONException {

            JSONArray skills = new JSONArray();
            JSONObject Html = new JSONObject();
            JSONObject Css = new JSONObject();
            JSONObject Php = new JSONObject();
            JSONObject JavaScript = new JSONObject();
            JSONObject Ruby = new JSONObject();
            JSONObject Python = new JSONObject();

            Html.putOpt("id",1);
            Html.putOpt("nom","Html");
            Html.putOpt("value","");
            Html.putOpt("apprenant",1);

            Css.putOpt("id",2);
            Css.putOpt("nom","Css");
            Css.putOpt("value","");
            Css.putOpt("apprenant",2);

            Php.putOpt("id",3);
            Php.putOpt("nom","Php");
            Php.putOpt("value","");
            Php.putOpt("apprenant",3);

            JavaScript.putOpt("id",4);
            JavaScript.putOpt("nom","JavaScript");
            JavaScript.putOpt("value","");
            JavaScript.putOpt("apprenant",1);

            Ruby.putOpt("id",5);
            Ruby.putOpt("nom","Ruby");
            Ruby.putOpt("value","");
            Ruby.putOpt("apprenant",2);

            Python.putOpt("id",6);
            Python.putOpt("nom","Python");
            Python.putOpt("value","");
            Python.putOpt("apprenant",3);

            skills.put(Html);
            skills.put(Css);
            skills.put(Php);
            skills.put(JavaScript);
            skills.put(Ruby);
            skills.put(Python);

            return skills;

        }


        //déclaration de la fonction qui récupère les skills des apprenants en fonction des id
        public static JSONArray getSkills(int apprenantID) throws JSONException {
            JSONArray skills = Datas.getSkills();
            JSONArray skillsApprenant = new JSONArray();
            for(int i=0 ; i<skills.length(); i++){
                if(skills.getJSONObject(i).getInt("apprenant") == apprenantID){
                    skillsApprenant.put(skills.getJSONObject(i));
                }
            }
            return skillsApprenant;
        }


}
