package com.example.svg;


import java.awt.Image;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


import org.apache.batik.svggen.SVGGraphics2D;

public class Logo extends Draw {
    public void paintLogoMinArm(SVGGraphics2D g) {

        try {
            Image minArm = ImageIO.read(new File("src/LogoMinArme.jpg"));
            super.paintComponent(g);
            g.drawImage(minArm, 0, 0, 500,500, this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}