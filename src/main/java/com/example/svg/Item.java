package com.example.svg;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;



public class Item {

    private static final int TAILLE_ITEM=18;
    private int TAILLE_JOUR;
    private int ORIGINE_DESSIN_X;
    private int ORIGINE_DESSIN_Y;
    private int MARGE_GAUCHE;
    private int HAUTEUR_LIGNE;
    private Triangle triangle=new Triangle();
    private Ligne lg=new Ligne(TAILLE_ITEM);       



    private List<Integer> ligne_INTRADEF_x1_MEPP_URGENT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEPP_URGENT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_x1_MEPP_CONFIRME = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEPP_CONFIRME = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_x1_MEPP_PARDEFAULT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEPP_PARDEFAULT = new ArrayList<Integer>();

    private List<Integer> ligne_INTRADEF_x1_MEP_URGENT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEP_URGENT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_x1_MEP_CONFIRME = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEP_CONFIRME = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_x1_MEP_PARDEFAULT = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEP_PARDEFAULT = new ArrayList<Integer>();
    

    public Item(int TAILLE_JOUR,int ORIGINE_DESSIN_X,int ORIGINE_DESSIN_Y,int MARGE_GAUCHE,int HAUTEUR_LIGNE)
    {
        this.TAILLE_JOUR=TAILLE_JOUR;
        this.ORIGINE_DESSIN_X=ORIGINE_DESSIN_X;
        this.ORIGINE_DESSIN_Y=ORIGINE_DESSIN_Y;
        this.MARGE_GAUCHE=MARGE_GAUCHE;
        this.HAUTEUR_LIGNE=HAUTEUR_LIGNE;
    }

    public void drawItem()
    {
        //A CODER TA FINIT LA HIER
    }




    public void drawLigneCircleMEPP(Graphics2D g,Color color, int tab)
    {

        System.out.println("MEP URGENT X " + ligne_INTRADEF_x1_MEPP_URGENT);
        System.out.println("MEP URGENT Y  " + ligne_INTRADEF_y1_MEPP_URGENT);
        System.out.println("MEP CONFIRME X " + ligne_INTRADEF_x1_MEPP_CONFIRME);
        System.out.println("MEP CONFIRME Y  " + ligne_INTRADEF_y1_MEPP_CONFIRME);
        System.out.println("MEP PARDEFAULT " + ligne_INTRADEF_x1_MEPP_PARDEFAULT);
        System.out.println("MEP PARDEFAULT Y  " + ligne_INTRADEF_y1_MEPP_PARDEFAULT);
        System.out.println("");
        
    lg.ligne(g, Color.blue, ligne_INTRADEF_x1_MEPP_URGENT, ligne_INTRADEF_y1_MEPP_URGENT);
    lg.ligne(g, Color.blue, ligne_INTRADEF_x1_MEPP_CONFIRME, ligne_INTRADEF_y1_MEPP_CONFIRME);
    //creation des lignes en pointillé
    Graphics2D g2d = (Graphics2D) g.create();
    Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
    g2d.setStroke(dashed);
    lg.ligne(g2d, Color.blue, ligne_INTRADEF_x1_MEPP_PARDEFAULT, ligne_INTRADEF_y1_MEPP_PARDEFAULT);

    
}

//_____________________________________________________________________________________________________

