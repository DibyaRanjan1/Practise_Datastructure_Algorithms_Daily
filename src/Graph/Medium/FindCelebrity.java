package Graph.Medium;

public class FindCelebrity {

    int totalCandidateNumber;
    public int findCelebrity(int n) {

    this.totalCandidateNumber = n;
    int candidate=0;

    for(int i=1;i<n;i++){
        if(knows(candidate,i)){
            candidate =i;
        }
    }

    if(isCelebrity(candidate)){
        return candidate;
    }

    return -1;

    }

    private boolean isCelebrity(int i){
        for(int j=0;j<totalCandidateNumber;j++){
            if(i==j) continue;
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

    private boolean knows(int a , int b){
        return true;
    }
}
