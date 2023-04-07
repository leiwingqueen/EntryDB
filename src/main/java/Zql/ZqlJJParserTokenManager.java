/*      */ package Zql;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ZqlJJParserTokenManager
/*      */   implements ZqlJJParserConstants
/*      */ {
/*   11 */   public PrintStream debugStream = System.out;
/*      */   public void setDebugStream(PrintStream paramPrintStream) {
/*   13 */     this.debugStream = paramPrintStream;
/*      */   }
/*      */   private final int jjStopStringLiteralDfa_0(int paramInt, long paramLong1, long paramLong2) {
/*   16 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/*   19 */         if ((paramLong2 & 0x4000000000L) != 0L)
/*   20 */           return 0; 
/*   21 */         if ((paramLong2 & 0x10020000000L) != 0L)
/*   22 */           return 47; 
/*   23 */         if ((paramLong2 & 0x80000000000L) != 0L)
/*   24 */           return 3; 
/*   25 */         if ((paramLong1 & 0xFFFFFFFFFFFFFFE0L) != 0L || (paramLong2 & 0xFFFL) != 0L) {
/*      */           
/*   27 */           this.jjmatchedKind = 82;
/*   28 */           return 48;
/*      */         } 
/*   30 */         return -1;
/*      */       case 1:
/*   32 */         if ((paramLong1 & 0x1A003F00004300L) != 0L)
/*   33 */           return 48; 
/*   34 */         if ((paramLong1 & 0xFFE5FFC0FFFFBCE0L) != 0L || (paramLong2 & 0xFFFL) != 0L) {
/*      */           
/*   36 */           if (this.jjmatchedPos != 1) {
/*      */             
/*   38 */             this.jjmatchedKind = 82;
/*   39 */             this.jjmatchedPos = 1;
/*      */           } 
/*   41 */           return 48;
/*      */         } 
/*   43 */         return -1;
/*      */       case 2:
/*   45 */         if ((paramLong1 & 0xEBF5D8DEEFFFB800L) != 0L || (paramLong2 & 0xFFEL) != 0L) {
/*      */           
/*   47 */           if (this.jjmatchedPos != 2) {
/*      */             
/*   49 */             this.jjmatchedKind = 82;
/*   50 */             this.jjmatchedPos = 2;
/*      */           } 
/*   52 */           return 48;
/*      */         } 
/*   54 */         if ((paramLong1 & 0x14002700100006E0L) != 0L || (paramLong2 & 0x1L) != 0L)
/*   55 */           return 48; 
/*   56 */         return -1;
/*      */       case 3:
/*   58 */         if ((paramLong1 & 0x1C488D024508000L) != 0L || (paramLong2 & 0x600L) != 0L)
/*   59 */           return 48; 
/*   60 */         if ((paramLong1 & 0xEA31540ECBAF3800L) != 0L || (paramLong2 & 0x9FEL) != 0L) {
/*      */           
/*   62 */           this.jjmatchedKind = 82;
/*   63 */           this.jjmatchedPos = 3;
/*   64 */           return 48;
/*      */         } 
/*   66 */         return -1;
/*      */       case 4:
/*   68 */         if ((paramLong1 & 0xA030040048080000L) != 0L || (paramLong2 & 0x90AL) != 0L)
/*   69 */           return 48; 
/*   70 */         if ((paramLong1 & 0x4A01500E83A73800L) != 0L || (paramLong2 & 0xF4L) != 0L) {
/*      */           
/*   72 */           this.jjmatchedKind = 82;
/*   73 */           this.jjmatchedPos = 4;
/*   74 */           return 48;
/*      */         } 
/*   76 */         return -1;
/*      */       case 5:
/*   78 */         if ((paramLong1 & 0x4200100C01853800L) != 0L || (paramLong2 & 0xC4L) != 0L) {
/*      */           
/*   80 */           this.jjmatchedKind = 82;
/*   81 */           this.jjmatchedPos = 5;
/*   82 */           return 48;
/*      */         } 
/*   84 */         if ((paramLong1 & 0x801400282220000L) != 0L || (paramLong2 & 0x30L) != 0L)
/*   85 */           return 48; 
/*   86 */         return -1;
/*      */       case 6:
/*   88 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*   90 */           if (this.jjmatchedPos != 6) {
/*      */             
/*   92 */             this.jjmatchedKind = 82;
/*   93 */             this.jjmatchedPos = 6;
/*      */           } 
/*   95 */           return 11;
/*      */         } 
/*   97 */         if ((paramLong1 & 0x100400052800L) != 0L || (paramLong2 & 0xC0L) != 0L)
/*   98 */           return 48; 
/*   99 */         if ((paramLong1 & 0x4200000801800000L) != 0L || (paramLong2 & 0x4L) != 0L) {
/*      */           
/*  101 */           if (this.jjmatchedPos != 6) {
/*      */             
/*  103 */             this.jjmatchedKind = 82;
/*  104 */             this.jjmatchedPos = 6;
/*      */           } 
/*  106 */           return 48;
/*      */         } 
/*  108 */         return -1;
/*      */       case 7:
/*  110 */         if ((paramLong1 & 0x4200000000800000L) != 0L)
/*  111 */           return 48; 
/*  112 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  114 */           this.jjmatchedKind = 82;
/*  115 */           this.jjmatchedPos = 7;
/*  116 */           return 11;
/*      */         } 
/*  118 */         if ((paramLong2 & 0x40L) != 0L)
/*  119 */           return 11; 
/*  120 */         if ((paramLong1 & 0x801000000L) != 0L || (paramLong2 & 0x4L) != 0L) {
/*      */           
/*  122 */           this.jjmatchedKind = 82;
/*  123 */           this.jjmatchedPos = 7;
/*  124 */           return 48;
/*      */         } 
/*  126 */         return -1;
/*      */       case 8:
/*  128 */         if ((paramLong2 & 0x4L) != 0L) {
/*      */           
/*  130 */           this.jjmatchedKind = 82;
/*  131 */           this.jjmatchedPos = 8;
/*  132 */           return 48;
/*      */         } 
/*  134 */         if ((paramLong1 & 0x801000000L) != 0L)
/*  135 */           return 48; 
/*  136 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  138 */           this.jjmatchedKind = 82;
/*  139 */           this.jjmatchedPos = 8;
/*  140 */           return 11;
/*      */         } 
/*  142 */         return -1;
/*      */       case 9:
/*  144 */         if ((paramLong2 & 0x4L) != 0L) {
/*      */           
/*  146 */           this.jjmatchedKind = 82;
/*  147 */           this.jjmatchedPos = 9;
/*  148 */           return 48;
/*      */         } 
/*  150 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  152 */           this.jjmatchedKind = 82;
/*  153 */           this.jjmatchedPos = 9;
/*  154 */           return 11;
/*      */         } 
/*  156 */         return -1;
/*      */       case 10:
/*  158 */         if ((paramLong2 & 0x4L) != 0L)
/*  159 */           return 48; 
/*  160 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  162 */           this.jjmatchedKind = 82;
/*  163 */           this.jjmatchedPos = 10;
/*  164 */           return 11;
/*      */         } 
/*  166 */         return -1;
/*      */       case 11:
/*  168 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  170 */           this.jjmatchedKind = 82;
/*  171 */           this.jjmatchedPos = 11;
/*  172 */           return 11;
/*      */         } 
/*  174 */         return -1;
/*      */       case 12:
/*  176 */         if ((paramLong1 & 0x1000L) != 0L) {
/*      */           
/*  178 */           this.jjmatchedKind = 82;
/*  179 */           this.jjmatchedPos = 12;
/*  180 */           return 11;
/*      */         } 
/*  182 */         return -1;
/*      */     } 
/*  184 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   private final int jjStartNfa_0(int paramInt, long paramLong1, long paramLong2) {
/*  189 */     return jjMoveNfa_0(jjStopStringLiteralDfa_0(paramInt, paramLong1, paramLong2), paramInt + 1);
/*      */   }
/*      */   
/*      */   private int jjStopAtPos(int paramInt1, int paramInt2) {
/*  193 */     this.jjmatchedKind = paramInt2;
/*  194 */     this.jjmatchedPos = paramInt1;
/*  195 */     return paramInt1 + 1;
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa0_0() {
/*  199 */     switch (this.curChar) {
/*      */       
/*      */       case '!':
/*  202 */         return jjMoveStringLiteralDfa1_0(0L, 1073741824L);
/*      */       case '#':
/*  204 */         return jjStopAtPos(0, 95);
/*      */       case '(':
/*  206 */         return jjStopAtPos(0, 88);
/*      */       case ')':
/*  208 */         return jjStopAtPos(0, 90);
/*      */       case '*':
/*  210 */         this.jjmatchedKind = 103;
/*  211 */         return jjMoveStringLiteralDfa1_0(0L, 17592186044416L);
/*      */       case '+':
/*  213 */         return jjStopAtPos(0, 101);
/*      */       case ',':
/*  215 */         return jjStopAtPos(0, 89);
/*      */       case '-':
/*  217 */         return jjStartNfaWithStates_0(0, 102, 0);
/*      */       case '.':
/*  219 */         this.jjmatchedKind = 93;
/*  220 */         return jjMoveStringLiteralDfa1_0(0L, 1099511627776L);
/*      */       case '/':
/*  222 */         return jjStartNfaWithStates_0(0, 107, 3);
/*      */       case ';':
/*  224 */         return jjStopAtPos(0, 91);
/*      */       case '<':
/*  226 */         this.jjmatchedKind = 99;
/*  227 */         return jjMoveStringLiteralDfa1_0(0L, 73014444032L);
/*      */       case '=':
/*  229 */         return jjStopAtPos(0, 92);
/*      */       case '>':
/*  231 */         this.jjmatchedKind = 97;
/*  232 */         return jjMoveStringLiteralDfa1_0(0L, 17179869184L);
/*      */       case '?':
/*  234 */         return jjStopAtPos(0, 105);
/*      */       case 'A':
/*      */       case 'a':
/*  237 */         return jjMoveStringLiteralDfa1_0(2016L, 0L);
/*      */       case 'B':
/*      */       case 'b':
/*  240 */         return jjMoveStringLiteralDfa1_0(30720L, 0L);
/*      */       case 'C':
/*      */       case 'c':
/*  243 */         return jjMoveStringLiteralDfa1_0(1015808L, 0L);
/*      */       case 'D':
/*      */       case 'd':
/*  246 */         return jjMoveStringLiteralDfa1_0(15728640L, 0L);
/*      */       case 'E':
/*      */       case 'e':
/*  249 */         return jjMoveStringLiteralDfa1_0(117440512L, 0L);
/*      */       case 'F':
/*      */       case 'f':
/*  252 */         return jjMoveStringLiteralDfa1_0(939524096L, 0L);
/*      */       case 'G':
/*      */       case 'g':
/*  255 */         return jjMoveStringLiteralDfa1_0(1073741824L, 0L);
/*      */       case 'H':
/*      */       case 'h':
/*  258 */         return jjMoveStringLiteralDfa1_0(2147483648L, 0L);
/*      */       case 'I':
/*      */       case 'i':
/*  261 */         return jjMoveStringLiteralDfa1_0(270582939648L, 0L);
/*      */       case 'L':
/*      */       case 'l':
/*  264 */         return jjMoveStringLiteralDfa1_0(824633720832L, 0L);
/*      */       case 'M':
/*      */       case 'm':
/*  267 */         return jjMoveStringLiteralDfa1_0(16492674416640L, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  270 */         return jjMoveStringLiteralDfa1_0(545357767376896L, 0L);
/*      */       case 'O':
/*      */       case 'o':
/*  273 */         return jjMoveStringLiteralDfa1_0(8444249301319680L, 0L);
/*      */       case 'P':
/*      */       case 'p':
/*  276 */         return jjMoveStringLiteralDfa1_0(9007199254740992L, 0L);
/*      */       case 'Q':
/*      */       case 'q':
/*  279 */         return jjMoveStringLiteralDfa1_0(18014398509481984L, 0L);
/*      */       case 'R':
/*      */       case 'r':
/*  282 */         return jjMoveStringLiteralDfa1_0(540431955284459520L, 0L);
/*      */       case 'S':
/*      */       case 's':
/*  285 */         return jjMoveStringLiteralDfa1_0(-576460752303423488L, 1L);
/*      */       case 'T':
/*      */       case 't':
/*  288 */         return jjMoveStringLiteralDfa1_0(0L, 6L);
/*      */       case 'U':
/*      */       case 'u':
/*  291 */         return jjMoveStringLiteralDfa1_0(0L, 24L);
/*      */       case 'V':
/*      */       case 'v':
/*  294 */         return jjMoveStringLiteralDfa1_0(0L, 224L);
/*      */       case 'W':
/*      */       case 'w':
/*  297 */         return jjMoveStringLiteralDfa1_0(0L, 3840L);
/*      */       case '|':
/*  299 */         return jjMoveStringLiteralDfa1_0(0L, 4398046511104L);
/*      */     } 
/*  301 */     return jjMoveNfa_0(2, 0);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa1_0(long paramLong1, long paramLong2) {
/*      */     try {
/*  306 */       this.curChar = this.input_stream.readChar();
/*  307 */     } catch (IOException iOException) {
/*  308 */       jjStopStringLiteralDfa_0(0, paramLong1, paramLong2);
/*  309 */       return 1;
/*      */     } 
/*  311 */     switch (this.curChar) {
/*      */       
/*      */       case '*':
/*  314 */         if ((paramLong2 & 0x10000000000L) != 0L)
/*  315 */           return jjStopAtPos(1, 104); 
/*  316 */         if ((paramLong2 & 0x100000000000L) != 0L)
/*  317 */           return jjStopAtPos(1, 108); 
/*      */         break;
/*      */       case '=':
/*  320 */         if ((paramLong2 & 0x40000000L) != 0L)
/*  321 */           return jjStopAtPos(1, 94); 
/*  322 */         if ((paramLong2 & 0x400000000L) != 0L)
/*  323 */           return jjStopAtPos(1, 98); 
/*  324 */         if ((paramLong2 & 0x1000000000L) != 0L)
/*  325 */           return jjStopAtPos(1, 100); 
/*      */         break;
/*      */       case '>':
/*  328 */         if ((paramLong2 & 0x100000000L) != 0L)
/*  329 */           return jjStopAtPos(1, 96); 
/*      */         break;
/*      */       case 'A':
/*      */       case 'a':
/*  333 */         return jjMoveStringLiteralDfa2_0(paramLong1, 18693846204416L, paramLong2, 226L);
/*      */       case 'E':
/*      */       case 'e':
/*  336 */         return jjMoveStringLiteralDfa2_0(paramLong1, 1837468647973455872L, paramLong2, 0L);
/*      */       case 'F':
/*      */       case 'f':
/*  339 */         if ((paramLong1 & 0x2000000000000L) != 0L)
/*  340 */           return jjStartNfaWithStates_0(1, 49, 48); 
/*      */         break;
/*      */       case 'H':
/*      */       case 'h':
/*  344 */         return jjMoveStringLiteralDfa2_0(paramLong1, 2305843009213726720L, paramLong2, 256L);
/*      */       case 'I':
/*      */       case 'i':
/*  347 */         return jjMoveStringLiteralDfa2_0(paramLong1, 6871956066304L, paramLong2, 512L);
/*      */       case 'L':
/*      */       case 'l':
/*  350 */         return jjMoveStringLiteralDfa2_0(paramLong1, 134217760L, paramLong2, 0L);
/*      */       case 'M':
/*      */       case 'm':
/*  353 */         return jjMoveStringLiteralDfa2_0(paramLong1, 4611686018427387904L, paramLong2, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  356 */         if ((paramLong1 & 0x100000000L) != 0L) {
/*      */           
/*  358 */           this.jjmatchedKind = 32;
/*  359 */           this.jjmatchedPos = 1;
/*      */         } 
/*  361 */         return jjMoveStringLiteralDfa2_0(paramLong1, 1126028755861696L, paramLong2, 8L);
/*      */       case 'O':
/*      */       case 'o':
/*  364 */         return jjMoveStringLiteralDfa2_0(paramLong1, 432460463462096896L, paramLong2, 1024L);
/*      */       case 'P':
/*      */       case 'p':
/*  367 */         return jjMoveStringLiteralDfa2_0(paramLong1, 0L, paramLong2, 16L);
/*      */       case 'R':
/*      */       case 'r':
/*  370 */         if ((paramLong1 & 0x8000000000000L) != 0L) {
/*      */           
/*  372 */           this.jjmatchedKind = 51;
/*  373 */           this.jjmatchedPos = 1;
/*      */         } 
/*  375 */         return jjMoveStringLiteralDfa2_0(paramLong1, 13510800492724224L, paramLong2, 2052L);
/*      */       case 'S':
/*      */       case 's':
/*  378 */         if ((paramLong1 & 0x100L) != 0L) {
/*      */           
/*  380 */           this.jjmatchedKind = 8;
/*  381 */           this.jjmatchedPos = 1;
/*      */         }
/*  383 */         else if ((paramLong1 & 0x2000000000L) != 0L) {
/*  384 */           return jjStartNfaWithStates_0(1, 37, 48);
/*  385 */         }  return jjMoveStringLiteralDfa2_0(paramLong1, 512L, paramLong2, 0L);
/*      */       case 'T':
/*      */       case 't':
/*  388 */         return jjMoveStringLiteralDfa2_0(paramLong1, Long.MIN_VALUE, paramLong2, 0L);
/*      */       case 'U':
/*      */       case 'u':
/*  391 */         return jjMoveStringLiteralDfa2_0(paramLong1, 18436610974547968L, paramLong2, 1L);
/*      */       case 'V':
/*      */       case 'v':
/*  394 */         return jjMoveStringLiteralDfa2_0(paramLong1, 1024L, paramLong2, 0L);
/*      */       case 'X':
/*      */       case 'x':
/*  397 */         return jjMoveStringLiteralDfa2_0(paramLong1, 117440512L, paramLong2, 0L);
/*      */       case 'Y':
/*      */       case 'y':
/*  400 */         if ((paramLong1 & 0x4000L) != 0L)
/*  401 */           return jjStartNfaWithStates_0(1, 14, 48); 
/*      */         break;
/*      */       case '|':
/*  404 */         if ((paramLong2 & 0x40000000000L) != 0L) {
/*  405 */           return jjStopAtPos(1, 106);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  410 */     return jjStartNfa_0(0, paramLong1, paramLong2);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa2_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  414 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  415 */       return jjStartNfa_0(0, paramLong1, paramLong3);  try {
/*  416 */       this.curChar = this.input_stream.readChar();
/*  417 */     } catch (IOException iOException) {
/*  418 */       jjStopStringLiteralDfa_0(1, paramLong2, paramLong4);
/*  419 */       return 2;
/*      */     } 
/*  421 */     switch (this.curChar) {
/*      */       
/*      */       case 'A':
/*      */       case 'a':
/*  425 */         return jjMoveStringLiteralDfa3_0(paramLong2, -2197756618156769280L, paramLong4, 4L);
/*      */       case 'B':
/*      */       case 'b':
/*  428 */         return jjMoveStringLiteralDfa3_0(paramLong2, 0L, paramLong4, 2L);
/*      */       case 'C':
/*      */       case 'c':
/*  431 */         if ((paramLong2 & 0x200L) != 0L)
/*  432 */           return jjStartNfaWithStates_0(2, 9, 48); 
/*  433 */         return jjMoveStringLiteralDfa3_0(paramLong2, 549772591104L, paramLong4, 0L);
/*      */       case 'D':
/*      */       case 'd':
/*  436 */         if ((paramLong2 & 0x40L) != 0L)
/*  437 */           return jjStartNfaWithStates_0(2, 6, 48); 
/*  438 */         return jjMoveStringLiteralDfa3_0(paramLong2, 4512395720392704L, paramLong4, 16L);
/*      */       case 'E':
/*      */       case 'e':
/*  441 */         return jjMoveStringLiteralDfa3_0(paramLong2, 0L, paramLong4, 256L);
/*      */       case 'G':
/*      */       case 'g':
/*  444 */         if ((paramLong2 & 0x400L) != 0L)
/*  445 */           return jjStartNfaWithStates_0(2, 10, 48); 
/*      */         break;
/*      */       case 'I':
/*      */       case 'i':
/*  449 */         return jjMoveStringLiteralDfa3_0(paramLong2, 27021597864886272L, paramLong4, 2056L);
/*      */       case 'K':
/*      */       case 'k':
/*  452 */         return jjMoveStringLiteralDfa3_0(paramLong2, 274877906944L, paramLong4, 0L);
/*      */       case 'L':
/*      */       case 'l':
/*  455 */         if ((paramLong2 & 0x20L) != 0L)
/*  456 */           return jjStartNfaWithStates_0(2, 5, 48); 
/*  457 */         return jjMoveStringLiteralDfa3_0(paramLong2, 721842577776574464L, paramLong4, 32L);
/*      */       case 'M':
/*      */       case 'm':
/*  460 */         if ((paramLong4 & 0x1L) != 0L)
/*  461 */           return jjStartNfaWithStates_0(2, 64, 48); 
/*  462 */         return jjMoveStringLiteralDfa3_0(paramLong2, 281474976907264L, paramLong4, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  465 */         if ((paramLong2 & 0x20000000000L) != 0L) {
/*      */           
/*  467 */           this.jjmatchedKind = 41;
/*  468 */           this.jjmatchedPos = 2;
/*      */         } 
/*  470 */         return jjMoveStringLiteralDfa3_0(paramLong2, 4398046777344L, paramLong4, 0L);
/*      */       case 'O':
/*      */       case 'o':
/*  473 */         return jjMoveStringLiteralDfa3_0(paramLong2, 1744838656L, paramLong4, 0L);
/*      */       case 'R':
/*      */       case 'r':
/*  476 */         if ((paramLong2 & 0x10000000L) != 0L)
/*  477 */           return jjStartNfaWithStates_0(2, 28, 48); 
/*  478 */         return jjMoveStringLiteralDfa3_0(paramLong2, 0L, paramLong4, 1216L);
/*      */       case 'S':
/*      */       case 's':
/*  481 */         return jjMoveStringLiteralDfa3_0(paramLong2, 8602517504L, paramLong4, 0L);
/*      */       case 'T':
/*      */       case 't':
/*  484 */         if ((paramLong2 & 0x200000000000L) != 0L)
/*  485 */           return jjStartNfaWithStates_0(2, 45, 48); 
/*  486 */         if ((paramLong2 & 0x1000000000000000L) != 0L)
/*  487 */           return jjStartNfaWithStates_0(2, 60, 48); 
/*  488 */         return jjMoveStringLiteralDfa3_0(paramLong2, 17712446179328L, paramLong4, 512L);
/*      */       case 'U':
/*      */       case 'u':
/*  491 */         return jjMoveStringLiteralDfa3_0(paramLong2, 524288L, paramLong4, 0L);
/*      */       case 'V':
/*      */       case 'v':
/*  494 */         return jjMoveStringLiteralDfa3_0(paramLong2, 2147483648L, paramLong4, 0L);
/*      */       case 'W':
/*      */       case 'w':
/*  497 */         if ((paramLong2 & 0x400000000000000L) != 0L)
/*  498 */           return jjStartNfaWithStates_0(2, 58, 48); 
/*  499 */         return jjMoveStringLiteralDfa3_0(paramLong2, 70368744177664L, paramLong4, 0L);
/*      */       case 'X':
/*      */       case 'x':
/*  502 */         if ((paramLong2 & 0x10000000000L) != 0L)
/*  503 */           return jjStartNfaWithStates_0(2, 40, 48); 
/*      */         break;
/*      */       case 'Y':
/*      */       case 'y':
/*  507 */         if ((paramLong2 & 0x80L) != 0L) {
/*  508 */           return jjStartNfaWithStates_0(2, 7, 48);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  513 */     return jjStartNfa_0(1, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa3_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  517 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  518 */       return jjStartNfa_0(1, paramLong1, paramLong3);  try {
/*  519 */       this.curChar = this.input_stream.readChar();
/*  520 */     } catch (IOException iOException) {
/*  521 */       jjStopStringLiteralDfa_0(2, paramLong2, paramLong4);
/*  522 */       return 3;
/*      */     } 
/*  524 */     switch (this.curChar) {
/*      */       
/*      */       case 'A':
/*      */       case 'a':
/*  528 */         return jjMoveStringLiteralDfa4_0(paramLong2, 70368878399488L, paramLong4, 16L);
/*      */       case 'B':
/*      */       case 'b':
/*  531 */         return jjMoveStringLiteralDfa4_0(paramLong2, 281474976710656L, paramLong4, 0L);
/*      */       case 'C':
/*      */       case 'c':
/*  534 */         if ((paramLong2 & 0x400000L) != 0L)
/*  535 */           return jjStartNfaWithStates_0(3, 22, 48); 
/*  536 */         return jjMoveStringLiteralDfa4_0(paramLong2, 0L, paramLong4, 192L);
/*      */       case 'D':
/*      */       case 'd':
/*  539 */         if ((paramLong2 & 0x80000000000000L) != 0L)
/*  540 */           return jjStartNfaWithStates_0(3, 55, 48); 
/*      */         break;
/*      */       case 'E':
/*      */       case 'e':
/*  544 */         if ((paramLong2 & 0x100000L) != 0L)
/*  545 */           return jjStartNfaWithStates_0(3, 20, 48); 
/*  546 */         if ((paramLong2 & 0x4000000000L) != 0L)
/*  547 */           return jjStartNfaWithStates_0(3, 38, 48); 
/*  548 */         if ((paramLong2 & 0x80000000000L) != 0L)
/*  549 */           return jjStartNfaWithStates_0(3, 43, 48); 
/*  550 */         return jjMoveStringLiteralDfa4_0(paramLong2, 580964412062433280L, paramLong4, 0L);
/*      */       case 'H':
/*      */       case 'h':
/*  553 */         if ((paramLong4 & 0x200L) != 0L)
/*  554 */           return jjStartNfaWithStates_0(3, 73, 48); 
/*      */         break;
/*      */       case 'I':
/*      */       case 'i':
/*  558 */         return jjMoveStringLiteralDfa4_0(paramLong2, 2147483648L, paramLong4, 0L);
/*      */       case 'K':
/*      */       case 'k':
/*  561 */         if ((paramLong2 & 0x8000000000L) != 0L)
/*  562 */           return jjStartNfaWithStates_0(3, 39, 48); 
/*  563 */         if ((paramLong4 & 0x400L) != 0L)
/*  564 */           return jjStartNfaWithStates_0(3, 74, 48); 
/*      */         break;
/*      */       case 'L':
/*      */       case 'l':
/*  568 */         if ((paramLong2 & 0x800000000000L) != 0L)
/*  569 */           return jjStartNfaWithStates_0(3, 47, 48); 
/*  570 */         if ((paramLong2 & 0x100000000000000L) != 0L)
/*  571 */           return jjStartNfaWithStates_0(3, 56, 48); 
/*  572 */         return jjMoveStringLiteralDfa4_0(paramLong2, 4755801206520029184L, paramLong4, 2L);
/*      */       case 'M':
/*      */       case 'm':
/*  575 */         if ((paramLong2 & 0x20000000L) != 0L)
/*  576 */           return jjStartNfaWithStates_0(3, 29, 48); 
/*  577 */         return jjMoveStringLiteralDfa4_0(paramLong2, 196608L, paramLong4, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  580 */         return jjMoveStringLiteralDfa4_0(paramLong2, 786432L, paramLong4, 4L);
/*      */       case 'O':
/*      */       case 'o':
/*  583 */         if ((paramLong2 & 0x1000000000L) != 0L)
/*  584 */           return jjStartNfaWithStates_0(3, 36, 48); 
/*  585 */         return jjMoveStringLiteralDfa4_0(paramLong2, 9007199254740992L, paramLong4, 8L);
/*      */       case 'R':
/*      */       case 'r':
/*  588 */         if ((paramLong2 & 0x8000L) != 0L)
/*  589 */           return jjStartNfaWithStates_0(3, 15, 48); 
/*  590 */         return jjMoveStringLiteralDfa4_0(paramLong2, -6917529027641081856L, paramLong4, 256L);
/*      */       case 'S':
/*      */       case 's':
/*  593 */         return jjMoveStringLiteralDfa4_0(paramLong2, 33554432L, paramLong4, 0L);
/*      */       case 'T':
/*      */       case 't':
/*  596 */         if ((paramLong2 & 0x4000000L) != 0L)
/*  597 */           return jjStartNfaWithStates_0(3, 26, 48); 
/*  598 */         if ((paramLong2 & 0x40000000000000L) != 0L)
/*  599 */           return jjStartNfaWithStates_0(3, 54, 48); 
/*  600 */         return jjMoveStringLiteralDfa4_0(paramLong2, 8388608L, paramLong4, 2048L);
/*      */       case 'U':
/*      */       case 'u':
/*  603 */         return jjMoveStringLiteralDfa4_0(paramLong2, 21991306297344L, paramLong4, 32L);
/*      */       case 'W':
/*      */       case 'w':
/*  606 */         return jjMoveStringLiteralDfa4_0(paramLong2, 2048L, paramLong4, 0L);
/*      */       case 'Y':
/*      */       case 'y':
/*  609 */         if ((paramLong2 & 0x4000000000000L) != 0L) {
/*  610 */           return jjStartNfaWithStates_0(3, 50, 48);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  615 */     return jjStartNfa_0(2, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa4_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  619 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  620 */       return jjStartNfa_0(2, paramLong1, paramLong3);  try {
/*  621 */       this.curChar = this.input_stream.readChar();
/*  622 */     } catch (IOException iOException) {
/*  623 */       jjStopStringLiteralDfa_0(3, paramLong2, paramLong4);
/*  624 */       return 4;
/*      */     } 
/*  626 */     switch (this.curChar) {
/*      */       
/*      */       case 'B':
/*      */       case 'b':
/*  630 */         return jjMoveStringLiteralDfa5_0(paramLong2, 144115188075855872L, paramLong4, 0L);
/*      */       case 'C':
/*      */       case 'c':
/*  633 */         return jjMoveStringLiteralDfa5_0(paramLong2, 576460752303423488L, paramLong4, 0L);
/*      */       case 'E':
/*      */       case 'e':
/*  636 */         if ((paramLong2 & 0x2000000000000000L) != 0L)
/*  637 */           return jjStartNfaWithStates_0(4, 61, 48); 
/*  638 */         if ((paramLong4 & 0x2L) != 0L)
/*  639 */           return jjStartNfaWithStates_0(4, 65, 48); 
/*  640 */         if ((paramLong4 & 0x100L) != 0L)
/*  641 */           return jjStartNfaWithStates_0(4, 72, 48); 
/*  642 */         if ((paramLong4 & 0x800L) != 0L)
/*  643 */           return jjStartNfaWithStates_0(4, 75, 48); 
/*  644 */         return jjMoveStringLiteralDfa5_0(paramLong2, 281474977048576L, paramLong4, 32L);
/*      */       case 'G':
/*      */       case 'g':
/*  647 */         return jjMoveStringLiteralDfa5_0(paramLong2, 17179869184L, paramLong4, 0L);
/*      */       case 'H':
/*      */       case 'h':
/*  650 */         return jjMoveStringLiteralDfa5_0(paramLong2, 0L, paramLong4, 192L);
/*      */       case 'I':
/*      */       case 'i':
/*  653 */         return jjMoveStringLiteralDfa5_0(paramLong2, 70368752697344L, paramLong4, 0L);
/*      */       case 'L':
/*      */       case 'l':
/*  656 */         return jjMoveStringLiteralDfa5_0(paramLong2, 4611686018427387904L, paramLong4, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  659 */         if ((paramLong4 & 0x8L) != 0L)
/*  660 */           return jjStartNfaWithStates_0(4, 67, 48); 
/*  661 */         return jjMoveStringLiteralDfa5_0(paramLong2, 2147483648L, paramLong4, 0L);
/*      */       case 'P':
/*      */       case 'p':
/*  664 */         if ((paramLong2 & 0x40000000L) != 0L)
/*  665 */           return jjStartNfaWithStates_0(4, 30, 48); 
/*      */         break;
/*      */       case 'R':
/*      */       case 'r':
/*  669 */         if ((paramLong2 & 0x10000000000000L) != 0L)
/*  670 */           return jjStartNfaWithStates_0(4, 52, 48); 
/*  671 */         if ((paramLong2 & 0x20000000000000L) != 0L)
/*  672 */           return jjStartNfaWithStates_0(4, 53, 48); 
/*  673 */         return jjMoveStringLiteralDfa5_0(paramLong2, 17635135721472L, paramLong4, 0L);
/*      */       case 'S':
/*      */       case 's':
/*  676 */         if ((paramLong2 & 0x40000000000L) != 0L)
/*  677 */           return jjStartNfaWithStates_0(4, 42, 48); 
/*  678 */         return jjMoveStringLiteralDfa5_0(paramLong2, 0L, paramLong4, 4L);
/*      */       case 'T':
/*      */       case 't':
/*  681 */         if ((paramLong2 & 0x80000L) != 0L)
/*  682 */           return jjStartNfaWithStates_0(4, 19, 48); 
/*  683 */         if ((paramLong2 & 0x8000000L) != 0L)
/*  684 */           return jjStartNfaWithStates_0(4, 27, 48); 
/*  685 */         if ((paramLong2 & Long.MIN_VALUE) != 0L)
/*  686 */           return jjStartNfaWithStates_0(4, 63, 48); 
/*  687 */         return jjMoveStringLiteralDfa5_0(paramLong2, 35651584L, paramLong4, 16L);
/*      */       case 'U':
/*      */       case 'u':
/*  690 */         return jjMoveStringLiteralDfa5_0(paramLong2, 16777216L, paramLong4, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  694 */     return jjStartNfa_0(3, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa5_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  698 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  699 */       return jjStartNfa_0(3, paramLong1, paramLong3);  try {
/*  700 */       this.curChar = this.input_stream.readChar();
/*  701 */     } catch (IOException iOException) {
/*  702 */       jjStopStringLiteralDfa_0(4, paramLong2, paramLong4);
/*  703 */       return 5;
/*      */     } 
/*  705 */     switch (this.curChar) {
/*      */       
/*      */       case 'A':
/*      */       case 'a':
/*  709 */         return jjMoveStringLiteralDfa6_0(paramLong2, 144132780261908480L, paramLong4, 196L);
/*      */       case 'C':
/*      */       case 'c':
/*  712 */         return jjMoveStringLiteralDfa6_0(paramLong2, 262144L, paramLong4, 0L);
/*      */       case 'E':
/*      */       case 'e':
/*  715 */         if ((paramLong2 & 0x200000L) != 0L)
/*  716 */           return jjStartNfaWithStates_0(5, 21, 48); 
/*  717 */         if ((paramLong4 & 0x10L) != 0L)
/*  718 */           return jjStartNfaWithStates_0(5, 68, 48); 
/*  719 */         return jjMoveStringLiteralDfa6_0(paramLong2, 17179871232L, paramLong4, 0L);
/*      */       case 'G':
/*      */       case 'g':
/*  722 */         if ((paramLong2 & 0x80000000L) != 0L)
/*  723 */           return jjStartNfaWithStates_0(5, 31, 48); 
/*      */         break;
/*      */       case 'I':
/*      */       case 'i':
/*  727 */         return jjMoveStringLiteralDfa6_0(paramLong2, 4611686018427387904L, paramLong4, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  730 */         return jjMoveStringLiteralDfa6_0(paramLong2, 8454144L, paramLong4, 0L);
/*      */       case 'R':
/*      */       case 'r':
/*  733 */         if ((paramLong2 & 0x1000000000000L) != 0L)
/*  734 */           return jjStartNfaWithStates_0(5, 48, 48); 
/*      */         break;
/*      */       case 'S':
/*      */       case 's':
/*  738 */         if ((paramLong2 & 0x2000000L) != 0L)
/*  739 */           return jjStartNfaWithStates_0(5, 25, 48); 
/*  740 */         if ((paramLong4 & 0x20L) != 0L)
/*  741 */           return jjStartNfaWithStates_0(5, 69, 48); 
/*  742 */         return jjMoveStringLiteralDfa6_0(paramLong2, 34376515584L, paramLong4, 0L);
/*      */       case 'T':
/*      */       case 't':
/*  745 */         if ((paramLong2 & 0x20000L) != 0L)
/*  746 */           return jjStartNfaWithStates_0(5, 17, 48); 
/*  747 */         if ((paramLong2 & 0x200000000L) != 0L)
/*  748 */           return jjStartNfaWithStates_0(5, 33, 48); 
/*  749 */         if ((paramLong2 & 0x400000000000L) != 0L)
/*  750 */           return jjStartNfaWithStates_0(5, 46, 48); 
/*  751 */         if ((paramLong2 & 0x800000000000000L) != 0L)
/*  752 */           return jjStartNfaWithStates_0(5, 59, 48); 
/*      */         break;
/*      */       case 'Y':
/*      */       case 'y':
/*  756 */         return jjMoveStringLiteralDfa6_0(paramLong2, 4096L, paramLong4, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  760 */     return jjStartNfa_0(4, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa6_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  764 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  765 */       return jjStartNfa_0(4, paramLong1, paramLong3);  try {
/*  766 */       this.curChar = this.input_stream.readChar();
/*  767 */     } catch (IOException iOException) {
/*  768 */       jjStopStringLiteralDfa_0(5, paramLong2, paramLong4);
/*  769 */       return 6;
/*      */     } 
/*  771 */     switch (this.curChar) {
/*      */       
/*      */       case '_':
/*  774 */         return jjMoveStringLiteralDfa7_0(paramLong2, 4096L, paramLong4, 0L);
/*      */       case 'C':
/*      */       case 'c':
/*  777 */         return jjMoveStringLiteralDfa7_0(paramLong2, 144115188084244480L, paramLong4, 4L);
/*      */       case 'E':
/*      */       case 'e':
/*  780 */         return jjMoveStringLiteralDfa7_0(paramLong2, 34359738368L, paramLong4, 0L);
/*      */       case 'I':
/*      */       case 'i':
/*  783 */         return jjMoveStringLiteralDfa7_0(paramLong2, 16777216L, paramLong4, 0L);
/*      */       case 'L':
/*      */       case 'l':
/*  786 */         if ((paramLong2 & 0x100000000000L) != 0L)
/*  787 */           return jjStartNfaWithStates_0(6, 44, 48); 
/*      */         break;
/*      */       case 'N':
/*      */       case 'n':
/*  791 */         if ((paramLong2 & 0x800L) != 0L)
/*  792 */           return jjStartNfaWithStates_0(6, 11, 48); 
/*  793 */         if ((paramLong2 & 0x2000L) != 0L)
/*  794 */           return jjStartNfaWithStates_0(6, 13, 48); 
/*  795 */         return jjMoveStringLiteralDfa7_0(paramLong2, 4611686018427387904L, paramLong4, 0L);
/*      */       case 'R':
/*      */       case 'r':
/*  798 */         if ((paramLong2 & 0x400000000L) != 0L)
/*  799 */           return jjStartNfaWithStates_0(6, 34, 48); 
/*  800 */         if ((paramLong4 & 0x80L) != 0L) {
/*      */           
/*  802 */           this.jjmatchedKind = 71;
/*  803 */           this.jjmatchedPos = 6;
/*      */         } 
/*  805 */         return jjMoveStringLiteralDfa7_0(paramLong2, 0L, paramLong4, 64L);
/*      */       case 'T':
/*      */       case 't':
/*  808 */         if ((paramLong2 & 0x10000L) != 0L)
/*  809 */           return jjStartNfaWithStates_0(6, 16, 48); 
/*  810 */         if ((paramLong2 & 0x40000L) != 0L) {
/*  811 */           return jjStartNfaWithStates_0(6, 18, 48);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  816 */     return jjStartNfa_0(5, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa7_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  820 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  821 */       return jjStartNfa_0(5, paramLong1, paramLong3);  try {
/*  822 */       this.curChar = this.input_stream.readChar();
/*  823 */     } catch (IOException iOException) {
/*  824 */       jjStopStringLiteralDfa_0(6, paramLong2, paramLong4);
/*  825 */       return 7;
/*      */     } 
/*  827 */     switch (this.curChar) {
/*      */       
/*      */       case '2':
/*  830 */         if ((paramLong4 & 0x40L) != 0L)
/*  831 */           return jjStartNfaWithStates_0(7, 70, 11); 
/*      */         break;
/*      */       case 'C':
/*      */       case 'c':
/*  835 */         return jjMoveStringLiteralDfa8_0(paramLong2, 34359738368L, paramLong4, 0L);
/*      */       case 'I':
/*      */       case 'i':
/*  838 */         return jjMoveStringLiteralDfa8_0(paramLong2, 4096L, paramLong4, 0L);
/*      */       case 'K':
/*      */       case 'k':
/*  841 */         if ((paramLong2 & 0x200000000000000L) != 0L)
/*  842 */           return jjStartNfaWithStates_0(7, 57, 48); 
/*      */         break;
/*      */       case 'T':
/*      */       case 't':
/*  846 */         if ((paramLong2 & 0x800000L) != 0L)
/*  847 */           return jjStartNfaWithStates_0(7, 23, 48); 
/*  848 */         if ((paramLong2 & 0x4000000000000000L) != 0L)
/*  849 */           return jjStartNfaWithStates_0(7, 62, 48); 
/*  850 */         return jjMoveStringLiteralDfa8_0(paramLong2, 0L, paramLong4, 4L);
/*      */       case 'V':
/*      */       case 'v':
/*  853 */         return jjMoveStringLiteralDfa8_0(paramLong2, 16777216L, paramLong4, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  857 */     return jjStartNfa_0(6, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa8_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  861 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  862 */       return jjStartNfa_0(6, paramLong1, paramLong3);  try {
/*  863 */       this.curChar = this.input_stream.readChar();
/*  864 */     } catch (IOException iOException) {
/*  865 */       jjStopStringLiteralDfa_0(7, paramLong2, paramLong4);
/*  866 */       return 8;
/*      */     } 
/*  868 */     switch (this.curChar) {
/*      */       
/*      */       case 'E':
/*      */       case 'e':
/*  872 */         if ((paramLong2 & 0x1000000L) != 0L)
/*  873 */           return jjStartNfaWithStates_0(8, 24, 48); 
/*      */         break;
/*      */       case 'I':
/*      */       case 'i':
/*  877 */         return jjMoveStringLiteralDfa9_0(paramLong2, 0L, paramLong4, 4L);
/*      */       case 'N':
/*      */       case 'n':
/*  880 */         return jjMoveStringLiteralDfa9_0(paramLong2, 4096L, paramLong4, 0L);
/*      */       case 'T':
/*      */       case 't':
/*  883 */         if ((paramLong2 & 0x800000000L) != 0L) {
/*  884 */           return jjStartNfaWithStates_0(8, 35, 48);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  889 */     return jjStartNfa_0(7, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa9_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  893 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  894 */       return jjStartNfa_0(7, paramLong1, paramLong3);  try {
/*  895 */       this.curChar = this.input_stream.readChar();
/*  896 */     } catch (IOException iOException) {
/*  897 */       jjStopStringLiteralDfa_0(8, paramLong2, paramLong4);
/*  898 */       return 9;
/*      */     } 
/*  900 */     switch (this.curChar) {
/*      */       
/*      */       case 'O':
/*      */       case 'o':
/*  904 */         return jjMoveStringLiteralDfa10_0(paramLong2, 0L, paramLong4, 4L);
/*      */       case 'T':
/*      */       case 't':
/*  907 */         return jjMoveStringLiteralDfa10_0(paramLong2, 4096L, paramLong4, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  911 */     return jjStartNfa_0(8, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa10_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  915 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  916 */       return jjStartNfa_0(8, paramLong1, paramLong3);  try {
/*  917 */       this.curChar = this.input_stream.readChar();
/*  918 */     } catch (IOException iOException) {
/*  919 */       jjStopStringLiteralDfa_0(9, paramLong2, paramLong4);
/*  920 */       return 10;
/*      */     } 
/*  922 */     switch (this.curChar) {
/*      */       
/*      */       case 'E':
/*      */       case 'e':
/*  926 */         return jjMoveStringLiteralDfa11_0(paramLong2, 4096L, paramLong4, 0L);
/*      */       case 'N':
/*      */       case 'n':
/*  929 */         if ((paramLong4 & 0x4L) != 0L) {
/*  930 */           return jjStartNfaWithStates_0(10, 66, 48);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  935 */     return jjStartNfa_0(9, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa11_0(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  939 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  940 */       return jjStartNfa_0(9, paramLong1, paramLong3);  try {
/*  941 */       this.curChar = this.input_stream.readChar();
/*  942 */     } catch (IOException iOException) {
/*  943 */       jjStopStringLiteralDfa_0(10, paramLong2, 0L);
/*  944 */       return 11;
/*      */     } 
/*  946 */     switch (this.curChar) {
/*      */       
/*      */       case 'G':
/*      */       case 'g':
/*  950 */         return jjMoveStringLiteralDfa12_0(paramLong2, 4096L);
/*      */     } 
/*      */ 
/*      */     
/*  954 */     return jjStartNfa_0(10, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa12_0(long paramLong1, long paramLong2) {
/*  958 */     if ((paramLong2 &= paramLong1) == 0L)
/*  959 */       return jjStartNfa_0(10, paramLong1, 0L);  try {
/*  960 */       this.curChar = this.input_stream.readChar();
/*  961 */     } catch (IOException iOException) {
/*  962 */       jjStopStringLiteralDfa_0(11, paramLong2, 0L);
/*  963 */       return 12;
/*      */     } 
/*  965 */     switch (this.curChar) {
/*      */       
/*      */       case 'E':
/*      */       case 'e':
/*  969 */         return jjMoveStringLiteralDfa13_0(paramLong2, 4096L);
/*      */     } 
/*      */ 
/*      */     
/*  973 */     return jjStartNfa_0(11, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int jjMoveStringLiteralDfa13_0(long paramLong1, long paramLong2) {
/*  977 */     if ((paramLong2 &= paramLong1) == 0L)
/*  978 */       return jjStartNfa_0(11, paramLong1, 0L);  try {
/*  979 */       this.curChar = this.input_stream.readChar();
/*  980 */     } catch (IOException iOException) {
/*  981 */       jjStopStringLiteralDfa_0(12, paramLong2, 0L);
/*  982 */       return 13;
/*      */     } 
/*  984 */     switch (this.curChar) {
/*      */       
/*      */       case 'R':
/*      */       case 'r':
/*  988 */         if ((paramLong2 & 0x1000L) != 0L) {
/*  989 */           return jjStartNfaWithStates_0(13, 12, 11);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  994 */     return jjStartNfa_0(12, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int jjStartNfaWithStates_0(int paramInt1, int paramInt2, int paramInt3) {
/*  998 */     this.jjmatchedKind = paramInt2;
/*  999 */     this.jjmatchedPos = paramInt1; 
/* 1000 */     try { this.curChar = this.input_stream.readChar(); }
/* 1001 */     catch (IOException iOException) { return paramInt1 + 1; }
/* 1002 */      return jjMoveNfa_0(paramInt3, paramInt1 + 1);
/*      */   }
/* 1004 */   static final long[] jjbitVec0 = new long[] { 0L, 0L, -1L, -1L };
/*      */ 
/*      */ 
/*      */   
/*      */   private int jjMoveNfa_0(int paramInt1, int paramInt2) {
/* 1009 */     int i = 0;
/* 1010 */     this.jjnewStateCnt = 47;
/* 1011 */     int j = 1;
/* 1012 */     this.jjstateSet[0] = paramInt1;
/* 1013 */     int k = Integer.MAX_VALUE;
/*      */     
/*      */     while (true) {
/* 1016 */       if (++this.jjround == Integer.MAX_VALUE)
/* 1017 */         ReInitRounds(); 
/* 1018 */       if (this.curChar < '@') {
/*      */         
/* 1020 */         long l = 1L << this.curChar;
/*      */         
/*      */         do {
/* 1023 */           switch (this.jjstateSet[--j]) {
/*      */             
/*      */             case 2:
/* 1026 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1028 */                 if (k > 76)
/* 1029 */                   k = 76; 
/* 1030 */                 jjCheckNAddStates(0, 6); break;
/*      */               } 
/* 1032 */               if (this.curChar == '.') {
/* 1033 */                 jjCheckNAddTwoStates(27, 37); break;
/* 1034 */               }  if (this.curChar == '"') {
/* 1035 */                 jjCheckNAddTwoStates(24, 25); break;
/* 1036 */               }  if (this.curChar == '\'') {
/* 1037 */                 jjCheckNAddTwoStates(19, 20); break;
/* 1038 */               }  if (this.curChar == ':') {
/* 1039 */                 this.jjstateSet[this.jjnewStateCnt++] = 13; break;
/* 1040 */               }  if (this.curChar == '/') {
/* 1041 */                 this.jjstateSet[this.jjnewStateCnt++] = 3; break;
/* 1042 */               }  if (this.curChar == '-')
/* 1043 */                 this.jjstateSet[this.jjnewStateCnt++] = 0; 
/*      */               break;
/*      */             case 11:
/*      */             case 48:
/* 1047 */               if ((0x3FF001000000000L & l) == 0L)
/*      */                 break; 
/* 1049 */               if (k > 82)
/* 1050 */                 k = 82; 
/* 1051 */               jjCheckNAdd(11);
/*      */               break;
/*      */             case 47:
/* 1054 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1056 */                 if (k > 76)
/* 1057 */                   k = 76; 
/* 1058 */                 jjCheckNAdd(37);
/*      */               } 
/* 1060 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1062 */                 if (k > 76)
/* 1063 */                   k = 76; 
/* 1064 */                 jjCheckNAddTwoStates(27, 28);
/*      */               } 
/*      */               break;
/*      */             case 0:
/* 1068 */               if (this.curChar != '-')
/*      */                 break; 
/* 1070 */               if (k > 80)
/* 1071 */                 k = 80; 
/* 1072 */               jjCheckNAdd(1);
/*      */               break;
/*      */             case 1:
/* 1075 */               if ((0xFFFFFFFFFFFFDBFFL & l) == 0L)
/*      */                 break; 
/* 1077 */               if (k > 80)
/* 1078 */                 k = 80; 
/* 1079 */               jjCheckNAdd(1);
/*      */               break;
/*      */             case 3:
/* 1082 */               if (this.curChar == '*')
/* 1083 */                 jjCheckNAddTwoStates(4, 5); 
/*      */               break;
/*      */             case 4:
/* 1086 */               if ((0xFFFFFBFFFFFFFFFFL & l) != 0L)
/* 1087 */                 jjCheckNAddTwoStates(4, 5); 
/*      */               break;
/*      */             case 5:
/* 1090 */               if (this.curChar == '*')
/* 1091 */                 jjCheckNAddStates(7, 9); 
/*      */               break;
/*      */             case 6:
/* 1094 */               if ((0xFFFF7BFFFFFFFFFFL & l) != 0L)
/* 1095 */                 jjCheckNAddTwoStates(7, 5); 
/*      */               break;
/*      */             case 7:
/* 1098 */               if ((0xFFFFFBFFFFFFFFFFL & l) != 0L)
/* 1099 */                 jjCheckNAddTwoStates(7, 5); 
/*      */               break;
/*      */             case 8:
/* 1102 */               if (this.curChar == '/' && k > 81)
/* 1103 */                 k = 81; 
/*      */               break;
/*      */             case 9:
/* 1106 */               if (this.curChar == '/')
/* 1107 */                 this.jjstateSet[this.jjnewStateCnt++] = 3; 
/*      */               break;
/*      */             case 12:
/* 1110 */               if (this.curChar == ':')
/* 1111 */                 this.jjstateSet[this.jjnewStateCnt++] = 13; 
/*      */               break;
/*      */             case 14:
/* 1114 */               if ((0x3FF001000000000L & l) == 0L)
/*      */                 break; 
/* 1116 */               if (k > 85)
/* 1117 */                 k = 85; 
/* 1118 */               jjAddStates(10, 11);
/*      */               break;
/*      */             case 15:
/* 1121 */               if (this.curChar == '.')
/* 1122 */                 this.jjstateSet[this.jjnewStateCnt++] = 16; 
/*      */               break;
/*      */             case 17:
/* 1125 */               if ((0x3FF001000000000L & l) == 0L)
/*      */                 break; 
/* 1127 */               if (k > 85)
/* 1128 */                 k = 85; 
/* 1129 */               this.jjstateSet[this.jjnewStateCnt++] = 17;
/*      */               break;
/*      */             case 18:
/* 1132 */               if (this.curChar == '\'')
/* 1133 */                 jjCheckNAddTwoStates(19, 20); 
/*      */               break;
/*      */             case 19:
/* 1136 */               if ((0xFFFFFF7FFFFFFFFFL & l) != 0L)
/* 1137 */                 jjCheckNAddTwoStates(19, 20); 
/*      */               break;
/*      */             case 20:
/* 1140 */               if (this.curChar != '\'')
/*      */                 break; 
/* 1142 */               if (k > 86)
/* 1143 */                 k = 86; 
/* 1144 */               this.jjstateSet[this.jjnewStateCnt++] = 21;
/*      */               break;
/*      */             case 21:
/* 1147 */               if (this.curChar == '\'')
/* 1148 */                 jjCheckNAddTwoStates(22, 20); 
/*      */               break;
/*      */             case 22:
/* 1151 */               if ((0xFFFFFF7FFFFFFFFFL & l) != 0L)
/* 1152 */                 jjCheckNAddTwoStates(22, 20); 
/*      */               break;
/*      */             case 23:
/* 1155 */               if (this.curChar == '"')
/* 1156 */                 jjCheckNAddTwoStates(24, 25); 
/*      */               break;
/*      */             case 24:
/* 1159 */               if ((0xFFFFFFFBFFFFDBFFL & l) != 0L)
/* 1160 */                 jjCheckNAddTwoStates(24, 25); 
/*      */               break;
/*      */             case 25:
/* 1163 */               if (this.curChar == '"' && k > 87)
/* 1164 */                 k = 87; 
/*      */               break;
/*      */             case 26:
/* 1167 */               if (this.curChar == '.')
/* 1168 */                 jjCheckNAddTwoStates(27, 37); 
/*      */               break;
/*      */             case 27:
/* 1171 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1173 */               if (k > 76)
/* 1174 */                 k = 76; 
/* 1175 */               jjCheckNAddTwoStates(27, 28);
/*      */               break;
/*      */             case 29:
/* 1178 */               if ((0x280000000000L & l) != 0L)
/* 1179 */                 jjAddStates(12, 13); 
/*      */               break;
/*      */             case 30:
/* 1182 */               if (this.curChar == '.')
/* 1183 */                 jjCheckNAdd(31); 
/*      */               break;
/*      */             case 31:
/* 1186 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1188 */               if (k > 76)
/* 1189 */                 k = 76; 
/* 1190 */               jjCheckNAdd(31);
/*      */               break;
/*      */             case 32:
/* 1193 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1195 */               if (k > 76)
/* 1196 */                 k = 76; 
/* 1197 */               jjCheckNAddStates(14, 16);
/*      */               break;
/*      */             case 33:
/* 1200 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1202 */               if (k > 76)
/* 1203 */                 k = 76; 
/* 1204 */               jjCheckNAdd(33);
/*      */               break;
/*      */             case 34:
/* 1207 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1209 */               if (k > 76)
/* 1210 */                 k = 76; 
/* 1211 */               jjCheckNAddTwoStates(34, 35);
/*      */               break;
/*      */             case 35:
/* 1214 */               if (this.curChar == '.')
/* 1215 */                 jjCheckNAdd(36); 
/*      */               break;
/*      */             case 36:
/* 1218 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1220 */               if (k > 76)
/* 1221 */                 k = 76; 
/* 1222 */               jjCheckNAdd(36);
/*      */               break;
/*      */             case 37:
/* 1225 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1227 */               if (k > 76)
/* 1228 */                 k = 76; 
/* 1229 */               jjCheckNAdd(37);
/*      */               break;
/*      */             case 38:
/* 1232 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1234 */               if (k > 76)
/* 1235 */                 k = 76; 
/* 1236 */               jjCheckNAddStates(0, 6);
/*      */               break;
/*      */             case 39:
/* 1239 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1241 */               if (k > 76)
/* 1242 */                 k = 76; 
/* 1243 */               jjCheckNAddTwoStates(39, 28);
/*      */               break;
/*      */             case 40:
/* 1246 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1248 */               if (k > 76)
/* 1249 */                 k = 76; 
/* 1250 */               jjCheckNAddStates(17, 19);
/*      */               break;
/*      */             case 41:
/* 1253 */               if (this.curChar == '.')
/* 1254 */                 jjCheckNAdd(42); 
/*      */               break;
/*      */             case 42:
/* 1257 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1259 */               if (k > 76)
/* 1260 */                 k = 76; 
/* 1261 */               jjCheckNAddTwoStates(42, 28);
/*      */               break;
/*      */             case 43:
/* 1264 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1266 */               if (k > 76)
/* 1267 */                 k = 76; 
/* 1268 */               jjCheckNAddTwoStates(43, 44);
/*      */               break;
/*      */             case 44:
/* 1271 */               if (this.curChar == '.')
/* 1272 */                 jjCheckNAdd(45); 
/*      */               break;
/*      */             case 45:
/* 1275 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1277 */               if (k > 76)
/* 1278 */                 k = 76; 
/* 1279 */               jjCheckNAdd(45);
/*      */               break;
/*      */             case 46:
/* 1282 */               if ((0x3FF000000000000L & l) == 0L)
/*      */                 break; 
/* 1284 */               if (k > 76)
/* 1285 */                 k = 76; 
/* 1286 */               jjCheckNAdd(46);
/*      */               break;
/*      */           } 
/*      */         
/* 1290 */         } while (j != i);
/*      */       }
/* 1292 */       else if (this.curChar < '') {
/*      */         
/* 1294 */         long l = 1L << (this.curChar & 0x3F);
/*      */         
/*      */         do {
/* 1297 */           switch (this.jjstateSet[--j]) {
/*      */             
/*      */             case 2:
/*      */             case 10:
/* 1301 */               if ((0x7FFFFFE07FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1303 */               if (k > 82)
/* 1304 */                 k = 82; 
/* 1305 */               jjCheckNAddTwoStates(10, 11);
/*      */               break;
/*      */             case 48:
/* 1308 */               if ((0x7FFFFFE87FFFFFEL & l) != 0L) {
/*      */                 
/* 1310 */                 if (k > 82)
/* 1311 */                   k = 82; 
/* 1312 */                 jjCheckNAdd(11);
/*      */               } 
/* 1314 */               if ((0x7FFFFFE07FFFFFEL & l) != 0L) {
/*      */                 
/* 1316 */                 if (k > 82)
/* 1317 */                   k = 82; 
/* 1318 */                 jjCheckNAddTwoStates(10, 11);
/*      */               } 
/*      */               break;
/*      */             case 1:
/* 1322 */               if (k > 80)
/* 1323 */                 k = 80; 
/* 1324 */               this.jjstateSet[this.jjnewStateCnt++] = 1;
/*      */               break;
/*      */             case 4:
/* 1327 */               jjCheckNAddTwoStates(4, 5);
/*      */               break;
/*      */             case 6:
/*      */             case 7:
/* 1331 */               jjCheckNAddTwoStates(7, 5);
/*      */               break;
/*      */             case 11:
/* 1334 */               if ((0x7FFFFFE87FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1336 */               if (k > 82)
/* 1337 */                 k = 82; 
/* 1338 */               jjCheckNAdd(11);
/*      */               break;
/*      */             case 13:
/* 1341 */               if ((0x7FFFFFE07FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1343 */               if (k > 85)
/* 1344 */                 k = 85; 
/* 1345 */               jjCheckNAddStates(20, 22);
/*      */               break;
/*      */             case 14:
/* 1348 */               if ((0x7FFFFFE87FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1350 */               if (k > 85)
/* 1351 */                 k = 85; 
/* 1352 */               jjCheckNAddTwoStates(14, 15);
/*      */               break;
/*      */             case 16:
/* 1355 */               if ((0x7FFFFFE07FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1357 */               if (k > 85)
/* 1358 */                 k = 85; 
/* 1359 */               jjCheckNAddTwoStates(16, 17);
/*      */               break;
/*      */             case 17:
/* 1362 */               if ((0x7FFFFFE87FFFFFEL & l) == 0L)
/*      */                 break; 
/* 1364 */               if (k > 85)
/* 1365 */                 k = 85; 
/* 1366 */               jjCheckNAdd(17);
/*      */               break;
/*      */             case 19:
/* 1369 */               jjCheckNAddTwoStates(19, 20);
/*      */               break;
/*      */             case 22:
/* 1372 */               jjCheckNAddTwoStates(22, 20);
/*      */               break;
/*      */             case 24:
/* 1375 */               jjAddStates(23, 24);
/*      */               break;
/*      */             case 28:
/* 1378 */               if ((0x2000000020L & l) != 0L) {
/* 1379 */                 jjAddStates(25, 27);
/*      */               }
/*      */               break;
/*      */           } 
/* 1383 */         } while (j != i);
/*      */       }
/*      */       else {
/*      */         
/* 1387 */         int m = (this.curChar & 0xFF) >> 6;
/* 1388 */         long l = 1L << (this.curChar & 0x3F);
/*      */         
/*      */         do {
/* 1391 */           switch (this.jjstateSet[--j]) {
/*      */             
/*      */             case 1:
/* 1394 */               if ((jjbitVec0[m] & l) == 0L)
/*      */                 break; 
/* 1396 */               if (k > 80)
/* 1397 */                 k = 80; 
/* 1398 */               this.jjstateSet[this.jjnewStateCnt++] = 1;
/*      */               break;
/*      */             case 4:
/* 1401 */               if ((jjbitVec0[m] & l) != 0L)
/* 1402 */                 jjCheckNAddTwoStates(4, 5); 
/*      */               break;
/*      */             case 6:
/*      */             case 7:
/* 1406 */               if ((jjbitVec0[m] & l) != 0L)
/* 1407 */                 jjCheckNAddTwoStates(7, 5); 
/*      */               break;
/*      */             case 19:
/* 1410 */               if ((jjbitVec0[m] & l) != 0L)
/* 1411 */                 jjCheckNAddTwoStates(19, 20); 
/*      */               break;
/*      */             case 22:
/* 1414 */               if ((jjbitVec0[m] & l) != 0L)
/* 1415 */                 jjCheckNAddTwoStates(22, 20); 
/*      */               break;
/*      */             case 24:
/* 1418 */               if ((jjbitVec0[m] & l) != 0L) {
/* 1419 */                 jjAddStates(23, 24);
/*      */               }
/*      */               break;
/*      */           } 
/* 1423 */         } while (j != i);
/*      */       } 
/* 1425 */       if (k != Integer.MAX_VALUE) {
/*      */         
/* 1427 */         this.jjmatchedKind = k;
/* 1428 */         this.jjmatchedPos = paramInt2;
/* 1429 */         k = Integer.MAX_VALUE;
/*      */       } 
/* 1431 */       paramInt2++;
/* 1432 */       if ((j = this.jjnewStateCnt) == (i = 47 - (this.jjnewStateCnt = i)))
/* 1433 */         return paramInt2;  
/* 1434 */       try { this.curChar = this.input_stream.readChar(); }
/* 1435 */       catch (IOException iOException) { return paramInt2; }
/*      */     
/*      */     } 
/* 1438 */   } static final int[] jjnextStates = new int[] { 39, 40, 41, 28, 43, 44, 46, 5, 6, 8, 14, 15, 30, 32, 33, 34, 35, 40, 41, 28, 13, 14, 15, 24, 25, 29, 30, 32 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1444 */   public static final String[] jjstrLiteralImages = new String[] { "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "(", ",", ")", ";", "=", ".", "!=", "#", "<>", ">", ">=", "<", "<=", "+", "-", "*", ".*", "?", "||", "/", "**" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1456 */   public static final String[] lexStateNames = new String[] { "DEFAULT" };
/*      */ 
/*      */   
/* 1459 */   static final long[] jjtoToken = new long[] { -31L, 35184370262015L };
/*      */ 
/*      */   
/* 1462 */   static final long[] jjtoSkip = new long[] { 30L, 196608L };
/*      */ 
/*      */   
/* 1465 */   static final long[] jjtoSpecial = new long[] { 0L, 196608L };
/*      */   
/*      */   protected SimpleCharStream input_stream;
/*      */   
/* 1469 */   private final int[] jjrounds = new int[47];
/* 1470 */   private final int[] jjstateSet = new int[94];
/*      */   
/*      */   protected char curChar;
/*      */   int curLexState;
/*      */   int defaultLexState;
/*      */   int jjnewStateCnt;
/*      */   int jjround;
/*      */   int jjmatchedPos;
/*      */   int jjmatchedKind;
/*      */   
/*      */   public ZqlJJParserTokenManager(SimpleCharStream paramSimpleCharStream, int paramInt) {
/* 1481 */     this(paramSimpleCharStream);
/* 1482 */     SwitchTo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void ReInit(SimpleCharStream paramSimpleCharStream) {
/* 1488 */     this.jjmatchedPos = this.jjnewStateCnt = 0;
/* 1489 */     this.curLexState = this.defaultLexState;
/* 1490 */     this.input_stream = paramSimpleCharStream;
/* 1491 */     ReInitRounds();
/*      */   }
/*      */ 
/*      */   
/*      */   private void ReInitRounds() {
/* 1496 */     this.jjround = -2147483647;
/* 1497 */     for (byte b = 47; b-- > 0;) {
/* 1498 */       this.jjrounds[b] = Integer.MIN_VALUE;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void ReInit(SimpleCharStream paramSimpleCharStream, int paramInt) {
/* 1504 */     ReInit(paramSimpleCharStream);
/* 1505 */     SwitchTo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void SwitchTo(int paramInt) {
/* 1511 */     if (paramInt >= 1 || paramInt < 0) {
/* 1512 */       throw new TokenMgrError("Error: Ignoring invalid lexical state : " + paramInt + ". State unchanged.", 2);
/*      */     }
/* 1514 */     this.curLexState = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Token jjFillToken() {
/* 1525 */     String str2 = jjstrLiteralImages[this.jjmatchedKind];
/* 1526 */     String str1 = (str2 == null) ? this.input_stream.GetImage() : str2;
/* 1527 */     int i = this.input_stream.getBeginLine();
/* 1528 */     int k = this.input_stream.getBeginColumn();
/* 1529 */     int j = this.input_stream.getEndLine();
/* 1530 */     int m = this.input_stream.getEndColumn();
/* 1531 */     Token token = Token.newToken(this.jjmatchedKind);
/* 1532 */     token.kind = this.jjmatchedKind;
/* 1533 */     token.image = str1;
/*      */     
/* 1535 */     token.beginLine = i;
/* 1536 */     token.endLine = j;
/* 1537 */     token.beginColumn = k;
/* 1538 */     token.endColumn = m;
/*      */     
/* 1540 */     return token;
/*      */   }
/*      */   public ZqlJJParserTokenManager(SimpleCharStream paramSimpleCharStream) {
/* 1543 */     this.curLexState = 0;
/* 1544 */     this.defaultLexState = 0;
/*      */     this.input_stream = paramSimpleCharStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Token getNextToken() {
/* 1553 */     Token token = null;
/*      */     
/* 1555 */     int i = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*      */       try {
/* 1562 */         this.curChar = this.input_stream.BeginToken();
/*      */       }
/* 1564 */       catch (IOException iOException) {
/*      */         
/* 1566 */         this.jjmatchedKind = 0;
/* 1567 */         Token token1 = jjFillToken();
/* 1568 */         token1.specialToken = token;
/* 1569 */         return token1;
/*      */       } 
/*      */       
/* 1572 */       try { this.input_stream.backup(0);
/* 1573 */         while (this.curChar <= ' ' && (0x100002600L & 1L << this.curChar) != 0L) {
/* 1574 */           this.curChar = this.input_stream.BeginToken();
/*      */         } }
/* 1576 */       catch (IOException iOException) { continue; }
/* 1577 */        this.jjmatchedKind = Integer.MAX_VALUE;
/* 1578 */       this.jjmatchedPos = 0;
/* 1579 */       i = jjMoveStringLiteralDfa0_0();
/* 1580 */       if (this.jjmatchedKind != Integer.MAX_VALUE) {
/*      */         
/* 1582 */         if (this.jjmatchedPos + 1 < i)
/* 1583 */           this.input_stream.backup(i - this.jjmatchedPos - 1); 
/* 1584 */         if ((jjtoToken[this.jjmatchedKind >> 6] & 1L << (this.jjmatchedKind & 0x3F)) != 0L) {
/*      */           
/* 1586 */           Token token1 = jjFillToken();
/* 1587 */           token1.specialToken = token;
/* 1588 */           return token1;
/*      */         } 
/*      */ 
/*      */         
/* 1592 */         if ((jjtoSpecial[this.jjmatchedKind >> 6] & 1L << (this.jjmatchedKind & 0x3F)) != 0L) {
/*      */           
/* 1594 */           Token token1 = jjFillToken();
/* 1595 */           if (token == null) {
/* 1596 */             token = token1;
/*      */             continue;
/*      */           } 
/* 1599 */           token1.specialToken = token;
/* 1600 */           token = token.next = token1;
/*      */         } 
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 1606 */     int j = this.input_stream.getEndLine();
/* 1607 */     int k = this.input_stream.getEndColumn();
/* 1608 */     String str = null;
/* 1609 */     boolean bool = false; try {
/* 1610 */       this.input_stream.readChar(); this.input_stream.backup(1);
/* 1611 */     } catch (IOException iOException) {
/* 1612 */       bool = true;
/* 1613 */       str = (i <= 1) ? "" : this.input_stream.GetImage();
/* 1614 */       if (this.curChar == '\n' || this.curChar == '\r') {
/* 1615 */         j++;
/* 1616 */         k = 0;
/*      */       } else {
/*      */         
/* 1619 */         k++;
/*      */       } 
/* 1621 */     }  if (!bool) {
/* 1622 */       this.input_stream.backup(1);
/* 1623 */       str = (i <= 1) ? "" : this.input_stream.GetImage();
/*      */     } 
/* 1625 */     throw new TokenMgrError(bool, this.curLexState, j, k, str, this.curChar, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jjCheckNAdd(int paramInt) {
/* 1631 */     if (this.jjrounds[paramInt] != this.jjround) {
/*      */       
/* 1633 */       this.jjstateSet[this.jjnewStateCnt++] = paramInt;
/* 1634 */       this.jjrounds[paramInt] = this.jjround;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jjAddStates(int paramInt1, int paramInt2) {
/*      */     do {
/* 1640 */       this.jjstateSet[this.jjnewStateCnt++] = jjnextStates[paramInt1];
/* 1641 */     } while (paramInt1++ != paramInt2);
/*      */   }
/*      */   
/*      */   private void jjCheckNAddTwoStates(int paramInt1, int paramInt2) {
/* 1645 */     jjCheckNAdd(paramInt1);
/* 1646 */     jjCheckNAdd(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jjCheckNAddStates(int paramInt1, int paramInt2) {
/*      */     do {
/* 1652 */       jjCheckNAdd(jjnextStates[paramInt1]);
/* 1653 */     } while (paramInt1++ != paramInt2);
/*      */   }
/*      */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZqlJJParserTokenManager.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */