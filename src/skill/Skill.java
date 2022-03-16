package skill;


public class Skill extends AbstractSkill {
    
    private int remainingUsage;

    public Skill(int id, String name, String description, int damage, int levelrequirement, int maxUsage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.levelRequirement = levelrequirement;
        this.maxUsage = maxUsage;
        this.remainingUsage = maxUsage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
    
    public int getLevelRequirement() {
        return this.levelRequirement;
    }

//  For fill description
    @Override
    public String toString() {
        return "Skill Name: "+this.name+".\nDescription: "+this.description+
                ".\nDamage: "+this.damage;
    }

//  basic description
    public String displaySkill() {
        return "Skill Name: "+this.name+"./nDamage: "+this.damage+"\nDescription: "+this.description;
    }
    
    public void useSkill() {
        this.remainingUsage--;
    }
    
    public void resetUsage() {
        this.remainingUsage = maxUsage;
    }
    
    public String saveSkill() {
        return id + "_" + name + "_" 
                + description + "_" + damage + "_" + levelRequirement + "_" + maxUsage;
    }
}
