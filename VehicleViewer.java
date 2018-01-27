import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;


public class VehicleViewer
{  
  
  public static void main(String[] args){
    VehicleComponent comp;
    JFrame frame = new VehicleFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("VehicleViewer");
    frame.setLayout(new BorderLayout());
    comp = new VehicleComponent();

    frame.add(comp);
    
    
    
    frame.setVisible(true);      
  }
  
}


