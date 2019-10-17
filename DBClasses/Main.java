package travelexperts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //test customer db
  /*      System.out.println("-------------TEST customer list CUSTOMER------------------");
        ArrayList<Customer> listCustomer = CustomerDb.getCustomerList();
        for (Customer customer : listCustomer
        ) {
            System.out.println(customer.toString());
        }
        System.out.println("-------------TEST ADD CUSTOMER------------------");
        //add
        int rows  = CustomerDb.addCustomer(  new Customer(0 , "paulnew", "davis",
                "103 marlbourough", "Calgary",
                "Alberta", "T2A4E5", null, null,"4034034333",
                "salah@gmail.com", null , "salah", "chou"));

        System.out.println(rows+"");

        System.out.println("-------------TEST getCustomer CUSTOMER------------------");
        Customer cust= CustomerDb.getCustomer(104,listCustomer);
        System.out.println(cust.toString());

        System.out.println("-------------TEST update CUSTOMER------------------");
        boolean success = CustomerDb.updateCustomer(cust, new Customer(104 , "salahupdate", "cherifupdtae",
                "103 marlbouroughupdate", "Calgaryupdate",
                "Albertaupdate", "T3A5E6", null, null,"403333333",
                "salahupdate@gmail.com", null , "salahup", "chouup"));

        System.out.println(success );
        System.out.println("-------------TEST update delete customer------------------");
        Customer cust2= CustomerDb.getCustomer(145,listCustomer); //one does not have bookings
        rows =CustomerDb.deleteCustmer(cust2);
        System.out.println(rows );

   */
/*
        System.out.println("-------------TEST agent list AGENt------------------");
        ArrayList<Agent> listAgent = AgentDb.getAgentList();
        for (Agent agent : listAgent
        ) {
            System.out.println(agent.toString());
        }
      System.out.println("-------------TEST ADD Agent------------------");

        int rows  = AgentDb.addAgent(  new Agent(0, null, null, null,
                null, null, null, 2));

        System.out.println(rows+"");

        System.out.println("-------------TEST getagent Agent------------------");
        Agent agent= AgentDb.getAgent(28,listAgent);
        System.out.println(agent.toString());

        System.out.println("-------------TEST update agent------------------");
        boolean success = AgentDb.updateAgent(agent, new Agent(26, "Janet", "",
                "Delton", "(403) 210-7801", "janet.delton@travelexperts.com",
                "Senior Agent", 1));

        System.out.println(success );


        System.out.println("-------------TEST delete agent------------------");
        Agent agent2= AgentDb.getAgent(29,listAgent ); //one does not have bookings
        rows =AgentDb.deleteAgent(agent2);
        System.out.println(rows );
*/
/*
        System.out.println("-------------TEST agent list AGENt------------------");
        ArrayList<Agency> listAgency = AgencyDb.getAgencyList();
        for (Agency agency : listAgency
        ) {
            System.out.println(agency.toString());
        }

        System.out.println("-------------TEST getagency Agency------------------");
        Agency agency= AgencyDb.getAgency(1,listAgency);
        System.out.println(agency.toString());

*/

  /*      System.out.println("-------------TEST customer rewards list ------------------");
        ArrayList<Customer_rewards> listcustrwd = Customer_rewardsDb.getCustomer_rewardsList();
        for (Customer_rewards customer_rewards : listcustrwd
        ) {
            System.out.println(customer_rewards.toString());
        }

        System.out.println("-------------TEST customer rewards list getCustomer_rewardsForCustomer------------------");
        ArrayList<Customer_rewards> listcust = Customer_rewardsDb.getCustomer_rewardsForCustomer(142,listcustrwd);
        for (Customer_rewards customer_rewards : listcust
        ) {
            System.out.println(customer_rewards.toString());
        }

*/
  /*
        System.out.println("-------------TEST triptype list ------------------");
        ArrayList<TripType> listtt=TripTypeDb.getTripTypesList();
        for (TripType tt : listtt
        ) {
            System.out.println(tt.toString());
        }

        System.out.println("-------------TEST  getttby idtt------------------");
        TripType tt = TripTypeDb.getTripTypeByid("B",listtt);

        System.out.println(tt.toString());

        */

