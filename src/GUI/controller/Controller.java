/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import DatabaseClasses.DBManager;
import GUI.model.Model;
import GUI.view.View;
import entities.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import skill.Skill;

/**
 *
 * @author ykx5915
 */
public class Controller implements ActionListener {
    
    public View view;
    public Model model;
    
    private DBManager dBManager;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.dBManager = new DBManager();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        
        if(source == view.titleScreenPanel.getStartButton()) {
            System.out.println("Start button pressed");
            view.closeTitleScreen();
            view.showLoginPanel();
        } else if(source == view.loginPanel.getLoginButton()) {
            String name = view.loginPanel.getLoginField().getText().trim();
            
            if(name.isEmpty()) return;
            
            if(dBManager.playerExists(name)) {
                model.player = dBManager.loadPlayer(name);
                view.closeLoginPanel();
                view.showMainMenuPanel();
                view.setPlayerMainMenu(model.player);
                model.getLearnableSkills();
            } else {
                view.loginPanel.showSelectJob();
            }
        } else if(source == view.loginPanel.getWarriorButton()) {
            String name = view.loginPanel.getLoginField().getText().trim();
            
            model.player = new Player(name, "Warrior");
            
            view.closeLoginPanel();
            view.showMainMenuPanel();
            view.setPlayerMainMenu(model.player);
            model.getLearnableSkills();
        } else if(source == view.loginPanel.getArcherButton()) {
            String name = view.loginPanel.getLoginField().getText().trim();
            
            model.player = new Player(name, "Archer");
            
            view.closeLoginPanel();
            view.showMainMenuPanel();
            view.setPlayerMainMenu(model.player);
            model.getLearnableSkills();
        } else if(source == view.mainMenuPanel.getEnterBattleButton()) {
            view.battlePanel.getMainTextArea().setText("");
            model.setNewGame();
            view.closeMainMenuPanel();
            view.showBattlePanel();
            view.battlePanel.setSkillSlot(model.player);
            view.battlePanel.setPlayerStats(model.player);
            view.battlePanel.setEnemyStats(model.gameModel.getEnemy());
        } else if(source == view.mainMenuPanel.getSaveButton()) {
            dBManager.savePlayer(model.player);
            System.out.println("Saved");
            System.exit(0);
        } else if(source == view.battlePanel.getSkill1()) {
            if(model.choiceMenu.equals("battle")) attack(0);
            if(model.choiceMenu.equals("learn")) learnSkill(0);
        } else if(source == view.battlePanel.getSkill2()) {
            if(model.choiceMenu.equals("battle")) attack(1);
            if(model.choiceMenu.equals("learn")) learnSkill(1);
        } else if(source == view.battlePanel.getSkill3()) {
            if(model.choiceMenu.equals("battle")) attack(2);
            if(model.choiceMenu.equals("learn")) learnSkill(2);
        } else if(source == view.battlePanel.getSkill4()) {
            if(model.choiceMenu.equals("battle")) attack(3);
            if(model.choiceMenu.equals("learn")) learnSkill(3);
        }
    }
    
    private void attack(int skill) {
        view.battlePanel.getMainTextArea().setText("");
        view.battlePanel.getMainTextArea().append("\nPlayer used: " + model.player.getSkillSlot().getSkill(skill).getName());
        model.gameModel.getEnemy().takeDamage(model.player.getSkillSlot().getSkill(skill).getDamage());
        view.battlePanel.setEnemyStats(model.gameModel.getEnemy());
        if(model.gameModel.getEnemy().isDead()) {
            view.battlePanel.getMainTextArea().setText("You slayed the Enemy");
            view.battlePanel.getMainTextArea().append("\nLeveled up");
            model.player.levelUp();
            model.player.heal();
            view.battlePanel.setPlayerStats(model.player);
            if(model.checkPlayerCanLearnNewSkill(model.player)) {
                view.battlePanel.getMainTextArea().append("\nPlayer can learn: " + model.learnableSkill.getName() +
                "\nDamage: " + model.learnableSkill.getDamage() +
                "\nDescription: " + model.learnableSkill.getDescription() +
                "\nSelect from existing skill to learn new skill");
                model.setLearnSkillMenu();
            } else {
                view.closeBattlePanel();
                view.showMainMenuPanel();
                view.setPlayerMainMenu(model.player);
            }     
        } else {
            Skill enemySkill = model.gameModel.getEnemy().attack(model.player);
            view.battlePanel.getMainTextArea().append("\nEnemy used: " + enemySkill.getName());
            view.battlePanel.setPlayerStats(model.player);
            if(model.player.isDead()) {
                model.player.heal();
                view.closeBattlePanel();
                view.showMainMenuPanel();
                view.setPlayerMainMenu(model.player);
            }
        } 
    }
    
    private void learnSkill(int skill) {
        model.player.getSkillSlot().replaceSkill(model.learnableSkill, skill);
        model.choiceMenu = "battle";
        model.learnableSkill = null;
        view.closeBattlePanel();
        view.showMainMenuPanel();
        view.setPlayerMainMenu(model.player);
    }
    
    
}
