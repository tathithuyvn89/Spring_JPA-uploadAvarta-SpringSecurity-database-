package thuy.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
  public class MyLogger {
//  public void error() {
//        System.out.println("[CMS] ERROR!");
//    }
////    execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))
//@AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.*.*(..))", throwing = "e")
//    public void log(JoinPoint joinPoint, Exception e) {
//    String className = joinPoint.getTarget().getClass().getSimpleName();
//    String method = joinPoint.getSignature().getName();
//    String args = Arrays.toString(joinPoint.getArgs());
//    System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
//@AfterReturning(pointcut = "within(thuy.codegym.service.student.*)", returning = "result")
//public void log(JoinPoint joinPoint, Object result) {
//  System.out.println("[MyLogger] @AfterReturning ================================ ");
//  String className = joinPoint.getTarget().getClass().getSimpleName();
//  String methodName = joinPoint.getSignature().getName();
//  String args = Arrays.toString(joinPoint.getArgs());
//  System.out.println(String.format("[MyLogger] executed %s.%s [args=%s]", className, methodName, args));
//  String strResult = (result == null) ? "[null]" : result.toString();
//  System.out.println("[MyLogger] Result: " + strResult);
//}
  public void error(){
    System.out.println("Program is error");
  }
  @AfterReturning(pointcut = "within(thuy.codegym.service.student.*)",returning = "result")
  public void log(JoinPoint joinPoint,Object result){
    System.out.println("[My Logger] @AfterReturning============================");
    String className= joinPoint.getTarget().getClass().getSimpleName();
    String methodName= joinPoint.getSignature().getName();
    String args= Arrays.toString(joinPoint.getArgs());
    System.out.println(String.format("[MyLogger] executed %s.%s[args=%s]",className,methodName,args));
    String strResult= (result==null)? "[null]" :result.toString();
    System.out.println("[MyLogger] Result: "+strResult);
  }
}