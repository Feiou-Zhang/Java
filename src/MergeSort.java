public class MergeSort {
    private void merge(int[] nums, int[] copy, int low, int mid, int high){
        int mid2 = mid + 1, k = low, left = low, length = high - low + 1;
        while(low <= mid && mid2 <= high){
            if(nums[low] <= nums[mid2])
                copy[k++] = nums[low++];
            else
                copy[k++] = nums[mid2++];
        }
        if(low <= mid)
            System.arraycopy(nums, low, copy, k, mid - low + 1);
        if(mid2 <= high)
            System.arraycopy(nums, mid2, copy, k, high - mid2 + 1);
        System.arraycopy(copy, left, nums, left, length);

    }
    public void sort(int[] nums){
        int len = nums.length;
        int[] copy = new int[len];
        for(int size = 1; size < len; size *= 2){
            for(int low = 0; low < len - size; low += size + size){
                int mid = low + size - 1;
                int high = Math.min(low + size + size - 1, len - 1);
                merge(nums, copy, low, mid, high);
            }
        }
    }
}



//    int[] nums = new int[]{3,1,7,2,5,4};
//    MergeSort ms = new MergeSort();
//    ms.sort(nums);
//    System.out.print(Arrays.toString(nums));