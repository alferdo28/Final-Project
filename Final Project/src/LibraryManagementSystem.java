import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LibraryManagementSystem {
	private static Scanner in = new Scanner(System.in);
	private static String[][] dataBuku = new String[100][9];
	private static String[][] dataMember = new String[100][6];
	private static int totalBuku = 0;
	private static int totalMember = 0;

	public static void listBUku() {
		try {
			Scanner input = new Scanner(new File("DataBuku.csv"));
			String baris = "";
			while ((baris = input.nextLine()) != null) {
				dataBuku[totalBuku] = baris.split(",");
				totalBuku++;
			}
		} catch (final Exception e) {

		}
	}

	public static void listMember() {
		try {
			Scanner in = new Scanner(new File("DataMember.csv"));
			String baris = "";
			while ((baris = in.nextLine()) != null) {
				dataMember[totalMember] = baris.split(",");
				totalMember++;
			}
		} catch (final Exception e) {

		}
	}

	public static void simpanDataBuku() {
		try {
			Writer wr = new FileWriter("DataBuku.csv");

			for (int baris = 0; baris < totalBuku; baris++) {
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

	public static void simpanDataMember() {
		try {
			Writer wr = new FileWriter("DataMember.csv");

			for (int baris = 0; baris < totalMember; baris++) {
				for (int kolom = 0; kolom < dataMember[0].length; kolom++) {
					wr.write(dataMember[baris][kolom] + ",");
				}
				wr.write("\n");
			}
			wr.flush();
			wr.close();
		} catch (final Exception e) {

		}
	}

	public static void tampilBUku() {
		System.out.println();
		System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s|%-15s|%-18s|%n", "id", "Subjek Buku",
				"Judul Buku", "Penulis Buku", "Penerbit Buku", "No Edisi", "Jumlah Halaman", "ISBN Buku",
				"Jumlah Stok Buku");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < totalBuku; i++) {
			System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s|%-15s|%-18s|%n", dataBuku[i][0],
					dataBuku[i][1], dataBuku[i][2], dataBuku[i][3], dataBuku[i][4], dataBuku[i][5], dataBuku[i][6],
					dataBuku[i][7], dataBuku[i][8]);
		}
		System.out.println();
	}

	public static void tampilMember() {
		System.out.println();
		System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", "No", "Nama", "NIK",
				"Tempat-Tanggal Lahir(DDMMYY)", "Alamat", "Asal Sekolah/Institusi");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < totalMember; i++) {
			System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", dataMember[i][0], dataMember[i][1],
					dataMember[i][2], dataMember[i][3], dataMember[i][4], dataMember[i][5]);
		}
		System.out.println();
	}

	public static void inputBuku() {

		String[] Buku = new String[9];
		int id;
		if (totalBuku - 1 < 0) {
			id = 1;
		} else {
			id = Integer.parseInt(dataBuku[totalBuku - 1][0]) + 1;
		}
		Buku[0] = String.valueOf(id);
		System.out.print("Masukkan Subjek Buku : ");
		in.nextLine();

		Buku[1] = in.nextLine();
		System.out.print("Masukkan Judul Buku : ");
		Buku[2] = in.nextLine();
		System.out.print("Masukkan Penulis Buku : ");
		Buku[3] = in.nextLine();
		System.out.print("Masukkan Penerbit Buku : ");
		Buku[4] = in.nextLine();
		System.out.print("Masukkan Nomor Edisi Buku : ");
		Buku[5] = in.nextLine();
		System.out.print("Masukkan Jumlah Halaman Buku : ");
		Buku[6] = in.nextLine();
		System.out.print("Masukkan Nomor ISBN Buku : ");
		Buku[7] = in.nextLine();
		System.out.print("Masukkan Jumlah Stok Buku : ");
		Buku[8] = in.nextLine();

		for (int i = 0; i < dataBuku.length; i++) {
			if (dataBuku[i][0] == null) {
				for (int l = 0; l < dataBuku[0].length; l++) {
					dataBuku[i][l] = Buku[l];
				}
				totalBuku++;
				break;
			}
		}

	}

	public static int cariBuku(String namaBuku) {
		int hasil = -1;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (dataBuku[baris][2].compareToIgnoreCase(namaBuku) == 0) {
				hasil = baris;
				break;
			}
		}
		return hasil;
	}
	
	public static int cariMember(String namaMember) {
		int hasil = -1;
		for (int baris = 0; baris < totalMember; baris++) {
			if (dataBuku[baris][2].compareToIgnoreCase(namaMember) == 0) {
				hasil = baris;
				break;
			}
		}
		return hasil;
	}

	public static void peminjamanBuku(String namaBuku) {
		int stock = 0;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (dataBuku[baris][2].compareToIgnoreCase(namaBuku) == 0) {
				stock = Integer.parseInt(dataBuku[baris][8]);
				stock--;
				dataBuku[baris][8] = String.valueOf(stock);
				simpanDataBuku();
				break;
			}
		}

	}

	public static void pengembalianBuku(String buku) {
		int stock = 0;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (dataBuku[baris][2].compareToIgnoreCase(buku) == 0) {
				stock = Integer.parseInt(dataBuku[baris][8]);
				stock++;
				dataBuku[baris][8] = String.valueOf(stock);
				simpanDataBuku();
				break;
			}

		}

	}

	public static void tglPeminjamandanPengembalian() {
		Date peminjaman = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
		System.out.println("Tanggal Peminjaman : " + sdf.format(peminjaman));

		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DATE, 21);
		Date pengembalian = cl.getTime();
		System.out.println("Tanggal Pengembalian : " + sdf.format(pengembalian));
	}

	public static void inputMember() {
		String[] Member = new String[6];
		int no;
		if (totalMember - 1 < 0) {
			no = 1;
		} else {
			no = Integer.parseInt(dataMember[totalMember - 1][0]) + 1;
		}
		Member[0] = String.valueOf(no);
		System.out.print("Nama : ");
		in.nextLine();
		Member[1] = in.nextLine();
		System.out.print("NIK : ");
		Member[2] = in.nextLine();
		System.out.print("Tempat-Tanggal Lahir(tempat-DDMMYY) : ");
		Member[3] = in.nextLine();
		System.out.print("Alamat : ");
		Member[4] = in.nextLine();
		System.out.print("Asal Sekolah/Institusi : ");
		Member[5] = in.nextLine();

		for (int i = 0; i < dataMember.length; i++) {
			if (dataMember[i][0] == null) {
				for (int l = 0; l < dataMember[0].length; l++) {
					dataMember[i][l] = Member[l];
				}
				totalMember++;
				break;
			}
		}

	}

	public static void menu() {
		System.out.println();
		System.out.println("Silahkan Pilih Menu yang Anda Inginkan : ");
		System.out.println("1. Menambahkan Buku");
		System.out.println("2. Menampilkan Buku");
		System.out.println("3. Mencari Buku");
		System.out.println("4. Menambahkan Member");
		System.out.println("5. Menampilkan Member");
		System.out.println("6. Meminjam Buku");
		System.out.println("7. Mengembalikan Buku");
		System.out.println();
		System.out.print("Pilih Salah Satu Menu : ");
		int pilihMenu = in.nextInt();
		if (pilihMenu == 1) {
			inputBuku();
			tampilBUku();
			simpanDataBuku();
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}

		} else if (pilihMenu == 2) {
			tampilBUku();
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				in.nextLine();
				menu();
			}

		} else if (pilihMenu == 3) {
			System.out.print("Masukkan Judul Buku : ");
			in.nextLine();
			String tampil = in.nextLine();
			int hasil = cariBuku(tampil);
			if (hasil < 0) {
				System.out.println("Maaf buku yang anda cari tidak ada");
			} else {
				System.out.println();
				System.out.println("Berikut data buku yang anda cari : ");
				System.out.println(Arrays.toString(dataBuku[hasil]));
			}
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}
		} else if (pilihMenu == 4) {
			inputMember();
			tampilMember();
			simpanDataMember();
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}

		} else if (pilihMenu == 5) {
			tampilMember();
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}

		} else if (pilihMenu == 6) {
			System.out.print("Masukkan Judul buku yang dipinjam : ");
			in.nextLine();
			String pinjam = in.nextLine();
			System.out.print("Masukkan Nama Member : ");
			String peminjam = in.nextLine();
			peminjamanBuku(pinjam);
			tglPeminjamandanPengembalian();
			System.out.println();
			System.out.println("Anda telah meminjam buku " + pinjam);
			System.out.println("Silahkan Kembalikan buku sesuai tanggal yang sudah ditentukan");
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}

		} else if (pilihMenu == 7) {
			System.out.print("Masukkan Judul buku yang dipinjam : ");
			in.nextLine();
			String pengembalian = in.nextLine();
			System.out.print("Masukkan Nama Member : ");
			String peminjam = in.nextLine();
			pengembalianBuku(pengembalian);
			tglPeminjamandanPengembalian();
			System.out.println();
			System.out.println("Terima kasih sudah mengembalikan buku " + pengembalian);
			System.out.println();
			System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
			System.out.print("=>");
			int kembali = in.nextInt();
			if (kembali == 1) {
				menu();
			}
		}
	}

	public static void main(String[] args) {
		listBUku();
		listMember();
		System.out.println("Selamat Datang di Perpustakaan");
		menu();

	}

}
