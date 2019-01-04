/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author pdora
 */
public class Guide extends JPanel {
    
    int gWIDTH = 1024, gHEIGHT = 768;
    int option = 0;
    JButton bNotes, bPause;
    public Guide(){
        JPanel hPanel = new JPanel();
        hPanel.setPreferredSize(new Dimension(gWIDTH, gHEIGHT));
        hPanel.setMaximumSize(new Dimension(gWIDTH, gHEIGHT));
        hPanel.setMinimumSize(new Dimension(gWIDTH, gHEIGHT)); 
        

        
        bNotes = new JButton("");
        hPanel.add(bNotes);
        bNotes.setIcon(new ImageIcon("C:\\Users\\pdora\\Documents\\NetBeansProjects\\onenotegame\\src\\grafiki\\hnuty1.png"));
        ClickEvent en = new ClickEvent();
        bNotes.addActionListener(en);

        hPanel.setVisible(true);
    }
    
        public class ClickEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent en){
               
         
        }
}
}