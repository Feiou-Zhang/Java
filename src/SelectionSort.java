public class SelectionSort {
    public void selectionSort(int[] nums){
        int len = nums.length;
        if(len > 1){
            for(int i = 0; i < len-1; ++i){
                int tmp = i+1;
                int min = nums[tmp];
                for(int j = i+2; j < len; ++j){
                    if(nums[j] < min){
                        min = nums[j];
                        tmp = j;
                    }
                }
                if(min < nums[i]){
                    nums[tmp] = nums[i];
                    nums[i] = min;
                }
            }
        }
    }
}
