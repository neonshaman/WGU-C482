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
/*     */ public class Inventory
/*     */ {
/*  18 */   private static ObservableList<Part> allParts = FXCollections.observableArrayList();
/*     */   
/*  20 */   private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
/*     */ 
/*     */   
/*     */   public static void addPart(Part part) {
/*  24 */     allParts.add(part);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addProduct(Product product) {
/*  29 */     allProducts.add(product);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deletePart(Part part) {
/*  34 */     allParts.remove(part);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void deleteProduct(Product product) {
/*  39 */     allProducts.remove(product);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObservableList<Part> getAllParts() {
/*  44 */     return allParts;
/*     */   }
/*     */   
/*     */   public static ObservableList<Product> getAllProducts() {
/*  48 */     return allProducts;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int lookupPart(int id) {
/*  53 */     int partIndex = -1;
/*  54 */     for (Part part : allParts) {
/*  55 */       if (part.getId() == id) {
/*  56 */         partIndex = allParts.indexOf(part);
/*     */       }
/*     */     } 
/*  59 */     return partIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int lookupPart(String name) {
/*  64 */     int partIndex = -1;
/*  65 */     for (Part part : allParts) {
/*  66 */       if (part.getName().equals(name)) {
/*  67 */         partIndex = allParts.indexOf(part);
/*     */       }
/*     */     } 
/*  70 */     return partIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int lookupProduct(int id) {
/*  75 */     int productIndex = -1;
/*  76 */     for (Product product : allProducts) {
/*  77 */       if (product.getId() == id) {
/*  78 */         productIndex = allProducts.indexOf(product);
/*     */       }
/*     */     } 
/*  81 */     return productIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int lookupProduct(String name) {
/*  86 */     int productIndex = -1;
/*  87 */     for (Product product : allProducts) {
/*  88 */       if (product.getName().equals(name)) {
/*  89 */         productIndex = allProducts.indexOf(product);
/*     */       }
/*     */     } 
/*  92 */     return productIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updatePart(int index, Part part) {
/*  97 */     allParts.set(index, part);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateProduct(int index, Product product) {
/* 102 */     allProducts.set(index, product);
/*     */   }
/*     */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\Model\Inventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */