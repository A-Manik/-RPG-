public abstract class FantasyCharacter implements Hunter{

    private String name;
    private int healthPoints;
    private int strength;
    private int agility;
    private int xp;
    private int gold;

    public FantasyCharacter(String name, int healthPoints, int strength, int agility, int xp, int gold) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.agility = agility;
        this.xp = xp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, healthPoints);

    }

    private int getRandomValue (){
        return (int) (Math.random() * 100);
    }

    @Override
    public int attack() {
        if (agility * 3 > getRandomValue()) return strength;
        else return 0;
    }
}