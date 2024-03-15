package Revision.BackTrack.DP.MCIM;

public class EvaluateBooleanExpression {
    public static void main(String[] args) {

    }

    public static int evaluateExp(String exp) {
        return evaluateExp_recur(0,exp.length()-1,true,exp);
    }

    private static int evaluateExp_recur(int i, int j, boolean isTrue,String exp){
        if(i>j) return 0;
        if(i==j){
            if(isTrue){
                if(exp.charAt(i) == 'T') return 1;
                return 0;
            }
            if(exp.charAt(i)=='F') return 1;
            return 0;
        }

        int ans =0;
        for(int k=i+1;k<=j-1;k=k+2){

            int lt = evaluateExp_recur(i,k-1,true,exp);
            int lf = evaluateExp_recur(i,k-1,false,exp);
            int rt = evaluateExp_recur(k+1,j,true,exp);
            int rf = evaluateExp_recur(k+1,j,false,exp);

            if(exp.charAt(k)=='&'){
                if(isTrue){
                    ans = ans + (lt *rt);
                }else {
                    ans = ans+ (lt*rf) + (lf*rt) + (lf*rf);
                }
            } else if (exp.charAt(k)=='|') {
                if(isTrue){
                    ans = ans+ (lt*rt)+(lt*rf)+(lf*rt);
                }else {
                    ans = ans + (lf*rf);
                }
            } else if (exp.charAt(k)=='^') {
                if(isTrue){
                    ans = ans + (lf*rt) + (lt*rf);
                }else {
                    ans = ans + (lt*rt) + (lf*rf);
                }
            }
        }
        return ans;
    }
}
