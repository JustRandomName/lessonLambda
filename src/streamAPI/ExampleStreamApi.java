package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStreamApi {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("QWERTY");
        strings.add("AAAAAA");
        strings.add("BBBBBB");
        strings.add("CCCCCC");

        //найти все строки которые начинаются с буквы а.

        for (String str : strings) {
            if (str.startsWith("A")) {
                System.out.println("I found this string!!! " + str);
            }
        }

        Predicate<String> predicate = str -> str.startsWith("AA");

        System.out.println("\n\n STREAM API FILTER()");
        //создаем стрим из иссходной коллекции
        strings.stream()
                // фильтруем наш стрим базируясь на предикате определенном в самом filter
                .filter(predicate)
                // перебор стрима для вывода на консоль
                .forEach(str -> System.out.println("I found this using Stream API!!! " + str));

        System.out.println("\n\n STREAM API MAP()");
        //создаем стрим из иссходной коллекции
        strings.stream()
                // преобразовать каждый эл-т коллекции в x + "1"
                .map(str -> str + "1")
                // перебор стрима для вывода на консоль
                .forEach(str -> System.out.println("I add \"1\" to each element using Stream API!!! " + str));


        //Превратить список в FOO SECOND, отфильровать value > 50. Достать только первый элемент из полученного результата
        System.out.println("\n\n STREAM API MAP() FROM FOOFORST TO FOOSECOND");
        List<FooFirst> fooFirsts = new ArrayList<>();
        fooFirsts.add(new FooFirst("42", "Spok"));
        fooFirsts.add(new FooFirst("7", "Shepard"));
        fooFirsts.add(new FooFirst("78", "Nemo"));
        fooFirsts.add(new FooFirst("55", "Jack Sparrow"));

//        Optional<FooSecond> optionalFooSecond = fooFirsts.stream()
//                .map(first -> new FooSecond(Integer.parseInt(first.getValue()), first.getName()))
//                .filter(second -> second.getValue() > 50).findFirst();
//
////        optionalFooSecond.ifPresent(second -> System.out.println(second));
//
//        FooSecond fooSecond;
//        if (optionalFooSecond.isPresent()) {
//            fooSecond = optionalFooSecond.get();
//            System.out.println(fooSecond.toString());
//        } else {
//            System.out.println("Ничего не найдено");
//        }

        FooSecond fooSecond = fooFirsts.stream()
                .map(first -> new FooSecond(Integer.parseInt(first.getValue()), first.getName()))
                .filter(second -> second.getValue() > 50).findFirst().orElse(null);

        System.out.println(fooSecond);

        System.out.println("\n\n STREAM API PEEK()");

        //создаем стрим из иссходной коллекции
        strings.stream()
                // перебор стрима для вывода на консоль
                .peek(str -> System.out.println("I print this using Stream API!!! " + str));


        System.out.println("\n\n STREAM API MAPTOINT()");
        List<String> numericStrings = Arrays.asList("78", "45", "05", "465");
        numericStrings.stream().mapToInt(num -> Integer.parseInt(num)).forEach(value -> System.out.println(value));

        System.out.println("\n\n STREAM API FLATMAP()");

        List<String> numericStringsIntoString = Arrays.asList("42,78,45,12,23,56,89", "78", "45", "05,45,546", "465,0025,789");
        List<String> nums = numericStringsIntoString.stream()
                .flatMap(str -> Arrays.asList(str.split(",")).stream())
                .collect(Collectors.toList());

        nums.forEach(num -> System.out.println(num));

    }
}
