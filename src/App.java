import java.util.Arrays;
public class App {
    
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp;
                }
            }
        }
        System.out.println(nums);
    }

    public static int binarySearch(int[] nums, int key) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max)
        {
            int mid = min + ((max - min) / 2);
            if (key == nums[mid])
                return ++mid;
            else if (key < nums[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        int[] a = {5, 3, 7, 9, 3, 5};
        bubbleSort(a);
    } 
}
