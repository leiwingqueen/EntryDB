/*    */ package Zql;
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
/*    */ 
/*    */ public class ZConstant
/*    */   implements ZExp
/*    */ {
/*    */   public static final int UNKNOWN = -1;
/*    */   public static final int COLUMNNAME = 0;
/*    */   public static final int NULL = 1;
/*    */   public static final int NUMBER = 2;
/*    */   public static final int STRING = 3;
/* 21 */   int type_ = -1;
/* 22 */   String val_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZConstant(String paramString, int paramInt) {
/* 28 */     this.val_ = new String(paramString);
/* 29 */     this.type_ = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 35 */     return this.val_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 40 */     return this.type_;
/*    */   }
/*    */   public String toString() {
/* 43 */     if (this.type_ == 3) return '\'' + this.val_ + '\''; 
/* 44 */     return this.val_;
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZConstant.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */