package com.thed.service;

import java.io.IOException;
import java.util.List;

import com.sun.jersey.api.client.ClientResponse;
import com.thed.Constants;
import com.thed.util.JIRAHTTPClient;
import org.apache.commons.configuration.ConfigurationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * JIRA project related services
 *
 * Created by Pravin on 4/19/17.
 * Copyright D Inc. 2017 , use it at own risk
 */

public class ProjectService {

    private JIRAHTTPClient client = null;

    public ProjectService() throws ConfigurationException {
        client = new JIRAHTTPClient();
    }


    //get List of projects based on the user assignment and accessibility with in Jira (user which is use to make jira connection)
    public List<Project> getProjectList() throws IOException {

        if (client == null){
            throw new IllegalStateException("HTTP Client not Initialized");
        }
        client.setResourceName(Constants.JIRA_RESOURCE_PROJECT);
        ClientResponse response = client.get();

        String content = response.getEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        TypeReference<List<Project>> ref = new TypeReference<List<Project>>(){};
        List<Project> prj = mapper.readValue(content, ref);

        return prj;
    }

    // get Full project Information
    public Project getProjectDetail(String idOrKey) throws IOException {
        if (client == null)
            throw new IllegalStateException("HTTP Client not Initailized");

        client.setResourceName(Constants.JIRA_RESOURCE_PROJECT + "/" + idOrKey);
        ClientResponse response = client.get();

        String content = response.getEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        TypeReference<Project> ref = new TypeReference<Project>(){};
        Project prj = mapper.readValue(content, ref);

        return prj;
    }
}
