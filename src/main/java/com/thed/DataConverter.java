package com.thed;


import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Base64;
import java.util.Properties;

/**
 * <p>This utility is designed to upload user in bulk</p>
 * Parse user.csv from a specified location , each row represents a user,
 * uses user upload zee rest API's to  upload user in bulk
 */
public class DataConverter {


//    private static String csvFile = "/Users/Pravin/Documents/dev/zee/zeerestcsvclient/src/main/resources/users.csv";
    private static String clientProperties = "/Users/Pravin/Documents/dev/zee/zfj_zee_converter/src/main/resources/client.properties";
    private static Properties prop = new Properties();

    public static void main(String as[]) throws Exception {
        if (as.length < 4) {
            showUsage();
            return;
        }

        loadProperties();

    }


    private static void loadProperties() {
        InputStream input = null;
        try {
            input = new FileInputStream(clientProperties);
            prop.load(input);
        } catch (Exception e) {
            System.out.println("could not load properties file " + e.getMessage());
            System.out.println("plz add full qualified file path of client.properties");
            e.printStackTrace();
            throw new IllegalArgumentException("incorrect setup");
        }

    }


    private static void showUsage() {
        System.out.println("Incorrect input params");
        System.out.println(" ZEE Rest client for user upload");
        System.out.println("\t 1. Server URL ex. " + "https://demo.yourzephyr.com");
        System.out.println("\t 2. CSV file path (absolute) ex./Users/Pravin/resources/users.csv" +
        " Plz get sample csv format from https://github.com/zeedeveloper/zeenodejsclient/blob/master/users.csv");
        System.out.println("\t 3. User ID ex. test.manager");
        System.out.println("\t 4. User password ex. test.manager");
        System.out.println("AN Example call is as following");
        System.out.println("\t java -cp .:/Users/Pravin/Documents/temp/libs/* com.thed.DataConverter " +
                " https://demo.yourzephyr.com /Users/Pravin/Documents/temp/libs/users.csv test.manager test.manager");
    }


}

