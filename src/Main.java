import lambda.Converter;
import lambda.Printable;
import lambda.Water;
import lambda.Wine;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        //входные параметры
//        (int a, int b) -> {
//            // тело функции
//            return a + b;
//        }
//
//        () -> {
//            System.out.println("42");
//        }

        Converter<String, Integer> stringIntegerConverter = (x) -> {
            return Integer.parseInt(x);
        };

        Converter<Wine, Water> wineWaterConverter = (x) -> {
            return new Water("Раньше это было вино крепостью " + x.getAlcohol() + " и цвета благородного, а именно: " + x.getColor());
        };

        Printable printable = () -> System.out.println("This is terminate operation");
        printable.print();
    }
}