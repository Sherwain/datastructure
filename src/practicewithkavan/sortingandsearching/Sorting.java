package practicewithkavan.sortingandsearching;

/**
 * Created with IntelliJ IDEA.
 * User: Sherwain
 * Date: 4/19/13
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sorting {
    public static void main(String[] args){
        int[] ary1 = {1, 76, 2, 32, 564, 76, 32};
        int[] ary2 = {1, 76, 2, 32, 564, 76, 32};
        int[] ary3 = {1, 76, 2, 32, 564, 76, 32};
        int[] ary4 = {4, 76, 2, 32, 564, 76, 32};
        int[] ary5 = {1, 6, 2, 3, 9, 43, 89, 30, 21, 42, 18, 25};
        int[] ary6 = {1, 6, 2, 3, 9, 43, 89, 30, 21, 42, 18, 25};
        int[] ary7 = {1, 6, 2, 3, 9, 43, 89, 30, 21, 42, 18, 25};
//        System.out.println("Before bubbleSort " + toString(ary1));
//        ary1 = bubbleSort(ary1);
//        System.out.println("After bubbleSort " + toString(ary1));
        System.out.println("Before insertionSort " + toString(ary6));
        ary2 = insertionSort1(ary6);
        System.out.println("After insertionSort " + toString(ary6));
        System.out.println("Before mergeSort " + toString(ary7));
        ary3 = mergeSort(ary7, 0, ary7.length);
        System.out.println("After mergeSort " + toString(ary7));
        System.out.println("Before selectionSort " + toString(ary4));
        ary4 = selectionSort(ary4);
        System.out.println("After selectionSort " + toString(ary4));
        System.out.println("Before quickSort " + toString(ary5));
        ary6 = quickSort1(ary6, 0, ary6.length-1);
        //quickSort(ary5, 0, ary5.length-1);
        System.out.println("After quickSort " + toString(ary6));
        //System.out.println(11/2);

//        System.out.println("Before bubbleSort " + toString(ary1));
//        ary1 = bubbleSort2(ary1);
//        System.out.println("After bubbleSort " + toString(ary1));

        System.out.println(10 +"th largest value: " +quickSort4(ary5, 0, ary5.length -1, 10));
    }

    @SuppressWarnings("unused")
	private static int[] bubbleSort(int[] ary1) {
        for(int x = 0; x < ary1.length; x++){
            for(int k = 0; k < ary1.length; k++){
                if (ary1[k] >  ary1[x]){
                    int temp = ary1[x];
                    ary1[x] = ary1[k];
                    ary1[k] = temp;
                }
            }
        }
        return ary1;
    }

    @SuppressWarnings("unused")
	private static int[] insertionSort(int[] ary2) {
        for (int i = 1; i < ary2.length; i++){
            if (ary2[i-1] > ary2[i]){
                int temp = ary2[i];
                for (int j = i; j > 0; j --){
                    if (ary2[j -1] > temp){
                        int temp2 = ary2[j-1];
                        ary2[j -1] = ary2[j];
                        ary2[j] = temp2;
                    }
                }
            }
        }
        return ary2;
    }

    private static int[] insertionSort1(int[] ary){
        for (int x = 1; x < ary.length; x ++){
            int temp = ary[x];
            int j = x;
            while (j > 0 && ary[j-1] >temp){
                ary[j] = ary[j-1];
                j--;
            }
            ary[j] = temp;
        }
        return ary;
    }

    private static int[] mergeSort(int[] ary, int first, int last) {
        int mid = (first + last)/2;
        if (last <= first){
            mergeSort(ary, first, mid);
            mergeSort(ary, mid + 1, last);
            ary = mergeSort(ary,first, mid, last);
        }
        return ary;
    }

    private static int[] mergeSort(int a[], int first, int mid, int last){
        int aux[] = new int[last];
        int i = first;
        int j = mid + 1;

        for (int x = first; x <= last; x++)
            aux[x] = a[x];
        for(int k = first; k < last; k ++){
            if (i > mid) aux[k] = a[j++];
            else if (j > last) aux[k] = a[i++];
            else{
                if (a[i] >= a[j])
                    aux[k] = a[i++];
                else
                    aux[k] = a[j++];
            }
        }
        return aux;
    }

    private static int[] quickSort1(int[] ary1, int left, int right) {
        if (left >= right)
            return ary1;
        int index = partition1(ary1, left, right);
        quickSort1(ary1, left, index - 1);
        quickSort1(ary1,index, right);
        return ary1;
    }

    private static int partition1(int[] ary, int left, int right){
        int j = right;
        int i = left;
        int pivot = ary[(left+right)/2];

        while(i <= j){

            while(ary[i] < pivot)
                i++;

            while(ary[j] > pivot)
                j--;

            if (i <= j){
                int temp = ary[i];
                ary[i] = ary[j];
                ary[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    private static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    private static int[] quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
        return arr;
    }

    private static int[] selectionSort(int[] ary) {
        int nextMinIndex = 0, k, x;
        for (x=0; x < ary.length - 1; x++){
            nextMinIndex = x;
            for (k = x + 1; k < ary.length; k++){
                if(ary[k] < ary[nextMinIndex])//swap
                    nextMinIndex = k;
            }
            if (nextMinIndex != x){
                int temp =  ary[x];
                ary[x] = ary[nextMinIndex];
                ary[nextMinIndex] = temp;
            }
        }
        return ary;
    }

    @SuppressWarnings("unused")
	private static int[] selectionSort1(int[] ary) {
        int nextMin;
        for (int x=0; x < ary.length - 1; x++){
            for (int k = x + 1; k < ary.length; k++){
                if(ary[k] < ary[x]){//swap
                    int temp =  ary[k];
                    ary[k] = ary[x];
                    ary[x] = temp;
                }
            }
        }
        return ary;
    }

    private static synchronized String toString(int[] arry) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < arry.length; i++) {
            sb.append(arry[i]);

            if (i == arry.length - 1)
                return sb.append('}').toString();
            sb.append(", ");
        }
        return sb.toString();
    }

    public static int[]  bubbleSort2(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return arr;
    }

    private static int quickSort4(int arr[], int left, int right, int nth) {
        int index = partition(arr, left, right);
        if (nth == index)
            return arr[index - 1];
        else if (nth < index)
            if (left < index - 1)
                quickSort4(arr, left, index - 1, nth);
        else if (nth > index)
            if (index < right)
                quickSort4(arr, index, right, nth);
        return arr[index - 1];
    }
}
