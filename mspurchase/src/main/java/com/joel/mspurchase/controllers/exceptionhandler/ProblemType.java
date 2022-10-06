package com.joel.mspurchase.controllers.exceptionhandler;

import lombok.Getter;

@Getter

public enum ProblemType {



    INVALID_DATA("/invalid-data", "invalid date"),
    SYSTEMS_ERROR("/systems-error", "Systems Error"),
    INVALID_PARAMETER("/invalid-parameter", "Invalid parameter"),
    MESSAGE_INCOMPREHENSIBLE("/message-incomprehensible", "Menssage Incomprehensible"),
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource Not Found"),
    ENTITY_IN_USE("/entity-in-user", "Entity In User"),
    BUSINESS_ERROR("/business-error", "Business Error");




    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https://api.online-shopping.com" + path;
        this.title = title;
    }


}
