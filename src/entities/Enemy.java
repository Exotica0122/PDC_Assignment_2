package entities;

import java.util.HashMap;
import skill.AllSkills;
import skill.Skill;
import skill.SkillSlot;

public class Enemy extends AbstractEntity {

    public Enemy(int level) {
        this.level = level;
        this.name = "Enemy";

        this.currentHP = (level+1) * 20;
        this.maxHP = (level+1) * 20;

//      Setting randoms skills
        this.setRandomSkills();
    }
    
    public Enemy(HashMap enemyData) {
        this.level = (int) enemyData.get("level");
        this.name = "Enemy";
        
        this.currentHP = ((int) enemyData.get("level") + 1) * 20;
        this.maxHP = ((int) enemyData.get("level") + 1) * 20;
        
        this.setRandomSkills();
    }

    @Override
    public boolean isDead() {return this.currentHP <= 0; }

    public Skill attack(Entity entity) {
        int randomSkill = (int) (Math.random() * this.skillSlot.size());
//        System.out.println("Enemy used " + this.skillSlot.getSkill(randomSkill).getName());
        entity.takeDamage(this.skillSlot.getSkill(randomSkill).getDamage());
        return this.skillSlot.getSkill(randomSkill);
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

    @Override
    public String getName() { return this.name; }

    @Override
    public String combatInfo() { return this.name + ". HP: " + this.currentHP; }

    private void setRandomSkills() {
        AllSkills allSkills = new AllSkills();
        Skill skill1 = allSkills.getRandomSkill();
        Skill skill2 = allSkills.getRandomSkill();
        Skill skill3 = allSkills.getRandomSkill();
        Skill skill4 = allSkills.getRandomSkill();
        this.skillSlot = new SkillSlot();
        skillSlot.addSkill(skill1);
        skillSlot.addSkill(skill2);
        skillSlot.addSkill(skill3);
        skillSlot.addSkill(skill4);
    }
    
    public int getHP() { return this.currentHP; }
    
    public int getLevel() { return this.level; }
    
    public SkillSlot getSkillSlot() {
        return this.skillSlot;
    }

}
