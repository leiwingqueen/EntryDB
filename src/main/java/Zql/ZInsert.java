/*    */ package Zql;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZInsert
/*    */   implements ZStatement
/*    */ {
/*    */   String table_;
/* 13 */   Vector columns_ = null;
/* 14 */   ZExp valueSpec_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZInsert(String paramString) {
/* 20 */     this.table_ = new String(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTable() {
/* 28 */     return this.table_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Vector getColumns() {
/* 36 */     return this.columns_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addColumns(Vector paramVector) {
/* 43 */     this.columns_ = paramVector;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addValueSpec(ZExp paramZExp) {
/* 53 */     this.valueSpec_ = paramZExp;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Vector getValues() {
/* 61 */     if (!(this.valueSpec_ instanceof ZExpression)) return null; 
/* 62 */     return ((ZExpression)this.valueSpec_).getOperands();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZQuery getQuery() {
/* 73 */     if (!(this.valueSpec_ instanceof ZQuery)) return null; 
/* 74 */     return (ZQuery)this.valueSpec_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuffer stringBuffer = new StringBuffer("insert into " + this.table_);
/* 79 */     if (this.columns_ != null && this.columns_.size() > 0) {
/*    */       
/* 81 */       stringBuffer.append("(" + this.columns_.elementAt(0));
/* 82 */       for (byte b = 1; b < this.columns_.size(); b++) {
/* 83 */         stringBuffer.append("," + this.columns_.elementAt(b));
/*    */       }
/* 85 */       stringBuffer.append(")");
/*    */     } 
/*    */     
/* 88 */     String str = this.valueSpec_.toString();
/* 89 */     stringBuffer.append(" ");
/* 90 */     if (getValues() != null)
/* 91 */       stringBuffer.append("values "); 
/* 92 */     if (str.startsWith("(")) { stringBuffer.append(str); }
/* 93 */     else { stringBuffer.append(" (" + str + ")"); }
/*    */     
/* 95 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZInsert.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */