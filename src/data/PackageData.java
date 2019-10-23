package data;

public interface PackageData {

    String getPackage(int packageId);
    String getAllPackages();
    String insertPackage(String jsonData);
    String updatePackage(String jsonData);
    String deletePackage(int packageId);
}
