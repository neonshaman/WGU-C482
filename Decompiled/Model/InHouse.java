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
/*    */ public class InHouse
/*    */   extends Part
/*    */ {
/*    */   private int machineID;
/*    */   
/*    */   public InHouse(int id, int stock, int min, int max, String name, double price, int machineID) {
/* 17 */     super(id, stock, min, max, name, price);
/* 18 */     this.machineID = machineID;
/*    */   }
/*    */   
/*    */   public int getMachineID() {
/* 22 */     return this.machineID;
/*    */   }
/*    */   
/*    */   public void setMachineID(int machineID) {
/* 26 */     this.machineID = machineID;
/*    */   }
/*    */ }


/* Location:              C:\Users\neons\Desktop\WGU-C482-master\jacobAloC482FinalProject\build\classes\!\Model\InHouse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */