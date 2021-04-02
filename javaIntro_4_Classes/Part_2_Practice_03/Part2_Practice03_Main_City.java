package javaIntro_4_Classes;

public class Part2_Practice03_Main_City {
	
	public static void main(String[] args) {
		
		State s = new State("Belarus",207600,9400000);
		
		Region minskO = new Region("Minskaja obl.",55000,3500000);
		Region gomelO = new Region("Mogilevskaja obl.",45000,200000);
		Region mogilO = new Region("Mogilevskaja obl.",25000,1500000);
		Region vitsebO = new Region("Vitsebskaja obl.",30000,1000000);
		Region grodnO = new Region("Grodnenskaja obl.",22000,700000);
		Region brestO = new Region("Brestskaja obl.",28000,700000);
		
		s.addRegion(minskO);
		s.addRegion(gomelO);
		s.addRegion(mogilO); 
		s.addRegion(vitsebO);
		s.addRegion(grodnO);
		s.addRegion(brestO);
		
		District minskD = new District("Minskij",5000,2000000);
		District gomelD = new District("Gomelskij",4500,700000);
		District mogilD = new District("Mogilevskij",4000,400000);
		District vitsebD = new District("Vitsebskij",4800,300000);
		District grodnD = new District("Grodnenslij",4200,280000);
		District brestD = new District("Brestskij",4300,275000);
		
		minskO.addDistrict(minskD);
		gomelO.addDistrict(gomelD);
		mogilO.addDistrict(mogilD);
		vitsebO.addDistrict(vitsebD);
		grodnO.addDistrict(grodnD);
		brestO.addDistrict(brestD);
		
		City minsk = new City("Minsk","Capital",2000000);
		City gomel = new City("Gomel","Regional center",500000);
		City mogilev = new City("Mogilev","Regional center",300000);
		City vitsebsk = new City("Vitsebsk","Regional center",250000);
		City grodno = new City("Grodno","Regional center",200000);
		City brest = new City("Brest","Regional center",200000);
		
		minskD.addCity(minsk);
		gomelD.addCity(gomel);
		mogilD.addCity(mogilev);
		vitsebD.addCity(vitsebsk);
		grodnD.addCity(grodno);
		brestD.addCity(brest);
		
		System.out.println(s.getName() + " regions count is " + s.getRegions().size());
		System.out.println(s.getName() + " square is " + s.getSquare() + " km2");
		System.out.println(s.getName() + " regions centers are:");
		s.printRegionCenters();
		System.out.print(s.getName() + " capital is ");
		s.printCapital();
		
	}
}
