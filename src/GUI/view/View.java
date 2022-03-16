/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.view;

import GUI.components.panels.gamePanels.BattlePanel;
import GUI.components.panels.gamePanels.LoginPanel;
import GUI.components.panels.gamePanels.MainMenuPanel;
import GUI.components.panels.gamePanels.TitleScreenPanel;
import GUI.controller.Controller;
import GUI.model.Data;
import entities.Player;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ykx5915
 */
public class View implements Observer {
    
    public JFrame mainFrame;
    public Container con;
    
    public TitleScreenPanel titleScreenPanel;
    public MainMenuPanel mainMenuPanel;
    public LoginPanel loginPanel;
    public BattlePanel battlePanel;
    
    public View() {
        
        this.mainFrame = new JFrame("Tribute");
        mainFrame.setSize(800,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.black);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        con = mainFrame.getContentPane();
        
        titleScreenPanel = new TitleScreenPanel();
        con.add(titleScreenPanel);
        
        loginPanel = new LoginPanel();
        con.add(loginPanel);
        loginPanel.setVisible(false);
        
        mainMenuPanel = new MainMenuPanel();
        con.add(mainMenuPanel);
        mainMenuPanel.setVisible(false);
        
        battlePanel = new BattlePanel();
        con.add(battlePanel);
        battlePanel.setVisible(false);
        
        
        
    }
    
    public void addController(Controller controller) {
        ArrayList<JButton> allButtonsArray = new ArrayList<>();
        allButtonsArray.addAll(titleScreenPanel.getButtonList());
        allButtonsArray.addAll(loginPanel.getButtonList());
        allButtonsArray.addAll(mainMenuPanel.getButtonList());
        allButtonsArray.addAll(battlePanel.getButtonList());
        
        allButtonsArray.forEach(button -> {
            button.addActionListener(controller);
        });
    }
    
    public void setPlayerMainMenu(Player player) {
//        , playerHPLabel, playerLevelLabel, playerJobLable
        mainMenuPanel.getPlayerNameLabel().setText("Name: " + player.getName());
        mainMenuPanel.getPlayerHPLabel().setText("HP: " + player.getHP());
        mainMenuPanel.getPlayerLevelLabel().setText("LVL: " + player.getLevel());
        mainMenuPanel.getPlayerJobLabel().setText("Job: " + player.getJob());
    }
    
    public void showTitleScreen() {
        titleScreenPanel.setVisible(true);
    }
    
    public void closeTitleScreen() {
        titleScreenPanel.setVisible(false);
    }
    
    public void showLoginPanel() {
        loginPanel.setVisible(true);
    }
    
    public void closeLoginPanel() {
        loginPanel.setVisible(false);
    }
    
    public void showMainMenuPanel() {
        mainMenuPanel.setVisible(true);
    }
    
    public void closeMainMenuPanel() {
        mainMenuPanel.setVisible(false);
    }
    
    public void showBattlePanel() {
        battlePanel.setVisible(true);
    }
    
    public void closeBattlePanel() {
        battlePanel.setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg) {
         Data data = (Data) arg;
         if(data.showTitleScreen) showTitleScreen();
         if(!data.showTitleScreen) closeTitleScreen();
         if(data.showLoginPanel) showLoginPanel();
         if(!data.showLoginPanel) closeLoginPanel();
         if(data.showMainMenuPanel) showMainMenuPanel();
         if(data.showMainMenuPanel) closeMainMenuPanel();
         if(data.showBattlePanel) showBattlePanel();
         if(!data.showBattlePanel) closeBattlePanel();
    }
    
    
}
