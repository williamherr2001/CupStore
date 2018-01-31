import java.util.ArrayList;
import java.util.Scanner;

public class cupStore {
	static ArrayList<cup> store = new ArrayList<cup>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Cups'R'Us");
		System.out.println("Menu Options:");
		System.out.println("\t1. Buy");
		System.out.println("\t2. Sell");
		System.out.println("\t3. Maintenance");
		System.out.println("\t4. Inventory Report");
		System.out.println("\t5. Logout");
		int method = in.nextInt();
		if(method == 1) buy();
		else if (method == 2) sell();
		else if (method == 3) maintenance();
		else if (method == 4) InventoryReport();
		else if (method == 5) LogOut();
	}
	public static void buy() {
		Scanner in = new Scanner(System.in);
		System.out.println("What type of cup is it?");
		System.out.println("\t1. Mug");
		System.out.println("\t2. Glass");
		System.out.println("\t3. Tumbler");
		int type = in.nextInt();
		System.out.println("Name?");
		String name = in.next();
		System.out.println("Serial?");
		int serial = in.nextInt();
		System.out.println("Color?");
		String color = in.next();
		System.out.println("Max Fluid?");
		double max = in.nextDouble();
		System.out.println("Handle? Yes/No");
		String s = in.next();
		boolean handle;
		if(s.toLowerCase().equals("yes"))handle = true;
		else handle = false;
		store.add(new cup(type, name, serial, color, max, handle));
		System.out.println("Thank you.");
		main(new String[0]);
	}
	public static void sell() {
		Scanner in = new Scanner(System.in);
		System.out.println("Which Cup?");
		for(int i = 0; i<store.size(); i++) {
			System.out.println("\t"+(i+1)+". "+store.get(i).name);
		}
		store.remove(in.nextInt()-1);
		System.out.println("You sold the cup.");
		main(new String[0]);
	}
	public static void maintenance() {
		Scanner in = new Scanner(System.in);
		System.out.println("Maintenance Menu");
		System.out.println("\t1. Fill Cup");
		System.out.println("\t2. Empty Cup");
		System.out.println("\t3. Drop Cup");
		System.out.println("\t4. Break Cup");
		int n = in.nextInt();
		if(n==1) {
			System.out.println("Which Cup?");
			for(int i = 0; i<store.size(); i++) {
				System.out.println("\t"+(i+1)+". "+store.get(i).name);
			}
			int f = in.nextInt();
			System.out.println("By how much (Press -1 for all the way)?");
			double oz = in.nextDouble();
			store.get((f-1)%store.size()).fillCup(oz);
		}else if(n==2) {
			System.out.println("Which Cup?");
			for(int i = 0; i<store.size(); i++) {
				System.out.println("\t"+(i+1)+". "+store.get(i).name);
			}
			int e = in.nextInt();
			System.out.println("By how much (Press -1 for all the way)?");
			double oz = in.nextDouble();
			store.get((e-1)%store.size()).emptyCup(oz);
		}else if(n==3) {
			System.out.println("Which Cup?");
			for(int i = 0; i<store.size(); i++) {
				System.out.println("\t"+(i+1)+". "+store.get(i).name);
			}
			int drop = in.nextInt();
			store.get((drop-1)%store.size()).dropCup();
		}else if(n==4) {
			System.out.println("Which Cup?");
			for(int i = 0; i<store.size(); i++) {
				System.out.println("\t"+(i+1)+". "+store.get(i).name);
			}
			int b = in.nextInt();
			store.get((b-1)%store.size()).breakCup();
		}
		main(new String[0]);
	}
	public static void InventoryReport() {
		System.out.println("Inventory Report");
		System.out.println("Name\tSerial\tColor\tFluid\tHandle\tBroken");
		for(int i = 0;i<store.size();i++) {
			if(store.get(i).name.length()>10)System.out.print(store.get(i).name.substring(0, 10)+"\t"+store.get(i).serialNum+"\t\t\t"+store.get(i).color+"\t+\t");
			else System.out.print(store.get(i).name+"\t"+store.get(i).serialNum+"\t"+store.get(i).color+"\t");
			double n = Math.round(store.get(i).currFluid*1000000.0);
			System.out.print(n/1000000.0+"\t");
			if(store.get(i).handle)System.out.print("Yes\t");
			else System.out.print("No\t");
			if(store.get(i).broken)System.out.println("Yes");
			else System.out.println("No");
		}
		main(new String[0]);
	}
	public static void LogOut() {
		System.out.println("Logged Out");
		return;
	}
}
