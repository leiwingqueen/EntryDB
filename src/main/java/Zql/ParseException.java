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
/*     */ public class ParseException
/*     */   extends Exception
/*     */ {
/*     */   protected boolean specialConstructor;
/*     */   public Token currentToken;
/*     */   public int[][] expectedTokenSequences;
/*     */   public String[] tokenImage;
/*     */   protected String eol;
/*     */   
/*     */   public ParseException(Token paramToken, int[][] paramArrayOfint, String[] paramArrayOfString) {
/*  32 */     super("");
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
/* 140 */     this.eol = System.getProperty("line.separator", "\n"); this.specialConstructor = true; this.currentToken = paramToken; this.expectedTokenSequences = paramArrayOfint; this.tokenImage = paramArrayOfString; } public ParseException() { this.eol = System.getProperty("line.separator", "\n"); this.specialConstructor = false; } public ParseException(String paramString) { super(paramString); this.eol = System.getProperty("line.separator", "\n");
/*     */     this.specialConstructor = false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String add_escapes(String paramString) {
/* 148 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 150 */     for (byte b = 0; b < paramString.length(); b++) {
/* 151 */       char c; switch (paramString.charAt(b)) {
/*     */         case '\000':
/*     */           break;
/*     */         
/*     */         case '\b':
/* 156 */           stringBuffer.append("\\b");
/*     */           break;
/*     */         case '\t':
/* 159 */           stringBuffer.append("\\t");
/*     */           break;
/*     */         case '\n':
/* 162 */           stringBuffer.append("\\n");
/*     */           break;
/*     */         case '\f':
/* 165 */           stringBuffer.append("\\f");
/*     */           break;
/*     */         case '\r':
/* 168 */           stringBuffer.append("\\r");
/*     */           break;
/*     */         case '"':
/* 171 */           stringBuffer.append("\\\"");
/*     */           break;
/*     */         case '\'':
/* 174 */           stringBuffer.append("\\'");
/*     */           break;
/*     */         case '\\':
/* 177 */           stringBuffer.append("\\\\");
/*     */           break;
/*     */         default:
/* 180 */           if ((c = paramString.charAt(b)) < ' ' || c > '~') {
/* 181 */             String str = "0000" + Integer.toString(c, 16);
/* 182 */             stringBuffer.append("\\u" + str.substring(str.length() - 4, str.length())); break;
/*     */           } 
/* 184 */           stringBuffer.append(c);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 189 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*     */     if (!this.specialConstructor)
/*     */       return super.getMessage(); 
/*     */     StringBuffer stringBuffer = new StringBuffer();
/*     */     int i = 0;
/*     */     for (byte b1 = 0; b1 < this.expectedTokenSequences.length; b1++) {
/*     */       if (i < (this.expectedTokenSequences[b1]).length)
/*     */         i = (this.expectedTokenSequences[b1]).length; 
/*     */       for (byte b = 0; b < (this.expectedTokenSequences[b1]).length; b++)
/*     */         stringBuffer.append(this.tokenImage[this.expectedTokenSequences[b1][b]]).append(" "); 
/*     */       if (this.expectedTokenSequences[b1][(this.expectedTokenSequences[b1]).length - 1] != 0)
/*     */         stringBuffer.append("..."); 
/*     */       stringBuffer.append(this.eol).append("    ");
/*     */     } 
/*     */     String str = "Encountered \"";
/*     */     Token token = this.currentToken.next;
/*     */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       if (b2 != 0)
/*     */         str = str + " "; 
/*     */       if (token.kind == 0) {
/*     */         str = str + this.tokenImage[0];
/*     */         break;
/*     */       } 
/*     */       str = str + add_escapes(token.image);
/*     */       token = token.next;
/*     */     } 
/*     */     str = str + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn;
/*     */     str = str + "." + this.eol;
/*     */     if (this.expectedTokenSequences.length == 1) {
/*     */       str = str + "Was expecting:" + this.eol + "    ";
/*     */     } else {
/*     */       str = str + "Was expecting one of:" + this.eol + "    ";
/*     */     } 
/*     */     str = str + stringBuffer.toString();
/*     */     return str;
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ParseException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */