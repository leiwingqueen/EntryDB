/*     */ package Zql;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ public class ZqlParser
/*     */ {
/*  12 */   ZqlJJParser _parser = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws ParseException {
/*  22 */     ZqlParser zqlParser = null;
/*     */     
/*  24 */     if (paramArrayOfString.length < 1) {
/*  25 */       System.out.println("/* Reading from stdin (exit; to finish) */");
/*  26 */       zqlParser = new ZqlParser(System.in);
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*  31 */         zqlParser = new ZqlParser(new DataInputStream(new FileInputStream(paramArrayOfString[0])));
/*  32 */       } catch (FileNotFoundException fileNotFoundException) {
/*  33 */         System.out.println("/* File " + paramArrayOfString[0] + " not found. Reading from stdin */");
/*     */         
/*  35 */         zqlParser = new ZqlParser(System.in);
/*     */       } 
/*     */     } 
/*     */     
/*  39 */     if (paramArrayOfString.length > 0) {
/*  40 */       System.out.println("/* Reading from " + paramArrayOfString[0] + "*/");
/*     */     }
/*     */     
/*  43 */     ZStatement zStatement = null;
/*  44 */     while ((zStatement = zqlParser.readStatement()) != null) {
/*  45 */       System.out.println(zStatement.toString() + ";");
/*     */     }
/*     */     
/*  48 */     System.out.println("exit;");
/*  49 */     System.out.println("/* Parse Successful */");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZqlParser(InputStream paramInputStream) {
/*  59 */     initParser(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZqlParser() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initParser(InputStream paramInputStream) {
/*  72 */     if (this._parser == null) {
/*  73 */       this._parser = new ZqlJJParser(paramInputStream);
/*     */     } else {
/*  75 */       this._parser.ReInit(paramInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addCustomFunction(String paramString, int paramInt) {
/*  80 */     ZUtils.addCustomFunction(paramString, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZStatement readStatement() throws ParseException {
/*  88 */     if (this._parser == null) {
/*  89 */       throw new ParseException("Parser not initialized: use initParser(InputStream);");
/*     */     }
/*  91 */     return this._parser.SQLStatement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector readStatements() throws ParseException {
/* 100 */     if (this._parser == null) {
/* 101 */       throw new ParseException("Parser not initialized: use initParser(InputStream);");
/*     */     }
/* 103 */     return this._parser.SQLStatements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZExp readExpression() throws ParseException {
/* 111 */     if (this._parser == null) {
/* 112 */       throw new ParseException("Parser not initialized: use initParser(InputStream);");
/*     */     }
/* 114 */     return this._parser.SQLExpression();
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZqlParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */