import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author epochong
 * @date 2019/9/14 12:12
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class F {
    public static void main(String[] args) {
        class Node {
            int val;
            int index;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
        class AscComparator implements Comparator <Node> {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                }
                return o1.index - o2.index;
            }
        }
        Scanner input = new Scanner(System.in);;
        while (input.hasNextInt()) {
            int n = input.nextInt();
            int k = input.nextInt();
            TreeSet<Node> set = new TreeSet <>(new AscComparator());
            for (int i = 0; i < n; i++) {
                set.add(new Node(input.nextInt(),i));
            }

            for (int i = 0; i < k ; i++) {
                Node last = set.pollLast();
                set.add(new Node(last.val - 1,last.index));
                Node first = set.pollFirst();
                set.add(new Node(first.val + 1,first.index));
            }
            if (n == 1) {
                System.out.println(0);
            } else {
                System.out.println(set.last().val - set.first().val);
            }
        }
    }
}
