package skill;

public abstract class AbstractSkill implements SkillInterface {

    int id;
    String name;
    String description;
    int damage;
    String jobRequirement;
    int levelRequirement;  // newly added fix all changes
    int maxUsage;

}
