import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
	private static Scanner in = new Scanner(System.in);
	private static String[][] dataBuku = new String[100][10];
	private static int k = 0;

	public static void tampilBUku() {
		try {
			Scanner data = new Scanner(new File("DataBuku.csv"));
			String baris = "";
			while ((baris = data.nextLine()) != null) {
				dataBuku[k] = baris.split(",");
				k++;

			}
		} catch (final Exception e) {

		}
	}

	public static void simpanDataBuku() {
		try {
			Writer wr = new FileWriter("DataBuku.csv");

			for (int baris = 0; baris < k; baris++) {
				for (int kolom = 0; kolom < dataBuku[0].length; kolom++) {
					wr.write(dataBuku[baris][kolom] + ",");
				}
				wr.write("\n");
			}
			wr.flush();
			wr.close();
		} catch (final Exception e) {

		}
	}

	public static void hapusLayar() {
		try {
			String OS = System.getProperty("os.name");
			String[] OSuser = OS.split(" ");
			if (OSuser[0].equals("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else if (OSuser[0].equals("Linux")) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			System.out.println("Maaf ada kesalahan dalam menghapus layar");
		}

	}

	public static void inputBuku() {
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
