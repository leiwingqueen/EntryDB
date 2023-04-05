/*     */ package Zql;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TokenMgrError
/*     */   extends Error
/*     */ {
/*     */   static final int LEXICAL_ERROR = 0;
/*     */   static final int STATIC_LEXER_ERROR = 1;
/*     */   static final int INVALID_LEXICAL_STATE = 2;
/*     */   static final int LOOP_DETECTED = 3;
/*     */   int errorCode;
/*     */   
/*     */   protected static final String addEscapes(String paramString) {
/*  41 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  43 */     for (byte b = 0; b < paramString.length(); b++) {
/*  44 */       char c; switch (paramString.charAt(b)) {
/*     */         case '\000':
/*     */           break;
/*     */         
/*     */         case '\b':
/*  49 */           stringBuffer.append("\\b");
/*     */           break;
/*     */         case '\t':
/*  52 */           stringBuffer.append("\\t");
/*     */           break;
/*     */         case '\n':
/*  55 */           stringBuffer.append("\\n");
/*     */           break;
/*     */         case '\f':
/*  58 */           stringBuffer.append("\\f");
/*     */           break;
/*     */         case '\r':
/*  61 */           stringBuffer.append("\\r");
/*     */           break;
/*     */         case '"':
/*  64 */           stringBuffer.append("\\\"");
/*     */           break;
/*     */         case '\'':
/*  67 */           stringBuffer.append("\\'");
/*     */           break;
/*     */         case '\\':
/*  70 */           stringBuffer.append("\\\\");
/*     */           break;
/*     */         default:
/*  73 */           if ((c = paramString.charAt(b)) < ' ' || c > '~') {
/*  74 */             String str = "0000" + Integer.toString(c, 16);
/*  75 */             stringBuffer.append("\\u" + str.substring(str.length() - 4, str.length())); break;
/*     */           } 
/*  77 */           stringBuffer.append(c);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/*  82 */     return stringBuffer.toString();
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
/*     */ 
/*     */   
/*     */   protected static String LexicalError(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, char paramChar) {
/*  98 */     return "Lexical error at line " + paramInt2 + ", column " + paramInt3 + ".  Encountered: " + (paramBoolean ? "<EOF> " : ("\"" + addEscapes(String.valueOf(paramChar)) + "\"" + " (" + paramChar + "), ")) + "after : \"" + addEscapes(paramString) + "\"";
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 115 */     return super.getMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenMgrError() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public TokenMgrError(String paramString, int paramInt) {
/* 126 */     super(paramString);
/* 127 */     this.errorCode = paramInt;
/*     */   }
/*     */   
/*     */   public TokenMgrError(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, char paramChar, int paramInt4) {
/* 131 */     this(LexicalError(paramBoolean, paramInt1, paramInt2, paramInt3, paramString, paramChar), paramInt4);
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/TokenMgrError.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */