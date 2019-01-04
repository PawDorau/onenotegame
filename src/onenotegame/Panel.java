/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static onenotegame.Note.*;

/**
 *
 * @author pdora
 */
public class Panel extends JPanel implements Runnable,KeyListener {
    
    public static final int pWIDTH  = 924;
    public static final int pHEIGHT = 418;
    Image panelBG;
    private Thread thread;
    public static boolean running = false;
    private int FPS = 60;
    private long targetTime = 1000/FPS;
    int speed = 3;
    
    public Panel(Task task){
        
            this.setPreferredSize(new Dimension(pWIDTH,pHEIGHT));
            this.setMaximumSize(new Dimension(pWIDTH,pHEIGHT));
            this.setMinimumSize(new Dimension(pWIDTH,pHEIGHT));
            this.setBounds(50, 50, pWIDTH, pHEIGHT);
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setVisible(true);
            this.addKeyListener(this);
            task.setText(Task.genTask());
            //start();

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
               
             if (wait <= 0) {
                wait = 5;
            }
            
            try{
            Thread.sleep(wait);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
     }
    
    public void stop(){
        running = false;
    }
     
    
    @Override
    
    public void paint(Graphics g){
    super.paint(g);
    Graphics2D b = (Graphics2D)g;
    
    for(Note note: Note.NoteList){
        
    b.setColor( Color.WHITE );
    b.fillRect(note.xCoords, note.yCoords, note.noteX, note.noteY);
    b.drawImage(note.noteImg ,0 , 0, null);
    
    note.xCoords = note.xCoords - speed;
    
    if(note.xCoords==0){
    b.dispose(); 
    NoteList.remove(note);
    }
    }
    }

    
    
 @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
        g.drawImage(panelBG, 0, 0, null);
}

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if(KeyCode == KeyEvent.VK_SPACE){
            System.out.println("DUPA");
            start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

