/*     */ package Zql;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ public class SimpleCharStream
/*     */ {
/*     */   public static final boolean staticFlag = false;
/*     */   int bufsize;
/*     */   int available;
/*     */   int tokenBegin;
/*  15 */   public int bufpos = -1;
/*     */   
/*     */   protected int[] bufline;
/*     */   protected int[] bufcolumn;
/*  19 */   protected int column = 0;
/*  20 */   protected int line = 1;
/*     */   
/*     */   protected boolean prevCharIsCR = false;
/*     */   
/*     */   protected boolean prevCharIsLF = false;
/*     */   
/*     */   protected Reader inputStream;
/*     */   protected char[] buffer;
/*  28 */   protected int maxNextCharInd = 0;
/*  29 */   protected int inBuf = 0;
/*  30 */   protected int tabSize = 8;
/*     */   
/*  32 */   protected void setTabSize(int paramInt) { this.tabSize = paramInt; } protected int getTabSize(int paramInt) {
/*  33 */     return this.tabSize;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ExpandBuff(boolean paramBoolean) {
/*  38 */     char[] arrayOfChar = new char[this.bufsize + 2048];
/*  39 */     int[] arrayOfInt1 = new int[this.bufsize + 2048];
/*  40 */     int[] arrayOfInt2 = new int[this.bufsize + 2048];
/*     */ 
/*     */     
/*     */     try {
/*  44 */       if (paramBoolean)
/*     */       {
/*  46 */         System.arraycopy(this.buffer, this.tokenBegin, arrayOfChar, 0, this.bufsize - this.tokenBegin);
/*  47 */         System.arraycopy(this.buffer, 0, arrayOfChar, this.bufsize - this.tokenBegin, this.bufpos);
/*     */         
/*  49 */         this.buffer = arrayOfChar;
/*     */         
/*  51 */         System.arraycopy(this.bufline, this.tokenBegin, arrayOfInt1, 0, this.bufsize - this.tokenBegin);
/*  52 */         System.arraycopy(this.bufline, 0, arrayOfInt1, this.bufsize - this.tokenBegin, this.bufpos);
/*  53 */         this.bufline = arrayOfInt1;
/*     */         
/*  55 */         System.arraycopy(this.bufcolumn, this.tokenBegin, arrayOfInt2, 0, this.bufsize - this.tokenBegin);
/*  56 */         System.arraycopy(this.bufcolumn, 0, arrayOfInt2, this.bufsize - this.tokenBegin, this.bufpos);
/*  57 */         this.bufcolumn = arrayOfInt2;
/*     */         
/*  59 */         this.maxNextCharInd = this.bufpos += this.bufsize - this.tokenBegin;
/*     */       }
/*     */       else
/*     */       {
/*  63 */         System.arraycopy(this.buffer, this.tokenBegin, arrayOfChar, 0, this.bufsize - this.tokenBegin);
/*  64 */         this.buffer = arrayOfChar;
/*     */         
/*  66 */         System.arraycopy(this.bufline, this.tokenBegin, arrayOfInt1, 0, this.bufsize - this.tokenBegin);
/*  67 */         this.bufline = arrayOfInt1;
/*     */         
/*  69 */         System.arraycopy(this.bufcolumn, this.tokenBegin, arrayOfInt2, 0, this.bufsize - this.tokenBegin);
/*  70 */         this.bufcolumn = arrayOfInt2;
/*     */         
/*  72 */         this.maxNextCharInd = this.bufpos -= this.tokenBegin;
/*     */       }
/*     */     
/*  75 */     } catch (Throwable throwable) {
/*     */       
/*  77 */       throw new Error(throwable.getMessage());
/*     */     } 
/*     */ 
/*     */     
/*  81 */     this.bufsize += 2048;
/*  82 */     this.available = this.bufsize;
/*  83 */     this.tokenBegin = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void FillBuff() throws IOException {
/*  88 */     if (this.maxNextCharInd == this.available)
/*     */     {
/*  90 */       if (this.available == this.bufsize) {
/*     */         
/*  92 */         if (this.tokenBegin > 2048) {
/*     */           
/*  94 */           this.bufpos = this.maxNextCharInd = 0;
/*  95 */           this.available = this.tokenBegin;
/*     */         }
/*  97 */         else if (this.tokenBegin < 0) {
/*  98 */           this.bufpos = this.maxNextCharInd = 0;
/*     */         } else {
/* 100 */           ExpandBuff(false);
/*     */         } 
/* 102 */       } else if (this.available > this.tokenBegin) {
/* 103 */         this.available = this.bufsize;
/* 104 */       } else if (this.tokenBegin - this.available < 2048) {
/* 105 */         ExpandBuff(true);
/*     */       } else {
/* 107 */         this.available = this.tokenBegin;
/*     */       } 
/*     */     }
/*     */     try {
/*     */       int i;
/* 112 */       if ((i = this.inputStream.read(this.buffer, this.maxNextCharInd, this.available - this.maxNextCharInd)) == -1) {
/*     */ 
/*     */         
/* 115 */         this.inputStream.close();
/* 116 */         throw new IOException();
/*     */       } 
/*     */       
/* 119 */       this.maxNextCharInd += i;
/*     */       
/*     */       return;
/* 122 */     } catch (IOException iOException) {
/* 123 */       this.bufpos--;
/* 124 */       backup(0);
/* 125 */       if (this.tokenBegin == -1)
/* 126 */         this.tokenBegin = this.bufpos; 
/* 127 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public char BeginToken() throws IOException {
/* 133 */     this.tokenBegin = -1;
/* 134 */     char c = readChar();
/* 135 */     this.tokenBegin = this.bufpos;
/*     */     
/* 137 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void UpdateLineColumn(char paramChar) {
/* 142 */     this.column++;
/*     */     
/* 144 */     if (this.prevCharIsLF) {
/*     */       
/* 146 */       this.prevCharIsLF = false;
/* 147 */       this.line += this.column = 1;
/*     */     }
/* 149 */     else if (this.prevCharIsCR) {
/*     */       
/* 151 */       this.prevCharIsCR = false;
/* 152 */       if (paramChar == '\n') {
/*     */         
/* 154 */         this.prevCharIsLF = true;
/*     */       } else {
/*     */         
/* 157 */         this.line += this.column = 1;
/*     */       } 
/*     */     } 
/* 160 */     switch (paramChar) {
/*     */       
/*     */       case '\r':
/* 163 */         this.prevCharIsCR = true;
/*     */         break;
/*     */       case '\n':
/* 166 */         this.prevCharIsLF = true;
/*     */         break;
/*     */       case '\t':
/* 169 */         this.column--;
/* 170 */         this.column += this.tabSize - this.column % this.tabSize;
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.bufline[this.bufpos] = this.line;
/* 177 */     this.bufcolumn[this.bufpos] = this.column;
/*     */   }
/*     */ 
/*     */   
/*     */   public char readChar() throws IOException {
/* 182 */     if (this.inBuf > 0) {
/*     */       
/* 184 */       this.inBuf--;
/*     */       
/* 186 */       if (++this.bufpos == this.bufsize) {
/* 187 */         this.bufpos = 0;
/*     */       }
/* 189 */       return this.buffer[this.bufpos];
/*     */     } 
/*     */     
/* 192 */     if (++this.bufpos >= this.maxNextCharInd) {
/* 193 */       FillBuff();
/*     */     }
/* 195 */     char c = this.buffer[this.bufpos];
/*     */     
/* 197 */     UpdateLineColumn(c);
/* 198 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 207 */     return this.bufcolumn[this.bufpos];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLine() {
/* 216 */     return this.bufline[this.bufpos];
/*     */   }
/*     */   
/*     */   public int getEndColumn() {
/* 220 */     return this.bufcolumn[this.bufpos];
/*     */   }
/*     */   
/*     */   public int getEndLine() {
/* 224 */     return this.bufline[this.bufpos];
/*     */   }
/*     */   
/*     */   public int getBeginColumn() {
/* 228 */     return this.bufcolumn[this.tokenBegin];
/*     */   }
/*     */   
/*     */   public int getBeginLine() {
/* 232 */     return this.bufline[this.tokenBegin];
/*     */   }
/*     */ 
/*     */   
/*     */   public void backup(int paramInt) {
/* 237 */     this.inBuf += paramInt;
/* 238 */     if ((this.bufpos -= paramInt) < 0) {
/* 239 */       this.bufpos += this.bufsize;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader, int paramInt1, int paramInt2, int paramInt3) {
/* 245 */     this.inputStream = paramReader;
/* 246 */     this.line = paramInt1;
/* 247 */     this.column = paramInt2 - 1;
/*     */     
/* 249 */     this.available = this.bufsize = paramInt3;
/* 250 */     this.buffer = new char[paramInt3];
/* 251 */     this.bufline = new int[paramInt3];
/* 252 */     this.bufcolumn = new int[paramInt3];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader, int paramInt1, int paramInt2) {
/* 258 */     this(paramReader, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader) {
/* 263 */     this(paramReader, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader, int paramInt1, int paramInt2, int paramInt3) {
/* 268 */     this.inputStream = paramReader;
/* 269 */     this.line = paramInt1;
/* 270 */     this.column = paramInt2 - 1;
/*     */     
/* 272 */     if (this.buffer == null || paramInt3 != this.buffer.length) {
/*     */       
/* 274 */       this.available = this.bufsize = paramInt3;
/* 275 */       this.buffer = new char[paramInt3];
/* 276 */       this.bufline = new int[paramInt3];
/* 277 */       this.bufcolumn = new int[paramInt3];
/*     */     } 
/* 279 */     this.prevCharIsLF = this.prevCharIsCR = false;
/* 280 */     this.tokenBegin = this.inBuf = this.maxNextCharInd = 0;
/* 281 */     this.bufpos = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader, int paramInt1, int paramInt2) {
/* 287 */     ReInit(paramReader, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader) {
/* 292 */     ReInit(paramReader, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3) throws UnsupportedEncodingException {
/* 297 */     this((paramString == null) ? new InputStreamReader(paramInputStream) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3) {
/* 303 */     this(new InputStreamReader(paramInputStream), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2) throws UnsupportedEncodingException {
/* 309 */     this(paramInputStream, paramString, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 315 */     this(paramInputStream, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString) throws UnsupportedEncodingException {
/* 320 */     this(paramInputStream, paramString, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream) {
/* 325 */     this(paramInputStream, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3) throws UnsupportedEncodingException {
/* 331 */     ReInit((paramString == null) ? new InputStreamReader(paramInputStream) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3) {
/* 337 */     ReInit(new InputStreamReader(paramInputStream), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString) throws UnsupportedEncodingException {
/* 342 */     ReInit(paramInputStream, paramString, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream) {
/* 347 */     ReInit(paramInputStream, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2) throws UnsupportedEncodingException {
/* 352 */     ReInit(paramInputStream, paramString, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 357 */     ReInit(paramInputStream, paramInt1, paramInt2, 4096);
/*     */   }
/*     */   
/*     */   public String GetImage() {
/* 361 */     if (this.bufpos >= this.tokenBegin) {
/* 362 */       return new String(this.buffer, this.tokenBegin, this.bufpos - this.tokenBegin + 1);
/*     */     }
/* 364 */     return new String(this.buffer, this.tokenBegin, this.bufsize - this.tokenBegin) + new String(this.buffer, 0, this.bufpos + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] GetSuffix(int paramInt) {
/* 370 */     char[] arrayOfChar = new char[paramInt];
/*     */     
/* 372 */     if (this.bufpos + 1 >= paramInt) {
/* 373 */       System.arraycopy(this.buffer, this.bufpos - paramInt + 1, arrayOfChar, 0, paramInt);
/*     */     } else {
/*     */       
/* 376 */       System.arraycopy(this.buffer, this.bufsize - paramInt - this.bufpos - 1, arrayOfChar, 0, paramInt - this.bufpos - 1);
/*     */       
/* 378 */       System.arraycopy(this.buffer, 0, arrayOfChar, paramInt - this.bufpos - 1, this.bufpos + 1);
/*     */     } 
/*     */     
/* 381 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */   
/*     */   public void Done() {
/* 386 */     this.buffer = null;
/* 387 */     this.bufline = null;
/* 388 */     this.bufcolumn = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void adjustBeginLineColumn(int paramInt1, int paramInt2) {
/* 396 */     int j, i = this.tokenBegin;
/*     */ 
/*     */     
/* 399 */     if (this.bufpos >= this.tokenBegin) {
/*     */       
/* 401 */       j = this.bufpos - this.tokenBegin + this.inBuf + 1;
/*     */     }
/*     */     else {
/*     */       
/* 405 */       j = this.bufsize - this.tokenBegin + this.bufpos + 1 + this.inBuf;
/*     */     } 
/*     */     
/* 408 */     byte b = 0; int k = 0, m = 0;
/* 409 */     int n = 0, i1 = 0;
/*     */ 
/*     */     
/* 412 */     while (b < j && this.bufline[k = i % this.bufsize] == this.bufline[m = ++i % this.bufsize]) {
/*     */       
/* 414 */       this.bufline[k] = paramInt1;
/* 415 */       n = i1 + this.bufcolumn[m] - this.bufcolumn[k];
/* 416 */       this.bufcolumn[k] = paramInt2 + i1;
/* 417 */       i1 = n;
/* 418 */       b++;
/*     */     } 
/*     */     
/* 421 */     if (b < j) {
/*     */       
/* 423 */       this.bufline[k] = paramInt1++;
/* 424 */       this.bufcolumn[k] = paramInt2 + i1;
/*     */       
/* 426 */       while (b++ < j) {
/*     */         
/* 428 */         if (this.bufline[k = i % this.bufsize] != this.bufline[++i % this.bufsize]) {
/* 429 */           this.bufline[k] = paramInt1++; continue;
/*     */         } 
/* 431 */         this.bufline[k] = paramInt1;
/*     */       } 
/*     */     } 
/*     */     
/* 435 */     this.line = this.bufline[k];
/* 436 */     this.column = this.bufcolumn[k];
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/SimpleCharStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */