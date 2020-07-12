package ASimulatorSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    
    public Login(){
       //Move the text to the center
        
      
        setTitle("ATM simulator system          © Nirajan Kunwor © 2020 ");
         
        l1=new JLabel("Welcome to ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l2=new JLabel("Card no:");
        l2.setFont(new Font("Raleway",Font.BOLD, 28));
        
        l3=new JLabel("PIN :");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        
        tf1=new JTextField(15);
        pf1=new JPasswordField(4);
        
        b1=new JButton("Sign in");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2=new JButton("Clear");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3=new JButton("Sign up");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(175, 50, 450, 200);
        add(l1);
        
        l2.setBounds(125, 150, 375, 200);
        add(l2);
        
        l3.setBounds(125, 225, 375, 200);
        add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD,14));
        tf1.setBounds(300, 235, 230, 30);
        add(tf1);
        
        pf1.setFont(new Font("Arial", Font.BOLD,14));
        pf1.setBounds(300, 310, 230, 30);
        add(pf1);
        
        b1.setFont(new Font("Arial",Font.BOLD, 14));
        b1.setBounds(300, 400, 100, 30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 400, 100, 30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD, 14));
        b3.setBounds(300, 450, 230, 30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       try{
            conn c=new conn();
            String a=tf1.getText();
            String b=pf1.getText(); //Deprecated use getPassword instead
            String q="Select * from login where cardno='"+a+"' and pin='"+b+"'";
            ResultSet rs=c.s.executeQuery(q); //data database bata tannako lagi
            
            if(e.getSource()==b1){      //action listener==button
                if(rs.next()){
                    new Transactions().setVisible(true);    //transaction frame open
                    setVisible(false); //current frame = close or false
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorect card number or password");
                    //JOption Pane to popup immediate dialog box using swing
                }
            }
            else if(e.getSource()==b2){
                tf1.setText("");
                pf1.setText("");
            }
            else if(e.getSource()==b3){
                new Signup().setVisible(true);
                setVisible(false);
            }
       }catch(Exception e1){
           e1.printStackTrace();
           System.out.println(e1.getMessage());
       }
    }
     
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}
