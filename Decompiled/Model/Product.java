/*     */ package Model;
/*     */ 
/*     */ import javafx.collections.FXCollections;
/*     */ import javafx.collections.ObservableList;
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
/*     */ public class Product
/*     */ {
/*  18 */   private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
/*     */   
/*     */   private int id;
/*     */   private int stock;
/*     */   private int min;
/*     */   
/*     */   public Product(int id, int stock, int min, int max, String name, double price, ObservableList<Part> associatedParts) {
/*  25 */     this.id = id;
/*  26 */     this.stock = stock;
/*  27 */     this.min = min;
/*  28 */     this.max = max;
/*  29 */     this.name = name;
/*  30 */     this.price = price;
/*  31 */     this.associatedParts.addAll(associatedParts);
/*     */   }
/*     */ 
/*     */   
/*     */   private int max;
/*     */   private String name;
/*     */   
/*     */   public int getId() {
/*  39 */     return this.id;
/*     */   }
/*     */   private double price; private static int productIDIterator;
/*     */   public void setId(int id) {
/*  43 */     this.id = id;
/*     */   }
/*     */   
/*     */   public int getStock() {
/*  47 */     return this.stock;
/*     */   }
/*     */   
/*     */   public void setStock(int stock) {
/*  51 */     this.stock = stock;
/*     */   }
/*     */   
/*     */   public int getMin() {
/*  55 */     return this.min;
/*     */   }
/*     */   
/*     */   public void setMin(int min) {
/*  59 */     this.min = min;
/*     */   }
/*     */   
/*     */   public int getMax() {
/*  63 */     return this.max;
/*     */   }
/*     */   
/*     */   public void setMax(int max) {
/*  67 */     this.max = max;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  75 */     this.name = name;
/*     */   }
/*     */   
/*     */   public double getPrice() {
/*  79 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(double price) {
/*  83 */     this.price = price;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAssociatedPart(Part part) {
/*  88 */     this.associatedParts.add(part);
/*     */   }
/*     */   
/*     */   public ObservableList<Part> getAllAssociatedParts() {
/*  92 */     return this.associatedParts;
/*     */   }
/*     */   
/*     */   public void deleteAssociatedPart(Part part) {
/*  96 */     this.associatedParts.remove(part);
/*     */   }
/*     */   
/*     */   public static int getProductIDIterator() {
/* 100 */     productIDIterator++;
/* 101 */     return productIDIterator;
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\Model\Product.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */