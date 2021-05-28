package javaIntro_5_Basics_of_OOP;

import java.util.Random;

public class Treasure {
	
	private String name;
	public Material material;
	private Type type;
	private int cost;
	
	public Treasure(String name, Material material, Type type, int cost) {
		this.name = name;
		this.material = material;
		this.type = type;
		this.cost = cost;
	}
	
	public Treasure(String name) {
		this.name = name;
		material = randomEnum(Material.class);
		this.type = randomEnum(Type.class);
		Random random = new Random();
		this.cost = random.nextInt(100);
	}
	
	public String getName() {
		return name;
	}
	public Material getMaterial() {
		return material;
	}
	public Type getType() {
		return type;
	}
	public int getCost() {
		return cost;
	}
	
	public String toString() {
		return String.format("%s;\tType: %s;\tMaterial: %s;\tCost: %d.",
				name, type, material, cost);
	}
	
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
    	Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    
    public enum Material {
    	
    	SILVER,
    	GOLD,
    	PLATINUM,
    	DIAMOND,
    	SAPPFIRE,
    	RUBY,
    	EMERALD	
    }
    
    public enum Type {
    	
    	RING,
    	NECKLACE,
    	EARRINGS,
    	CROWN,
    	SCEPETER,
    	CUP
    }
}
