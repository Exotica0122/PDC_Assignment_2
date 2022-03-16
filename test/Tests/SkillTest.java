package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import skill.Skill;
import skill.SkillSlot;

/**
 *
 * @author ykx5915
 */
public class SkillTest {
    
    public SkillTest() {
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

    public void testSkill() {
        System.out.println("Create skill pinch");
        Skill result = new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20);
        assertEquals("Pinch", result.getName());
    }
    
    public void testSkillSlot() {
        System.out.println("Create skill pinch then add to skillslot");
        Skill skill = new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20);
        SkillSlot result = new SkillSlot();
        result.addSkill(skill);
        assertEquals("Pinch", result.getSkill(0).getName());
    }
}
