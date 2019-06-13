package NumbersCreate;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            menu.showMenu();
            System.out.println("Choose: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menu.createResults();
                    break;
                case 2:
                    menu.createRandomResults();
                    break;
                case 3:
                    menu.printAllResults();
                    break;
                case 4:
                    menu.showFrequency();
                    break;
                case 5:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Choose a number between 1 and 50: ");
                    menu.showFrequency(scanner.nextInt());
                    break;
                case 6:
                    menu.printMostFrequentNumbers();
                    break;
                case 7:
                    menu.addNewResult();
                    break;
                case 8:
                    System.out.println("------------------------ GOOD BYE !!! ------------------------");
                    System.exit(0);
            }
        }
    }
}
