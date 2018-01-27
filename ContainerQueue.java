import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Queue;
import java.awt.Rectangle;
import java.util.LinkedList;
public class ContainerQueue{
  int x;
  int y;



  Queue<StorageContainer> queue;
  StorageContainer container1;
  StorageContainer container2;
  StorageContainer container3;
  StorageContainer container4;
  StorageContainer container5;
  
  public ContainerQueue(int x, int y){
    this.x=x;
    this.y=y;
    
    queue = new LinkedList <StorageContainer>();
    container1= new StorageContainer(x+25,y-30);
    container1.setLabel("A");
    queue.add(container1);
    
    container2= new StorageContainer(x+25,y-65);
    container2.setLabel("B");
    queue.add(container2);
    
    container3= new StorageContainer(x+25,y-100);
    container3.setLabel("C");
    queue.add(container3);
    
    container4= new StorageContainer(x+25,y-135);
    container4.setLabel("D");
    queue.add(container4);
    
    container5= new StorageContainer(x+25,y-170);
    container5.setLabel("E");
    queue.add(container5);
    
    
  }
  public StorageContainer getLast(){
    
    return queue.peek();
  }
  
  public void update(){

    for (StorageContainer sc: queue){
      sc.moveTo(sc.getX(),sc.getY()+(35));
      
    }
  }
  
  public void draw(Graphics2D g2){ 
    Rectangle rect= new Rectangle (x,y+1,80,30);
    g2.fill(rect);
    for (StorageContainer sc: queue){
      sc.draw(g2);
    }
  }
}