    public void drawLigneCircleMEP(Graphics2D g, Color color, int tab) 
    {

        System.out.println("MEP URGENT X " + ligne_INTRADEF_x1_MEP_URGENT);
        System.out.println("MEP URGENT Y  " + ligne_INTRADEF_y1_MEP_URGENT);
        System.out.println("MEP CONFIRME X " + ligne_INTRADEF_x1_MEP_CONFIRME);
        System.out.println("MEP CONFIRME Y  " + ligne_INTRADEF_y1_MEP_CONFIRME);
        System.out.println("MEP PARDEFAULT X " + ligne_INTRADEF_x1_MEP_PARDEFAULT);
        System.out.println("MEP PARDEFAULT Y  " + ligne_INTRADEF_y1_MEP_PARDEFAULT);

        lg.ligne(g, color, ligne_INTRADEF_x1_MEP_URGENT, ligne_INTRADEF_y1_MEP_URGENT);
        lg.ligne(g, color, ligne_INTRADEF_x1_MEP_CONFIRME, ligne_INTRADEF_y1_MEP_CONFIRME);
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
        g2d.setStroke(dashed);
        lg.ligne(g2d, color, ligne_INTRADEF_x1_MEP_PARDEFAULT, ligne_INTRADEF_y1_MEP_PARDEFAULT);
    }

    


//-----------------------Methode_DrawCircle-Surcharé-------------------------------
//elle transette au les cordonnées pour afficher les lignes entre les cercle
    public void drawCircleMEPP(Graphics2D g, int i,int jour_d, List<Integer> jour_affichage, Color color,ArrayList<String> Statut_INTRADEF) 
    {
        for (int a = 0; a < jour_affichage.size(); a++) 
        {
        if (i == jour_affichage.get(a)) 
        {
            if(Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a)==i)
            {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i-jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(Color.blue);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEPP_URGENT.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEPP_URGENT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);

            }
           else if(Statut_INTRADEF.get(a).equals("CONFIRME") && jour_affichage.get(a)==i)
           {
               Shape circle = new Ellipse2D.Double(
                       MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                       ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
               g.setPaint(Color.blue);
               g.fill(circle);
               g.setColor(Color.BLACK);
               ligne_INTRADEF_x1_MEPP_CONFIRME
                       .add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
               ligne_INTRADEF_y1_MEPP_CONFIRME.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
           }
           else
           {
               Shape circle = new Ellipse2D.Double(
                       MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                       ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
               g.setPaint(color);
               g.fill(circle);
               g.setColor(Color.BLACK);
               ligne_INTRADEF_x1_MEPP_PARDEFAULT
                       .add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
               ligne_INTRADEF_y1_MEPP_PARDEFAULT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
           }
       }

    }
    }



    public void drawCircleMEPP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,List<Integer> jour_affichage2,Color color,ArrayList<String> Statut_INTERNET) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) {
                if(Statut_INTERNET.get(a).equals("URGENT") && jour_affichage.get(a)==i)
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                    ORIGINE_DESSIN_Y + ((a+jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, 
                    TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_URGENT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_URGENT.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
                else if(Statut_INTERNET.get(a).equals("CONFIRME") && jour_affichage.get(a)==i)
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                    ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM,
                    TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_CONFIRME.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_CONFIRME.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
                else
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                    ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM,
                    TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_PARDEFAULT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_PARDEFAULT.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
               
            }
        }
    }

    public void drawCircleMEPP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, List<Integer> jour_affichage2,List<Integer> jour_affichage3,
            Color color, ArrayList<String> Statut_PAPI) {
        for (int a = 0; a < jour_affichage.size(); a++) 
        {
            if (i == jour_affichage.get(a)) 
            {
                if(Statut_PAPI.get(a).equals("URGENT") && jour_affichage.get(a)==i)
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a +jour_affichage2.size()+jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_URGENT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_URGENT.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
                else if(Statut_PAPI.get(a).equals("CONFIRME") && jour_affichage.get(a)==i)
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                            ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)- TAILLE_ITEM,TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_CONFIRME.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_CONFIRME.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
                else
                {
                    Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                            ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)- TAILLE_ITEM,TAILLE_ITEM, TAILLE_ITEM);
                    g.setPaint(color);
                    g.fill(circle);
                    g.setColor(Color.BLACK);
                    ligne_INTRADEF_x1_MEPP_PARDEFAULT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                    ligne_INTRADEF_y1_MEPP_PARDEFAULT.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
                }
                
            }
        }
    }

//___________________________________________________________Draw_Circle_MEP_______________________________________________________

    public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, Color color,
        ArrayList<String> Statut_INTRADEF) {
    for (int a = 0; a < jour_affichage.size(); a++) {
        if (i == jour_affichage.get(a)) {
            if (Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_URGENT.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEP_URGENT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);

            } else if (Statut_INTRADEF.get(a).equals("CONFIRME") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_CONFIRME.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEP_CONFIRME.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
            } else {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_PARDEFAULT.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEP_PARDEFAULT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }

    }
}


    public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, List<Integer> jour_affichage2,
        Color color, ArrayList<String> Statut_INTERNET) {
    for (int a = 0; a < jour_affichage.size(); a++) {
        if (i == jour_affichage.get(a)) {
            if (Statut_INTERNET.get(a).equals("URGENT") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM,
                        TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_URGENT
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_URGENT
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            } else if (Statut_INTERNET.get(a).equals("CONFIRME") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM,
                        TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_CONFIRME
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_CONFIRME
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            } else {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM,
                        TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_PARDEFAULT
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_PARDEFAULT
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }

        }
    }
}

