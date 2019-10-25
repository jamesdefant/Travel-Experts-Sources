package sample;


import java.io.FileNotFoundException;
import java.net.URL;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.application.Application;
import data.dummy.BookingData;
import javafx.scene.layout.StackPane;
*/

import java.util.ResourceBundle;

import data.AgencyDB;
import data.AgentDB;

import data.ProductDB;
import data.SupplierDB;


import data.BookingDB;
import data.CustomerDB;
import data.PackageDB;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import model.Agency;
import model.Agent;
import model.Product;
import model.Supplier;
import model.Booking;
import model.Customer;
import model.Package;


public class Controller {


    private ObservableList<Agent> agents = FXCollections.observableArrayList();
    private ObservableList<Agency> agencies = FXCollections.observableArrayList();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<Supplier> suppliers = FXCollections.observableArrayList();

    private ObservableList<Customer> customers = FXCollections.observableArrayList();
    private ObservableList<Booking> bookings = FXCollections.observableArrayList();

    private Customer selectedCustomer ; //contain the selected customer
    private ObservableList<Package> packages = FXCollections.observableArrayList(); //the list of all packages
    private Package selectedpackage ; //contain the selected package

    private String REGEX_NAME="([a-zA-Z\\s])+";
    private String REGEX_POSTAL="[A-Z][0-9][A-Z][ ][0-9][A-Z][0-9]" ;

    private String REGEX_PHONE="[0-9]{10}";
    private String REGEX_EMAIL="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+";// "[A-Z0-9+_.-]+@[A-Z0-9.-]+";
    private String REGEX_NUMBER= "[0-9]+";
    private String REGEX_USERNAME="[a-zA-Z0-9_-]+";
    private String REGEX_PASSWORD="[a-zA-Z0-9@#$%^&+=]+";
    private String ALERT_TITLE="Travel Expert Db Maintenance";



    @FXML // fx:id="tabAgents"
    private Tab tabAgents; // Value injected by FXMLLoader

    @FXML // fx:id="tabCustomers"
    private Tab tabCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="tabReview"
    private Tab tabReview; // Value injected by FXMLLoader

    @FXML // fx:id="tabFuture"
    private Tab tabFuture; // Value injected by FXMLLoader

    @FXML // fx:id="tabPackages"
    private Tab tabPackages; // Value injected by FXMLLoader

    @FXML // fx:id="tabEmployees"
    private Tab tabEmployees; // Value injected by FXMLLoader

    // @FXML // fx:id="tblSuppliers"
    //  private TableView<?> tblSuppliers; // Value injected by FXMLLoader

    @FXML // fx:id="tfSupplierId"
    private TextField tfSupplierId; // Value injected by FXMLLoader

    @FXML // fx:id="tfSupplierName"
    private TextField tfSupplierName; // Value injected by FXMLLoader


    //  @FXML // fx:id="tblProducts"
    // private TableView<?> tblProducts; // Value injected by FXMLLoader


    @FXML // fx:id="imgFired"
    private ImageView imgFired; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddProd"
    private Button btnAddProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateProd"
    private Button btnUpdateProd; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearProd"
    private Button btnClearProd; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdId"
    private TextField tfProdId; // Value injected by FXMLLoader


    @FXML // fx:id="tfProdName"
    private TextField tfProdName; // Value injected by FXMLLoader

    @FXML
    private TableColumn<String, Customer> colCustomerId, colCustFirstName, colCustLastName, colCustAddress, colCustCity,
            colCustProv,colCustPostal, colCustCountry, colCustHomePhone,colCustBusPhone,colCustAgentId ,colCustEmail,colCustusername,colCustpassword;

    @FXML
    private TableColumn<String, Booking> colBookingId,colBookingDate, colBookingNo,colTravelerCount, colTripTypeId,colPackageIdBooking;
    @FXML
    private TextField tfAgentId,  tfAgtFirstName, tfAgtMiddleInitial, tfAgtLastName, tfAgtBusPhone, tfAgtEmail, tfAgtPosition, tfAgencyId;



    @FXML // fx:id="tfProdId1"
    private TextField tfProdId1; // Value injected by FXMLLoader

    @FXML // fx:id="tfProdName1"
    private TextField tfProdName1; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddSupplier"
    private Button btnAddSupplier; // Value injected by FXMLLoader

    @FXML // fx:id="btnUpdateSupplier"
    private Button btnUpdateSupplier; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearSupplier"
    private Button btnClearSupplier; // Value injected by FXMLLoader


    @FXML // fx:id="btnUpdate3"
    private Button btnUpdate3; // Value injected by FXMLLoader


    @FXML // fx:id="tabSandP"
    private Tab tabSandP; // Value injected by FXMLLoader

    @FXML // fx:id="anpEmp2"
    private AnchorPane anpEmp2; // Value injected by FXMLLoader

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField tfUserPass;

    @FXML
    private AnchorPane anpEmp, apControls, anpEmp1, apCredentials, apControls1, anpEmp11, anpEmp3, apControls3;

    @FXML
    private TableView tblAgents, tblAgencies, tblProducts, tblSuppliers;

    @FXML
    private TableColumn<String, Agent> colAgentId, colAgtFirstName, colAgtMiddleInitial, colAgtLastName, colAgtBusPhone, colAgtEmail, colAgtPosition, colAgencyId;

    @FXML
    private TableColumn<String, Agency> colAgncyId1, colAgncyAddress, colAgncyCity,colAgncyProv, colAgncyPostal, colAgncyCountry,
            colAgncyPhone, colAgncyFax;


    @FXML
    private TableColumn<String, Product> colProductId, colProdName;

    @FXML
    private TableColumn<String, Supplier> colSupplierId, colSuppName;

    @FXML // fx:id="tfReview"
    private TextArea tfReview; // Value injected by FXMLLoader


    @FXML // fx:id="btnClearReview"
    private Button btnClearReview; // Value injected by FXMLLoader


    @FXML
    private TableView tblBookings;

    /*@FXML
    private TableColumn<?, ?> colAgentId1;

    @FXML
    private TableColumn<?, ?> colAgtFirstName1;

    @FXML
    private TableColumn<?, ?> colAgtMiddleInitial1;

    @FXML
    private TableColumn<?, ?> colAgtLastName1;

    @FXML
    private TableColumn<?, ?> colAgtBusPhone1;

    @FXML
    private TableColumn<?, ?> colAgtEmail1;

    @FXML
    private TableColumn<?, ?> colAgtPosition1;


   @FXML
    private TableColumn<?, ?> colAgncyAddress1;

    @FXML
    private TableColumn<?, ?> colAgncyCity1;

    @FXML
    private TableColumn<?, ?> colAgncyProv1;

    @FXML
    private TableColumn<?, ?> colAgncyPostal1;

    @FXML
    private TableColumn<?, ?> colAgncyCountry1;

    @FXML
    private TableColumn<?, ?> colAgncyPhone1;

    @FXML
    private TableColumn<?, ?> colAgncyFax1;

*/

