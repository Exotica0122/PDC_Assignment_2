package entities;

public interface Entity {

    public boolean isDead();
    public void displayInfo();
    public void takeDamage(int damage);
    public String getName();
    public String combatInfo();
}
