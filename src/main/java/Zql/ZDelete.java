/*    */ package Zql;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZDelete
/*    */   implements ZStatement
/*    */ {
/*    */   String table_;
/* 14 */   ZExp where_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZDelete(String paramString) {
/* 21 */     this.table_ = new String(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addWhere(ZExp paramZExp) {
/* 28 */     this.where_ = paramZExp;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTable() {
/* 33 */     return this.table_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ZExp getWhere() {
/* 39 */     return this.where_;
/*    */   }
/*    */   public String toString() {
/* 42 */     StringBuffer stringBuffer = new StringBuffer("delete ");
/* 43 */     if (this.where_ != null) stringBuffer.append("from "); 
/* 44 */     stringBuffer.append(this.table_);
/* 45 */     if (this.where_ != null) stringBuffer.append(" where " + this.where_.toString()); 
/* 46 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZDelete.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */