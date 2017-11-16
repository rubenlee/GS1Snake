package main;

public class Key {

    public String name;
    public int keyCode, pressCount;
    public boolean pressed;

    public Key(String name, int keyCode){
        this.name = name;
        this.keyCode = keyCode;
        this.pressed=false;
    }
    public void toggle(boolean toggle){
        if(pressed != toggle){
            pressed = toggle;
        }
        if(pressed){
            pressCount++;
        }
    }
}
