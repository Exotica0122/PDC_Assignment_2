/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.components.panels.gamePanels;

import GUI.controller.Controller;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author ykx5915
 */
public class testing {
    
    private JFrame window;
    private Container con;
    private TitleScreenPanel titleScreenPanel;
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    private BattlePanel battlePanel;
    
    public testing() {
        window = new JFrame("Tribute");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);
        con = window.getContentPane();
    }
    
    public static void main(String[] args) {
        new testing();
    }
    
}
