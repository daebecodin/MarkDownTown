package com.daebecodin.mdt.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class DataLoaderBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private final DataLoader dataLoader;
    private final ApplicationContext applicationContext;


    @Autowired
    public DataLoaderBootstrap(DataLoader dataLoader, ApplicationContext applicationContext) {
        this.dataLoader = dataLoader;
        this.applicationContext = applicationContext;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dataLoader.loadData();
    }


}
