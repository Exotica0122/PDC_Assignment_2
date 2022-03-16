/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.components.panels.gamePanels;

import entities.Enemy;
import entities.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author ykx5915
 */
public class BattlePanel extends JPanel {
    
    private JPanel mainTextPanel, skillSelectPanel, playerStatsPanel, enemyPanel;
    private JLabel playerNameLabel, playerHPLabel, playerLevelLabel, playerJobLable, enemyLevelLabel, enemyLevelLabelNumber, enemyHPLabel, enemyHPLabelNumber;
    private JButton skill1, skill2, skill3, skill4;
    private JTextArea mainTextArea;
    
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    
    private ArrayList<JButton> buttonList;
    
    public BattlePanel() {
        
        buttonList = new ArrayList<>();
        
        this.setSize(800,600);
        this.setBackground(Color.black);
        this.setLayout(null);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        add(mainTextPanel);
        
        mainTextArea = new JTextArea("Welcome to the arena\nChoose your attack");
        mainTextArea.setBounds(100, 200, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
        
        skillSelectPanel = new JPanel();
        skillSelectPanel.setBounds(25, 350, 400, 150);
        skillSelectPanel.setBackground(Color.black);
        skillSelectPanel.setLayout(new GridLayout(2,2));
        
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(450, 350, 350, 150);
        playerStatsPanel.setBackground(Color.black);
        playerStatsPanel.setLayout(new GridLayout(2,2));
        add(playerStatsPanel);
        
        playerNameLabel = new JLabel("Name: ");
        playerNameLabel.setFont(normalFont);
        playerNameLabel.setForeground(Color.white);
        playerStatsPanel.add(playerNameLabel);
        
        playerHPLabel = new JLabel("HP: ");
        playerHPLabel.setFont(normalFont);
        playerHPLabel.setForeground(Color.white);
        playerStatsPanel.add(playerHPLabel);
        
        playerLevelLabel = new JLabel("LVL: ");
        playerLevelLabel.setFont(normalFont);
        playerLevelLabel.setForeground(Color.white);
        playerStatsPanel.add(playerLevelLabel);
        
        playerJobLable = new JLabel("Job: ");
        playerJobLable.setFont(normalFont);
        playerJobLable.setForeground(Color.white);
        playerStatsPanel.add(playerJobLable);
        
//        set skills to its name
        skill1 = new JButton("");
        skill1.setBackground(Color.black);
        skill1.setForeground(Color.white);
        skill1.setFont(normalFont);
        skillSelectPanel.add(skill1);
        skill1.setFocusPainted(false);
//        skill1.addActionListener(choiceHandler);
        skill1.setActionCommand("s1");
        
        skill2 = new JButton("");
        skill2.setBackground(Color.black);
        skill2.setForeground(Color.white);
        skill2.setFont(normalFont);
        skillSelectPanel.add(skill2);
        skill2.setFocusPainted(false);
//        skill2.addActionListener(choiceHandler);
        skill2.setActionCommand("s2");
        
        skill3 = new JButton("");
        skill3.setBackground(Color.black);
        skill3.setForeground(Color.white);
        skill3.setFont(normalFont);
        skillSelectPanel.add(skill3);
        skill3.setFocusPainted(false);
//        skill3.addActionListener(choiceHandler);
        skill3.setActionCommand("s3");
        
        skill4 = new JButton("");
        skill4.setBackground(Color.black);
        skill4.setForeground(Color.white);
        skill4.setFont(normalFont);
        skillSelectPanel.add(skill4);
        skill4.setFocusPainted(false);
//        skill4.addActionListener(choiceHandler);
        skill4.setActionCommand("s4");
        
        add(skillSelectPanel);
        
        buttonList.add(skill1);
        buttonList.add(skill2);
        buttonList.add(skill3);
        buttonList.add(skill4);
        
//      Top portion  
        enemyPanel = new JPanel();
        enemyPanel.setBounds(100, 40, 600, 50);
        enemyPanel.setBackground(Color.black);
        enemyPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        enemyPanel.setLayout(new GridLayout(1, 4));
        
        enemyLevelLabel = new JLabel("Enemy lvl:");
        enemyLevelLabel.setFont(normalFont);
        enemyLevelLabel.setForeground(Color.white);
        enemyPanel.add(enemyLevelLabel);
        
        enemyLevelLabelNumber = new JLabel();
        enemyLevelLabelNumber.setFont(normalFont);
        enemyLevelLabelNumber.setForeground(Color.white);
        enemyPanel.add(enemyLevelLabelNumber);
        
        enemyHPLabel = new JLabel("Enemy HP:");
        enemyHPLabel.setFont(normalFont);
        enemyHPLabel.setForeground(Color.white);
        enemyPanel.add(enemyHPLabel);
        
        enemyHPLabelNumber = new JLabel();
        enemyHPLabelNumber.setFont(normalFont);
        enemyHPLabelNumber.setForeground(Color.white);
        enemyPanel.add(enemyHPLabelNumber);
        
        add(enemyPanel);
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
    
    public JLabel getPlayerJobLable() {
        return playerJobLable;
    }
    
    public JLabel getEnemyHPLabelNumber() {
        return enemyHPLabelNumber;
    }
    
    public JButton getSkill1() {
        return skill1;
    }
    
    public JButton getSkill2() {
        return skill2;
    }
    
    public JButton getSkill3() {
        return skill3;
    }
    
    public JButton getSkill4() {
        return skill4;
    }
    
    public JTextArea getMainTextArea() {
        return mainTextArea;
    }
    
    public void setPlayerStats(Player player) {
        playerNameLabel.setText("Name: " + player.getName());
        playerHPLabel.setText("HP: " + player.getHP());
        playerLevelLabel.setText("LVL: " + player.getLevel());
        playerJobLable.setText("Job: " + player.getJob());
    }
    
    public void setEnemyStats(Enemy enemy) {
        enemyLevelLabel.setText("Enemy lvl:");
        enemyLevelLabelNumber.setText(""+enemy.getLevel());
        enemyHPLabel.setText("Enemy HP:");
        enemyHPLabelNumber.setText(""+enemy.getHP());
    }
    
    public void setSkillSlot(Player player) {
        skill1.setText(player.getSkillSlot().getSkill(0).getName());
        skill2.setText(player.getSkillSlot().getSkill(1).getName());
        skill3.setText(player.getSkillSlot().getSkill(2).getName());
        skill4.setText(player.getSkillSlot().getSkill(3).getName());
    }
}
