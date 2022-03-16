package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DatabaseClasses.DBManager;
import entities.Player;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import skill.Skill;

/**
 *
 * @author ykx5915
 */
public class DBManagerTest {
    
    public DBManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test Database connection close with DBManager
     */
    @Test
    public void testClose() throws Exception {
        DBManager dBManager = new DBManager();
        dBManager.closeConnections();
        assertTrue(dBManager.getConnection().isClosed());
    }
    
    /**
     * Test Database skill table load with DBManager
     */
    @Test
    public void testGetSkillList() throws Exception {
        DBManager dBManager = new DBManager();
        System.out.println("load WarriorSkill");
        String warriorSkills = "WarriorSkill";
        ArrayList<Skill> result = dBManager.getSkillList(warriorSkills);
        assertNotNull(result);
        dBManager.closeConnections();
    }
    
    /**
     * Test Database player load with DBManager
     */
    @Test
    public void testRetrieveSaveList() throws Exception { 
        DBManager dBManager = new DBManager();
        System.out.println("load player: Peter");
        String playerName = "Peter";
        Player player = dBManager.loadPlayer(playerName);
        assertNotNull(player);
        dBManager.closeConnections();
    }
}
