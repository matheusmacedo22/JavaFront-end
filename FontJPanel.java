import java.awt.*;
import javax.swing.*;

public class FontJPanel extends JPanel
{
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 

      g.setColor(Color.BLUE);
      g.fillRect(20, 40, 100, 50);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.ITALIC, 22));
      g.drawString("Senac ", 22, 70);
   }
}

      