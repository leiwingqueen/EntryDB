/*     */ package Zql;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZAliasedName
/*     */   implements Serializable
/*     */ {
/*  17 */   String strform_ = "";
/*  18 */   String schema_ = null;
/*  19 */   String table_ = null;
/*  20 */   String column_ = null;
/*  21 */   String alias_ = null;
/*     */   
/*  23 */   public static int FORM_TABLE = 1;
/*  24 */   public static int FORM_COLUMN = 2;
/*     */   
/*  26 */   int form_ = FORM_COLUMN;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZAliasedName() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZAliasedName(String paramString, int paramInt) {
/*  37 */     this.form_ = paramInt;
/*  38 */     this.strform_ = new String(paramString);
/*     */     
/*  40 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ".");
/*  41 */     switch (stringTokenizer.countTokens()) {
/*     */       case 1:
/*  43 */         if (paramInt == FORM_TABLE) { this.table_ = new String(stringTokenizer.nextToken()); }
/*  44 */         else { this.column_ = new String(stringTokenizer.nextToken()); }
/*     */          return;
/*     */       case 2:
/*  47 */         if (paramInt == FORM_TABLE) {
/*  48 */           this.schema_ = new String(stringTokenizer.nextToken());
/*  49 */           this.table_ = new String(stringTokenizer.nextToken());
/*     */         } else {
/*  51 */           this.table_ = new String(stringTokenizer.nextToken());
/*  52 */           this.column_ = new String(stringTokenizer.nextToken());
/*     */         } 
/*     */         return;
/*     */     } 
/*     */     
/*  57 */     this.schema_ = new String(stringTokenizer.nextToken());
/*  58 */     this.table_ = new String(stringTokenizer.nextToken());
/*  59 */     this.column_ = new String(stringTokenizer.nextToken());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  65 */     if (this.alias_ == null) return this.strform_; 
/*  66 */     return this.strform_ + " " + this.alias_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchema() {
/*  73 */     return this.schema_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTable() {
/*  79 */     return this.table_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumn() {
/*  85 */     return this.column_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWildcard() {
/*  92 */     if (this.form_ == FORM_TABLE) return (this.table_ != null && this.table_.equals("*")); 
/*  93 */     return (this.column_ != null && this.column_.indexOf('*') >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAlias() {
/*  99 */     return this.alias_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlias(String paramString) {
/* 105 */     this.alias_ = new String(paramString);
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZAliasedName.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */