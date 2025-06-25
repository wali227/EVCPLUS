
import java.util.Scanner;

public class EVC {
    //Haraaga Evcplus
    static float Haraaga = 600.0f;
    // Array lagu keydinaayo waree jimaha udambeeyey
    static int[] lastTransfers = new int[5];
    static int transferIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int password, option;
        // Biloowga Evcplus
        System.out.println("KUSO DHAWOOW EVCPLUS:");
        System.out.print("Gali lambarka sirta ah: ");
        password = scanner.nextInt();
        //Hubinta passwordka
        if (password == 1199) {
            showMainMenu();
            option = scanner.nextInt();
            processOption(option, scanner);
        } else {
            System.out.println("Password-ka waa khalad.");
        }
    }
    //Menu-ga ugu weyn
    static void showMainMenu() {
        System.out.println("\n1. Itus Haraaga");
        System.out.println("2. Kaarka hadalka");
        System.out.println("3. Bixi Biil");
        System.out.println("4. U wareeji EVCPlus");
        System.out.println("5. Warbixin Kooban");
        System.out.println("6. Salaam Bank");
        System.out.println("7. Maareynta");
        System.out.println("8. Bill Payment");
        System.out.print("Dooro ikhtiyaarkaaga: ");
    }
    // Doorashada Isticmaalaha
    static void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                showBalance();
                break;
            case 2:
                rechargeAirtime(scanner);
                break;
            case 3:
                payBill(scanner);
                break;
            case 4:
                transferEVC(scanner);
                break;
            case 5:
                showReport(scanner);
                break;
            case 6:
                transferToBank(scanner);
                break;
            case 7:
                manageSettings(scanner);
                break;
            case 8:
                payUtilities(scanner);
                break;
            default:
                System.out.println("Doorasho khaldan.");
        }
    }
    // 1:Function ku tusaya haraaga
    static void showBalance() {
        System.out.println("Haraagagu waa $" + Haraaga);
    }


    //2: Qeybta kaararka Hadalka
    static void rechargeAirtime(Scanner scanner) {
        System.out.println("Kaarka Hadalka");
        System.out.println("1. Ku Shubo Airtime");
        System.out.println("2. Ugu Shub Airtime");
        System.out.println("3. MIFI Packages");
        System.out.println("4. Ku shubo Internet");
        System.out.println("5. Ugu shub qof kale (MMT)");
        System.out.print("Dooro ikhtiyaarkaaga: ");

        int subOption = scanner.nextInt();
        int amount, number;

        switch (subOption) {
            case 1:
                System.out.print("Gali lacagta aad rabto in aad isugu shubto: ");
                amount = scanner.nextInt();
                if (Haraaga >= amount) {
                    Haraaga -= amount;
                    System.out.println("Waad isugu shubtay $" + amount + ". Haraagaaga hadda waa $" + Haraaga);
                } else {
                    System.out.println("Haraagagu kuma filna.");
                }
                break;

            case 2:
                System.out.print("Gali lambarka qofka aad ugu shubayso: ");
                number = scanner.nextInt();
                System.out.print("Gali lacagta: ");
                amount = scanner.nextInt();
                if (Haraaga >= amount) {
                    Haraaga -= amount;
                    System.out.println("Waxaad $" + amount + " ugu shubtay qofka 252" + number + ". Haraagaga waa $" + Haraaga);
                } else {
                    System.out.println("Haraagagu kuma filna.");
                }
                break;

            case 3:
                System.out.println("1. 5GB - $5\n2. 10GB - $9\n3. 20GB - $17");
                int mifiOption = scanner.nextInt();
                if (mifiOption == 1 && Haraaga >= 5) {
                    Haraaga -= 5;
                    System.out.println("Waxaad iibsatey 5GB MIFI. Haraagaaga waa $" + Haraaga);
                } else if (mifiOption == 2 && Haraaga >= 9) {
                    Haraaga -= 9;
                    System.out.println("Waxaad iibsatey 10GB MIFI. Haraagaaga waa $" + Haraaga);
                } else if (mifiOption == 3 && Haraaga >= 17) {
                    Haraaga -= 17;
                    System.out.println("Waxaad iibsatey 20GB MIFI. Haraagaaga waa $" + Haraaga);
                } else {
                    System.out.println("Haraagagu kuma filna ama doorasho khaldan.");
                }
                break;

            case 4:
                System.out.print("Gali lacagta aad rabto in aad ku shubto Internet: ");
                amount = scanner.nextInt();
                if (Haraaga >= amount) {
                    Haraaga -= amount;
                    System.out.println("Waxaad internet ku shubtay $" + amount + ". Haraagaaga waa $" + Haraaga);
                } else {
                    System.out.println("Haraagagu kuma filna.");
                }
                break;

            case 5:
                System.out.print("Gali lambarka qofka kale (MMT): ");
                number = scanner.nextInt();
                System.out.print("Gali lacagta: ");
                amount = scanner.nextInt();
                if (Haraaga >= amount) {
                    Haraaga -= amount;
                    System.out.println("Waxaad $" + amount + " ugu shubtay qof kale (MMT): 252" + number + ". Haraagaga waa $" + Haraaga);
                } else {
                    System.out.println("Haraagagu kuma filna.");
                }
                break;

            default:
                System.out.println("Doorasho aan sax ahayn.");
        }
    }

    // 3:Bixinta Biilasha
    static void payBill(Scanner scanner) {
        System.out.println("1. Bixi biil Koronto");
        System.out.println("2. Bixi biil Biyo");
        System.out.println("3. Bixi biil Internet");
        int subOption = scanner.nextInt();

        System.out.print("Gali lambarka adeegga: ");
        int number = scanner.nextInt();
        System.out.print("Gali lacagta: ");
        int amount = scanner.nextInt();

        if (Haraaga >= amount) {
            Haraaga -= amount;
            System.out.println("Waxaad $" + amount + " ugu shubtay adeegga lambarka " + number + ". Haraaga cusub waa $" + Haraaga);
        } else {
            System.out.println("Haraagagu kuma filna.");
        }
    }
    //4:Qeybta Wareejinta lacagta
    static void transferEVC(Scanner scanner) {
        System.out.print("Gali lambarka aad u wareejinayso: ");
        int number = scanner.nextInt();
        System.out.print("Gali lacagta: ");
        int amount = scanner.nextInt();

        if (Haraaga >= amount) {
            Haraaga -= amount;
            saveTransfer(amount);
            System.out.println("Waxaad $" + amount + " u wareejisay 252" + number + ". Haraagagu waa $" + Haraaga);
        } else {
            System.out.println("Haraagagu kuma filna.");
        }
    }

    static void saveTransfer(int amount) {
        if (transferIndex < lastTransfers.length) {
            lastTransfers[transferIndex++] = amount;
        } else {
            for (int i = 1; i < lastTransfers.length; i++) {
                lastTransfers[i - 1] = lastTransfers[i];
            }
            lastTransfers[lastTransfers.length - 1] = amount;
        }
    }
    // 5:Warbixinta kooban meesha ay ku jirto
    static void showReport(Scanner scanner) {
        System.out.println("1. Last Action");
        System.out.println("2. Wareejintii u dambaysay");
        System.out.println("3. Iibsashadii u dambeysay");
        System.out.println("4. Last 3 Actions");
        System.out.println("5. Email Me My Activity");
        int subOption = scanner.nextInt();

        switch (subOption) {
            case 1:
                if (transferIndex > 0) {
                    System.out.println("$" + lastTransfers[transferIndex - 1] + " u wareejisay 252615947659 - 10/6/2025 08:00PM");
                } else {
                    System.out.println("Ma jiro wax last action ah.");
                }
                break;

            case 2:
                if (transferIndex > 0) {
                    System.out.println("Wareejintii u dambaysay: $" + lastTransfers[transferIndex - 1]);
                } else {
                    System.out.println("Ma jiro wax wareejin ah oo hore.");
                }
                break;

            case 3:
                System.out.println("Iibsashadii u dambeysay: Kaarka hadalka $10 - 20/06/2025");
                break;

            case 4:
                System.out.println("3-dii fal ee ugu dambeysay:");
                int count = Math.min(transferIndex, 3);
                if (count == 0) {
                    System.out.println("Ma jiro wax fal ah.");
                } else {
                    for (int i = transferIndex - count; i < transferIndex; i++) {
                        System.out.println("- $" + lastTransfers[i]);
                    }
                }
                break;

            case 5:
                System.out.println("Warbixintaada waxaa loo soo diray email-kaaga: hassan@example.com");
                System.out.println("✓ Last Action: $" + (transferIndex > 0 ? lastTransfers[transferIndex - 1] : 0));
                System.out.println("✓ Iibsashadii ugu dambeysay: $10");
                System.out.println("✓ Wareejintii ugu dambeysay: $" + (transferIndex > 0 ? lastTransfers[transferIndex - 1] : 0));
                break;

            default:
                System.out.println("Doorasho aan sax ahayn.");
        }
    }
    // 6:Meesha ay ku jirto Salaam Bank
    static void transferToBank(Scanner scanner) {
        System.out.println("Salaam Bank");
        System.out.println("1. Itus Haraaga");
        System.out.println("2. Lacag dhigasho");
        System.out.println("3. Lacag qaadasho");
        System.out.println("4. Ka Wareeji EVCPlus");
        System.out.print("Dooro ikhtiyaarkaaga: ");
        int subOption = scanner.nextInt();

        switch (subOption) {
            case 1:
                System.out.println("Haraaga Salaam Bank waa: $320");
                break;
            case 2:
                System.out.print("Gali lacagta aad dhigeyso: ");
                int deposit = scanner.nextInt();
                System.out.println("Waxaad dhigatay $" + deposit + " Salaam Bank.");
                break;
            case 3:
                System.out.print("Gali lacagta aad rabto inaad qaadato: ");
                int withdraw = scanner.nextInt();
                System.out.println("Waad qaaday $" + withdraw + " Salaam Bank.");
                break;
            case 4:
                System.out.print("Gali lacagta aad ka wareejinayso EVCPLUS: ");
                int amount = scanner.nextInt();
                if (Haraaga >= amount) {
                    Haraaga -= amount;
                    System.out.println("Waxaad $" + amount + " ka wareejisay EVCPLUS kuna shubtay Salaam Bank.");
                } else {
                    System.out.println("Haraagagu kuma filna.");
                }
                break;
            default:
                System.out.println("Doorasho aan sax ahayn.");
        }
    }
    //7: Qeybta maareynta
    static void manageSettings(Scanner scanner) {
        System.out.println("1. Badel lambarka sirta ah");
        System.out.println("2. Badel luqadda");
        System.out.println("3. Wargelin Mobile Lumay");
        System.out.println("4. Lacag Xirasho");
        System.out.println("5. U celi lacag qaldantay");
        int subOption = scanner.nextInt();

        switch (subOption) {
            case 1:
                System.out.print("Gali password cusub: ");
                int newPass = scanner.nextInt();
                System.out.println("Password waa la bedelay.");
                break;
            case 2:
                System.out.println("Luqadda waa la bedelay.");
                break;
            case 3:
                System.out.println("Fadlan tag xarunta ugu dhow si aad u wargeliso mobile lumay.");
                break;
            case 4:
                System.out.println("Lacagtaada waa la xiray si ku meel gaar ah.");
                break;
            case 5:
                System.out.println("Lacagta qaldantay waa la celin doonaa haddii ay suurtagal tahay.");
                break;
            default:
                System.out.println("Doorasho aan sax ahayn.");
        }
    }

    // 8:Qeybta bill-payment
    static void payUtilities(Scanner scanner) {
        System.out.println("1. Electricity");
        System.out.println("2. Internet");
        System.out.println("3. Cable TV");
        int subOption = scanner.nextInt();

        System.out.print("Gali lambarka adeegga: ");
        int number = scanner.nextInt();
        System.out.print("Gali lacagta: ");
        int amount = scanner.nextInt();

        if (Haraaga >= amount) {
            Haraaga -= amount;
            System.out.println("Waxaad bixisay $" + amount + " adeegga lambarka " + number + ". Haraagaga waa $" + Haraaga);
        } else {
            System.out.println("Haraagagu kuma filna.");
        }
    }
}


