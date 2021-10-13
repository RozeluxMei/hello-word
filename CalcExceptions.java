
class NotRomanResultException extends Exception {
    //Исключение если результируещее число из римских цифр не удовлетворяет ТЗ П.10
    public NotRomanResultException (String message){
        super(message);
    }
}

class NotAppropriateNumbersException extends Exception {
    //Исключение если введены числа разных систем или если входящие значения больше допустимого диапазона
    // Условия ТЗ П.3 и П.5
    public NotAppropriateNumbersException (String message){
        super(message);
    }
}

class NotAppropriateOperation extends Exception {
    //Исключение если строка не подходит под арифметическую операцию
    //Условие ТЗ П.8
    public NotAppropriateOperation (String message){
        super(message);
    }
}

class InvalidRomanNumberException extends Exception{
    //Исключение если введенное римское число выходит за рамки логики построения например "IIIX" или превышает 100
public InvalidRomanNumberException (String message){
    super(message);
}

}

