/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DatabaseClasses.DBManager;
import GUI.GUI_DONT_USE_THIS.LoginHandler;
import entities.Enemy;
import entities.Player;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import models.GameModel;
import skill.Skill;

/**
 *
 * @author ykx5915
 */
public class GUI_DONT_USE_THIS {
    
    private DBManager dBManager;
    private Player player;
    private GameModel gameModel;
    
    private JFrame window;
    private Container con;
    private JPanel titleNamePanel, startBottomPanel, mainTextPanel, skillSelectPanel, playerStatsPanel, playerPanel, enemyPanel, loginPanel, mainMenuPanel;
    private JLabel titleNameLabel, enemyHPLabel, enemyHPLabelNumber, enemyLevelLabel, enemyLevelLabelNumber, loginLabel, chooseJobLabel, playerNameLabel, playerHPLabel, playerLevelLabel, playerJobLable;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private JButton startButton, rulesButton, skill1, skill2, skill3, skill4, loginButton, warriorButton, archerButton, enterBattleButton, saveButton;
    private JTextArea mainTextArea;
    private JTextField loginField;
    
    private TitleScreenHandler tsHandler = new TitleScreenHandler();
    private ChoiceHandler choiceHandler = new ChoiceHandler();
    private LoginHandler loginHandler = new LoginHandler();
    private SelectJobHandler selectjobHandler = new SelectJobHandler();
    private SaveAndExit saveAndExit = new SaveAndExit();
    private GameScreenHandler gameScreenHandler = new GameScreenHandler();
    
