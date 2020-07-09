/*    */ package Model;
/*    */ 
/*    */ import javafx.collections.FXCollections;
/*    */ import javafx.collections.ObservableList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Part
/*    */ {
/* 18 */   public ObservableList<Product> associatedProducts = FXCollections.observableArrayList();
/*    */   private int id;
/*    */   private int stock;
/*    */   private int min;
/*    */   
/*    */   public Part(int id, int stock, int min, int max, String name, double price) {
/* 24 */     this.id = id;
/* 25 */     this.stock = stock;
/* 26 */     this.min = min;
/* 27 */     this.max = max;
/* 28 */     this.name = name;
/* 29 */     this.price = price;
/*    */   }
/*    */   
/*    */   private int max;
/*    */   private String name;
/*    */   
/*    */   public int getId() {
/* 36 */     return this.id;
/*    */   }
/*    */   private double price; private static int partIDIterator;
/*    */   public void setId(int id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   
/*    */   public int getStock() {
/* 44 */     return this.stock;
/*    */   }
/*    */   
/*    */   public void setStock(int stock) {
/* 48 */     this.stock = stock;
/*    */   }
/*    */   
/*    */   public int getMin() {
/* 52 */     return this.min;
/*    */   }
/*    */   
/*    */   public void setMin(int min) {
/* 56 */     this.min = min;
/*    */   }
/*    */   
/*    */   public int getMax() {
/* 60 */     return this.max;
/*    */   }
/*    */   
/*    */   public void setMax(int max) {
/* 64 */     this.max = max;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 68 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 72 */     this.name = name;
/*    */   }
/*    */   
/*    */   public double getPrice() {
/* 76 */     return this.price;
/*    */   }
/*    */   
/*    */   public void setPrice(double price) {
/* 80 */     this.price = price;
/*    */   }
/*    */   
/*    */   public static int getPartIDIterator() {
/* 84 */     partIDIterator++;
/* 85 */     return partIDIterator;
/*    */   }
/*    */   
/*    */   public void addAssociatedProduct(Product product) {
/* 89 */     this.associatedProducts.add(product);
/*    */   }
/*    */   
/*    */   public void deleteAssociatedProduct(Product product) {
/* 93 */     this.associatedProducts.remove(product);
/*    */   }
/*    */   
/*    */   public ObservableList<Product> getAllAssociatedProducts() {
/* 97 */     return this.associatedProducts;
/*    */   }
/*    */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\Model\Part.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */