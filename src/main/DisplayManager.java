package main;

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
    protected DisplayManager(){
        super();
        logger = Logger.getLogger(getClass().getName());
        canvas = new Canvas();
        init();
    }
    public void init(){
        logger.log(Level.FINE," Configuración Correcta"); //ejemplo a borrar
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(canvas);
        pack();
        setVisible(true);
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
