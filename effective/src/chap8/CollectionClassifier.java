package chap8;

import java.util.*;

public class CollectionClassifier {

    public static String classify(Set<?> s){
        return "집합";
    }
    public static String classify(List<?> l){
        return "리스트";
    }
    public static String classify(Collection<?> c){
        return  c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }

    public static void main(String[] args){
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()
        };
        for(Collection<?> c : collections){
            System.out.println(classify(c));
        }
    }

}
