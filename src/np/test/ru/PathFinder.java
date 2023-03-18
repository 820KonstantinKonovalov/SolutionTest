package np.test.ru;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PathFinder{
    private ArrayList<Query> paths;
    public PathFinder(ArrayList<Query> queries){
        paths = queries;
    }
     public ArrayList<String> calculatePath(int count){

         ArrayList<String> resultPath = new ArrayList<>();

         //So, what do we have:
         System.out.println("Data:");
         for(Query  item: paths){
             System.out.println(item.getFrom() + "-" + item.getTo());
         }
         // ************************************************************************************
         // MAIN WORK IS HERE (all around this place is an Africa, but we need only bananas :-):
         // after this operation we will get unique values (exist only in From or To, not both!)
         // according to task only two items must be in uniqueItems (as possible validation)
         List<String> flatList = paths.stream()
                .flatMap(l->Arrays.stream(l.getEdge()))
                .collect(Collectors.toList());

         List<String> uniqueItems = flatList
                 .stream()
                 .filter(QueryEdge -> Collections.frequency(flatList, QueryEdge) == 1)
                 .collect(Collectors.toList());

         //Constructing the rout:
         Map<String, String> tmpSet = paths
                 .stream()
                 .collect(Collectors.toMap(Query::getFrom, Query::getTo));

         // start point
         String nextKey = "";
         // two items cycle (start, destination) - we need start.
         for(String item: uniqueItems){
             if(tmpSet.containsKey(item)){
                 resultPath.add(item);
                 nextKey = tmpSet.get(item);
                 break;
             }
         }
         while(count > 1) {
             if(tmpSet.containsKey(nextKey)){
                 resultPath.add(nextKey);
                 nextKey = tmpSet.get(nextKey);
                 count--;
                 // don't forget the last element:
                 if(count==1) resultPath.add(nextKey);
             }else{
                 // possible unexpected situation:
                 break;
             }
         }
        return resultPath;
     }
}
