import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
public abstract class Vehicle{
  int x ;
  int y;
  int number=1;
  boolean selected;
  Color color;
  boolean isTrailer=false;
  boolean trainLink=false;
  boolean moved=false;
  Vehicle trailer;
  Vehicle vehicle;
  StorageContainer queue;
  Rectangle hitbox;
  public Vehicle (int x, int y){
    this.x=x;
    this.y=y;
  }
  public int getNumber(){
    return number;
  }
  public void setNumber(int i){
    number=i;
  }
  public void trailerLink(Vehicle v1, boolean train){
    vehicle=v1;
    
    trainLink=train;
 
    if (trailer==null){
      
      
      trailer=v1;
         v1.isTrailer=true;
    }else{
      trailer=v1.trailer;
      
      v1.trailer=trailer;
      v1.trailer.isTrailer=true;
      
    }
    
    if (trainLink){
      
      
      
      v1.moveTo(this.x+100,this.y);
    }else{
      
      v1.moveTo(this.x+66,this.y);
      
    }
  }
  public void setColor(Color color){
   this.color=color;
  }
  public Color getColor(){
    return this.color;
  }
  public void trailerLink2(Vehicle v1, boolean train){
    vehicle=v1;
    
    trainLink=train;
    
    if (trailer==null){
      
      trailer=v1;
      v1.isTrailer=true;
    }else{
      trailer=v1;
      
      v1=trailer;
      v1.isTrailer=true;
      
    }
    
    if (trainLink){
      
      
      
      v1.moveTo(this.x+100,this.y);
    }else{
      
      v1.moveTo(this.x+66,this.y);
      
    }
  }
  
  
  
  
  
  
  
  public int getX(){
    
    return x;
  }
  
  public int getY(){
    return y;
  }
  public void moveTo(int x, int y){
    
    this.x=x;
    this.y=y;
    hitcar(x,y);
    if (queue!=null){
      queue.moveTo(x+15,y-21);
    }
    if (trailer!=null){
      if (trainLink){
        
        trailer.moveTo(x+100,y);
        
      }else{
        trailer.moveTo(x+66,y);
        
        
        
        
      }
    }
  }
  
  public void setColor(boolean b){
    selected = b;
    if (trailer != null){
      trailer.setColor(b);
    }
    
  }
  
  public void hitcar(int x, int y){
    hitbox= new Rectangle (x,y,60, 10);
  }
  
  abstract boolean isClicked(double x, double y);
  public abstract void draw(Graphics2D g2);
  
  
}