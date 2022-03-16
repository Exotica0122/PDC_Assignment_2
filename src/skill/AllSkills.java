package skill;

import java.util.ArrayList;

public class AllSkills {
    public ArrayList<Skill> allSkills = new ArrayList<Skill>();

    public AllSkills() {
        allSkills.add(new Skill(1, "Whip", "Whips the enemy", 10, 0, 0));
        allSkills.add(new Skill(2, "Punch", "Punches with great force", 20, 0, 0));
        allSkills.add(new Skill(3, "Side-Kick", "Attacks with a tight side kick", 30, 0, 0));
        allSkills.add(new Skill(4, "Uppercut-Punch", "Punches the enemy on the chin with a fearful uppercut", 40, 0, 0));
        allSkills.add(new Skill(5, "Headbutt", "Headbutts the enemy with unexpected", 35, 0, 0));
        allSkills.add(new Skill(6, "Roll", "Player rolls the enemy", 22, 0, 0));
        allSkills.add(new Skill(7, "Rock-throw", "Throws a rock", 11, 0, 0));
        allSkills.add(new Skill(8, "Tickle", "Tickles the enemy dealing little damage", 5, 0, 0));
        allSkills.add(new Skill(9, "Wink", "Winking mental damages the enemy", 7, 0, 0));
        allSkills.add(new Skill(10, "Scream", "damages enemies ears", 3, 0, 0));
        allSkills.add(new Skill(11, "Stick-attack", "Attacks with a stick", 15, 0, 0));
        allSkills.add(new Skill(12, "Shock", "Shocks enemy with a taser", 55, 0, 0));
        allSkills.add(new Skill(13, "Jab", "Jab enemy", 26, 0, 0));
        allSkills.add(new Skill(14, "Scratch", "Scratches enemy with long nails", 33, 0, 0));
        allSkills.add(new Skill(15, "Pound", "Pound enemy with players weight", 25, 0, 0));
        allSkills.add(new Skill(16, "Pinch", "A painful short pinch", 14, 0, 0));
        allSkills.add(new Skill(17, "Bite", "Becomes a god and bite", 12, 0, 0));
    }

    public Skill getRandomSkill() {
        return allSkills.get((int) (Math.random() * allSkills.size()));
    }

    public Skill getSkill(String name) {
        Skill returnSkill = null;
        for(Skill skill : allSkills) {
            if(name.equals(skill.getName())) {
                returnSkill = skill;
            }
        }
        return returnSkill;
    }
}
