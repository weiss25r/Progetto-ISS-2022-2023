package it.unipa.iss.rpg.screen.model;

import java.awt.image.BufferedImage;

public class MapHandler {
    int worldX;
    int worldY;
    private MapBuilder product;
    public void createWorldMap(int x,int y){
        if(x >0 && y >0 ){
            worldX = x;
            worldY = y;
            product.buildWorldTiles(new  BufferedImage[x][y]);
        }else{
            System.out.print("Wrong Dimension");
        }
    }
    public void createEndMap(int x, int y){
        if (x > 0 && y > 0){
            if (x < this.worldX && y < this.worldY){
                product.buildEndMap(new BufferedImage[x][y]);
            }
        }else{
            System.out.print("Wrong Dimension");
        }
    }
    


}
