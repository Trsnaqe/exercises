
public class q7 {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 41) - 20;
        }
        int[] pOdd = positiveOdd(array);

    }
    public static int[] positiveOdd(int[] arr) {
        int[] result = new int[10];
        int resultIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] % 2 == 1) {
                result[resultIndex] = arr[i];
                resultIndex++;
            }
        }
        return result;
    }

}
