import java.util.Scanner;
public class LibraryManagementSystem {
	private static Scanner in = new Scanner(System.in);
	private static String [][] dataBuku = new String[100][10];
	
	
	public static void inputBuku () {
		for (int i = 0; i < dataBuku.length; i++) {
			for (int j = 0; j < dataBuku.length; j++) {
				System.out.println("Subjek buku: ");
				String subjekBuku = in.next();
				System.out.println("Judul Buku");
			}
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