    @FXML
    private TableView tblCustomers;

    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustProv;

    @FXML
    private TextField tfCustPostal;

    @FXML
    private TextField tfCustCountry;

    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustBusPhone;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private TextField tfCustUsername;

    @FXML
    //private PasswordField tfCustPassword = new PasswordField();
    private TextField tfCustPassword;

    @FXML
    private Button btnEditCustomer;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnUpdateCustomer;


 //   @FXML
  //  private Button btnExit1;


    @FXML
    private Button btnCancelCustomer;


    @FXML
    private Label lbl311;

    @FXML
    private Button btnUpdatePackage;

    @FXML
    private Button btnAddPackage;

    @FXML
    private Button btnClearPackageTF;

    @FXML
    private TableColumn<?, ?> colAgencyId1;

    @FXML
    private TextField tfCustId, tfCustMiddleInitial,  tfCustPhone, tfCustNotes, tf6,tf7, tf8,
            tf13, tf23,  tf33,  tf43, tf53,  tf63, tf73, tf83, tf93, tfPkgBasePrice, tfAgencyCommission, tfPkgName, tfUserName;


    @FXML
    private Label lblID1,  lbl11, lbl21,lbl31, lbl41,lbl71,  lbl51,  lblID11, lbl211, lbl711, lblID,  lbl1, lbl2, lbl3, lbl4, lbl7,
            lbl5, lbl64, lblID3,  lbl13, lbl23, lbl33, lbl43, lbl73, lbl53,  lbl6, lbl63, lbl83, lbl93;


    @FXML
    private Button btnApplyPackageChanges,
            btnDeletePkg, btnExit, btnInsertCustomer,  btnSaveCustomer,  btnUpdate,
            btnClearAgent, btnDeleteAgent, btnInsertAgent, btnInsert3,  btnClear3, btnApply3, btnLogin, btnLogOut;

    @FXML // fx:id="pane"
    private Pane pane; // Value injected by FXMLLoader

    @FXML
    private DatePicker datepicker13,  datepicker23, dateStartDate, dateEndDate;

    @FXML
    private ComboBox<?> cbPackageId;

    @FXML
    private TextArea taPkgDesc;

    @FXML
    private TableView  tblPackages;

    @FXML
    private TableColumn< String, Package> colPackageId, colPkgName,colPkgStartDate,colPkgEndDate,colPkgDescription, colPkgBasePrice , colPkgAgencyComm;


    public Controller() throws FileNotFoundException {
    }


    @FXML
    void btnAddProdOnMouseClick(MouseEvent event) {
        InsertProduct(); }

    @FXML
    void btnAddSupplierOnMouseClick(MouseEvent event) {
        InsertSupplier(); }

    @FXML
    void btnClearProdOnMouseClick(MouseEvent event) {
        ClearProductInputData(); }

    @FXML
    void btnClearSupplierOnMouseClick(MouseEvent event) {
        ClearSupplierInputData(); }

    @FXML
    void btnUpdateProdOnMouseClick(MouseEvent event) {
        InsertProduct(); }

    @FXML
    void btnUpdateSupplierOnMouseClick(MouseEvent event) {
        InsertSupplier(); }

   // @FXML
 //   void onActionBtnExit1(ActionEvent event) {
 //       Platform.exit();
 //   }



    Agent _selectedAgent;
    Agency _selectedAgency;

    Product _selectedProduct;
    Supplier _selectedSupplier;



    int _selectedAgentIndex;
    int _selectedAgencyIndex;
    int sendThisIndex = 1;
    int sendThisProductIndex = 1;
    int sendThisSupplierIndex = 1;


    int _selectedProductIndex;
    int _selectedSupplierIndex;


    AgentDB _agentDb;
    AgencyDB _agencyDb;

    ProductDB _productDb;
    SupplierDB _supplierDb;


    private void initRestService() {
        _agentDb = new AgentDB(new data.REST.AgentData());
        _agencyDb = new AgencyDB(new data.REST.AgencyData());

        _productDb = new ProductDB(new data.REST.ProductData());
        _supplierDb = new SupplierDB(new data.REST.SupplierData());
    }

    @FXML
    public void OnMouseEnteredLoginBtn(MouseEvent event) {
    }

    @FXML
    public void onActionBtnExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onTFpassKeyPressed(KeyEvent event) {
        CheckLoginStartPage();

    }
    final ImageView img1= new ImageView();
    final Image image2 = new Image(Main.class.getResourceAsStream("Fired.gif"));

    @FXML
    public void onActionBtnLoginClick(ActionEvent event) {
        //if login was successful, then set this after login was ran
        DisableLoginEnableLogout();
    }

    @FXML
    public void onActionBtnLogoutClick(ActionEvent event) {
        EnableLoginDisableLogout();
    }

    @FXML
    public void onUpdateAgentBtnClick(MouseEvent event) {
        UpdateAgent();
        refreshAgentTableView();
    }
    @FXML
    public void onClearAgentBtnClick(MouseEvent event) {
        ClearAgentInputData();
    }


    public void onDeleteAgentBtnClick(MouseEvent mouseEvent) {
        DeleteSelectedAgent();
        ClearAgentInputData();
        refreshAgentTableView();

        Agent _selectedAgent;
        int _selectedAgentIndex;

        Alert a = new Alert(Alert.AlertType.INFORMATION,"you are fired!!");
        a.show();

        imgFired.toFront();

}
        @FXML
    void OnMouseClickedCusttable(MouseEvent event) {
        //look for the booking list of selected customer
        //and build a new list in the booking list
        buildBookingForCustomerSelected();
    }
    void buildBookingForCustomerSelected()
    {
        //get the new selected customer
        selectedCustomer = (Customer) tblCustomers.getSelectionModel().getSelectedItem();
        //get all the bookings of the customer selected and refresh the bookings table with the values of a list of bookings
        ObservableList<Booking> bookingList= GetBookingsOfCustomer(selectedCustomer.getCustomerId());
        if (bookingList!=null)
            System.out.println(bookingList);
        //build the booking table view
        buildBookingstable(bookingList);


    }
    void createBookingTableColumns()
    {
        //table Column definition
        colBookingId = new TableColumn<>("Id");
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("BookingId"));

        colBookingDate = new TableColumn<>("Booking Date");
        colBookingDate.setCellValueFactory(new PropertyValueFactory<>("BookingDate"));


        colBookingNo = new TableColumn<>("Booking No");
        colBookingNo.setCellValueFactory(new PropertyValueFactory<>("BookingNo"));

        colTravelerCount = new TableColumn("Number of Travelers");
        colTravelerCount.setCellValueFactory(new PropertyValueFactory("TravelerCount"));

