public class Expression {
    int a;
    int b;
    boolean isRoman;
    Operations operation;


    public Expression(String input) throws InvalidRomanNumberException, NotAppropriateOperation, NotAppropriateNumbersException {
        // конструктор составляет выражение из строки (сложно но удобно, конечно же мы будем пользоваться им)

        String [] args = ExpressionScanner.getArgs(input);
        this.isRoman = ExpressionScanner.isRoman(input);

        if (isRoman){
            a = RomanTranslator.transToInteger(args[0]);
            b = RomanTranslator.transToInteger(args[1]);
        }

        else if (ExpressionScanner.isArabian(input)){
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }

        else {
            throw new NotAppropriateNumbersException(input + " Arguments has different system");
        }
        operation = ExpressionScanner.getOperation(input);
    }

    public Expression (int a, int b, boolean isRoman, Operations operation){// конструктор составляет выражение из
        // передаваемых аргов (неудобно, но очень просто)
        this.a = a;
        this.b = b;
        this.isRoman = isRoman;
        this.operation = operation;
    }
    //перечислим методы арифметических операций,т.к. не хотим вызывать их из класса сделаем приватными
    private int apply (){
        return a + b;
    }

    private int subtract (){
        return a - b;
    }

    private float divide (){
        if (b == 0){
            throw new ArithmeticException("You can not divide by zero!"); //вредно делить на ноль)
        }
        else return (float) a/b;
    }

    private int multiply (){
        return a*b;
    }

    public void compute () throws NotRomanResultException, NotAppropriateNumbersException {
        if (isRoman){
            switch (operation){ //если числа были римские на выходе надо преобразовать из в римские
                case ADD -> System.out.println(RomanTranslator.transToRoman(apply()));
                case SUBTRACT -> System.out.println(RomanTranslator.transToRoman(subtract()));
                case DIVIDE -> System.out.println(RomanTranslator.transToRoman((int)divide()));
                case MULTIPLY -> System.out.println(RomanTranslator.transToRoman(multiply()));
            }
        }
        else {
            switch (operation){//ну тут всё очевидно...
                case ADD -> System.out.println(apply());
                case SUBTRACT -> System.out.println(subtract());
                case DIVIDE -> System.out.println(divide());
                case MULTIPLY -> System.out.println(multiply());

            }
        }
    }
}
