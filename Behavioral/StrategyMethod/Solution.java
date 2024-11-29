package Behavioral.StrategyMethod;

// The strategy method allows us to define a family of algorithms, encapsulate
// each one of them and make them interchangeable. This pattern lets the algorithm
// vary independently from the clients and use it.

// Lets consider a sorting algorithm where we need to sort a list of integers. However, the sorting
// algorithm used may vary depending upon the factors such as the size of the list and the desired 
// performance characteristics.

// Sorting context
class SortingContext {
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}

// Sorting strategy interface
interface SortingStrategy {
    void sort(int[] array);
}

// Bubble sort strategy: concrete implementation
class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using BUBBLE SORT");
    }

}

// Quick sort strategy: concrete implementation
class QuickSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using QUICK SORT");
    }

}

public class Solution {

    // client code
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 9, 1, 7 };

        SortingContext sortingContextBubble = new SortingContext(new BubbleSortStrategy());
        sortingContextBubble.performSort(arr);

        SortingContext sortingContextQuick = new SortingContext(new QuickSortStrategy());
        sortingContextQuick.performSort(arr);
    }

}
