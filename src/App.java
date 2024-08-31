import java.util.Arrays;

public class App {

    public static void selectionSort(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j])
                    minElementIndex = j;
            }
            if (minElementIndex != i)
                swap(arr, i, minElementIndex);
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void split(int[] arr) {
        if (arr.length < 2)
            return; // no need to sort
        int mid = arr.length / 2;
        int left[] = new int[mid];
        int right[] = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        for (int j = 0; j < arr.length - mid; j++)
            right[j] = arr[mid + j];
        split(left);
        split(right);
        merge(left, right, arr);
    }

    private static void merge(int[] a, int[] b, int[] all) {
        int i = 0, j = 0, k = 0;
        while ((i < a.length) && (j < b.length)) {
            if (a[i] < b[j]) {
                all[k] = a[i];
                i++;
            } else {
                all[k] = b[j];
                j++;
            }k++;
        }
        while (i < a.length)
            all[k++] = a[i++];
        while (j < b.length)
            all[k++] = b[j++]; 
    } 

    public static void quickSort(int[] arr, int i, int j){

        if (j <= i) return;

        int pivot = partition(arr, i, j);
        quickSort(arr, i, j - 1);
        quickSort(arr, pivot+1, j);
    }

    private static int partition(int[] arr, int i, int j){
        int pivot = arr[j];
        int k = i-1;

        for (int l=i; l<=j-1; l++){
            if (arr[l]<pivot){
                k++;
                swap(arr, k, l);
            }   
        }
        k++;
        swap(arr, k, j);
        return i;
    }

    public static int binarySearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = min + ((max - min) / 2);
            if (key == arr[mid])
                return mid;
            else if (key < arr[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        return -1;
    }

    public static void search(int[] arr, int key) {
        if (arr.length == 1) {
            System.out.println("the array is" + Arrays.toString(arr));
            if (arr[0] == key) {
                System.out.println(key + " found at index 0");
            }
            else{
                System.out.println(key + " was not found");
            }
            System.out.println("------------------------------------");
            return;
        }
        System.out.println("the unsorted array is:");
        System.out.println(Arrays.toString(arr));
        System.out.println("the sorted array is:");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int a = binarySearch(arr, key);
        if (a == -1)
            System.out.println(key +" was not found");
        else
            System.out.println(key + " found at index " + a);

        System.out.println("------------------------------------");
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int[] a = { 5, 3, 7, 9, 3, 5, 2, 5, 3, 6, 12, 6, 3, 45, 100 };
        int[] b = { 3, 5, 2, 4, 3 };
        int[] c = { 5, 2, 6, 2, 6, 1, 6, 2, 100, 30, -1, 4, -30, 20, 25, 104, 300, 2 };
        int[] d = { 1, 3, 3, 2 };
        int[] e = { 1 };
        int[] f = { 20 };
        search(a, 5);
        search(b, 3);
        search(a, 1);
        search(c, 100);
        search(d, 4);
        search(e, 1);
        search(f, 1);
        // System.out.println(fibonacci(10));
    }
}