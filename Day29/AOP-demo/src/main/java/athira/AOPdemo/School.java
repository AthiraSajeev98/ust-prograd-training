package athira.AOPdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class School {

    @Pointcut("execution( public void welcome())")
    public void pointcutOne() {
    }

    @Before("pointcutOne()")
    public void logBeforeWelcome() {

        System.out.println("Before welcome()");
    }

    @After("pointcutOne()")
    public void logAfterWelcome() {
        System.out.println("After welcome()");

    }

    @Pointcut("execution( public void *display*())")
    public void pointcutTwo() {
    }

    @Around("pointcutTwo()")
    public void logAroundDetails(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Displaying before *Display");
        proceedingJoinPoint.proceed();
        System.out.println("Displaying after *Display");

    }

    @Pointcut("execution(public int *Age())")
    public void pointcutThree() {
    }

//    @AfterReturning("pointcutThree()")
//    public void commitTransaction() {
//        System.out.println("Transaction committed !");
//    }


    @AfterReturning(value="pointcutThree()", returning = "value")
    public void getAdviceReturnValue(Object value) {
        System.out.println("Returning Value is : "+value);
    }

//    @Pointcut("execution(public int getName())")
//    public void pointcutFour() {
//    }
//
//    @AfterThrowing("pointcutFour()")
//    public void rollbackTransaction() {
//        System.out.println("Transaction rolled back !");
//    }

//    @AfterThrowing (pointcut = "execution(public void setPhoneNumber())", throwing = "ex")
//    public void logAfterThrowingAllMethods(Exception ex) throws Throwable{
//        System.out.println("Exception" + ex);
//    }
    @AfterThrowing (pointcut = "execution(public void setPhoneNumber())", throwing = "error")
    public void afterThrowingAdvice(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("full method description: " + signature.getMethod().getName());
        System.out.println("method name: " + signature.getMethod().getName());
        System.out.println("declaring type: " + signature.getDeclaringType());
    }
}


