package skill;

import java.util.Scanner;

// Change to primitive array

public class SkillSlot {
    private Skill[] skillSlot;
    private int maxSkillLength = 4;

    public SkillSlot() {
        this.skillSlot = new Skill[4];
    }

    public SkillSlot(Skill skill1, Skill skill2, Skill skill3, Skill skill4) {
        this.skillSlot = new Skill[4];
        this.skillSlot[0] = (skill1);
        this.skillSlot[1] = (skill2);
        this.skillSlot[2] = (skill3);
        this.skillSlot[3] = (skill4);
        
    }
    
//    
    public boolean addSkill(Skill newSkill) {
        if(!isFull()) {
            for(int i = 0; i < maxSkillLength; i++) {
                if(skillSlot[i] == null) { 
                    skillSlot[i] = newSkill;
                    return true;
                }
            }
        }
        return false;
    }
    
    public Skill getSkill(Skill skill) {
        for(int i = 0; i < maxSkillLength; i++) {
            if(skillSlot[i] == skill) return skillSlot[i];
        }
        return null;
    }
    
    public void replaceSkill(Skill skill, int index) {
        skillSlot[index] = skill;
    }

    public void learnSkill() {
        AllSkills allSkills = new AllSkills();
        Skill skill = allSkills.getRandomSkill();
        Scanner scan = new Scanner(System.in);

//        while(skillSlot.contains(skill)) skill = allSkills.getRandomSkill();

//      learning new skill when skill slot has space
        if (!this.isFull()) {
            addSkill(skill);
            System.out.println("You learnt the skill: " + skill.toString());
            return;
        }


//      replace skill with existing skill when skill slot is full
        System.out.println("You want to learn this Skill:");
        System.out.println(skill.toString());
        System.out.println("Which skill do u want to replace?");
        System.out.println(this.toString());
        System.out.println("Type: 1, 2, 3, 4, 0 (0 for forgetting");

//      if skill want to be forgotten
        int removedSkill = scan.nextInt();
        if (removedSkill == 0) {
            System.out.println("You forgot the skill");
            System.out.println(skill.toString());
            return;
        }

//      replacing a skill
        System.out.println("You unlearnt: " + getSkill(removedSkill));
        replaceSkill(skill, removedSkill-1);
        System.out.println("and learned: " + skill.toString());
    }

    public boolean isFull() { 
        for(int i=0; i < maxSkillLength; i++) { 
            if(skillSlot[i] == null) return false;
        }
        return true;
    }

    public String toString() {
        String skillString = "";
        for(Skill skill : this.skillSlot) skillString += (skill.displaySkill() + "\n");
        return skillString;
    }

    public Skill getSkill(int index) {
        return this.skillSlot[index];
    }

    public int size() { return this.skillSlot.length; }

    public void combatPrint() {
        for(int i=0; i<this.size(); i++) {
            System.out.print(i+1 + ". " + this.skillSlot[i] + "\n");
        }
        System.out.println();
    }

    public String save() {
        String string = "";
        for(Skill skill : skillSlot) {
            string += skill.getName() + " ";
        }
        return string;
    }
}
