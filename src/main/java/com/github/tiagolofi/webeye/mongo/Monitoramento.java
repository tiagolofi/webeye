package com.github.tiagolofi.webeye.mongo;

import java.util.ArrayList;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "monitoramento")
public class Monitoramento extends PanacheMongoEntity {
    
    public String timestamp;
    public String service;
    public String url;
    public ArrayList<String> informations;
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setService(String service) {
        this.service = service;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setInformations(ArrayList<String> informations) {
        this.informations = informations;
    }

}
