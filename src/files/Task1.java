package files;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        File directory = new File("E:/folder");
        File[] arrFiles = directory.listFiles();
        List<File> lst = Arrays.asList(arrFiles);

        File[] folder1 = lst.get(0).listFiles();
        File[] folder2 = lst.get(1).listFiles();
        File[] folder3 = lst.get(2).listFiles();

        List<File> lst1 = Arrays.asList(folder1);
        List<File> lst2 = Arrays.asList(folder2);
        List<File> lst3 = Arrays.asList(folder3);

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(searchFile(string, lst1));
        System.out.println(searchFile(string, lst2));
        System.out.println(searchFile(string, lst3));




//        System.out.println(lst);
//        System.out.println(lst1);
//        System.out.println(lst2);
//        System.out.println(lst3);
    }
    static String searchFile(String s, List<File> lst){
        String result = "";
        for (File file : lst) {
            if(file.toString().contains(s))
            result+=file+"\n";
        }
        return result;
    }
}
