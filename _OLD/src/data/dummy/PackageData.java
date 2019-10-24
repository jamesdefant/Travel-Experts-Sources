package data.dummy;

public class PackageData implements data.PackageData {
    @Override
    public String getPackage(int packageId) {
        return "{\"PackageId\":1,\"PkgName\":\"Caribbean New Year\",\"PkgStartDate\":\"2017-12-25\",\"PkgEndDate\":\"2017-01-04\",\"PkgDesc\":\"Cruise the Caribbean \\u0026 Celebrate the New Year.\",\"PkgBasePrice\":4800.0,\"PkgAgencyCommission\":400.0}";
    }

    @Override
    public String getAllPackages() {
        return "[{\"PackageId\":1,\"PkgName\":\"Caribbean New Year\",\"PkgStartDate\":\"2017-12-25\",\"PkgEndDate\":\"2017-01-04\",\"PkgDesc\":\"Cruise the Caribbean \\u0026 Celebrate the New Year.\",\"PkgBasePrice\":4800.0,\"PkgAgencyCommission\":400.0},{\"PackageId\":1,\"PkgName\":\"Caribbean New Year\",\"PkgStartDate\":\"2017-12-25\",\"PkgEndDate\":\"2017-01-04\",\"PkgDesc\":\"Cruise the Caribbean \\u0026 Celebrate the New Year.\",\"PkgBasePrice\":4800.0,\"PkgAgencyCommission\":400.0},{\"PackageId\":2,\"PkgName\":\"Polynesian Paradise\",\"PkgStartDate\":\"2016-12-12\",\"PkgEndDate\":\"2016-12-20\",\"PkgDesc\":\"8 Day All Inclusive Hawaiian Vacation\",\"PkgBasePrice\":3000.0,\"PkgAgencyCommission\":310.0},{\"PackageId\":3,\"PkgName\":\"Asian Expedition\",\"PkgStartDate\":\"2016-05-14\",\"PkgEndDate\":\"2016-05-28\",\"PkgDesc\":\"Airfaire, Hotel and Eco Tour.\",\"PkgBasePrice\":2800.0,\"PkgAgencyCommission\":300.0},{\"PackageId\":4,\"PkgName\":\"European Vacation\",\"PkgBasePrice\":3000.0,\"PkgAgencyCommission\":0.0}]";
    }

    @Override
    public String insertPackage(String jsonData) {
        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updatePackage(String jsonData) {
        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deletePackage(int packageId) {
        return "DELETE on " + packageId + "\n...attemtped.\nMethod not yet implemented";
    }
}
