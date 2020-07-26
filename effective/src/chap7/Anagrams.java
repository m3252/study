package chap7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagrams {
    public static void main(String[] args){

        String[] fileVar = new String[2];
        fileVar[0] = "\\Users\\moon_\\study\\";
        fileVar[1] = "2";

        File dictionary = new File(fileVar[0]);
        int minGroupSzie = Integer.parseInt(fileVar[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner scan = new Scanner(dictionary)){
            while(scan.hasNext()){
                String world = scan.next();
                groups.computeIfAbsent(alphabetize(world),
                        (unused) -> new TreeSet<>()).add(world);
            }

            for(Set<String> group : groups.values()){
                if(group.size() >= minGroupSzie)
                    System.out.println(group.size() + ": " + group);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String alphabetize(String scan){
        char[] a = scan.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

}
