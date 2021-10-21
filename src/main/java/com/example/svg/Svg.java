package com.example.svg;

import java.awt.*;
import java.awt.geom.*;
import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.apache.batik.dom.svg.SVGDOMImplementation;


import org.w3c.dom.*;
import org.w3c.dom.svg.*;


public class Svg{

    //------------------Test-DATE-----------------------

    private  String date_debut= "01/01/2021";
    private  String date_fin= "31/12/2021";
    
    private static final int TAILLE_FENETRE_X=2000;
    private static final int TAILLE_FENETRE_Y=1000;

    private static final int ORIGINE_DESSIN_X=2;
    private static final int ORIGINE_DESSIN_Y=150;
    private static final int MARGE_GAUCHE = 100;
    private static final int TAILLE_ITEM=18;
    private static final int HAUTEUR_RECTANGLE=40;
    private static final int ECART_ENTRE_JOUR=5;
    private int ECART_ENTRE_GRILLE=7*ECART_ENTRE_JOUR;


    private int circleX1;
    private int circleX2;
    private int semainedebut;
    private int semainefin;
    private int jourdebut;
    private int jourfin;

    private String vartempon;

    private TraitementDate td=new TraitementDate();
    
    

    

    public void setDate_debut(String date_debut){
        this.date_debut=date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDate_debut(){
        return date_debut;
    }

    public String getDate_fin(){
        return date_fin;
    }
    
    public String getVartempon() {
        return vartempon;
    }

    public void setVartempon(String newvartempon) {
        this.vartempon = newvartempon;
    }
      


    
    public void tableauCadrage(String datedebut,String datefin)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );
        LocalDate date_d = LocalDate.parse( datedebut, formatter );
        LocalDate date_f = LocalDate.parse( datefin, formatter );

        ArrayList<String> encadrementDate =new ArrayList<String>();
        List<Integer> semaine =new ArrayList<Integer>();
        encadrementDate.add(datedebut);
        encadrementDate.add(datefin);
        TraitementDate td=new TraitementDate();
        td.GetDateTrier(encadrementDate);
        semaine=td.semaineDate(encadrementDate);
        semainedebut=semaine.get(0);
        semainefin=semaine.get(1);
        if(semainedebut==53){semainedebut=1;}
        System.out.println("Affichage entre la semaine "+semaine.get(0));
        System.out.println("Et la semaine "+semaine.get(1));

        jourdebut=date_d.getDayOfYear();
        jourfin=date_f.getDayOfYear();

