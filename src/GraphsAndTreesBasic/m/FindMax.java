package GraphsAndTreesBasic.m;

/**
 * Created by hnastevska on 7/21/2017.
 */
public class FindMax {
    public static int method(int arr[]) {
        int first, second;
        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }

        for (int i = 2; i < arr.length; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

        return (first + second);
    }
    static int[] findMax(int N, int[] numbers) {

        int sum = Integer.MIN_VALUE;
        int s = 0;
        int[]  nums = new int[2];
        for (int i = 0; i <numbers.length ; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                s = numbers[i]+numbers[j];
                if (sum < s){
                    sum = s;
                    if (i < j){
                        nums[0]= i;
                        nums[1]=j;
                    }else{
                        nums[0]= j;
                        nums[1]=i;
                    }

                }
            }

        }


        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {15, 1973, 7873, 6276, 8197, 3429, 6746, 4163, 7454, 554, 996, 859, 69, 7908, 1517, 7408};
        int[] bla = findMax(arr.length, arr);
        System.out.println(bla[0]);
        System.out.println(bla[1]);
        System.out.println(method(arr));

    }
}
