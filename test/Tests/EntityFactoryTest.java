/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import entities.Enemy;
import entities.EntityFactory;
import entities.Player;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import skill.SkillSlot;

/**
 *
 * @author ykx5915
 */
public class EntityFactoryTest {
    
    public EntityFactoryTest() {
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
    
    public void testCreatePlayer() throws Exception {
        System.out.println("create peter");
        HashMap playerdata = new HashMap();
        playerdata.put("name", "Peter");
        playerdata.put("job", "Warrior");
        playerdata.put("level", 2);
        SkillSlot skillslot = new SkillSlot();
        playerdata.put("skillslot", skillslot);
        Player player = (Player) EntityFactory.createOldEntity("player", playerdata);
        assertEquals("Peter", player.getName());
    }
    
    public void testCreateEnemy() throws Exception {
        System.out.println("create enemy");
        HashMap enemydata = new HashMap();
        enemydata.put("level", 10);
        Enemy enemy = (Enemy) EntityFactory.createOldEntity("enemy", enemydata);
        assertEquals(10, enemy.getLevel());
    }
    
    public void testCreateFail() throws Exception {
        try {
            HashMap playerdata = new HashMap();
            playerdata.put("name", "Peter");
            playerdata.put("job", "Warrior");
            playerdata.put("level", 2);
            SkillSlot skillslot = new SkillSlot();
            playerdata.put("skillslot", skillslot);
            Player player = (Player) EntityFactory.createOldEntity("cat", playerdata);
        }
        catch (final Exception e) {
            final String msg = "Invalid entity type.";
            assertEquals(msg, e.getMessage());
        }
    }
}
