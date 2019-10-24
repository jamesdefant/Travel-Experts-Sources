package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    /**
     * Perform a GET request at a specified URL - SELECT
     * @param urlString - the url of the REST API
     * @return JSON data
     */
    public static String getJson(String urlString) {
        try {
            System.out.println("Connection URL: " + urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if(conn.getResponseCode() == 200) {
                System.out.println("Successfully connected");
            }
            else {
                System.out.println("Problem connecting");
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally {
                conn.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Perform a PUT request at a specified URL with supplied jsonData - INSERT
     * @param urlString - the URL of the REST API
     * @param jsonData - the object to INSERT
     * @return - String - message of success/failure
     */
    public static String putJson(String urlString, String jsonData) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonData.getBytes());
            os.flush();

            if(conn.getResponseCode() == 200) {
                System.out.println("Successfully connected");
            }
            else {
                System.out.println("Problem connecting");
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally {
                conn.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Perform a POST request at a specified URL with supplied jsonData - UPDATE
     * @param urlString - the URL of the REST API
     * @param jsonData - the object to INSERT
     * @return - String - message of success/failure
     */
    public static String postJson(String urlString, String jsonData) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(jsonData.getBytes());
            os.flush();

            if(conn.getResponseCode() == 200) {
                System.out.println("Successfully connected");
            }
            else {
                System.out.println("Problem connecting");
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally {
                conn.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Perform a POST request at a specified URL with supplied jsonData - DELETE
     * @param urlString - the URL of the REST API
     * @return - String - message of success/failure
     */
    public static String deleteJson(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");

            if(conn.getResponseCode() == 200) {
                System.out.println("Successfully connected");
            }
            else {
                System.out.println("Problem connecting");
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally {
                conn.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
