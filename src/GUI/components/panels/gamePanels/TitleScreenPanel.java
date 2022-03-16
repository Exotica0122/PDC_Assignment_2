/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.components.panels.gamePanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ykx5915
 */
public class TitleScreenPanel extends JPanel {
    
    private JPanel titleNamePanel, startBottomPanel;
    private JButton startButton, rulesButton;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    
    private ArrayList<JButton> buttonList;
    
    public TitleScreenPanel() {
        
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
        
        startBottomPanel = new JPanel();
        startBottomPanel.setBounds(250, 400, 300, 150);
        startBottomPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
//        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        startBottomPanel.add(startButton);
        
        rulesButton = new JButton("HOW TO PLAY");
        rulesButton.setBackground(Color.black);
        rulesButton.setForeground(Color.white);
        rulesButton.setFont(normalFont);
        rulesButton.setFocusPainted(false);
        startBottomPanel.add(rulesButton);
        
        buttonList.add(startButton);
        buttonList.add(rulesButton);
        
        add(titleNamePanel);
        add(startBottomPanel);
    }
    
    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }
    
    public JButton getStartButton() {
        return startButton;
    }
    
    public JButton getRuleButton() {
        return rulesButton;
    }
}
