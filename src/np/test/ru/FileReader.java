package np.test.ru;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements Reader {
    private String path;
    @Override
    public ArrayList<Query> process() {

        ArrayList<Query> pairs = new ArrayList<>();

        try {
            if(!test()){
                String message = String.format("File/Path %s - doesn't exist.", path);
                throw new FileNotFoundException(message);
            }
            File file = new File(path);
            Scanner sc = new Scanner(file);
            int i = 0;
            int j = 0;

            String temp;
            int count = 0;


            // get count of queries:
            temp = sc.nextLine().stripTrailing();
            if(!temp.equals(null) && temp.matches("[0-9]+")) {
                count = Integer.parseInt(temp);
            }else {
                throw new NumberFormatException("Please, verify the number of queries: " + temp);
            }

            while (sc.hasNextLine() || count!=0) {
                // Query pairs getting:
                String[] pair = sc.nextLine().split(" ");
                pairs.add(new Query(pair[0], pair[1]));
                count --;
            }
            if(count != 0){
                throw new ArithmeticException ("The count number of query doesn't coincide with given lines");
            }
            sc.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return pairs;
    }

    public FileReader(String path){
        this.path = path;
    }

   private boolean test() {
       File f = new File(path);
       if (!f.exists() || f.isDirectory())
           return false;
       return true;
   }
}
