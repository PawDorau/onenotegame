/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;

import java.awt.image.*;
import java.io.*;
import java.util.logging.*;
import javax.imageio.*;

/**
 *
 * @author pdora
 */
public class Images {
    
    public static BufferedImage panelbg, helpbg;
    
    public Images(){
        
    try {
            helpbg = ImageIO.read(getClass().getResourceAsStream("grafiki/hnuty1.png"));
            panelbg = ImageIO.read(getClass().getResource("grafiki\\panelbg.png"));


        } catch (IOException e) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, e);
        }
}
}