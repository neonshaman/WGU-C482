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
/*     */ 
/*     */ public class AddProductScreenController
/*     */   implements Initializable
/*     */ {
/*     */   Stage stage;
/*     */   Parent scene;
/*  49 */   private ObservableList<Part> selectedParts = FXCollections.observableArrayList();
/*     */   
/*  51 */   ObservableList<Part> partsToAssociate = FXCollections.observableArrayList(); private int productIDIterator; @FXML private TableView<Part> addProductTopTableView; @FXML private TableColumn<Part, Integer> addProductTopPartIDCol; @FXML private TableColumn<Part, String> addProductTopPartNameCol; @FXML private TableColumn<Part, Integer> addProductTopInvLvlCol; @FXML
/*     */   private TableColumn<Double, Integer> addProductTopPPUCol; @FXML
/*     */   private TableView<Part> addProductBotTableView; @FXML
/*     */   private TableColumn<Part, Integer> addProductBotPartIDCol; @FXML
/*     */   private TableColumn<Part, String> addProductBotPartNameCol; @FXML
/*     */   private TableColumn<Part, Integer> addProductBotInvLvlCol; @FXML
/*     */   private TableColumn<Part, Double> addProductBotPPUCol; @FXML
/*  58 */   private Button addProductSearchBtn; public void changeScene(ActionEvent event, String resource) throws IOException { this.stage = (Stage)((Button)event.getSource()).getScene().getWindow();
/*     */     
/*  60 */     this.scene = FXMLLoader.<Parent>load(getClass().getResource(resource));
/*     */     
/*  62 */     this.stage.setScene(new Scene(this.scene));
/*     */     
/*  64 */     this.stage.show(); } @FXML private TextField addProductSearchTxt; @FXML private Button addProductAddBtn; @FXML private Button addProductDeleteBtn; @FXML private Button addProductCancelBtn; @FXML private Button addProductSaveBtn; @FXML private TextField addProductIDTxt; @FXML private TextField addProductNameTxt; @FXML
/*     */   private TextField addProductInvTxt; @FXML
/*     */   private TextField addProductPriceTxt; @FXML
/*     */   private TextField addProductMaxTxt; @FXML
/*     */   private TextField addProductMinTxt; @FXML
/*     */   private Button addProductAllPartsBtn; @FXML
/*  70 */   void onActionCancel(ActionEvent event) throws IOException { Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/*  71 */     alert.setTitle("Confirmation");
/*  72 */     alert.setContentText("Return to main screen? Any unsaved information will be lost.");
/*  73 */     Optional<ButtonType> userInput = alert.showAndWait();
/*     */     
/*  75 */     if (userInput.get() == ButtonType.OK) {
/*  76 */       String resource = "/View_Controller/mainScreen.fxml";
/*  77 */       changeScene(event, resource);
/*     */     } else {
/*  79 */       alert.close();
/*     */     }  }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddProductSearch(ActionEvent event) {
/* 156 */     Boolean partFound = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 159 */       int intPart = Integer.parseInt(this.addProductSearchTxt.getText());
/*     */       
/* 161 */       if (Inventory.lookupPart(intPart) != -1) {
/* 162 */         int partIndex = Inventory.lookupPart(intPart);
/* 163 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 164 */         partFound = Boolean.valueOf(true);
/*     */         
/* 166 */         if (!this.selectedParts.contains(foundPart)) {
/* 167 */           this.selectedParts.add(foundPart);
/* 168 */           this.addProductTopTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 171 */           this.addProductTopTableView.setItems(this.selectedParts);
/*     */         }
/*     */       
/*     */       } 
/* 175 */     } catch (Exception e) {
/* 176 */       String strPart = this.addProductSearchTxt.getText();
/*     */       
/* 178 */       if (Inventory.lookupPart(strPart) != -1) {
/* 179 */         int partIndex = Inventory.lookupPart(strPart);
/* 180 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 181 */         partFound = Boolean.valueOf(true);
/*     */         
/* 183 */         if (!this.selectedParts.contains(foundPart)) {
/* 184 */           this.selectedParts.add(foundPart);
/* 185 */           this.addProductTopTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 188 */           this.addProductTopTableView.setItems(this.selectedParts);
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       
/* 193 */       if (!partFound.booleanValue()) {
/* 194 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 195 */         alert.setTitle("Search result");
/* 196 */         alert.setHeaderText("Part not found, please verify input.");
/* 197 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionDisplayAllParts(ActionEvent event) {
/* 205 */     this.addProductTopTableView.setItems(Inventory.getAllParts());
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddProductAddPart(ActionEvent event) {
/* 211 */     Part part = this.addProductTopTableView.getSelectionModel().getSelectedItem();
/* 212 */     this.partsToAssociate.add(part);
/* 213 */     this.addProductBotTableView.setItems(this.partsToAssociate);
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddProductDeletePart(ActionEvent event) {
/* 219 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 220 */     alert.setTitle("Confirmation");
/* 221 */     alert.setHeaderText("Remove product association? You will still need to save to finalize this change.");
/* 222 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 223 */     if (userInput.get() == ButtonType.OK) {
/* 224 */       Part part = this.addProductBotTableView.getSelectionModel().getSelectedItem();
/* 225 */       this.partsToAssociate.remove(part);
/* 226 */       this.addProductBotTableView.setItems(this.partsToAssociate);
/*     */     } else {
/* 228 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddProductSave(ActionEvent event) {
/* 236 */     String name = this.addProductNameTxt.getText();
/* 237 */     String inv = this.addProductInvTxt.getText();
/* 238 */     String price = this.addProductPriceTxt.getText();
/* 239 */     String max = this.addProductMaxTxt.getText();
/* 240 */     String min = this.addProductMinTxt.getText();
/*     */ 
/*     */     
/* 243 */     if (Integer.parseInt(min) > Integer.parseInt(max)) {
/* 244 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 245 */       alert.setTitle("Invalid input");
/* 246 */       alert.setHeaderText("Minimum cannot be greater than maximum.");
/* 247 */       alert.showAndWait();
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/* 252 */         Product product = new Product(this.productIDIterator, Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(price), this.partsToAssociate);
/* 253 */         Inventory.addProduct(product);
/*     */         
/* 255 */         for (Part associatedPart : product.getAllAssociatedParts()) {
/* 256 */           associatedPart.addAssociatedProduct(product);
/*     */         }
/*     */         
/* 259 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 260 */         alert.setTitle("Success");
/* 261 */         alert.setHeaderText("Product added.");
/* 262 */         alert.showAndWait();
/*     */         
/* 264 */         this.addProductNameTxt.clear();
/* 265 */         this.addProductInvTxt.clear();
/* 266 */         this.addProductPriceTxt.clear();
/* 267 */         this.addProductMaxTxt.clear();
/* 268 */         this.addProductMinTxt.clear();
/* 269 */         this.addProductTopTableView.refresh();
/* 270 */         this.addProductBotTableView.refresh();
/*     */         
/* 272 */         String resource = "/View_Controller/mainScreen.fxml";
/* 273 */         changeScene(event, resource);
/*     */       }
/* 275 */       catch (Exception e) {
/* 276 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 277 */         alert.setTitle("Error adding product");
/* 278 */         alert.setHeaderText("Something went wrong in adding this product. Please check input and try again.");
/* 279 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 288 */     this.productIDIterator = Product.getProductIDIterator();
/* 289 */     this.addProductIDTxt.setText("Auto-Gen: " + this.productIDIterator);
/*     */ 
/*     */     
/* 292 */     this.addProductTopTableView.setItems(Inventory.getAllParts());
/* 293 */     this.addProductTopPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 294 */     this.addProductTopPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 295 */     this.addProductTopInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 296 */     this.addProductTopPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */     
/* 298 */     this.addProductBotTableView.setItems(this.partsToAssociate);
/* 299 */     this.addProductBotPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 300 */     this.addProductBotPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 301 */     this.addProductBotInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 302 */     this.addProductBotPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\View_Controller\AddProductScreenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */