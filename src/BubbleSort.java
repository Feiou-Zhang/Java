public class BubbleSort {
    public void bubbleSort(int[] nums){
        int len = nums.length;
        boolean sorted = false;
        int  k = 0;
        if(len > 1){
            while(!sorted){
                int i = 0, j = 1;
                while(j < len - k){
                    int swapTime = 0;
                    if(nums[i] > nums[j]){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        ++swapTime;
                    }
                    //if there is no swap happened in a round, that means the list is already sorted.
                    // len - k  = 2 : if you just compared the last round, the list also has been sorted.
                    if(j == len - k -1 && swapTime == 0 || len - k == 2){
                        sorted = true;
                    }
                    ++i;
                    ++j;
                }
                ++k;
            }
        }
    }
}
