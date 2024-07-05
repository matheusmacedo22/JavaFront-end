import javax.swing.JFrame;

public class ShowColorsSenac
{
   // execute application
   public static void main(String[] args)
   {
      // create frame for ColorJPanel
      JFrame frame = new JFrame("Senac");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ColorJPanelSenac colorJPanel = new ColorJPanelSenac();
      frame.add(colorJPanel); 
      frame.setSize(250, 120);
      frame.setVisible(true);
   } 
}