package np.test.ru;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements Reader {
    private String path;

    private int count;

    @Override
    public int getCount() {
        return count;
    }

    public FileReader(String path) {
        this.path = path;
        count = 0;
    }

    @Override
    public ArrayList<Query> process() {

        ArrayList<Query> pairs = new ArrayList<>();

        try {
            if(!test()) {
                String message = String.format("File/Path %s - doesn't exist.", path);
                throw new FileNotFoundException(message);
            }
            File file = new File(path);
            Scanner sc = new Scanner(file);
            String temp;

            // get count of queries:
            temp = sc.nextLine().stripTrailing();
            if(!temp.equals(null) && temp.matches("[0-9]+")) {
                this.count = Integer.parseInt(temp);
            } else {
                throw new NumberFormatException("Please, verify the number of queries: " + temp);
            }
            // *********************
            // General work is here:
            // *********************
            while (sc.hasNextLine()) {
                // Query pairs getting:
                String[] pair = sc.nextLine().split(" ");
                pairs.add(new Query(pair[0], pair[1]));
            }
            sc.close();

        }catch (Exception e){
            e.printStackTrace();
        }
       /* for(Query item: pairs){
            System.out.println(item);
        } */
        return pairs;
    }

    private boolean test() {
       File file = new File(path);
       if (!file.exists() || file.isDirectory()) return false;
       return true;
   }
}
