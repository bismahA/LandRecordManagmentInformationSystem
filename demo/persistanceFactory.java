package com.example.demo;

public class persistanceFactory {
    private static persistanceFactory instance=null;

    persistanceHandler service;
    private persistanceFactory(){}

    public static synchronized persistanceFactory getInstance(){
        if(instance==null)
        {
            instance=new persistanceFactory();
        }
        return instance;
    }

    public persistanceHandler createPersistanceHandler(String serviceName){
        if(service==null)
        {
            if(serviceName=="db")
            {
                service=new dbHandler();
            }
        }
        return service;
    }
}
