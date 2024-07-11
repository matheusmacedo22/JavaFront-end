import java.awt.*;
import javax.swing.*;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.YELLOW);

      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);
      g.setColor(Color.BLUE);
      g.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 22));
      g.drawString("Senac ", 160, 28);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.fillRect(100, 40, 90, 55);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString(" Java ", 20, 75);
      g.setColor(Color.WHITE);
      g.setFont(new Font("ARIAL", Font.ITALIC + Font.BOLD, 22));
      g.drawString("Senac ", 113, 75);

      g.setColor(Color.BLACK);
      g.fillRoundRect(290, 40, 90, 55, 20, 20);
      g.drawRoundRect(195, 40, 90, 55, 50, 50);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Curso ", 210, 75);
      g.setColor(Color.WHITE);
      g.setFont(new Font("ARIAL", Font.ITALIC + Font.BOLD, 22));
      g.drawString("Senac ", 305, 75);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.fill3DRect(100, 100, 90, 55, false);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Color ", 25, 135);
      g.setColor(Color.WHITE);
      g.setFont(new Font("ARIAL", Font.ITALIC + Font.BOLD, 22));
      g.drawString("Senac ", 112, 135);

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.fillOval(290, 100, 90, 55);
      g.setFont(new Font("ARIAL", Font.ITALIC, 22));
      g.drawString("Fonte ", 212, 135);
      g.setColor(Color.WHITE);
      g.setFont(new Font("ARIAL", Font.ITALIC + Font.BOLD, 22));
      g.drawString("Senac ", 303, 135);
   } 
} // end class LinesRectsOvalsJPanel

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
