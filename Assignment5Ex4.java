package Assignment5SW;


class Character {
    private String name;
    private String characterClass;
    private Weapon weapon;
    private int health;
    private int mana;

    public Character(String name, String characterClass, Weapon weapon, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}


class Weapon {
    private String type;
    private int damage;
    private int speed;
    private int range;

    public Weapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}


abstract class CharacterFactory {
    public abstract Character createCharacter();
    public abstract Weapon createWeapon();
}

class WarriorSwordFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Warrior", "Warrior", createWeapon(), 100, 50);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Sword", 20, 5, 10);
    }
}

class MageStaffFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Mage", "Mage", createWeapon(), 80, 100);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Staff", 15, 7, 15);
    }
}

class ArcherBowFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Character("Archer", "Archer", createWeapon(), 90, 80);
    }

    @Override
    public Weapon createWeapon() {
        return new Weapon("Bow", 18, 6, 20);
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter() {
        return factory.createCharacter();
    }

    public Weapon createWeapon() {
        return factory.createWeapon();
    }
}

public class Assignment5Ex4 {

    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorSwordFactory());
        Character warrior = creator.createCharacter();
        Weapon warriorWeapon = creator.createWeapon();

        creator.setFactory(new MageStaffFactory());
        Character mage = creator.createCharacter();
        Weapon mageWeapon = creator.createWeapon();

        creator.setFactory(new ArcherBowFactory());
        Character archer = creator.createCharacter();
        Weapon archerWeapon = creator.createWeapon();

        displayCharacterDetails(warrior);
        displayWeaponDetails(warriorWeapon);

        displayCharacterDetails(mage);
        displayWeaponDetails(mageWeapon);

        displayCharacterDetails(archer);
        displayWeaponDetails(archerWeapon);
    }

    public static void displayCharacterDetails(Character character) {
        System.out.println("Character Name: " + character.getName());
        System.out.println("Character Class: " + character.getCharacterClass());
        System.out.println("Health: " + character.getHealth());
        System.out.println("Mana: " + character.getMana());
        System.out.println();
    }

    public static void displayWeaponDetails(Weapon weapon) {
        System.out.println("Weapon Type: " + weapon.getType());
        System.out.println("Damage: " + weapon.getDamage());
        System.out.println("Speed: " + weapon.getSpeed());
        System.out.println("Range: " + weapon.getRange());
        System.out.println();
    }
}