        colTripTypeId = new TableColumn<>("Trip Type");
        colTripTypeId.setCellValueFactory(new PropertyValueFactory<>("TripTypeId"));

        colPackageIdBooking= new TableColumn<>("PackageId");
        colPackageIdBooking.setCellValueFactory(new PropertyValueFactory<>("PackageId"));


        tblBookings.getColumns().add( colBookingId );
        tblBookings.getColumns().add(colBookingDate);
        tblBookings.getColumns().add(colBookingNo);
        tblBookings.getColumns().add(colTravelerCount);
        tblBookings.getColumns().add(colTripTypeId);
        tblBookings.getColumns().add(colPackageIdBooking);


    }
    //build the booking list table from given list
    void buildBookingstable(ObservableList<Booking> bookingList)
    {

        tblBookings.setItems(bookingList);
        tblBookings.refresh();

    }
    //get all the booking of a given customer id
    private ObservableList<Booking> GetBookingsOfCustomer(int CustId)
    {
        ObservableList <Booking> resultlist= FXCollections.observableArrayList() ;
        //get all the bookinglist
        BookingDB bookingDB = new BookingDB(new data.REST.BookingData());
        bookings = FXCollections.observableArrayList( bookingDB.getBookingList());

        for(Booking booking:bookings)
        {
            if (booking.getCustomerId()==CustId)
            {
                resultlist.add(booking);
            }
        }

        return resultlist;
    }



    @FXML
    void onInsertAgentBtnClick(MouseEvent event) {

        InsertAgent();
    }


    public void ClearAgentInputData(){
        tfAgentId.clear();
        tfAgtPosition.clear();
        tfAgtEmail.clear();
        tfAgtBusPhone.clear();
        tfAgtLastName.clear();
        tfAgtFirstName.clear();
        tfAgtMiddleInitial.clear();
        tfAgencyId.clear();
    }

    @FXML

    void onBtnClearReviewClicked(MouseEvent event) {
        tfReview.clear();
        tfReview.setText("Yeh. Lets re-write this review and send us a better mark! ");
    }

    @FXML
    void OnActionBtnAddCust(ActionEvent event) {

        //get the value for the new customer after validating all fields
        String errorMessageTextFields =validateTextFieldsCustomer (); // contain the error message to display to the user
        if (errorMessageTextFields.isEmpty()) {
            Customer newCustomer = getNewCustomerFromTextField();
            //disable edit and textfield and save data to db
            btnEditCustomer.setDisable(true);
            setDisableTextFieldElementCustomer(true);
            //save the new value entered by user into the db
            try {

                CustomerDB customerdb = new CustomerDB(new data.REST.CustomerData());
                String message = customerdb.insertCustomer(   newCustomer);
                //add the new customer to my list of customers
                customers.add(newCustomer);
                //refresh table with new value
                loadCustomers();
                btnUpdateCustomer.setDisable(true);
                btnEditCustomer.setDisable(false);
                System.out.println("Insert:" + message);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {

            //substring the last ","
            errorMessageTextFields= errorMessageTextFields.substring(0,errorMessageTextFields.length()-2);

            Alert alert = new Alert(Alert.AlertType.ERROR, "Check the following fields: " + errorMessageTextFields , ButtonType.OK);
            alert.setTitle(ALERT_TITLE);
            alert.setHeaderText("");
            alert.show();

        }


    }

    @FXML
    void OnActionBtnCancelCust(ActionEvent event) {
        clearCustumerTextField();
        setDisableTextFieldElementCustomer(false);
    }

    public void OnMouseClickedBooktable(MouseEvent mouseEvent) {

    }

    @FXML
    void OnActionBtnUpdateCust(ActionEvent event) {

        //call update with new customer from field
        Customer oldCustomer=selectedCustomer;

        //get the value for the new customer after validating all fields
        String errorMessageTextFields =validateTextFieldsCustomer (); // contain the error message to display to the user
        if (errorMessageTextFields.isEmpty()) {
            Customer newCustomer = getNewCustomerFromTextField();
            //disable edit and textfield and save data to db
            btnEditCustomer.setDisable(true);
            setDisableTextFieldElementCustomer(true);
            //save the new value entered by user into the db
            try {

                CustomerDB customerdb = new CustomerDB(new data.REST.CustomerData());
                String message = customerdb.updateCustomer(  oldCustomer, newCustomer);

                oldCustomer.copy(newCustomer);
                //refresh table with new value
                tblCustomers.refresh();
                btnUpdateCustomer.setDisable(true);
                btnEditCustomer.setDisable(false);
                System.out.println("Update:" + message);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {

            //substring the last ","
            errorMessageTextFields= errorMessageTextFields.substring(0,errorMessageTextFields.length()-2);

            Alert alert = new Alert(Alert.AlertType.ERROR, "Check the following fields: " + errorMessageTextFields , ButtonType.OK);
            alert.setTitle(ALERT_TITLE);
            alert.setHeaderText("");
            alert.show();

        }

    }

    @FXML
    void OnActionClickBtnEditCust(ActionEvent event) {
        loadCustomer(selectedCustomer);
        //set unable update btn
        btnUpdate.setDisable(false);
        setDisableTextFieldElementCustomer(false);

    }

    @FXML
    void initialize() {
        assert apCredentials != null : "fx:id=\"apCredentials\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfUserPass != null : "fx:id=\"tfUserPass\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfUserName != null : "fx:id=\"tfUserName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabAgents != null : "fx:id=\"tabAgents\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert anpEmp != null : "fx:id=\"anpEmp\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tblAgents != null : "fx:id=\"tblAgents\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
          assert tblAgencies != null : "fx:id=\"tblAgencies\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert apControls != null : "fx:id=\"apControls\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgentId != null : "fx:id=\"tfAgentId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtFirstName != null : "fx:id=\"tfAgtFirstName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtMiddleInitial != null : "fx:id=\"tfAgtMiddleInitial\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtLastName != null : "fx:id=\"tfAgtLastName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtBusPhone != null : "fx:id=\"tfAgtBusPhone\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lblID != null : "fx:id=\"lblID\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl64 != null : "fx:id=\"lbl64\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtEmail != null : "fx:id=\"tfAgtEmail\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgtPosition != null : "fx:id=\"tfAgtPosition\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgencyId != null : "fx:id=\"tfAgencyId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnInsertAgent != null : "fx:id=\"btnInsertAgent\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClearAgent != null : "fx:id=\"btnClearAgent\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnDeleteAgent != null : "fx:id=\"btnDeleteAgent\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabCustomers != null : "fx:id=\"tabCustomers\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert anpEmp1 != null : "fx:id=\"anpEmp1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert tblBookings != null : "fx:id=\"tblBookings\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert colAgencyId1 != null : "fx:id=\"colAgencyId1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert apControls1 != null : "fx:id=\"apControls1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert tfCustFirstName != null : "fx:id=\"tfCustFirstName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert tfCustLastName != null : "fx:id=\"tfCustLastName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert tfCustEmail != null : "fx:id=\"tfCustEmail\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert btnUpdateCustomer != null : "fx:id=\"btnUpdateCustomer\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";

        assert tabPackages != null : "fx:id=\"tabPackages\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert anpEmp11 != null : "fx:id=\"anpEmp11\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl311 != null : "fx:id=\"lbl311\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnUpdatePackage != null : "fx:id=\"btnUpdatePackage\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnAddPackage != null : "fx:id=\"btnAddPackage\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClearPackageTF != null : "fx:id=\"btnClearPackageTF\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnApplyPackageChanges != null : "fx:id=\"btnApplyPackageChanges\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnDeletePkg != null : "fx:id=\"btnDeletePkg\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lblID11 != null : "fx:id=\"lblID11\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl211 != null : "fx:id=\"lbl211\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl711 != null : "fx:id=\"lbl711\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfAgencyCommission != null : "fx:id=\"tfAgencyCommission\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert dateStartDate != null : "fx:id=\"dateStartDate\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert dateEndDate != null : "fx:id=\"dateEndDate\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert cbPackageId != null : "fx:id=\"cbPackageId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert taPkgDesc != null : "fx:id=\"taPkgDesc\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tblPackages != null : "fx:id=\"tblPackages\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPackageId != null : "fx:id=\"colPackageId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgName != null : "fx:id=\"colPkgName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgStartDate != null : "fx:id=\"colPkgStartDate\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgEndDate != null : "fx:id=\"colPkgEndDate\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgDescription != null : "fx:id=\"colPkgDescription\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgBasePrice != null : "fx:id=\"colPkgBasePrice\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert colPkgAgencyComm != null : "fx:id=\"colPkgAgencyComm\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabEmployees != null : "fx:id=\"tabEmployees\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert anpEmp3 != null : "fx:id=\"anpEmp3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert apControls3 != null : "fx:id=\"apControls3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf13 != null : "fx:id=\"tf13\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf23 != null : "fx:id=\"tf23\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf33 != null : "fx:id=\"tf33\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf43 != null : "fx:id=\"tf43\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf53 != null : "fx:id=\"tf53\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnUpdate3 != null : "fx:id=\"btnUpdate3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnInsert3 != null : "fx:id=\"btnInsert3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClear3 != null : "fx:id=\"btnClear3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert datepicker13 != null : "fx:id=\"datepicker13\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lblID3 != null : "fx:id=\"lblID3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnApply3 != null : "fx:id=\"btnApply3\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl23 != null : "fx:id=\"lbl23\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl33 != null : "fx:id=\"lbl33\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl43 != null : "fx:id=\"lbl43\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl73 != null : "fx:id=\"lbl73\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl53 != null : "fx:id=\"lbl53\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl6 != null : "fx:id=\"lbl6\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl63 != null : "fx:id=\"lbl63\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl83 != null : "fx:id=\"lbl83\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf63 != null : "fx:id=\"tf63\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf73 != null : "fx:id=\"tf73\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf83 != null : "fx:id=\"tf83\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tf93 != null : "fx:id=\"tf93\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert lbl93 != null : "fx:id=\"lbl93\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert datepicker23 != null : "fx:id=\"datepicker23\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabReview != null : "fx:id=\"tabReview\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabFuture != null : "fx:id=\"tabFuture\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tabSandP != null : "fx:id=\"tabSandP\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert anpEmp2 != null : "fx:id=\"anpEmp2\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tblSuppliers != null : "fx:id=\"tblSuppliers\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tblProducts != null : "fx:id=\"tblProducts\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnAddProd != null : "fx:id=\"btnAddProd\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnUpdateProd != null : "fx:id=\"btnUpdateProd\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClearProd != null : "fx:id=\"btnClearProd\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfProdId != null : "fx:id=\"tfProdId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfProdName != null : "fx:id=\"tfProdName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfProdId1 != null : "fx:id=\"tfProdId1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfProdName1 != null : "fx:id=\"tfProdName1\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnAddSupplier != null : "fx:id=\"btnAddSupplier\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnUpdateSupplier != null : "fx:id=\"btnUpdateSupplier\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClearSupplier != null : "fx:id=\"btnClearSupplier\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfSupplierId != null : "fx:id=\"tfSupplierId\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfSupplierName != null : "fx:id=\"tfSupplierName\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert imgFired != null : "fx:id=\"imgFired\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfReview != null : "fx:id=\"tfReview\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert btnClearReview != null : "fx:id=\"btnClearReview\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
        assert tfReview != null : "fx:id=\"tfReview\" was not injected: check your FXML file 'ExampleLayoutAlexo_mergedversion.fxml'.";
    //    assert btnExit1 != null : "fx:id=\"btnExit1\" was not injected: check your FXML file." ;

        loadAgents();
        LoadAgencies();
        loadProducts();
        loadSuppliers();


        DisableAll(); //disable all tabs until valid credintials have been provided
        CheckLoginStartPage();


        //When a user clicks on an agent in a table, this will populate the individual agent
        tblAgents.setOnMouseClicked((MouseEvent eventAgt) -> {
                    if (eventAgt.getButton().equals(MouseButton.PRIMARY)) {
                        int indexAgt = tblAgents.getSelectionModel().getSelectedIndex();
                        _selectedAgent = (Agent) tblAgents.getItems().get(indexAgt);
                        _selectedAgentIndex = indexAgt;

                        System.out.println("Selected Agent" + _selectedAgent.toString());
                        System.out.println("Selected AgentIndex" + _selectedAgentIndex);

                        tfAgentId.setText(String.valueOf(_selectedAgent.getAgentId()));
                        tfAgtFirstName.setText(_selectedAgent.getAgtFirstName());
                        tfAgtMiddleInitial.setText(_selectedAgent.getAgtMiddleInitial());
                        tfAgtLastName.setText(_selectedAgent.getAgtLastName());
                        tfAgtBusPhone.setText(_selectedAgent.getAgtBusPhone());
                        tfAgtEmail.setText(_selectedAgent.getAgtEmail());
                        tfAgtPosition.setText(_selectedAgent.getAgtPosition());
                        tfAgencyId.setText(String.valueOf(_selectedAgent.getAgencyId()));
                        sendThisIndex = Integer.valueOf(_selectedAgent.getAgencyId());
                        //  LoadAgency(sendThisIndex);
                        RefreshAgencyTableViewSingle(sendThisIndex);
                        imgFired.toBack();
                    }
                }
        );

        //code to add when an agency is selected
        tblAgencies.setOnMouseClicked((MouseEvent event) -> {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        sendThisIndex =  Integer.valueOf(_selectedAgent.getAgencyId());
//input code to show only the agents who are in that agency

                    }
                }
        );
        loadAgents();
        //load all the customers in the db
        loadCustomers();
        //load just the header of the booking table
        createBookingTableColumns();
        //load the booking of the selected customer -the first customer
        buildBookingForCustomerSelected( );

        //load all the packages in the db
        //   loadPackages();
        ////





        tblProducts.setOnMouseClicked((MouseEvent eventP) -> {
                    if (eventP.getButton().equals(MouseButton.PRIMARY)) {
                        int indexP = tblProducts.getSelectionModel().getSelectedIndex();
                        _selectedProduct = (Product) tblProducts.getItems().get(indexP);
                        _selectedProductIndex = indexP;

                        System.out.println("Selected Product" + _selectedProduct.toString());
                        System.out.println("Selected ProductIndex" + _selectedProductIndex);

                        tfProdId.setText(String.valueOf(_selectedProduct.getProductId()));
                        tfProdName.setText(_selectedProduct.getProdName());

                        sendThisProductIndex = Integer.valueOf(_selectedProduct.getProductId());
                        //  LoadAgency(sendThisIndex);
                        RefreshProductsTableView();
                    }
                }
        );

        tblSuppliers.setOnMouseClicked((MouseEvent eventS) -> {
                    if (eventS.getButton().equals(MouseButton.PRIMARY)) {
                        int indexS = tblSuppliers.getSelectionModel().getSelectedIndex();
                        _selectedSupplier = (Supplier) tblSuppliers.getItems().get(indexS);
                        _selectedSupplierIndex = indexS;

                        System.out.println("Selected Supplier" + _selectedSupplier.toString());
                        System.out.println("Selected SupplierIndex" + _selectedSupplierIndex);

                        tfSupplierId.setText(String.valueOf(_selectedSupplier.getSupplierId()));
                        tfSupplierName.setText(_selectedSupplier.getSupName());

                        sendThisSupplierIndex = Integer.valueOf(_selectedSupplier.getSupplierId());
                        //  LoadAgency(sendThisIndex);
                        RefreshSuppliersTableView();
                    }
                }
        );
    }
    //load all the packages into the packages table
    void loadPackages()
    {
        tblPackages.refresh();
        PackageDB packageDB = new PackageDB(new data.REST.PackageData());
        packages = null;//FXCollections.observableArrayList( packageDB.getPackageList());

        //define the table column
        colPackageId = new TableColumn<>("Id");
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("PackageId"));

        colPkgName = new TableColumn<>("Package Name");
        colPkgName.setCellValueFactory(new PropertyValueFactory<>("PkgName"));


        colPkgStartDate = new TableColumn<>("Start Date");
        colPkgStartDate.setCellValueFactory(new PropertyValueFactory<>("PkgStartDate"));

        colPkgEndDate = new TableColumn<>("End Date");
        colPkgEndDate.setCellValueFactory(new PropertyValueFactory<>("PkgEndDate"));

        colPkgDescription = new TableColumn<>("Description");
        colPkgDescription.setCellValueFactory(new PropertyValueFactory<>("PkgDescription"));

        colPkgBasePrice = new TableColumn<>("Base price");
        colPkgBasePrice.setCellValueFactory(new PropertyValueFactory<>("PkgBasePrice"));

        colPkgAgencyComm= new TableColumn<>("Commission");
        colPkgAgencyComm.setCellValueFactory(new PropertyValueFactory<>("PkgAgencyCommission"));



        tblPackages.getColumns().add(colPackageId);
        tblPackages.getColumns().add(colPkgName);
        tblPackages.getColumns().add(colPkgStartDate);
        tblPackages.getColumns().add(colPkgEndDate);
        tblPackages.getColumns().add(colPkgDescription);
        tblPackages.getColumns().add(colPkgBasePrice);
        tblPackages.getColumns().add(colPkgAgencyComm);

       /* tblPackages.setItems(packages);


        if (packages.size() != 0)
            selectedpackage=packages.get(0);
        tblPackages.getSelectionModel().select(0);

*/

    }



    //validate all the textfield return false if we find errors
    public String validateTextFieldsCustomer()
    {
        //this will verify all the user entry and return result in valid
        Validate valid =new Validate();
        String errorMessage=
                valid.validateTextField(tfCustFirstName.getText(),REGEX_NAME,2,25,"First Name") +
                        valid.validateTextField(tfCustLastName.getText(),REGEX_NAME,2,25,"Last Name")+
                        valid.validateTextFieldNoRegexp(tfCustAddress.getText(),6,75,"Address")+
                        valid.validateTextField(tfCustCity.getText(),REGEX_NAME,2,25,"City")+
                        valid.validateTextField(tfCustProv.getText(),REGEX_NAME,2,25,"Province")+
                        valid.validateTextField(tfCustPostal.getText(),REGEX_POSTAL,7,7,"Postal Code")+
                        valid.validateTextFieldNullValue(tfCustCountry.getText(),REGEX_NAME,25,"Country")+
                        valid.validateTextFieldNullValue(tfCustHomePhone.getText(),REGEX_PHONE,10,"Home Phone")+
                        valid.validateTextField(tfCustBusPhone.getText(),REGEX_PHONE,10,10,"Business Phone")+
                        valid.validateTextField(tfCustEmail.getText(),REGEX_EMAIL,6,50,"Email")+
                        valid.validateTextFieldNullValue(tfAgentId.getText(),REGEX_NUMBER,11,"Agent Id")+
                        valid.validateTextFieldNullValue(tfCustUsername.getText(),REGEX_USERNAME,20,"Username")+
                        valid.validateTextFieldNullValue(tfCustPassword.getText(),REGEX_PASSWORD,20,"Password");

        return errorMessage;
    }
    //set disable to all textfield with value in status
    public void setDisableTextFieldElementCustomer( boolean status)
    {
        tfCustomerId.setDisable(true);
        tfCustFirstName.setDisable(status);
        tfCustLastName.setDisable(status);
        tfCustAddress.setDisable(status);
        tfCustBusPhone.setDisable(status);
        tfCustHomePhone.setDisable(status);
        tfCustCity.setDisable(status);
        tfCustProv.setDisable(status);
        tfCustEmail.setDisable(status);
        tfCustPostal.setDisable(status);
        tfCustCountry.setDisable(status);
        tfAgentId.setDisable(status);
        tfCustUsername.setDisable(status);
        tfCustPassword.setDisable(status);

    }

    //get new customer from textfield after checking data entered by the user
    public Customer getNewCustomerFromTextField()
    {
        Customer newCustomer = new
                Customer( Integer.parseInt( tfCustomerId.getText().toString() ), tfCustFirstName.getText(), tfCustLastName.getText(), tfCustAddress.getText(),
                tfCustCity.getText(), tfCustProv.getText(), tfCustPostal.getText(), tfCustCountry.getText()
                ,tfCustHomePhone.getText(), tfCustBusPhone.getText(), tfCustEmail.getText(),Integer.parseInt( tfAgentId.getText()), tfCustUsername.getText(),
                tfCustPassword.getText());

        return newCustomer;
    }

    //load customer field with value in cust
    public void loadCustomer(Customer cust)
    {
        clearCustumerTextField();
        tfCustomerId.setText(cust.getCustomerId()+"");
        tfCustomerId.setDisable(true);
        tfCustFirstName.setText(cust.getCustFirstName().trim());
        tfCustLastName.setText(cust.getCustLastName().trim());
        tfCustAddress.setText(cust.getCustAddress().trim());
        tfCustBusPhone.setText(cust.getCustBusPhone().trim());
        tfCustHomePhone.setText(cust.getCustHomePhone().trim());
        tfCustCity.setText(cust.getCustCity().trim());
        tfCustProv.setText(cust.getCustProv().trim());
        tfCustEmail.setText(cust.getCustEmail().trim());
        tfCustPostal.setText(cust.getCustPostal().trim());
        tfCustCountry.setText(cust.getCustCountry().trim());
        tfAgentId.setText(cust.getAgentId()+"");
        tfCustUsername.setText(cust.getCustusername().trim());
        tfCustPassword.setText(cust.getCustpassword().trim());
        tfCustFirstName.requestFocus();

    }

    public void clearCustumerTextField()
    {
        tfCustomerId.clear();
        tfCustFirstName.clear();
        tfCustLastName.clear();
        tfCustAddress.clear();
        tfCustBusPhone.clear();
        tfCustHomePhone.clear();
        tfCustCity.clear();
        tfCustProv.clear();
        tfCustEmail.clear();
        tfCustPostal.clear();
        tfCustCountry.clear();
        tfAgentId.clear();
        tfCustUsername.clear();
        tfCustPassword.clear();

    }


    public void loadCustomers()
    {

        tblCustomers.refresh();
        CustomerDB customerDB = new CustomerDB(new data.REST.CustomerData());
        customers = FXCollections.observableArrayList( customerDB.getCustomerList());

        //properties access method
        colCustomerId = new TableColumn<>("Id");
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));

        colCustFirstName = new TableColumn<>("First Name");
        colCustFirstName.setCellValueFactory(new PropertyValueFactory<>("CustFirstName"));


        colCustLastName = new TableColumn<>("Last Name");
        colCustLastName.setCellValueFactory(new PropertyValueFactory<>("CustLastName"));

        colCustAddress = new TableColumn<>("Address");
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));

        colCustCity = new TableColumn<>("City");
        colCustCity.setCellValueFactory(new PropertyValueFactory<>("CustCity"));

        colCustProv = new TableColumn<>("Province");
        colCustProv.setCellValueFactory(new PropertyValueFactory<>("CustProv"));

        colCustPostal= new TableColumn<>("Postal Code");
        colCustPostal.setCellValueFactory(new PropertyValueFactory<>("CustPostal"));

        colCustCountry= new TableColumn<>("Country");
        colCustCountry.setCellValueFactory(new PropertyValueFactory<>("CustCountry"));

        colCustHomePhone= new TableColumn<>("Home Phone");
        colCustHomePhone.setCellValueFactory(new PropertyValueFactory<>("CustHomePhone"));

        colCustBusPhone= new TableColumn<>("Business Phone");
        colCustBusPhone.setCellValueFactory(new PropertyValueFactory<>("CustBusPhone"));

        colCustEmail= new TableColumn<>("Email");
        colCustEmail.setCellValueFactory(new PropertyValueFactory<>("CustEmail"));

        colCustAgentId= new TableColumn<>("Agent Id");
        colCustAgentId.setCellValueFactory(new PropertyValueFactory<>("AgentId"));

        colCustusername= new TableColumn<>("Username");
        colCustusername.setCellValueFactory(new PropertyValueFactory<>("Custusername"));

        colCustpassword= new TableColumn<>("Password");
        colCustpassword.setCellValueFactory(new PropertyValueFactory<>("Custpassword"));



        tblCustomers.getColumns().add(colCustomerId);
        tblCustomers.getColumns().add(colCustFirstName);
        tblCustomers.getColumns().add(colCustLastName);
        tblCustomers.getColumns().add(colCustAddress);
        tblCustomers.getColumns().add(colCustCity);
        tblCustomers.getColumns().add(colCustProv);
        tblCustomers.getColumns().add(colCustPostal);
        tblCustomers.getColumns().add(colCustCountry);
        tblCustomers.getColumns().add(colCustHomePhone);
        tblCustomers.getColumns().add(colCustBusPhone);
        tblCustomers.getColumns().add(colCustEmail);
        tblCustomers.getColumns().add(colCustAgentId);
        tblCustomers.getColumns().add(colCustusername);
        tblCustomers.getColumns().add(colCustpassword);


        for (Customer a: customers ) {
            tblCustomers.getItems().add(a);
        }

        if (customers.size() != 0)
            selectedCustomer=customers.get(0);
        tblCustomers.getSelectionModel().select(0);

        //set disable the update btn  , until we click on edit then it will become enable again
        btnUpdate.setDisable(true);
        clearCustumerTextField();
        setDisableTextFieldElementCustomer(false);



    }

    public void  CheckLoginStartPage()
    {
        if (tfUserName.getLength()  > 1  && tfUserPass.getLength() > 1  ) {
            btnLogin.setDisable(false);
        } else {
            btnLogin.setDisable(true);
        }

    }


    //method below will enable login and disable logout button
    //run it as default or when login was NOT successful
    public void EnableLoginDisableLogout() {
        tfUserName.setDisable(false);
        tfUserPass.setDisable(false);
        tfUserName.clear();
        tfUserPass.clear();

        btnLogin.setDisable(false);
        btnLogOut.setDisable(true);

        tabAgents.setDisable(true);
        tabSandP.setDisable(true);
        tabCustomers.setDisable(true);
        tabFuture.setDisable(true);
        tabPackages.setDisable(true);
        tabReview.setDisable(true);
    }

    //method below will disable login and enable logout button
    //run it when login was SUCCESSFUL
    public void DisableLoginEnableLogout() {
        btnLogin.setDisable(true);
        tfUserName.setDisable(true);
        tfUserPass.setDisable(true);
        btnLogOut.setDisable(false);

        tabAgents.setDisable(false);
        tabSandP.setDisable(false);
        tabCustomers.setDisable(false);

        tabFuture.setDisable(false);
        tabPackages.setDisable(false);
        tabReview.setDisable(false);
    }

    public void DisableAll(){
        btnLogin.setDisable(true);
        btnLogOut.setDisable(true);
        tabAgents.setDisable(true);
        tabSandP.setDisable(true);
        tabCustomers.setDisable(true);

        tabFuture.setDisable(true);
        tabPackages.setDisable(true);
        tabReview.setDisable(true);
    }


    public void loadAgents() {
//loads all agents into the table
        _agentDb = new AgentDB(new data.REST.AgentData());
        agents = FXCollections.observableArrayList( _agentDb.getAgentList());

        colAgentId = new TableColumn<>("Id");
        colAgentId.setCellValueFactory(new PropertyValueFactory<>("agentId"));

        colAgtFirstName = new TableColumn<>("First Name");
        colAgtFirstName.setCellValueFactory(new PropertyValueFactory<>("agtFirstName"));

        colAgtMiddleInitial = new TableColumn<>("Middle Initial");
        colAgtMiddleInitial.setCellValueFactory(new PropertyValueFactory<>("agtMiddleInitial"));

        colAgtLastName = new TableColumn<>("Last Name");
        colAgtLastName.setCellValueFactory(new PropertyValueFactory<>("agtLastName"));

        colAgtBusPhone = new TableColumn<>("Business Phone");
        colAgtBusPhone.setCellValueFactory(new PropertyValueFactory<>("agtBusPhone"));

        colAgtEmail = new TableColumn<>("Email");
        colAgtEmail.setCellValueFactory(new PropertyValueFactory<>("agtEmail"));

        colAgtPosition = new TableColumn<>("Position");
        colAgtPosition.setCellValueFactory(new PropertyValueFactory<>("agtPosition"));

        colAgencyId= new TableColumn<>("Agency Id");
        colAgencyId.setCellValueFactory(new PropertyValueFactory<>("agencyId"));

        tblAgents.getColumns().add(colAgentId);
        tblAgents.getColumns().add(colAgtFirstName);
        tblAgents.getColumns().add(colAgtMiddleInitial);
        tblAgents.getColumns().add(colAgtLastName);
        tblAgents.getColumns().add(colAgtBusPhone);
        tblAgents.getColumns().add(colAgtEmail);
        tblAgents.getColumns().add(colAgtPosition);
        tblAgents.getColumns().add(colAgencyId);

        refreshAgentTableView();
        RefreshAgencyTableView();
        //RefreshAgencyTableViewSingle(sendThisIndex);
    }

    public void loadProducts() {
        //loads all products
        _productDb = new ProductDB(new data.REST.ProductData());
        products = FXCollections.observableArrayList(_productDb.getProductList());

        colProductId = new TableColumn<>("Product Id");
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));

        colProdName= new TableColumn<>("Product Name");
        colProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));

        tblProducts.getColumns().add(colProductId);
        tblProducts.getColumns().add(colProdName);
        RefreshProductsTableView();
    }

    public void loadSuppliers() {
        //loads all suppliers
        _supplierDb = new SupplierDB(new data.REST.SupplierData());
        suppliers = FXCollections.observableArrayList(_supplierDb.getSupplierList());

        colSupplierId = new TableColumn<>("Supplier Id");
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));

        colSuppName= new TableColumn<>("Supplier Name");
        colSuppName.setCellValueFactory(new PropertyValueFactory<>("supName"));

        tblSuppliers.getColumns().add(colSupplierId);
        tblSuppliers.getColumns().add(colSuppName);
        RefreshSuppliersTableView();
    }




    public void LoadAgencies(){
        _agencyDb = new AgencyDB(new data.REST.AgencyData());
        agencies = FXCollections.observableArrayList( _agencyDb.getAgencyList());

        colAgencyId1 = new TableColumn<>("Id");
        colAgencyId1.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));

        colAgncyAddress = new TableColumn<>("Address");
        colAgncyAddress.setCellValueFactory(new PropertyValueFactory<>("AgncyAddress"));

        colAgncyCity= new TableColumn<>("City");
        colAgncyCity.setCellValueFactory(new PropertyValueFactory<>("AgncyCity"));

        colAgncyProv = new TableColumn<>("Province");
        colAgncyProv.setCellValueFactory(new PropertyValueFactory<>("AgncyProv"));

        colAgncyPostal = new TableColumn<>("Postal Code");
        colAgncyPostal.setCellValueFactory(new PropertyValueFactory<>("AgncyPostal"));

        colAgncyCountry = new TableColumn<>("Country");
        colAgncyCountry.setCellValueFactory(new PropertyValueFactory<>("AgncyCountry"));

        colAgncyPhone = new TableColumn<>("Phone");
        colAgncyPhone.setCellValueFactory(new PropertyValueFactory<>("AgncyPhone"));

        colAgncyFax= new TableColumn<>("Fax");
        colAgncyFax.setCellValueFactory(new PropertyValueFactory<>("AgncyFax"));

        tblAgencies.getColumns().add(colAgencyId1);
        tblAgencies.getColumns().add(colAgncyAddress);
        tblAgencies.getColumns().add(colAgncyCity);
        tblAgencies.getColumns().add(colAgncyProv);
        tblAgencies.getColumns().add(colAgncyPostal);
        tblAgencies.getColumns().add(colAgncyCountry);
        tblAgencies.getColumns().add(colAgncyPhone);
        tblAgencies.getColumns().add(colAgncyFax);
        RefreshAgencyTableView();
    }

