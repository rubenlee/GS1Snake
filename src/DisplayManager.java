import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayManager extends JFrame {
    private static DisplayManager instance = null;
    private Canvas canvas;
    private BufferStrategy bs;
    private Logger logger;
    public int WIDTH = 600;
    public int HEIGHT= 600;
    protected DisplayManager(){
        logger = Logger.getLogger(getClass().getName());
        canvas = new Canvas();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(canvas);
        pack();
        setVisible(true);
        logger.log(Level.FINE," Configuración Correcta"); //ejemplo a borrar
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public static DisplayManager getInstance() {
        if(instance == null) {
            instance = new DisplayManager();
        }
        return instance;
    }
}
