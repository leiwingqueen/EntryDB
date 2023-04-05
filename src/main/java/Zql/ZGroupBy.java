/*    */ package Zql;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZGroupBy
/*    */   implements Serializable
/*    */ {
/*    */   Vector groupby_;
/* 13 */   ZExp having_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZGroupBy(Vector paramVector) {
/* 19 */     this.groupby_ = paramVector;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setHaving(ZExp paramZExp) {
/* 25 */     this.having_ = paramZExp;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Vector getGroupBy() {
/* 31 */     return this.groupby_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ZExp getHaving() {
/* 37 */     return this.having_;
/*    */   }
/*    */   public String toString() {
/* 40 */     StringBuffer stringBuffer = new StringBuffer("group by ");
/*    */ 
/*    */     
/* 43 */     stringBuffer.append(this.groupby_.elementAt(0).toString());
/* 44 */     for (byte b = 1; b < this.groupby_.size(); b++) {
/* 45 */       stringBuffer.append(", " + this.groupby_.elementAt(b).toString());
/*    */     }
/* 47 */     if (this.having_ != null) {
/* 48 */       stringBuffer.append(" having " + this.having_.toString());
/*    */     }
/* 50 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZGroupBy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */