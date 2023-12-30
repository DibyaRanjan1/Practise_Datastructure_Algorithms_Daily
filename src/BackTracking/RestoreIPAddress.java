package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
       RestoreIPAddress r = new RestoreIPAddress();
       r.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        if(s.length() > 12) return result;
        backtrack(0,s,"",0,result);
             return result;
    }

    private void backtrack(int index,String s,String ipchunk, int dots, List<String> result){

        if(dots ==4 && index == s.length()){
            result.add(ipchunk.substring(0,ipchunk.length()-1));
            return;
        }

        if(dots >4) return;

        for(int j=index;j< Math.min(index+3,s.length());j++){

            if(Integer.parseInt(s.substring(index,j+1)) < 256 && (index==j || s.charAt(index)!='0')){
                backtrack(j+1,s,ipchunk+ s.substring(index,j+1)+".",dots+1,result);
            }
        }
    }
}
