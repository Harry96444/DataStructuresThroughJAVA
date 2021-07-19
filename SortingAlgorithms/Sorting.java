import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int a[] = {6,2,3,1,4,5,9,7,600,500,400,300,200,100,50,40,30,20,10,19,18,171,61,15,14,13,12,11,21,22,23,24,2,6,25};
        System.out.println("\nBubble Sort : ");
        bubble(a);
        System.out.println("\nInsertion Sort : ");
        insertion(a);
        System.out.println("\nSelection Sort : ");
        selection(a); 
        System.out.println("\nMerge Sort : ");
        System.out.println(Arrays.toString(merge(a, 0, a.length-1)));
        System.out.println("\nQuick Sort : "); 
        quickSort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
        System.out.println("\nHeap Sort : ");
        heapsort(a);
        System.out.println(Arrays.toString(a));    
    }
    
    public static void bubble(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[i]) {
                    swap(a, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void insertion(int a[]) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void selection(int a[]) {
        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
        System.out.println(Arrays.toString(a));
    }
    public static int[] merge(int a[],int l,int h) {
        
        if(l == h) {
            int [] ba = new int[1];
            ba[0] = a[l];
            return ba;
        }
        int mid = l + (h-l) /2;
        int fsh[] = merge(a,l,mid);
        int ssh[] = merge(a,mid+1,h);
        int fsa[] = mergeUtil(fsh,ssh);
        return fsa;
    }
    public static int[] mergeUtil(int arr1[], int arr2[]) {
        int a[] = new int[arr1.length + arr2.length];
        System.arraycopy(arr1,0,a,0,arr1.length);
        System.arraycopy(arr2,0,a,arr1.length,arr2.length);
        Arrays.sort(a);
        
        System.arraycopy(a,0,arr1,0,arr1.length);
        System.arraycopy(a,arr1.length,arr2,0,arr2.length);
        return a;
    }
    public static int quickUtil(int[] arr,int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
 
    for(int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            int c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }
        int c = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = c;
      return (i + 1);
  }
    public static void quickSort(int[] arr, int low, int high) {
    if (low < high)
    {
        int pi = quickUtil(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
} 
    public static void heapify(int arr[],int n,int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public static int[] heapsort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void swap(int arr[],int a,int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