/*        System.out.println("-------------TEST Booking list ------------------");
        ArrayList<Booking> list=BookingDb.getBookingList();
        for (Booking bb : list
        ) {
            System.out.println(bb.toString());
        }

        System.out.println("-------------TEST  getbookingofcustomer idtt------------------");
        ArrayList<Booking> bblist = BookingDb.GetBookingOfCustomer(143 , list);
        for (Booking bb : bblist
        ) {
            System.out.println(bb.toString());
        }
*/
/*
        System.out.println("-------------TEST product list ------------------");
        ArrayList<Product> list=ProductDb.getProductList();
        for (Product p : list
        ) {
            System.out.println(p.toString());
        }

        System.out.println("-------------TEST  get product by id------------------");
        Product p = ProductDb.getProduct(17 , list);
            System.out.println(p.toString());


        System.out.println("-------------TEST  add Product ------------------");
        int row = ProductDb.addProduct(new Product(0,"mexico tour"));
        System.out.println(row);


        System.out.println("-------------TEST  delete Product ------------------");
        row= ProductDb.deleteProduct(p);
        System.out.println(row);

*/
  /*
        System.out.println("-------------TEST Supplier list ------------------");
        ArrayList<Supplier> list=SupplierDb.getSupplierList();
        for (Supplier s: list
        ) {
            System.out.println(s.toString());
        }

      System.out.println("-------------TEST  get Supplier by id------------------");
        Supplier p = SupplierDb.getSupplier(13597 , list);
        System.out.println(p.toString());


        System.out.println("-------------TEST  add Supplier ------------------");
        int row = SupplierDb.addSupplier(new Supplier(0,"the tour supplier"));
        System.out.println(row);


        System.out.println("-------------TEST  delete Supplier ------------------");
        row= SupplierDb.deleteSupplier(p);
        System.out.println(row);

*/
/*
        System.out.println("-------------TEST ProductSupplier list ------------------");
        ArrayList<ProductSupplier> list=ProductSupplierDb.getProductSupplierList();
        for (ProductSupplier ps: list
        ) {
            System.out.println(ps.toString());
        }

        System.out.println("-------------TEST  get ProductSupplier by id------------------");
        ProductSupplier ps = ProductSupplierDb.getProductSupplier(99 , list);
        System.out.println(ps.toString());

        System.out.println("-------------TEST  add ProductSupplier ------------------");
        int row = ProductSupplierDb.addProductSupplier(new ProductSupplier(0,null,null));
        System.out.println(row);


        System.out.println("-------------TEST  update ProductSupplier ------------------");
        boolean b= ProductSupplierDb.updateProductSupplier(ps , new ProductSupplier(0,1,1859) );
        System.out.println(b);

        System.out.println("-------------TEST  delete ProductSupplier ------------------");
        row = ProductSupplierDb.deleteProductSupplier(ps );
        System.out.println(row);
*/
/*
        System.out.println("-------------TEST PkgProductSupplier list ------------------");
        ArrayList<Package_Product_Supplier> list=Package_Product_SupplierDb.getPackageProductSupplierList();
        for (Package_Product_Supplier pps: list
        ) {
            System.out.println(pps.toString());
        }
        System.out.println("-------------TEST  get allProductSupplierof pkg id------------------");
        ArrayList <ProductSupplier> listps = Package_Product_SupplierDb.getListProdSupplierOfPkgID(4);
        System.out.println(listps);

       /* System.out.println("-------------TEST  add packageProductSupplier ------------------");
        int row = Package_Product_SupplierDb.addPackageProductSupplier(new Package_Product_Supplier(4,87));
        System.out.println(row);*/

   /*     System.out.println("-------------TEST  update ProductSupplier ------------------");
        //boolean b = Package_Product_SupplierDb.updatePackageProductSupplier(new Package_Product_Supplier(3,28),new Package_Product_Supplier(3,65));
       // System.out.println(b);

*/

        System.out.println("-------------TEST Pkg list ------------------");
        ArrayList<Package> list=PackageDb.getPackageList();
        for (Package pp: list
        ) {
            System.out.println(pp.toString());
        }
    }





    public static void main(String[] args) {
        launch(args);


    }
}
