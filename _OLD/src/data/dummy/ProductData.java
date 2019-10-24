package data.dummy;

public class ProductData implements data.ProductData {
    @Override
    public String getProduct(int productId) {

        return "{\"ProductId\":1,\"ProdName\":\"Air\"}";
    }

    @Override
    public String getAllProducts() {

        return "[{\"ProductId\":1,\"ProdName\":\"Air\"},{\"ProductId\":2,\"ProdName\":\"Attractions\"},{\"ProductId\":3,\"ProdName\":\"Car rental\"},{\"ProductId\":4,\"ProdName\":\"Cruise\"},{\"ProductId\":5,\"ProdName\":\"Hotel\"},{\"ProductId\":6,\"ProdName\":\"Motor Coach\"},{\"ProductId\":7,\"ProdName\":\"Railroad\"},{\"ProductId\":8,\"ProdName\":\"Tours\"},{\"ProductId\":9,\"ProdName\":\"stuff\"},{\"ProductId\":10,\"ProdName\":\"Yacht/Boat Charters\"},{\"ProductId\":14,\"ProdName\":\"widget\"},{\"ProductId\":15,\"ProdName\":\"zzz\"},{\"ProductId\":16,\"ProdName\":\"test\"}]";
    }

    @Override
    public String insertProduct(String jsonData) {

        return "INSERT on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String updateProduct(String jsonData) {

        return "UPDATE on \n" + jsonData + "\n...attemtped.\nMethod not yet implemented";
    }

    @Override
    public String deleteProduct(int productId) {

        return "DELETE on " + productId + "\n...attemtped.\nMethod not yet implemented";
    }
}
