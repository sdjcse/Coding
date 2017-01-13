

import java.util.*;

/**
 *
 * https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/little-monk-and-the-matchmaker/
 *
 * Created by sdj on 1/11/17.
 */

// Comparator to compare map entries based on values
class ValueComparator implements Comparator<Integer> {
    Map<Integer, Integer> base;

    public ValueComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(Integer a, Integer b) {
        if (base.get(a) <= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

public class MatchFinder
{
    public static String topMatch(Map<Integer,String> inpMap,int k)
    {
        String inp = "littlejhool";
        Map<Integer,Integer> workingMap = new HashMap<>();
        StringBuffer out = new StringBuffer();
        int n = 0;
        String temp1,temp2;

        for (Map.Entry<Integer, String> entry : inpMap.entrySet()) {
            temp1 = removeDuplicate(inp);
            temp2 = removeDuplicate(entry.getValue().toLowerCase());
            workingMap.put(entry.getKey(),lcsTwoString(temp1,temp2));
        }
        ValueComparator temp = new ValueComparator(workingMap);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<>(temp);
        sortedMap.putAll(workingMap);
        int sortVal = sortedMap.firstEntry().getValue();
        List<Integer> finList = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if(sortVal == entry.getValue())
            {
                keyList.add(entry.getKey());
            }else if(keyList.size() < k)
            {
                Collections.sort(keyList);
                finList.addAll(keyList);
                keyList.clear();
                sortVal = entry.getValue();
                keyList.add(entry.getKey());
            }else {
                break;
            }

        }
        Collections.sort(keyList);
        finList.addAll(keyList);
        int i = 0;
        while (k > 0) {
            k--;
            out.append(inpMap.get(finList.get(i)) + " ");
            i++;
        }
        return out.toString();
    }
    private static String removeDuplicate(String s)
    {
        StringBuffer out = new StringBuffer();
        Set<Character> charSet = new TreeSet<>();
        for(char c : s.toCharArray())
        {
            charSet.add(c);
        }
        for(char c : charSet)
        {
            out.append(c);
        }
        return out.toString();
    }
    public static void main(String[] args)
    {
        Map<Integer,String> inpMap = new HashMap<>();
        List<String> out = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int tot=0,top=0;
        int iter = 0;
        while(n>0)
        {
            tot = input.nextInt();
            top = input.nextInt();
            iter = 0 ;
            while(tot > 0)
            {
                inpMap.put(iter,input.next());
                iter++;
                tot--;
            }
            out.add(topMatch(inpMap,top));
            inpMap.clear();
            n--;
        }
        for(String s : out)
        {
            System.out.println(s);
        }
    }

    public static int lcsTwoString(String s1,String s2)
    {
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int common = 0;
        int [][] mat = new int[c1.length+1][c2.length+1];
        for(int i = 0 ; i < c1.length+1 ; i++)
        {
            for(int j=0 ; j < c2.length+1 ; j++)
            {
                mat[i][j] = 0;
            }
        }
        for(int i = 1 ; i < c1.length+1 ; i++)
        {
            for(int j = 1 ; j < c2.length+1 ; j++)
            {
                mat[i][j] += (s1.charAt(i-1) == s2.charAt(j-1)) ? mat[i-1][j-1]+1 : Math.max(mat[i-1][j],mat[i][j-1]);
            }
        }
        return  mat[c1.length][c2.length];
    }
}
