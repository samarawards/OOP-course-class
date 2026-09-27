package BankSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bankCentral = new Bank();

        // Data awal untuk mempermudah eksplorasi langsung
        bankCentral.addCustomer("Mark", "Lee");
        bankCentral.getCustomer(0).setAccount(new Account(500000.0));

        boolean running = true;

        System.out.println("==================================================");
        System.out.println("      SELAMAT DATANG DI SISTEM ATM & BANKING      ");
        System.out.println("==================================================");

        while (running) {
            System.out.println("\n---------------- MENU UTAMA ATM ------------------");
            System.out.println("1. Lihat Daftar Nasabah");
            System.out.println("2. Tambah Nasabah Baru");
            System.out.println("3. Buka Rekening Baru untuk Nasabah");
            System.out.println("4. Cek Saldo Rekening");
            System.out.println("5. Setor Tunai / Deposit");
            System.out.println("6. Tarik Tunai / Withdraw");
            System.out.println("7. Simulasi BankAccount Mandiri");
            System.out.println("8. Jalankan Demo ArrayList (BankAccountArrayBeraksi)");
            System.out.println("0. Keluar");
            System.out.println("--------------------------------------------------");
            System.out.print("Pilih menu [0-8]: ");

            String input = scanner.nextLine().replace("\uFEFF", "").trim();
            if (input.isEmpty()) {
                continue;
            }

            switch (input) {
                case "1":
                    tampilkanDaftarNasabah(bankCentral);
                    break;

                case "2":
                    System.out.println("\n--- Tambah Nasabah Baru ---");
                    System.out.print("Masukkan nama depan: ");
                    String fName = scanner.nextLine().trim();
                    System.out.print("Masukkan nama belakang: ");
                    String lName = scanner.nextLine().trim();

                    if (!fName.isEmpty() && !lName.isEmpty()) {
                        bankCentral.addCustomer(fName, lName);
                        int idBaru = bankCentral.getNumOfCustomers() - 1;
                        System.out.println(">> Sukses! Nasabah berhasil ditambahkan dengan ID Indeks: " + idBaru);
                    } else {
                        System.out.println(">> Nama tidak boleh kosong.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Buka Rekening Baru ---");
                    Customer custUntukBukaRek = pilihNasabah(bankCentral, scanner);
                    if (custUntukBukaRek != null) {
                        if (custUntukBukaRek.getNumOfAccounts() >= 5) {
                            System.out.println(">> Nasabah ini sudah mencapai batas maksimal 5 rekening.");
                            break;
                        }
                        System.out.print("Masukkan setoran saldo awal: Rp ");
                        try {
                            double saldoAwal = Double.parseDouble(scanner.nextLine().trim());
                            if (saldoAwal < 0) {
                                System.out.println(">> Saldo awal tidak boleh negatif.");
                            } else {
                                custUntukBukaRek.setAccount(new Account(saldoAwal));
                                System.out.println(">> Rekening baru berhasil dibuat untuk "
                                        + custUntukBukaRek.getFirstName() + " " + custUntukBukaRek.getLastName()
                                        + " dengan saldo Rp " + saldoAwal);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(">> Input nominal tidak valid.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("\n--- Cek Saldo ATM ---");
                    Account accCek = pilihAkunNasabah(bankCentral, scanner);
                    if (accCek != null) {
                        System.out.println(">> Saldo saat ini: Rp " + accCek.getBalance());
                    }
                    break;

                case "5":
                    System.out.println("\n--- Setor Tunai (Deposit) ---");
                    Account accDep = pilihAkunNasabah(bankCentral, scanner);
                    if (accDep != null) {
                        System.out.print("Masukkan nominal setor tunai: Rp ");
                        try {
                            double nominalDep = Double.parseDouble(scanner.nextLine().trim());
                            boolean sukses = accDep.deposit(nominalDep);
                            if (sukses) {
                                System.out.println(">> Setor tunai berhasil!");
                                System.out.println(">> Saldo terbaru: Rp " + accDep.getBalance());
                            } else {
                                System.out.println(">> Gagal: Nominal setor harus lebih dari 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(">> Input nominal tidak valid.");
                        }
                    }
                    break;

                case "6":
                    System.out.println("\n--- Tarik Tunai (Withdraw) ---");
                    Account accWd = pilihAkunNasabah(bankCentral, scanner);
                    if (accWd != null) {
                        System.out.println("Saldo saat ini: Rp " + accWd.getBalance());
                        System.out.print("Masukkan nominal tarik tunai: Rp ");
                        try {
                            double nominalWd = Double.parseDouble(scanner.nextLine().trim());
                            boolean sukses = accWd.withdraw(nominalWd);
                            if (sukses) {
                                System.out.println(">> Tarik tunai berhasil! Silakan ambil uang Anda.");
                                System.out.println(">> Sisa saldo Anda: Rp " + accWd.getBalance());
                            } else {
                                System.out.println(">> Gagal: Saldo tidak mencukupi untuk melakukan penarikan.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(">> Input nominal tidak valid.");
                        }
                    }
                    break;

                case "7":
                    jalankanSimulasiBankAccount(scanner);
                    break;

                case "8":
                    System.out.println("\n--- Menjalankan Demo BankAccountArrayBeraksi ---");
                    BankAccountArrayBeraksi.main(args);
                    break;

                case "0":
                    running = false;
                    System.out.println("\n==================================================");
                    System.out.println("   Terima kasih telah menggunakan sistem ATM!    ");
                    System.out.println("==================================================");
                    break;

                default:
                    System.out.println(">> Pilihan menu tidak valid. Silakan pilih 0-8.");
                    break;
            }
        }

        scanner.close();
    }

    // Menampilkan seluruh nasabah dalam array Bank
    private static void tampilkanDaftarNasabah(Bank bank) {
        int total = bank.getNumOfCustomers();
        System.out.println("\n--- Daftar Nasabah di Bank (Total: " + total + ") ---");
        if (total == 0) {
            System.out.println(">> Belum ada nasabah terdaftar.");
            return;
        }

        for (int i = 0; i < total; i++) {
            Customer c = bank.getCustomer(i);
            System.out.println("[" + i + "] " + c.getFirstName() + " " + c.getLastName()
                    + " | Jumlah Rekening: " + c.getNumOfAccounts());
        }
    }

    // Membantu user memilih nasabah dari array Bank
    private static Customer pilihNasabah(Bank bank, Scanner scanner) {
        if (bank.getNumOfCustomers() == 0) {
            System.out.println(">> Belum ada nasabah di bank. Silakan tambah nasabah terlebih dahulu.");
            return null;
        }

        tampilkanDaftarNasabah(bank);
        System.out.print("Pilih indeks nasabah: ");
        try {
            int idx = Integer.parseInt(scanner.nextLine().trim());
            if (idx >= 0 && idx < bank.getNumOfCustomers()) {
                return bank.getCustomer(idx);
            } else {
                System.out.println(">> Indeks nasabah tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println(">> Input indeks harus berupa angka bulat.");
        }
        return null;
    }

    // Membantu user memilih rekening dari nasabah terpilih
    private static Account pilihAkunNasabah(Bank bank, Scanner scanner) {
        Customer cust = pilihNasabah(bank, scanner);
        if (cust == null) return null;

        if (cust.getNumOfAccounts() == 0) {
            System.out.println(">> Nasabah " + cust.getFirstName() + " belum memiliki rekening (Account). Buka rekening terlebih dahulu di menu 3.");
            return null;
        }

        if (cust.getNumOfAccounts() == 1) {
            return cust.getAccount(0);
        }

        // Jika nasabah memiliki lebih dari 1 rekening dalam array
        System.out.println("\nDaftar Rekening " + cust.getFirstName() + ":");
        for (int i = 0; i < cust.getNumOfAccounts(); i++) {
            System.out.println("  [" + i + "] Saldo: Rp " + cust.getAccount(i).getBalance());
        }
        System.out.print("Pilih indeks rekening: ");
        try {
            int accIdx = Integer.parseInt(scanner.nextLine().trim());
            if (accIdx >= 0 && accIdx < cust.getNumOfAccounts()) {
                return cust.getAccount(accIdx);
            } else {
                System.out.println(">> Indeks rekening tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println(">> Input indeks harus berupa angka bulat.");
        }
        return null;
    }

    // Simulasi interaktif untuk class BankAccount mandiri
    private static void jalankanSimulasiBankAccount(Scanner scanner) {
        System.out.println("\n--- Simulasi BankAccount (Class Mandiri) ---");
        System.out.print("Masukkan nomor rekening baru: ");
        try {
            int noRek = Integer.parseInt(scanner.nextLine().trim());
            BankAccount standalone = new BankAccount(noRek);
            System.out.println(">> BankAccount dibuat dengan No Rekening: " + standalone.getAccountNumber());
            System.out.println(">> Saldo Awal: Rp " + standalone.getBalance());

            System.out.print("Masukkan nominal deposit: Rp ");
            double dep = Double.parseDouble(scanner.nextLine().trim());
            standalone.deposit(dep);
            System.out.println(">> Saldo setelah deposit: Rp " + standalone.getBalance());

            System.out.print("Masukkan nominal penarikan: Rp ");
            double wd = Double.parseDouble(scanner.nextLine().trim());
            standalone.withdraw(wd);
            System.out.println(">> Saldo setelah penarikan: Rp " + standalone.getBalance());
        } catch (NumberFormatException e) {
            System.out.println(">> Input angka tidak valid.");
        }
    }
}
