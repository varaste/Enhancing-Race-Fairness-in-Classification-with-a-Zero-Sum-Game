package convertdecitobin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//13
public class ConvertDeciToBin extends JFrame{
    
    //Screen items
    
    JFrame window;
    JTextField input;
    JTextField output;
    JButton convert;
    JButton clear;
    JLabel decimal;
    JLabel binary;
    JPanel innerwindow;
    
    //calculation variables
    
     Double i_bin=0.0;//get i from user input
     ArrayList<String> mylist_bin;
     ArrayList<String> my_frac=new ArrayList<>();
 
     long integer_bin;
       String one_bin="1";
     String zero_bin="0";
     String in;
     String con_fra="";
     String out; 
    
     double fraction_bin;
     double v_universal;
     double mul=0.0;
     double k;
     long inte;
         
     String ret_bin="";
 
  
    public static void main(String[] args) {
        
        ConvertDeciToBin calc_bin=new ConvertDeciToBin();
        calc_bin.screen();        
    }
    
    //Method to render the screen
    public void screen(){
        window=new JFrame("Convert Decimal to Binary v 1.0");
        window.setLocationRelativeTo(null);
        window.setSize(500, 150);
        decimal=new JLabel("Enter Decimal value");
        binary=new JLabel("Binary Output");
        innerwindow=new JPanel();
        input=new JTextField(30);
        output=new JTextField(30);
        output.setEditable(false);
        output.setBackground(Color.WHITE);
        output.enableInputMethods(false);
        convert=new JButton("Convert");
        clear=new JButton("Clear");
        innerwindow.add(decimal);
        innerwindow.add(input);
        innerwindow.add(binary);
        innerwindow.add(output);
        innerwindow.add(convert);
        innerwindow.add(clear);
        window.add(innerwindow);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        convert.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
              in= input.getText();
              if(in.contains(".")){
                i_bin=Double.valueOf(in);
                double bin=i_bin;
                integer_bin=(long)bin;
                fraction_bin=bin-integer_bin;
                String in_int=binary((double)integer_bin);
                String in_fra=binary_frac(fraction_bin);
                out=in_int+in_fra;
                output.setText(out);
                
              }else{
                  out=binary(Double.valueOf(in));
                  output.setText(out);
              }
              
            }catch(NumberFormatException p){
            }
        }
               
        });
        
        clear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                output.setText("");
                window.repaint();
                my_frac.clear();
            } 
       });
    }
    
    
    
    //Method to convert input decimal into binary ---
    public String binary(Double k){    
        if(k==0.0){
            ret_bin="0";
            return ret_bin;
        }else
        mylist_bin=new ArrayList<>();
               i_bin=k;
        for(int l=0;l<999999999;l++){//loop over the largest integer possible
            int v=i_bin.intValue();
           
               i_bin=i_bin/2;
               
              if((v%2)!=0){
                   mylist_bin.add(one_bin);
                  
              } else{
                   mylist_bin.add(zero_bin);
                                  
               }                                
               
               if(i_bin<=1){//break from loop when division is over
              
                  break; 
               }                               
                       
        }//End of for loop
        
         int w=mylist_bin.size();//get the size of the arraylist
              String gt=mylist_bin.get(w-1);//get the string at the last index
                   
                   if((!"1".equals(gt))){
                       mylist_bin.set(w-1, "1");
                       mylist_bin.add(0, "0");                     
                   }
        
        String a=mylist_bin.toString();
        
        StringBuilder rt=new StringBuilder(a);
        rt=rt.reverse();
        
        ret_bin=rt.toString();
        ret_bin=ret_bin.replace("[","").replace("]", "").replace(",", "");
       
        
        return ret_bin+" ";
                     
    }
        
    //Method to perform fraction parts operation
    public String binary_frac(double v){
        
        v_universal=v;
        String zero="0";
        String one="1";
         
        for(int y=0;y<999999999;y++){//loop over the largest integer possible
             mul=v_universal*2;
             inte=(long)mul;
                       
            if(inte==0){
                my_frac.add(zero);
                v_universal=mul;
                
            }else {
              my_frac.add(one);
              break;
              
            }
                        
        }
        
         String a=my_frac.toString();
      
        a=a.replace("[","").replace("]", "").replace(",", "");
        
        con_fra=a;
        return con_fra;      
    }    
}

