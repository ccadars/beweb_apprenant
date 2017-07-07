package fr.fondespierre.beweb.mobile.apprenants.dataAccessLayer.enumeration;

/**
 * Created by ccadars on 05/07/17.
 */

public enum Status {

    Chomage("chomage"), En_poste("en poste"), Formation("en formation");

    private String name = "";

    Status (String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "name='" + name + '\'' +
                '}';
    }
}
