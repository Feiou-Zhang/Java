import javax.sound.midi.SysexMessage;
import java.util.*;

public class Coursera {
    public void sort(String[] names) {
        if (names == null || names.length < 2) {
            return;
        }
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                if (!s1[0].equals(s2[0])) {
                    return s1[0].compareTo(s2[0]);
                }
                //otherwise the first part is same
                return convertRomanToInt(s1[1]) - convertRomanToInt(s2[1]);
            }
        });

    }
    public int convertRomanToInt(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        int res = map.get(roman.charAt(roman.length() - 1));
        for (int i = roman.length() - 2; i >= 0; --i) {
            if (map.get(roman.charAt((i))) >= map.get(roman.charAt((i + 1)))) {
                res += map.get(roman.charAt((i)));
            } else {
                res -= map.get(roman.charAt((i)));
            }
        }
        return res;
    }
    public int minUniqueSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int n: nums) {
            min = Math.min(min, n);
        }
        for (int n: nums) {
            if (!set.add(n)) {
                while (set.contains(++min));
                set.add(min);
                res += min;
            } else {
                res += n;
            }
        }
        //System.out.print(set);
        return res;
    }
    public int nonDominatable(int[][] entities) {
        int res = 0;
        Arrays.sort(entities, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });
        for (int[] e: entities) {
            System.out.print(Arrays.toString(e));
        }
        int n = entities.length;
        int count = 0;
        int i = 0;
        while (i < n) {
            int j = n - 1;
            for (; j >= i; --j) {
                if (entities[i][0] < entities[j][0]) {
                    if (entities[i][1] < entities[j][1]) {
                        ++i;
                        break;
                    }
                } else {
                    count += j - i + 1;
                    i = j + 1;
                    break;
                }
            }
        }
        return count;
    }
    public int uniquePlaylist(int n, int l, int k) {
        int total = 1;
        for (int i = 1; i <= l; ++i) {
            if (i < k ) {
                total = total * (n - i);
            } else {
                total = total * (n - k);
            }
        }
        return total;
    }
    public String subset(String a) {
        List<String> res = new ArrayList<>();
        subsetHelper(a, res, 0, new StringBuilder());
        Collections.sort(res);
        return res.get(res.size() - 1);
    }
    public void subsetHelper(String a, List<String> res, int index, StringBuilder curr) {
        //if (index == a.length()) {
            res.add(curr.toString());
        //}
        for (int i = index; i < a.length(); ++i) {
            curr.append(a.charAt(i));
            subsetHelper(a, res, i + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
