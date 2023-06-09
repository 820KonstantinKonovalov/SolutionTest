import np.test.ru.*;

import java.util.ArrayList;

public class NationalPlatform {
    public static void main(String[] args) {
        // Valid values of first arg: empty or 'path to file'
        Reader reader;
        PathFinder finder;
        ArrayList<String> paths = new ArrayList<>();

        //help info:
        System.out.println("");
        System.out.println("--------How to use this utility:-------");
        System.out.println(" There are two case to run application:");
        System.out.println("1 - without any parameters. ");
        System.out.println("Sorry about: only Latin letters in this mode");
        System.out.println("2 - with 'path to data-file'");
        System.out.println("as example(without parameter): $Dir>java - jar C:\\out\\NationalPlatform.jar ");
        System.out.println("with path to file: $Dir>java - jar C:\\out\\NationalPlatform.jar C:\\traning\\NationalPlatform\\Data\\test.txt");
        // -------------
        // PREPARATIONS:
        if (args.length > 0) {
            reader = new FileReader(args[0]);
        } else {
            reader = new LineReader();
        }
        // ----
        // WORK
        finder = new PathFinder(reader.process());
        paths = finder.calculatePath(reader.getCount());

        // ------------
        // SHOW RESULTS
        System.out.println("The result is:");
        for(String item: paths){
            System.out.print(item + " ");
        }
        System.out.println("");

    }
}
