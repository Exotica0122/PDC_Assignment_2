/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.HashMap;

/**
 *
 * @author ykx5915
 */
public class EntityFactory {
    
    public static Entity createNewEntity(String entityType, HashMap entityData) throws Exception {
        switch(entityType) {
            case "player":
                Player player = new Player(entityData);
                return player;
            case "enemy":
                Enemy enemy = new Enemy(entityData);
                return enemy;
            default:
                throw new Exception("Invalid entity");
        }
    }
    
    public static Entity createOldEntity(String entityType, HashMap entityData) throws Exception {
        switch(entityType) {
            case "player":
                Player player = new Player(entityData);
                return player;
            case "enemy":
                Enemy enemy = new Enemy(entityData);
                return enemy;
            default:
                throw new Exception("Invalid entity");
        }
    }
    
}
