/*    */ package Zql;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ZOrderBy
/*    */   implements Serializable {
/*    */   ZExp exp_;
/*    */   boolean asc_ = true;
/*    */   
/*    */   public ZOrderBy(ZExp paramZExp) {
/* 11 */     this.exp_ = paramZExp;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAscOrder(boolean paramBoolean) {
/* 17 */     this.asc_ = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getAscOrder() {
/* 23 */     return this.asc_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZExp getExpression() {
/* 30 */     return this.exp_;
/*    */   }
/*    */   public String toString() {
/* 33 */     return this.exp_.toString() + " " + (this.asc_ ? "ASC" : "DESC");
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZOrderBy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */