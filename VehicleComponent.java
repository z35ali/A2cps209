import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;


/**
 Component that draws a snow person that is moved my a mouse.
 */
public class VehicleComponent extends JComponent
{  
  
  
  static Vehicle select;
  Vehicle selectTrailer;
  static int count=1;
  static int count1=1;
  int size=0;
  boolean black=false;
  static Vehicle v;
  public  static boolean rc=false;
  public static boolean engine= true;
  public static boolean que=false;
  public static ArrayList <Vehicle>list=new ArrayList <Vehicle> ();
  static ContainerQueue  queue;
  
  static boolean queueBoolean =true;
  public VehicleComponent()
  {  
    
    /*
     Make a listener that responds to mouse events.
     It moves the snow person to the mouse position.
     You could also use the MouseAdaptor interface - google it
     */
    class MyListener implements MouseListener
    {
      public void mousePressed(MouseEvent event)
      {
        
        if (count1>5){
          rc=false;
        }
        select=null;
       
       black=false;
        
        //loops through the array list and checks if it is selected
        for (int i=0;i<list.size();i++){
       
          if ((list.get(i).isClicked(event.getX(),event.getY()))){
              System.out.println("clicked");
                 System.out.println(list.get(i).selected);
            if (!(list.get(i).selected)){
            System.out.println("selected");
            Vehicle select1=select;
            select=list.get(i);
            if (select!=select1){
              deSelectAll();
System.out.println("deselect");
                     System.out.println("deselect");
        
           // select.selected=true;
            System.out.println("red");
            changeColor();
            
            }
        }
        }
        }
         
        if (engine&&!rc){
          
          TrainEngine te= new TrainEngine (event.getX(),event.getY());
          list.add(te);
          rc=true;
          engine=false;
        }
        
        else if (rc&&!engine&&(count1<=5)){
          
          RailCar railcar=new RailCar(event.getX(),event.getY());
          list.add(railcar);
          railcar.setNumber(count);
          rc=true;
          engine=false;
          
          count++;
          count1++;
        }
        else if (!rc&&!engine&&queueBoolean){
          
          queue= new ContainerQueue  (event.getX(),event.getY());
          engine=false;
          queueBoolean=false;
        }
        
        repaint();
      }
      
      public void mouseReleased(MouseEvent event)
      {
        for (int i=0;i<list.size();i++){
          if (select!=null){
            if (list.get(i)!=select){
              if (list.get(i).hitbox.intersects(select.hitbox)){
                if (i!=0){
                  list.get(i).trailerLink(select,false);
                  
                }else if (i==0){
                  list.get(i).trailerLink(select,true);
                  
                }
              }
            }
          }
          repaint();
        }
      
        //do nothing
      }
      public void mouseClicked(MouseEvent event)
      {
        
      }
      public void mouseEntered(MouseEvent event)
      {
        //do nothing
      }
      public void mouseExited(MouseEvent event)
      {
        //do nothing
      }
    }
    // Make a Mylistener object and connect to the component object using inherited
    // method "addMouseListener()"
    // The reference variable listener is of type MouseListener
    // This means it can refer to objects whose class implements the MouseListener interface
    // The only methods you can call via the listener variable are those listed in the MouseListener
    // interface
    MouseListener listener = new MyListener() ;
    addMouseListener(listener) ;
    
    // Set up mouse motion handler
    class MyMotionListener implements MouseMotionListener
    {
      public void mouseDragged(MouseEvent event)
      {
        for (int i=0;i<list.size();i++){
          
          if (select==list.get(i)){
            list.get(i).moveTo(event.getX(),event.getY());
            repaint();
          }
        } 
        
      }
      
      public void mouseMoved(MouseEvent event)
      {
        // do nothing
        // use this one if you don't want to hold down the mouse button
        // while dragging
      }
    }
    // Create mouse motin listenefr object ad connect to component object
    MouseMotionListener mlistener = new MyMotionListener() ;
    addMouseMotionListener(mlistener) ;
  }
  
  
  
