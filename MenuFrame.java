import javax.swing.*;

public class MenuFrame extends JFrame {

    public MenuFrame() {
        super("Menu");

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        JMenu arquivoMenu = new JMenu("Arquivo");
        arquivoMenu.setMnemonic('A'); 
        bar.add(arquivoMenu);

        JMenu editarMenu = new JMenu("Editar");
        editarMenu.setMnemonic('E');
        bar.add(editarMenu);


    }
}