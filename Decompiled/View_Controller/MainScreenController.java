/*     */ package View_Controller;
/*     */ 
/*     */ import Model.Inventory;
/*     */ import Model.Part;
/*     */ import Model.Product;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.Optional;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.event.ActionEvent;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.scene.Parent;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.Button;
/*     */ import javafx.scene.control.ButtonType;
/*     */ import javafx.scene.control.TableColumn;
/*     */ import javafx.scene.control.TableView;
/*     */ import javafx.scene.control.TextField;
/*     */ import javafx.scene.control.cell.PropertyValueFactory;
/*     */ import javafx.stage.Stage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MainScreenController
/*     */   implements Initializable
/*     */ {
/*     */   Stage stage;
/*     */   Parent scene;
/*  48 */   private ObservableList<Part> selectedParts = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  51 */   private ObservableList<Product> selectedProducts = FXCollections.observableArrayList();
/*     */   
/*     */   public static Part partToModify;
/*     */   
/*     */   public static Product productToModify;
/*     */   
/*     */   @FXML
/*     */   private TableView<Product> mainScreenProductsTableView;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Product, Integer> mainScreenProductIDCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Product, String> mainScreenProductNameCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Product, Integer> mainScreenProductInvLvlCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Product, Double> mainScreenProductPPUCol;
/*     */   
/*     */   @FXML
/*     */   private TableView<Part> mainScreenPartsTableView;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Part, Integer> mainScreenPartIDCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Part, String> mainScreenPartNameCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Part, Integer> mainScreenPartInvLvlCol;
/*     */   
/*     */   @FXML
/*     */   private TableColumn<Part, Double> mainScreenPartPPUCol;
/*     */   
/*     */   @FXML
/*     */   private TextField mainProductsSearchTxt;
/*     */   
/*     */   @FXML
/*     */   private Button mainProductsSearchBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainProductsAddBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainProductsModifyBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainProductsDeleteBtn;
/*     */   
/*     */   @FXML
/*     */   private TextField mainPartsSearchTxt;
/*     */   
/*     */   @FXML
/*     */   private Button mainPartsSearchBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainPartsAddBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainPartsAllBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainProductsAllBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainPartsModifyBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainPartsDeleteBtn;
/*     */   
/*     */   @FXML
/*     */   private Button mainExitBtn;
/*     */ 
/*     */   
/*     */   public void changeScene(ActionEvent event, String resource) throws IOException {
/* 128 */     this.stage = (Stage)((Button)event.getSource()).getScene().getWindow();
/*     */     
/* 130 */     this.scene = FXMLLoader.<Parent>load(getClass().getResource(resource));
/*     */     
/* 132 */     this.stage.setScene(new Scene(this.scene));
/*     */     
/* 134 */     this.stage.show();
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAllParts(ActionEvent event) {
/* 140 */     this.mainScreenPartsTableView.setItems(Inventory.getAllParts());
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAllProducts(ActionEvent event) {
/* 146 */     this.mainScreenProductsTableView.setItems(Inventory.getAllProducts());
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddPart(ActionEvent event) throws IOException {
/* 152 */     String resource = "/View_Controller/addPartScreen.fxml";
/* 153 */     changeScene(event, resource);
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddProduct(ActionEvent event) throws IOException {
/* 159 */     String resource = "/View_Controller/addProductScreen.fxml";
/* 160 */     changeScene(event, resource);
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionDeletePart(ActionEvent event) {
/* 166 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 167 */     alert.setTitle("Confirmation");
/* 168 */     alert.setContentText("Permanently delete this part?");
/* 169 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 170 */     if (userInput.get() == ButtonType.OK) {
/*     */       
/* 172 */       Part part = this.mainScreenPartsTableView.getSelectionModel().getSelectedItem();
/*     */       
/* 174 */       for (Product associatedProduct : part.getAllAssociatedProducts()) {
/* 175 */         associatedProduct.deleteAssociatedPart(part);
/*     */       }
/*     */       
/* 178 */       Inventory.deletePart(part);
/* 179 */       this.mainScreenPartsTableView.setItems(Inventory.getAllParts());
/*     */     } else {
/* 181 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionDeleteProduct(ActionEvent event) {
/* 188 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 189 */     alert.setTitle("Confirmation");
/* 190 */     alert.setContentText("Permanently delete this product?");
/* 191 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 192 */     if (userInput.get() == ButtonType.OK) {
/*     */       
/* 194 */       Product product = this.mainScreenProductsTableView.getSelectionModel().getSelectedItem();
/*     */       
/* 196 */       for (Part associatedPart : product.getAllAssociatedParts()) {
/* 197 */         associatedPart.deleteAssociatedProduct(product);
/*     */       }
/* 199 */       Inventory.deleteProduct(product);
/* 200 */       this.mainScreenProductsTableView.setItems(Inventory.getAllProducts());
/*     */     } else {
/* 202 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionExit(ActionEvent event) {
/* 209 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 210 */     alert.setTitle("Confirmation");
/* 211 */     alert.setContentText("Exit the program?");
/* 212 */     Optional<ButtonType> userInput = alert.showAndWait();
/*     */     
/* 214 */     if (userInput.get() == ButtonType.OK) {
/* 215 */       System.exit(0);
/*     */     } else {
/* 217 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModPart(ActionEvent event) throws IOException {
/* 224 */     partToModify = this.mainScreenPartsTableView.getSelectionModel().getSelectedItem();
/* 225 */     String resource = "/View_Controller/modifyPartScreen.fxml";
/* 226 */     changeScene(event, resource);
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModProduct(ActionEvent event) throws IOException {
/* 232 */     productToModify = this.mainScreenProductsTableView.getSelectionModel().getSelectedItem();
/* 233 */     String resource = "/View_Controller/modifyProductScreen.fxml";
/* 234 */     changeScene(event, resource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionSearchParts(ActionEvent event) {
/* 242 */     Boolean partFound = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 245 */       int intPart = Integer.parseInt(this.mainPartsSearchTxt.getText());
/*     */       
/* 247 */       if (Inventory.lookupPart(intPart) != -1) {
/* 248 */         int partIndex = Inventory.lookupPart(intPart);
/* 249 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 250 */         partFound = Boolean.valueOf(true);
/*     */         
/* 252 */         if (!this.selectedParts.contains(foundPart)) {
/* 253 */           this.selectedParts.add(foundPart);
/* 254 */           this.mainScreenPartsTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 257 */           this.mainScreenPartsTableView.setItems(this.selectedParts);
/*     */         }
/*     */       
/*     */       } 
/* 261 */     } catch (Exception e) {
/* 262 */       String strPart = this.mainPartsSearchTxt.getText();
/*     */       
/* 264 */       if (Inventory.lookupPart(strPart) != -1) {
/* 265 */         int partIndex = Inventory.lookupPart(strPart);
/* 266 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 267 */         partFound = Boolean.valueOf(true);
/*     */         
/* 269 */         if (!this.selectedParts.contains(foundPart)) {
/* 270 */           this.selectedParts.add(foundPart);
/* 271 */           this.mainScreenPartsTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 274 */           this.mainScreenPartsTableView.setItems(this.selectedParts);
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       
/* 279 */       if (!partFound.booleanValue()) {
/* 280 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 281 */         alert.setTitle("Search result");
/* 282 */         alert.setHeaderText("Part not found, please verify input.");
/* 283 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionSearchProducts(ActionEvent event) {
/* 293 */     Boolean productFound = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 296 */       int intProduct = Integer.parseInt(this.mainProductsSearchTxt.getText());
/*     */       
/* 298 */       if (Inventory.lookupProduct(intProduct) != -1) {
/* 299 */         int productIndex = Inventory.lookupProduct(intProduct);
/* 300 */         Product foundProduct = Inventory.getAllProducts().get(productIndex);
/* 301 */         productFound = Boolean.valueOf(true);
/*     */         
/* 303 */         if (!this.selectedProducts.contains(foundProduct)) {
/* 304 */           this.selectedProducts.add(foundProduct);
/* 305 */           this.mainScreenProductsTableView.setItems(this.selectedProducts);
/*     */         } else {
/*     */           
/* 308 */           this.mainScreenProductsTableView.setItems(this.selectedProducts);
/*     */         }
/*     */       
/*     */       } 
/* 312 */     } catch (Exception e) {
/* 313 */       String strProduct = this.mainProductsSearchTxt.getText();
/*     */       
/* 315 */       if (Inventory.lookupProduct(strProduct) != -1) {
/* 316 */         int productIndex = Inventory.lookupProduct(strProduct);
/* 317 */         Product foundProduct = Inventory.getAllProducts().get(productIndex);
/* 318 */         productFound = Boolean.valueOf(true);
/*     */         
/* 320 */         if (!this.selectedProducts.contains(foundProduct)) {
/* 321 */           this.selectedProducts.add(foundProduct);
/* 322 */           this.mainScreenProductsTableView.setItems(this.selectedProducts);
/*     */         } else {
/*     */           
/* 325 */           this.mainScreenProductsTableView.setItems(this.selectedProducts);
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       
/* 330 */       if (!productFound.booleanValue()) {
/* 331 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 332 */         alert.setTitle("Search result");
/* 333 */         alert.setHeaderText("Product not found, please verify input.");
/* 334 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 343 */     this.mainScreenPartsTableView.setItems(Inventory.getAllParts());
/* 344 */     this.mainScreenPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 345 */     this.mainScreenPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 346 */     this.mainScreenPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 347 */     this.mainScreenPartPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */     
/* 349 */     this.mainScreenProductsTableView.setItems(Inventory.getAllProducts());
/* 350 */     this.mainScreenProductIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 351 */     this.mainScreenProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 352 */     this.mainScreenProductInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 353 */     this.mainScreenProductPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\View_Controller\MainScreenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */