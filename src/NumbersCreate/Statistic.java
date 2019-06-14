package NumbersCreate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistic {
    private Results results;

    public Statistic(Results results) {
        this.results = results;
    }

    // count frequency of all numbers appear as results
    public Map<Integer, Integer> countRepeatedAllNumbers() {
        Map<Integer, Integer> repeatedNumbers = new HashMap<>();
        for (int i = 1; i <= 50; i++) {
            repeatedNumbers.put(i, countRepeatedNumber(i));
        }

        return repeatedNumbers;
    }

    // show all numbers appear as results with frequency
    public void showRepeatedAllNumbers() {
        int breakLine = 0;
        Map<Integer, Integer> map = countRepeatedAllNumbers();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%2d : %2d\t\t", entry.getKey(), entry.getValue());
            if (++breakLine % 5 == 0) {
                System.out.println();
            }
        }
    }

    // count frequency of a number appears as results
    public int countRepeatedNumber(int n) {
        int count = 0;

        WeekResult zeiger = results.getOldestResult();
        while (zeiger != null) {
            if (zeiger.getNumbers().contains(n)) {
                count++;
            }
            if (zeiger.getSuperNumbers().contains(n)) {
                count++;
            }
            zeiger = zeiger.getNextWeekResult();
        }

        return count;
    }

    // calculate ratio of all numbers
    public Map<Integer, Double> calcRatio() {
        Map<Integer, Double> ratios = new HashMap<>();
        for (int i = 1; i <= 50; i++) {
            double ratio = (double) countRepeatedNumber(i) / (this.results.getCount() * 7);
            ratios.put(i, ratio * 100);
        }

        return ratios;
    }

    // show all numbers appear as results and sort by value with ratio
    public void showRatio() {
        int breakLine = 0;

        final Map<Integer, Double> sortedMap = calcRatio()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<Integer, Double> entry : sortedMap.entrySet()) {
            System.out.printf("%2d : %.2f %c \t\t", entry.getKey(), entry.getValue(), '%');
            if (++breakLine % 5 == 0) {
                System.out.println();
            }
        }
    }

    // find the most frequent number(s) in results
    public Map<Integer, Integer> mostFrequentNumbers() {
        Map<Integer, Integer> result = new HashMap<>();
        Map.Entry<Integer, Integer> maxEntry = null;
        Map<Integer, Integer> map = countRepeatedAllNumbers();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxEntry.getValue())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    // show the most frequent number(s) in results
    public void showMostFrequentNumbers() {
        Map<Integer, Integer> map = mostFrequentNumbers();
        System.out.print("THE MOST FREQUENT NUMBER(S) :");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%2d (%d times) %n", entry.getKey(), entry.getValue());
        }
    }
}
