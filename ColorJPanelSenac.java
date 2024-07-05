import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorJPanelSenac extends JPanel 
{
   // draw rectangles and Strings in different colors
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.RED);

      // set new drawing color using integers
      g.setColor(new Color(0, 0, 255));
      g.fillRect(15, 25, 100, 20);
      g.drawString("Senac ", 130, 40);

      // set new drawing color using floats
      g.setColor(new Color(255, 255, 255));
      g.fillRect(15, 50, 100, 20);
      g.drawString("Curso de Java ", 130, 65);

      
   } 
}
