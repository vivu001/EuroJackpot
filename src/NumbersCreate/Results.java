package NumbersCreate;

public class Results {
    private WeekResult oldestResult;
    private WeekResult latestResult;
    private int count = 0;

    public Results() {
        this.oldestResult = this.latestResult = null;
    }

    public WeekResult getOldestResult() {
        return oldestResult;
    }

    public void setOldestResult(WeekResult newResult) {
        this.oldestResult = newResult;
    }

    public WeekResult getLatestResult() {
        return latestResult;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isEmpty() {
        return this.latestResult == null;
    }

    public void addResult(WeekResult newResult) {
        if (this.latestResult == null) {
            this.oldestResult = newResult;
        } else {
            if (count == 15) {
                WeekResult oldestResultCopy = new WeekResult();
                oldestResultCopy.setNextWeekResult(this.oldestResult.getNextWeekResult());
                this.oldestResult.setNextWeekResult(null);

                this.setOldestResult(oldestResultCopy.getNextWeekResult());
                oldestResultCopy.setNextWeekResult(null);
                count--;
            }
            this.latestResult.setNextWeekResult(newResult);
        }

        this.latestResult = newResult;
        count++;
    }

    public void clearResults() {
        if (this.latestResult != null) {
            this.oldestResult = this.latestResult = null;
            System.out.println("Clear all results successfully !!!");
        } else {
            System.out.println("There is no result to clear!!!");
        }
    }

    public void printAllResults() {
        if (this.latestResult != null) {
            WeekResult zeiger = oldestResult;
            while (zeiger != null) {
                zeiger.printWeekResult();
                System.out.println();
                zeiger = zeiger.getNextWeekResult();
            }
        } else {
            System.out.println("There is no result to show !!!");
        }
    }
}





