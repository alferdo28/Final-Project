import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
	private static Scanner in = new Scanner(System.in);
	private static String[][] dataBuku = new String[100][9];
	private static int k = 0;

	public static void listBUku() {
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
			System.out.println("Maaf terdapat kesalahan dalam menghapus layar");
		}

	}
	
	public static void tampilBUku(){
	
    System.out.printf("%-10s| %-8s| %-18s| %-12s| %-8s| %-18s| %-20s|%-10s|%-8s|%n",
            "Subjek Buku","Judul Buku","Penulis Buku","Penerbit Buku","Nomor Edisi Buku","Jumlah Halaman","ISBN Buku","Jumlah Stok Buku","Nomor Rak Buku");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    for (int i = 0;i<=k-1;i++) {
        System.out.printf("%-10s| %-8s| %-18s| %-12s| %-8s| %-18s| %-20s|%-10s|%-8s|%n",
                dataBuku[i][1], dataBuku[i][2], dataBuku[i], dataBuku[i][3],
                dataBuku[i][4], dataBuku[i][5], dataBuku[i][6], dataBuku[i][7], dataBuku[i][8]);

    }


}

	public static void inputBuku() {

		        String[] Buku = new String[9];

		        System.out.printf("Masukkan Subjek Buku : ");
		        in.nextLine();
		        Buku[0]=in.nextLine();
		        System.out.printf("Masukkan Judul Buku : ");
		        Buku[1]=in.nextLine();
		        System.out.printf("Masukkan Penulis Buku : ");
		        Buku[2]=in.nextLine();
		        System.out.printf("Masukkan Penerbit Buku : ");
		        Buku[3]=in.nextLine();
		        System.out.printf("Masukkan Nomor Edisi Buku : ");
		        Buku[4]=in.nextLine();
		        System.out.printf("Masukkan Jumlah Halaman Buku : ");
		        Buku[5]=in.nextLine();
		        System.out.printf("Masukkan Nomor ISBN Buku : ");
		        Buku[6]=in.nextLine();
		        System.out.printf("Masukkan Jumlah Stok Buku : ");
		        Buku[7]=in.nextLine();
		        System.out.printf("Masukkan Nomor Rak Buku : ");
		        Buku[8]=in.nextLine();

		        for(int i = 0;i<dataBuku.length;i++){
		            if (dataBuku[i][0] == null) {
		                for (int l = 0; l < dataBuku[0].length; l++) {
		                    dataBuku[i][l] = Buku[l];
		                }
		                i++;
		                break;
		            }
		            tampilBUku();
		        }
		    }
	public static void menu () {
		System.out.println("Silahkan ");
		System.out.println("1. Menambahkan Buku");
		System.out.println("2. Menampilkan Buku");
		System.out.println("3. Mencari Buku");
		System.out.println("4. Menambahkan Member");
		System.out.println("5. Menampilkan Member");
		System.out.println("6. Meminjam Buku");
		System.out.println("7. Mengembalikan Buku");
		
		System.out.print("Pilih Salah Satu Menu : ");
		int pilihMenu = in.nextInt(); 
		if (pilihMenu == 1) {
			inputBuku();
		} else if (pilihMenu == 2) {
			tampilBUku();
		}
	}

	public static void main(String[] args) {
		System.out.println("Selamat Datang di Perpustakaan Umum Kota");
		menu();
		
		System.out.println("Terima Kasih Sudah Mengunjungi Perpustakaan");
		System.out.println("Semoga Ilmu yang Kamu Dapatkan Bermanfaat");

	}

}
