package chap8;

import java.util.Date;

public class DefensiveRadiant {

    public static void main(String[] args){
        //내부 공격
        Date start = new Date();
        Date end = new Date();

        // Date 가변인수는 취약하다
        Period p = new Period(start, end);
        end.setYear(78);

        // 내부로 접근하여 공격할 수단이 남아있다.
        DefensivePeriod p2 = new DefensivePeriod(start, end);
        p2.end().setYear(78);

        // 공격할 수단이 없다.
        PerfectDefensivePeriod p3 = new PerfectDefensivePeriod(start, end);
        p3.end().setYear(78);



        System.out.println(p.start() + "///" + p.end());
        System.out.println(p2.start() + "///" + p2.end());
        System.out.println(p3.start() + "///" + p3.end());
    }

}

final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + " 보다 늦어");
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

}

final class DefensivePeriod {
    private final Date start;
    private final Date end;

    public DefensivePeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0){
            throw new IllegalArgumentException(start + "가 " + end + " 보다 늦어");
        }
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }
}

final class PerfectDefensivePeriod {
    private final Date start;
    private final Date end;

    public PerfectDefensivePeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0){
            throw new IllegalArgumentException(start + "가 " + end + " 보다 늦어");
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}