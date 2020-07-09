/*    */ package Model;
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
/*    */ public class Outsourced
/*    */   extends Part
/*    */ {
/*    */   private String companyName;
/*    */   
/*    */   public Outsourced(int id, int stock, int min, int max, String name, double price, String companyName) {
/* 18 */     super(id, stock, min, max, name, price);
/* 19 */     this.companyName = companyName;
/*    */   }
/*    */   
/*    */   public String getCompanyName() {
/* 23 */     return this.companyName;
/*    */   }
/*    */   
/*    */   public void setCompanyName(String companyName) {
/* 27 */     this.companyName = companyName;
/*    */   }
/*    */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\Model\Outsourced.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */