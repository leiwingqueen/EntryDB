/*    */ package Zql;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZLockTable
/*    */   implements ZStatement
/*    */ {
/*    */   boolean nowait_ = false;
/* 13 */   String lockMode_ = null;
/* 14 */   Vector tables_ = null;
/*    */ 
/*    */   
/*    */   public void addTables(Vector paramVector) {
/* 18 */     this.tables_ = paramVector; }
/* 19 */   public Vector getTables() { return this.tables_; }
/* 20 */   public void setLockMode(String paramString) { this.lockMode_ = new String(paramString); }
/* 21 */   public String getLockMode() { return this.lockMode_; } public boolean isNowait() {
/* 22 */     return this.nowait_;
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZLockTable.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */