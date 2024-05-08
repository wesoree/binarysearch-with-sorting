import java.util.Arrays;
public class App {
    
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int arr[], int start, int end) {
        if (start < end) { 
            int pIndex = partition(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }
    }   

    static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pivot);
                pIndex++;
            }
        }
        return pIndex;
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

    public static void searchSort(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("the number is located on spot " + binarySearch(arr, key));
    }

    public static void main(String[] args) throws Exception {
        int[] a = {5, 3, 7, 9, 3, 5, 2, 5, 3, 6, 12, 6, 3, 45, 100};
        int[] b = bubbleSort(a);
        String str = Arrays.toString(b);
        System.out.println(str);
        searchSort(a, 5);
    } 
}