  public static void addLast(){
    if (select!=list.get(0)){
    if (select!=null){
      if (list.get(0).trailer==null){
        list.get(0).trailerLink(select,true);
        
           
      }else{
        
          Vehicle a=null;
    Vehicle b=null;
    a=list.get(0);
    while (a!=null){
      b=a;
      a=a.trailer;
    }
   
    
    
    
     
        b.trailerLink(select,false);
       
        
      
     
      
    
      }
    }
      select=null;
  }
  }
  public static void addFirst(){
    if (select!=list.get(0)){
    if (select!=null){
      Vehicle a=null;
      Vehicle b=null;
      if (list.get(0).trailer==null){
        list.get(0).trailerLink(select,true);
       
        
      }else{
        a=select;
        while (a!=null){
          b=a;
          a=a.trailer;
        }
        
        b.trailer=list.get(0).trailer;
        list.get(0).trailer=b.trailer;
        
        list.get(0).trailerLink2(select,true);
        
      }
      
      select=null;
    }
        }
  }
  public static void removeLast(){
    int randomX= 60 + (int)(Math.random() * 740); 
    int randomY= 10 + (int)(Math.random() *670); 
    Vehicle a=null;
    Vehicle b=null;
    a=list.get(0);
    while (a!=null){
      b=a;
      a=a.trailer;
    }
    a=list.get(0);
    
    
    while (a!=null){
      if (a.trailer==b){
        
        a.trailer.moveTo(randomX,randomY);
        a.hitcar(randomX,randomY);
        a.trailer.isTrailer=false;
        a.trailer=null;
        
      }
      a=a.trailer;
      
    }
  }
  public static void removeFirst(){
    if (list.get(0).trailer!=null){
      int randomX= 60 + (int)(Math.random() * 740); 
      int randomY= 10+ (int)(Math.random() *670); 
      Vehicle a=null;
      Vehicle b=null;
      a=list.get(0);
      
      b=a.trailer;
      
      a=list.get(0);
      
      
      
      
      
      list.get(0).trailer=list.get(0).trailer.trailer;
      b.moveTo(randomX,randomY);
     
      b.hitcar(randomX,randomY);
      list.get(0).moveTo(list.get(0).getX(), list.get(0).getY());
      b.isTrailer=false;
      a=a.trailer;
      select=null;
    }
  }
  public static void removeQueue(){
    if (!queue.queue.isEmpty()){
    if (select!=list.get(0)&&select!=null){
      if (queue.getLast()!=null){
        if (select.queue==null){
          queue.getLast().moveTo(select.getX()+15,select.getY()-21);
          
          select.queue=queue.getLast();
          queue.queue.remove();
          queue.update();
          
        }else if (select.trailer!=null){
          
          Vehicle a=select;
          
          while (a.trailer.queue!=null){
            
            a=a.trailer;
            if (a.trailer==null){
              break;
            }
          }
         
          if (a.trailer!=null){  
            queue.getLast().moveTo(a.trailer.getX()+15,a.trailer.getY()-21);
            a.trailer.queue=queue.getLast();
            queue.queue.remove();
            queue.update();
         
          }
        }
      }
    }else if (select==list.get(0)){
            select=select.trailer;
            removeQueue();
          }
    
  }
    select=null;
  }
  public void changeColor()
  {
    
    Vehicle temp = null;
    temp = select;
    if (temp==select){
      temp=select.trailer;
    while(temp != null)
    {
     
      temp.selected=true;;
      
      temp = temp.trailer;
      
    }
    }
  }
  public void deSelectAll(){
    for (int i=0;i<list.size();i++){
      list.get(i).selected=false;
    
      
      
    }
  }
  public static void addQueue(){
    if (queue.queue.size()!=5){
    if (select!=null){
      if (select.queue!=null){
        select.queue.moveTo(queue.x+25,queue.y-(35)*(queue.queue.size())-30);
        System.out.println(queue.queue.size());
        queue.queue.add(select.queue);
        
        select.queue=null;
        
        
      }else if (select.trailer!=null){
        
        Vehicle a=select;
        
        while (a.trailer.queue==null){
          
          a=a.trailer;
          if (a.trailer==null){
            break;
          }
        }
      
          
          
          if (a.trailer.queue!=null){
            a.trailer.queue.moveTo(queue.x+25,queue.y-(35)*(queue.queue.size())-30);
            queue.queue.add(a.trailer.queue);
            a.trailer.queue=null;
         
        }
      }
      
      
      
      
    }else if (select==list.get(0)){
            select=select.trailer;
            removeQueue();
          }
  }
    select=null;
  }
  
  
  
  public void paintComponent(Graphics g)
  {  
    
    Graphics2D g2 = (Graphics2D)g;
    
    if (queue!=null){
      queue.draw(g2);
    }
    for (int i=0;i<list.size();i++){
      if (list.get(i).isTrailer!=true){
      if (list.get(i).trailer!=null){
        list.get(i).trailer.draw(g2);
      }
      if (select!=list.get(i)){
     
     
      g2.setColor(Color.black);
        list.get(i).draw(g2);
      
      
      }else {
       System.out.println(list.get(i));
         g2.setColor(Color.RED);
       
        list.get(i).draw(g2);
      
      }}
  }
  }
  
}
