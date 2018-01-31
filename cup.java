

public class cup {
	public int type;
	public String name;
	public int serialNum;
	public String color;
	public boolean handle;
	double maxFluid;
	public double currFluid;
	public boolean broken;
	public cup(int type, String name, int serialNum, String color, double maxFluid, boolean handle) {
		this.type = type;
		this.name = name;
		this.serialNum = serialNum;
		this.color = color;
		this.maxFluid = maxFluid;
		this.currFluid = 0;
		this.handle = handle;
		broken = false;
	}
	
	public void fillCup(double oz) {
		if(!broken) {
			if(oz == -1) {
				currFluid = maxFluid;
				System.out.println("You filled the cup completely.");
			}else {
				currFluid+=oz;
				if(currFluid>maxFluid)currFluid = maxFluid;
				System.out.println("You filled the cup.");
			}
			if(type == 3)currFluid *= 0.8;
		}
	}
	
	public void emptyCup(double oz) {
		if(!broken) {
			if(oz == -1) {
				currFluid = 0;
				System.out.println("You emptied the cup completely.");
			} else {
				currFluid-=oz;
				if(currFluid<0)currFluid = 0;
				System.out.println("You emptied the cup.");
			}
			if(type == 3)currFluid *=0.8;
		}
	}
	
	public void dropCup() {
		if(type == 1) {
			double breaks = Math.random();
			if(breaks<0.2) {
				broken = true;
				currFluid = 0;
				System.out.println("You broke it.");
			}else System.out.println("It did not break.");
		}else if(type == 2) {
			double breaks = Math.random();
			if(breaks<0.8) {
				broken = true;
				currFluid = 0;
				System.out.println("You broke it.");
			}else System.out.println("It did not break.");
		}else {
			System.out.println("It did not break.");
		}
	}
	
	public void breakCup() {
		if(type!=3) {
			broken = true;
			currFluid = 0;
			System.out.println("You broke it.");
		}else System.out.println("It could not be broken.");
	}
	
}
