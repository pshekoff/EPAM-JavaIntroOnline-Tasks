package javaIntro_5_Basics_of_OOP;

import java.util.Random;

public class Treasure {
	
	private String name;
	public TreasureMaterial material;
	private TreasureType type;
	private int cost;
	
	public Treasure(String name, TreasureMaterial material, TreasureType type, int cost) {
		this.name = name;
		this.material = material;
		this.type = type;
		this.cost = cost;
	}
	
	public Treasure(String name) {
		this.name = name;
		material = randomEnum(TreasureMaterial.class);
		this.type = randomEnum(TreasureType.class);
		Random random = new Random();
		this.cost = random.nextInt(100);
	}
	
	public String getName() {
		return name;
	}
	public TreasureMaterial getMaterial() {
		return material;
	}
	public TreasureType getType() {
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
}
