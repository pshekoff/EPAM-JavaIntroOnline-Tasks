package javaIntro_5_Basics_of_OOP;

public class Practice05_Main_FlowerComposition {

	public static void main(String[] args) {
		
		Gift gift1 = new Gift();
		Package box1 = new FlowerPackage(FlowerPackage.Type.TAPE);
		gift1.setPackage(box1);
		
		gift1.addItem(new Flower(Flower.Name.ASTER, 5));
		gift1.addItem(new Flower(Flower.Name.CHRYSANTHEMUMS, 4));
		gift1.addItem(new Flower(Flower.Name.TULIP, 3));
		
		gift1.output();
		
	}

}
