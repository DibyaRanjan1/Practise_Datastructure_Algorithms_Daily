package DisjointSet;

import java.util.*;

public class AccountMerge {

   public class DisjointSet{
        public List<Integer> parent;
        public List<Integer> size;
        public List<Integer> rank;

        public DisjointSet(int n){
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            this.rank = new ArrayList<>();

            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
                rank.add(1);
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)){
                return node;
            }

          int uParent =  findParent(parent.get(node));
            parent.set(node,uParent);
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);

            if(uParent == vParent) return;

            int uRank = rank.get(uParent);
            int vRank = rank.get(vParent);

            if (uRank<vRank){
                parent.set(uRank,vRank);
            } else if (vRank<uRank) {
                parent.set(vRank,uRank);
            }else {
                parent.set(vRank,uRank);
                rank.set(uRank,rank.get(uRank)+1);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      List<List<String>> result = new ArrayList<>();

        HashMap<String,Integer> mapEmail = new HashMap<>();

        int n = accounts.size();

        DisjointSet disjointSet = new DisjointSet(n);

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                 String mail = accounts.get(i).get(j);
                if(!mapEmail.containsKey(mail)){
                    mapEmail.put(mail,i);
                }else {
                    disjointSet.unionByRank(i,mapEmail.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedList = new ArrayList[n];

        for(int i=0;i<n;i++){
            mergedList[i] = new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> it: mapEmail.entrySet()){
            String key = it.getKey();
            int value = it.getValue();
            int ultimateParent = disjointSet.findParent(value);
            mergedList[ultimateParent].add(key);
        }

        for(int i=0;i<n;i++){
            if(mergedList[i].size()==0) continue;
            Collections.sort(mergedList[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedList[i]){
                temp.add(it);
            }
            result.add(temp);
        }
        return result;

    }
}
