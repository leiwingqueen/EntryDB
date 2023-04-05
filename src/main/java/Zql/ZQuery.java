/*     */ package Zql;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZQuery
/*     */   implements ZStatement, ZExp
/*     */ {
/*     */   Vector select_;
/*     */   boolean distinct_ = false;
/*     */   Vector from_;
/*  15 */   ZExp where_ = null;
/*  16 */   ZGroupBy groupby_ = null;
/*  17 */   ZExpression setclause_ = null;
/*  18 */   Vector orderby_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean forupdate_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSelect(Vector paramVector) {
/*  30 */     this.select_ = paramVector;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFrom(Vector paramVector) {
/*  36 */     this.from_ = paramVector;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addWhere(ZExp paramZExp) {
/*  42 */     this.where_ = paramZExp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGroupBy(ZGroupBy paramZGroupBy) {
/*  48 */     this.groupby_ = paramZGroupBy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSet(ZExpression paramZExpression) {
/*  54 */     this.setclause_ = paramZExpression;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOrderBy(Vector paramVector) {
/*  60 */     this.orderby_ = paramVector;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector getSelect() {
/*  66 */     return this.select_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector getFrom() {
/*  72 */     return this.from_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp getWhere() {
/*  78 */     return this.where_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ZGroupBy getGroupBy() {
/*  84 */     return this.groupby_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExpression getSet() {
/*  90 */     return this.setclause_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector getOrderBy() {
/*  96 */     return this.orderby_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDistinct() {
/* 101 */     return this.distinct_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isForUpdate() {
/* 106 */     return this.forupdate_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuffer stringBuffer = new StringBuffer("select ");
/* 111 */     if (this.distinct_) stringBuffer.append("distinct ");
/*     */ 
/*     */ 
/*     */     
/* 115 */     stringBuffer.append(this.select_.elementAt(0).toString()); byte b;
/* 116 */     for (b = 1; b < this.select_.size(); b++) {
/* 117 */       stringBuffer.append(", " + this.select_.elementAt(b).toString());
/*     */     }
/*     */ 
/*     */     
/* 121 */     stringBuffer.append(" from ");
/* 122 */     stringBuffer.append(this.from_.elementAt(0).toString());
/* 123 */     for (b = 1; b < this.from_.size(); b++) {
/* 124 */       stringBuffer.append(", " + this.from_.elementAt(b).toString());
/*     */     }
/*     */     
/* 127 */     if (this.where_ != null) {
/* 128 */       stringBuffer.append(" where " + this.where_.toString());
/*     */     }
/* 130 */     if (this.groupby_ != null) {
/* 131 */       stringBuffer.append(" " + this.groupby_.toString());
/*     */     }
/* 133 */     if (this.setclause_ != null) {
/* 134 */       stringBuffer.append(" " + this.setclause_.toString());
/*     */     }
/* 136 */     if (this.orderby_ != null) {
/* 137 */       stringBuffer.append(" order by ");
/*     */       
/* 139 */       stringBuffer.append(this.orderby_.elementAt(0).toString());
/* 140 */       for (b = 1; b < this.orderby_.size(); b++) {
/* 141 */         stringBuffer.append(", " + this.orderby_.elementAt(b).toString());
/*     */       }
/*     */     } 
/* 144 */     if (this.forupdate_) stringBuffer.append(" for update");
/*     */     
/* 146 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZQuery.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */