/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietokonekauppa;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application {

    // yleiset
    Scene scene;
    TabPane tabPane;

    // ekasivu
    private Tab tab1;
    private GridPane grid1;
    //tokasivu
    private GridPane grid2;
    private Tab tab2;
    private TableView tableVarasto;

    // kolmassivu
    private GridPane grid3;
    private Tab tab3;
    private TableView table;


    //nappuloita
    private Button btnAddproduct;
    private Button btnSend;
	
    public void start(Stage primaryStage) {
		
        // Käyttöliittymän rakentaminen
        try {
            tabPane = new TabPane();
            tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

            BorderPane borderPane = new BorderPane();

            // tabit
            createTab1();
            createTab2();
            createTab3();
	        
            //Tabit tabpanee , tää ehkä pois 
            tabPane.getTabs().add(tab1);
            tabPane.getTabs().add(tab2);
            tabPane.getTabs().add(tab3);
    
            scene = new Scene(tabPane,1900, 1000);
	        
            borderPane.prefHeightProperty().bind(scene.heightProperty());
            borderPane.prefWidthProperty().bind(scene.widthProperty());

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    };
	
    // Myyntinäyttö
    private void createTab1() {
        tab1 = new Tab();
        tab1.setText("Päävalikko");

        grid1 = new GridPane();
        grid1.setHgap(30); // Horizontal gap
        grid1.setVgap(30); // Vertical gap

        // SIVUSTON KOMPONENTIT
        Text lblSales = new Text("MYYNTISIVU");	
        lblSales.setFont(Font.font(null, FontWeight.BOLD, 60));
        lblSales.setFill(Color.rgb(255, 255, 255));

        Text lblOrder = new Text("TILAUS");	
        lblOrder.setFont(Font.font(null, FontWeight.BOLD, 30));
        lblOrder.setFill(Color.rgb(255, 255, 255));

        Text lblProduct = new Text("TUOTE:");	
        lblOrder.setFont(Font.font(null, 15));
        lblOrder.setFill(Color.rgb(255, 255, 255));

        Text lblOrderAmount = new Text("MÄÄRÄ:");	
        lblOrder.setFont(Font.font(null, 15));
        lblOrder.setFill(Color.rgb(255, 255, 255));

        // ComboboXXX
        ComboBox productsdrop = new ComboBox();
        productsdrop.getItems().addAll(
            "SUPER PC3000-MASTERRACE 353225 HYPERSPEED",
            "Tietsikka2",
            "Tietsikka3",
            "Tietsikka4",
            "Tietsikka5"
        );
                ComboBox orderAmount = new ComboBox();
                orderAmount.getItems().addAll(
            "1",
            "2",
            "3",
            "4",
            "5"
        );


        btnAddproduct = new Button();
        btnAddproduct.setText("Lisää");
        btnAddproduct.setPrefSize(200, 100);


        // LISÄYKSET GRIDII
        grid1.add(lblSales,2,2,4,1);
        grid1.add(lblOrder,2,4);
        grid1.add(lblProduct,2,6);
        grid1.add(productsdrop, 2,8,4,1);
        grid1.add(lblOrderAmount, 2,10);
        grid1.add(orderAmount, 3,10);

        grid1.add(btnAddproduct,15,11);
		
        tab1.setContent(grid1);
        grid1.setStyle("-fx-background-image: url('https://cdn.images.express.co.uk/img/dynamic/36/590x/Anrold-s-568683.jpg')");

        table = new TableView();
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        Text otsikko = new Text("TILAUKSESI:");		 
        otsikko.setFont(Font.font(null, FontWeight.BOLD, 30));
        otsikko.setFill(Color.rgb(255, 255, 255));
        
        table.setEditable(true);
        
        TableColumn productCol = new TableColumn("Tuote");
        productCol.setStyle("-fx-font-size: 14pt;");
        productCol.setMinWidth(200);
        
        TableColumn amountCol = new TableColumn("Määrä");
        amountCol.setStyle("-fx-font-size: 14pt;");
        amountCol.setMinWidth(200);
        
        TableColumn priceCol = new TableColumn("Hinta");
        priceCol.setStyle("-fx-font-size: 14pt;");
        priceCol.setMinWidth(200);
        
        table.getColumns().addAll(productCol, amountCol, priceCol);
        table.setPrefHeight(250);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(otsikko, table);
				
        // gridin paikka
        grid1.add(vbox, 2, 12,10,1);


    }
    // Myyntinäyttö
    private void createTab2() {
        tab2 = new Tab();
        tab2.setText("esimerkki");
	
        grid2 = new GridPane();
        grid2.setHgap(0); // Horizontal gap
        grid2.setVgap(0); // Vertical gap
        //Text lblexample = new Text("esimerkki");
        
        // Nappula, josta saa prosessorit näkyviin
        Button btnProcessors = new Button();
        btnProcessors.setText("Prosessorit");
        btnProcessors.setPrefSize(200, 100);
        grid2.add(btnProcessors, 0, 0);
        
        // Nappula, josta saa emolevyt näkyviin
        Button btnMotherboard = new Button();
        btnMotherboard.setText("Emolevyt");
        btnMotherboard.setPrefSize(200, 100);
        grid2.add(btnMotherboard, 0, 1);
        
        // Nappula, josta saa näytönohjaimet näkyviin
        Button btnGraphics = new Button();
        btnGraphics.setText("Näytönohjaimet");
        btnGraphics.setPrefSize(200, 100);
        grid2.add(btnGraphics, 0, 2);
        
       
         // Nappula, josta saa muistit näkyviin
        Button btnRam = new Button();
        btnRam.setText("RAM");
        btnRam.setPrefSize(200, 100);
        grid2.add(btnRam, 0, 3);
        
         // Nappula, josta saa virtalähteet näkyviin
        Button btnPower = new Button();
        btnPower.setText("Virtalähteet");
        btnPower.setPrefSize(200, 100);
        grid2.add(btnPower, 0, 4);
        
         // Nappula, josta saa SSD:t näkyviin
        Button btnSsd = new Button();
        btnSsd.setText("SSD");
        btnSsd.setPrefSize(200, 100);
        grid2.add(btnSsd, 0, 5);
        
         // Nappula, josta saa HDD:t näkyviin
        Button btnHdd = new Button();
        btnHdd.setText("HHD");
        btnHdd.setPrefSize(200, 100);
        grid2.add(btnHdd, 0, 6);

        //grid2.add(lblexample,15,11);
        
        tableVarasto = new TableView();
        InnerShadow is = new InnerShadow();
        is.setOffsetX(4.0f);
        is.setOffsetY(4.0f);

        
        tableVarasto.setEditable(true);
        
        TableColumn brand = new TableColumn("Merkki");
        brand.setStyle("-fx-font-size: 14pt;");
        brand.setMinWidth(200);
        
        TableColumn product = new TableColumn("Tuote");
        product.setStyle("-fx-font-size: 14pt;");
        product.setMinWidth(500);
        
        TableColumn arriveDate = new TableColumn("Saapunut");
        arriveDate.setStyle("-fx-font-size: 14pt;");
        arriveDate.setMinWidth(200);
        
        TableColumn amount = new TableColumn("Määrä");
        amount.setStyle("-fx-font-size: 14pt;");
        amount.setMinWidth(200);
        
        TableColumn additionalInfo = new TableColumn("HUOM");
        additionalInfo.setStyle("-fx-font-size: 14pt;");
        additionalInfo.setMinWidth(500);
        
        tableVarasto.getColumns().addAll(brand, product, arriveDate, amount, additionalInfo);
        tableVarasto.setPrefHeight(700);
        tableVarasto.setPrefWidth(1600);
        
        final VBox vboxVarasto = new VBox();
        vboxVarasto.setSpacing(5);
        vboxVarasto.setPadding(new Insets(0, 0, 0, 20));
        vboxVarasto.getChildren().addAll(tableVarasto);
				
        // gridin paikka
        grid2.add(vboxVarasto, 1, 0,7,7);
        
        Button btnAddProduct = new Button();
        btnAddProduct.setText("Lisää Tuote");
        btnAddProduct.setPrefSize(200, 100);
        
        Button btnDeleteProduct = new Button();
        btnDeleteProduct.setText("Poista Tuote");
        btnDeleteProduct.setPrefSize(200, 100);
        
        Button btnAlterProduct = new Button();
        btnAlterProduct.setText("Lisää Tuote");
        btnAlterProduct.setPrefSize(200, 100);
        //grid2.add(btnAddProduct, 2, 7);

        
        
        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(30);
        buttonsBox.setPadding(new Insets(20, 20, 20, 20));
        
        buttonsBox.getChildren().addAll(btnAddProduct, btnDeleteProduct, btnAlterProduct);
        grid2.add(buttonsBox, 7, 8, 7, 10);
		
        tab2.setContent(grid2);

    }
    // Myyntinäyttö
    private void createTab3() {
        tab3 = new Tab();
        tab3.setText("Varasto");

        grid3 = new GridPane();
        grid3.setHgap(30); // Horizontal gap
        grid3.setVgap(30); // Vertical gap

        Text lblWarehouse = new Text("Varastohommia");		 

        grid3.add(lblWarehouse,15,11);
        tab3.setContent(grid3);
		
	}
                
        private void pekka(){
            int pekka;
        }
	public static void main(String[] args) {
		launch(args);
	}
}



