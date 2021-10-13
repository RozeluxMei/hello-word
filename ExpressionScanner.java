import java.util.Scanner;

class ExpressionScanner { // хотелось бы занаследоваться от сканера но пишет что у сканера приписка final по этому
    // некрасивое решение - создавать экземпляр сканера внутри методов.

    public static boolean isOperation (String input) {
        //Проверяем является ли введенная строка выражением, для реализации решил использовать регулярные
        //выражения т.к. в ТЗ не запрещалось их наличие в исходном коде, и они больше всего подходят, чтобы чекнуть
        //П.8 из ТЗ т.е. функция не проверяет подойдет число или нет, она проверяет являются ли элементы строки
        //подходящими для дальнейших преобразований или не стоит тратить время на дальнейшие операции вообще.
        return input.matches("^([VIX]{1,4}|\\d{1,2})\\s*[+*/-]\\s*([VIX]{1,4}|\\d{1,2})$");
    }

    public static boolean isRoman (String input) {
        //Проверяем является ли выражение "Римским"
        return input.matches("^[VIX]{1,4}\\s*[+*/-]\\s*[VIX]{1,4}$");
    }

    public static boolean isArabian (String input) {
        //Проверяем является ли выражение "Арабским"
        return input.matches("^\\d{1,2}\\s*[+*/-]\\s*\\d{1,2}$");
    }

    public static String [] getArgs (String input) {
        Scanner scanner = new Scanner(input); //сканнер поможет вырезать нужную часть строки по шаблону
        //разберем строку которую ввел пользователь на аргументы, массив позволит запомнить их порядок для дальнейших
        //операций
        String [] Args = new String[2];
        Args [0] = scanner.findInLine("\\d|[VIX]{1,4}"); //вытягиваем первый арг
        Args [1] = scanner.findInLine("\\d|[VIX]{1,4}"); //вытягиваем второй арг
        scanner.close();
        return Args;
    }

    public static Operations getOperation (String input) throws NotAppropriateOperation {
        //Метод вычисляет операцию и возвращает по ней Enum для дальнейших действий
        Scanner scanner = new Scanner(input);
        switch (scanner.findInLine("[*/+-]")){
            case "+": scanner.close(); return Operations.ADD;
            case "-": scanner.close(); return Operations.SUBTRACT;
            case "/": scanner.close(); return Operations.DIVIDE;
            case "*": scanner.close(); return Operations.MULTIPLY;
        }
        throw new NotAppropriateOperation (input + " is invalid operation somehow...");//после стольких проверок по
        // цепочке это в принципе невозможно, но на всякий случай обработам
        //
    }

}