        System.out.println("Affichage entre le Jour " + jourdebut);
        System.out.println("Et le JOUR " + jourfin);


    }
  
    public void drawcircle(SVGGraphics2D g,List<Integer> testlist,int index,Color color){
        Shape circle = new Ellipse2D.Double( ((testlist.get(index)-semainedebut)*ECART_ENTRE_JOUR*7)+MARGE_GAUCHE+2+(3.5*ECART_ENTRE_JOUR),ORIGINE_DESSIN_Y+10,TAILLE_ITEM, TAILLE_ITEM);
        g.setPaint(color);
        g.fill(circle);
        g.setColor(Color.BLACK);
        circleX2=((testlist.get(index)-semainedebut)*ECART_ENTRE_JOUR*7)+MARGE_GAUCHE+10;
    }

    public void drawline(SVGGraphics2D g, Color color,int hauteurGrille,int i,int jour)
    {
        g.setColor(Color.black);
        g.drawLine(MARGE_GAUCHE + i * ECART_ENTRE_JOUR +(jour*ECART_ENTRE_JOUR) , ORIGINE_DESSIN_Y, MARGE_GAUCHE + i * ECART_ENTRE_JOUR
                + (jour * ECART_ENTRE_JOUR),ORIGINE_DESSIN_Y + HAUTEUR_RECTANGLE * hauteurGrille);
        // Affichage semaine
        g.setColor(Color.BLACK);
    }


    public void drawGrille(SVGGraphics2D g,int hauteurGrille,int NOMBRE_JOUR,String date_debut,String date_fin){
        System.out.println("----------------"+NOMBRE_JOUR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);

        //jour de décalage
        int jour;
        if(date_d.getDayOfWeek()==DayOfWeek.MONDAY)
        {   
            jour=0;
            for(int i=0;i<NOMBRE_JOUR-7;i=i+7)
            {
                drawline(g, Color.black, hauteurGrille, i,jour);
            } 
        }else
        {
            jour= 7-date_d.getDayOfWeek().getValue()+1;
            for (int i = 0; i < NOMBRE_JOUR-7; i = i + 7) 
            {
                drawline(g, Color.black, hauteurGrille, i, jour);
            }
        }
    }



    public void drawWeeks(SVGGraphics2D g, int hauteurGrille, int NOMBRE_JOUR, String date_debut, String date_fin)
    {
        System.out.println("----------------" + NOMBRE_JOUR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);
        LocalDate date_f = LocalDate.parse(date_debut, formatter);
        if((date_f.getDayOfYear()-date_d.getDayOfYear()/7)<51)
        {
            for (int i = 0; i < NOMBRE_JOUR - 7; i = i + 7)
            {
                g.drawString(" S" + ((i+7+date_d.getDayOfYear())/7), MARGE_GAUCHE + i * ECART_ENTRE_JOUR + (int)(3.5 * ECART_ENTRE_JOUR),
                        ORIGINE_DESSIN_Y);
            }
        }else
        {
            for (int i = 0; i < NOMBRE_JOUR; i = i + 7) {
                g.drawString(" S" + ((i + 7 + date_d.getDayOfYear()) / 7),
                        MARGE_GAUCHE + i * ECART_ENTRE_JOUR + (int) (0 * ECART_ENTRE_JOUR), ORIGINE_DESSIN_Y);
            }       
        }
    }
        
        
        
        
    

    public void drawMonth(SVGGraphics2D g,String date_debut,String date_fin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );
        LocalDate date_d = LocalDate.parse( date_debut, formatter );
        LocalDate date_f = LocalDate.parse( date_fin, formatter );
        int nb_month=date_f.getMonthValue()-date_d.getMonthValue()+1;
        String[] months = new DateFormatSymbols().getMonths();
       
        for(int i=0;i<nb_month;i++){
            g.drawString(months[i+date_d.getMonthValue()-1],(int)(MARGE_GAUCHE + (i) *4.3333* ECART_ENTRE_GRILLE)+10, ORIGINE_DESSIN_Y - 18);
        }
    }


    public void drawFirstdayMonth(SVGGraphics2D g,String date_debut,String date_fin, int hauteurGrille)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);
        LocalDate date_f = LocalDate.parse(date_fin, formatter);
        System.out.println("First day: " + date_d.withDayOfMonth(1));
    
        int nb_month=date_f.getMonthValue()-date_d.getMonthValue()+1;

        List<Integer> premier_jour_mois = new ArrayList<Integer>();

        System.out.println("NOMBRE DE MOIS A AFFICHER" + nb_month);
        
        for(int i=1;i<=nb_month;i++)
        {
            if((i + date_d.getMonthValue() - 1)<10)
            {
                //System.out.println(i);
                LocalDate valtemp = LocalDate.parse("01/0"+(i+date_d.getMonthValue()-1)+"/2021", formatter);
                premier_jour_mois.add(valtemp.withDayOfMonth(1).getDayOfYear());
            }
            else if((i + date_d.getMonthValue() - 1)<13)
            {
                //System.out.println(i);
                LocalDate valtemp = LocalDate.parse("01/" + (i + date_d.getMonthValue() - 1) + "/2021", formatter);
                premier_jour_mois.add(valtemp.withDayOfMonth(1).getDayOfYear());
            }
        }
        
        System.out.println("VELEUR DEBUT DU MOIS "+ date_d.getMonthValue());
        System.out.println("VELEUR JOUR DEBUT " + date_d.getDayOfYear());

        for (int i=1;i<=365;i++)
        {
           for(int a= 0;a<nb_month;a++)
           {
                
                if(i==premier_jour_mois.get(a))
                {

                    if(date_d.getDayOfYear()<=i) //n'affiche pas le mois en cour 
                    {
                        g.setColor(Color.red);
                        g.drawLine(MARGE_GAUCHE + i *ECART_ENTRE_JOUR - (date_d.getDayOfYear()*ECART_ENTRE_JOUR), ORIGINE_DESSIN_Y, MARGE_GAUCHE + i * ECART_ENTRE_JOUR- (date_d
                            .getDayOfYear() * ECART_ENTRE_JOUR),
                        ORIGINE_DESSIN_Y + HAUTEUR_RECTANGLE * hauteurGrille);
                        g.setColor(Color.black);
                        //encadrement des noms des mois
                        g.drawRect(0,ORIGINE_DESSIN_Y-35,
                                MARGE_GAUCHE + i * ECART_ENTRE_JOUR - (date_d.getDayOfYear() * ECART_ENTRE_JOUR),20);
                        g.drawRect(0, ORIGINE_DESSIN_Y - 35,
                                MARGE_GAUCHE +(date_f.getDayOfYear()-date_d.getDayOfYear())* ECART_ENTRE_JOUR, 20);
                        
                    }
                    
       
                }
           }
            
        }
 
    }


    public void drawCadre(SVGGraphics2D g,String date_debut,String date_fin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);
        LocalDate date_f = LocalDate.parse(date_fin, formatter);

        g.setColor(Color.blue);
        g.drawRect(ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y, 
                MARGE_GAUCHE + (date_f.getDayOfYear() - date_d.getDayOfYear()) * ECART_ENTRE_JOUR, HAUTEUR_RECTANGLE);
        g.setColor(Color.black);
        
    }

    public void drawHachure(SVGGraphics2D g,List<Integer> nb_api,String date_debut,String date_fin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);
        LocalDate date_f = LocalDate.parse(date_fin, formatter);

        int md_api=(int)(nb_api.size()/2);
        for(int i=0;i<md_api;i++){
           g.setColor(Color.lightGray);
           g.fillRect(ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y+(2*i*HAUTEUR_RECTANGLE)+ HAUTEUR_RECTANGLE, MARGE_GAUCHE
                   + (date_f.getDayOfYear() - date_d.getDayOfYear()) * ECART_ENTRE_JOUR, HAUTEUR_RECTANGLE);
         }
        g.setColor(Color.black);
    }

    
    public void TestSvg(){
        tableauCadrage(date_debut, date_fin);
        int NOMBRE_JOUR= jourfin-jourdebut+1;
        System.out.println(" _______________NOMBRE_________JOUR______________ :" + NOMBRE_JOUR);

        
        // Document svg.
        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);

        //Afficher le svg dans une fenêtre
        SVGGraphics2D g = new SVGGraphics2D(doc);
       
        //Apelle de l'api
        Api testdraw=new Api(vartempon);
        System.out.println(" VAR TEMPOB :"+vartempon);//donne le fichier a étudier
        testdraw.setFileApi(vartempon);
        
        //testdraw.setFileApi("C:/Users/Kleden/Documents/Api/api-test2.yaml");

        int nbapi=testdraw.count();
        ArrayList<String> str = new ArrayList<String>();
        str= testdraw.recuperateName();
        //récupératin des semaine
        List<Integer> semainedebutprojet=new ArrayList<Integer>();//date prévue Nemo
        List<Integer> semaineMepPrévue = new ArrayList<Integer>();
        List<Integer> semaineMEPSouhoutée =new ArrayList<Integer>();
        List<Integer> semaineMEPEffective = new ArrayList<Integer>();//temporaire juste pour le test

        semainedebutprojet= td.semaineDate(testdraw.recuperateDatePrévueNemoMEPP());
        semaineMepPrévue=td.semaineDate(testdraw.recuperateDatePrévueMEPP());
        semaineMEPSouhoutée = td.semaineDate(testdraw.recuperateDatePrévueMEP());
        semaineMEPEffective= td.semaineDate(testdraw.recuperateDatePrévueDemandeMEP());

        int nbapiafficher=0; 
        List<Integer> index=new ArrayList<Integer>();

        for(int i=0;i<nbapi;i++){
            
            if(semainedebut<=semainedebutprojet.get(i) && semainefin>= semaineMEPSouhoutée.get(i)){//verification api dans les borne pour affichage
                nbapiafficher++;
                index.add(i);
            }
        }
        //_______________________________________Dessiner_Grille/marge_a_afficher___________________________
        drawMonth(g,date_debut, date_fin);
       
        drawHachure(g, index, date_debut,date_fin);
        drawGrille(g, nbapiafficher,NOMBRE_JOUR,date_debut,date_fin);
        g.drawLine(MARGE_GAUCHE,ORIGINE_DESSIN_Y, MARGE_GAUCHE, ORIGINE_DESSIN_Y + HAUTEUR_RECTANGLE* nbapiafficher);//MARGE A GAUCHE 
        drawFirstdayMonth(g, date_debut, date_fin, nbapiafficher);
        System.out.println("nb api a afficher "+nbapiafficher);
        drawWeeks(g, HAUTEUR_RECTANGLE, NOMBRE_JOUR, date_debut, date_fin);
        
        //________________________________________Dessiner_les_bonnes_api_et_le_bon_nombres___________________________
        for(int i=0;i<index.size();i++)
        {
            g.drawString(str.get(index.get(i)), 6, ORIGINE_DESSIN_Y + (int) (HAUTEUR_RECTANGLE / 2));// Affichage des Nom des APi
            g.drawLine(MARGE_GAUCHE-1, ORIGINE_DESSIN_Y, MARGE_GAUCHE-1, ORIGINE_DESSIN_Y + HAUTEUR_RECTANGLE);
            g.drawLine(MARGE_GAUCHE - 2, ORIGINE_DESSIN_Y, MARGE_GAUCHE - 2, ORIGINE_DESSIN_Y + HAUTEUR_RECTANGLE);//AFFICHE DE LA MARGE
            drawCadre(g, date_debut, date_fin);
            drawcircle(g, semainedebutprojet, index.get(i),Color.BLUE);
            circleX1 = circleX2;
            drawcircle(g, semaineMepPrévue, index.get(i), Color.BLUE);
            g.setColor(Color.BLUE);
            g.drawLine(circleX1 + 10, ORIGINE_DESSIN_Y + 20, circleX2 + 10, ORIGINE_DESSIN_Y + 20);// ligne entre les
                                                                                                   // cercles
            g.setColor(Color.BLACK);
            drawcircle(g, semaineMEPSouhoutée, index.get(i),Color.green);
            circleX1 = circleX2;
            drawcircle(g, semaineMEPEffective, index.get(i), Color.green);
            g.setColor(Color.green);
            g.drawLine(circleX1 + 10, ORIGINE_DESSIN_Y + 20, circleX2 + 10, ORIGINE_DESSIN_Y + 20);// ligne entre les
            g.setColor(Color.black);
            g.translate(0, HAUTEUR_RECTANGLE);
            
        }
             

        g.setSVGCanvasSize(new Dimension(TAILLE_FENETRE_X+1000, TAILLE_FENETRE_Y+1000));

    
        Element root = doc.getDocumentElement();
        g.getRoot(root);

        JSVGCanvas canvas = new JSVGCanvas();
        JFrame f = new JFrame();
        f.getContentPane().add(canvas);
        canvas.setSVGDocument(doc);
        f.pack();
        f.setSize(TAILLE_FENETRE_X, TAILLE_FENETRE_Y);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    
    
    
    
    
}
