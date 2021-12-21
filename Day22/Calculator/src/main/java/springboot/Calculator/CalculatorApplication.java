package springboot.Calculator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {

  ApplicationContext context = SpringApplication.run(CalculatorApplication.class, args);

        Calculator calculator=context.getBean(Calculator.class);

        System.out.println("OperandOne : "+calculator.getOperandOne());
        System.out.println("OperandTwo : "+calculator.getOperandTwo());

        System.out.print(calculator.getOperandOne()+" + "+calculator.getOperandTwo()+" = ");
        System.out.println(calculator.add());

        System.out.print(calculator.getOperandOne()+" - "+calculator.getOperandTwo()+" = ");
        System.out.println(calculator.subtract());

        System.out.print(calculator.getOperandOne()+" * "+calculator.getOperandTwo()+" = ");
        System.out.println(calculator.multiply());

        System.out.print(calculator.getOperandOne()+" / "+calculator.getOperandTwo()+" = ");
        System.out.println(calculator.divide());

    }
}
//Create a simple spring boot application and add a class to implement
//calculator functionalities.
//Fetch the inputs required from application.properties file.
//use @component and @value annotations