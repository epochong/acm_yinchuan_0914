import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/9/14 13:03
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class F2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
           int n = input.nextInt();
           int k = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                arr[arr.length - 1] = arr[arr.length - 1] - 1;
                Arrays.sort(arr);
                arr[0] += 1;
                Arrays.sort(arr);
                if (arr[arr.length - 1] - arr[0] <= 0) {
                    break;
                }
            }
            System.out.println(arr[arr.length - 1] - arr[0]);
        }
    }
}
