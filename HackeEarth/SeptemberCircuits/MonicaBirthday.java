import java.util.*;

/**
 * Created by sdj on 9/18/16.
 *
 * https://www.hackerearth.com/september-circuits/approximate/monicas-birthday-party/
 */
public class MonicaBirthday {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c1 = input.nextInt(),c2 = input.nextInt();

        int dislikeArr[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dislikeArr[i][j] = input.nextInt();
            }
        }
        Set<Integer> tab1 = new TreeSet<>();
        Set<Integer> tab2 = null;

        createPartition(tab1,tab2,dislikeArr,c1,c2,n);

        Iterator iter = tab1.iterator();
        System.out.println(tab1.size());
        while(iter.hasNext()){
            System.out.print(((Integer) iter.next()+1) + " ");
        }
    }

    public static void createPartition(Set<Integer> tab1,Set<Integer> tab2,int [][] dislikeArr,int c1
    , int c2,int n){
        List<Integer> averageOfFriends = new ArrayList<>();
        List<Integer> firstTab = new ArrayList<>();
        List<Integer> secondTab = new ArrayList<>();

        int sumAver = 0;
        for(int i=0;i<n;i++){
            sumAver = 0;
            for(int j=0;j<n;j++){
                sumAver += dislikeArr[i][j];
            }
            averageOfFriends.add(i,sumAver);
        }
        int avertedGuy = Collections.max(averageOfFriends);
        int avertedGuyIndex = averageOfFriends.indexOf(avertedGuy);

        int friendlyGuy = Collections.min(averageOfFriends);
        int friendlyGuyIndex = averageOfFriends.indexOf(friendlyGuy);

        if(c1<c2){
            firstTab.add(avertedGuyIndex);
            secondTab.add(friendlyGuyIndex);
        }else{
            secondTab.add(avertedGuyIndex);
            firstTab.add(friendlyGuyIndex);
        }

        int tab1Val = 0,tab2Val = 0;

        for(int i=0;i<n;i++){
            if(i==avertedGuyIndex || i==friendlyGuyIndex){
                continue;
            }

            int sumOfFriendly = 0,sumOfAverted = 0;
            for(int j=0;j<firstTab.size();j++){
                sumOfFriendly += dislikeArr[i][firstTab.get(j)];
            }
            for(int j=0;j<secondTab.size();j++){
                sumOfAverted += dislikeArr[i][secondTab.get(j)];
            }

            if((sumOfFriendly<sumOfAverted && firstTab.size()<c1)
                    || (firstTab.size() < c1 && secondTab.size()==c2)){
                firstTab.add(i);
            }else if ((sumOfFriendly>=sumOfAverted && secondTab.size()<c2)
                    || (secondTab.size()<c2 && firstTab.size() == c1)){
                secondTab.add(i);
            }
        }
        tab1.addAll(firstTab);
    }
}
