import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{-2, 0,14,-3,-2};
        SelectionSort bs = new SelectionSort();
        bs.selectionSort(nums);
        System.out.print(Arrays.toString(nums));
    }
}
