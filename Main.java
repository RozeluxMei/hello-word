import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException, InvalidRomanNumberException, NotAppropriateOperation, NotAppropriateNumbersException, NotRomanResultException {
        System.out.println("Hello, please input your expression below:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Expression expression = new Expression(reader.readLine());
        expression.compute();
        reader.close();
    }
}
