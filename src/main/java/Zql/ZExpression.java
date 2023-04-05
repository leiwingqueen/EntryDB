/*     */ package Zql;
/*     */ 
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZExpression
/*     */   implements ZExp
/*     */ {
/*  14 */   String op_ = null;
/*  15 */   Vector operands_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExpression(String paramString) {
/*  22 */     this.op_ = new String(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExpression(String paramString, ZExp paramZExp) {
/*  31 */     this.op_ = new String(paramString);
/*  32 */     addOperand(paramZExp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExpression(String paramString, ZExp paramZExp1, ZExp paramZExp2) {
/*  42 */     this.op_ = new String(paramString);
/*  43 */     addOperand(paramZExp1);
/*  44 */     addOperand(paramZExp2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOperator() {
/*  51 */     return this.op_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOperands(Vector paramVector) {
/*  58 */     this.operands_ = paramVector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector getOperands() {
/*  66 */     return this.operands_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOperand(ZExp paramZExp) {
/*  74 */     if (this.operands_ == null) this.operands_ = new Vector(); 
/*  75 */     this.operands_.addElement(paramZExp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp getOperand(int paramInt) {
/*  84 */     if (this.operands_ == null || paramInt >= this.operands_.size()) return null; 
/*  85 */     return this.operands_.elementAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nbOperands() {
/*  93 */     if (this.operands_ == null) return 0; 
/*  94 */     return this.operands_.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toReversePolish() {
/* 103 */     StringBuffer stringBuffer = new StringBuffer("(");
/* 104 */     stringBuffer.append(this.op_);
/* 105 */     for (byte b = 0; b < nbOperands(); b++) {
/* 106 */       ZExp zExp = getOperand(b);
/* 107 */       if (zExp instanceof ZExpression) {
/* 108 */         stringBuffer.append(" " + ((ZExpression)zExp).toReversePolish());
/* 109 */       } else if (zExp instanceof ZQuery) {
/* 110 */         stringBuffer.append(" (" + zExp.toString() + ")");
/*     */       } else {
/* 112 */         stringBuffer.append(" " + zExp.toString());
/*     */       } 
/* 114 */     }  stringBuffer.append(")");
/* 115 */     return stringBuffer.toString(); } public String toString() {
/*     */     ZExp zExp;
/*     */     boolean bool;
/*     */     int i;
/*     */     byte b;
/* 120 */     if (this.op_.equals("?")) return this.op_;
/*     */     
/* 122 */     if (ZUtils.isCustomFunction(this.op_) >= 0) {
/* 123 */       return formatFunction();
/*     */     }
/* 125 */     StringBuffer stringBuffer = new StringBuffer();
/* 126 */     if (needPar(this.op_)) stringBuffer.append("(");
/*     */ 
/*     */     
/* 129 */     switch (nbOperands()) {
/*     */       
/*     */       case 1:
/* 132 */         zExp = getOperand(0);
/* 133 */         if (zExp instanceof ZConstant) {
/*     */           
/* 135 */           if (ZUtils.isAggregate(this.op_)) {
/* 136 */             stringBuffer.append(this.op_ + "(" + zExp.toString() + ")"); break;
/* 137 */           }  if (this.op_.equals("IS NULL") || this.op_.equals("IS NOT NULL")) {
/* 138 */             stringBuffer.append(zExp.toString() + " " + this.op_); break;
/*     */           } 
/* 140 */           if (this.op_.equals(",")) { stringBuffer.append(zExp.toString()); break; }
/* 141 */            stringBuffer.append(this.op_ + " " + zExp.toString()); break;
/* 142 */         }  if (zExp instanceof ZQuery) {
/* 143 */           stringBuffer.append(this.op_ + " (" + zExp.toString() + ")"); break;
/*     */         } 
/* 145 */         if (this.op_.equals("IS NULL") || this.op_.equals("IS NOT NULL")) {
/* 146 */           stringBuffer.append(zExp.toString() + " " + this.op_); break;
/*     */         } 
/* 148 */         if (this.op_.equals(",")) { stringBuffer.append(zExp.toString()); break; }
/* 149 */          stringBuffer.append(this.op_ + " " + zExp.toString());
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 154 */         if (this.op_.toUpperCase().endsWith("BETWEEN")) {
/* 155 */           stringBuffer.append(getOperand(0).toString() + " " + this.op_ + " " + getOperand(1).toString() + " AND " + getOperand(2).toString());
/*     */           break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 163 */         bool = (this.op_.equals("IN") || this.op_.equals("NOT IN")) ? true : false;
/*     */         
/* 165 */         i = nbOperands();
/* 166 */         for (b = 0; b < i; b++) {
/*     */           
/* 168 */           if (bool && b == 1) stringBuffer.append(" " + this.op_ + " (");
/*     */           
/* 170 */           zExp = getOperand(b);
/* 171 */           if (zExp instanceof ZQuery && !bool) {
/* 172 */             stringBuffer.append("(" + zExp.toString() + ")");
/*     */           } else {
/* 174 */             stringBuffer.append(zExp.toString());
/*     */           } 
/* 176 */           if (b < i - 1)
/* 177 */             if (this.op_.equals(",") || (bool && b > 0)) { stringBuffer.append(", "); }
/* 178 */             else if (!bool) { stringBuffer.append(" " + this.op_ + " "); }
/*     */              
/*     */         } 
/* 181 */         if (bool) stringBuffer.append(")");
/*     */         
/*     */         break;
/*     */     } 
/* 185 */     if (needPar(this.op_)) stringBuffer.append(")"); 
/* 186 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private boolean needPar(String paramString) {
/* 190 */     String str = paramString.toUpperCase();
/* 191 */     return (!str.equals("ANY") && !str.equals("ALL") && !str.equals("UNION") && !ZUtils.isAggregate(str));
/*     */   }
/*     */ 
/*     */   
/*     */   private String formatFunction() {
/* 196 */     StringBuffer stringBuffer = new StringBuffer(this.op_ + "(");
/* 197 */     int i = nbOperands();
/* 198 */     for (byte b = 0; b < i; b++) {
/* 199 */       stringBuffer.append(getOperand(b).toString() + ((b < i - 1) ? "," : ""));
/*     */     }
/* 201 */     stringBuffer.append(")");
/* 202 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZExpression.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */