package javaIntro_5_Basics_of_OOP;

public class Practice05_Main_GiftPackage {

	public static void main(String[] args) {
		
		Gift gift1 = new Gift();
		Package box1 = new SweetsPackage(SweetsPackage.Type.BASKET);
		gift1.setPackage(box1);
		
		gift1.addItem(new Sweetness(Sweetness.Name.CANDY, 15));
		gift1.addItem(new Sweetness(Sweetness.Name.CAKE, 2));
		gift1.addItem(new Sweetness(Sweetness.Name.LOLLIPOP, 10));
		gift1.addItem(new Sweetness(Sweetness.Name.CHOCOLATE, 5));
		
		gift1.output();

	}

}
