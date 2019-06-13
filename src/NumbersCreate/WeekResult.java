package NumbersCreate;

import java.util.Random;
import java.util.TreeSet;

public class WeekResult {
    private WeekResult nextWeekResult = null;
    private TreeSet<Integer> numbers;
    private TreeSet<Integer> superNumbers;

    public WeekResult() {
        Random rand = new Random();

        numbers = new TreeSet<>();
        while (numbers.size() < 5) {
            numbers.add(rand.nextInt(50) + 1);
        }

        superNumbers = new TreeSet<>();
        while (superNumbers.size() < 2) {
            superNumbers.add(rand.nextInt(10) + 1);
        }
    }

    public WeekResult(TreeSet<Integer> numbers, TreeSet<Integer> superNumbers) {
        this.numbers = numbers;
        this.superNumbers = superNumbers;
    }

    public TreeSet<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(TreeSet<Integer> numbers) {
        this.numbers = numbers;
    }

    public TreeSet<Integer> getSuperNumbers() {
        return superNumbers;
    }

    public void setSuperNumbers(TreeSet<Integer> superNumbers) {
        this.superNumbers = superNumbers;
    }

    public WeekResult getNextWeekResult() {
        return nextWeekResult;
    }

    public void setNextWeekResult(WeekResult nextWeekResult) {
        this.nextWeekResult = nextWeekResult;
    }

    public void printWeekResult() {
        for (int number : numbers) {
            System.out.printf("%5d", number);
        }
        System.out.print("\t\t");
        for (int superNumber : superNumbers) {
            System.out.printf("%5d", superNumber);
        }
    }
}
