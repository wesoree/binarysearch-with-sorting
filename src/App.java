import java.util.Arrays;
public class App {
    public static int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n ; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static int binarySearch(int[] nums, int key) {
        nums = sort(nums);
        int min = 0;
        int max = nums.length - 1;
        while (min <= max)
        {
            int mid = (min + max) >> 1;
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
        int[] a = {5, 2, 4, 45, 2, 45, 2, 3};
        System.out.println(binarySearch(a, 2));
    }
}
