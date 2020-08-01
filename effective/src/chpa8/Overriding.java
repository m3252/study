package chpa8;

import java.util.List;

public class Overriding {
    public static void main(String[] args){
        List<Wine> wineList= List.of(
                new Wine(), new SparklingWine(), new Champagne()
        );

        for(Wine wine : wineList){
            System.out.println(wine.name());
        }
    }
}

class Wine{
    String name (){ return "포도주"; }
}
class SparklingWine extends Wine{
    @Override
    String name(){
        return "스파클링 포도주";
    }
}
class Champagne extends SparklingWine{
    @Override
    String name() {
        return "샴페인";
    }
}
