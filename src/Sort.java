public class Sort {
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
    public void insertionSort(int[] nums){
        int len = nums.length;
        if(len > 1){
            for(int i = 1; i < len; ++i){
                for(int j = i-1; j >= 0; --j){
                    if(nums[j+1] < nums[j]){
                        int tmp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }
    }
    public void sort(int[] a) {
        //edge case
        if(a == null || a.length < 2) {
            return;
        }
        quicksort(a, 0, a.length - 1);

    }
    public void quicksort(int[] a, int lo, int hi) {
        if (lo >=  hi) {
            return;
        }
        int partitionPoint = partition(a, lo, hi);
        quicksort(a, lo, partitionPoint - 1);
        quicksort(a, partitionPoint + 1, hi);
    }
    public int partition(int[] a, int lo, int hi) {
        int pivot = a[(hi - lo) / 2 + lo];
        while (lo <= lo) {
            while (a[lo] < pivot) {
                ++lo;
            }
            while (a[hi] > pivot) {
                --hi;
            }
            if (lo <= hi) {
                swap(a, lo, hi);
                ++lo;
                --hi;
            }
        }
        return lo; //or hi
    }
    public void swap (int[] a, int lo, int hi) {
        int tem = a[lo];
        a[lo] = a[hi];
        a[hi] = tem;
    }
}
