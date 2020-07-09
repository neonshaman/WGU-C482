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
/*     */ public class ModifyProductScreenController
/*     */   implements Initializable
/*     */ {
/*     */   Stage stage;
/*     */   Parent scene;
/*  47 */   private ObservableList<Part> selectedParts = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*  50 */   ObservableList<Part> partsToAssociate = FXCollections.observableArrayList(); @FXML private Button modProductSearchBtn; @FXML private TextField modProductSearchTxt; @FXML private TableView<Part> modProductTopTableView; @FXML private TableColumn<Part, Integer> modProductTopPartIDCol; @FXML private TableColumn<Part, String> modProductTopPartNameCol; @FXML private TableColumn<Part, Integer> modProductTopInvLvlCol; @FXML
/*     */   private TableColumn<Part, Double> modProductTopPPUCol; @FXML
/*     */   private TableView<Part> modProductBotTableView; @FXML
/*     */   private TableColumn<Part, Integer> modProductBotPartIDCol; @FXML
/*     */   private TableColumn<Part, String> modProductBotPartNameCol; @FXML
/*  55 */   private TableColumn<Part, Integer> modProductBotInvLvlCol; public void changeScene(ActionEvent event, String resource) throws IOException { this.stage = (Stage)((Button)event.getSource()).getScene().getWindow();
/*     */     
/*  57 */     this.scene = FXMLLoader.<Parent>load(getClass().getResource(resource));
/*     */     
/*  59 */     this.stage.setScene(new Scene(this.scene));
/*     */     
/*  61 */     this.stage.show(); } @FXML private TableColumn<Part, Double> modProductBotPPUCol; @FXML private Button modProductAddBtn; @FXML private Button modProductDeleteBtn; @FXML private Button modProductCancelBtn; @FXML private Button modProductSaveBtn; @FXML private TextField modProductIDTxt; @FXML private TextField modProductNameTxt; @FXML
/*     */   private TextField modProductInvTxt; @FXML
/*     */   private TextField modProductPriceTxt; @FXML
/*     */   private TextField modProductMaxTxt; @FXML
/*     */   private TextField modProductMinTxt; @FXML
/*     */   private Button modProductAllPartsBtn; @FXML
/*  67 */   void onActionCancel(ActionEvent event) throws IOException { Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/*  68 */     alert.setTitle("Confirmation");
/*  69 */     alert.setContentText("Return to main screen? Any unsaved information will be lost.");
/*  70 */     Optional<ButtonType> userInput = alert.showAndWait();
/*     */     
/*  72 */     if (userInput.get() == ButtonType.OK) {
/*  73 */       String resource = "/View_Controller/mainScreen.fxml";
/*  74 */       changeScene(event, resource);
/*     */     } else {
/*  76 */       alert.close();
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
/*     */   void onActionModProductSearch(ActionEvent event) {
/* 153 */     Boolean partFound = Boolean.valueOf(false);
/*     */     
/*     */     try {
/* 156 */       int intPart = Integer.parseInt(this.modProductSearchTxt.getText());
/*     */       
/* 158 */       if (Inventory.lookupPart(intPart) != -1) {
/* 159 */         int partIndex = Inventory.lookupPart(intPart);
/* 160 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 161 */         partFound = Boolean.valueOf(true);
/*     */         
/* 163 */         if (!this.selectedParts.contains(foundPart)) {
/* 164 */           this.selectedParts.add(foundPart);
/* 165 */           this.modProductTopTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 168 */           this.modProductTopTableView.setItems(this.selectedParts);
/*     */         }
/*     */       
/*     */       } 
/* 172 */     } catch (Exception e) {
/* 173 */       String strPart = this.modProductSearchTxt.getText();
/*     */       
/* 175 */       if (Inventory.lookupPart(strPart) != -1) {
/* 176 */         int partIndex = Inventory.lookupPart(strPart);
/* 177 */         Part foundPart = Inventory.getAllParts().get(partIndex);
/* 178 */         partFound = Boolean.valueOf(true);
/*     */         
/* 180 */         if (!this.selectedParts.contains(foundPart)) {
/* 181 */           this.selectedParts.add(foundPart);
/* 182 */           this.modProductTopTableView.setItems(this.selectedParts);
/*     */         } else {
/*     */           
/* 185 */           this.modProductTopTableView.setItems(this.selectedParts);
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       
/* 190 */       if (!partFound.booleanValue()) {
/* 191 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 192 */         alert.setTitle("Search result");
/* 193 */         alert.setHeaderText("Part not found, please verify input.");
/* 194 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionDisplayAllParts(ActionEvent event) {
/* 202 */     this.modProductTopTableView.setItems(Inventory.getAllParts());
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModProductAddPart(ActionEvent event) {
/* 208 */     Part part = this.modProductTopTableView.getSelectionModel().getSelectedItem();
/* 209 */     this.partsToAssociate.add(part);
/* 210 */     this.modProductBotTableView.refresh();
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModProductDeletePart(ActionEvent event) {
/* 216 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 217 */     alert.setTitle("Confirmation");
/* 218 */     alert.setHeaderText("Remove product association? You will still need to save to finalize this change");
/* 219 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 220 */     if (userInput.get() == ButtonType.OK) {
/* 221 */       Part part = this.modProductBotTableView.getSelectionModel().getSelectedItem();
/* 222 */       this.partsToAssociate.remove(part);
/* 223 */       this.modProductBotTableView.refresh();
/*     */     } else {
/* 225 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModProductSave(ActionEvent event) {
/* 236 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 237 */     alert.setTitle("Confirmation");
/* 238 */     alert.setContentText("Permanently modify this product? Product ID will not be changed.");
/* 239 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 240 */     if (userInput.get() == ButtonType.OK) {
/*     */       
/* 242 */       String name = this.modProductNameTxt.getText();
/* 243 */       String inv = this.modProductInvTxt.getText();
/* 244 */       String price = this.modProductPriceTxt.getText();
/* 245 */       String max = this.modProductMaxTxt.getText();
/* 246 */       String min = this.modProductMinTxt.getText();
/*     */ 
/*     */       
/* 249 */       if (Integer.parseInt(min) > Integer.parseInt(max)) {
/* 250 */         Alert alertError = new Alert(Alert.AlertType.ERROR);
/* 251 */         alertError.setTitle("Invalid input");
/* 252 */         alertError.setHeaderText("Minimum cannot be greater than maximum.");
/* 253 */         alertError.showAndWait();
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/* 258 */           Product product = new Product(MainScreenController.productToModify.getId(), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(price), this.partsToAssociate);
/* 259 */           Inventory.addProduct(product);
/*     */           
/* 261 */           this.modProductNameTxt.clear();
/* 262 */           this.modProductInvTxt.clear();
/* 263 */           this.modProductPriceTxt.clear();
/* 264 */           this.modProductMaxTxt.clear();
/* 265 */           this.modProductMinTxt.clear();
/* 266 */           this.modProductTopTableView.refresh();
/* 267 */           this.modProductBotTableView.refresh();
/*     */           
/* 269 */           for (Part associatedPart : product.getAllAssociatedParts()) {
/*     */             
/* 271 */             associatedPart.deleteAssociatedProduct(MainScreenController.productToModify);
/*     */             
/* 273 */             associatedPart.addAssociatedProduct(product);
/*     */           } 
/*     */           
/* 276 */           Inventory.deleteProduct(MainScreenController.productToModify);
/*     */           
/* 278 */           String resource = "/View_Controller/mainScreen.fxml";
/* 279 */           changeScene(event, resource);
/*     */         }
/* 281 */         catch (Exception e) {
/* 282 */           Alert alertError = new Alert(Alert.AlertType.ERROR);
/* 283 */           alertError.setTitle("Error modifying product");
/* 284 */           alertError.setHeaderText("Something went wrong in modifying this product. Please check input and try again.");
/* 285 */           alertError.showAndWait();
/*     */         } 
/*     */       } 
/*     */     } else {
/* 289 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 297 */     this.modProductIDTxt.setText(String.valueOf(MainScreenController.productToModify.getId()));
/* 298 */     this.modProductNameTxt.setText(MainScreenController.productToModify.getName());
/* 299 */     this.modProductInvTxt.setText(String.valueOf(MainScreenController.productToModify.getStock()));
/* 300 */     this.modProductPriceTxt.setText(String.valueOf(MainScreenController.productToModify.getPrice()));
/* 301 */     this.modProductMaxTxt.setText(String.valueOf(MainScreenController.productToModify.getMax()));
/* 302 */     this.modProductMinTxt.setText(String.valueOf(MainScreenController.productToModify.getMin()));
/*     */ 
/*     */     
/* 305 */     this.partsToAssociate.addAll(MainScreenController.productToModify.getAllAssociatedParts());
/*     */ 
/*     */     
/* 308 */     this.modProductTopTableView.setItems(Inventory.getAllParts());
/* 309 */     this.modProductTopPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 310 */     this.modProductTopPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 311 */     this.modProductTopInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 312 */     this.modProductTopPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */     
/* 314 */     this.modProductBotTableView.setItems(this.partsToAssociate);
/* 315 */     this.modProductBotPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
/* 316 */     this.modProductBotPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
/* 317 */     this.modProductBotInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
/* 318 */     this.modProductBotPPUCol.setCellValueFactory(new PropertyValueFactory<>("price"));
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\View_Controller\ModifyProductScreenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */