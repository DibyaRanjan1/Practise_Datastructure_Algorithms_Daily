package Graph;

public class AdjListNode {
   private int v;
   private int weight;

   public AdjListNode(int v,int weight){
       this.v = v;
       this.weight = weight;
   }
   public int getV(){
       return v;
   }
   public int getWeight(){
       return weight;
   }
}
