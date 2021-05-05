package fr.formation;

public class ApplicationArgs {
	public static void main(String[] args) {
//		int[] as = new int[] { 6, 7, 8 };

//		demo(5, new int[] { 6, 7, 8 });
		demo(5);
		demo(5, 6, 7, 8, 9, 10);

		demo2();
		demo2(5);
		demo2(5, 10);
	}
	
	public static void demo(int a, int... as) { // argument variable forcément à la fin !
		System.out.println(a);

		for (int b : as) {
			System.out.println(b);
		}
	}
	
	public static void demo2(int... as) { // argument variable forcément à la fin !
		for (int b : as) {
			System.out.println(b);
		}
	}
}