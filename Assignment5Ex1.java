package Assignment5SW;

import java.util.*;

class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Attribute attributes;

    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Attribute attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}

class Appearance {
    private String appearanceName;

    public Appearance(String appearanceName) {
        this.appearanceName = appearanceName;
    }

    public String getAppearanceName() {
        return appearanceName;
    }

    public void setAppearanceName(String appearanceName) {
        this.appearanceName = appearanceName;
    }
}

class Ability {
    private String abilityName;

    public Ability(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }
}

class Equipment {
    private String equipmentName;

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}

class Attribute {
    private int strength;
    private int intelligence;
    private int agility;

    public Attribute(int strength, int intelligence, int agility) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {

        Appearance appearance = new Appearance("Warrior appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Super sword strike"));
        abilities.add(new Ability("Shield"));
        abilities.add(new Ability("Active attack"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Sword"));
        equipment.add(new Equipment("Shield"));
        Attribute attributes = new Attribute(10, 6, 9);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {

        Appearance appearance = new Appearance("Mage appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Fireball"));
        abilities.add(new Ability("Teleport"));
        abilities.add(new Ability("Curse"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Magic ball"));
        equipment.add(new Equipment("Robe"));
        Attribute attributes = new Attribute(2, 10, 5);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {

        Appearance appearance = new Appearance("Archer appearance");
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new Ability("Arrow shot"));
        abilities.add(new Ability("Super arrow cascade"));
        abilities.add(new Ability("Invisible"));
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment("Bow"));
        equipment.add(new Equipment("Arrows"));
        Attribute attributes = new Attribute(7, 10, 8);
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        return factory.createCharacter(name);
    }
}


public class Assignment5Ex1 {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorFactory());
        Character warrior = creator.createCharacter("Warrior1");

        creator.setFactory(new MageFactory());
        Character mage = creator.createCharacter("Mage1");

        creator.setFactory(new ArcherFactory());
        Character archer = creator.createCharacter("Archer1");

        displayCharacter(warrior);
        displayCharacter(mage);
        displayCharacter(archer);
    }

    public static void displayCharacter(Character character) {
        System.out.println("Character Name: " + character.getName());
        System.out.println("Appearance: " + character.getAppearance().getAppearanceName());
        System.out.println("Abilities:");
        for (Ability ability : character.getAbilities()) {
            System.out.println("- " + ability.getAbilityName());
        }
        System.out.println("Equipment:");
        for (Equipment equipment : character.getEquipment()) {
            System.out.println("- " + equipment.getEquipmentName());
        }
        System.out.println("Attributes:");
        System.out.println("- Strength: " + character.getAttributes().getStrength());
        System.out.println("- Intelligence: " + character.getAttributes().getIntelligence());
        System.out.println("- Agility: " + character.getAttributes().getAgility());
        System.out.println();
    }
}
