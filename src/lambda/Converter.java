package lambda;

//нужна для того чтобы сообщить компилятору о том что дальше фун интерфейс
@FunctionalInterface
public interface Converter<T, Q> {

    // непосредственно сама функция конвертации
    Q convert(T t);
}
