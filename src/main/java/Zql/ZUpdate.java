/*     */ package Zql;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZUpdate
/*     */   implements ZStatement
/*     */ {
/*     */   String table_;
/*  13 */   String alias_ = null;
/*     */   Hashtable set_;
/*  15 */   ZExp where_ = null;
/*  16 */   Vector columns_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZUpdate(String paramString) {
/*  22 */     this.table_ = new String(paramString);
/*     */   }
/*     */   
/*     */   public String getTable() {
/*  26 */     return this.table_;
/*     */   }
/*     */   
/*  29 */   public void setAlias(String paramString) { this.alias_ = paramString; } public String getAlias() {
/*  30 */     return this.alias_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSet(Hashtable paramHashtable) {
/*  40 */     this.set_ = paramHashtable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hashtable getSet() {
/*  49 */     return this.set_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addColumnUpdate(String paramString, ZExp paramZExp) {
/*  58 */     if (this.set_ == null) this.set_ = new Hashtable(); 
/*  59 */     this.set_.put(paramString, paramZExp);
/*  60 */     if (this.columns_ == null) this.columns_ = new Vector(); 
/*  61 */     this.columns_.addElement(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp getColumnUpdate(String paramString) {
/*  71 */     return (ZExp)this.set_.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp getColumnUpdate(int paramInt) {
/*  84 */     if (--paramInt < 0) return null; 
/*  85 */     if (this.columns_ == null || paramInt >= this.columns_.size()) return null; 
/*  86 */     String str = this.columns_.elementAt(paramInt);
/*  87 */     return (ZExp)this.set_.get(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumnUpdateName(int paramInt) {
/*  99 */     if (--paramInt < 0) return null; 
/* 100 */     if (this.columns_ == null || paramInt >= this.columns_.size()) return null; 
/* 101 */     return this.columns_.elementAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnUpdateCount() {
/* 108 */     if (this.set_ == null) return 0; 
/* 109 */     return this.set_.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addWhere(ZExp paramZExp) {
/* 116 */     this.where_ = paramZExp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp getWhere() {
/* 122 */     return this.where_;
/*     */   } public String toString() {
/*     */     Enumeration enumeration;
/* 125 */     StringBuffer stringBuffer = new StringBuffer("update " + this.table_);
/* 126 */     if (this.alias_ != null) stringBuffer.append(" " + this.alias_); 
/* 127 */     stringBuffer.append(" set ");
/*     */ 
/*     */     
/* 130 */     if (this.columns_ != null) { enumeration = this.columns_.elements(); }
/* 131 */     else { enumeration = this.set_.keys(); }
/* 132 */      boolean bool = true;
/* 133 */     while (enumeration.hasMoreElements()) {
/* 134 */       String str = enumeration.nextElement().toString();
/* 135 */       if (!bool) stringBuffer.append(", "); 
/* 136 */       stringBuffer.append(str + "=" + this.set_.get(str).toString());
/* 137 */       bool = false;
/*     */     } 
/*     */     
/* 140 */     if (this.where_ != null) stringBuffer.append(" where " + this.where_.toString()); 
/* 141 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZUpdate.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */