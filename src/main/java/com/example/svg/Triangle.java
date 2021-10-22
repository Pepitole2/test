package com.example.svg;
    
import java.awt.*;


public class Triangle {

    private int Ax=30;  //sommet du triangle Ax en haut  --> commun au deux triangle
    private int Bx=20;   //sommet du triangle Bx         --> commun au deux triangle 


    public Triangle() {
    }

    public void drawMe(Graphics g,Color color ,Color color2,int x,int y) {
    
        g.setColor(color);
        int x4[] = { x, x - 8, x + 8 };
        int y4[] = { Ax+y, 2 * Bx+y, 2 * Bx+y };
        g.fillPolygon(x4, y4, 3);
        int x5[] = { x, x - 8, x + 8 };
        int y5[] = { Ax+y, Bx+y, Bx+y };
        g.fillPolygon(x5, y5, 3);
        g.setColor(color2);

        int x9[] = { x, x-8, x+8 };
        int y9[] = { Ax+y , 2*Bx+y, 2*Bx+y };
        g.drawPolygon(x9, y9, 3);
        int x1[] = { x, x-8, x+8 };
        int y1[] = { Ax+y, Bx+y, Bx+y };
        g.drawPolygon(x1, y1, 3);
        g.setColor(Color.black);
        

       }
}
    

