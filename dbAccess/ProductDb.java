/**
 * Database access class to manipulate travelexperts.products table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 *  * Author: Salah Hadj Cherif
 * Date: OCt 12 2019
 */

package dbAccess;


import model.Product;

import java.sql.*;
import java.util.ArrayList;


public class ProductDb {
    private static DbConnection dbconn =new DbConnection();//connection to Db travelexperts

    /**
     * Method to return all the product in the products table
     *
     * @return List of products
     */

    public static ArrayList<Product> getProductList()
    {
        ArrayList<Product> listProduct = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Define your Connection object
            conn = dbconn.createConnection();

            // Build the query
            String sql = "SELECT * FROM products";

            // Prepare the statement
            stmt = conn.prepareStatement(sql);

            // Execute the statement
            rs = stmt.executeQuery(sql);

            // Create a Metadata object from the ResultSet object
            ResultSetMetaData metaData = rs.getMetaData();

            // Process the data
            while (rs.next()) {

                int productId = rs.getInt(1);
                String prodName = rs.getString(2);

                Product newProduct = new  Product( productId,prodName);

                // Add the newcustomer to the list
                listProduct.add(newProduct  );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return listProduct;
    }

    /**
     * Method to update a single product in the products table
     * @param newProduct ,oldProduct
     * @return true if success , false if not
     */
    public static boolean updateProduct(Product oldProduct , Product newProduct) {

        boolean isSuccess = true;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "UPDATE products " +
                    "SET ProdName = ?, " +
                    "WHERE ProductId = ? ";

            // Create a Prepared Statement object
            stmt = conn.prepareStatement(sql);

            //Assign values
            stmt.setString(1, newProduct.getProdName());
            stmt.setInt(2, oldProduct.getProductId());

            // Execute the statement
            int rows = stmt.executeUpdate();

            // Check if it was successful
            if(rows == 0) {
                isSuccess = false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return isSuccess;
    }

    /**
     * Method to delete a single product from the products table
     * @param productId
     * @return 0 if not deleted , 1 if deleted
     */

    public static int deleteProduct(int productId)
    {
        int rows=0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "DELETE FROM products WHERE  ProductId= ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);
            // execute the preparedstatement
            rows= stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return rows;
    }

    /**
     * Method to add a single Product to the Products table
     * @param newProduct
     * @return 0 if not inserted , 1 if inserted
     */

    public static int addProduct(Product newProduct)
    {
        int rows = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            // Define your Connection object
            conn = dbconn.createConnection();

            String sql = "INSERT INTO products(  " +
                    " ProdName ) " +
                    " VALUES ( ? ) " ;

            stmt =conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //Assign values
            stmt.setString(1, newProduct.getProdName());

            // Execute the statement
            rows = stmt.executeUpdate();
            //this will add an id to our new agent added to the table
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                int newprodId=rs.getInt(1);
                newProduct.setProductId(newprodId);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Close the objects
            try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return rows;
 }

    /**
     * Method to get a single Product from the Product list
     * @param idprod
     * @return a product
     */

    public static Product getProduct(int idprod)
    {
        ArrayList<Product>  listProduct=getProductList();
        Product productResult=null;
        for (Product product : listProduct
        ) {
            if (product.getProductId() ==idprod    ) {
                productResult = product;
                break;
            }

        }
        return productResult;
    }



}
