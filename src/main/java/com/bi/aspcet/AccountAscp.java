package com.bi.aspcet;


import com.bi.anno.Auth;
import com.bi.pojo.AuthInfo;
import com.bi.service.AccountService;
import com.bi.service.impl.AccountServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class AccountAscp {
    private String classForName;

    public void setClassForName(String classForName) {
        this.classForName = classForName;
    }

    @Autowired
    AccountService accountServiceImpl;
    private HashMap<String, AuthInfo> hashMap;
    public void auth(){
        System.out.println("auth");
    }

    public void initAuth() throws ClassNotFoundException {
        hashMap = new HashMap<>();

        //Method[] methods = joinPoint.getTarget().getClass().getMethods();

        Method[] methods =  Class.forName(classForName).getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Auth.class)) {
                Auth annotation = method.getAnnotation(Auth.class);
                hashMap.put(method.getName(),new AuthInfo(annotation.username(),annotation.password()));
            }


        }
    }

    public Object  accountAuth(ProceedingJoinPoint joinPoint) throws Throwable {
//        if(hashMap == null){
//            initAuth(joinPoint);
//        }
        AuthInfo authInfo = hashMap.get(joinPoint.getSignature().getName());
        System.out.println(hashMap+"-----");
        if("admin1234".equals(authInfo.getUsername()) && "admin1234".equals(authInfo.getPassword())){
                        System.out.println("鉴权成功");
            return joinPoint.proceed();
                    }else {
                        System.out.println("鉴权失败");

                    }
        //  Method[] methods = joinPoint.getTarget().getClass().getMethods();

//        for (Method method : methods) {
//
//            if (method.isAnnotationPresent(Auth.class)) {
//
//                Auth annotation = method.getAnnotation(Auth.class);
//                if(method.getName().equals(joinPoint.getSignature().getName())){
//                    if("admin1234".equals(annotation.username()) && "admin1234".equals(annotation.password())){
//                        System.out.println("鉴权成功");
//                    }else {
//                        System.out.println("鉴权失败");
//                    }
//                }
//
//            }
//        }

        System.out.println("-----");
        return joinPoint.proceed();

    }
}
