package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Package;

public class PackageDB {

    private Gson gson;
    private PackageData data;

    // Constructor
    public PackageDB(PackageData data) {

        this.data = data;
    }

    /**
     * Retrieve Package Json and return Package object
     * @param packageId - id of the Package
     * @return Package object
     */
    public model.Package getPackage(int packageId) {

        gson = new Gson();
        String jsonData = this.data.getPackage(packageId);
        System.out.println("jsonData: " + jsonData);
        Package pkg = gson.fromJson(jsonData, Package.class);
        return pkg;

    }

    /**
     * Retrieve Package list json and return ArrayList<Package> object
     * @return list of all Package in database
     */
    public ArrayList<Package> getPackageList() {

        gson = new Gson();
        String jsonData = this.data.getAllPackages();
        System.out.println("jsonData: " + jsonData);

        // Turn jsondata into list of objects
        Type type = new TypeToken<List<Package>>() {}.getType();
        return gson.fromJson(jsonData, type);
    }

    /**
     * INSERT a new Package in the database
     * @param pkg to insert
     * @return message of success/failure
     */
    public String insertPackage(model.Package pkg) {

        gson = new Gson();
        String jsonData = gson.toJson(pkg, model.Package.class);
        String response = this.data.insertPackage(jsonData);
        return response;
    }

    /**
     * UPDATE a Package in the database
     * @param oldPackage to check for optimistic concurrency
     * @param newPackage to update
     * @return message of success/failure
     */
    public String updatePackage(Package oldPackage,
                                Package newPackage) {

        gson = new Gson();
        ArrayList<Package> list = new ArrayList<>();
        list.add(oldPackage);
        list.add(newPackage);
        Type type = new TypeToken<List<Package>>() {}.getType();

        String jsonData = gson.toJson(list, type);
        String response = this.data.updatePackage(jsonData);
        return response;
    }

    /**
     * DELETE an Package in the database
     * @param packageId of Package to delete
     * @return message of success/failure
     */
    public String deletePackage(int packageId) {

        return this.data.deletePackage(packageId);
    }

}
