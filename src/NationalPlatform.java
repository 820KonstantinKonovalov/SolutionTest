import np.test.ru.*;

import java.util.ArrayList;

public class NationalPlatform {
    public static void main(String[] args) {
        // Valid values of first arg: empty or 'path to file'
        Reader reader;
        PathFinder finder;
        String firstArg = "";
        ArrayList<String> paths = new ArrayList<>();

        //help info:
        System.out.println("--------How to use this utility:-------");
        System.out.println(" There are two case to run application:");
        System.out.println("1 - without any parameters");
        System.out.println("2 - with 'path to data-file'");

        if (args.length > 0) {
            firstArg = args[0];
            reader = new FileReader(firstArg);
        } else {
            reader = new LineReader();
        }
        if (reader.test()) {
            finder = new PathFinder(reader.process());
            paths = finder.calculatePath();
        }

        for(String path: paths){
            System.out.println(path);
        }

    }
}
