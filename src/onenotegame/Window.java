/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onenotegame;

/**
 *
 * @author pdora
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends Canvas{
    
    public  Window(int WIDTH ,int HEIGHT, String title){
        JFrame window = new JFrame(title);

        window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        window.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        
        
        Panel panel = new Panel( WIDTH-100,HEIGHT-300 );
        panel.setPreferredSize(new Dimension(WIDTH-100, HEIGHT-300));
        panel.setBounds(50, 50, WIDTH-100, HEIGHT-300);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        window.getContentPane().add(panel);
        
        //panel menu
        JPanel menu = new JPanel();
        menu.setBounds(50, 510, WIDTH-100, 200);
        window.add(menu);
        menu.setLayout(new FlowLayout());
        ((FlowLayout)menu.getLayout()).setHgap(75);
        menu.setSize(WIDTH-100, 200);
        
        //pole z zadaniem
        JTextField task = new JTextField("zadanie");
        task.setBounds(50, 623, 300, 75);
        menu.add(task);
        
        //wynik
        JTextField Score = new JTextField("Wynik");
        Score.setBounds(500, 623, 150, 75);
        menu.add(Score);
        
        //samouczek
        //Icon hicon = new ImageIcon(getClass().getResource("hicon.png")); //dodanie wyglądu przycisku
        //JButton Help = new JButton("POMOC",hicon);
        JButton help = new JButton("POMOC");
        help.setBounds(824, 623, 150, 75);
        menu.add(help);
        ClickEvent e = new ClickEvent();
        help.addActionListener(e);
        
        window.pack();
        window.setVisible(true);

        
    }
    
     //samouczek event
    public class ClickEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //wyświtlenie samouczka
           
           //panel.stop(); 
        }
}
}