package com.example.svg;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.w3c.dom.*;
import org.w3c.dom.svg.*;

public class Draw extends JPanel {

    public Draw(){}

    private static final int ORIGINE_DESSIN_X=30;
    private static final int ORIGINE_DESSIN_Y=200;
    private static final int HAUTEUR_LIGNE=50;
    private static final int TAILLE_FENETRE_X = 2600;
    private static final int TAILLE_FENETRE_Y = 900;
    private static final int TAILLE_JOUR=7;
    private static final int MARGE_GAUCHE=200; //taille du rectangle avec les noms

    private String date_debut = "01/01/2021";           //date qui correspond au début du tablean
    private String date_fin = "31/12/2021";             // ---- ------------------ fin du tableau
    private String filePath;                            //chein du fichier a traiter
    private TraitementDate td=new TraitementDate();
    private Api api;
  //nb jour a afficher --> longueur du recangle --> déclarer au début de draw panel
    private int jour_debut=td.haveDayofYear(date_debut)-1;  //date a implément si le date_debut!=jur_debut

    //variable pour le stockage des date en jour
    private List<Integer> jour_Nemo_MEPP_INTRADEF=new ArrayList<Integer>();
    private List<Integer> jour_Nemo_MEPP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_Nemo_MEPP_PAPI = new ArrayList<Integer>();
    private List<Integer> jour_MEPP_INTRADEF = new ArrayList<Integer>();
    private List<Integer> jour_MEPP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_MEPP_PAPI = new ArrayList<Integer>();
    // pour les cerles verts
    private List<Integer> jour_Demande_MEP_INTRADEF = new ArrayList<Integer>();
    private List<Integer> jour_Demande_MEP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_Demande_MEP_PAPI = new ArrayList<Integer>();
    private List<Integer> jour_MEP_INTRADEF = new ArrayList<Integer>();
    private List<Integer> jour_MEP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_MEP_PAPI = new ArrayList<Integer>();

    //variale pour le try des passerelles
    private ArrayList<String> Passerelle_INTRADEF = new ArrayList<String>();
    private ArrayList<String> Passerelle_INTERNET = new ArrayList<String>();
    private ArrayList<String> Passerelle_PAPI = new ArrayList<String>();
    //STATUT
    private ArrayList<String> Statut_INTRADEF = new ArrayList<String>();
    private ArrayList<String> Statut_INTERNET = new ArrayList<String>();
    private ArrayList<String> Statut_PAPI = new ArrayList<String>();




    private int nb_api_to_string=0;

