package np.test.ru;

import java.util.ArrayList;

public class LineReader implements Reader {
    @Override
    public ArrayList<Query> process() {
        return null;
    }

    @Override
    public boolean test(){
        System.out.println("Please, specify numbers of query:");
        return true;
    }

    public LineReader(){

    }

}
