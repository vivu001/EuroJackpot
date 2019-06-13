package NumbersCreate;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    private Results results;
    private Statistic statistic;

    public Menu() {
        results = new Results();
        statistic = new Statistic(results);
    }

    public void showMenu() {
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("1. Get real results\n" +
                "2. Create random results\n" +
                "3. Show all results\n" +
                "4. Frequency of all numbers\n" +
                "5. Frequency of a number\n" +
                "6. Show the most frequent number(s)\n" +
                "7. Add a new result\n" +
                "8. Exit");
    }

    // convert an array to a set
    public TreeSet<Integer> arrayToSet(Integer array[]) {
        return new TreeSet<>(Arrays.asList(array));
    }

    // Option 1: create manual results
    public void createResults() {
        if (!results.isEmpty()) {
            results.clearResults();
        }
        Integer[][] numbersResults =
                {
                        {7, 16, 18, 19, 24}, {4, 29, 30, 31, 45}, {1, 2, 11, 19, 47}, {15, 20, 24, 44, 49}, {4, 9, 15, 24, 42},
                        {22, 31, 43, 44, 50}, {14, 16, 21, 30, 37}, {18, 21, 37, 43, 47}, {1, 6, 11, 17, 38}, {3, 9, 10, 19, 42},
                        {5, 7, 15, 19, 29}, {20, 27, 33, 35, 46}, {8, 26, 38, 47, 50}, {10, 12, 35, 36, 43}, {7, 8, 20, 35, 38}
                };

        Integer[][] superNumbersResults =
                {
                        {1, 6}, {1, 7}, {2, 7}, {7, 9}, {8, 9},
                        {1, 9}, {4, 8}, {1, 3}, {4, 8}, {1, 7},
                        {3, 8}, {5, 9}, {3, 7}, {2, 5}, {5, 9}
                };

        for (int i = 0; i < 15; i++) {
            TreeSet<Integer> numbers = arrayToSet(numbersResults[i]);
            TreeSet<Integer> superNumbers = arrayToSet(superNumbersResults[i]);
            results.addResult(new WeekResult(numbers, superNumbers));
        }
        results.setCount(15);
        printAllResults();
    }

    // Option 2: create random results
    public void createRandomResults() {
        if (!results.isEmpty()) {
            results.clearResults();
        }
        int[] weeks = new int[15];
        for (int i = 0; i < weeks.length; i++) {
            results.addResult(new WeekResult());
        }
        results.setCount(15);
        printAllResults();
    }

    // Option 3: print all of results
    public void printAllResults() {
        results.printAllResults();
    }

    // Option 4: print frequency of all numbers
    public void showFrequency() {
        System.out.println("FREQUENCY OF ALL NUMBERS :\n");
        statistic.showRepeatedAllNumbers();
    }

    // Option 5: print frequency of a number
    public void showFrequency(int num) {
        System.out.println("The number " + num + " has appeared " + statistic.countRepeatedNumber(num) + " times");
    }

    // Option 6: print the most frequent number(s)
    public void printMostFrequentNumbers() {
        statistic.showMostFrequentNumbers();
    }

    // Option 7: Add a new week result
    public void addNewResult() {
        Scanner sc = new Scanner(System.in);
        Integer[] numbers = {0, 0, 0, 0, 0};
        Integer[] superNumbers = {0, 0};

        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                numbers[i] = sc.nextInt();
            } else {
                superNumbers[i - 5] = sc.nextInt();
            }
        }

        results.addResult(new WeekResult(arrayToSet(numbers), arrayToSet(superNumbers)));
    }
}