    private int playerHP, enemyHP, enemyLevel;
    private String choiceMenu, playerJob;
    private ArrayList<Skill> skillList;
    private Skill learnableSkill;
    
    
    public GUI_DONT_USE_THIS() {
        
        dBManager = new DBManager();
        
        window = new JFrame("Tribute");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 50, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("TRIBUTE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startBottomPanel = new JPanel();
        startBottomPanel.setBounds(250, 400, 300, 150);
        startBottomPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        
        rulesButton = new JButton("HOW TO PLAY");
        rulesButton.setBackground(Color.black);
        rulesButton.setForeground(Color.white);
        rulesButton.setFont(normalFont);
        rulesButton.setFocusPainted(false);
        
//      Upper side title screen  
        titleNamePanel.add(titleNameLabel);
        
//      Lower side title screen  
        startBottomPanel.add(startButton);
        startBottomPanel.add(rulesButton);
        
        
        con.add(titleNamePanel);
        con.add(startBottomPanel);
    }
    
    public static void main(String args[]){
        new GUI_DONT_USE_THIS();
    }
    
    public void createGameScreen() {
        
        gameModel = new GameModel(player);
        
        titleNamePanel.setVisible(false);
        mainMenuPanel.setVisible(false);
//        startBottomPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
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
        con.add(skillSelectPanel);
        
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(450, 350, 350, 150);
        playerStatsPanel.setBackground(Color.black);
        playerStatsPanel.setLayout(new GridLayout(2,2));
        con.add(playerStatsPanel);
        
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
        
        skill1 = new JButton(player.getSkillSlot().getSkill(0).getName());
        skill1.setBackground(Color.black);
        skill1.setForeground(Color.white);
        skill1.setFont(normalFont);
        skillSelectPanel.add(skill1);
        skill1.setFocusPainted(false);
        skill1.addActionListener(choiceHandler);
        skill1.setActionCommand("s1");
        
        skill2 = new JButton(player.getSkillSlot().getSkill(1).getName());
        skill2.setBackground(Color.black);
        skill2.setForeground(Color.white);
        skill2.setFont(normalFont);
        skillSelectPanel.add(skill2);
        skill2.setFocusPainted(false);
        skill2.addActionListener(choiceHandler);
        skill2.setActionCommand("s2");
        
        skill3 = new JButton(player.getSkillSlot().getSkill(2).getName());
        skill3.setBackground(Color.black);
        skill3.setForeground(Color.white);
        skill3.setFont(normalFont);
        skillSelectPanel.add(skill3);
        skill3.setFocusPainted(false);
        skill3.addActionListener(choiceHandler);
        skill3.setActionCommand("s3");
        
        skill4 = new JButton(player.getSkillSlot().getSkill(3).getName());
        skill4.setBackground(Color.black);
        skill4.setForeground(Color.white);
        skill4.setFont(normalFont);
        skillSelectPanel.add(skill4);
        skill4.setFocusPainted(false);
        skill4.addActionListener(choiceHandler);
        skill4.setActionCommand("s4");
        
//      Top portion  
        enemyPanel = new JPanel();
        enemyPanel.setBounds(100, 40, 600, 50);
        enemyPanel.setBackground(Color.black);
        enemyPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        enemyPanel.setLayout(new GridLayout(1, 4));
        con.add(enemyPanel);
        
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
        
        
        setEnemyStats();
        setPlayerStats();
        System.out.println(player.getHP());
        
        setBattleMenu();
        
    }
    
    public void createLoginScreen() {
        
//        titleNamePanel.setVisible(false);
        startBottomPanel.setVisible(false);
        
        
        loginPanel = new JPanel();
        loginPanel.setBounds(250, 300, 300, 50);
        loginPanel.setBackground(Color.black);
        loginPanel.setLayout(new GridLayout(2,1));
        loginLabel = new JLabel("Enter Name:");
        loginLabel.setFont(normalFont);
        loginLabel.setForeground(Color.white);
        loginField = new JTextField();
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(325, 450, 150, 50);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.setFont(normalFont);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(loginHandler);
        
        warriorButton = new JButton("Warrior");
        warriorButton.setBounds(250, 450, 150, 50);
        warriorButton.setBackground(Color.black);
        warriorButton.setForeground(Color.white);
        warriorButton.setFont(normalFont);
        warriorButton.setVisible(false);
        warriorButton.setFocusPainted(false);
        warriorButton.addActionListener(selectjobHandler);
        
        archerButton = new JButton("Archer");
        archerButton.setBounds(400, 450, 150, 50);
        archerButton.setBackground(Color.black);
        archerButton.setForeground(Color.white);
        archerButton.setFont(normalFont);
        archerButton.setVisible(false);
        archerButton.setFocusPainted(false);
        archerButton.addActionListener(selectjobHandler);
        
        con.add(loginButton);
        con.add(loginPanel);
        con.add(warriorButton);
        con.add(archerButton);
    }
    
    public void mainMenuScreen() {
        
        skillList = dBManager.getSkillList(player.getJob()+"Skill");
        
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(150, 200, 500, 300);
        mainMenuPanel.setBackground(Color.black);
        mainMenuPanel.setLayout(new GridLayout(3,2));
        
        playerNameLabel = new JLabel("Name: " + player.getName());
        playerNameLabel.setFont(normalFont);
        playerNameLabel.setForeground(Color.white);
        mainMenuPanel.add(playerNameLabel);
        
        playerHPLabel = new JLabel("HP: " + player.getHP());
        playerHPLabel.setFont(normalFont);
        playerHPLabel.setForeground(Color.white);
        mainMenuPanel.add(playerHPLabel);
        
        playerLevelLabel = new JLabel("LVL: " + player.getLevel());
        playerLevelLabel.setFont(normalFont);
        playerLevelLabel.setForeground(Color.white);
        mainMenuPanel.add(playerLevelLabel);
        
        playerJobLable = new JLabel("Job: " + player.getJob());
        playerJobLable.setFont(normalFont);
        playerJobLable.setForeground(Color.white);
        mainMenuPanel.add(playerJobLable);
        
        enterBattleButton = new JButton("Battle");
        enterBattleButton.setBackground(Color.black);
        enterBattleButton.setForeground(Color.white);
        enterBattleButton.setFont(normalFont);
        enterBattleButton.addActionListener(gameScreenHandler);
        enterBattleButton.setFocusPainted(false);
        mainMenuPanel.add(enterBattleButton);
        
        saveButton = new JButton("Save & Exit");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);
        saveButton.addActionListener(saveAndExit);
        saveButton.setFocusPainted(false);
        mainMenuPanel.add(saveButton);
        
        con.add(mainMenuPanel);
    }
    
    public void battleToMainMenu() {
        enemyPanel.setVisible(false);
    }
    
    public void playerSetup(Player player) {
        playerHP = player.getHP();
        playerJob = player.getJob();
    }
    
    public void enemySetup() {
        enemyHP = gameModel.getEnemy().getHP();
        enemyLevel = gameModel.getEnemy().getLevel();
        enemyHPLabelNumber.setText(Integer.toString(enemyHP));
        enemyLevelLabelNumber.setText(Integer.toString(enemyLevel));
    }
    
    public void setBattleMenu() {
        choiceMenu = "battle";
    }
    
    public void setLearnSkillMenu() {
        choiceMenu = "learn";
    }
    
    public void setPlayerStats() {
        playerNameLabel.setText("Name: " + player.getName());
        playerHPLabel.setText("HP: " + player.getHP());
        playerLevelLabel.setText("LVL: " + player.getLevel());
        playerJobLable.setText("Job: " + player.getJob());
    }
    
    public void setEnemyStats() {
        enemyHPLabelNumber.setText(""+gameModel.getEnemy().getHP());
    }
    
