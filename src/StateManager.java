import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StateManager {
    public static final int MENU = 0;
    private static StateManager instance = null;
    private int currentState;
    private List<State> states= new ArrayList<State>();

    /* Añadir nuevos Estados aqui */
    protected StateManager(){
        states.add(new MenuState());
        states.add(new OriginalGameState());
        init();
    }
    /* No Tocar */
    private void init() {
        for (State state: states){
            state.init();
        }
        currentState = MENU;
    }
    public void update(){
        states.get(currentState).update();
    }
    public void render(Graphics g){
        states.get(currentState).render(g);
    }
    public void setState(int state){
        currentState=state;
    }
    public static StateManager getInstance() {
        if(instance == null) {
            instance = new StateManager();
        }
        return instance;
    }
}
