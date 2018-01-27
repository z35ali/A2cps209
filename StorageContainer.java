import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
public class StorageContainer{
  int x;
  int y;
  String letter;
  
  
  
  public StorageContainer(int x,int y){
    this.x=x;
    this.y=y;
    letter="";
  }
  
  public int getY(){
    return y;
  }
  public int getX(){
    return x;
  }
  public void draw(Graphics2D g2){
    g2.setColor(Color.GREEN);
    g2.drawRect(x,y,30,30);
    g2.setColor(Color.black);
    g2.drawString(letter,x+15,y+25);
    
  }
  
  public void moveTo(int x, int y){
    this.x=x;
    this.y=y;
  }
  public String getLabel(){
    return letter;
  }
  
  public void setLabel(String label){
    letter=label;
  }
  
  
}