    public boolean checkPlayerCanLearnNewSkill(Player player) {
        for(int i=0; i<skillList.size() ;i++) {
            if(skillList.get(i).getLevelRequirement() == player.getLevel()) {
                learnableSkill = (skillList.get(i));
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            createLoginScreen();
            

        }
    
    }
    
    public class GameScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
        
    } 
    
    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            String skillChoice = event.getActionCommand();
            
            switch(choiceMenu) { 
                case "battle":
                    mainTextArea.setText("");
                    switch(skillChoice) {
                        case "s1":
                            System.out.println("Used skill 1");
                            mainTextArea.append("\nPlayer used: " + player.getSkillSlot().getSkill(0).getName());
                            gameModel.getEnemy().takeDamage(player.getSkillSlot().getSkill(0).getDamage());
                            break;
                        case "s2":
                            System.out.println("Used skill 2");
                            mainTextArea.append("\nPlayer used: " + player.getSkillSlot().getSkill(1).getName());
                            gameModel.getEnemy().takeDamage(player.getSkillSlot().getSkill(1).getDamage());
                            break;
                        case "s3":
                            System.out.println("Used skill 3");
                            mainTextArea.append("\nPlayer used: " + player.getSkillSlot().getSkill(2).getName());
                            gameModel.getEnemy().takeDamage(player.getSkillSlot().getSkill(2).getDamage());
                            break;
                        case "s4":
                            System.out.println("Used skill 4");
                            mainTextArea.append("\nPlayer used: " + player.getSkillSlot().getSkill(3).getName());
                            gameModel.getEnemy().takeDamage(player.getSkillSlot().getSkill(3).getDamage());
                            break;
                        default:
                            break;
                    }
                    setEnemyStats();
                    if(gameModel.getEnemy().isDead()) {
                        mainTextArea.setText("You slayed the Enemy");
                        mainTextArea.append("\nLeveled up");
                        player.levelUp();
                        setPlayerStats();
                        
                        if(checkPlayerCanLearnNewSkill(player)) {
                            mainTextArea.append("\nPlayer can learn: " + learnableSkill.getName() +
                                    "\nDamage: " + learnableSkill.getDamage() +
                                    "\nDescription: " + learnableSkill.getDescription() +
                                    "\nSelect from existing skill to learn new skill");
                            choiceMenu = "learn";
                        }
                        else mainMenuScreen();
                    } else {
                    Skill enemySkill = gameModel.getEnemy().attack(player);
                    mainTextArea.append("\nEnemy used: " + enemySkill.getName());
                    player.takeDamage(enemySkill.getDamage());
                    setPlayerStats();
                    }
                    break;
                case "learn":
                    if(learnableSkill == null) return;
                    switch(skillChoice) {
                        case "s1":
                            player.getSkillSlot().replaceSkill(learnableSkill, 0);
                            break;
                        case "s2":
                            player.getSkillSlot().replaceSkill(learnableSkill, 1);
                            break;
                        case "s3":
                            player.getSkillSlot().replaceSkill(learnableSkill, 2);
                            break;
                        case "s4":
                            player.getSkillSlot().replaceSkill(learnableSkill, 3);
                            break;
                        default:
                            break;
                    }
                    choiceMenu = "battle";
                    learnableSkill = null;
                    mainMenuScreen();
                    break;
                 default:
                     break;
            }
            
        }
        
    }
    
    public class LoginHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            String name = loginField.getText().trim();
            if(name.isEmpty()) return;
            
            if(dBManager.playerExists(name)) {
                player = dBManager.loadPlayer(name);
                loginPanel.setVisible(false);
                loginButton.setVisible(false);
                mainMenuScreen();
            } else {
                loginButton.setVisible(false);
                loginField.setEditable(false);
                
                warriorButton.setVisible(true);
                archerButton.setVisible(true);
            }
        }
    }
    
    public class BattleScreenHandler implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
        
    }
    
    public class SelectJobHandler implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent event) {
            String name = loginField.getText().trim();
            Object source = event.getSource();
            
            if(source == warriorButton) player = new Player(name, "Warrior");
            if(source == archerButton) player = new Player(name, "Archer");
            
            loginPanel.setVisible(false);
            loginButton.setVisible(false);
            warriorButton.setVisible(false);
            archerButton.setVisible(false);
            
            mainMenuScreen();
        }
    }
    
    public class SetPlayerStats implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent event) {
            setPlayerStats();
        }
        
    } 
    
    public class SetEnemyStats implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent event) {
            setEnemyStats();
        }
        
    } 
    
    public class SaveAndExit implements ActionListener { 
        
        @Override
        public void actionPerformed(ActionEvent event) {
            dBManager.savePlayer(player);
            System.out.println("Saved");
            System.exit(0);
        }
    }
}

