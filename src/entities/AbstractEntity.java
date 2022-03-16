package entities;


import java.io.Serializable;
import skill.SkillSlot;


public abstract class AbstractEntity implements Entity, Serializable {

    String name;
    
    int currentHP;
    int maxHP;
    int level;
    SkillSlot skillSlot;

}
