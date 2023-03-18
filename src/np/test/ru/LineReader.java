package np.test.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LineReader implements Reader {

    private int count = 0;

    @Override
    public int getCount(){
        return count;
    }
    @Override
    public ArrayList<Query> process() {
        ArrayList<Query> pairs = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please, specify numbers of query:");
            count = Integer.parseInt(br.readLine());
            int i = 1;
            System.out.println("To exit from entering mode, type ^X");

            // *********************
            // General work is here:
            // *********************
            while(true){
                String inputMessage = String.format("Enter %d query pair 'From' 'To' :", i);
                System.out.println(inputMessage);
                String[] pair = br.readLine().split(" ");

                if(pair[0].equalsIgnoreCase("^X")) break;

                pairs.add(new Query(pair[0], pair[1]));
                i++;
            }

        } catch(NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pairs;
    }


}
