import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{8,0};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(nums);
        System.out.print(Arrays.toString(nums));
    }
}
