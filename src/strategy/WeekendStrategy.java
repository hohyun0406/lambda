package strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

enum WeekendStrategy {
    MONDAY("1", i->"MONDAY"),
    TUESDAY("2", i->"TUESDAY"),
    WEDNESDAY("3", i->"WEDNESDAY"),
    THURSDAY("4", i->"THURSDAY"),
    FRIDAY("5", i->"FRIDAY"),
    SATURDAY("6", i->"SATURDAY"),
    SUNDAY("7", i->"SUNDAY"),
    ERORR("x", i->"Exit");

    private final String name;
    private final Function<String, String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }


    public static String execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String s = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(s))
                .findAny().orElseGet(() -> ERORR)
                .function.apply(s);
    }

}
