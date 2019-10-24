package data.dummy;

import data.REST.Constants;
import rest.API;

public class ProductSupplierData implements data.ProductSupplierData {
    @Override
    public String getProductSupplier(int productSupplierId) {

        return "{\"ProductSupplierId\":1,\"ProductId\":1,\"SupplierId\":5492}";
    }

    @Override
    public String getAllProductSuppliers() {

        return "[{\"ProductSupplierId\":1,\"ProductId\":1,\"SupplierId\":5492},{\"ProductSupplierId\":2,\"ProductId\":1,\"SupplierId\":6505},{\"ProductSupplierId\":3,\"ProductId\":8,\"SupplierId\":796},{\"ProductSupplierId\":4,\"ProductId\":1,\"SupplierId\":4196},{\"ProductSupplierId\":6,\"ProductId\":8,\"SupplierId\":1040},{\"ProductSupplierId\":7,\"ProductId\":1,\"SupplierId\":3576},{\"ProductSupplierId\":8,\"ProductId\":3,\"SupplierId\":845},{\"ProductSupplierId\":9,\"ProductId\":7,\"SupplierId\":828},{\"ProductSupplierId\":10,\"ProductId\":8,\"SupplierId\":5777},{\"ProductSupplierId\":11,\"ProductId\":8,\"SupplierId\":5827},{\"ProductSupplierId\":12,\"ProductId\":5,\"SupplierId\":3273},{\"ProductSupplierId\":13,\"ProductId\":1,\"SupplierId\":80},{\"ProductSupplierId\":14,\"ProductId\":8,\"SupplierId\":9396},{\"ProductSupplierId\":15,\"ProductId\":8,\"SupplierId\":3589},{\"ProductSupplierId\":16,\"ProductId\":1,\"SupplierId\":69},{\"ProductSupplierId\":19,\"ProductId\":1,\"SupplierId\":3376},{\"ProductSupplierId\":20,\"ProductId\":3,\"SupplierId\":323},{\"ProductSupplierId\":23,\"ProductId\":1,\"SupplierId\":3549},{\"ProductSupplierId\":24,\"ProductId\":5,\"SupplierId\":1918},{\"ProductSupplierId\":25,\"ProductId\":3,\"SupplierId\":11156},{\"ProductSupplierId\":26,\"ProductId\":8,\"SupplierId\":8837},{\"ProductSupplierId\":28,\"ProductId\":8,\"SupplierId\":8089},{\"ProductSupplierId\":29,\"ProductId\":1,\"SupplierId\":1028},{\"ProductSupplierId\":30,\"ProductId\":1,\"SupplierId\":2466},{\"ProductSupplierId\":31,\"ProductId\":5,\"SupplierId\":1406},{\"ProductSupplierId\":32,\"ProductId\":3,\"SupplierId\":1416},{\"ProductSupplierId\":33,\"ProductId\":5,\"SupplierId\":13596},{\"ProductSupplierId\":34,\"ProductId\":1,\"SupplierId\":9323},{\"ProductSupplierId\":35,\"ProductId\":5,\"SupplierId\":11237},{\"ProductSupplierId\":36,\"ProductId\":8,\"SupplierId\":9785},{\"ProductSupplierId\":37,\"ProductId\":5,\"SupplierId\":11163},{\"ProductSupplierId\":39,\"ProductId\":9,\"SupplierId\":11172},{\"ProductSupplierId\":40,\"ProductId\":8,\"SupplierId\":9285},{\"ProductSupplierId\":41,\"ProductId\":5,\"SupplierId\":3622},{\"ProductSupplierId\":42,\"ProductId\":5,\"SupplierId\":9323},{\"ProductSupplierId\":43,\"ProductId\":1,\"SupplierId\":1766},{\"ProductSupplierId\":44,\"ProductId\":1,\"SupplierId\":3212},{\"ProductSupplierId\":45,\"ProductId\":9,\"SupplierId\":11174},{\"ProductSupplierId\":46,\"ProductId\":8,\"SupplierId\":3600},{\"ProductSupplierId\":47,\"ProductId\":9,\"SupplierId\":11160},{\"ProductSupplierId\":48,\"ProductId\":8,\"SupplierId\":11549},{\"ProductSupplierId\":49,\"ProductId\":4,\"SupplierId\":2827},{\"ProductSupplierId\":50,\"ProductId\":9,\"SupplierId\":12657},{\"ProductSupplierId\":51,\"ProductId\":8,\"SupplierId\":7377},{\"ProductSupplierId\":52,\"ProductId\":5,\"SupplierId\":6550},{\"ProductSupplierId\":53,\"ProductId\":4,\"SupplierId\":1634},{\"ProductSupplierId\":54,\"ProductId\":8,\"SupplierId\":2140},{\"ProductSupplierId\":55,\"ProductId\":3,\"SupplierId\":317},{\"ProductSupplierId\":56,\"ProductId\":1,\"SupplierId\":1205},{\"ProductSupplierId\":57,\"ProductId\":8,\"SupplierId\":3633},{\"ProductSupplierId\":58,\"ProductId\":2,\"SupplierId\":6873},{\"ProductSupplierId\":59,\"ProductId\":1,\"SupplierId\":7377},{\"ProductSupplierId\":60,\"ProductId\":5,\"SupplierId\":7244},{\"ProductSupplierId\":61,\"ProductId\":3,\"SupplierId\":2938},{\"ProductSupplierId\":63,\"ProductId\":2,\"SupplierId\":5081},{\"ProductSupplierId\":64,\"ProductId\":1,\"SupplierId\":3119},{\"ProductSupplierId\":65,\"ProductId\":9,\"SupplierId\":2998},{\"ProductSupplierId\":66,\"ProductId\":8,\"SupplierId\":3576},{\"ProductSupplierId\":67,\"ProductId\":8,\"SupplierId\":2592},{\"ProductSupplierId\":68,\"ProductId\":4,\"SupplierId\":100},{\"ProductSupplierId\":69,\"ProductId\":9,\"SupplierId\":2987},{\"ProductSupplierId\":70,\"ProductId\":4,\"SupplierId\":1005},{\"ProductSupplierId\":71,\"ProductId\":4,\"SupplierId\":908},{\"ProductSupplierId\":72,\"ProductId\":1,\"SupplierId\":5796},{\"ProductSupplierId\":73,\"ProductId\":10,\"SupplierId\":2386},{\"ProductSupplierId\":74,\"ProductId\":1,\"SupplierId\":3650},{\"ProductSupplierId\":75,\"ProductId\":4,\"SupplierId\":1425},{\"ProductSupplierId\":76,\"ProductId\":8,\"SupplierId\":6346},{\"ProductSupplierId\":78,\"ProductId\":1,\"SupplierId\":1685},{\"ProductSupplierId\":79,\"ProductId\":2,\"SupplierId\":2588},{\"ProductSupplierId\":80,\"ProductId\":6,\"SupplierId\":1620},{\"ProductSupplierId\":81,\"ProductId\":4,\"SupplierId\":1542},{\"ProductSupplierId\":82,\"ProductId\":5,\"SupplierId\":9766},{\"ProductSupplierId\":83,\"ProductId\":5,\"SupplierId\":5228},{\"ProductSupplierId\":84,\"ProductId\":6,\"SupplierId\":9396},{\"ProductSupplierId\":87,\"ProductId\":1,\"SupplierId\":1859},{\"ProductSupplierId\":90,\"ProductId\":1,\"SupplierId\":1713},{\"ProductSupplierId\":93,\"ProductId\":4,\"SupplierId\":3650}]";
    }

        @Override
    public String insertProductSupplier(String jsonData) {

        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updateProductSupplier(String jsonData) {

        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deleteProductSupplier(int productSupplierId) {

        return "DELETE on " + productSupplierId + "\n...attemtped.\nMethod not yet implemented";
    }
}
