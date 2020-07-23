package solution.offer10_2;

public class NumWays {
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        if(n<=2){
            return n;
        }
        int answer=0, preOne=2, preTwo=1;
        for(int i=3;i<=n;i++)
        {
            answer=(preOne+preTwo)%1000000007;
            preTwo=preOne;
            preOne=answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        NumWays test=new NumWays();
        System.out.println(test.numWays(1));
        System.out.println(test.numWays(2));
        System.out.println(test.numWays(3));
        System.out.println(test.numWays(30));

    }
}
