import java.util.*;

public class Visa {
    public String mergeString (String s1, String s2) {
        //edge case
        if (s1 == null || s1.length() == 0) {
            return s2;
        }
        if (s2 == null || s2.length() == 0) {
            return s1;
        }
        int i = 0; //the start index for string 1
        int j = 0; //the start index for string 2
        char[] newString = new char[s1.length() + s2.length()];
        int k = -1;
        while (i < s1.length() && j < s2.length()) {
            newString[++k] = s1.charAt(i++);
            newString[++k] = s2.charAt(j++);
        }
        while (i < s1.length()) {
            newString[++k] = s1.charAt(i++);
        }
        while (j < s2.length()) {
            newString[++k] = s2.charAt(j++);
        }
        return new String(newString);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        long product = 1L;
        for (int left = 0, right = 0; right < nums.length; ++right) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            //there will be window size of qualified answers
            count += (right - left + 1);
        }
        return count;
    }
    public long minAmount (int[] prices) {
        //edge case, valid input
        if (prices == null || prices.length == 0) {
            return 0;
        }
        long result = prices[0];
        long min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                result += (prices[i] - min);
            }
        }
        return result;
    }
    public String[] missingwords (String s1, String s2) {
        //edge case, valid input
        if (s1 == null || s1.length() == 0) {
            return null;
        }
        String[] words1 = s1.split(" +");
        if (s2 == null || s2.length() == 0) {
            return words1;
        }
        String[] words2 = s2.split(" +");
        List<String> result = new ArrayList<>();

        for (int i = 0, j = 0; i < words1.length; ++i) {
            if (j == words2.length) {
                while (i < words1.length) {
                    result.add(words1[i]);
                    i++;
                }
                return result.toArray(new String[result.size()]);
            }
            if (words1[i].equals(words2[j])) {
                ++j;
            } else {
                result.add(words1[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    public int divde (int a, int b) {
        int c = -1;
        try {
            c = a / b;
        }
        catch (Exception e) {
            System.out.print("exc");
        }
        finally {
            System.out.print("Fina");
        }
        return c;
    }
    public int minmoves (int[] a, int[] b) {
        //edge case
        if (a == null || a.length == 0) {
            return 0;
        }
        int min = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == b[i]) {
                continue;
            }
            int num1 = a[i];
            int num2 = b[i];
            while (num1 != 0 || num2 != 0) {
                min += Math.abs((num1 % 10) - (num2 % 10));
                num1 /= 10;
                num2 /= 10;
            }
        }
        return min;
    }
    public long doubleSize (long[] a, long b) {
        long res = b;
        Set<Long> set = new HashSet<>();
        for (long l: a) {
            set.add(l);
        }
        while (set.contains(res)) {
            res *= 2;
        }
        return res;
    }
    public String canReach (int x1, int y1, int x2, int y2) {
        if (canReachHelper(x1, y1, x2 , y2)) {
            return "yes";
        } else {
            return "no";
        }
    }
    public boolean canReachHelper (int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return true;
        }
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        return canReachHelper(x1 + y1, y1, x2, y2) || canReachHelper(x1, x1 + y1, x2, y2);
    }
    public String rollingString (String s, int left, int right, char direction) {
        //edge case, valid input
        if (s == null || s.length() == 0 || left < 0 || right >= s.length()) {
            return s;
        }
        char[] c = s.toCharArray();
        if (direction == 'L') {
            while (left <= right) {
                if (c[left] == 'a') {
                    c[left] = 'z';
                } else {
                    --c[left];
                }
                ++left;
            }
        } else if (direction == 'R') {
            while (left <= right) {
                if (c[left] == 'z') {
                    c[left] = 'a';
                } else {
                    ++c[left];
                }
                ++left;
            }
        }
        return new String(c);
    }
    public int derangement (int[] a) {
        //edge case, valid input
        if (a == null || a.length < 2) {
            return 0;
        }
        int[] ways = new int[a.length + 1];
        ways[2] = 1;
        for (int i = 3; i <= a.length; ++i) {
            ways[i] = (i - 1) * (ways[i - 1] + ways[i - 2]);
        }
        return ways[a.length];
    }

    public int findDerangement(int n) {
        if (n < 2) {
            return 0;
        }
        long[] ways = new long[n + 1];
        ways[2] = 1;
        for (int i = 3; i <= n; ++i) {
            ways[i] = (i - 1) * (ways[i - 1] + ways[i - 2]) % 1000000007;
        }
        return (int)ways[n];
    }
    //O(1) space
    public int findDerangement2(int n) {
        if (n < 2) {
            return 0;
        }
        long withoutOne = 1;
        long withoutTwo = 0;
        long result = 1;
        for (int i = 3; i <= n; ++i) {
            result = (i - 1) * (withoutOne + withoutTwo) % 1000000007;
            withoutTwo = withoutOne;
            withoutOne = result;
        }
        return (int)result;
    }
    public int moveoneandzero(int[] a) {
        //edge case
        if (a == null || a.length < 3) {
            return 0;
        }
        return Math.min(moveoneandzeroHelper(a, 1, 0), moveoneandzeroHelper(a, 0, 1));

    }
    public int moveoneandzeroHelper(int[] a, int target, int other) {
        int sum = 0;
        int count = 0;
        int i = 0;
        while (i < a.length && a[i] == target){
            ++i;
        }
        for (; i < a.length; ++i) {
            if (a[i] == target) {
                sum += i;
                ++count;
            }
        }
        for (int j = 0; j < a.length; ++j) {
            if (a[j] == other) {
                sum -= j;
                if(--count == 0){
                    break;
                }
            }
        }
        return Math.abs(sum);
    }
}
