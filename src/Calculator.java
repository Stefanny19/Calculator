import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Calculator extends JFrame{

    public JPanel panel;
    public JLabel display;
    public float firstNumber, secondNumber, result;
    public String operator = "";
    public Boolean convert = false;

    public Calculator(){
        setSize(350, 500);
        setLocationRelativeTo(null);

        //method
        components();
    }

    //Components
    private void components(){

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        //Color
        panel.setBackground(Color.DARK_GRAY);
        
        initButtons();
        //textfield();
        labelDisplay();
    }

    private void textfield(){

        JTextField textField = new JTextField(8);

        textField.setBounds(20, 30, 290, 90);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont( new Font("arial", Font.PLAIN,60));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.DARK_GRAY);
        textField.setBorder(null);
        
        textField.setText(" ");
        

        panel.add(textField);
    }

    private void labelDisplay(){

        display = new JLabel();
        Border border = LineBorder.createGrayLineBorder();

        display.setText("0");
        display.setBounds(20, 30, 290, 90);

        display.setForeground(Color.WHITE);
        
        //display.setBorder(border);

        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont( new Font("arial", Font.PLAIN,60));

        panel.add(display);
    }

    //Buttons
    private void initButtons(){

        JButton aButton[][] = new JButton[3][5];  
        JButton operatorButton[] = new JButton[5]; 
        int x = 20;
        int y = 130;     
       
        //Numbers buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
              
                aButton[i][j] = new JButton();
                aButton[i][j].setBounds(x, y, 60, 60);
                aButton[i][j].setBackground(Color.decode("#0B0A15"));
                

                panel.add(aButton[i][j]);
                
                y += 63;                
            }
            x += 67;
            y = 130;
            
        }

        //Operation buttons
        for (int i = 0; i < operatorButton.length; i++) {

            operatorButton[i] = new JButton();
            operatorButton[i].setBounds(221, y, 90, 60);
            operatorButton[i].setBackground(Color.decode("#0B0A15"));

            panel.add(operatorButton[i]);

            y += 63;
        }

        //Design
            //Adding button numbers and symbols
        aButton[0][0].setText("+/-"); aButton[1][0].setText("%"); aButton[2][0].setText("C"); 
        aButton[0][1].setText("7"); aButton[1][1].setText("8"); aButton[2][1].setText("9"); 
        aButton[0][2].setText("4"); aButton[1][2].setText("5"); aButton[2][2].setText("6"); 
        aButton[0][3].setText("1"); aButton[1][3].setText("2"); aButton[2][3].setText("3");
        aButton[0][4].setText("."); aButton[1][4].setText("0"); aButton[2][4].setText("AC");

        operatorButton[0].setText("÷"); operatorButton[1].setText("x"); operatorButton[2].setText("-"); 
        operatorButton[3].setText("+");  operatorButton[4].setText("="); 
        
            //Text configuration
        aButton[0][0].setForeground(Color.WHITE); aButton[1][0].setForeground(Color.WHITE); aButton[2][0].setForeground(Color.WHITE); 
        aButton[0][1].setForeground(Color.WHITE); aButton[1][1].setForeground(Color.WHITE); aButton[2][1].setForeground(Color.WHITE); 
        aButton[0][2].setForeground(Color.WHITE); aButton[1][2].setForeground(Color.WHITE); aButton[2][2].setForeground(Color.WHITE); 
        aButton[0][3].setForeground(Color.WHITE); aButton[1][3].setForeground(Color.WHITE); aButton[2][3].setForeground(Color.WHITE);
        aButton[0][4].setForeground(Color.WHITE); aButton[1][4].setForeground(Color.WHITE); aButton[2][4].setForeground(Color.WHITE);

        operatorButton[0].setForeground(Color.WHITE); operatorButton[1].setForeground(Color.WHITE); operatorButton[2].setForeground(Color.WHITE); 
        operatorButton[3].setForeground(Color.WHITE);  operatorButton[4].setForeground(Color.WHITE); 
        
        aButton[0][0].setFont( new Font("arial", Font.BOLD,20)); aButton[1][0].setFont( new Font("arial", Font.BOLD,20)); 
        aButton[2][0].setFont( new Font("arial", Font.BOLD,20)); aButton[0][1].setFont( new Font("arial", Font.PLAIN,20)); 
        aButton[1][1].setFont( new Font("arial", Font.PLAIN,20)); aButton[2][1].setFont( new Font("arial", Font.PLAIN,20)); 
        aButton[0][2].setFont( new Font("arial", Font.PLAIN,20)); aButton[1][2].setFont( new Font("arial", Font.PLAIN,20)); 
        aButton[2][2].setFont( new Font("arial", Font.PLAIN,20)); aButton[0][3].setFont( new Font("arial", Font.PLAIN,20)); 
        aButton[1][3].setFont( new Font("arial", Font.PLAIN,20)); aButton[2][3].setFont( new Font("arial", Font.PLAIN,20));
        aButton[0][4].setFont( new Font("arial", Font.PLAIN,20)); aButton[1][4].setFont( new Font("arial", Font.PLAIN,16));
        aButton[2][4].setFont( new Font("arial", Font.PLAIN,16));

        operatorButton[0].setFont( new Font("arial", Font.BOLD,30)); operatorButton[1].setFont( new Font("arial", Font.BOLD,20)); 
        operatorButton[2].setFont( new Font("arial", Font.BOLD,30)); operatorButton[3].setFont( new Font("arial", Font.BOLD,20));  
        operatorButton[4].setFont( new Font("arial", Font.BOLD,25));

            //Buttons color
        aButton[0][0].setBackground(Color.decode("#CC9EA9")); aButton[1][0].setBackground(Color.decode("#CC9EA9")); aButton[2][0].setBackground(Color.decode("#CC9EA9"));

        operatorButton[0].setBackground(Color.decode("#CC9EA9")); operatorButton[1].setBackground(Color.decode("#CC9EA9")); 
        operatorButton[2].setBackground(Color.decode("#CC9EA9")); operatorButton[3].setBackground(Color.decode("#CC9EA9"));  
        operatorButton[4].setBackground(Color.GRAY);
        
        aButton[0][0].setBorderPainted(false); aButton[1][0].setBorderPainted(false); aButton[2][0].setBorderPainted(false); 
        aButton[0][1].setBorderPainted(false); aButton[1][1].setBorderPainted(false); aButton[2][1].setBorderPainted(false); 
        aButton[0][2].setBorderPainted(false); aButton[1][2].setBorderPainted(false); aButton[2][2].setBorderPainted(false); 
        aButton[0][3].setBorderPainted(false); aButton[1][3].setBorderPainted(false); aButton[2][3].setBorderPainted(false);
        aButton[0][4].setBorderPainted(false); aButton[1][4].setBorderPainted(false); aButton[2][4].setBorderPainted(false);

        operatorButton[0].setBorderPainted(false); operatorButton[1].setBorderPainted(false); operatorButton[2].setBorderPainted(false); 
        operatorButton[3].setBorderPainted(false);  operatorButton[4].setBorderPainted(false);

        //Buttons configuration
        aButton[0][0].addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                convert = true;
                
                if(convert){
                    display.setText(Float.toString(result * (-1)));
                }
            }
            
        });
        aButton[1][0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                display.setText(display.getText()+"%");                
                
            }
            
        }) ;
        aButton[2][0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                if(display.getText().length() != 0){

                    display.setText(display.getText().substring(0, display.getText().length() - 1));
                }
            }
            
        });
        aButton[0][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                display.setText(display.getText()+"7");
            }
            
        });
        aButton[1][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"8");
            }
            
        });
        aButton[2][1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"9");
            }
            
        });
        aButton[0][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"4");
            }
            
        });
        aButton[1][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"5");
            }
            
        });
        aButton[2][2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"6");
            }
            
        });
        aButton[0][3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"1");
            }
            
        });
        aButton[1][3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"2");
            }
            
        });
        aButton[2][3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"3");
            }
            
        });
        aButton[0][4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+".");
            }
            
        });
        aButton[1][4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText(display.getText()+"0");
            }
            
        });
        aButton[2][4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                display.setText("0");
            }
            
        });
    
        operatorButton[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                //display.setText(display.getText()+"÷");
                firstNumber = Float.parseFloat(display.getText());
                operator = "÷";
                display.setText(" ");
            }
            
        });
        operatorButton[1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                //display.setText(display.getText()+"x");
                firstNumber = Float.parseFloat(display.getText());
                operator ="x";
                display.setText(" ");
            }
            
        });
        operatorButton[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                //display.setText(display.getText()+"-");
                firstNumber = Float.parseFloat(display.getText());
                operator = "-";
                display.setText(" ");
            }
            
        });
        operatorButton[3].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
        
                //display.setText(display.getText()+"+");
                firstNumber = Float.parseFloat(display.getText());
                operator = "+";
                display.setText(" ");
            }
            
        });
        operatorButton[4].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                secondNumber = Float.parseFloat(display.getText());

                try {
                    switch (operator) {
                        case "÷":
                            result = firstNumber / secondNumber;
                            display.setText(Float.toString(result));
                            break;
                        case "x":
                            result = firstNumber * secondNumber;
                            display.setText(Float.toString(result));
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            display.setText(Float.toString(result));
                            break;
                        case "+":
                            result = firstNumber + secondNumber;
                            display.setText(Float.toString(result));
                            break;

                        default:
                            break;
                    }

                } catch (Exception ee) {
                    System.out.println("Error!");
                    
                }
            

            }
            
        });



    }   
}