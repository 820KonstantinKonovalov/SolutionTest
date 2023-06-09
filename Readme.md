Пояснения:

 Собственно, сам алгоритм поиска пути находится в файле PathFinder.java 
метод - public ArrayList<String> **calculatePath**(int count). Он состоит
из двух частей. Первая - ищем начало и конец пути; вторая - проходим по
данным и формируем путь (результат).
 Находим начало и конец пути. Два 'stream' (в стеке C#  - lambda) 
выражения:

         List<String> flatList = paths.stream()
                .flatMap(l->Arrays.stream(l.getEdge()))
                .toList();

         List<String> uniqueItems = flatList
                 .stream()
                 .filter(QueryEdge -> Collections.frequency(flatList, QueryEdge) == 1)
                 .toList();

Далее, выбираем начало:

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

и проходим по исходным данным:

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
Сложность поиска начала/конца пути **O(n log n)** - фактически это два вложенных цикла.
Сложность постороения самого пути **O(1)** - чтение по ключу из map. 
Используемая память как минимум в два раза больше входных данных. 

   
