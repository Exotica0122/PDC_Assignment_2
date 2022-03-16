/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.components.panels.gamePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ykx5915
 */
public class MainMenuPanel extends JPanel {
    
    private JPanel mainMenuPanel, titleNamePanel;
    private JLabel titleNameLabel, playerNameLabel, playerHPLabel, playerLevelLabel, playerJobLable;
    private JButton enterBattleButton, saveButton;
    
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    
    private ArrayList<JButton> buttonList;
    
    public MainMenuPanel() {
        
        buttonList = new ArrayList<>();
        
        this.setSize(800,600);
        this.setBackground(Color.black);
        this.setLayout(null);
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 50, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("TRIBUTE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(150, 200, 500, 300);
        mainMenuPanel.setBackground(Color.black);
        mainMenuPanel.setLayout(new GridLayout(3,2));
        
        playerNameLabel = new JLabel("Name: ");
        playerNameLabel.setFont(normalFont);
        playerNameLabel.setForeground(Color.white);
        mainMenuPanel.add(playerNameLabel);
        
        playerHPLabel = new JLabel("HP: ");
        playerHPLabel.setFont(normalFont);
        playerHPLabel.setForeground(Color.white);
        mainMenuPanel.add(playerHPLabel);
        
        playerLevelLabel = new JLabel("LVL: " );
        playerLevelLabel.setFont(normalFont);
        playerLevelLabel.setForeground(Color.white);
        mainMenuPanel.add(playerLevelLabel);
        
        playerJobLable = new JLabel("Job: ");
        playerJobLable.setFont(normalFont);
        playerJobLable.setForeground(Color.white);
        mainMenuPanel.add(playerJobLable);
        
        enterBattleButton = new JButton("Battle");
        enterBattleButton.setBackground(Color.black);
        enterBattleButton.setForeground(Color.white);
        enterBattleButton.setFont(normalFont);
//        enterBattleButton.addActionListener(gameScreenHandler);
        enterBattleButton.setFocusPainted(false);
        mainMenuPanel.add(enterBattleButton);
        
        saveButton = new JButton("Save & Exit");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);
//        saveButton.addActionListener(saveAndExit);
        saveButton.setFocusPainted(false);
        mainMenuPanel.add(saveButton);
        
        buttonList.add(enterBattleButton);
        buttonList.add(saveButton);
        
        add(titleNamePanel);
        add(mainMenuPanel);
    }
    
    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }
    
    public JLabel getPlayerNameLabel() {
        return playerNameLabel;
    }
    
    public JLabel getPlayerHPLabel() {
        return playerHPLabel;
    }
    
    public JLabel getPlayerLevelLabel() {
        return playerLevelLabel;
    }
    
    public JLabel getPlayerJobLabel() {
        return playerJobLable;
    }
    
    public JButton getEnterBattleButton() {
        return enterBattleButton;
    }
    
    public JButton getSaveButton() {
        return saveButton;
}
    
    
    
    
    
}
