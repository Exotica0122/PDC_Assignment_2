/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Enemy;
import entities.Player;

/**
 *
 * @author ykx5915
 */
public class GameModel {
    
    private Player player;
    private Enemy enemy;
    private boolean isOver;
    
    public GameModel(Player player) {
        this.player = player;
        this.enemy = new Enemy(player.getLevel());
        this.isOver = false;
    }
    
    public Player getPlayer() { return player; }
    
    public Enemy getEnemy() { return enemy; }
    
    public boolean isOver() { return (player.isDead() || enemy.isDead()); }
}
