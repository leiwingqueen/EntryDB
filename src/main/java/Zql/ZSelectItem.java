/*    */ package Zql;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZSelectItem
/*    */   extends ZAliasedName
/*    */ {
/* 13 */   ZExp expression_ = null;
/* 14 */   String aggregate_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZSelectItem() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZSelectItem(String paramString) {
/* 27 */     super(paramString, ZAliasedName.FORM_COLUMN);
/* 28 */     setAggregate(ZUtils.getAggregateCall(paramString));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ZExp getExpression() {
/* 36 */     if (isExpression()) return this.expression_; 
/* 37 */     if (isWildcard()) return null;
/*    */     
/* 39 */     return new ZConstant(getColumn(), 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setExpression(ZExp paramZExp) {
/* 49 */     this.expression_ = paramZExp;
/* 50 */     this.strform_ = this.expression_.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isExpression() {
/* 57 */     return (this.expression_ != null && this.expression_ instanceof ZExpression);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAggregate(String paramString) {
/* 66 */     this.aggregate_ = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAggregate() {
/* 75 */     return this.aggregate_;
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZSelectItem.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */