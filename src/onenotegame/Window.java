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
    Panel panel;
    JFrame window;
    
    public  Window(int WIDTH ,int HEIGHT, String title){
        window = new JFrame(title);

        window.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        window.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());
        
        //panel menu
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(WIDTH-100, 200));
        window.add(menu, BorderLayout.SOUTH);
        menu.setLayout(new FlowLayout());
        ((FlowLayout)menu.getLayout()).setHgap(75);
        ((FlowLayout)menu.getLayout()).setVgap(75);
        
        
        //pole z zadaniem
        Task task = new Task();
        menu.add(task, FlowLayout.LEFT);
        
        
        //wynik
        Font font = new Font("SansSerif", Font.BOLD, 20);
        JTextField Score = new JTextField("Wynik");
        Score.setPreferredSize(new Dimension(150,75));
        menu.add(Score, FlowLayout.CENTER);
        Score.setHorizontalAlignment(JTextField.CENTER);
        Score.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
        Score.setFont(font);
        Score.setEditable(false);
        Score.setBackground(Color.WHITE);
        
        //samouczek
        JButton Help = new JButton("POMOC");
        Help.setPreferredSize(new Dimension(150,75));
        menu.add(Help, FlowLayout.RIGHT);
        Help.setIcon(new ImageIcon("C:\\Users\\pdora\\Documents\\NetBeansProjects\\onenotegame\\src\\grafiki\\hicon2.png"));
        Help.setBackground(Color.WHITE);
        Help.setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
        ClickEvent e = new ClickEvent();
        Help.addActionListener(e);
        
        //panel rozgrywki
        panel = new Panel(task);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        window.getContentPane().add(panel,BorderLayout.CENTER );
        
        window.pack();
        window.setVisible(true);

    }
    
     //samouczek event
    public class ClickEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           //wyświtlenie samouczka
           panel.stop(); 
           
           Guide guide = new Guide();
           window.add(guide);
           window.setVisible(true);
        }
}
}