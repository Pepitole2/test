package com.example.svg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Api {

    private String fileApi; // =  "C:\\Users\\Kleden\\Desktop\\test\\cvg-test-7\\svgdem\\src\\api.yaml";

    public Api(String nomAPI, String passerelle, String prioritéDGNUM, String version, String nbAPI, String etatAPI,
            String datePremierEnvoi,String dateDernierEnvoiSwager,String delaiAPIM,String stabilitéApi,String dateLivraisonPrévu,
            String dateEffectiveValidation,String dateGoPrévue, String dateGoOfficielPréProd,String délaiNemo,String datePrévueNemoMEPP,
            String dateEffectiveNemoMEPP,String datePrévueMEPP,String dateEffectiveMEPP,String datePrévueDemandeMEP,String dateEffectiveDemandeMEP,
            String datePrévueMEP,String dateEffectiveMEP,String dateGoOfficielProd,String délaiPourMep,String dateMepEnvisagée,
            String demandeDeDésactivation,String dateEffectiveDésactivation,String statutPlanification) {

        this.nomAPI = nomAPI;
        this.passerelle = passerelle;
        this.prioritéDGNUM = prioritéDGNUM;
        this.version = version;
        this.nbAPI=nbAPI;
        this.etatAPI=etatAPI;
        this.datePremierEnvoi=datePremierEnvoi;
        this.dateDernierEnvoiSwager=dateDernierEnvoiSwager;
        this.delaiAPIM=delaiAPIM;
        this.stabilitéApi=stabilitéApi;
        this.dateLivraisonPrévu=dateLivraisonPrévu;
        this.dateEffectiveValidation=dateEffectiveValidation;
        this.dateGoPrévue=dateGoPrévue;
        this.dateGoOfficielProd=dateGoOfficielPréProd;
        this.délaiNemo=délaiNemo;
        this.datePrévueNemoMEPP=datePrévueNemoMEPP;
        this.dateEffectiveNemoMEPP=dateEffectiveNemoMEPP;
        this.datePrévueMEPP=datePrévueMEPP;
        this.dateEffectiveMEP=dateEffectiveMEP;
        this.datePrévueDemandeMEP=datePrévueDemandeMEP;
        this.dateEffectiveDemandeMEP=dateEffectiveDemandeMEP;
        this.datePrévueMEP=datePrévueMEP;
        this.dateEffectiveMEP=dateEffectiveMEP;
        this.dateGoOfficielProd=dateGoOfficielProd;
        this.délaiPourMep=délaiPourMep;
        this.dateMepEnvisagée=dateMepEnvisagée;
        this.demandeDeDésactivation=demandeDeDésactivation;
        this.dateEffectiveDésactivation=dateEffectiveDésactivation;
        this.statutPlanification=statutPlanification;



 
    }


  protected Api(){}

    public Api(String newfileApi){
        this.fileApi=newfileApi;
    }
  
    private String nomAPI;
    private String passerelle;
    private String prioritéDGNUM;
    private String version;
    private String nbAPI;
    private String etatAPI;
    private String datePremierEnvoi;
    private String dateDernierEnvoiSwager;
    private String delaiAPIM;
    private String stabilitéApi;
    private String dateLivraisonPrévu;
    private String dateEffectiveValidation;
    private String dateGoPrévue;
    private String dateGoOfficielPréProd;
    private String délaiNemo;
    private String datePrévueNemoMEPP;
    private String dateEffectiveNemoMEPP;
    private String datePrévueMEPP;
    private String dateEffectiveMEPP;
    private String datePrévueDemandeMEP;
    private String dateEffectiveDemandeMEP;
    private String datePrévueMEP;
    private String dateEffectiveMEP;
    private String dateGoOfficielProd;
    private String délaiPourMep;
    private String dateMepEnvisagée;
    private String demandeDeDésactivation;
    private String dateEffectiveDésactivation;
    private String statutPlanification;
    

    // getter and setter

    
    public String getNomAPI() {return nomAPI;}

    public String getPasserelle() {return passerelle;}

    public String getPrioritéDGNUM() {return prioritéDGNUM;}

    public String getVersion() {return version;}

    public String getNbAPI() {return nbAPI;}

    public String getEtatAPI(){return etatAPI;}

    public String getDatePremierEnvoi(){return datePremierEnvoi;}

    public String getDateDernierEnvoiSwager(){return dateDernierEnvoiSwager;}

    public String getDelaiAPIM(){return delaiAPIM;}
    
    public String getStabilitéApi(){return stabilitéApi;}

    public String getDateLivraisonPrévu(){return dateLivraisonPrévu;}

    public String getDateEffectiveValidation(){return dateEffectiveValidation;}

    public String getDateGoPrévue(){return dateGoPrévue;}

    public String getDateGoOfficielPréProd(){return dateGoOfficielPréProd;}

    public String getDélaiNemo(){return délaiNemo;}

    public String getDatePrévueNemoMEPP(){return datePrévueNemoMEPP;}

    public String getDateEffectiveNemoMEPP(){return dateEffectiveNemoMEPP;}

    public String getDatePrévueMEPP(){return datePrévueMEPP;}

    public String getDateEffectiveMEPP(){return dateEffectiveMEPP;}

    public String getDatePrévueDemandeMEP(){return datePrévueDemandeMEP;}

    public String getDateEffectiveDemandeMEP(){return dateEffectiveDemandeMEP;}

    public String getDatePrévueMEP(){return datePrévueMEP;}

    public String getDateEffectiveMEP(){return dateEffectiveMEP;}

    public String getDateGoOfficielProd(){return dateGoOfficielProd;}

    public String getDélaiPourMep(){return délaiPourMep;}

    public String getDateMepEnvisagée(){return dateMepEnvisagée;}

    public String getdemandeDeDésactivation(){return demandeDeDésactivation;}

    public String getDateEffectiveDésactivation(){return dateEffectiveDésactivation;}

    public String getFileApi(){return fileApi;}

    public String getStatutPlanification(){return statutPlanification;}


    public void setFileApi(String newfileApi){
        this.fileApi=newfileApi;
    }


    @Override
    public String toString() {
        return "\nNom de l'api : " + nomAPI + "\nPasserelle : " + passerelle + "\nVerion : " + version + "\nDatePrévueNemoMEPP : "+
        datePrévueNemoMEPP+"\nDatePrévueMEPP : "+datePrévueMEPP+"\nDatePrévueDemandeMEP : "+ datePrévueDemandeMEP +"\nDatePrévueMEP : "+
        datePrévueMEP;
    }

    //_______________________________________Methode_de _traitement____________________________________________
    //--------------------------------------------LECTURE-SIMPLE--------------------------------------------

    public Api[] read() {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //System.out.println("______________Fichier_En_Cour_:"+fileApi+"  ___________________");

        try {

            //System.out.println("\n___________________LECTURE_FICHIER_API______________________\n");
            Api[] api = mapper.readValue(new File(fileApi),Api[].class);
            return api;

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        System.out.println("_________________________ECHEC_LECTURE______________________________");
        return null;
    }

    //-----------------------------------------TRAITEMENT-DATA-------------------------------------------

    public void show() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        if (apitest != null) {
            for (Api api : apitest) {
                System.out.println("\n");
                System.out.println(api.toString());
            }
        }
    }

    public int count() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        int count = 0;
        if (apitest != null) {
            for (Api api : apitest) {
                count++;
            }
            return count;

        } else {

            return 0;
        }
    }
    //----------------------------------------SUPER-GET-METHODE-----------------------------------------

    public  ArrayList<String> recuperateName() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
               str.add(api.getNomAPI());
               //System.out.println(api.getNomAPI());
               }
            }
            return str;
        
    }

    public ArrayList<String> recuperatePasserelle() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getPasserelle());
                // System.out.println(api.getNomAPI());
            }
        }
        return str;

    }

    public  ArrayList<String> recuperateVersion() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
               str.add(api.getVersion());
               //System.out.println(api.getNomAPI());
               }
            }
            return str;
        
    }

    public  ArrayList<String> recuperateDatePrévueNemoMEPP() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
               str.add(api.getDatePrévueNemoMEPP());
               //System.out.println(api.getNomAPI());
               }
            }
            return str;
        
    }

    public ArrayList<String> recuperateDatePrévueMEPP() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getDatePrévueMEPP());
                // System.out.println(api.getNomAPI());
            }
        }
        return str;

    }   

public ArrayList<String> recuperateDatePrévueDemandeMEP() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getDatePrévueDemandeMEP());
                //System.out.println(api.getDatePrévueDemandeMEP());
            }
        }
        return str;

    }

public ArrayList<String> recuperateDatePrévueMEP() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getDatePrévueMEP());
                // System.out.println(api.getNomAPI());
            }
        }
        return str;

    }

    public ArrayList<String> recuperateNbAPI() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getNbAPI());
                // System.out.println(api.getNomAPI());
            }
        }
        return str;
    }

    public ArrayList<String> recuperatePrioritéDGNUM() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getPrioritéDGNUM());
                // System.out.println(api.getNomAPI());
            }
        }
        return str;
    }

    public ArrayList<String> recuperateStatutPlanification() {
        Api test = new Api(fileApi);
        Api[] apitest = test.read();
        ArrayList<String> str = new ArrayList<String>();
        if (apitest != null) {
            for (Api api : apitest) {
                str.add(api.getStatutPlanification());
                //System.out.println(api.getStatutPlanification());
            }
        }
        return str;
    }
    
}
    


