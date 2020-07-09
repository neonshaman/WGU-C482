/*     */ package View_Controller;
/*     */ 
/*     */ import Model.InHouse;
/*     */ import Model.Inventory;
/*     */ import Model.Outsourced;
/*     */ import Model.Part;
/*     */ import Model.Product;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.Optional;
/*     */ import java.util.ResourceBundle;
/*     */ import javafx.event.ActionEvent;
/*     */ import javafx.fxml.FXML;
/*     */ import javafx.fxml.FXMLLoader;
/*     */ import javafx.fxml.Initializable;
/*     */ import javafx.scene.Parent;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Alert;
/*     */ import javafx.scene.control.Button;
/*     */ import javafx.scene.control.ButtonType;
/*     */ import javafx.scene.control.Label;
/*     */ import javafx.scene.control.RadioButton;
/*     */ import javafx.scene.control.TextField;
/*     */ import javafx.scene.control.ToggleGroup;
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
/*     */ public class ModifyPartScreenController
/*     */   implements Initializable
/*     */ {
/*     */   Stage stage;
/*     */   Parent scene;
/*  45 */   private Boolean isOutsource = Boolean.valueOf(false); @FXML private RadioButton modPartInHouseRadBtn; @FXML
/*     */   private ToggleGroup modPartRadBtToggleGroup; @FXML
/*     */   private RadioButton modPartOutsourcedRadBtn; @FXML
/*     */   private Label modPartChangingLbl; @FXML
/*     */   private TextField modPartIDTxt; @FXML
/*  50 */   private TextField modPartNameTxt; public void changeScene(ActionEvent event, String resource) throws IOException { this.stage = (Stage)((Button)event.getSource()).getScene().getWindow();
/*     */     
/*  52 */     this.scene = FXMLLoader.<Parent>load(getClass().getResource(resource));
/*     */     
/*  54 */     this.stage.setScene(new Scene(this.scene));
/*     */     
/*  56 */     this.stage.show(); } @FXML private TextField modPartInvTxt; @FXML private TextField modPartPriceCostTxt; @FXML
/*     */   private TextField modPartMaxTxt; @FXML
/*     */   private TextField modPartMinTxt; @FXML
/*     */   private TextField modPartChangingTxt; @FXML
/*     */   private Button modPartSaveBtn; @FXML
/*     */   private Button modPartCancelBtn; @FXML
/*  62 */   void onActionCancel(ActionEvent event) throws IOException { Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/*  63 */     alert.setTitle("Confirmation");
/*  64 */     alert.setContentText("Return to main screen? Any unsaved information will be lost.");
/*  65 */     Optional<ButtonType> userInput = alert.showAndWait();
/*     */     
/*  67 */     if (userInput.get() == ButtonType.OK) {
/*  68 */       String resource = "/View_Controller/mainScreen.fxml";
/*  69 */       changeScene(event, resource);
/*     */     } else {
/*  71 */       alert.close();
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
/*     */   @FXML
/*     */   void onActionRadInHouse(ActionEvent event) {
/* 117 */     this.isOutsource = Boolean.valueOf(false);
/* 118 */     this.modPartChangingLbl.setText("Machine ID");
/*     */   }
/*     */   
/*     */   @FXML
/*     */   void onActionRadOutsource(ActionEvent event) {
/* 123 */     this.isOutsource = Boolean.valueOf(true);
/* 124 */     this.modPartChangingLbl.setText("Company Name");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionModPartSave(ActionEvent event) {
/* 135 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 136 */     alert.setTitle("Confirmation");
/* 137 */     alert.setContentText("Permanently modify this part? Part ID will not be changed.");
/* 138 */     Optional<ButtonType> userInput = alert.showAndWait();
/* 139 */     if (userInput.get() == ButtonType.OK) {
/*     */       
/* 141 */       String name = this.modPartNameTxt.getText();
/* 142 */       String inv = this.modPartInvTxt.getText();
/* 143 */       String priceCost = this.modPartPriceCostTxt.getText();
/* 144 */       String max = this.modPartMaxTxt.getText();
/* 145 */       String min = this.modPartMinTxt.getText();
/* 146 */       String changingField = this.modPartChangingTxt.getText();
/*     */ 
/*     */       
/* 149 */       if (Integer.parseInt(min) > Integer.parseInt(max)) {
/* 150 */         Alert alertError = new Alert(Alert.AlertType.ERROR);
/* 151 */         alert.setTitle("Invalid input");
/* 152 */         alert.setHeaderText("Minimum cannot be greater than maximum.");
/* 153 */         alert.showAndWait();
/*     */       } else {
/*     */         try {
/*     */           Outsourced outsourced;
/*     */           
/* 158 */           if (!this.isOutsource.booleanValue()) {
/*     */ 
/*     */             
/* 161 */             InHouse inPart = new InHouse(MainScreenController.partToModify.getId(), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(priceCost), Integer.parseInt(changingField));
/* 162 */             Inventory.addPart((Part)inPart);
/*     */             
/* 164 */             inPart.associatedProducts.addAll(MainScreenController.partToModify.associatedProducts);
/*     */             
/* 166 */             InHouse inHouse1 = inPart;
/*     */           }
/*     */           else {
/*     */             
/* 170 */             Outsourced outPart = new Outsourced(MainScreenController.partToModify.getId(), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(priceCost), changingField);
/*     */             
/* 172 */             Inventory.addPart((Part)outPart);
/*     */             
/* 174 */             outPart.associatedProducts.addAll(MainScreenController.partToModify.getAllAssociatedProducts());
/*     */ 
/*     */             
/* 177 */             outsourced = outPart;
/*     */           } 
/*     */           
/* 180 */           for (Product associatedProduct : outsourced.getAllAssociatedProducts()) {
/*     */             
/* 182 */             associatedProduct.deleteAssociatedPart(MainScreenController.partToModify);
/*     */             
/* 184 */             associatedProduct.addAssociatedPart((Part)outsourced);
/*     */           } 
/*     */           
/* 187 */           Inventory.deletePart(MainScreenController.partToModify);
/*     */           
/* 189 */           this.modPartNameTxt.clear();
/* 190 */           this.modPartInvTxt.clear();
/* 191 */           this.modPartPriceCostTxt.clear();
/* 192 */           this.modPartMaxTxt.clear();
/* 193 */           this.modPartMinTxt.clear();
/* 194 */           this.modPartChangingTxt.clear();
/*     */           
/* 196 */           String resource = "/View_Controller/mainScreen.fxml";
/* 197 */           changeScene(event, resource);
/*     */         }
/* 199 */         catch (Exception e) {
/* 200 */           Alert alertError = new Alert(Alert.AlertType.ERROR);
/* 201 */           alert.setTitle("Error modifying part");
/* 202 */           alert.setHeaderText("Something went wrong in modifying this part. Please check input and try again.");
/* 203 */           alert.showAndWait();
/*     */         } 
/*     */       } 
/*     */     } else {
/* 207 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 214 */     this.modPartIDTxt.setText(String.valueOf(MainScreenController.partToModify.getId()));
/* 215 */     this.modPartNameTxt.setText(MainScreenController.partToModify.getName());
/* 216 */     this.modPartInvTxt.setText(String.valueOf(MainScreenController.partToModify.getStock()));
/* 217 */     this.modPartPriceCostTxt.setText(String.valueOf(MainScreenController.partToModify.getPrice()));
/* 218 */     this.modPartMaxTxt.setText(String.valueOf(MainScreenController.partToModify.getMax()));
/* 219 */     this.modPartMinTxt.setText(String.valueOf(MainScreenController.partToModify.getMin()));
/*     */     
/* 221 */     if (MainScreenController.partToModify instanceof InHouse) {
/* 222 */       this.modPartInHouseRadBtn.setSelected(true);
/* 223 */       this.isOutsource = Boolean.valueOf(false);
/* 224 */       System.out.println("In House found");
/* 225 */       this.modPartChangingLbl.setText("Machine ID");
/* 226 */       this.modPartChangingTxt.setText(String.valueOf(((InHouse)MainScreenController.partToModify).getMachineID()));
/*     */     
/*     */     }
/* 229 */     else if (MainScreenController.partToModify instanceof Outsourced) {
/* 230 */       this.modPartOutsourcedRadBtn.setSelected(true);
/* 231 */       this.isOutsource = Boolean.valueOf(true);
/* 232 */       System.out.println("Outsourced found");
/* 233 */       this.modPartChangingLbl.setText("Company Name");
/* 234 */       this.modPartChangingTxt.setText(((Outsourced)MainScreenController.partToModify).getCompanyName());
/*     */     } else {
/*     */       
/* 237 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 238 */       alert.setTitle("Error");
/* 239 */       alert.setHeaderText("Something went wrong while importing the part. Please check selection and try again.");
/* 240 */       alert.showAndWait();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\View_Controller\ModifyPartScreenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */