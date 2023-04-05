/*     */ package Zql;
/*     */ 
/*     */ import java.util.Hashtable;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
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
/*     */ 
/*     */ 
/*     */ public class ZTuple
/*     */ {
/*  30 */   private Vector attributes_ = new Vector();
/*  31 */   private Vector values_ = new Vector();
/*  32 */   private Hashtable searchTable_ = new Hashtable();
/*     */ 
/*     */ 
/*     */   
/*     */   public ZTuple() {}
/*     */ 
/*     */   
/*     */   public ZTuple(String paramString) {
/*  40 */     this();
/*  41 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
/*  42 */     while (stringTokenizer.hasMoreTokens()) {
/*  43 */       setAtt(stringTokenizer.nextToken().trim(), null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(String paramString) {
/*  52 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
/*  53 */     for (byte b = 0; stringTokenizer.hasMoreTokens(); b++) {
/*  54 */       String str = stringTokenizer.nextToken().trim();
/*     */       try {
/*  56 */         Double double_ = new Double(str);
/*  57 */         setAtt(getAttName(b), double_);
/*  58 */       } catch (Exception exception) {
/*  59 */         setAtt(getAttName(b), str);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(Vector paramVector) {
/*  69 */     for (byte b = 0; b < paramVector.size(); b++) {
/*  70 */       setAtt(getAttName(b), paramVector.elementAt(b));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAtt(String paramString, Object paramObject) {
/*  82 */     if (paramString != null) {
/*     */       
/*  84 */       boolean bool = this.searchTable_.containsKey(paramString);
/*     */       
/*  86 */       if (bool) {
/*     */         
/*  88 */         int i = ((Integer)this.searchTable_.get(paramString)).intValue();
/*  89 */         this.values_.setElementAt(paramObject, i);
/*     */       }
/*     */       else {
/*     */         
/*  93 */         int i = this.attributes_.size();
/*  94 */         this.attributes_.addElement(paramString);
/*  95 */         this.values_.addElement(paramObject);
/*  96 */         this.searchTable_.put(paramString, new Integer(i));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAttName(int paramInt) {
/*     */     try {
/* 110 */       return this.attributes_.elementAt(paramInt);
/*     */     }
/* 112 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*     */       
/* 114 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttIndex(String paramString) {
/* 125 */     if (paramString == null)
/* 126 */       return -1; 
/* 127 */     Integer integer = (Integer)this.searchTable_.get(paramString);
/* 128 */     if (integer != null) {
/* 129 */       return integer.intValue();
/*     */     }
/* 131 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getAttValue(int paramInt) {
/*     */     try {
/* 143 */       return this.values_.elementAt(paramInt);
/*     */     }
/* 145 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*     */       
/* 147 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getAttValue(String paramString) {
/* 157 */     boolean bool = false;
/*     */     
/* 159 */     if (paramString != null) {
/* 160 */       bool = this.searchTable_.containsKey(paramString);
/*     */     }
/* 162 */     if (bool) {
/*     */       
/* 164 */       int i = ((Integer)this.searchTable_.get(paramString)).intValue();
/* 165 */       return this.values_.elementAt(i);
/*     */     } 
/*     */     
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAttribute(String paramString) {
/* 178 */     if (paramString != null) {
/* 179 */       return this.searchTable_.containsKey(paramString);
/*     */     }
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumAtt() {
/* 190 */     return this.values_.size();
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
/*     */   
/*     */   public String toString() {
/* 204 */     StringBuffer stringBuffer = new StringBuffer();
/* 205 */     stringBuffer.append("[");
/* 206 */     if (this.attributes_.size() > 0) {
/*     */       String str1, str2;
/* 208 */       Object object1 = this.attributes_.elementAt(0);
/* 209 */       if (object1 == null) {
/* 210 */         str1 = "(null)";
/*     */       } else {
/* 212 */         str1 = object1.toString();
/*     */       } 
/* 214 */       Object object2 = this.values_.elementAt(0);
/* 215 */       if (object2 == null) {
/* 216 */         str2 = "(null)";
/*     */       } else {
/* 218 */         str2 = object2.toString();
/* 219 */       }  stringBuffer.append(str1 + " = " + str2);
/*     */     } 
/*     */     
/* 222 */     for (byte b = 1; b < this.attributes_.size(); b++) {
/*     */       String str1, str2;
/* 224 */       Object object1 = this.attributes_.elementAt(b);
/* 225 */       if (object1 == null) {
/* 226 */         str1 = "(null)";
/*     */       } else {
/* 228 */         str1 = object1.toString();
/*     */       } 
/* 230 */       Object object2 = this.values_.elementAt(b);
/* 231 */       if (object2 == null) {
/* 232 */         str2 = "(null)";
/*     */       } else {
/* 234 */         str2 = object2.toString();
/* 235 */       }  stringBuffer.append(", " + str1 + " = " + str2);
/*     */     } 
/* 237 */     stringBuffer.append("]");
/* 238 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZTuple.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */