import java.util.*;

/**
 * @author epochong
 * @date 2019/9/14 14:47
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class H {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        class Node {
            String name;
            int val;

            public Node(String name, int val) {
                this.name = name;
                this.val = val;
            }
        }
        class AscComparator implements Comparator<Node> {

            @Override
            public int compare(Node o1, Node o2) {
                if (o2.val > o1.val) {
                    return 1;
                } else if (o2.val < o1.val) {
                    return -1;
                }
                return o1.name.compareTo(o2.name);
            }
        }
        class Count {
            char c;
            int times;

            public Count(char c, int times) {
                this.c = c;
                this.times = times;
            }
        }
        class AscCount implements Comparator<Count> {

            @Override
            public int compare(Count o1, Count o2) {
                if (o1.times > o2.times) {
                    return 1;
                } else if (o1.times < o2.times) {
                    return -1;
                }
                return o1.c - o2.c;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A2345");
        HashMap<String,Integer> map = new HashMap <>();
        map.put("A2345",1234500);
        map.put("23456",7891000);
        map.put("34567",7891000);
        map.put("45678",7891000);
        map.put("56789",7891000);
        map.put("678910",7891000);
        map.put("78910J",7891000);
        map.put("8910JQ",8910000);
        map.put("910JQK",9100000);
        map.put("10JQKA",10000000);
        HashMap<Character,Integer> map1 = new HashMap <>();
        map1.put('A',1);
        map1.put('J',11);
        map1.put('Q',12);
        map1.put('K',13);
        for (int i = 2; i < 10; i++) {
            map1.put((char) ('0' + i),i);
        }
        map1.put('1',10);
        map1.put('0',0);
        TreeSet<Node> set = new TreeSet<>(new AscComparator());
        while (input.hasNextInt()) {
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                String name = input.next();
                String pok = input.next();
                if (map.containsKey(pok)) {
                    set.add(new Node(name,map.get(pok)));
                } else {
                    for (int j = 0; j < pok.length() - 1; j++) {
                        HashMap<Character,Integer> temMap = new HashMap <>() ;
                        if (temMap.containsKey(pok.charAt(i))) {
                            temMap.put(pok.charAt(i),map.get(pok.charAt(i)));
                        } else {
                            temMap.put(pok.charAt(i),1);
                        }
                        if (temMap.containsValue(4)) {
                            for (Character c:
                                 temMap.keySet()) {
                                if (temMap.get(c) == 4) {
                                    set.add(new Node(name,map1.get(c) * 100000 + 30000));
                                }
                            }
                        } else if (temMap.containsValue(3) && temMap.containsValue(2)) {
                            for (Character c :
                                    temMap.keySet()) {
                                if (temMap.get(c) == 3) {
                                    set.add(new Node(name,map.get(c) * 10000 + 3000));
                                }
                            }
                        } else if (temMap.containsValue(3)) {
                            for (Character c :
                                    temMap.keySet()) {
                                if (temMap.get(c) == 3) {
                                    set.add(new Node(name,map1.get(c) * 1000 + 300));
                                }
                            }
                        } else if (temMap.containsValue(2)) {
                            for (Character c :
                                    temMap.keySet()) {
                                    if (temMap.get(c) == 2) {
                                        set.add(new Node(name,map1.get(c) * 100));
                                    }
                                }
                        } else {
                            int sum = 0;
                            for (int k = 0; k < pok.length(); k++) {
                                sum += map1.get(pok.charAt(k));
                            }
                            set.add(new Node(name,sum));
                        }
                    }
                }
            }
            for (Node node :
                    set) {
                System.out.println(node.name);
            }
        }
    }
}
