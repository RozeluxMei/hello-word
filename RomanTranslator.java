import java.util.HashMap;
import java.util.Map;

public class RomanTranslator {
   static Map<String, Integer> romanInt = getRomanInt(); //создадим словарик (почему то кажется неверным)

public static HashMap <String, Integer> getRomanInt(){
    //Словарь с римскими числами от 1 до 10 сделал чтобы была возможность по нему проверить является ли введенное
    //число подходящим для дальнейшей обработки, так же должен пригодится чтобы преобразовать римское выражение
    //в реальную операцию
    HashMap<String, Integer> romanInt = new HashMap<>();

    romanInt.put("I", 1);
    romanInt.put("II", 2);
    romanInt.put("III", 3);
    romanInt.put("IV", 4);
    romanInt.put("V", 5);
    romanInt.put("VI", 6);
    romanInt.put("VII", 7);
    romanInt.put("VIII", 8);
    romanInt.put("IX", 9);
    romanInt.put("X", 10);
    return romanInt;

    //так же можно реализовать путем возврата индекса по поиску в массиве где индексу массива соответсвует
    //строка характеризующая римское число, но хэш таблица показалась более подходящей реализацией
}

public static boolean romanNumbersCheck (String input, HashMap<String, Integer> romanInt){
    //чекаем подходят ли римские числа в выражении для того чтобы работать с ними

    String [] numbers = input.split("[*/+-]"); //разбиваем выражение по знаку операции
    for (String number:
         numbers) {
        if (!romanInt.containsKey(number.trim())){ //переберем каждое число и сверим с нашим словарем
            return false; //Если хоть одно вхождение не совпало возвращаем "неверно"
        }
    }
    return true;

    //метод избыточен т.к. можно проверить число на соответствие словарю в момент когда число будет
    //конвертироваться из римского в арабское, стоит сделать метод не для целого выражения а для конкретного аргумента
    //что и было реализовано ниже
}

public static boolean isRomanNumber (String input){
    //более простой метод для одного вхождения, нет необходимости усложнять всё регулярками
    return romanInt.containsKey(input.trim());
}

public static String transToRoman (int result) throws NotAppropriateNumbersException,NotRomanResultException {
    //Сначала проверим меньше ли 1 поступившее число чтобы не нарушать ТЗ П.10
    if (result < 1) throw new NotRomanResultException (result + " is not available in Roman System");
    //Теперь проверим результируещее число, если оно больше 100 был нарушен ТЗ П.3
    if (result>100) throw new NotAppropriateNumbersException (result + " result is larger than possible");

    String RomanResult = ""; //сюда будем добавлять символы по мере обработки числа
    //Метод для перевода числа в римское
    //т.к. максимальное возможное число в "римском" выражении будет  X*X то максимальное допустимое число будет 100 - "C"
    String [] Hundreds = new String[] {"","C"}; //Массив в котором индекс соответствует количеству сотен
    String [] Tens = new String[] {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//такой же массив для десятков
    String [] Ones = new String[] {"","I","II","III","IV","V","VI","VII","VIII","IX"};//аналогично с единицами

    RomanResult += Hundreds[result/100]; //Добавить в строку столько "сотен" на сколько делится входящее число
    RomanResult += Tens[(result/10) % 10]; //остаток от деления на 10 исключает ошибку превышения индекса
    RomanResult += Ones[result % 10]; //так же находим и добавляем единицы

    return RomanResult;
    //метод можно отрефакторить для работы с числами до 4000 путем дополнения массива с сотнями и добавления массива
    //c тысячами и добавлением строчки процессящей тысячную разрядность
}

public static int transToInteger (String input) throws InvalidRomanNumberException {
    //Метод для перевода римской цифры в int для дальнейших вычислений, так же перед переводом в цифру будет чекать
    //является ли введенная цифра подходящей для операций (есть ли она в словаре) если нет - кидаем исключение
    if (isRomanNumber(input)){
        return romanInt.get(input.trim());
    }
    else throw new InvalidRomanNumberException("\"" + input.trim() + "\"" + " - is not a valid Roman number");
}

}
