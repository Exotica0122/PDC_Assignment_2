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
import javax.swing.JTextField;

/**
 *
 * @author ykx5915
 */
public class LoginPanel extends JPanel{
    private JPanel loginPanel, titleNamePanel;
    private JLabel loginLabel, titleNameLabel;
    private JButton loginButton, warriorButton, archerButton;
    private JTextField loginField;
    
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    
    private ArrayList<JButton> buttonList;
    
    public LoginPanel() {
        
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
//        loginButton.addActionListener(selectJobHandler);

        warriorButton = new JButton("Warrior");
        warriorButton.setBounds(250, 450, 150, 50);
        warriorButton.setBackground(Color.black);
        warriorButton.setForeground(Color.white);
        warriorButton.setFont(normalFont);
        warriorButton.setVisible(false);
        warriorButton.setFocusPainted(false);
//        warriorButton.addActionListener(selectJobHandler);
        
        archerButton = new JButton("Archer");
        archerButton.setBounds(400, 450, 150, 50);
        archerButton.setBackground(Color.black);
        archerButton.setForeground(Color.white);
        archerButton.setFont(normalFont);
        archerButton.setVisible(false);
        archerButton.setFocusPainted(false);
//        archerButton.addActionListener(selectJobHandler);
        

        buttonList.add(loginButton);
        buttonList.add(warriorButton);
        buttonList.add(archerButton);
        
        add(titleNamePanel);
        add(loginButton);
        add(loginPanel);
        add(warriorButton);
        add(archerButton);
    }
    
    public void showSelectJob() {
        loginButton.setVisible(false);
        warriorButton.setVisible(true);
        archerButton.setVisible(true);
    }
    
    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JTextField getLoginField() {
        return loginField;
    }
    
    public JButton getWarriorButton() {
        return warriorButton;
    }
    
    public JButton getArcherButton() {
        return archerButton;
    }
           
}
