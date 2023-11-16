package com.example.design.proxy2.after.dynamicProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }

    private void dynamicProxy(){
        GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }

    private GameService getGameServiceProxy(GameService target){
        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
        new Class[]{GameService.class}, new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("프록시 적용 ");
                method.invoke(target,args);
                System.out.println("프록시 적용 ");
                return null;
            }
        });
    }
}
