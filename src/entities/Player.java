package entities;

import java.util.HashMap;
import skill.SkillSlot;

import java.util.Scanner;
import skill.Skill;

public class Player extends AbstractEntity {

    private String job;
    
//  Initialize new player
    public Player(String name, String job) {
        this.level = 1;
        this.name = name;
        this.skillSlot = new SkillSlot();
        this.currentHP = 150;
        this.maxHP = 150;
        this.job = job;

        this.skillSlot.addSkill(new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20));
        this.skillSlot.addSkill(new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20));
        this.skillSlot.addSkill(new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20));
        this.skillSlot.addSkill(new Skill(0, "Pinch","Weak pinch attack", 10, 0, 20));
    }
    
    public Player(HashMap playerData) {
        this.name = (String) playerData.get("name");
        this.job = (String) playerData.get("job");
        this.level = (int) playerData.get("level");
        this.skillSlot = (SkillSlot) playerData.get("skillslot");
        this.maxHP = ((int) playerData.get("level") * 50) + 100;
        this.currentHP = ((int) playerData.get("level") * 50) + 100;
    }

//  Reload player using saved data
    public Player(String name, int level, SkillSlot skillSlot) {
        this.name = name;
        this.level = level;
        this.maxHP = (level * 50) + 100;
        this.currentHP = (level * 50) + 100;
        this.skillSlot = skillSlot;
    }


//  check if player is dead
    @Override
    public boolean isDead() {
        return this.currentHP <= 0;
    }
    
    public boolean attackAvaliable(int skill) {
        if(!skillSlot.getSkill(skill).getName().isEmpty()) return true;
        return false;
    }

    public void attack(Entity entity, int skill) {
        entity.takeDamage(skillSlot.getSkill(skill).getDamage());
    }

    @Override
    public void displayInfo() {
        System.out.println("| Name: "+this.name+" | Level: "+this.level+" | HP: "+this.currentHP
            +this.maxHP);
    }

    @Override
    public void takeDamage(int damage) {
        this.currentHP -= damage;
        if(this.currentHP < 0) this.currentHP = 0;
    }

    public void heal() {
        this.currentHP = this.maxHP;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String combatInfo() {
        return this.name + ". HP: " + this.currentHP;
    }

    public void levelUp() {
        if(this.level >= 100) return;
        this.level++;
        this.maxHP += 50;
    }

    public int getLevel() { return this.level; }

    public String saveSkillset() { return this.skillSlot.save(); }
    
    public int getHP() { return this.currentHP; }
    
    public String getJob() { return this.job; }
    
    public SkillSlot getSkillSlot() {
        return this.skillSlot;
    }
      
}