    public int getJour_debut()
    {
        return jour_debut;
    }


    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath=filePath;
    }


    public String getDate_debut()
    {
        return date_debut;
    }

    public String getDate_fin()
    {
        return date_fin;
    }

    public void setDate_debut(String new_date_debut)
    {
        this.date_debut=new_date_debut;
    }

    public void setDate_fin(String new_date_fin)
    {
        this.date_fin=new_date_fin;
    }    

    //ici que l'on ajoute les date en jour dans les listes qui seront transmise au auttre classe
    private void triPasserelle(Api api,int nb_api_file)
    {
        System.out.println("date debut test " + td.haveDayofYear(date_debut));
        System.out.println("date de fin test " + td.haveDayofYear(date_fin));
        for(int i=0;i<nb_api_file;i++) //try des api en fonction de leur passerelle
        {
            //Avant d'ahouter les api dans la liste de difusion on regarde si les dates sont bonnes afin de l'afficher ou pas.
            if(((td.haveDayofYear(api.recuperateDatePrévueNemoMEPP().get(i))>= td.haveDayofYear(date_debut)) || (td.haveDayofYear(api.recuperateDatePrévueMEPP().get(i))>= td.haveDayofYear(date_debut)) ||
            (td.haveDayofYear(api.recuperateDatePrévueDemandeMEP().get(i))>= td.haveDayofYear(date_debut)) || (td.haveDayofYear(api.recuperateDatePrévueMEP().get(i))>= td.haveDayofYear(date_debut))) &&
            ((td.haveDayofYear(api.recuperateDatePrévueNemoMEPP().get(i)) <= td.haveDayofYear(date_fin)) || (td.haveDayofYear(api.recuperateDatePrévueMEPP().get(i)) <= td.haveDayofYear(date_fin))
            ||  (td.haveDayofYear(api.recuperateDatePrévueDemandeMEP().get(i)) <= td.haveDayofYear(date_fin)) || (td.haveDayofYear(api.recuperateDatePrévueMEP().get(i)) <= td.haveDayofYear(date_fin))
            ))
            //si l'api est dans les bornes on l'ajote aux différente liste 
            {
                nb_api_to_string++;
                if(api.recuperatePasserelle().get(i).equals("INTRADEF"))
                {
                    Passerelle_INTRADEF.add(api.recuperateName().get(i)+" "+ api.recuperateVersion().get(i)+"  "+api.recuperateNbAPI().get(i)+"Api "+api.recuperatePrioritéDGNUM().get(i));
                    jour_Nemo_MEPP_INTRADEF.add(td.haveDayofYear(api.recuperateDatePrévueNemoMEPP().get(i)));    //
                    jour_MEPP_INTRADEF.add(td.haveDayofYear(api.recuperateDatePrévueMEPP().get(i)));
                    jour_Demande_MEP_INTRADEF.add(td.haveDayofYear((api.recuperateDatePrévueDemandeMEP().get(i))));
                    jour_MEP_INTRADEF.add(td.haveDayofYear((api.recuperateDatePrévueMEP().get(i))));
                    Statut_INTRADEF.add(api.recuperateStatutPlanification().get(i));
                }
                if (api.recuperatePasserelle().get(i).equals("INTERNET")) 
                {
                    Passerelle_INTERNET.add(api.recuperateName().get(i) + " " + api.recuperateVersion().get(i)+" "+api.recuperateNbAPI().get(i)+"Api "+api.recuperatePrioritéDGNUM().get(i));
                    jour_Nemo_MEPP_INTERNET.add(td.haveDayofYear(api.recuperateDatePrévueNemoMEPP().get(i)));
                    jour_MEPP_INTERNET.add(td.haveDayofYear(api.recuperateDatePrévueMEPP().get(i)));
                    jour_Demande_MEP_INTERNET.add(td.haveDayofYear((api.recuperateDatePrévueDemandeMEP().get(i))));
                    jour_MEP_INTERNET.add(td.haveDayofYear((api.recuperateDatePrévueMEP().get(i))));
                    Statut_INTERNET.add(api.recuperateStatutPlanification().get(i));
                }
                if (api.recuperatePasserelle().get(i).equals("P-API")) {
                    Passerelle_PAPI.add(api.recuperateName().get(i) + " " + api.recuperateVersion().get(i)+" "+api.recuperateNbAPI().get(i)+"Api "+api.recuperatePrioritéDGNUM().get(i));
                    jour_Nemo_MEPP_PAPI.add(td.haveDayofYear(api.recuperateDatePrévueNemoMEPP().get(i)));
                    jour_MEPP_PAPI.add(td.haveDayofYear(api.recuperateDatePrévueMEPP().get(i)));
                    jour_Demande_MEP_PAPI.add(td.haveDayofYear((api.recuperateDatePrévueDemandeMEP().get(i))));
                    jour_MEP_PAPI.add(td.haveDayofYear((api.recuperateDatePrévueMEP().get(i))));
                    Statut_PAPI.add(api.recuperateStatutPlanification().get(i));
                }
            }
            
        
        }

      

    }

    public void paintTitle(Graphics2D g,int nombre_jour_afficher)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setFont(new Font("Calibri", Font.PLAIN, 25));
        g2d.drawString("Feuille de route des déploiements d'API PEM et P-API", ( (TAILLE_JOUR*nombre_jour_afficher))/2 , ORIGINE_DESSIN_Y/2-40);
        g2d.drawString("   Proposition CASID du : "+ date_debut +" au "+date_fin,
                ( (TAILLE_JOUR * nombre_jour_afficher)) / 2, ORIGINE_DESSIN_Y / 2 - 15);
    }

    public void paintHachure(Graphics2D g, int nombre_jour_afficher,int nb_api_file)
     {
        Graphics2D g2d = (Graphics2D) g.create();
        int md_api = (int) (nb_api_file / 2);
        for (int i = 0; i < md_api; i++) {
            g2d.setColor(Color.lightGray);
            g2d.fillRect(ORIGINE_DESSIN_X - 5, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 5 + (i * 2 *HAUTEUR_LIGNE),
                    MARGE_GAUCHE + (TAILLE_JOUR * nombre_jour_afficher), HAUTEUR_LIGNE);
        }
        g2d.setColor(Color.black);
    }


    public void paintLigneApi(Graphics2D g,Api api, int nb_api_file,int nombre_jour_afficher,Color color) throws IOException {     

        triPasserelle(api,nb_api_file);
        paintHachure(g, nombre_jour_afficher, nb_api_to_string);
        int ht_rect_INTRADEF= 0;

        System.out.println("Nombre de jour a afficher"+ nombre_jour_afficher);

        for(int i=0;i<Passerelle_INTRADEF.size();i++)
        {
            g.drawString(Passerelle_INTRADEF.get(i) , ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y + (i*HAUTEUR_LIGNE));// Affichage des Api
            g.setColor(color);
            g.drawRect(ORIGINE_DESSIN_X-5 ,ORIGINE_DESSIN_Y -(HAUTEUR_LIGNE/2)-5+ (i*HAUTEUR_LIGNE), 
                    MARGE_GAUCHE + (TAILLE_JOUR * nombre_jour_afficher) , HAUTEUR_LIGNE);
            ht_rect_INTRADEF=ht_rect_INTRADEF+(i*HAUTEUR_LIGNE);
            g.setColor(Color.black);
        }
        for (int i = 0; i <Passerelle_INTERNET.size(); i++) 
        {
            g.drawString(Passerelle_INTERNET.get(i), ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y + ((i+Passerelle_INTRADEF.size()) * HAUTEUR_LIGNE));// Affichage
            g.setColor(color);
            g.drawRect(ORIGINE_DESSIN_X-5  ,ORIGINE_DESSIN_Y +(Passerelle_INTRADEF.size()*HAUTEUR_LIGNE)-(HAUTEUR_LIGNE/2)-5+ (i*HAUTEUR_LIGNE), MARGE_GAUCHE+(TAILLE_JOUR*nombre_jour_afficher), HAUTEUR_LIGNE);
            g.setColor(Color.black);
        }
        for (int i = 0; i < Passerelle_PAPI.size(); i++) {
            g.drawString(Passerelle_PAPI.get(i), ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y + ((i+Passerelle_INTRADEF.size()+Passerelle_INTERNET.size()) * HAUTEUR_LIGNE));
            g.setColor(color);
            g.drawRect(ORIGINE_DESSIN_X - 5, ORIGINE_DESSIN_Y + ((Passerelle_INTRADEF.size()+Passerelle_INTERNET.size()) * HAUTEUR_LIGNE)
                    - (HAUTEUR_LIGNE / 2) - 5 + (i * HAUTEUR_LIGNE), MARGE_GAUCHE + (
                            TAILLE_JOUR * nombre_jour_afficher), HAUTEUR_LIGNE);
            g.setColor(Color.black);
        }

        if(Passerelle_INTRADEF.size()>0)
        {
            paintRectPasserrel_INTRADEF(g,Color.magenta,nombre_jour_afficher);
        }
        if (Passerelle_INTERNET.size() > 0) {
            paintRectPasserrel_INTERNET(g, Color.DARK_GRAY,nombre_jour_afficher);
        }
        if (Passerelle_PAPI.size()> 0) {
            paintRectPasserrel_PAPI(g, Color.red,nombre_jour_afficher);
        }
       
        
       

        //dessin des deux lignes de marge
        g.setColor(Color.black);
        g.drawLine(MARGE_GAUCHE-5+ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y-(HAUTEUR_LIGNE/2)-10, MARGE_GAUCHE-5+ORIGINE_DESSIN_X, 
                nb_api_to_string*HAUTEUR_LIGNE+(ORIGINE_DESSIN_Y-(HAUTEUR_LIGNE/2)));
        g.drawLine(MARGE_GAUCHE-6+ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 10, MARGE_GAUCHE-6+ORIGINE_DESSIN_X,
                nb_api_to_string * HAUTEUR_LIGNE + (ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)));
        g.drawLine(MARGE_GAUCHE - 7 + ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 10,
                MARGE_GAUCHE - 7 + ORIGINE_DESSIN_X,
                nb_api_to_string * HAUTEUR_LIGNE + (ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)));
        g.setColor(Color.black);
    }


    public void drawnPanel() throws IOException {
        //Appelle de l aclasse Api
        System.out.println("date debut"+date_debut);
        System.out.println("date de fin" +date_fin);
        int nombre_jour_afficher = td.haveDayofYear(date_fin) - td.haveDayofYear(date_debut) + 1;

        api=new Api(filePath);
        //api.show();
        int nb_api_file = api.count();//Contage du nombre d'api dans le dossier
        
        //récupération des dates en jour jj/mm/aaaa en jour 365 - a coder
      
        // Create an SVG document.
        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

        // Create a converter for this document.
        SVGGraphics2D g = new SVGGraphics2D(doc);

       
        paintLigneApi(g,api, nb_api_file,nombre_jour_afficher,Color.black);
        paintTitle(g, nombre_jour_afficher);
        System.out.println("hyp== "+nb_api_to_string);
        Tableau tab=new Tableau(ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y, HAUTEUR_LIGNE, TAILLE_JOUR,MARGE_GAUCHE, 
                nb_api_to_string);

        //methode set pour transmetre les infos au tableau
        //cercle blue
        tab.setJour_nemo_MEPP_INTRADEF(jour_Nemo_MEPP_INTRADEF);
        tab.setJour_nemo_MEPP_INTERNET(jour_Nemo_MEPP_INTERNET);
        tab.setJour_nemo_MEPP_PAPI(jour_Nemo_MEPP_PAPI);
        tab.setJour__MEPP_INTRADEF(jour_MEPP_INTRADEF);
        tab.setJour__MEPP_INTERNET(jour_MEPP_INTERNET);
        tab.setJour__MEPP_PAPI(jour_MEPP_PAPI);
        //cercle vert
        tab.setJour_Demande_MEP_INTRADEF(jour_Demande_MEP_INTRADEF);
        tab.setJour_Demande_MEP_INTERNET(jour_Demande_MEP_INTERNET);
        tab.setJour_Demande_MEP_PAPI(jour_Demande_MEP_PAPI);
        tab.setJour_MEP_INTRADEF(jour_MEP_INTRADEF);
        tab.setJour_MEP_INTERNET(jour_MEP_INTERNET);
        tab.setJour_MEP_PAPI(jour_MEP_PAPI);
        //statut
        tab.setStatut_INTRADEF(Statut_INTRADEF);
        tab.setStatut_INTERNET(Statut_INTERNET);
        tab.setStatut_PAPI(Statut_PAPI);
        //Type de ligne en fonction du statut
        tab.setStatut_INTRADEF(Statut_INTRADEF);
        System.out.println(Statut_INTRADEF);

        tab.drawWeeks(g,date_debut, date_fin);    //-----------> passage des dates pour la construction du tableau
        
        // Populate the document root with the generated SVG content.
        Element root = doc.getDocumentElement();
        g.getRoot(root);

        //test image
        

        // Display the document.
        JSVGCanvas canvas = new JSVGCanvas();
        JFrame f = new JFrame();
        f.getContentPane().add(canvas);
        canvas.setSVGDocument(doc);
        f.pack();
        f.setSize(TAILLE_FENETRE_X, TAILLE_FENETRE_Y);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

   


    }


    public void paintRectPasserrel_INTRADEF(Graphics2D g, Color color,int nombre_jour_afficher)
    {
        Graphics2D g3d = (Graphics2D) g.create();
        g3d.setColor(color);
        g3d.setFont(new Font("Calibri", Font.BOLD, 10));
        g3d.drawString("INTRADEF", ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 10);
        Stroke dashed = new BasicStroke(3, BasicStroke.JOIN_ROUND , BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
        g3d.setStroke(dashed);
        g3d.drawRect(ORIGINE_DESSIN_X - 8, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 8, MARGE_GAUCHE+nombre_jour_afficher*TAILLE_JOUR+2,
                Passerelle_INTRADEF.size() * HAUTEUR_LIGNE-13); 
    }

    public void paintRectPasserrel_INTERNET(Graphics2D g, Color color,int nombre_jour_afficher) {
        Graphics2D g3d = (Graphics2D) g.create();
        g3d.setColor(color);
        g3d.setFont(new Font("Calibri", Font.BOLD, 10));
        g3d.drawString("INTERNET", ORIGINE_DESSIN_X,
                ORIGINE_DESSIN_Y + ((Passerelle_INTRADEF.size()) * HAUTEUR_LIGNE)
                        - (HAUTEUR_LIGNE / 2) - 10);
        Stroke dashed = new BasicStroke(3, BasicStroke.JOIN_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
        g3d.setStroke(dashed);
        g3d.drawRect(ORIGINE_DESSIN_X - 8, ORIGINE_DESSIN_Y + ((Passerelle_INTRADEF.size()) * HAUTEUR_LIGNE)
                    - (HAUTEUR_LIGNE / 2) - 8, 
                MARGE_GAUCHE + nombre_jour_afficher * TAILLE_JOUR+2,
                Passerelle_INTERNET.size() * HAUTEUR_LIGNE-13);
    }

    public void paintRectPasserrel_PAPI(Graphics2D g, Color color,int nombre_jour_afficher) {
        Graphics2D g3d = (Graphics2D) g.create();
        g3d.setColor(color);
        g3d.setFont(new Font("Calibri", Font.BOLD, 10));
        g3d.drawString("P-API",ORIGINE_DESSIN_X,
                ORIGINE_DESSIN_Y + ((Passerelle_INTRADEF.size() + Passerelle_INTERNET.size()) * HAUTEUR_LIGNE)
                        - (HAUTEUR_LIGNE / 2)-10);
        Stroke dashed = new BasicStroke(3, BasicStroke.JOIN_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
        g3d.setStroke(dashed);
        g3d.drawRect(ORIGINE_DESSIN_X - 8, 
                ORIGINE_DESSIN_Y + ((Passerelle_INTRADEF.size() + Passerelle_INTERNET.size()) * HAUTEUR_LIGNE)
                        - (HAUTEUR_LIGNE / 2) - 8, 
                MARGE_GAUCHE +2+ nombre_jour_afficher * TAILLE_JOUR,
                Passerelle_PAPI.size() * HAUTEUR_LIGNE );
    }

}