/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import DatabaseClasses.DBManager;
import entities.Player;
import java.util.ArrayList;
import java.util.Observable;
import models.GameModel;
import skill.Skill;

/**
 *
 * @author ykx5915
 */
public class Model extends Observable {
    
    private DBManager dBManager;
    public Data data;
    
    public Player player;
    public GameModel gameModel;
    
    private int playerHP, enemyHP, enemyLevel;
    private String playerJob;
    
    public String choiceMenu;
    
    public ArrayList<Skill> learnableSkillList;
    public Skill learnableSkill;
    
    public Model() {
        this.dBManager = new DBManager();
        this.data = new Data();
        this.learnableSkillList = new ArrayList<>();
        this.choiceMenu = "battle";
    }
    
    public void playerSetup(Player player) {
        playerHP = player.getHP();
        playerJob = player.getJob();
    }
    
    public void enemySetup() {
        enemyHP = gameModel.getEnemy().getHP();
        enemyLevel = gameModel.getEnemy().getLevel();
//        enemyHPLabelNumber.setText(Integer.toString(enemyHP));
//        enemyLevelLabelNumber.setText(Integer.toString(enemyLevel));
    }
    
    public void setBattleMenu() {
        choiceMenu = "battle";
    }
    
    public void setLearnSkillMenu() {
        choiceMenu = "learn";
    }
    
    public void setPlayerStats() {
//        playerNameLabel.setText("Name: " + player.getName());
//        playerHPLabel.setText("HP: " + player.getHP());
//        playerLevelLabel.setText("LVL: " + player.getLevel());
//        playerJobLable.setText("Job: " + player.getJob());
    }
    
    public void setEnemyStats() {
//        enemyHPLabelNumber.setText(""+gameModel.getEnemy().getHP());
    }
    
    public boolean checkPlayerCanLearnNewSkill(Player player) {
        for(int i=0; i<learnableSkillList.size() ;i++) {
            if(learnableSkillList.get(i).getLevelRequirement() == player.getLevel()) {
                learnableSkill = (learnableSkillList.get(i));
                return true;
            }
        }
        return false;
    }
    
    public void showTitleScreen() {
        data.showTitleScreen = true;
        notifyObservers(data);
    }
    
    public void closeTitleScreen() {
        data.showTitleScreen = false;
        notifyObservers(data);
    }
    
    public void showLoginPanel() {
        data.showLoginPanel = true;
        notifyObservers(data);
    }
    
    public void closeLoginPanel() {
        data.showLoginPanel = false;
        notifyObservers(data);
    }
    
    public void showMainMenuPanel() {
        data.showMainMenuPanel = true;
        notifyObservers(data);
    }
    
    public void closeMainMenuPanel() {
        data.showMainMenuPanel = true;
        notifyObservers(data);
    }
    
    public void showBattlePanel() {
        data.showBattlePanel = false;
        notifyObservers(data);
    }
    
    public void closeBattlePanel() {
        data.showBattlePanel = false;
        notifyObservers(data);
    }

    public void getLearnableSkills() {
        learnableSkillList = dBManager.getSkillList(player.getJob()+"Skill");
    }
    
    public void setNewGame() {
        this.gameModel = new GameModel(player);
    }
    
}
