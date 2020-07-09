/*    */ package MainInventorySystemApp;
/*    */ 
/*    */ import Model.InHouse;
/*    */ import Model.Inventory;
/*    */ import Model.Outsourced;
/*    */ import Model.Part;
/*    */ import Model.Product;
/*    */ import java.io.IOException;
/*    */ import javafx.application.Application;
/*    */ import javafx.collections.FXCollections;
/*    */ import javafx.collections.ObservableList;
/*    */ import javafx.fxml.FXMLLoader;
/*    */ import javafx.scene.Parent;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.stage.Stage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainInvSys
/*    */   extends Application
/*    */ {
/*    */   public void init() {
/* 28 */     System.out.println("Starting.");
/*    */   }
/*    */ 
/*    */   
/*    */   public void start(Stage stage) throws IOException {
/* 33 */     Parent root = FXMLLoader.<Parent>load(getClass().getResource("/View_Controller/mainScreen.fxml"));
/* 34 */     Scene scene = new Scene(root);
/* 35 */     stage.setScene(scene);
/* 36 */     stage.show();
/* 37 */     stage.setResizable(false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 45 */     InHouse inPart1 = new InHouse(496, 2, 0, 20, "in test1", 2.0D, 14);
/* 46 */     InHouse inPart2 = new InHouse(822, 2, 1, 33, "in test2", 3.5D, 5);
/* 47 */     InHouse inPart3 = new InHouse(360, 2, 14, 500, "in test3", 4.0D, 43);
/* 48 */     Outsourced outPart1 = new Outsourced(864, 5, 5, 30, "out test 1", 9.5D, "Company 1");
/* 49 */     Outsourced outPart2 = new Outsourced(274, 5, 5, 30, "out test 2", 9.5D, "Company 2");
/* 50 */     Outsourced outPart3 = new Outsourced(143, 5, 5, 30, "out test 3", 9.5D, "Company 3");
/*    */     
/* 52 */     Inventory.addPart((Part)inPart1);
/* 53 */     Inventory.addPart((Part)inPart2);
/* 54 */     Inventory.addPart((Part)inPart3);
/* 55 */     Inventory.addPart((Part)outPart1);
/* 56 */     Inventory.addPart((Part)outPart2);
/* 57 */     Inventory.addPart((Part)outPart3);
/*    */     
/* 59 */     ObservableList<Part> testPartList = FXCollections.observableArrayList();
/* 60 */     testPartList.add(inPart1);
/*    */     
/* 62 */     Product test = new Product(555, 55, 55, 55, "TEST", 55.0D, testPartList);
/* 63 */     inPart1.addAssociatedProduct(test);
/* 64 */     Inventory.addProduct(test);
/*    */     
/* 66 */     launch(args);
/*    */   }
/*    */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\MainInventorySystemApp\MainInvSys.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */