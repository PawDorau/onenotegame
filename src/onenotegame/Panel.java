/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;

import java.awt.*;
import javax.swing.*;
import static onenotegame.Note.*;

/**
 *
 * @author pdora
 */
public class Panel extends JPanel implements Runnable {
    
    Image background = Toolkit.getDefaultToolkit().getImage("panelbg.png");
    private Thread thread;
    public static boolean running = true;
    private int FPS = 60;
    private long targetTime = 1000/FPS;
    int pWIDTH, speed = 3;
    
    
    public Panel(int pWIDTH,int pHEIGHT){
        
        this.setPreferredSize(new Dimension(pWIDTH,pHEIGHT));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setVisible(true);
        
    }

    
    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
     public void run(){
        long start,elapsed,wait;
        
            while(running){
            start = System.nanoTime();
            
            
            repaint();
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed /1000;
               
            
            try{
            Thread.sleep(wait);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
     }
    
    public void tick(){
        
    }
    
    @Override
    
    public void paint(Graphics g){
    super.paint(g);
    Graphics2D b = (Graphics2D)g;
    for(Note note: Note.NoteList){
        
    b.setColor( Color.WHITE );
    b.fillRect(note.xCoords, note.yCoords, note.noteX, note.noteY);
    b.drawImage(note.noteImg ,0 , 0, null);
    
    note.xCoords = note.xCoords +speed;
    if(note.xCoords==pWIDTH){
    b.dispose(); 
    NoteList.remove(note);
    }
    }
    }

    
    
 @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
}
}
    

