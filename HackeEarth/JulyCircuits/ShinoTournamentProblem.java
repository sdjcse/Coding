import java.util.*;

/**
 * Created by sdj on 28/7/16.
 *
 *Hacker earth problem: https://www.hackerearth.com/july-circuits/algorithm/little-shino-and-the-tournament/
 */
public class ShinoTournamentProblem {

    public ShinoTournamentProblem(){
    }

    public static void main(String [] args){
        Scanner inputScanner = new Scanner(System.in);
        int n=0,q=0;
        n = inputScanner.nextInt();
        q = inputScanner.nextInt();
        Queue<Integer> strengthInputQueue = new LinkedList<Integer>();
        Map<Integer,Integer> strengthInput = new HashMap<Integer,Integer>();
        ArrayList<Integer> numberOfFigths = new ArrayList<Integer>();
        ArrayList<Integer> queryInput = new ArrayList<Integer>(q);

        for(int i=1;i<=n;i++){
            strengthInput.put(i,inputScanner.nextInt());
            strengthInputQueue.add(i);
            numberOfFigths.add(0);
        }
        numberOfFigths.add(0);
        strengthInputQueue.add(0);
        for(int i=1;i<=q;i++){
            queryInput.add(inputScanner.nextInt());
        }

        new ShinoTournamentProblem().computeFigths(strengthInputQueue,strengthInput,numberOfFigths);
        for(int i:queryInput){
            System.out.println(numberOfFigths.get(i));
        }
    }

    public void computeFigths(Queue<Integer> strengthInputQueue,Map<Integer,Integer> strengthInput, ArrayList<Integer> numberofFights){
        int firstCompetitor,secondCompetitor;
        while(!strengthInputQueue.isEmpty()){
            // Even case
            if(strengthInputQueue.peek() == 0){
                strengthInputQueue.remove();
                continue;
            }
            firstCompetitor = strengthInputQueue.remove();

            // Odd case
            if(strengthInputQueue.peek() == null )
            {
                continue;
            } else if(strengthInputQueue.peek() == 0){
                strengthInputQueue.add(firstCompetitor);
                strengthInputQueue.add(0);
                continue;
            }
            secondCompetitor = strengthInputQueue.remove();
            if(strengthInput.get(firstCompetitor) > strengthInput.get(secondCompetitor)){
                strengthInputQueue.add(firstCompetitor);
            }else{
                strengthInputQueue.add(secondCompetitor);
            }
            incrementFight(firstCompetitor,numberofFights);
            incrementFight(secondCompetitor,numberofFights);
        }
    }

    private int incrementFight(int i,ArrayList<Integer> numberofFights){
        int setNum = numberofFights.get(i);
        setNum++;
        return numberofFights.set(i,setNum);
    }
}