public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, List<Integer> jour_affichage2,
        List<Integer> jour_affichage3, Color color, ArrayList<String> Statut_PAPI) {
    for (int a = 0; a < jour_affichage.size(); a++) {
        if (i == jour_affichage.get(a)) {
            if (Statut_PAPI.get(a).equals("URGENT") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM,
                        TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_URGENT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_URGENT.add(ORIGINE_DESSIN_Y+ ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            } else if (Statut_PAPI.get(a).equals("CONFIRME") && jour_affichage.get(a) == i) {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM,
                        TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_CONFIRME.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_CONFIRME.add(ORIGINE_DESSIN_Y+ ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            } else {
                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)- TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP_PARDEFAULT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_PARDEFAULT.add(ORIGINE_DESSIN_Y+ ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }

        }
    }
}






    //-------------------draw--------------------triangle-----------------------------------

    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, Color color,
            ArrayList<String> Statut_INTRADEF) 
    {
    for (int a = 0; a < jour_affichage.size(); a++) 
    {
        if (i == jour_affichage.get(a))
            {
            if(Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a)==i)
                    {
                        triangle.drawMe(g, color,Color.red,
                             MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                             ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                        ligne_INTRADEF_x1_MEP_URGENT.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                        ligne_INTRADEF_y1_MEP_URGENT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
                    }
            else if (Statut_INTRADEF.get(a).equals("CONFIRME") && jour_affichage.get(a)==i)
                    {
                        triangle.drawMe(
                                g, color, color, MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X
                                        - TAILLE_ITEM / 2 + 10,
                                ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                        ligne_INTRADEF_x1_MEP_CONFIRME.add(
                                (MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                        ligne_INTRADEF_y1_MEP_CONFIRME.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
                    }
            else
             {
                triangle.drawMe(g, color, color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP_PARDEFAULT
                        .add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEP_PARDEFAULT.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }
}


    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,
            List<Integer> jour_affichage2, Color color, ArrayList<String> Statut_INTERNET) 
    {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) 
            {
             if(Statut_INTERNET.get(a).equals("URGENT") && jour_affichage.get(a)==i)
             {
                triangle.drawMe(g, color,Color.RED,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP_URGENT
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_URGENT
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
            else if (Statut_INTERNET.get(a).equals("CONFIRME") && jour_affichage.get(a) == i)
            {
            triangle.drawMe(g, color,color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP_CONFIRME
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_CONFIRME
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
            else
            {
                triangle.drawMe(g, color, color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP_PARDEFAULT
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_PARDEFAULT
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }}

    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,
            List<Integer> jour_affichage2, List<Integer> jour_affichage3, Color color,
            ArrayList<String> Statut_PAPI) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) 
            {
            if(Statut_PAPI.get(a).equals("URGENT") && jour_affichage.get(a)==i)
             {
                triangle.drawMe(g, color,Color.red,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM*2 - 3);
                ligne_INTRADEF_x1_MEP_URGENT
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_URGENT.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
            else if (Statut_PAPI.get(a).equals("CONFIRME") && jour_affichage.get(a) == i)
            {
                triangle.drawMe(g, color,color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM*2 - 3);
                ligne_INTRADEF_x1_MEP_CONFIRME
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_CONFIRME.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);   
            }
            else
            {
                triangle.drawMe(g, color, color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP_PARDEFAULT.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP_PARDEFAULT.add(ORIGINE_DESSIN_Y+ ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }
    
}





    public void drawRectangle(Graphics2D g,int withd,int height,int a,Color color)
    {   
        g.setColor(color);
        g.drawRect(ORIGINE_DESSIN_X,ORIGINE_DESSIN_Y,withd,height);
        g.setColor(Color.BLACK);
    }




    
}
