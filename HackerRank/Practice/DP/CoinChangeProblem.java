

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    /**
     * Created by sdj on 28/8/16.
     *
     * https://www.hackerrank.com/challenges/coin-change
     */
    public class CoinChangeProblem {
        public static void main(String[] args) {
            List<Integer> coinList = new ArrayList<>();
            Scanner inputScanner = new Scanner(System.in);

            int n = inputScanner.nextInt();
            int m = inputScanner.nextInt();

            for(int i=0;i<m;i++){
                coinList.add(inputScanner.nextInt());
            }

            System.out.println(new CoinChangeProblem().coinCounter(coinList.toArray(),m,n));
        }

        public long coinCounter(Object S[],int m,int n){
           int [][]accumSum = new int[n+1][m];
            int countWithJ = 0;
            int countWithoutJ = 0;
            for(int i=0;i<m;i++){
                accumSum[0][i] = 1;
            }

            for(int i=1;i<=n;i++){
                for(int j=0;j<m;j++){
                    int checker = i-(Integer) S[j];
                    countWithJ = (checker>=0)?accumSum[checker][j]:0;
                    countWithoutJ = (j>0)?accumSum[i][j-1]:0;
                    accumSum[i][j] = countWithJ+countWithoutJ;
                }
            }

            return accumSum[n][m-1];
        }
    }
