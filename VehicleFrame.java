import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.ArrayList;
/**
 This frame has a menu with commands to change the font 
 of a text sample.
 */
public class VehicleFrame extends JFrame
{
  private static final int FRAME_WIDTH = 800;
  private static final int FRAME_HEIGHT = 700;
  
  
  VehicleComponent comp= new  VehicleComponent();
  /**
   Constructs the frame.
   */
  public VehicleFrame()
  {  
    
    
    // Construct menu      
    JMenuBar menuBar = new JMenuBar();     
    setJMenuBar(menuBar);
    menuBar.add(createFileMenu());
    menuBar.add(createQueueMenu());
    menuBar.add(createListMenu());
    
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
  }
  
  
  class ExitItemListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      System.exit(0);
    }
  }  
  
  public JMenuItem createNewItem()
  {
    class NewItemListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        VehicleComponent.list=new ArrayList<Vehicle>();
        VehicleComponent.count1=1;
        VehicleComponent.queue=null;
        VehicleComponent.queueBoolean=true;
        VehicleComponent.rc=false;
        VehicleComponent.engine= true;
        repaint();
      }
    } 
    JMenuItem item = new JMenuItem("New");
    ActionListener listener = new NewItemListener();
    item.addActionListener(listener);
    return item;
    
  }
  /**
   Creates the File menu.
   @return the menu
   */
  public JMenu createFileMenu()
  {
    JMenu menu = new JMenu("File");
    JMenuItem exitItem = new JMenuItem("Exit");   
    
    
    ActionListener listener = new ExitItemListener();
    
    exitItem.addActionListener(listener);
    
    menu.add(exitItem);
    menu.add(createNewItem());
    return menu;
  }
  
  /**
   Creates the Font submenu.
   @return the menu
   */
  public JMenu createQueueMenu()
  {
    JMenu menu = new JMenu("Queue");
    menu.add(createRemoveQueueMenu());
    menu.add(createAddQueueMenu());
    
    return menu;
  }  
  
  public JMenu createListMenu(){
    JMenu menu= new JMenu ("List");
    menu.add(createAddFirstMenu());
    menu.add(createAddLastMenu());
    menu.add(createRemoveFirstMenu());
    menu.add(createRemoveLastMenu());
    return menu;
  }
  
  public JMenuItem createAddFirstMenu(){
    class AddFirstListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        VehicleComponent.addFirst();
        repaint();
      }
    } 
    
    JMenuItem item = new JMenuItem("AddFirst");
    ActionListener listener = new AddFirstListener();
    item.addActionListener(listener);
    return item;
    
    
  }
  
  public JMenuItem createAddLastMenu(){
    class AddLastListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        VehicleComponent.addLast();
        repaint();
      }
    } 
    ActionListener listener = new AddLastListener();
    JMenuItem menuItem= new JMenuItem ("AddLast");
    menuItem.addActionListener(listener);
    return menuItem;
  }
  
  public JMenuItem createRemoveFirstMenu(){
    class RemoveFirstListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        VehicleComponent.removeFirst();
        repaint();
      }
    } 
    ActionListener listener = new RemoveFirstListener();
    JMenuItem menuItem= new JMenuItem ("RemoveFirst");
    menuItem.addActionListener(listener);
    return menuItem;
  }
  
  
  public JMenuItem createRemoveLastMenu(){
    class AddFirstListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        VehicleComponent.removeLast();
        repaint();
      }
    } 
    
    JMenuItem item = new JMenuItem("RemoveLast");
    ActionListener listener = new AddFirstListener();
    item.addActionListener(listener);
    return item;
    
    
  }
  
  
  
  /**
   Creates the Face submenu.
   @return the menu
   */
  
  public JMenuItem createRemoveQueueMenu()
  {
    class RemoveQueueListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        VehicleComponent.removeQueue();
        repaint();
      }
    }
    JMenuItem menuItem = new JMenuItem("remove");
    ActionListener listener= new RemoveQueueListener();
    menuItem.addActionListener(listener);
    return menuItem;
  }  
  
  /**
   Creates the Size submenu.
   @return the menu
   */
  public JMenuItem createAddQueueMenu()
  {
    class AddQueueListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        VehicleComponent.addQueue();
        repaint();
      }
    }
    JMenuItem menuItem = new JMenuItem("add");
    ActionListener listener= new AddQueueListener();
    menuItem.addActionListener(listener);
    return menuItem;
  } 
  
  
  
}


