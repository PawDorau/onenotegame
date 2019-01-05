/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;

import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import static onenotegame.Task.Color.*;
import static onenotegame.Task.Value.*;

/**
 *
 * @author pdora
 */
public class Note {
    
    public static ArrayList<Note>NoteList = new ArrayList<Note>();
    int id =0, noteX=0, noteY=0,xCoords=Panel.pWIDTH, yCoords=Panel.pHEIGHT/2;;
    BufferedImage noteImg;
    Task.Color noteColor;
    Task.Value noteValue;
    boolean noteClicked = false;
    
    public Note(int id, int noteX,int noteY,int xCoords,int yCoords, BufferedImage noteImg, Task.Color noteColor, Task.Value noteValue, boolean noteClicked){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.id = id;
        this.noteX=noteX;
        this.noteY=noteY;
        this.noteImg=noteImg;
        this.noteColor=noteColor;
        this.noteValue=noteValue;
        this.noteClicked=noteClicked;

}
    
    public void CreateList() throws IOException{

        while(Panel.running){
        
        //losuj img nuty/pauzy
        int min = 1 , max=40;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        //noteImg = ImageIO.read(new File("note"+randomNum+".png"));
        noteImg = ImageIO.read(getClass().getResource("grafiki.notes/panelbg"+randomNum+".png"));
        //JLabel noteImage = new JLabel(new ImageIcon("note"+randomNum+".png"));
        
        //pobierz wymiary
        noteX = noteImg.getHeight();
        noteY = noteImg.getHeight();
        
        //przypis kolor
        if((randomNum>0 && randomNum<5)&&(randomNum>20 && randomNum<25)){
        noteColor=CZARNA; }
        else if((randomNum>4 && randomNum<9)&&(randomNum>24 && randomNum<29)){
        noteColor = CZERWONA; }
        else if((randomNum>8 && randomNum<13)&&(randomNum>28 && randomNum<33)){
        noteColor = NIEBIESKA; }
        else if((randomNum>12 && randomNum<17)&&(randomNum>32 && randomNum<37)){
        noteColor = POMARAŃCZOWA; }
        else if((randomNum>16 && randomNum<21)&&(randomNum>36 && randomNum<41)){
        noteColor = ZIELONA; }
        
        //przypis wartosc
        if((randomNum>0 && randomNum<5)&&(randomNum>20 && randomNum<25)){
        noteColor=CZARNA; }
        else if((randomNum>4 && randomNum<9)&&(randomNum>24 && randomNum<29)){
        noteColor = CZERWONA; }
        else if((randomNum>8 && randomNum<13)&&(randomNum>28 && randomNum<33)){
        noteColor = NIEBIESKA; }
        else if((randomNum>12 && randomNum<17)&&(randomNum>32 && randomNum<37)){
        noteColor = POMARAŃCZOWA; }
        else if((randomNum>16 && randomNum<21)&&(randomNum>36 && randomNum<41)){
        noteColor = ZIELONA; }
        
        if((randomNum==1 || randomNum-4==1 || randomNum-8==1 || randomNum-12==1)){
        noteValue=CAŁANUTA; }
        else if((randomNum==2 || randomNum-4==2 || randomNum-8==2 || randomNum-12==2)){
        noteValue=PÓŁNUTA; }
        else if((randomNum==3 || randomNum-4==3 || randomNum-8==3 || randomNum-12==3)){
        noteValue=ĆWIERĆNUTA; }
        else if((randomNum==4 || randomNum-4==4 || randomNum-8==4 || randomNum-12==4)){
        noteValue=CAŁANUTA; }
        else if((randomNum-20==1 || randomNum-24==1 || randomNum-28==1 || randomNum-32==1)){
        noteValue=CAŁAPAUZA; }
        else if((randomNum-20==2 || randomNum-24==2 || randomNum-28==2 || randomNum-32==2)){
        noteValue=PAUZAPÓŁNUTOWA; }
        else if((randomNum-20==3 || randomNum-24==3 || randomNum-28==3 || randomNum-32==3)){
        noteValue=PAUZAĆWIERĆNUTOWA; }
        else if((randomNum-20==4 || randomNum-24==4 || randomNum-28==4 || randomNum-32==4)){
        noteValue=PAUZAÓSEMKOWA; }
        
        NoteList.add(new Note(id++ , noteX, noteY,xCoords, yCoords, noteImg, noteColor, noteValue, noteClicked));
        
        }
    }
    
}
