package com.dummy.rest;

import com.jayway.restassured.response.Response;
import java.util.logging.Logger;
import java.util.Map;

public class ApiExecutor {

    private static final Logger LOGGER = Logger.getLogger(ApiExecutor.class.getName());
    private static final String POSTMAN_API = "https://api.getpostman.com";

    public ApiExecutor() { }

    public String postSingleCollection() throws Exception{
        Map<String, String> myMap;

        final Response response = ExecutorHelper.postObject(POSTMAN_API + "/" + "collections");
        LOGGER.info("Creating brand new collection");
        CollectionResponseHelper.validateResponseStatus(response);

        myMap = CollectionResponseHelper.extractDataFromCreateResponse(response);
        return  myMap.get("uid");
    }

    public void putSingleCollection(final String createdUid) throws Exception{
        final Response response = ExecutorHelper.putObject(POSTMAN_API + "/" +"collections"+ "/" +createdUid);
        LOGGER.info("Updating uid: " + createdUid);
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getSingleCollection(final String createdUid) throws Exception{
        final Response response = ExecutorHelper.getObject(POSTMAN_API + "/"  +"collections"+ "/" + createdUid);
        LOGGER.info("Getting single collection for uid: " + createdUid);
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllCollections() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API+ "/" + "collections"));
        LOGGER.info("Validating all Collections");
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void deleteSingleCollection(final String createdUid) throws Exception{
        final Response response = ExecutorHelper.deleteObject(POSTMAN_API + "/"  +"collections"+ "/" + createdUid);
        LOGGER.info("Deleting single collection for uid: " + createdUid);
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllEnvironments() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API + "/" + "environments"));
        LOGGER.info("Validating all environments");
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllMocks() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API + "/" + "mocks"));
        LOGGER.info("Validating all environments");
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllMonitors() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API + "/" + "monitors"));
        LOGGER.info("Validating all environments");
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllWorkspaces() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API + "/" + "workspaces"));
        LOGGER.info("Validating all environments");
        CollectionResponseHelper.validateResponseStatus(response);
    }

    public void getAllUsers() throws Exception{
        final Response response = ExecutorHelper.getObject((POSTMAN_API + "/" + "me"));
        LOGGER.info("Validating all environments");
        CollectionResponseHelper.validateResponseStatus(response);
    }

}
