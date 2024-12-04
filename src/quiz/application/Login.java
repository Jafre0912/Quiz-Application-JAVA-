package quiz.application;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {

    JButton start, close;
    JTextField tfName;
    
    public Login() {
 
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/quiz.png"));
        setIconImage(icon.getImage());
        
        setTitle("Login Form");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login_page_quiz.png"));
        JLabel image = new JLabel(image1);
        image.setBounds(370, 50, 255, 100);
        add(image);
        
        JLabel heading = new JLabel("Growing Minds");
        heading.setBounds(395, 150, 255, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(new Color(3, 132, 252));
        add(heading);
        
        JLabel name = new JLabel("Enter your name : ");
        name.setBounds(250, 250, 300, 30);
        name.setFont(new Font("serif", Font.BOLD, 18));
        name.setForeground(new Color(3, 132, 252));
        add(name);
        
        
        tfName = new JTextField();
        tfName.setBounds(410, 250, 300, 30);
        tfName.setFont(new Font("serif", Font.BOLD, 15));
        Insets inset1 = tfName.getMargin();
        inset1.left = 5; 
        tfName.setMargin(inset1);
        add(tfName);
        
        start = new JButton();
        start.setText("Start Quiz");
        start.setBounds(320, 350, 130, 40);
        start.setBackground(new Color(3, 132, 252));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("serif", Font.BOLD, 18));
        Insets inset2 = start.getMargin();
        inset2.set(10, 10, 10, 10);
        start.setMargin(inset2);
        start.addActionListener(this);
        add(start);
        
        
        close = new JButton();
        close.setText("Close");
        close.setBounds(550, 350, 130, 40);
        close.setBackground(new Color(3, 132, 252));
        close.setForeground(Color.WHITE);
        close.setFont(new Font("serif", Font.BOLD, 18));
        Insets inset3 = start.getMargin();
        inset3.set(10, 10, 10, 10);
        close.setMargin(inset3);
        close.addActionListener(this);
        add(close);
       
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == start) {
          
            String name = tfName.getText();
            
            if(name.length() < 3) {
                JOptionPane.showMessageDialog(this, "Enter proper name first");
            }
            
            else if(name.length() > 15) {
                JOptionPane.showMessageDialog(this, "Please write shorter name");
            }
            
            else {
                setVisible(false);
                new Quiz_Page(name);
            }
            
        }
        
        else if(event.getSource() == close) {
            dispose();
           
        }
    }
    
    
    public static  void main(String[] amk) {
        new Login();
        
    }
    
}
