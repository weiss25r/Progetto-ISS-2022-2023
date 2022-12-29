package it.unipa.iss.rpg.screen.model;

import java.util.ArrayList;

public class Level {
    int counter;
    //only 2 map for level
    ArrayList<Map> maps;

    public Level(ArrayList<Map> maps){
        this.maps = maps;
        this.counter = 0;
    }
    public void switchMap(){
        if (counter == 0){
            counter = 1;
        }else{
            counter = 0;
        }
    }

    public Map getCurrentMap(){
        return this.maps.get(this.counter);
    }

}
