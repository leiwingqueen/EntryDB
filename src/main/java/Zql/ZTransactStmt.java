/*    */ package Zql;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZTransactStmt
/*    */   implements ZStatement
/*    */ {
/*    */   String statement_;
/* 14 */   String comment_ = null; boolean readOnly_ = false;
/*    */   
/*    */   public ZTransactStmt(String paramString) {
/* 17 */     this.statement_ = new String(paramString);
/*    */   }
/* 19 */   public void setComment(String paramString) { this.comment_ = new String(paramString); }
/* 20 */   public String getComment() { return this.comment_; }
/* 21 */   public boolean isReadOnly() { return this.readOnly_; } public String getStmtType() {
/* 22 */     return this.statement_;
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZTransactStmt.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */