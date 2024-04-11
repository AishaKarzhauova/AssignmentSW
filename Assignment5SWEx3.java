package Assignment5SW;

import java.util.*;

class Furniture {
    private String name;
    private String style;
    private String material;
    private float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

abstract class FurnitureFactory {
    public abstract Chair createChair();
    public abstract Table createTable();
    public abstract Sofa createSofa();
}

class ModernWoodFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Vintage Wood Chair", "Vintage", "Wood", 150.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Modern Wood Table", "Modern", "Wood", 300.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Vintage Wood Sofa", "Vintage", "Wood", 500.0f);
    }
}

class TraditionalMetalFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Traditional Metal Chair", "Traditional", "Metal", 100.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Abstract Metal Table", "Abstract", "Metal", 250.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Traditional Metal Sofa", "Traditional", "Metal", 450.0f);
    }
}

class IndustrialGlassFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Industrial Glass Chair", "Industrial", "Glass", 120.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Coffee Glass Table", "Coffee", "Glass", 270.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Home Glass Sofa", "Home", "Glass", 480.0f);
    }
}


class Chair extends Furniture {
    public Chair(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Table extends Furniture {
    public Table(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Sofa extends Furniture {
    public Sofa(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Chair createChair() {
        return factory.createChair();
    }

    public Table createTable() {
        return factory.createTable();
    }

    public Sofa createSofa() {
        return factory.createSofa();
    }
}

public class Assignment5SWEx3 {
    public static void main(String[] args) {
        FurnitureCreator creator = new FurnitureCreator();

        creator.setFactory(new ModernWoodFactory());
        Chair modernWoodChair = creator.createChair();
        Table modernWoodTable = creator.createTable();
        Sofa modernWoodSofa = creator.createSofa();

        creator.setFactory(new TraditionalMetalFactory());
        Chair traditionalMetalChair = creator.createChair();
        Table traditionalMetalTable = creator.createTable();
        Sofa traditionalMetalSofa = creator.createSofa();

        creator.setFactory(new IndustrialGlassFactory());
        Chair industrialGlassChair = creator.createChair();
        Table industrialGlassTable = creator.createTable();
        Sofa industrialGlassSofa = creator.createSofa();

        displayFurnitureDetails(modernWoodChair);
        displayFurnitureDetails(modernWoodTable);
        displayFurnitureDetails(modernWoodSofa);

        displayFurnitureDetails(traditionalMetalChair);
        displayFurnitureDetails(traditionalMetalTable);
        displayFurnitureDetails(traditionalMetalSofa);

        displayFurnitureDetails(industrialGlassChair);
        displayFurnitureDetails(industrialGlassTable);
        displayFurnitureDetails(industrialGlassSofa);
    }

    public static void displayFurnitureDetails(Furniture furniture) {
        System.out.println("Furniture Name: " + furniture.getName());
        System.out.println("Style: " + furniture.getStyle());
        System.out.println("Material: " + furniture.getMaterial());
        System.out.println("Price: $" + furniture.getPrice());
        System.out.println();
    }
}