//    public void LoadAgency(int X){
//        _agencyDb = new AgencyDB(new data.dummy.AgencyData());
//        agencies = FXCollections.observableArrayList( _agencyDb.getAgency(X));
//        colAgencyId1 = new TableColumn<>("Id");
//        colAgencyId1.setCellValueFactory(new PropertyValueFactory<>("AgencyId"));
//
//        colAgncyAddress = new TableColumn<>("Address");
//        colAgncyAddress.setCellValueFactory(new PropertyValueFactory<>("AgncyAddress"));
//
//        colAgncyCity= new TableColumn<>("City");
//        colAgncyCity.setCellValueFactory(new PropertyValueFactory<>("AgncyCity"));
//
//        colAgncyProv = new TableColumn<>("Province");
//        colAgncyProv.setCellValueFactory(new PropertyValueFactory<>("AgncyProv"));
//
//        colAgncyPostal = new TableColumn<>("Postal Code");
//        colAgncyPostal.setCellValueFactory(new PropertyValueFactory<>("AgncyPostal"));
//
//        colAgncyCountry = new TableColumn<>("Country");
//        colAgncyCountry.setCellValueFactory(new PropertyValueFactory<>("AgncyCountry"));
//
//        colAgncyPhone = new TableColumn<>("Phone");
//        colAgncyPhone.setCellValueFactory(new PropertyValueFactory<>("AgncyPhone"));
//
//        colAgncyFax= new TableColumn<>("Fax");
//        colAgncyFax.setCellValueFactory(new PropertyValueFactory<>("AgncyFax"));
//
//        tblAgencies.getColumns().add(colAgencyId1);
//        tblAgencies.getColumns().add(colAgncyAddress);
//        tblAgencies.getColumns().add(colAgncyCity);
//        tblAgencies.getColumns().add(colAgncyProv);
//        tblAgencies.getColumns().add(colAgncyPostal);
//        tblAgencies.getColumns().add(colAgncyCountry);
//        tblAgencies.getColumns().add(colAgncyPhone);
//        tblAgencies.getColumns().add(colAgncyFax);
//        RefreshAgencyTableView();
//    }

    private void refreshAgentTableView() {
        tblAgents.getItems().clear();

        for (Agent a: agents ) {
            tblAgents.getItems().add(a);
        }
    }

    private void RefreshAgencyTableView() {
        tblAgencies.getItems().clear();

        for (Agency ay: agencies) {
            tblAgencies.getItems().add(ay);
        }
    }
    private void RefreshProductsTableView() {
        tblProducts.getItems().clear();

        for (Product py: products) {
            tblProducts.getItems().add(py);
        }
    }
    private void RefreshSuppliersTableView() {
        tblSuppliers.getItems().clear();

        for (Supplier sy: suppliers) {
            tblSuppliers.getItems().add(sy);
        }
    }


    private void RefreshAgencyTableViewSingle(int x) {
        tblAgencies.getItems().clear();
        Agency ay = _agencyDb.getAgency(x);
        tblAgencies.getItems().add(ay);
    }

    private void RefreshProductTableViewSingle(int xP) {
        tblProducts.getItems().clear();
        Product py = _productDb.getProduct(xP);
        tblProducts.getItems().add(py);
    }

    /*
    private void RefreshSupplierTableViewSingle(int xS) {
        tblSuppliers.getItems().clear();
        Supplier sy = _supplierDb.getSupplier(xS);

        for (Supplier sy: suppliers) {
            tblSuppliers.getItems().add(sy);
        }

    }  */


    public void UpdateProduct(){
        try {
            // VALIDATE !!!
            if(true) {

                int productId = Integer.parseInt(tfProdId.getText().trim());

                String newProdName = tfProdName.getText().trim();

                Product newProduct = new Product(productId, newProdName);

                _productDb = new ProductDB(new data.REST.ProductData());
                String message = _productDb.updateProduct(_selectedProduct, newProduct);
                RefreshProductsTableView();
                System.out.println("Update product so it doesn't go stale:" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateSupplier(){
        try {
            // VALIDATE !!!
            if(true) {

                int supplierId = Integer.parseInt(tfSupplierId.getText().trim());
                String newSuppName = tfSupplierName.getText().trim();

                Supplier newSupplier = new Supplier(supplierId, newSuppName);

                _supplierDb = new SupplierDB(new data.REST.SupplierData());
                String message = _supplierDb.updateSupplier(_selectedSupplier, newSupplier);
                RefreshSuppliersTableView();
                System.out.println("Update supplier:" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void UpdateAgent(){
        try {
            // VALIDATE !!!
            if(true) {

                int agentId = Integer.parseInt(tfAgentId.getText().trim());
                Integer newAgencyId = Integer.parseInt(tfAgencyId.getText().trim());
                String newagtFirstName = tfAgtFirstName.getText().trim();
                String newagtMiddleInitial = tfAgtMiddleInitial.getText().trim();
                String newagtLastName = tfAgtLastName.getText().trim();
                String newagtBusPhone = tfAgtBusPhone.getText().trim();
                String newagtEmail = tfAgtEmail.getText().trim();
                String newagtPosition = tfAgtPosition.getText().trim();

                Agent newAgent = new Agent(agentId, newagtFirstName, newagtMiddleInitial, newagtLastName, newagtBusPhone, newagtEmail, newagtPosition, newAgencyId, null, null );

                _agentDb = new AgentDB(new data.REST.AgentData());
                String message = _agentDb.updateAgent(_selectedAgent, newAgent);
                refreshAgentTableView();
                System.out.println("Update:" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void DeleteSelectedAgent(){
        int agentId = Integer.parseInt(tfAgentId.getText());
        String message = _agentDb.deleteAgent(agentId);
        refreshAgentTableView();
        System.out.println("Agent# " + agentId + " was deleted." + message);
    }


    public void InsertAgent(){

        try {
            // VALIDATE !!!
            if(true) {
                int agentId = 999;
                Integer newAgencyId = Integer.parseInt(tfAgencyId.getText().trim());
                String newagtFirstName = tfAgtFirstName.getText().trim();
                String newagtMiddleInitial = tfAgtMiddleInitial.getText().trim();
                String newagtLastName = tfAgtLastName.getText().trim();
                String newagtBusPhone = tfAgtBusPhone.getText().trim();
                String newagtEmail = tfAgtEmail.getText().trim();
                String newagtPosition = tfAgtPosition.getText().trim();

                Agent newAgent = new Agent(agentId, newagtFirstName, newagtMiddleInitial, newagtLastName, newagtBusPhone, newagtEmail, newagtPosition, newAgencyId, null, null );
                _agentDb = new AgentDB(new data.REST.AgentData());
                String message = _agentDb.insertAgent(newAgent);
                refreshAgentTableView();
                System.out.println("Added new fresh meat#: " + message);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Fresh meat on our team!");
                a.show();

                ClearAgentInputData();}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void InsertProduct(){
        try {
            // VALIDATE !!!
            if(true) {
                int productId = 999;
                Integer newProductId = Integer.parseInt(tfProdId.getText().trim());
                String newProdName = tfProdName.getText().trim();

                Product newProduct = new Product(newProductId, newProdName);
                _productDb = new ProductDB(new data.REST.ProductData());
                String message = _productDb.insertProduct(newProduct);
                RefreshProductsTableView();
                System.out.println("New product, (not viagra!!!), added:" + message);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Fresh products for our customers!!!");
                a.show();

                ClearProductInputData(); }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertSupplier(){
        try {
            // VALIDATE !!!
            if(true) {
                int supplierId = 999;
                Integer newSupplierId = Integer.parseInt(tfSupplierId.getText().trim());
                String newSupplierName = tfSupplierName.getText().trim();

                Supplier newSupplier = new Supplier(newSupplierId, newSupplierName);
                _supplierDb = new SupplierDB(new data.REST.SupplierData());
                String message = _supplierDb.insertSupplier(newSupplier);
                RefreshSuppliersTableView();
                System.out.println("New (non illegal drug) supplier added:" + message);
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Fresh supplier was successfully added!");
                a.show();

                ClearSupplierInputData();  }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ClearProductInputData() {
        tfProdId.clear();
        tfProdName.clear();
    }
    private void ClearSupplierInputData() {
        tfSupplierId.clear();
        tfSupplierName.clear();
    }
}
