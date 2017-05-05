package com.thed.service;

import org.joda.time.DateTime;

/**
 * Created by Pravin on 4/19/17.
 * Copyright D Inc. 2017 , use it at own risk
 */
public class Version {
    private String self;
    private String id;
    private String description;
    private String name;
    private Boolean archived;
    private Boolean released;
    private DateTime releaseDate;
    private Boolean overdue;
    private String userReleaseDate;
    private String projectId;

    private DateTime startDate;
    private String userStartDate;
}
