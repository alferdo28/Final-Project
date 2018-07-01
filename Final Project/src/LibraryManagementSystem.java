import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LibraryManagementSystem {
	private static Scanner in = new Scanner(System.in);
	private static String[][] dataBuku = new String[100][9];
	private static String[][] dataMember = new String[100][6];
	private static String[][] dataPeminjaman = new String[100][9];
	private static int totalBuku = 0;
	private static int totalMember = 0;
	private static int totalPinjam = 0;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Method loadBuku digunakan untuk memuat data buku yang tersedia dalam
	 * DataBuku.csv
	 */
	public static void loadBUku() {
		try {
			totalBuku = 0;
			Scanner input = new Scanner(new File("DataBuku.csv"));
			String baris = "";
			while (input.hasNextLine()) {
				baris = input.nextLine();
				dataBuku[totalBuku] = baris.split(",");
				totalBuku++;
			}
		} catch (final Exception e) {

		}
	}

	/**
	 * Method loadMember digunakan untuk memuat data member yang tersedia dalam
	 * DataBuku.csv
	 */
	public static void loadMember() {
		try {
			totalMember = 0;
			Scanner in = new Scanner(new File("DataMember.csv"));
			String baris = "";
			while ((baris = in.nextLine()) != null) {
				dataMember[totalMember] = baris.split(",");
				totalMember++;
			}
		} catch (final Exception e) {

		}
	}
	
	/**
	 * Method loadPinjam digunakan untuk memuat data peminjaman yang tersedia pada
	 * DataPeminjaman.csv
	 */
	public static void loadPinjam() {
		try {
			totalPinjam = 0;
			Scanner in = new Scanner(new File("DataPeminjaman.csv"));
			String baris = "";
			while ((baris = in.nextLine()) != null) {
				dataPeminjaman[totalPinjam] = baris.split(",");
				totalPinjam++;
			}
		} catch (final Exception e) {

		}
	}
	
	/**
	 * Method simpanDataPeminjaman digunakan untuk menyimpan data yang disimpan 
	 * dalam DataPeminjaman.csv
	 */
	public static void simpanDataPinjam() {
		try {
			Writer wr = new FileWriter("DataPeminjaman.csv");

			for (int baris = 0; baris < totalPinjam; baris++) {
				for (int kolom = 0; kolom < dataPeminjaman[0].length; kolom++) {
					wr.write(dataPeminjaman[baris][kolom] + ",");
				}
				wr.write("\n");
			}
			wr.flush();
			wr.close();
		} catch (final Exception e) {

		}
	}

	/**
	 * Method simpanDataBuku digunakan untuk menyimpan data yang telah dimasukkan
	 * kedalam method inputBuku yang disimpan dalam DataBuku.csv
	 */
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

	/**
	 * Method simpanDataMember digunakan untuk menyimpan data yang telah dimasukkan
	 * kedalam method inputMember yang disimpan dalam DataMember.csv
	 */
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

	/**
	 * Method pemotonganKarakter digunakan untuk membatasi karakter yang ditampilkan
	 * pada tabel data buku dan data member dengan membatasi jumlahnya dengan nilai
	 * maksimal karakternya dikurangi dengan 2 dan 2 karakter tersebut akan
	 * digantikan dengan karakter titik
	 * 
	 * @param kata
	 *            kalimat/kata yang akan dipotong karakternya pada kalimat/kata
	 *            tersebut
	 * @param maksimal
	 *            Karakter dari kata
	 * @return nilai String yang telah dimodifikasi pada variabel baru apabila
	 *         melebihi karakter dan nilai String pada variabel kata apabila tidak
	 *         melebihi karakter
	 */
	public static String pemotonganKarakter(String kata, int maksimal) {
		if (kata.length() > maksimal) {
			String baru = "";
			for (int i = 0; i < maksimal - 2; i++) {
				baru += kata.charAt(i);
			}
			for (int j = 1; j <= 2; j++) {
				baru += ".";
			}
			return baru;
		} else {
			return kata;
		}
	}

	/**
	 * Method tampilBuku digunakan untuk menampilkan tabel data buku yang telah
	 * dimasukkan dalam Method inputBuku dengan menggunakan format yang telah
	 * ditentukan
	 */
	public static void tampilBUku() {
		System.out.println();
		System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s| %-15s| %-18s| %n", "id", "Subjek Buku",
				"Judul Buku", "Penulis Buku", "Penerbit Buku", "No Edisi", "Jumlah Halaman", "ISBN Buku",
				"Jumlah Stok Buku");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------");
		if (totalBuku > 0) {
			for (int i = 0; i < totalBuku; i++) {
				System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s| %-15s| %-18s| %n", dataBuku[i][0],
						pemotonganKarakter(dataBuku[i][1], 18), pemotonganKarakter(dataBuku[i][2], 18),
						pemotonganKarakter(dataBuku[i][3], 18), pemotonganKarakter(dataBuku[i][4], 18), dataBuku[i][5],
						dataBuku[i][6], dataBuku[i][7], dataBuku[i][8]);
			}
			System.out.println();
		} else if (totalBuku == 0) {
			System.out.println("Data Buku Kosong");
		}
	}

	/**
	 * Method tampilMember digunakan untuk menampilkan tabel data Member yang telah
	 * dimasukkan dalam Method inputMember dengan menggunakan format yang telah
	 * ditentukan
	 */
	public static void tampilMember() {
		System.out.println();
		System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", "No", "Nama", "NIK",
				"Tempat-Tanggal Lahir(DDMMYY)", "Alamat", "Asal Sekolah/Institusi");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");
		if (totalMember > 0) {
			for (int i = 0; i < totalMember; i++) {
				System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", dataMember[i][0],
						pemotonganKarakter(dataMember[i][1], 25), dataMember[i][2], dataMember[i][3],
						pemotonganKarakter(dataMember[i][4], 40), pemotonganKarakter(dataMember[i][5], 25));
			}
			System.out.println();
		} else if (totalMember == 0) {
			System.out.println("Data Member Kosong");
		}
	}

	/**
	 * Method inputBuku digunakan untuk memasukkan data buku dari user sesuai dengan
	 * inputan yang diminta dan akan disimpan pada DataBuku.csv
	 */
	public static void inputBuku() {

		String[] Buku = new String[9];
		int id;
		if (totalBuku == 0) {
			id = 1;
		} else {
			id = Integer.parseInt(dataBuku[totalBuku - 1][0]) + 1;
		}
		in.nextLine();
		Buku[0] = String.valueOf(id);
		System.out.print("Masukkan Subjek Buku : ");
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

	/**
	 * Method cariBuku digunakan untuk mencari data buku yang diinginkan
	 * 
	 * @param id
	 *            id dari buku yang tersimpan dalam perpustakaan
	 * @return nilai integer pada variabel hasil
	 */
	public static int cariBuku(int id) {
		int hasil = -1;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (Integer.parseInt(dataBuku[baris][0]) == id) {
				hasil = baris;
				return hasil;
			}
		}
		return hasil;
	}
	
	/**
	 * Method hitungDenda digunakan dalam perhitungan denda pengembalian buku
	 * @param tglkembali
	 * 						tanggal pengembalian buku
	 * @return hasil perhitungan denda
	 * @throws ParseException
	 * 				ketika kesalahan parse ditemui maka akan dilemparkan ke statement berikutnya
	 */
	public static int hitungDenda(String tglkembali) throws ParseException {
		// hitung denda
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		Date dateNow = cal.getTime();
		Date tglPengembalian = new SimpleDateFormat("dd/MMMM/yyyy").parse(tglkembali);
		if (dateNow.after(tglPengembalian)) {
			long penalti = dateNow.getTime() - tglPengembalian.getTime();
			return (int) TimeUnit.DAYS.convert(penalti, TimeUnit.MILLISECONDS) * 500;
		} else {
			return 0;
		}
	}

	
	/**
	 * Method PinjamBuku digunakan dalam meminjam buku pada perpustakaan
	 * dengan input id member dan id buku dan menampilkan laporan apabila member belum mengembalikan
	 * buku
	 */
	public static void PinjamBuku() {
		String[] pinjamBuku = new String[9];
		int pinjam_id;
		if (totalPinjam == 0) {
			pinjam_id = 1;
		} else {
			pinjam_id = Integer.parseInt(dataPeminjaman[totalPinjam - 1][0]) + 1;
		}
		pinjamBuku[0] = String.valueOf(pinjam_id);
		System.out.print("Masukkan id Member : ");
		pinjamBuku[2] = in.next();
		if (cariMember(Integer.parseInt((pinjamBuku[2]))) == -1) {
			System.out.println("id Member tidak ada");
			System.out.println();
			inputMember();
		}
		in.nextLine();
		int banyakPinjam = 0;
		int l = 0;
		for (l = 0; l < totalPinjam; l++) {
			if (dataPeminjaman[l][8].equals("false") && dataPeminjaman[l][2].equals(pinjamBuku[2])) {
				banyakPinjam++;
				break;
			}
		}
		if (banyakPinjam > 0) {
			System.out.println(
					"Maaf tidak bisa meminjam karena masih ada buku yang belum di kembalikan, silahkan kembalikan buku terlebih dahulu !");
			System.out.println("Buku yang belum dikembalikan ");
			System.out.println("id Buku : " + dataPeminjaman[l][1]);
			System.out.print("Nama buku : ");
			for (int n = 0; n < totalBuku; n++) {
				if (dataBuku[n][0].equals(dataPeminjaman[Integer.parseInt(dataPeminjaman[l][1]) - 1][0])) {
					System.out.print(dataBuku[n][2]);
					break;
				}

			}

		} else {

			System.out.print("Masukkan id Buku : ");
			int[] hasil = cekStokBuku(in.nextInt());
			if (hasil[0] < 0) {
				System.out.println("Buku tidak ada");
			} else {
				pinjamBuku[1] = dataBuku[hasil[0]][0];
			}

			System.out.print("Masukkan banyak Buku : ");
			pinjamBuku[3] = in.next();

			Date now = new Date();

			pinjamBuku[4] = dateFormat.format(now);
			pinjamBuku[5] = timeFormat.format(now);

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 21);
			Date resultDate = cal.getTime();
			pinjamBuku[6] = dateFormat.format(resultDate);
			pinjamBuku[7] = timeFormat.format(resultDate);

			pinjamBuku[8] = "false";

			for (int i = 0; i < dataPeminjaman.length; i++) {
				if (dataPeminjaman[i][0] == null) {
					for (int k = 0; k < dataPeminjaman[0].length; k++) {
						dataPeminjaman[i][k] = pinjamBuku[k];
					}
					totalPinjam++;
					break;
				}
			}
			simpanDataPinjam();
			loadPinjam();
			peminjamanBuku(Integer.parseInt(pinjamBuku[1]),Integer.parseInt(pinjamBuku[3]));
			System.out.println();
			System.out.print("Sukses pinjam buku ");
			for (int n = 0; n < totalBuku; n++) {
				if (dataBuku[n][0].equals(pinjamBuku[1])) {
					System.out.print(dataBuku[n][2]);
					break;
				}

			}
		}
	}
	
	/**
	 * Method kembaliBuku digunakan dalam mengembalikan buku pada perpustakaan
	 * dengan input id member dan id buku serta menampilkan laporan peminjaman buku
	 * @throws ParseException
	 * 					ketika kesalahan parse ditemui maka akan dilemparkan ke statement berikutnya
	 */
	public static void kembaliBuku() throws ParseException {

		System.out.print("Masukkan id buku : ");
		int idBuku = in.nextInt();
		System.out.print("Masukkan id member : ");
		int idMember = in.nextInt();
		System.out.println("Menampilkan data peminjaman oleh member id " + idMember);
		int kembali = -1;
		System.out.println();
		System.out.printf("%-3s| %-7s| %-9s| %-11s| %-20s| %-12s| %-20s| %-18s| %-18s| %n", "no", "id Buku",
				"id Member", "Jumlah Buku", "Tanggal Peminjaman", "Waktu Pinjam", "Tanggal Pengembalian", "Waktu pengembalian",
				"Status kembali");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < totalPinjam; i++) {
			if ((dataPeminjaman[i][1].compareToIgnoreCase(String.valueOf(idBuku)) == 0)
					&& (dataPeminjaman[i][2].compareToIgnoreCase(String.valueOf(idMember)) == 0)) {
				System.out.printf("%-3s| %-7s| %-9s| %-11s| %-20s| %-12s| %-20s| %-18s| %-18s| %n",
						dataPeminjaman[i][0], pemotonganKarakter(dataPeminjaman[i][1], 18),
						pemotonganKarakter(dataPeminjaman[i][2], 18), pemotonganKarakter(dataPeminjaman[i][3], 18),
						pemotonganKarakter(dataPeminjaman[i][4], 18), dataPeminjaman[i][5], dataPeminjaman[i][6],
						dataPeminjaman[i][7], ((dataPeminjaman[i][8].equals("true")) ? "Sudah" : "Belum"));
				if (dataPeminjaman[i][8].equals("false")) {
					kembali = i;
				}
				hitungDenda(dataPeminjaman[i][6]);
				System.out.println();
			}
		}

		if (kembali < 0) {
			System.out.println("Tidak ada buku dengan id " + idBuku + " yang harus dikembalikan ");
		} else {

			System.out.println("Detail pengembalian buku : ");
			System.out.println("Nama buku : " + dataBuku[3][idBuku]);
			System.out.println("Dipinjam oleh : " + dataMember[idMember][1]);
			System.out.println("Tanggal pinjam : " + dataPeminjaman[kembali][4]);
			System.out.println("Tanggal kembali : " + dataPeminjaman[kembali][6]);
			System.out.println("Denda yang harus dibayar : " + hitungDenda(dataPeminjaman[kembali][6]));
			System.out.println("Status : Belum bayar");
			System.out.println("apakah anda ingin mengembalikan buku dengan id " + idBuku + " yang dipinjam member id "
					+ idMember + " (y/t) ? ");
			char choice = in.next().charAt(0);
			if (choice == 'y') {
				dataPeminjaman[kembali][8] = "true";
				simpanDataPinjam();
				loadPinjam();
				pengembalianBuku(Integer.parseInt(dataPeminjaman[kembali][1]),Integer.parseInt(dataPeminjaman[kembali][3]));
				System.out.println("Pengembalian sukses ");
			} else {
				System.out.println("Anda tidak bisa meminjam buku jika masih ada buku yang belum dikembalikan ");
			}

		}

		back();
	}

	/**
	 * Method cariMember digunakan untuk mencari data Member yang diinginkan
	 * 
	 * @param idMember
	 *            id dari anggota member perpustakaan
	 * @return hasilCari
	 */
	public static int cariMember(int idMember) {
		int hasilCari = -1;
		for (int baris = 0; baris < totalMember; baris++) {
			if (Integer.parseInt(dataMember[baris][0]) == idMember) {
				hasilCari = baris;
				break;
			}
		}
		return hasilCari;
	}
	
	
	/**
	 * Method ini digunakan untuk input dari keyboard dan mengembalikan nilai String
	 * @return String yang diinput dari keyboard
	 */
    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

	/**
	 * Method ini digunakan untuk mengecek suatu keberadaan stok buku pada array
	 * dataBuku
	 * 
	 * @param buku1
	 *            id dari buku
	 * @return nilai array data
	 */
	public static int[] cekStokBuku(int buku1) {
		int[] data = new int[2];
		if (dataBuku[0][0] != null) {
			for (int cek = 0; cek < totalBuku; cek++) {
				if (Integer.parseInt(dataBuku[cek][0]) == buku1) {
					data[0] = cek;
					data[1] = Integer.parseInt(dataBuku[cek][8]);
					return data;
				}
			}
		}
		data[0] = -1;
		data[1] = 0;
		return data;
	}

	/**
	 * Method ini digunakan untuk menghapus data buku dalam DataBuku.csv
	 * @param buku1
	 *            id dari buku
	 */
	public static void hapusBuku(int buku1) {
		int[] hasil = cekStokBuku(buku1);
		if (hasil[0] >= 0) {
			String[][] matriksTmp = new String[100][9];
			int row = 0;
			int tmp = totalBuku;
			for (int baris = 0; baris < tmp; baris++) {
				int col = 0;
				if (Integer.parseInt(dataBuku[baris][0]) == buku1) {
					totalBuku--;
					continue;
				} else {
					for (int kolom = 0; kolom < dataBuku[0].length; kolom++) {
						matriksTmp[row][col] = dataBuku[baris][kolom];
						col++;

					}
				}
				row++;
			}
			if (hapusData("buku")) {
				for (int baris = 0; baris < totalBuku; baris++) {
					for (int kolom = 0; kolom < dataBuku[baris].length; kolom++) {
						dataBuku[baris][kolom] = matriksTmp[baris][kolom];
					}
				}
			}
			simpanDataBuku();
			loadBUku();
			System.out.println("Buku dengan nomor id \"" + buku1 + "\" berhasil dihapus");
		} else {
			System.out.println("Data tidak ada");
		}
	}

	/**
	 * Method ini digunakan untuk menghapus member apabila member sudah tidak 
	 * beraktifitas kembali
	 * @param nama
	 * 			id dari nama member
	 */
	public static void hapusMember(int nama) {
		int cek = 0;
		if (dataMember[0][0] != null) {
			for (cek = 0; cek < totalMember; cek++) {
				if (Integer.parseInt(dataMember[cek][0]) == nama) {
					String[][] matriksTmp2 = new String[100][6];
					int row = 0;
					int tmp = totalMember;
					for (int baris = 0; baris < tmp; baris++) {
						int col = 0;
						if (Integer.parseInt(dataMember[baris][0]) == nama) {
							totalMember--;
							continue;
						} else {
							for (int kolom = 0; kolom < dataMember[0].length; kolom++) {
								matriksTmp2[row][col] = dataMember[baris][kolom];
								col++;

							}
						}
						row++;
					}
					if (hapusData("member")) {
						for (int baris = 0; baris < totalMember; baris++) {
							for (int kolom = 0; kolom < dataMember[baris].length; kolom++) {
								dataMember[baris][kolom] = matriksTmp2[baris][kolom];
							}
						}
					}
					simpanDataMember();
					loadMember();
					System.out.println("Member pada nomor id \"" + nama + "\" berhasil dihapus");
					break;
				}
			}
		} else if (cek == totalMember) {
			System.out.println("Data tidak ada");
		}
	}

	/**
	 * Method ini digunakan untuk menghapus semua data dari array dataBuku
	 * 
	 * @param data
	 *            data member atau data buku
	 * @return true apabila data sudah terhapus dan false apabila data belum
	 *         terhapus
	 */
	public static boolean hapusData(String data) {
		try {
			if (data.compareTo("buku") == 0) {
				for (int baris = 0; baris < dataBuku.length; baris++) {
					for (int kolom = 0; kolom < dataBuku[baris].length; kolom++) {
						dataBuku[baris][kolom] = null;
					}
				}
			} else if (data.compareTo("member") == 0) {
				for (int baris = 0; baris < dataMember.length; baris++) {
					for (int kolom = 0; kolom < dataMember[baris].length; kolom++) {
						dataMember[baris][kolom] = null;
					}
				}
			}
		} catch (final Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * Method ini digunakan dalam meminjam buku dengan mengurangi nilai stok buku
	 * apabila ada buku yang terpinjam
	 * @param namaBuku
	 * 				id buku yang dipinjam
	 * @param banyakBuku
	 * 				stok buku yang dipinjam
	 */
	public static void peminjamanBuku(int namaBuku, int banyakBuku) {
		int stock = 0;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (Integer.parseInt(dataBuku[baris][0]) == namaBuku) {
				stock = Integer.parseInt(dataBuku[baris][8]);
				stock = stock-banyakBuku;
				dataBuku[baris][8] = String.valueOf(stock);
				simpanDataBuku();

				break;
			}
		}

	}

	/**
	 * Method ini digunakan dalam mengembalikan buku dengan menambah stok buku
	 * apabila ada buku yang dikembalikan
	 * @param buku
	 * 			id buku yang dikembalikan
	 * @param jumlah
	 * 			stok buku yang dikembalikan
	 */
	public static void pengembalianBuku(int buku,int jumlah) {
		int stock = 0;
		for (int baris = 0; baris < totalBuku; baris++) {
			if (Integer.parseInt(dataBuku[baris][0]) == buku) {
				stock = Integer.parseInt(dataBuku[baris][8]);
				stock = stock + jumlah;
				dataBuku[baris][8] = String.valueOf(stock);
				simpanDataBuku();
				break;
			}

		}

	}

	/**
	 * Method inputMember digunakan untuk memasukkan data Member dari user sesuai
	 * dengan inputan yang diminta dan akan disimpan pada DataMember.csv
	 */
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
		System.out.println("Sukses tambah member");

	}

	/**
	 * Method ini diguanakan untuk kembali ke pilihan menu apabila ingin memilih
	 * pilihan menu yang lain
	 * 
	 * @throws ParseException
	 * 						ketika kesalahan parse ditemui maka akan dilemparkan ke statement berikutnya
	 */
	public static void back() throws ParseException {
		System.out.println();
		System.out.println("Apakah anda ingin kembali ke menu ? (1.Ya 2.Tidak)");
		System.out.print("=>");
		String kembali = in.next();
		if (kembali.equalsIgnoreCase("1")) {
			menu();
		} else if (kembali.equalsIgnoreCase("2")) {
			System.out.println();
			System.out.println(" ---------------------------------------------------------");
			System.out.println("|    Terima kasih telah berkunjung ke perpustakaan        |");
			System.out.println("|    Semoga ilmu yang anda dapatkan bermanfaat..          |");
			System.out.println("|    Jangan lupa mengembalikan buku tepat waktu ya..      |");
			System.out.println("|    Biar tidak membayar denda..                          |");
			System.out.println("|    Hemat uangmu dengan tidak membayar denda             |");
			System.out.println(" ---------------------------------------------------------");
			System.exit(1);
		} else {
			System.out.println("input yang anda masukkan salah");
			back();
		}
	}

	/**
	 * Method ini digunakan untuk memilih method yang tersedia dalam menu yang dapat
	 * dikembalikan ke menu kembali apabila telah mengakses salah satu menu
	 * 
	 * @throws ParseException
	 * 					ketika kesalahan parse ditemui maka akan dilemparkan ke statement berikutnya
	 */
	public static void menu() throws ParseException {
		System.out.println();
		System.out.println("Silahkan Pilih Menu yang Anda Inginkan : ");
		System.out.println("1. Menambahkan Buku");
		System.out.println("2. Menampilkan Buku");
		System.out.println("3. Mencari Buku");
		System.out.println("4. Mencari Member");
		System.out.println("5. Menambahkan Member");
		System.out.println("6. Menampilkan Member");
		System.out.println("7. Meminjam Buku");
		System.out.println("8. Mengembalikan Buku");
		System.out.println("9. Hapus Buku");
		System.out.println("10. Hapus Member");
		System.out.println();
		System.out.print("Pilih Salah Satu Menu : ");
		String pilihMenu = in.next();
		if (pilihMenu.equals("1")) {
			inputBuku();
			simpanDataBuku();
			loadBUku();
			tampilBUku();
			back();
		} else if (pilihMenu.equals("2")) {
			loadBUku();
			tampilBUku();
			back();
		} else if (pilihMenu.equals("3")) {
			System.out.print("Masukkan id Buku : ");
			String tampil = in.next();
			int hasil = cariBuku(Integer.parseInt(tampil));
			if (hasil < 0) {
				System.out.println("Maaf buku yang anda cari tidak ada");
			} else {
				System.out.println();
				System.out.println("Berikut data buku yang anda cari : ");
				System.out.println();
				System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s| %-15s| %-18s| %n", "id",
						"Subjek Buku", "Judul Buku", "Penulis Buku", "Penerbit Buku", "No Edisi", "Jumlah Halaman",
						"ISBN Buku", "Jumlah Stok Buku");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-3s| %-18s| %-18s| %-18s| %-18s| %-10s| %-15s| %-15s| %-18s| %n",
						dataBuku[hasil][0], pemotonganKarakter(dataBuku[hasil][1], 18),
						pemotonganKarakter(dataBuku[hasil][2], 18), pemotonganKarakter(dataBuku[hasil][3], 18),
						pemotonganKarakter(dataBuku[hasil][4], 18), dataBuku[hasil][5], dataBuku[hasil][6],
						dataBuku[hasil][7], dataBuku[hasil][8]);
			}
			back();
		} else if (pilihMenu.equals("4")) {
			System.out.print("Masukkan id Member : ");
			int tampil = in.nextInt();
			int hasilCari = cariMember(tampil);
			if (hasilCari < 0) {
				System.out.println("Maaf nama member yang anda cari tidak ada");
			} else {
				System.out.println();
				System.out.println("Berikut data member yang anda cari : ");
				System.out.println();
				System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", "No", "Nama", "NIK",
						"Tempat-Tanggal Lahir(DDMMYY)", "Alamat", "Asal Sekolah/Institusi");
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-3s| %-25s| %-18s| %-32s| %-40s| %-25s|%n", dataMember[hasilCari][0],
						pemotonganKarakter(dataMember[hasilCari][1], 25), dataMember[hasilCari][2],
						dataMember[hasilCari][3], pemotonganKarakter(dataMember[hasilCari][4], 40),
						pemotonganKarakter(dataMember[hasilCari][5], 25));

			}
			back();
		} else if (pilihMenu.equals("5")) {
			inputMember();
			tampilMember();
			simpanDataMember();
			back();
		} else if (pilihMenu.equals("6")) {
			loadMember();
			tampilMember();
			back();
		} else if (pilihMenu.equals("7")) {
			PinjamBuku();
			System.out.println();
			back();
		} else if (pilihMenu.equals("8")) {
			kembaliBuku();
			System.out.println();
			back();
		}

		else if (pilihMenu.equals("9")) {
			System.out.print("Masukkan id buku : ");
			int idBook = in.nextInt();
			hapusBuku(idBook);
			back();
		} else if (pilihMenu.equals("10")) {
			System.out.print("Masukkan id member : ");
			int nama = in.nextInt();
			hapusMember(nama);
			back();
		} else {
			System.out.println("input yang anda berikan salah");
			System.out.println();
			menu();
		}
	}

	public static void main(String[] args) throws ParseException {
		loadBUku();
		loadMember();
		loadPinjam();
		System.out.println("Selamat Datang di Perpustakaan");
		menu();

	}
}