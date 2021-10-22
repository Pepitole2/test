package com.example.svg;

import java.awt.*;
import java.util.List;

public class Ligne {

    private int TAILLE_ITEM;

    public Ligne(int TAILLE_ITEM){
        this.TAILLE_ITEM=TAILLE_ITEM;
    }

    public void ligne(Graphics2D g, Color color, List<Integer> ligne_x, List<Integer> ligne_y) {
        for (int y = 0; y < ligne_y.size(); y++) {
            for (int a = y + 1; a < ligne_y.size(); a++) {
                if (ligne_y.get(y).equals(ligne_y.get(a))) {
                    g.setColor(color);
                    g.drawLine(ligne_x.get(y) + TAILLE_ITEM / 2, ligne_y.get(y) + TAILLE_ITEM / 2,
                            ligne_x.get(a) + TAILLE_ITEM / 2, ligne_y.get(a) + TAILLE_ITEM / 2);
                    g.setColor(Color.black);
                }
            }
        }
    }

    /*List<Integer> liste_testx1 = new ArrayList<Integer>(ligne_INTRADEF_x1_MEP);
        List<Integer> liste_testy1 = new ArrayList<Integer>(ligne_INTRADEF_y1_MEP);
        for (int y = 0; y < ligne_INTRADEF_y1_MEP.size(); y++) {
            for (int a = y + 1; a < ligne_INTRADEF_y1_MEP.size(); a++) {
                if (ligne_INTRADEF_y1_MEP.get(y).equals(ligne_INTRADEF_y1_MEP.get(a))) {
                    g.setColor(color);
                    g.drawLine(ligne_INTRADEF_x1_MEP.get(y) + TAILLE_ITEM / 2, ligne_INTRADEF_y1_MEP.get(y) + TAILLE_ITEM / 2,
                            ligne_INTRADEF_x1_MEP.get(a) + TAILLE_ITEM / 2, ligne_INTRADEF_y1_MEP.get(a) + TAILLE_ITEM / 2);
                    g.setColor(Color.black);
                    liste_testx1.remove(ligne_INTRADEF_x1_MEP.get(a));
                    liste_testx1.remove(ligne_INTRADEF_x1_MEP.get(y));
                    liste_testy1.remove(ligne_INTRADEF_y1_MEP.get(a));
                    liste_testy1.remove(ligne_INTRADEF_y1_MEP.get(y));
                }
            }
        }
    
        System.out.println(liste_testy1);
        List<Integer> testy1 = new ArrayList<Integer>(liste_testy1);   //On copi les listes 
        List<Integer> testx1 = new ArrayList<Integer>(liste_testx1);
        List<Integer> liste_test_y2 = new ArrayList<Integer>(testy1);
        List<Integer> liste_test_x2 = new ArrayList<Integer>(testx1);
        for (int i = 0; i < testy1.size(); i++)// Si l'un des deux cercle n'est pas dessiner , on prolonge le trait jusqu'a la marge
        {                                           //si la marge l aplus proche est a gauche
            for(int a=0;a<ligne_INTRADEF_y1.size();a++)
            {
                if(testy1.get(i).equals(ligne_INTRADEF_y1.get(a)))
                {
                    g.setColor(color);
                    g.drawLine(tab+ MARGE_GAUCHE+ 24, liste_testy1.get(i) + TAILLE_ITEM / 2, liste_testx1.get(i) + TAILLE_ITEM / 2,
                    liste_testy1.get(i) + TAILLE_ITEM / 2);
                    g.setColor(Color.black);
                    liste_test_y2.remove(ligne_INTRADEF_y1.get(a));
                }

            }
        }
        if(liste_test_y2.size()>1)//si la marge la plus proche et a droite
        {
            for (int i = 0; i < liste_test_y2.size(); i++)
            {
                g.setColor(color);
                g.drawLine(MARGE_GAUCHE + 24, liste_test_y2.get(i) + TAILLE_ITEM / 2,
                        liste_test_x2.get(i) + TAILLE_ITEM / 2, liste_test_y2.get(i) + TAILLE_ITEM / 2);
                g.setColor(Color.black);
            }
        }*/
    
}
