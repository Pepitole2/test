package com.example.svg;
    
import java.awt.*;


public class Triangle {

    private Color color;
    private int TAILLE_ITEM;
    private int ORIGINE_DESSIN_X;
    private int ORIGINE_DESSIN_Y;    
    private int MARGE_GAUCHE;
    private int HAUTEUR_LIGNE;

    private int Ax=30;  //sommet du triangle Ax en haut  --> commun au deux triangle
    private int Bx=20;   //sommet du triangle Bx         --> commun au deux triangle 
    private int Cx=10;   //sommet du triangle Cx         --> communt au deux triangle
    private int Ay=10; //sommet du triangle Ay            --> cmmun au deux triangle
    private int By=20;
    private int Cy=20;

    public Triangle(int ORIGINE_DESSIN_X,int ORIGINE_DESSIN_Y,int MARGE_GAUCHE,int HAUTEUR_LIGNE) {
        this.ORIGINE_DESSIN_X=ORIGINE_DESSIN_X;
        this.ORIGINE_DESSIN_Y=ORIGINE_DESSIN_Y;
        this.MARGE_GAUCHE=MARGE_GAUCHE;
        this.HAUTEUR_LIGNE=HAUTEUR_LIGNE;
    }

    public void drawMe(Graphics g,Color color,int x,int y) {
    

        int x9[] = { ORIGINE_DESSIN_X, ORIGINE_DESSIN_X-5, ORIGINE_DESSIN_X+5 };
        int y9[] = { Ax , 2*Bx, 2*Bx };
        g.drawPolygon(x9, y9, 3);
        int x1[] = { ORIGINE_DESSIN_X, ORIGINE_DESSIN_X-5, ORIGINE_DESSIN_X+5 };
        int y1[] = { Ax, Bx, Bx };
        g.drawPolygon(x1, y1, 3);
        

       }
}
    

