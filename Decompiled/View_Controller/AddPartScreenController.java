/*     */ package View_Controller;
/*     */ 
/*     */ import Model.InHouse;
/*     */ import Model.Inventory;
/*     */ import Model.Outsourced;
/*     */ import Model.Part;
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
/*     */ 
/*     */ 
/*     */ public class AddPartScreenController
/*     */   implements Initializable
/*     */ {
/*     */   Stage stage;
/*     */   Parent scene;
/*     */   
/*     */   public void changeScene(ActionEvent event, String resource) throws IOException {
/*  48 */     this.stage = (Stage)((Button)event.getSource()).getScene().getWindow();
/*     */     
/*  50 */     this.scene = FXMLLoader.<Parent>load(getClass().getResource(resource));
/*     */     
/*  52 */     this.stage.setScene(new Scene(this.scene));
/*     */     
/*  54 */     this.stage.show();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isOutsource = false;
/*     */   
/*     */   private int partIDIterator;
/*     */   
/*     */   @FXML
/*     */   private RadioButton addPartInHouseRadBtn;
/*     */   
/*     */   @FXML
/*     */   private RadioButton addPartOutsourcedRadBtn;
/*     */   
/*     */   @FXML
/*     */   private ToggleGroup addPartRadBtnToggleGroup;
/*     */   
/*     */   @FXML
/*     */   private Label addPartChangingLbl;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartIDTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartNameTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartInvTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartPriceCostTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartMaxTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartMinTxt;
/*     */   
/*     */   @FXML
/*     */   private TextField addPartChangingTxt;
/*     */   
/*     */   @FXML
/*     */   private Button addPartSaveBtn;
/*     */   @FXML
/*     */   private Button addPartCancelBtn;
/*     */   
/*     */   @FXML
/*     */   void onActionCancel(ActionEvent event) throws IOException {
/* 102 */     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
/* 103 */     alert.setTitle("Confirmation");
/* 104 */     alert.setContentText("Return to main screen? Any unsaved information will be lost.");
/* 105 */     Optional<ButtonType> userInput = alert.showAndWait();
/*     */     
/* 107 */     if (userInput.get() == ButtonType.OK) {
/* 108 */       String resource = "/View_Controller/mainScreen.fxml";
/* 109 */       changeScene(event, resource);
/*     */     } else {
/* 111 */       alert.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionRadInHouse(ActionEvent event) {
/* 118 */     this.isOutsource = false;
/* 119 */     this.addPartChangingLbl.setText("Machine ID");
/*     */   }
/*     */   
/*     */   @FXML
/*     */   void onActionRadOutsource(ActionEvent event) {
/* 124 */     this.isOutsource = true;
/* 125 */     this.addPartChangingLbl.setText("Company Name");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FXML
/*     */   void onActionAddPartSave(ActionEvent event) {
/* 133 */     String name = this.addPartNameTxt.getText();
/* 134 */     String inv = this.addPartInvTxt.getText();
/* 135 */     String priceCost = this.addPartPriceCostTxt.getText();
/* 136 */     String max = this.addPartMaxTxt.getText();
/* 137 */     String min = this.addPartMinTxt.getText();
/* 138 */     String changingField = this.addPartChangingTxt.getText();
/*     */ 
/*     */     
/* 141 */     if (Integer.parseInt(min) > Integer.parseInt(max)) {
/* 142 */       Alert alert = new Alert(Alert.AlertType.ERROR);
/* 143 */       alert.setTitle("Invalid input");
/* 144 */       alert.setHeaderText("Minimum cannot be greater than maximum.");
/* 145 */       alert.showAndWait();
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/* 150 */         if (!this.isOutsource) {
/*     */ 
/*     */           
/* 153 */           InHouse inPart = new InHouse(this.partIDIterator, Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(priceCost), Integer.parseInt(changingField));
/* 154 */           Inventory.addPart((Part)inPart);
/*     */         }
/*     */         else {
/*     */           
/* 158 */           Outsourced outPart = new Outsourced(this.partIDIterator, Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), name, Double.parseDouble(priceCost), changingField);
/*     */           
/* 160 */           Inventory.addPart((Part)outPart);
/*     */         } 
/*     */         
/* 163 */         Alert alert = new Alert(Alert.AlertType.INFORMATION);
/* 164 */         alert.setTitle("Success");
/* 165 */         alert.setHeaderText("Part added.");
/* 166 */         alert.showAndWait();
/*     */         
/* 168 */         this.addPartNameTxt.clear();
/* 169 */         this.addPartInvTxt.clear();
/* 170 */         this.addPartPriceCostTxt.clear();
/* 171 */         this.addPartMaxTxt.clear();
/* 172 */         this.addPartMinTxt.clear();
/* 173 */         this.addPartChangingTxt.clear();
/*     */         
/* 175 */         String resource = "/View_Controller/mainScreen.fxml";
/* 176 */         changeScene(event, resource);
/*     */       }
/* 178 */       catch (Exception e) {
/* 179 */         Alert alert = new Alert(Alert.AlertType.ERROR);
/* 180 */         alert.setTitle("Error adding part");
/* 181 */         alert.setHeaderText("Something went wrong in adding this part. Please check input and try again.");
/* 182 */         alert.showAndWait();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(URL url, ResourceBundle rb) {
/* 190 */     this.partIDIterator = Part.getPartIDIterator();
/* 191 */     this.addPartIDTxt.setText("Auto-Gen: " + this.partIDIterator);
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\View_Controller\AddPartScreenController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */