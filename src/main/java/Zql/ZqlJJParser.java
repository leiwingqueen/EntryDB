/*      */ package Zql;
/*      */ public class ZqlJJParser implements ZqlJJParserConstants {
/*      */   public ZqlJJParserTokenManager token_source;
/*      */   SimpleCharStream jj_input_stream;
/*      */   public Token token;
/*      */   public Token jj_nt;
/*      */   private int jj_ntk;
/*      */   private Token jj_scanpos;
/*      */   private Token jj_lastpos;
/*      */   private int jj_la;
/*      */   private int jj_gen;
/*      */   
/*      */   public static void main(String[] paramArrayOfString) throws ParseException {
/*   14 */     ZqlJJParser zqlJJParser = null;
/*      */     
/*   16 */     if (paramArrayOfString.length < 1) {
/*   17 */       System.out.println("Reading from stdin (exit; to finish)");
/*   18 */       zqlJJParser = new ZqlJJParser(System.in);
/*      */     } else {
/*      */ 
/*      */       
/*      */       try {
/*   23 */         zqlJJParser = new ZqlJJParser(new DataInputStream(new FileInputStream(paramArrayOfString[0])));
/*      */       }
/*   25 */       catch (FileNotFoundException fileNotFoundException) {
/*   26 */         System.out.println("File " + paramArrayOfString[0] + " not found. Reading from stdin");
/*      */         
/*   28 */         zqlJJParser = new ZqlJJParser(System.in);
/*      */       } 
/*      */     } 
/*      */     
/*   32 */     if (paramArrayOfString.length > 0) {
/*   33 */       System.out.println(paramArrayOfString[0]);
/*      */     }
/*      */     
/*   36 */     ZStatement zStatement = null;
/*   37 */     while ((zStatement = zqlJJParser.SQLStatement()) != null) {
/*   38 */       System.out.println(zStatement.toString());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   49 */     System.out.println("Parse Successful");
/*      */   }
/*      */ 
/*      */   
/*      */   public final void BasicDataTypeDeclaration() throws ParseException {
/*   54 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 15:
/*      */       case 27:
/*      */       case 34:
/*      */       case 44:
/*      */       case 48:
/*      */       case 56:
/*      */       case 70:
/*      */       case 71:
/*   63 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 15:
/*   65 */             jj_consume_token(15);
/*      */             break;
/*      */           case 71:
/*   68 */             jj_consume_token(71);
/*      */             break;
/*      */           case 70:
/*   71 */             jj_consume_token(70);
/*      */             break;
/*      */           case 34:
/*   74 */             jj_consume_token(34);
/*      */             break;
/*      */           case 48:
/*   77 */             jj_consume_token(48);
/*      */             break;
/*      */           case 44:
/*   80 */             jj_consume_token(44);
/*      */             break;
/*      */           case 56:
/*   83 */             jj_consume_token(56);
/*      */             break;
/*      */           case 27:
/*   86 */             jj_consume_token(27);
/*      */             break;
/*      */           default:
/*   89 */             this.jj_la1[0] = this.jj_gen;
/*   90 */             jj_consume_token(-1);
/*   91 */             throw new ParseException();
/*      */         } 
/*   93 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 88:
/*   95 */             jj_consume_token(88);
/*   96 */             jj_consume_token(76);
/*   97 */             switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */               case 89:
/*   99 */                 jj_consume_token(89);
/*  100 */                 jj_consume_token(76);
/*      */                 break;
/*      */               default:
/*  103 */                 this.jj_la1[1] = this.jj_gen;
/*      */                 break;
/*      */             } 
/*  106 */             jj_consume_token(90);
/*      */             return;
/*      */         } 
/*  109 */         this.jj_la1[2] = this.jj_gen;
/*      */         return;
/*      */ 
/*      */       
/*      */       case 20:
/*  114 */         jj_consume_token(20);
/*      */         return;
/*      */       case 12:
/*  117 */         jj_consume_token(12);
/*      */         return;
/*      */       case 13:
/*  120 */         jj_consume_token(13);
/*      */         return;
/*      */     } 
/*  123 */     this.jj_la1[3] = this.jj_gen;
/*  124 */     jj_consume_token(-1);
/*  125 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Vector SQLStatements() throws ParseException
/*      */   {
/*  133 */     Vector vector = new Vector();
/*      */ 
/*      */     
/*      */     while (true) {
/*  137 */       ZStatement zStatement = SQLStatement();
/*  138 */       if (zStatement == null) return vector;  vector.addElement(zStatement);
/*  139 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 17:
/*      */         case 21:
/*      */         case 26:
/*      */         case 33:
/*      */         case 39:
/*      */         case 54:
/*      */         case 57:
/*      */         case 59:
/*      */         case 60:
/*      */         case 68:
/*      */           continue;
/*      */       }  break;
/*      */     } 
/*  153 */     this.jj_la1[4] = this.jj_gen;
/*      */ 
/*      */ 
/*      */     
/*  157 */     return vector; } public final ZStatement SQLStatement() throws ParseException { ZDelete zDelete;
/*      */     ZInsert zInsert;
/*      */     ZLockTable zLockTable;
/*      */     ZTransactStmt zTransactStmt2;
/*      */     ZQuery zQuery;
/*  162 */     ZTransactStmt zTransactStmt1, zTransactStmt3 = null;
/*  163 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 17:
/*  165 */         zTransactStmt3 = CommitStatement();
/*  166 */         return zTransactStmt3;
/*      */       
/*      */       case 21:
/*  169 */         return DeleteStatement();
/*      */ 
/*      */       
/*      */       case 33:
/*  173 */         return InsertStatement();
/*      */ 
/*      */       
/*      */       case 39:
/*  177 */         return LockTableStatement();
/*      */ 
/*      */       
/*      */       case 57:
/*  181 */         return RollbackStatement();
/*      */ 
/*      */       
/*      */       case 59:
/*  185 */         return QueryStatement();
/*      */ 
/*      */       
/*      */       case 60:
/*  189 */         return SetTransactionStatement();
/*      */ 
/*      */       
/*      */       case 68:
/*  193 */         return UpdateStatement();
/*      */ 
/*      */       
/*      */       case 26:
/*      */       case 54:
/*  198 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 26:
/*  200 */             jj_consume_token(26);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  210 */             jj_consume_token(91);
/*  211 */             return null;case 54: jj_consume_token(54); jj_consume_token(91); return null;
/*      */         }  this.jj_la1[5] = this.jj_gen; jj_consume_token(-1); throw new ParseException();
/*      */     } 
/*  214 */     this.jj_la1[6] = this.jj_gen;
/*  215 */     jj_consume_token(-1);
/*  216 */     throw new ParseException(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZTransactStmt CommitStatement() throws ParseException {
/*      */     Token token;
/*  224 */     ZTransactStmt zTransactStmt = new ZTransactStmt("COMMIT");
/*  225 */     jj_consume_token(17);
/*  226 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 74:
/*  228 */         jj_consume_token(74);
/*      */         break;
/*      */       default:
/*  231 */         this.jj_la1[7] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  234 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 16:
/*  236 */         jj_consume_token(16);
/*  237 */         token = jj_consume_token(86);
/*  238 */         zTransactStmt.setComment(token.toString());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  244 */         jj_consume_token(91);
/*  245 */         return zTransactStmt; }  this.jj_la1[8] = this.jj_gen; jj_consume_token(91); return zTransactStmt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZLockTable LockTableStatement() throws ParseException {
/*  252 */     ZLockTable zLockTable = new ZLockTable();
/*  253 */     Vector vector = new Vector();
/*      */     
/*  255 */     jj_consume_token(39);
/*  256 */     jj_consume_token(65);
/*  257 */     String str = TableReference();
/*  258 */     vector.addElement(str);
/*      */     
/*      */     while (true) {
/*  261 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 89:
/*      */           break;
/*      */         
/*      */         default:
/*  266 */           this.jj_la1[9] = this.jj_gen;
/*      */           break;
/*      */       } 
/*  269 */       jj_consume_token(89);
/*  270 */       str = TableReference();
/*  271 */       vector.addElement(str);
/*      */     } 
/*  273 */     jj_consume_token(32);
/*  274 */     str = LockMode();
/*  275 */     zLockTable.setLockMode(str);
/*  276 */     jj_consume_token(43);
/*  277 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 46:
/*  279 */         jj_consume_token(46);
/*  280 */         zLockTable.nowait_ = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  286 */         jj_consume_token(91);
/*  287 */         zLockTable.addTables(vector); return zLockTable; }  this.jj_la1[10] = this.jj_gen; jj_consume_token(91); zLockTable.addTables(vector); return zLockTable;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZTransactStmt RollbackStatement() throws ParseException {
/*      */     Token token;
/*  294 */     ZTransactStmt zTransactStmt = new ZTransactStmt("ROLLBACK");
/*  295 */     jj_consume_token(57);
/*  296 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 74:
/*  298 */         jj_consume_token(74);
/*      */         break;
/*      */       default:
/*  301 */         this.jj_la1[11] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  304 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 16:
/*  306 */         jj_consume_token(16);
/*  307 */         token = jj_consume_token(86);
/*  308 */         zTransactStmt.setComment(token.toString());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  314 */         jj_consume_token(91);
/*  315 */         return zTransactStmt; }  this.jj_la1[12] = this.jj_gen; jj_consume_token(91); return zTransactStmt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZTransactStmt SetTransactionStatement() throws ParseException {
/*  322 */     ZTransactStmt zTransactStmt = new ZTransactStmt("SET TRANSACTION");
/*  323 */     boolean bool = false;
/*  324 */     jj_consume_token(60);
/*  325 */     jj_consume_token(66);
/*  326 */     jj_consume_token(55);
/*  327 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 50:
/*  329 */         jj_consume_token(50);
/*  330 */         bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  340 */         jj_consume_token(91);
/*  341 */         zTransactStmt.readOnly_ = bool; return zTransactStmt;case 75: jj_consume_token(75); jj_consume_token(91); zTransactStmt.readOnly_ = bool; return zTransactStmt;
/*      */     } 
/*      */     this.jj_la1[13] = this.jj_gen;
/*      */     jj_consume_token(-1);
/*      */     throw new ParseException();
/*      */   }
/*      */   
/*      */   public final String LockMode() throws ParseException {
/*  349 */     StringBuffer stringBuffer = new StringBuffer();
/*  350 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 58:
/*  352 */         jj_consume_token(58);
/*  353 */         stringBuffer.append("ROW ");
/*  354 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 61:
/*  356 */             jj_consume_token(61);
/*  357 */             stringBuffer.append("SHARE");
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
/*  368 */             return stringBuffer.toString();case 24: jj_consume_token(24); stringBuffer.append("EXCLUSIVE"); return stringBuffer.toString();
/*      */         }  this.jj_la1[14] = this.jj_gen; jj_consume_token(-1); throw new ParseException();
/*      */       case 61:
/*  371 */         jj_consume_token(61);
/*  372 */         stringBuffer.append("SHARE");
/*  373 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */         { case 58:
/*      */           case 68:
/*  376 */             switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */             { case 68:
/*  378 */                 jj_consume_token(68);
/*  379 */                 stringBuffer.append(" UPDATE");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  396 */                 return stringBuffer.toString();case 58: jj_consume_token(58); jj_consume_token(24); stringBuffer.append(" ROW EXCLUSIVE"); return stringBuffer.toString(); }  this.jj_la1[15] = this.jj_gen; jj_consume_token(-1); throw new ParseException(); }  this.jj_la1[16] = this.jj_gen; return stringBuffer.toString();
/*      */       
/*      */       case 24:
/*  399 */         jj_consume_token(24);
/*  400 */         return new String("EXCLUSIVE");
/*      */     } 
/*      */     
/*  403 */     this.jj_la1[17] = this.jj_gen;
/*  404 */     jj_consume_token(-1);
/*  405 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZUpdate UpdateStatement() throws ParseException {
/*      */     ZExp zExp;
/*      */     Token token;
/*  418 */     jj_consume_token(68);
/*  419 */     String str = TableReference();
/*  420 */     ZUpdate zUpdate = new ZUpdate(str);
/*  421 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 82:
/*  423 */         token = jj_consume_token(82);
/*  424 */         zUpdate.setAlias(token.toString());
/*      */         break;
/*      */       default:
/*  427 */         this.jj_la1[18] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  430 */     jj_consume_token(60);
/*  431 */     ColumnValues(zUpdate);
/*      */     
/*  433 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 72:
/*  435 */         jj_consume_token(72);
/*  436 */         zExp = SQLExpression();
/*  437 */         zUpdate.addWhere(zExp);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  443 */         jj_consume_token(91);
/*  444 */         return zUpdate; }  this.jj_la1[19] = this.jj_gen; jj_consume_token(91); return zUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void ColumnValues(ZUpdate paramZUpdate) throws ParseException {
/*  452 */     String str = TableColumn();
/*  453 */     jj_consume_token(92);
/*  454 */     ZExp zExp = UpdatedValue();
/*  455 */     paramZUpdate.addColumnUpdate(str, zExp);
/*      */     
/*      */     while (true) {
/*  458 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 89:
/*      */           break;
/*      */         
/*      */         default:
/*  463 */           this.jj_la1[20] = this.jj_gen;
/*      */           break;
/*      */       } 
/*  466 */       jj_consume_token(89);
/*  467 */       str = TableColumn();
/*  468 */       jj_consume_token(92);
/*  469 */       zExp = UpdatedValue();
/*  470 */       paramZUpdate.addColumnUpdate(str, zExp);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp UpdatedValue() throws ParseException {
/*      */     ZExp zExp;
/*  478 */     if (jj_2_1(2147483647)) {
/*  479 */       jj_consume_token(88);
/*  480 */       ZQuery zQuery = SelectStatement();
/*  481 */       jj_consume_token(90);
/*  482 */       return zQuery;
/*      */     } 
/*  484 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 25:
/*      */       case 40:
/*      */       case 41:
/*      */       case 45:
/*      */       case 47:
/*      */       case 53:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/*  502 */         zExp = SQLExpression();
/*  503 */         return zExp;
/*      */       
/*      */       case 105:
/*  506 */         zExp = PreparedCol();
/*  507 */         return zExp;
/*      */     } 
/*      */     
/*  510 */     this.jj_la1[21] = this.jj_gen;
/*  511 */     jj_consume_token(-1);
/*  512 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZInsert InsertStatement() throws ParseException {
/*      */     Vector vector;
/*      */     ZQuery zQuery;
/*      */     ZExpression zExpression;
/*  527 */     jj_consume_token(33);
/*  528 */     jj_consume_token(36);
/*  529 */     String str = TableReference();
/*  530 */     ZInsert zInsert = new ZInsert(str);
/*  531 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 88:
/*  533 */         jj_consume_token(88);
/*  534 */         str = TableColumn();
/*  535 */         vector = new Vector(); vector.addElement(str);
/*      */         
/*      */         while (true) {
/*  538 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 89:
/*      */               break;
/*      */             
/*      */             default:
/*  543 */               this.jj_la1[22] = this.jj_gen;
/*      */               break;
/*      */           } 
/*  546 */           jj_consume_token(89);
/*  547 */           str = TableColumn();
/*  548 */           vector.addElement(str);
/*      */         } 
/*  550 */         jj_consume_token(90);
/*  551 */         zInsert.addColumns(vector);
/*      */         break;
/*      */       default:
/*  554 */         this.jj_la1[23] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  557 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 69:
/*  559 */         jj_consume_token(69);
/*  560 */         jj_consume_token(88);
/*  561 */         vector = SQLExpressionList();
/*  562 */         jj_consume_token(90);
/*  563 */         zExpression = new ZExpression(",");
/*  564 */         zExpression.setOperands(vector); zInsert.addValueSpec(zExpression);
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
/*  575 */         jj_consume_token(91);
/*  576 */         return zInsert;case 59: zQuery = SelectStatement(); zInsert.addValueSpec(zQuery); jj_consume_token(91); return zInsert;
/*      */     } 
/*      */     this.jj_la1[24] = this.jj_gen;
/*      */     jj_consume_token(-1);
/*      */     throw new ParseException();
/*      */   }
/*      */   
/*      */   public final ZDelete DeleteStatement() throws ParseException {
/*      */     ZExp zExp;
/*  585 */     jj_consume_token(21);
/*  586 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 29:
/*  588 */         jj_consume_token(29);
/*      */         break;
/*      */       default:
/*  591 */         this.jj_la1[25] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  594 */     String str = TableReference();
/*  595 */     ZDelete zDelete = new ZDelete(str);
/*  596 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 72:
/*  598 */         jj_consume_token(72);
/*  599 */         zExp = SQLExpression();
/*  600 */         zDelete.addWhere(zExp);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  606 */         jj_consume_token(91);
/*  607 */         return zDelete; }  this.jj_la1[26] = this.jj_gen; jj_consume_token(91); return zDelete;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZQuery QueryStatement() throws ParseException {
/*  614 */     ZQuery zQuery = SelectStatement();
/*  615 */     jj_consume_token(91);
/*  616 */     return zQuery;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String TableColumn() throws ParseException {
/*  622 */     StringBuffer stringBuffer = new StringBuffer();
/*      */ 
/*      */     
/*  625 */     String str = OracleObjectName();
/*  626 */     stringBuffer.append(str);
/*  627 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 93:
/*  629 */         jj_consume_token(93);
/*  630 */         str = OracleObjectName();
/*  631 */         stringBuffer.append("." + str);
/*  632 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */         { case 93:
/*  634 */             jj_consume_token(93);
/*  635 */             str = OracleObjectName();
/*  636 */             stringBuffer.append("." + str);
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
/*  647 */             return stringBuffer.toString(); }  this.jj_la1[27] = this.jj_gen; return stringBuffer.toString(); }  this.jj_la1[28] = this.jj_gen; return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public final String OracleObjectName() throws ParseException {
/*      */     Token token;
/*  653 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 82:
/*  655 */         token = jj_consume_token(82);
/*  656 */         return token.toString();
/*      */       
/*      */       case 87:
/*  659 */         token = jj_consume_token(87);
/*  660 */         return token.toString();
/*      */     } 
/*      */     
/*  663 */     this.jj_la1[29] = this.jj_gen;
/*  664 */     jj_consume_token(-1);
/*  665 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String Relop() throws ParseException {
/*      */     Token token;
/*  672 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 92:
/*  674 */         token = jj_consume_token(92);
/*  675 */         return token.toString();
/*      */       
/*      */       case 94:
/*  678 */         token = jj_consume_token(94);
/*  679 */         return token.toString();
/*      */       
/*      */       case 95:
/*  682 */         token = jj_consume_token(95);
/*  683 */         return token.toString();
/*      */       
/*      */       case 96:
/*  686 */         token = jj_consume_token(96);
/*  687 */         return token.toString();
/*      */       
/*      */       case 97:
/*  690 */         token = jj_consume_token(97);
/*  691 */         return token.toString();
/*      */       
/*      */       case 98:
/*  694 */         token = jj_consume_token(98);
/*  695 */         return token.toString();
/*      */       
/*      */       case 99:
/*  698 */         token = jj_consume_token(99);
/*  699 */         return token.toString();
/*      */       
/*      */       case 100:
/*  702 */         token = jj_consume_token(100);
/*  703 */         return token.toString();
/*      */     } 
/*      */     
/*  706 */     this.jj_la1[30] = this.jj_gen;
/*  707 */     jj_consume_token(-1);
/*  708 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String TableReference() throws ParseException {
/*  715 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/*  717 */     String str = OracleObjectName();
/*  718 */     stringBuffer.append(str);
/*  719 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 93:
/*  721 */         jj_consume_token(93);
/*  722 */         str = OracleObjectName();
/*  723 */         stringBuffer.append("." + str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  729 */         return stringBuffer.toString(); }  this.jj_la1[31] = this.jj_gen; return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void NumOrID() throws ParseException {
/*  734 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 82:
/*  736 */         jj_consume_token(82);
/*      */         return;
/*      */       case 76:
/*      */       case 101:
/*      */       case 102:
/*  741 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 101:
/*      */           case 102:
/*  744 */             switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */               case 101:
/*  746 */                 jj_consume_token(101);
/*      */                 break;
/*      */               case 102:
/*  749 */                 jj_consume_token(102);
/*      */                 break;
/*      */             } 
/*  752 */             this.jj_la1[32] = this.jj_gen;
/*  753 */             jj_consume_token(-1);
/*  754 */             throw new ParseException();
/*      */ 
/*      */           
/*      */           default:
/*  758 */             this.jj_la1[33] = this.jj_gen;
/*      */             break;
/*      */         } 
/*  761 */         jj_consume_token(76);
/*      */         return;
/*      */     } 
/*  764 */     this.jj_la1[34] = this.jj_gen;
/*  765 */     jj_consume_token(-1);
/*  766 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZQuery SelectStatement() throws ParseException {
/*      */     Vector vector;
/*  776 */     ZQuery zQuery = SelectWithoutOrder();
/*  777 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 52:
/*  779 */         vector = OrderByClause();
/*  780 */         zQuery.addOrderBy(vector);
/*      */         break;
/*      */       default:
/*  783 */         this.jj_la1[35] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  786 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 28:
/*  788 */         ForUpdateClause();
/*  789 */         zQuery.forupdate_ = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  795 */         return zQuery; }  this.jj_la1[36] = this.jj_gen; return zQuery;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZQuery SelectWithoutOrder() throws ParseException {
/*  800 */     ZQuery zQuery = new ZQuery();
/*      */ 
/*      */     
/*  803 */     ZExp zExp = null;
/*  804 */     ZGroupBy zGroupBy = null;
/*  805 */     ZExpression zExpression = null;
/*  806 */     jj_consume_token(59);
/*  807 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 5:
/*      */       case 23:
/*  810 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 5:
/*  812 */             jj_consume_token(5);
/*      */             break;
/*      */           case 23:
/*  815 */             jj_consume_token(23);
/*  816 */             zQuery.distinct_ = true;
/*      */             break;
/*      */         } 
/*  819 */         this.jj_la1[37] = this.jj_gen;
/*  820 */         jj_consume_token(-1);
/*  821 */         throw new ParseException();
/*      */ 
/*      */       
/*      */       default:
/*  825 */         this.jj_la1[38] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  828 */     Vector vector1 = SelectList();
/*  829 */     Vector vector2 = FromClause();
/*  830 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 72:
/*  832 */         zExp = WhereClause();
/*      */         break;
/*      */       default:
/*  835 */         this.jj_la1[39] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  838 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 18:
/*      */       case 63:
/*  841 */         ConnectClause();
/*      */         break;
/*      */       default:
/*  844 */         this.jj_la1[40] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  847 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 30:
/*  849 */         zGroupBy = GroupByClause();
/*      */         break;
/*      */       default:
/*  852 */         this.jj_la1[41] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  855 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 35:
/*      */       case 42:
/*      */       case 67:
/*  859 */         zExpression = SetClause();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  865 */         zQuery.addSelect(vector1);
/*  866 */         zQuery.addFrom(vector2);
/*  867 */         zQuery.addWhere(zExp);
/*  868 */         zQuery.addGroupBy(zGroupBy);
/*  869 */         zQuery.addSet(zExpression);
/*      */         
/*  871 */         return zQuery; }  this.jj_la1[42] = this.jj_gen; zQuery.addSelect(vector1); zQuery.addFrom(vector2); zQuery.addWhere(zExp); zQuery.addGroupBy(zGroupBy); zQuery.addSet(zExpression); return zQuery;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Vector SelectList() throws ParseException {
/*      */     ZSelectItem zSelectItem;
/*  881 */     Vector vector = new Vector(8);
/*      */     
/*  883 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 103:
/*  885 */         jj_consume_token(103);
/*  886 */         vector.addElement(new ZSelectItem("*")); return vector;
/*      */       
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 47:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/*  902 */         zSelectItem = SelectItem();
/*  903 */         vector.addElement(zSelectItem);
/*      */         
/*      */         while (true) {
/*  906 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 89:
/*      */               break;
/*      */             
/*      */             default:
/*  911 */               this.jj_la1[43] = this.jj_gen;
/*      */               break;
/*      */           } 
/*  914 */           jj_consume_token(89);
/*  915 */           zSelectItem = SelectItem();
/*  916 */           vector.addElement(zSelectItem);
/*      */         } 
/*  918 */         return vector;
/*      */     } 
/*      */     
/*  921 */     this.jj_la1[44] = this.jj_gen;
/*  922 */     jj_consume_token(-1);
/*  923 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZSelectItem SelectItem() throws ParseException {
/*      */     String str;
/*      */     ZSelectItem zSelectItem;
/*      */     ZExp zExp;
/*  937 */     if (jj_2_2(2147483647)) {
/*  938 */       String str1 = SelectStar();
/*  939 */       return new ZSelectItem(str1);
/*      */     } 
/*  941 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 47:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/*  956 */         zExp = SQLSimpleExpression();
/*      */         
/*  958 */         zSelectItem = new ZSelectItem(zExp.toString());
/*  959 */         zSelectItem.setExpression(zExp);
/*  960 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */         { case 8:
/*      */           case 82:
/*      */           case 87:
/*  964 */             str = SelectAlias();
/*  965 */             zSelectItem.setAlias(str);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  971 */             return zSelectItem; }  this.jj_la1[45] = this.jj_gen; return zSelectItem;
/*      */     } 
/*      */     
/*  974 */     this.jj_la1[46] = this.jj_gen;
/*  975 */     jj_consume_token(-1);
/*  976 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String SelectAlias() throws ParseException {
/*      */     Token token;
/*  985 */     StringBuffer stringBuffer = null;
/*  986 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 8:
/*  988 */         jj_consume_token(8);
/*      */         break;
/*      */       default:
/*  991 */         this.jj_la1[47] = this.jj_gen;
/*      */         break;
/*      */     } 
/*  994 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 87:
/*  996 */         token = jj_consume_token(87);
/*  997 */         return token.toString().trim();
/*      */ 
/*      */       
/*      */       case 82:
/*      */         while (true) {
/* 1002 */           token = jj_consume_token(82);
/* 1003 */           if (stringBuffer == null) { stringBuffer = new StringBuffer(token.toString().trim()); }
/* 1004 */           else { stringBuffer.append(" " + token.toString().trim()); }
/* 1005 */            switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 82:
/*      */               continue;
/*      */           }  break;
/*      */         } 
/* 1010 */         this.jj_la1[48] = this.jj_gen;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1020 */         return stringBuffer.toString().trim();
/*      */     } 
/*      */     this.jj_la1[49] = this.jj_gen;
/*      */     jj_consume_token(-1);
/*      */     throw new ParseException();
/*      */   }
/*      */   
/*      */   public final String SelectStar() throws ParseException {
/* 1028 */     if (jj_2_3(2)) {
/* 1029 */       String str = OracleObjectName();
/* 1030 */       jj_consume_token(104);
/* 1031 */       return new String(str + ".*");
/* 1032 */     }  if (jj_2_4(4)) {
/* 1033 */       String str1 = OracleObjectName();
/* 1034 */       jj_consume_token(93);
/* 1035 */       String str2 = OracleObjectName();
/* 1036 */       jj_consume_token(104);
/* 1037 */       return new String(str1 + "." + str2 + ".*");
/*      */     } 
/* 1039 */     jj_consume_token(-1);
/* 1040 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Vector FromClause() throws ParseException {
/* 1047 */     Vector vector = new Vector(8);
/*      */     
/* 1049 */     jj_consume_token(29);
/* 1050 */     ZFromItem zFromItem = FromItem();
/* 1051 */     vector.addElement(zFromItem);
/*      */     
/*      */     while (true) {
/* 1054 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 89:
/*      */           break;
/*      */         
/*      */         default:
/* 1059 */           this.jj_la1[50] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1062 */       jj_consume_token(89);
/* 1063 */       zFromItem = FromItem();
/* 1064 */       vector.addElement(zFromItem);
/*      */     } 
/* 1066 */     return vector;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZFromItem FromItem() throws ParseException {
/*      */     Token token;
/* 1075 */     String str = TableReference();
/* 1076 */     ZFromItem zFromItem = new ZFromItem(str);
/* 1077 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 82:
/* 1079 */         token = jj_consume_token(82);
/* 1080 */         zFromItem.setAlias(token.toString());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1086 */         return zFromItem; }  this.jj_la1[51] = this.jj_gen; return zFromItem;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp WhereClause() throws ParseException {
/* 1092 */     jj_consume_token(72);
/* 1093 */     return SQLExpression();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void ConnectClause() throws ParseException {
/* 1099 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 63:
/* 1101 */         jj_consume_token(63);
/* 1102 */         jj_consume_token(73);
/* 1103 */         SQLExpression();
/*      */         break;
/*      */       default:
/* 1106 */         this.jj_la1[52] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1109 */     jj_consume_token(18);
/* 1110 */     jj_consume_token(14);
/* 1111 */     SQLExpression();
/* 1112 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 63:
/* 1114 */         jj_consume_token(63);
/* 1115 */         jj_consume_token(73);
/* 1116 */         SQLExpression();
/*      */         return;
/*      */     } 
/* 1119 */     this.jj_la1[53] = this.jj_gen;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZGroupBy GroupByClause() throws ParseException {
/*      */     ZExp zExp;
/* 1125 */     ZGroupBy zGroupBy = null;
/*      */ 
/*      */     
/* 1128 */     jj_consume_token(30);
/* 1129 */     jj_consume_token(14);
/* 1130 */     Vector vector = SQLExpressionList();
/* 1131 */     zGroupBy = new ZGroupBy(vector);
/* 1132 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 31:
/* 1134 */         jj_consume_token(31);
/* 1135 */         zExp = SQLExpression();
/* 1136 */         zGroupBy.setHaving(zExp);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1142 */         return zGroupBy; }  this.jj_la1[54] = this.jj_gen; return zGroupBy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExpression SetClause() throws ParseException {
/*      */     Token token;
/* 1152 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 67:
/* 1154 */         token = jj_consume_token(67);
/* 1155 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 5:
/* 1157 */             jj_consume_token(5);
/*      */             break;
/*      */         } 
/* 1160 */         this.jj_la1[55] = this.jj_gen;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 35:
/* 1165 */         token = jj_consume_token(35);
/*      */         break;
/*      */       case 42:
/* 1168 */         token = jj_consume_token(42);
/*      */         break;
/*      */       default:
/* 1171 */         this.jj_la1[56] = this.jj_gen;
/* 1172 */         jj_consume_token(-1);
/* 1173 */         throw new ParseException();
/*      */     } 
/* 1175 */     ZExpression zExpression = new ZExpression(token.toString());
/* 1176 */     if (jj_2_5(2147483647))
/* 1177 */     { jj_consume_token(88);
/* 1178 */       ZQuery zQuery = SelectWithoutOrder();
/* 1179 */       zExpression.addOperand(zQuery);
/* 1180 */       jj_consume_token(90); }
/*      */     else
/* 1182 */     { ZQuery zQuery; switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */       { case 59:
/* 1184 */           zQuery = SelectWithoutOrder();
/* 1185 */           zExpression.addOperand(zQuery);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1193 */           return zExpression; }  this.jj_la1[57] = this.jj_gen; jj_consume_token(-1); throw new ParseException(); }  return zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Vector OrderByClause() throws ParseException {
/* 1198 */     Vector vector = new Vector();
/*      */ 
/*      */     
/* 1201 */     jj_consume_token(52);
/* 1202 */     jj_consume_token(14);
/* 1203 */     ZExp zExp = SQLSimpleExpression();
/* 1204 */     ZOrderBy zOrderBy = new ZOrderBy(zExp);
/* 1205 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 9:
/*      */       case 22:
/* 1208 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 9:
/* 1210 */             jj_consume_token(9);
/*      */             break;
/*      */           case 22:
/* 1213 */             jj_consume_token(22);
/* 1214 */             zOrderBy.setAscOrder(false);
/*      */             break;
/*      */         } 
/* 1217 */         this.jj_la1[58] = this.jj_gen;
/* 1218 */         jj_consume_token(-1);
/* 1219 */         throw new ParseException();
/*      */ 
/*      */       
/*      */       default:
/* 1223 */         this.jj_la1[59] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1226 */     vector.addElement(zOrderBy);
/*      */     
/*      */     while (true) {
/* 1229 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 89:
/*      */           break;
/*      */         
/*      */         default:
/* 1234 */           this.jj_la1[60] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1237 */       jj_consume_token(89);
/* 1238 */       zExp = SQLSimpleExpression();
/* 1239 */       zOrderBy = new ZOrderBy(zExp);
/* 1240 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 9:
/*      */         case 22:
/* 1243 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 9:
/* 1245 */               jj_consume_token(9);
/*      */               break;
/*      */             case 22:
/* 1248 */               jj_consume_token(22);
/* 1249 */               zOrderBy.setAscOrder(false);
/*      */               break;
/*      */           } 
/* 1252 */           this.jj_la1[61] = this.jj_gen;
/* 1253 */           jj_consume_token(-1);
/* 1254 */           throw new ParseException();
/*      */ 
/*      */         
/*      */         default:
/* 1258 */           this.jj_la1[62] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1261 */       vector.addElement(zOrderBy);
/*      */     } 
/* 1263 */     return vector;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void ForUpdateClause() throws ParseException {
/* 1268 */     jj_consume_token(28);
/* 1269 */     jj_consume_token(68);
/* 1270 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 49:
/* 1272 */         jj_consume_token(49);
/* 1273 */         TableColumn();
/*      */         
/*      */         while (true) {
/* 1276 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 89:
/*      */               break;
/*      */             
/*      */             default:
/* 1281 */               this.jj_la1[63] = this.jj_gen;
/*      */               break;
/*      */           } 
/* 1284 */           jj_consume_token(89);
/* 1285 */           TableColumn();
/*      */         } 
/*      */         return;
/*      */     } 
/* 1289 */     this.jj_la1[64] = this.jj_gen;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLExpression() throws ParseException {
/* 1296 */     ZExpression zExpression = null;
/* 1297 */     boolean bool = true;
/* 1298 */     ZExp zExp = SQLAndExpression();
/*      */     
/*      */     while (true) {
/* 1301 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 51:
/*      */           break;
/*      */         
/*      */         default:
/* 1306 */           this.jj_la1[65] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1309 */       jj_consume_token(51);
/* 1310 */       ZExp zExp1 = SQLAndExpression();
/* 1311 */       if (bool) zExpression = new ZExpression("OR", zExp); 
/* 1312 */       bool = false;
/* 1313 */       zExpression.addOperand(zExp1);
/*      */     } 
/* 1315 */     return bool ? zExp : zExpression;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLAndExpression() throws ParseException {
/* 1321 */     ZExpression zExpression = null;
/* 1322 */     boolean bool = true;
/* 1323 */     ZExp zExp = SQLUnaryLogicalExpression();
/*      */     
/*      */     while (true) {
/* 1326 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 6:
/*      */           break;
/*      */         
/*      */         default:
/* 1331 */           this.jj_la1[66] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1334 */       jj_consume_token(6);
/* 1335 */       ZExp zExp1 = SQLUnaryLogicalExpression();
/* 1336 */       if (bool) zExpression = new ZExpression("AND", zExp); 
/* 1337 */       bool = false;
/* 1338 */       zExpression.addOperand(zExp1);
/*      */     } 
/* 1340 */     return bool ? zExp : zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZExp SQLUnaryLogicalExpression() throws ParseException {
/*      */     ZExp zExp1, zExp2;
/* 1346 */     boolean bool = false;
/* 1347 */     if (jj_2_6(2)) {
/* 1348 */       zExp2 = ExistsClause();
/* 1349 */       return zExp2;
/*      */     } 
/* 1351 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 45:
/*      */       case 47:
/*      */       case 53:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/* 1368 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 45:
/* 1370 */             jj_consume_token(45);
/* 1371 */             bool = true;
/*      */             break;
/*      */           default:
/* 1374 */             this.jj_la1[67] = this.jj_gen;
/*      */             break;
/*      */         } 
/* 1377 */         zExp1 = SQLRelationalExpression();
/* 1378 */         if (bool) { zExp2 = new ZExpression("NOT", zExp1); }
/* 1379 */         else { zExp2 = zExp1; }
/* 1380 */          return zExp2;
/*      */     } 
/*      */     
/* 1383 */     this.jj_la1[68] = this.jj_gen;
/* 1384 */     jj_consume_token(-1);
/* 1385 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExpression ExistsClause() throws ParseException {
/*      */     ZExpression zExpression1;
/* 1394 */     boolean bool = false;
/* 1395 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 45:
/* 1397 */         jj_consume_token(45);
/* 1398 */         bool = true;
/*      */         break;
/*      */       default:
/* 1401 */         this.jj_la1[69] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1404 */     jj_consume_token(25);
/* 1405 */     jj_consume_token(88);
/* 1406 */     ZQuery zQuery = SubQuery();
/* 1407 */     jj_consume_token(90);
/* 1408 */     ZExpression zExpression2 = new ZExpression("EXISTS", zQuery);
/* 1409 */     if (bool) { zExpression1 = new ZExpression("NOT", zExpression2); }
/* 1410 */     else { zExpression1 = zExpression2; }
/* 1411 */      return zExpression1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLRelationalExpression() throws ParseException {
/*      */     ZExp zExp;
/* 1421 */     ZExpression zExpression = null;
/*      */     
/* 1423 */     boolean bool = false;
/* 1424 */     if (jj_2_7(2147483647)) {
/* 1425 */       jj_consume_token(88);
/* 1426 */       Vector vector1 = SQLExpressionList();
/* 1427 */       jj_consume_token(90);
/* 1428 */       zExp = new ZExpression(",");
/* 1429 */       zExp.setOperands(vector1);
/*      */     } else {
/* 1431 */       ZExp zExp1; switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 10:
/*      */         case 19:
/*      */         case 40:
/*      */         case 41:
/*      */         case 47:
/*      */         case 53:
/*      */         case 64:
/*      */         case 76:
/*      */         case 82:
/*      */         case 85:
/*      */         case 86:
/*      */         case 87:
/*      */         case 88:
/*      */         case 101:
/*      */         case 102:
/* 1447 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 53:
/* 1449 */               jj_consume_token(53);
/* 1450 */               bool = true;
/*      */               break;
/*      */             default:
/* 1453 */               this.jj_la1[70] = this.jj_gen;
/*      */               break;
/*      */           } 
/* 1456 */           zExp1 = SQLSimpleExpression();
/* 1457 */           if (bool) { ZExpression zExpression1 = new ZExpression("PRIOR", zExp1); break; }
/* 1458 */            zExp = zExp1;
/*      */           break;
/*      */         default:
/* 1461 */           this.jj_la1[71] = this.jj_gen;
/* 1462 */           jj_consume_token(-1);
/* 1463 */           throw new ParseException();
/*      */       } 
/*      */     } 
/* 1466 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 11:
/*      */       case 32:
/*      */       case 37:
/*      */       case 38:
/*      */       case 45:
/*      */       case 92:
/*      */       case 94:
/*      */       case 95:
/*      */       case 96:
/*      */       case 97:
/*      */       case 98:
/*      */       case 99:
/*      */       case 100:
/* 1480 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 92:
/*      */           case 94:
/*      */           case 95:
/*      */           case 96:
/*      */           case 97:
/*      */           case 98:
/*      */           case 99:
/*      */           case 100:
/* 1489 */             zExpression = SQLRelationalOperatorExpression();
/*      */             break;
/*      */         } 
/* 1492 */         this.jj_la1[72] = this.jj_gen;
/* 1493 */         if (jj_2_8(2)) {
/* 1494 */           zExpression = SQLInClause(); break;
/* 1495 */         }  if (jj_2_9(2)) {
/* 1496 */           zExpression = SQLBetweenClause(); break;
/* 1497 */         }  if (jj_2_10(2)) {
/* 1498 */           zExpression = SQLLikeClause(); break;
/*      */         } 
/* 1500 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 37:
/* 1502 */             zExpression = IsNullClause();
/*      */             break;
/*      */         } 
/* 1505 */         this.jj_la1[73] = this.jj_gen;
/* 1506 */         jj_consume_token(-1);
/* 1507 */         throw new ParseException();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1513 */         this.jj_la1[74] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1516 */     if (zExpression == null) return zExp; 
/* 1517 */     Vector vector = zExpression.getOperands();
/* 1518 */     if (vector == null) vector = new Vector(); 
/* 1519 */     vector.insertElementAt(zExp, 0);
/* 1520 */     zExpression.setOperands(vector);
/* 1521 */     return zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final Vector SQLExpressionList() throws ParseException {
/* 1526 */     Vector vector = new Vector(8);
/*      */     
/* 1528 */     ZExp zExp = SQLSimpleExpressionOrPreparedCol();
/* 1529 */     vector.addElement(zExp);
/*      */     
/*      */     while (true) {
/* 1532 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 89:
/*      */           break;
/*      */         
/*      */         default:
/* 1537 */           this.jj_la1[75] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1540 */       jj_consume_token(89);
/* 1541 */       zExp = SQLSimpleExpressionOrPreparedCol();
/* 1542 */       vector.addElement(zExp);
/*      */     } 
/* 1544 */     return vector;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExpression SQLRelationalOperatorExpression() throws ParseException {
/*      */     ZExp zExp;
/* 1552 */     String str2 = null;
/* 1553 */     String str1 = Relop();
/* 1554 */     ZExpression zExpression = new ZExpression(str1);
/* 1555 */     if (jj_2_11(2147483647))
/* 1556 */     { switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 5:
/*      */         case 7:
/* 1559 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 5:
/* 1561 */               jj_consume_token(5);
/* 1562 */               str2 = "ALL";
/*      */               break;
/*      */             case 7:
/* 1565 */               jj_consume_token(7);
/* 1566 */               str2 = "ANY";
/*      */               break;
/*      */           } 
/* 1569 */           this.jj_la1[76] = this.jj_gen;
/* 1570 */           jj_consume_token(-1);
/* 1571 */           throw new ParseException();
/*      */ 
/*      */         
/*      */         default:
/* 1575 */           this.jj_la1[77] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1578 */       jj_consume_token(88);
/* 1579 */       ZQuery zQuery = SubQuery();
/* 1580 */       jj_consume_token(90);
/* 1581 */       if (str2 == null) { zExp = zQuery; }
/* 1582 */       else { zExp = new ZExpression(str2, zQuery); }
/*      */        }
/* 1584 */     else { ZExp zExp1; switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */       { case 10:
/*      */         case 19:
/*      */         case 40:
/*      */         case 41:
/*      */         case 47:
/*      */         case 53:
/*      */         case 64:
/*      */         case 76:
/*      */         case 82:
/*      */         case 85:
/*      */         case 86:
/*      */         case 87:
/*      */         case 88:
/*      */         case 101:
/*      */         case 102:
/*      */         case 105:
/* 1601 */           switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */             case 53:
/* 1603 */               jj_consume_token(53);
/* 1604 */               str2 = "PRIOR";
/*      */               break;
/*      */             default:
/* 1607 */               this.jj_la1[78] = this.jj_gen;
/*      */               break;
/*      */           } 
/* 1610 */           zExp1 = SQLSimpleExpressionOrPreparedCol();
/* 1611 */           if (str2 == null) { zExp = zExp1; }
/* 1612 */           else { zExp = new ZExpression(str2, zExp1); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1620 */           zExpression.addOperand(zExp); return zExpression; }  this.jj_la1[79] = this.jj_gen; jj_consume_token(-1); throw new ParseException(); }  zExpression.addOperand(zExp); return zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZExp SQLSimpleExpressionOrPreparedCol() throws ParseException {
/*      */     ZExp zExp;
/* 1626 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 47:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/* 1641 */         zExp = SQLSimpleExpression();
/* 1642 */         return zExp;
/*      */       
/*      */       case 105:
/* 1645 */         zExp = PreparedCol();
/* 1646 */         return zExp;
/*      */     } 
/*      */     
/* 1649 */     this.jj_la1[80] = this.jj_gen;
/* 1650 */     jj_consume_token(-1);
/* 1651 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp PreparedCol() throws ParseException {
/* 1658 */     jj_consume_token(105);
/* 1659 */     return new ZExpression("?");
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZExpression SQLInClause() throws ParseException {
/*      */     ZQuery zQuery;
/*      */     Vector vector;
/* 1666 */     boolean bool = false;
/*      */     
/* 1668 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 45:
/* 1670 */         jj_consume_token(45);
/* 1671 */         bool = true;
/*      */         break;
/*      */       default:
/* 1674 */         this.jj_la1[81] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1677 */     jj_consume_token(32);
/* 1678 */     ZExpression zExpression = new ZExpression(bool ? "NOT IN" : "IN");
/* 1679 */     jj_consume_token(88);
/* 1680 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 47:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/*      */       case 105:
/* 1696 */         vector = SQLExpressionList();
/* 1697 */         zExpression.setOperands(vector);
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
/* 1708 */         jj_consume_token(90);
/* 1709 */         return zExpression;case 59: zQuery = SubQuery(); zExpression.addOperand(zQuery); jj_consume_token(90); return zExpression;
/*      */     } 
/*      */     this.jj_la1[82] = this.jj_gen;
/*      */     jj_consume_token(-1);
/*      */     throw new ParseException();
/*      */   } public final ZExpression SQLBetweenClause() throws ParseException {
/*      */     ZExpression zExpression;
/* 1716 */     boolean bool = false;
/* 1717 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 45:
/* 1719 */         jj_consume_token(45);
/* 1720 */         bool = true;
/*      */         break;
/*      */       default:
/* 1723 */         this.jj_la1[83] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1726 */     jj_consume_token(11);
/* 1727 */     ZExp zExp1 = SQLSimpleExpressionOrPreparedCol();
/* 1728 */     jj_consume_token(6);
/* 1729 */     ZExp zExp2 = SQLSimpleExpressionOrPreparedCol();
/* 1730 */     if (bool) { zExpression = new ZExpression("NOT BETWEEN", zExp1, zExp2); }
/* 1731 */     else { zExpression = new ZExpression("BETWEEN", zExp1, zExp2); }
/* 1732 */      return zExpression;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExpression SQLLikeClause() throws ParseException {
/*      */     ZExpression zExpression;
/* 1739 */     boolean bool = false;
/* 1740 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 45:
/* 1742 */         jj_consume_token(45);
/* 1743 */         bool = true;
/*      */         break;
/*      */       default:
/* 1746 */         this.jj_la1[84] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1749 */     jj_consume_token(38);
/* 1750 */     ZExp zExp = SQLSimpleExpressionOrPreparedCol();
/* 1751 */     if (bool) { zExpression = new ZExpression("NOT LIKE", zExp); }
/* 1752 */     else { zExpression = new ZExpression("LIKE", zExp); }
/* 1753 */      return zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZExpression IsNullClause() throws ParseException {
/* 1758 */     boolean bool = false;
/* 1759 */     jj_consume_token(37);
/* 1760 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 45:
/* 1762 */         jj_consume_token(45);
/* 1763 */         bool = true;
/*      */         break;
/*      */       default:
/* 1766 */         this.jj_la1[85] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1769 */     jj_consume_token(47);
/* 1770 */     return bool ? new ZExpression("IS NOT NULL") : new ZExpression("IS NULL");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLSimpleExpression() throws ParseException {
/* 1780 */     ZExpression zExpression = null;
/* 1781 */     ZExp zExp = SQLMultiplicativeExpression();
/*      */     while (true) {
/*      */       Token token;
/* 1784 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 101:
/*      */         case 102:
/*      */         case 106:
/*      */           break;
/*      */         
/*      */         default:
/* 1791 */           this.jj_la1[86] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1794 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 101:
/* 1796 */           token = jj_consume_token(101);
/*      */           break;
/*      */         case 102:
/* 1799 */           token = jj_consume_token(102);
/*      */           break;
/*      */         case 106:
/* 1802 */           token = jj_consume_token(106);
/*      */           break;
/*      */         default:
/* 1805 */           this.jj_la1[87] = this.jj_gen;
/* 1806 */           jj_consume_token(-1);
/* 1807 */           throw new ParseException();
/*      */       } 
/* 1809 */       ZExp zExp1 = SQLMultiplicativeExpression();
/* 1810 */       zExpression = new ZExpression(token.toString(), zExp);
/* 1811 */       zExpression.addOperand(zExp1);
/* 1812 */       zExp = zExpression;
/*      */     } 
/* 1814 */     return zExp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLMultiplicativeExpression() throws ParseException {
/* 1824 */     ZExpression zExpression = null;
/* 1825 */     ZExp zExp = SQLExpotentExpression();
/*      */     while (true) {
/*      */       Token token;
/* 1828 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 103:
/*      */         case 107:
/*      */           break;
/*      */         
/*      */         default:
/* 1834 */           this.jj_la1[88] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1837 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 103:
/* 1839 */           token = jj_consume_token(103);
/*      */           break;
/*      */         case 107:
/* 1842 */           token = jj_consume_token(107);
/*      */           break;
/*      */         default:
/* 1845 */           this.jj_la1[89] = this.jj_gen;
/* 1846 */           jj_consume_token(-1);
/* 1847 */           throw new ParseException();
/*      */       } 
/* 1849 */       ZExp zExp1 = SQLExpotentExpression();
/* 1850 */       zExpression = new ZExpression(token.toString(), zExp);
/* 1851 */       zExpression.addOperand(zExp1);
/* 1852 */       zExp = zExpression;
/*      */     } 
/* 1854 */     return zExp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExp SQLExpotentExpression() throws ParseException {
/* 1862 */     ZExpression zExpression = null;
/* 1863 */     boolean bool = true;
/* 1864 */     ZExp zExp = SQLUnaryExpression();
/*      */     
/*      */     while (true) {
/* 1867 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */         case 108:
/*      */           break;
/*      */         
/*      */         default:
/* 1872 */           this.jj_la1[90] = this.jj_gen;
/*      */           break;
/*      */       } 
/* 1875 */       Token token = jj_consume_token(108);
/* 1876 */       ZExp zExp1 = SQLUnaryExpression();
/* 1877 */       if (bool) zExpression = new ZExpression(token.toString(), zExp); 
/* 1878 */       bool = false;
/* 1879 */       zExpression.addOperand(zExp1);
/*      */     } 
/* 1881 */     return bool ? zExp : zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final ZExp SQLUnaryExpression() throws ParseException {
/*      */     ZExp zExp2;
/* 1887 */     Token token = null;
/*      */     
/* 1889 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 101:
/*      */       case 102:
/* 1892 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */           case 101:
/* 1894 */             token = jj_consume_token(101);
/*      */             break;
/*      */           case 102:
/* 1897 */             token = jj_consume_token(102);
/*      */             break;
/*      */         } 
/* 1900 */         this.jj_la1[91] = this.jj_gen;
/* 1901 */         jj_consume_token(-1);
/* 1902 */         throw new ParseException();
/*      */ 
/*      */       
/*      */       default:
/* 1906 */         this.jj_la1[92] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 1909 */     ZExp zExp1 = SQLPrimaryExpression();
/* 1910 */     if (token == null) { zExp2 = zExp1; }
/* 1911 */     else { zExp2 = new ZExpression(token.toString(), zExp1); }
/* 1912 */      return zExp2;
/*      */   }
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
/*      */   public final ZExp SQLPrimaryExpression() throws ParseException {
/*      */     Token token;
/*      */     String str1;
/*      */     ZExp zExp;
/* 1929 */     String str2 = "";
/*      */     
/* 1931 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 47:
/* 1933 */         jj_consume_token(47);
/* 1934 */         return new ZConstant("NULL", 1);
/*      */     } 
/*      */     
/* 1937 */     this.jj_la1[94] = this.jj_gen;
/* 1938 */     if (jj_2_12(2147483647)) {
/* 1939 */       String str = OuterJoinExpression();
/* 1940 */       return new ZConstant(str, 0);
/*      */     } 
/*      */     
/* 1943 */     if (jj_2_13(3)) {
/* 1944 */       jj_consume_token(19);
/* 1945 */       jj_consume_token(88);
/* 1946 */       jj_consume_token(103);
/* 1947 */       jj_consume_token(90);
/* 1948 */       return new ZExpression("COUNT", new ZConstant("*", 0));
/*      */     } 
/* 1950 */     if (jj_2_14(3)) {
/* 1951 */       String str4, str3 = AggregateFunc();
/* 1952 */       jj_consume_token(88);
/* 1953 */       switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */       { case 5:
/* 1955 */           jj_consume_token(5);
/* 1956 */           str2 = "all ";
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
/* 1967 */           str4 = TableColumn();
/* 1968 */           jj_consume_token(90);
/* 1969 */           return new ZExpression(str3, new ZConstant(str2 + str4, 0));case 23: jj_consume_token(23); str2 = "distinct "; str4 = TableColumn(); jj_consume_token(90); return new ZExpression(str3, new ZConstant(str2 + str4, 0)); }  this.jj_la1[93] = this.jj_gen; jj_consume_token(-1); throw new ParseException();
/* 1970 */     }  if (jj_2_15(2)) {
/* 1971 */       return FunctionCall();
/*      */     }
/*      */     
/* 1974 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 82:
/*      */       case 87:
/* 1977 */         str1 = TableColumn();
/* 1978 */         return new ZConstant(str1, 0);
/*      */       
/*      */       case 76:
/* 1981 */         token = jj_consume_token(76);
/* 1982 */         return new ZConstant(token.toString(), 2);
/*      */       
/*      */       case 86:
/* 1985 */         token = jj_consume_token(86);
/* 1986 */         str1 = token.toString();
/* 1987 */         if (str1.startsWith("'")) str1 = str1.substring(1); 
/* 1988 */         if (str1.endsWith("'")) str1 = str1.substring(0, str1.length() - 1); 
/* 1989 */         return new ZConstant(str1, 3);
/*      */       
/*      */       case 85:
/* 1992 */         token = jj_consume_token(85);
/* 1993 */         return new ZConstant(token.toString(), 3);
/*      */       
/*      */       case 88:
/* 1996 */         jj_consume_token(88);
/* 1997 */         zExp = SQLExpression();
/* 1998 */         jj_consume_token(90);
/* 1999 */         return zExp;
/*      */     } 
/*      */     
/* 2002 */     this.jj_la1[95] = this.jj_gen;
/* 2003 */     jj_consume_token(-1);
/* 2004 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String AggregateFunc() throws ParseException {
/*      */     Token token;
/* 2015 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 64:
/* 2017 */         token = jj_consume_token(64);
/* 2018 */         return token.toString();
/*      */       
/*      */       case 10:
/* 2021 */         token = jj_consume_token(10);
/* 2022 */         return token.toString();
/*      */       
/*      */       case 40:
/* 2025 */         token = jj_consume_token(40);
/* 2026 */         return token.toString();
/*      */       
/*      */       case 41:
/* 2029 */         token = jj_consume_token(41);
/* 2030 */         return token.toString();
/*      */       
/*      */       case 19:
/* 2033 */         token = jj_consume_token(19);
/* 2034 */         return token.toString();
/*      */     } 
/*      */     
/* 2037 */     this.jj_la1[96] = this.jj_gen;
/* 2038 */     jj_consume_token(-1);
/* 2039 */     throw new ParseException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZExpression FunctionCall() throws ParseException {
/*      */     Token token;
/*      */     String str;
/* 2048 */     Vector vector = null;
/* 2049 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 82:
/* 2051 */         token = jj_consume_token(82);
/* 2052 */         str = token.toString();
/*      */         break;
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 64:
/* 2059 */         str = AggregateFunc();
/*      */         break;
/*      */       default:
/* 2062 */         this.jj_la1[97] = this.jj_gen;
/* 2063 */         jj_consume_token(-1);
/* 2064 */         throw new ParseException();
/*      */     } 
/* 2066 */     jj_consume_token(88);
/* 2067 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk) {
/*      */       case 10:
/*      */       case 19:
/*      */       case 40:
/*      */       case 41:
/*      */       case 47:
/*      */       case 64:
/*      */       case 76:
/*      */       case 82:
/*      */       case 85:
/*      */       case 86:
/*      */       case 87:
/*      */       case 88:
/*      */       case 101:
/*      */       case 102:
/*      */       case 105:
/* 2083 */         vector = SQLExpressionList();
/*      */         break;
/*      */       default:
/* 2086 */         this.jj_la1[98] = this.jj_gen;
/*      */         break;
/*      */     } 
/* 2089 */     jj_consume_token(90);
/* 2090 */     int i = ZUtils.isCustomFunction(str);
/* 2091 */     if (i < 0) i = ZUtils.isAggregate(str) ? 1 : -1; 
/* 2092 */     if (i < 0)
/* 2093 */       throw new ParseException("Undefined function: " + str); 
/* 2094 */     if (i != 10000 && i > 0 && (
/* 2095 */       vector == null || vector.size() != i)) {
/* 2096 */       throw new ParseException("Function " + str + " should have " + i + " parameter(s)");
/*      */     }
/*      */ 
/*      */     
/* 2100 */     ZExpression zExpression = new ZExpression(str);
/* 2101 */     zExpression.setOperands(vector);
/* 2102 */     return zExpression;
/*      */   }
/*      */ 
/*      */   
/*      */   public final String OuterJoinExpression() throws ParseException {
/* 2107 */     String str1 = null;
/* 2108 */     String str2 = "";
/*      */     
/* 2110 */     str1 = OracleObjectName();
/* 2111 */     switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */     { case 93:
/* 2113 */         jj_consume_token(93);
/* 2114 */         str2 = OracleObjectName();
/* 2115 */         str1 = str1 + "." + str2;
/* 2116 */         switch ((this.jj_ntk == -1) ? jj_ntk() : this.jj_ntk)
/*      */         { case 93:
/* 2118 */             jj_consume_token(93);
/* 2119 */             str2 = OracleObjectName();
/* 2120 */             str1 = str1 + "." + str2;
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
/* 2131 */             jj_consume_token(88);
/* 2132 */             jj_consume_token(101);
/* 2133 */             jj_consume_token(90);
/* 2134 */             return str1 + "(+)"; }  this.jj_la1[99] = this.jj_gen; jj_consume_token(88); jj_consume_token(101); jj_consume_token(90); return str1 + "(+)"; }  this.jj_la1[100] = this.jj_gen; jj_consume_token(88); jj_consume_token(101); jj_consume_token(90); return str1 + "(+)";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final ZQuery SubQuery() throws ParseException {
/* 2140 */     return SelectWithoutOrder();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean jj_2_1(int paramInt) {
/* 2146 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2147 */     try { return !jj_3_1(); }
/* 2148 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2149 */     finally { jj_save(0, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_2(int paramInt) {
/* 2153 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2154 */     try { return !jj_3_2(); }
/* 2155 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2156 */     finally { jj_save(1, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_3(int paramInt) {
/* 2160 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2161 */     try { return !jj_3_3(); }
/* 2162 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2163 */     finally { jj_save(2, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_4(int paramInt) {
/* 2167 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2168 */     try { return !jj_3_4(); }
/* 2169 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2170 */     finally { jj_save(3, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_5(int paramInt) {
/* 2174 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2175 */     try { return !jj_3_5(); }
/* 2176 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2177 */     finally { jj_save(4, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_6(int paramInt) {
/* 2181 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2182 */     try { return !jj_3_6(); }
/* 2183 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2184 */     finally { jj_save(5, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_7(int paramInt) {
/* 2188 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2189 */     try { return !jj_3_7(); }
/* 2190 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2191 */     finally { jj_save(6, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_8(int paramInt) {
/* 2195 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2196 */     try { return !jj_3_8(); }
/* 2197 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2198 */     finally { jj_save(7, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_9(int paramInt) {
/* 2202 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2203 */     try { return !jj_3_9(); }
/* 2204 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2205 */     finally { jj_save(8, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_10(int paramInt) {
/* 2209 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2210 */     try { return !jj_3_10(); }
/* 2211 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2212 */     finally { jj_save(9, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_11(int paramInt) {
/* 2216 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2217 */     try { return !jj_3_11(); }
/* 2218 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2219 */     finally { jj_save(10, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_12(int paramInt) {
/* 2223 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2224 */     try { return !jj_3_12(); }
/* 2225 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2226 */     finally { jj_save(11, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_13(int paramInt) {
/* 2230 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2231 */     try { return !jj_3_13(); }
/* 2232 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2233 */     finally { jj_save(12, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_14(int paramInt) {
/* 2237 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2238 */     try { return !jj_3_14(); }
/* 2239 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2240 */     finally { jj_save(13, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_2_15(int paramInt) {
/* 2244 */     this.jj_la = paramInt; this.jj_lastpos = this.jj_scanpos = this.token; 
/* 2245 */     try { return !jj_3_15(); }
/* 2246 */     catch (LookaheadSuccess lookaheadSuccess) { return true; }
/* 2247 */     finally { jj_save(14, paramInt); }
/*      */   
/*      */   }
/*      */   private boolean jj_3R_52() {
/* 2251 */     if (jj_scan_token(108)) return true; 
/* 2252 */     if (jj_3R_51()) return true; 
/* 2253 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_138() {
/* 2257 */     if (jj_scan_token(82)) return true; 
/* 2258 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_46() {
/* 2262 */     if (jj_3R_51()) return true;
/*      */     
/*      */     while (true) {
/* 2265 */       Token token = this.jj_scanpos;
/* 2266 */       if (jj_3R_52()) { this.jj_scanpos = token;
/*      */         
/* 2268 */         return false; }
/*      */     
/*      */     } 
/*      */   }
/*      */   private boolean jj_3R_137() {
/* 2273 */     if (jj_3R_138()) return true; 
/*      */     while (true) {
/* 2275 */       Token token = this.jj_scanpos;
/* 2276 */       if (jj_3R_138()) { this.jj_scanpos = token;
/*      */         
/* 2278 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_78() {
/* 2282 */     if (jj_scan_token(88)) return true; 
/* 2283 */     if (jj_3R_70()) return true; 
/* 2284 */     if (jj_scan_token(90)) return true; 
/* 2285 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_76() {
/* 2290 */     Token token = this.jj_scanpos;
/* 2291 */     if (jj_3R_78()) {
/* 2292 */       this.jj_scanpos = token;
/* 2293 */       if (jj_3R_79()) return true; 
/*      */     } 
/* 2295 */     token = this.jj_scanpos;
/* 2296 */     if (jj_3R_80()) this.jj_scanpos = token; 
/* 2297 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_135() {
/* 2302 */     Token token = this.jj_scanpos;
/* 2303 */     if (jj_scan_token(8)) this.jj_scanpos = token; 
/* 2304 */     token = this.jj_scanpos;
/* 2305 */     if (jj_3R_136()) {
/* 2306 */       this.jj_scanpos = token;
/* 2307 */       if (jj_3R_137()) return true; 
/*      */     } 
/* 2309 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3_1() {
/* 2314 */     if (jj_scan_token(88)) return true; 
/*      */     while (true) {
/* 2316 */       Token token = this.jj_scanpos;
/* 2317 */       if (jj_scan_token(88)) { this.jj_scanpos = token;
/*      */         
/* 2319 */         if (jj_scan_token(59)) return true; 
/* 2320 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_134() {
/* 2324 */     if (jj_3R_135()) return true; 
/* 2325 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_2() {
/* 2329 */     if (jj_3R_16()) return true; 
/* 2330 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_47() {
/* 2335 */     Token token = this.jj_scanpos;
/* 2336 */     if (jj_scan_token(103)) {
/* 2337 */       this.jj_scanpos = token;
/* 2338 */       if (jj_scan_token(107)) return true; 
/*      */     } 
/* 2340 */     if (jj_3R_46()) return true; 
/* 2341 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_32() {
/* 2345 */     if (jj_3R_46()) return true;
/*      */     
/*      */     while (true) {
/* 2348 */       Token token = this.jj_scanpos;
/* 2349 */       if (jj_3R_47()) { this.jj_scanpos = token;
/*      */         
/* 2351 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_130() {
/* 2355 */     if (jj_3R_19()) return true;
/*      */     
/* 2357 */     Token token = this.jj_scanpos;
/* 2358 */     if (jj_3R_134()) this.jj_scanpos = token; 
/* 2359 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_31() {
/* 2363 */     if (jj_scan_token(45)) return true; 
/* 2364 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_129() {
/* 2368 */     if (jj_3R_16()) return true; 
/* 2369 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_109() {
/* 2374 */     Token token = this.jj_scanpos;
/* 2375 */     if (jj_3R_129()) {
/* 2376 */       this.jj_scanpos = token;
/* 2377 */       if (jj_3R_130()) return true; 
/*      */     } 
/* 2379 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_18() {
/* 2384 */     Token token = this.jj_scanpos;
/* 2385 */     if (jj_3R_31()) this.jj_scanpos = token; 
/* 2386 */     if (jj_scan_token(25)) return true; 
/* 2387 */     if (jj_scan_token(88)) return true; 
/* 2388 */     if (jj_3R_77()) return true; 
/* 2389 */     if (jj_scan_token(90)) return true; 
/* 2390 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_33() {
/* 2395 */     Token token = this.jj_scanpos;
/* 2396 */     if (jj_scan_token(101)) {
/* 2397 */       this.jj_scanpos = token;
/* 2398 */       if (jj_scan_token(102)) {
/* 2399 */         this.jj_scanpos = token;
/* 2400 */         if (jj_scan_token(106)) return true; 
/*      */       } 
/*      */     } 
/* 2403 */     if (jj_3R_32()) return true; 
/* 2404 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_75() {
/* 2408 */     if (jj_scan_token(45)) return true; 
/* 2409 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_19() {
/* 2413 */     if (jj_3R_32()) return true;
/*      */     
/*      */     while (true) {
/* 2416 */       Token token = this.jj_scanpos;
/* 2417 */       if (jj_3R_33()) { this.jj_scanpos = token;
/*      */         
/* 2419 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_110() {
/* 2423 */     if (jj_scan_token(89)) return true; 
/* 2424 */     if (jj_3R_109()) return true; 
/* 2425 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_74() {
/* 2430 */     Token token = this.jj_scanpos;
/* 2431 */     if (jj_3R_75()) this.jj_scanpos = token; 
/* 2432 */     if (jj_3R_76()) return true; 
/* 2433 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_96() {
/* 2437 */     if (jj_3R_109()) return true;
/*      */     
/*      */     while (true) {
/* 2440 */       Token token = this.jj_scanpos;
/* 2441 */       if (jj_3R_110()) { this.jj_scanpos = token;
/*      */         
/* 2443 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3_6() {
/* 2447 */     if (jj_3R_18()) return true; 
/* 2448 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_71() {
/* 2453 */     Token token = this.jj_scanpos;
/* 2454 */     if (jj_3_6()) {
/* 2455 */       this.jj_scanpos = token;
/* 2456 */       if (jj_3R_74()) return true; 
/*      */     } 
/* 2458 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_95() {
/* 2462 */     if (jj_scan_token(103)) return true; 
/* 2463 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_86() {
/* 2468 */     Token token = this.jj_scanpos;
/* 2469 */     if (jj_3R_95()) {
/* 2470 */       this.jj_scanpos = token;
/* 2471 */       if (jj_3R_96()) return true; 
/*      */     } 
/* 2473 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_108() {
/* 2477 */     if (jj_scan_token(45)) return true; 
/* 2478 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_72() {
/* 2482 */     if (jj_scan_token(6)) return true; 
/* 2483 */     if (jj_3R_71()) return true; 
/* 2484 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_94() {
/* 2488 */     if (jj_scan_token(23)) return true; 
/* 2489 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_93() {
/* 2493 */     if (jj_scan_token(37)) return true;
/*      */     
/* 2495 */     Token token = this.jj_scanpos;
/* 2496 */     if (jj_3R_108()) this.jj_scanpos = token; 
/* 2497 */     if (jj_scan_token(47)) return true; 
/* 2498 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_67() {
/* 2502 */     if (jj_3R_71()) return true;
/*      */     
/*      */     while (true) {
/* 2505 */       Token token = this.jj_scanpos;
/* 2506 */       if (jj_3R_72()) { this.jj_scanpos = token;
/*      */         
/* 2508 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_45() {
/* 2512 */     if (jj_3R_25()) return true; 
/* 2513 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_77() {
/* 2517 */     if (jj_3R_81()) return true; 
/* 2518 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_85() {
/* 2523 */     Token token = this.jj_scanpos;
/* 2524 */     if (jj_scan_token(5)) {
/* 2525 */       this.jj_scanpos = token;
/* 2526 */       if (jj_3R_94()) return true; 
/*      */     } 
/* 2528 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_91() {
/* 2532 */     if (jj_3R_102()) return true; 
/* 2533 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_90() {
/* 2537 */     if (jj_3R_101()) return true; 
/* 2538 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_37() {
/* 2542 */     if (jj_scan_token(45)) return true; 
/* 2543 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_89() {
/* 2547 */     if (jj_3R_100()) return true; 
/* 2548 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_22() {
/* 2553 */     Token token = this.jj_scanpos;
/* 2554 */     if (jj_3R_37()) this.jj_scanpos = token; 
/* 2555 */     if (jj_scan_token(38)) return true; 
/* 2556 */     if (jj_3R_36()) return true; 
/* 2557 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_88() {
/* 2561 */     if (jj_3R_99()) return true; 
/* 2562 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_68() {
/* 2566 */     if (jj_scan_token(51)) return true; 
/* 2567 */     if (jj_3R_67()) return true; 
/* 2568 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_38() {
/* 2572 */     if (jj_scan_token(93)) return true; 
/* 2573 */     if (jj_3R_17()) return true;
/*      */     
/* 2575 */     Token token = this.jj_scanpos;
/* 2576 */     if (jj_3R_50()) this.jj_scanpos = token; 
/* 2577 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_50() {
/* 2581 */     if (jj_scan_token(93)) return true; 
/* 2582 */     if (jj_3R_17()) return true; 
/* 2583 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_64() {
/* 2587 */     if (jj_3R_67()) return true;
/*      */     
/*      */     while (true) {
/* 2590 */       Token token = this.jj_scanpos;
/* 2591 */       if (jj_3R_68()) { this.jj_scanpos = token;
/*      */         
/* 2593 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_24() {
/* 2597 */     if (jj_3R_17()) return true;
/*      */     
/* 2599 */     Token token = this.jj_scanpos;
/* 2600 */     if (jj_3R_38()) this.jj_scanpos = token; 
/* 2601 */     if (jj_scan_token(88)) return true; 
/* 2602 */     if (jj_scan_token(101)) return true; 
/* 2603 */     if (jj_scan_token(90)) return true; 
/* 2604 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_81() {
/* 2608 */     if (jj_scan_token(59)) return true;
/*      */     
/* 2610 */     Token token = this.jj_scanpos;
/* 2611 */     if (jj_3R_85()) this.jj_scanpos = token; 
/* 2612 */     if (jj_3R_86()) return true; 
/* 2613 */     if (jj_3R_87()) return true; 
/* 2614 */     token = this.jj_scanpos;
/* 2615 */     if (jj_3R_88()) this.jj_scanpos = token; 
/* 2616 */     token = this.jj_scanpos;
/* 2617 */     if (jj_3R_89()) this.jj_scanpos = token; 
/* 2618 */     token = this.jj_scanpos;
/* 2619 */     if (jj_3R_90()) this.jj_scanpos = token; 
/* 2620 */     token = this.jj_scanpos;
/* 2621 */     if (jj_3R_91()) this.jj_scanpos = token; 
/* 2622 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_35() {
/* 2626 */     if (jj_scan_token(45)) return true; 
/* 2627 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_21() {
/* 2632 */     Token token = this.jj_scanpos;
/* 2633 */     if (jj_3R_35()) this.jj_scanpos = token; 
/* 2634 */     if (jj_scan_token(11)) return true; 
/* 2635 */     if (jj_3R_36()) return true; 
/* 2636 */     if (jj_scan_token(6)) return true; 
/* 2637 */     if (jj_3R_36()) return true; 
/* 2638 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_106() {
/* 2642 */     if (jj_3R_70()) return true; 
/* 2643 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_30() {
/* 2647 */     if (jj_scan_token(87)) return true; 
/* 2648 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_107() {
/* 2652 */     if (jj_3R_77()) return true; 
/* 2653 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_5() {
/* 2657 */     if (jj_scan_token(88)) return true; 
/* 2658 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_34() {
/* 2662 */     if (jj_scan_token(45)) return true; 
/* 2663 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_20() {
/* 2668 */     Token token = this.jj_scanpos;
/* 2669 */     if (jj_3R_34()) this.jj_scanpos = token; 
/* 2670 */     if (jj_scan_token(32)) return true; 
/* 2671 */     if (jj_scan_token(88)) return true; 
/* 2672 */     token = this.jj_scanpos;
/* 2673 */     if (jj_3R_106()) {
/* 2674 */       this.jj_scanpos = token;
/* 2675 */       if (jj_3R_107()) return true; 
/*      */     } 
/* 2677 */     if (jj_scan_token(90)) return true; 
/* 2678 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_66() {
/* 2682 */     if (jj_3R_70()) return true; 
/* 2683 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_133() {
/* 2687 */     if (jj_scan_token(7)) return true; 
/* 2688 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_118() {
/* 2692 */     if (jj_3R_81()) return true; 
/* 2693 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_44() {
/* 2697 */     if (jj_scan_token(82)) return true; 
/* 2698 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_28() {
/* 2703 */     Token token = this.jj_scanpos;
/* 2704 */     if (jj_3R_44()) {
/* 2705 */       this.jj_scanpos = token;
/* 2706 */       if (jj_3R_45()) return true; 
/*      */     } 
/* 2708 */     if (jj_scan_token(88)) return true; 
/* 2709 */     token = this.jj_scanpos;
/* 2710 */     if (jj_3R_66()) this.jj_scanpos = token; 
/* 2711 */     if (jj_scan_token(90)) return true; 
/* 2712 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_117() {
/* 2716 */     if (jj_scan_token(88)) return true; 
/* 2717 */     if (jj_3R_81()) return true; 
/* 2718 */     if (jj_scan_token(90)) return true; 
/* 2719 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_23() {
/* 2723 */     if (jj_scan_token(88)) return true; 
/* 2724 */     if (jj_scan_token(59)) return true; 
/* 2725 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_116() {
/* 2729 */     if (jj_scan_token(67)) return true;
/*      */     
/* 2731 */     Token token = this.jj_scanpos;
/* 2732 */     if (jj_scan_token(5)) this.jj_scanpos = token; 
/* 2733 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_53() {
/* 2737 */     if (jj_scan_token(105)) return true; 
/* 2738 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_131() {
/* 2742 */     if (jj_scan_token(93)) return true; 
/* 2743 */     if (jj_3R_17()) return true; 
/* 2744 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_102() {
/* 2749 */     Token token = this.jj_scanpos;
/* 2750 */     if (jj_3R_116()) {
/* 2751 */       this.jj_scanpos = token;
/* 2752 */       if (jj_scan_token(35)) {
/* 2753 */         this.jj_scanpos = token;
/* 2754 */         if (jj_scan_token(42)) return true; 
/*      */       } 
/*      */     } 
/* 2757 */     token = this.jj_scanpos;
/* 2758 */     if (jj_3R_117()) {
/* 2759 */       this.jj_scanpos = token;
/* 2760 */       if (jj_3R_118()) return true; 
/*      */     } 
/* 2762 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_27() {
/* 2766 */     if (jj_scan_token(23)) return true; 
/* 2767 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_111() {
/* 2771 */     if (jj_3R_17()) return true;
/*      */     
/* 2773 */     Token token = this.jj_scanpos;
/* 2774 */     if (jj_3R_131()) this.jj_scanpos = token; 
/* 2775 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_43() {
/* 2779 */     if (jj_scan_token(19)) return true; 
/* 2780 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_49() {
/* 2784 */     if (jj_3R_53()) return true; 
/* 2785 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_42() {
/* 2789 */     if (jj_scan_token(41)) return true; 
/* 2790 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_36() {
/* 2795 */     Token token = this.jj_scanpos;
/* 2796 */     if (jj_3R_48()) {
/* 2797 */       this.jj_scanpos = token;
/* 2798 */       if (jj_3R_49()) return true; 
/*      */     } 
/* 2800 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_48() {
/* 2804 */     if (jj_3R_19()) return true; 
/* 2805 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_41() {
/* 2809 */     if (jj_scan_token(40)) return true; 
/* 2810 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_40() {
/* 2814 */     if (jj_scan_token(10)) return true; 
/* 2815 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_25() {
/* 2820 */     Token token = this.jj_scanpos;
/* 2821 */     if (jj_3R_39()) {
/* 2822 */       this.jj_scanpos = token;
/* 2823 */       if (jj_3R_40()) {
/* 2824 */         this.jj_scanpos = token;
/* 2825 */         if (jj_3R_41()) {
/* 2826 */           this.jj_scanpos = token;
/* 2827 */           if (jj_3R_42()) {
/* 2828 */             this.jj_scanpos = token;
/* 2829 */             if (jj_3R_43()) return true; 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2834 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_39() {
/* 2838 */     if (jj_scan_token(64)) return true; 
/* 2839 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_115() {
/* 2843 */     if (jj_scan_token(31)) return true; 
/* 2844 */     if (jj_3R_64()) return true; 
/* 2845 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3_11() {
/* 2850 */     Token token = this.jj_scanpos;
/* 2851 */     if (jj_scan_token(7)) {
/* 2852 */       this.jj_scanpos = token;
/* 2853 */       if (jj_scan_token(5)) {
/* 2854 */         this.jj_scanpos = token;
/* 2855 */         if (jj_3R_23()) return true; 
/*      */       } 
/*      */     } 
/* 2858 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_128() {
/* 2862 */     if (jj_scan_token(53)) return true; 
/* 2863 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_126() {
/* 2867 */     if (jj_scan_token(100)) return true; 
/* 2868 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_125() {
/* 2872 */     if (jj_scan_token(99)) return true; 
/* 2873 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_105() {
/* 2878 */     Token token = this.jj_scanpos;
/* 2879 */     if (jj_3R_128()) this.jj_scanpos = token; 
/* 2880 */     if (jj_3R_36()) return true; 
/* 2881 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_101() {
/* 2885 */     if (jj_scan_token(30)) return true; 
/* 2886 */     if (jj_scan_token(14)) return true; 
/* 2887 */     if (jj_3R_70()) return true;
/*      */     
/* 2889 */     Token token = this.jj_scanpos;
/* 2890 */     if (jj_3R_115()) this.jj_scanpos = token; 
/* 2891 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_124() {
/* 2895 */     if (jj_scan_token(98)) return true; 
/* 2896 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_123() {
/* 2900 */     if (jj_scan_token(97)) return true; 
/* 2901 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_62() {
/* 2905 */     if (jj_scan_token(88)) return true; 
/* 2906 */     if (jj_3R_64()) return true; 
/* 2907 */     if (jj_scan_token(90)) return true; 
/* 2908 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_122() {
/* 2912 */     if (jj_scan_token(96)) return true; 
/* 2913 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_61() {
/* 2917 */     if (jj_scan_token(85)) return true; 
/* 2918 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_121() {
/* 2922 */     if (jj_scan_token(95)) return true; 
/* 2923 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_132() {
/* 2927 */     if (jj_scan_token(5)) return true; 
/* 2928 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_127() {
/* 2933 */     Token token = this.jj_scanpos;
/* 2934 */     if (jj_3R_132()) {
/* 2935 */       this.jj_scanpos = token;
/* 2936 */       if (jj_3R_133()) return true; 
/*      */     } 
/* 2938 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_120() {
/* 2942 */     if (jj_scan_token(94)) return true; 
/* 2943 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_119() {
/* 2947 */     if (jj_scan_token(92)) return true; 
/* 2948 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_103() {
/* 2953 */     Token token = this.jj_scanpos;
/* 2954 */     if (jj_3R_119()) {
/* 2955 */       this.jj_scanpos = token;
/* 2956 */       if (jj_3R_120()) {
/* 2957 */         this.jj_scanpos = token;
/* 2958 */         if (jj_3R_121()) {
/* 2959 */           this.jj_scanpos = token;
/* 2960 */           if (jj_3R_122()) {
/* 2961 */             this.jj_scanpos = token;
/* 2962 */             if (jj_3R_123()) {
/* 2963 */               this.jj_scanpos = token;
/* 2964 */               if (jj_3R_124()) {
/* 2965 */                 this.jj_scanpos = token;
/* 2966 */                 if (jj_3R_125()) {
/* 2967 */                   this.jj_scanpos = token;
/* 2968 */                   if (jj_3R_126()) return true; 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2976 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_114() {
/* 2980 */     if (jj_scan_token(63)) return true; 
/* 2981 */     if (jj_scan_token(73)) return true; 
/* 2982 */     if (jj_3R_64()) return true; 
/* 2983 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_113() {
/* 2987 */     if (jj_scan_token(63)) return true; 
/* 2988 */     if (jj_scan_token(73)) return true; 
/* 2989 */     if (jj_3R_64()) return true; 
/* 2990 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_104() {
/* 2995 */     Token token = this.jj_scanpos;
/* 2996 */     if (jj_3R_127()) this.jj_scanpos = token; 
/* 2997 */     if (jj_scan_token(88)) return true; 
/* 2998 */     if (jj_3R_77()) return true; 
/* 2999 */     if (jj_scan_token(90)) return true; 
/* 3000 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_60() {
/* 3004 */     if (jj_scan_token(86)) return true; 
/* 3005 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_59() {
/* 3009 */     if (jj_scan_token(76)) return true; 
/* 3010 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_100() {
/* 3015 */     Token token = this.jj_scanpos;
/* 3016 */     if (jj_3R_113()) this.jj_scanpos = token; 
/* 3017 */     if (jj_scan_token(18)) return true; 
/* 3018 */     if (jj_scan_token(14)) return true; 
/* 3019 */     if (jj_3R_64()) return true; 
/* 3020 */     token = this.jj_scanpos;
/* 3021 */     if (jj_3R_114()) this.jj_scanpos = token; 
/* 3022 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_58() {
/* 3026 */     if (jj_3R_63()) return true; 
/* 3027 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_29() {
/* 3031 */     if (jj_scan_token(82)) return true; 
/* 3032 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_17() {
/* 3037 */     Token token = this.jj_scanpos;
/* 3038 */     if (jj_3R_29()) {
/* 3039 */       this.jj_scanpos = token;
/* 3040 */       if (jj_3R_30()) return true; 
/*      */     } 
/* 3042 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_15() {
/* 3046 */     if (jj_3R_28()) return true; 
/* 3047 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_26() {
/* 3051 */     if (jj_scan_token(5)) return true; 
/* 3052 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_12() {
/* 3056 */     if (jj_3R_24()) return true; 
/* 3057 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_92() {
/* 3061 */     if (jj_3R_103()) return true;
/*      */     
/* 3063 */     Token token = this.jj_scanpos;
/* 3064 */     if (jj_3R_104()) {
/* 3065 */       this.jj_scanpos = token;
/* 3066 */       if (jj_3R_105()) return true; 
/*      */     } 
/* 3068 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_99() {
/* 3072 */     if (jj_scan_token(72)) return true; 
/* 3073 */     if (jj_3R_64()) return true; 
/* 3074 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_14() {
/* 3078 */     if (jj_3R_25()) return true; 
/* 3079 */     if (jj_scan_token(88)) return true;
/*      */     
/* 3081 */     Token token = this.jj_scanpos;
/* 3082 */     if (jj_3R_26()) {
/* 3083 */       this.jj_scanpos = token;
/* 3084 */       if (jj_3R_27()) return true; 
/*      */     } 
/* 3086 */     if (jj_3R_63()) return true; 
/* 3087 */     if (jj_scan_token(90)) return true; 
/* 3088 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_69() {
/* 3092 */     if (jj_scan_token(93)) return true; 
/* 3093 */     if (jj_3R_17()) return true; 
/* 3094 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_65() {
/* 3098 */     if (jj_scan_token(93)) return true; 
/* 3099 */     if (jj_3R_17()) return true;
/*      */     
/* 3101 */     Token token = this.jj_scanpos;
/* 3102 */     if (jj_3R_69()) this.jj_scanpos = token; 
/* 3103 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_13() {
/* 3107 */     if (jj_scan_token(19)) return true; 
/* 3108 */     if (jj_scan_token(88)) return true; 
/* 3109 */     if (jj_scan_token(103)) return true; 
/* 3110 */     if (jj_scan_token(90)) return true; 
/* 3111 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_63() {
/* 3115 */     if (jj_3R_17()) return true;
/*      */     
/* 3117 */     Token token = this.jj_scanpos;
/* 3118 */     if (jj_3R_65()) this.jj_scanpos = token; 
/* 3119 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_57() {
/* 3123 */     if (jj_3R_24()) return true; 
/* 3124 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_112() {
/* 3128 */     if (jj_scan_token(82)) return true; 
/* 3129 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_55() {
/* 3134 */     Token token = this.jj_scanpos;
/* 3135 */     if (jj_3R_56()) {
/* 3136 */       this.jj_scanpos = token;
/* 3137 */       if (jj_3R_57()) {
/* 3138 */         this.jj_scanpos = token;
/* 3139 */         if (jj_3_13()) {
/* 3140 */           this.jj_scanpos = token;
/* 3141 */           if (jj_3_14()) {
/* 3142 */             this.jj_scanpos = token;
/* 3143 */             if (jj_3_15()) {
/* 3144 */               this.jj_scanpos = token;
/* 3145 */               if (jj_3R_58()) {
/* 3146 */                 this.jj_scanpos = token;
/* 3147 */                 if (jj_3R_59()) {
/* 3148 */                   this.jj_scanpos = token;
/* 3149 */                   if (jj_3R_60()) {
/* 3150 */                     this.jj_scanpos = token;
/* 3151 */                     if (jj_3R_61()) {
/* 3152 */                       this.jj_scanpos = token;
/* 3153 */                       if (jj_3R_62()) return true; 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 3163 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_56() {
/* 3167 */     if (jj_scan_token(47)) return true; 
/* 3168 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_73() {
/* 3172 */     if (jj_scan_token(89)) return true; 
/* 3173 */     if (jj_3R_36()) return true; 
/* 3174 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_97() {
/* 3178 */     if (jj_3R_111()) return true;
/*      */     
/* 3180 */     Token token = this.jj_scanpos;
/* 3181 */     if (jj_3R_112()) this.jj_scanpos = token; 
/* 3182 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_70() {
/* 3186 */     if (jj_3R_36()) return true;
/*      */     
/*      */     while (true) {
/* 3189 */       Token token = this.jj_scanpos;
/* 3190 */       if (jj_3R_73()) { this.jj_scanpos = token;
/*      */         
/* 3192 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_98() {
/* 3196 */     if (jj_scan_token(89)) return true; 
/* 3197 */     if (jj_3R_97()) return true; 
/* 3198 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_87() {
/* 3202 */     if (jj_scan_token(29)) return true; 
/* 3203 */     if (jj_3R_97()) return true;
/*      */     
/*      */     while (true) {
/* 3206 */       Token token = this.jj_scanpos;
/* 3207 */       if (jj_3R_98()) { this.jj_scanpos = token;
/*      */         
/* 3209 */         return false; }
/*      */     
/*      */     } 
/*      */   } private boolean jj_3R_84() {
/* 3213 */     if (jj_3R_93()) return true; 
/* 3214 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_10() {
/* 3218 */     if (jj_3R_22()) return true; 
/* 3219 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_9() {
/* 3223 */     if (jj_3R_21()) return true; 
/* 3224 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_8() {
/* 3228 */     if (jj_3R_20()) return true; 
/* 3229 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_54() {
/* 3234 */     Token token = this.jj_scanpos;
/* 3235 */     if (jj_scan_token(101)) {
/* 3236 */       this.jj_scanpos = token;
/* 3237 */       if (jj_scan_token(102)) return true; 
/*      */     } 
/* 3239 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_83() {
/* 3243 */     if (jj_3R_92()) return true; 
/* 3244 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_80() {
/* 3249 */     Token token = this.jj_scanpos;
/* 3250 */     if (jj_3R_83()) {
/* 3251 */       this.jj_scanpos = token;
/* 3252 */       if (jj_3_8()) {
/* 3253 */         this.jj_scanpos = token;
/* 3254 */         if (jj_3_9()) {
/* 3255 */           this.jj_scanpos = token;
/* 3256 */           if (jj_3_10()) {
/* 3257 */             this.jj_scanpos = token;
/* 3258 */             if (jj_3R_84()) return true; 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 3263 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_51() {
/* 3268 */     Token token = this.jj_scanpos;
/* 3269 */     if (jj_3R_54()) this.jj_scanpos = token; 
/* 3270 */     if (jj_3R_55()) return true; 
/* 3271 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_4() {
/* 3275 */     if (jj_3R_17()) return true; 
/* 3276 */     if (jj_scan_token(93)) return true; 
/* 3277 */     if (jj_3R_17()) return true; 
/* 3278 */     if (jj_scan_token(104)) return true; 
/* 3279 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_3() {
/* 3283 */     if (jj_3R_17()) return true; 
/* 3284 */     if (jj_scan_token(104)) return true; 
/* 3285 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_16() {
/* 3290 */     Token token = this.jj_scanpos;
/* 3291 */     if (jj_3_3()) {
/* 3292 */       this.jj_scanpos = token;
/* 3293 */       if (jj_3_4()) return true; 
/*      */     } 
/* 3295 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_82() {
/* 3299 */     if (jj_scan_token(53)) return true; 
/* 3300 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3_7() {
/* 3304 */     if (jj_scan_token(88)) return true; 
/* 3305 */     if (jj_3R_19()) return true; 
/* 3306 */     if (jj_scan_token(89)) return true; 
/* 3307 */     return false;
/*      */   }
/*      */   
/*      */   private boolean jj_3R_136() {
/* 3311 */     if (jj_scan_token(87)) return true; 
/* 3312 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean jj_3R_79() {
/* 3317 */     Token token = this.jj_scanpos;
/* 3318 */     if (jj_3R_82()) this.jj_scanpos = token; 
/* 3319 */     if (jj_3R_19()) return true; 
/* 3320 */     return false;
/*      */   }
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
/*      */   
/* 3334 */   private final int[] jj_la1 = new int[101]; private static int[] jj_la1_0;
/*      */   private static int[] jj_la1_1;
/*      */   private static int[] jj_la1_2;
/*      */   private static int[] jj_la1_3;
/*      */   
/*      */   static {
/* 3340 */     jj_la1_init_0();
/* 3341 */     jj_la1_init_1();
/* 3342 */     jj_la1_init_2();
/* 3343 */     jj_la1_init_3();
/*      */   }
/*      */   private static void jj_la1_init_0() {
/* 3346 */     jj_la1_0 = new int[] { 134250496, 0, 0, 135311360, 69337088, 67108864, 69337088, 0, 65536, 0, 0, 0, 65536, 0, 16777216, 0, 0, 16777216, 0, 0, 0, 34079744, 0, 0, 0, 536870912, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268435456, 8388640, 8388640, 0, 262144, 1073741824, 0, 0, 525312, 256, 525312, 256, 0, 0, 0, 0, 0, 0, Integer.MIN_VALUE, 32, 0, 0, 4194816, 4194816, 0, 4194816, 4194816, 0, 0, 0, 64, 0, 525312, 0, 0, 525312, 0, 0, 2048, 0, 160, 160, 0, 525312, 525312, 0, 525312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388640, 0, 0, 525312, 525312, 525312, 0, 0 };
/*      */   }
/*      */   private static void jj_la1_init_1() {
/* 3349 */     jj_la1_1 = new int[] { 16846852, 0, 0, 16846852, 440402050, 4194304, 440402050, 0, 0, 0, 16384, 0, 0, 262144, 536870912, 67108864, 67108864, 603979776, 0, 0, 0, 2138880, 0, 0, 134217728, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048576, 0, 0, 0, 0, Integer.MIN_VALUE, 0, 1032, 0, 33536, 0, 33536, 0, 0, 0, 0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0, 1032, 134217728, 0, 0, 0, 0, 0, 0, 131072, 524288, 0, 8192, 2138880, 8192, 2097152, 2130688, 0, 32, 8289, 0, 0, 0, 2097152, 2130688, 33536, 8192, 134251264, 8192, 8192, 8192, 0, 0, 0, 0, 0, 0, 0, 0, 32768, 0, 768, 768, 33536, 0, 0 };
/*      */   }
/*      */   private static void jj_la1_init_2() {
/* 3352 */     jj_la1_2 = new int[] { 192, 33554432, 16777216, 192, 16, 0, 16, 1024, 0, 33554432, 0, 1024, 0, 2048, 0, 16, 16, 0, 262144, 256, 33554432, 31723521, 33554432, 16777216, 32, 0, 256, 536870912, 536870912, 8650752, -805306368, 536870912, 0, 0, 266240, 0, 0, 0, 0, 256, 0, 0, 8, 33554432, 31723521, 8650752, 31723521, 0, 262144, 8650752, 33554432, 262144, 0, 0, 0, 0, 8, 0, 0, 0, 33554432, 0, 0, 33554432, 0, 0, 0, 0, 31723521, 0, 0, 31723521, -805306368, 0, -805306368, 33554432, 0, 0, 0, 31723521, 31723521, 0, 31723521, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31723520, 1, 262145, 31723521, 536870912, 536870912 };
/*      */   }
/*      */   private static void jj_la1_init_3() {
/* 3355 */     jj_la1_3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 608, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 96, 96, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 224, 0, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 96, 0, 0, 96, 31, 0, 31, 0, 0, 0, 0, 608, 608, 0, 608, 0, 0, 0, 1120, 1120, 2176, 2176, 4096, 96, 96, 0, 0, 0, 0, 0, 608, 0, 0 };
/*      */   }
/* 3357 */   private final JJCalls[] jj_2_rtns = new JJCalls[15];
/*      */   private boolean jj_rescan = false;
/* 3359 */   private int jj_gc = 0; private final LookaheadSuccess jj_ls; private List jj_expentries; private int[] jj_expentry; private int jj_kind; private int[] jj_lasttokens;
/*      */   private int jj_endpos;
/*      */   
/*      */   public ZqlJJParser(InputStream paramInputStream) {
/* 3363 */     this(paramInputStream, null);
/*      */   }
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
/*      */   
/*      */   public void ReInit(InputStream paramInputStream) {
/* 3378 */     ReInit(paramInputStream, null);
/*      */   }
/*      */   public void ReInit(InputStream paramInputStream, String paramString) {
/*      */     
/* 3382 */     try { this.jj_input_stream.ReInit(paramInputStream, paramString, 1, 1); } catch (UnsupportedEncodingException unsupportedEncodingException) { throw new RuntimeException(unsupportedEncodingException); }
/* 3383 */      this.token_source.ReInit(this.jj_input_stream);
/* 3384 */     this.token = new Token();
/* 3385 */     this.jj_ntk = -1;
/* 3386 */     this.jj_gen = 0; byte b;
/* 3387 */     for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }
/* 3388 */      for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }
/*      */   
/*      */   }
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
/*      */   
/*      */   public void ReInit(Reader paramReader) {
/* 3404 */     this.jj_input_stream.ReInit(paramReader, 1, 1);
/* 3405 */     this.token_source.ReInit(this.jj_input_stream);
/* 3406 */     this.token = new Token();
/* 3407 */     this.jj_ntk = -1;
/* 3408 */     this.jj_gen = 0; byte b;
/* 3409 */     for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }
/* 3410 */      for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }
/*      */   
/*      */   }
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
/*      */   public void ReInit(ZqlJJParserTokenManager paramZqlJJParserTokenManager) {
/* 3425 */     this.token_source = paramZqlJJParserTokenManager;
/* 3426 */     this.token = new Token();
/* 3427 */     this.jj_ntk = -1;
/* 3428 */     this.jj_gen = 0; byte b;
/* 3429 */     for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }
/* 3430 */      for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }
/*      */   
/*      */   }
/*      */   private Token jj_consume_token(int paramInt) throws ParseException {
/*      */     Token token;
/* 3435 */     if ((token = this.token).next != null) { this.token = this.token.next; }
/* 3436 */     else { this.token = this.token.next = this.token_source.getNextToken(); }
/* 3437 */      this.jj_ntk = -1;
/* 3438 */     if (this.token.kind == paramInt) {
/* 3439 */       this.jj_gen++;
/* 3440 */       if (++this.jj_gc > 100) {
/* 3441 */         this.jj_gc = 0;
/* 3442 */         for (byte b = 0; b < this.jj_2_rtns.length; b++) {
/* 3443 */           JJCalls jJCalls = this.jj_2_rtns[b];
/* 3444 */           while (jJCalls != null) {
/* 3445 */             if (jJCalls.gen < this.jj_gen) jJCalls.first = null; 
/* 3446 */             jJCalls = jJCalls.next;
/*      */           } 
/*      */         } 
/*      */       } 
/* 3450 */       return this.token;
/*      */     } 
/* 3452 */     this.token = token;
/* 3453 */     this.jj_kind = paramInt;
/* 3454 */     throw generateParseException();
/*      */   }
/*      */   private static final class LookaheadSuccess extends Error {
/*      */     private LookaheadSuccess() {} }
/* 3458 */   public ZqlJJParser(InputStream paramInputStream, String paramString) { this.jj_ls = new LookaheadSuccess();
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3507 */     this.jj_expentries = new ArrayList();
/*      */     
/* 3509 */     this.jj_kind = -1;
/* 3510 */     this.jj_lasttokens = new int[100]; try { this.jj_input_stream = new SimpleCharStream(paramInputStream, paramString, 1, 1); } catch (UnsupportedEncodingException unsupportedEncodingException) { throw new RuntimeException(unsupportedEncodingException); }  this.token_source = new ZqlJJParserTokenManager(this.jj_input_stream); this.token = new Token(); this.jj_ntk = -1; this.jj_gen = 0; byte b; for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }  for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }  } public ZqlJJParser(Reader paramReader) { this.jj_ls = new LookaheadSuccess(); this.jj_expentries = new ArrayList(); this.jj_kind = -1; this.jj_lasttokens = new int[100]; this.jj_input_stream = new SimpleCharStream(paramReader, 1, 1); this.token_source = new ZqlJJParserTokenManager(this.jj_input_stream); this.token = new Token(); this.jj_ntk = -1; this.jj_gen = 0; byte b; for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }  for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }  } public ZqlJJParser(ZqlJJParserTokenManager paramZqlJJParserTokenManager) { this.jj_ls = new LookaheadSuccess(); this.jj_expentries = new ArrayList(); this.jj_kind = -1; this.jj_lasttokens = new int[100]; this.token_source = paramZqlJJParserTokenManager; this.token = new Token(); this.jj_ntk = -1; this.jj_gen = 0; byte b; for (b = 0; b < 101; ) { this.jj_la1[b] = -1; b++; }  for (b = 0; b < this.jj_2_rtns.length; ) { this.jj_2_rtns[b] = new JJCalls(); b++; }  }
/*      */   private boolean jj_scan_token(int paramInt) { if (this.jj_scanpos == this.jj_lastpos) { this.jj_la--; if (this.jj_scanpos.next == null) { this.jj_lastpos = this.jj_scanpos = this.jj_scanpos.next = this.token_source.getNextToken(); } else { this.jj_lastpos = this.jj_scanpos = this.jj_scanpos.next; }  } else { this.jj_scanpos = this.jj_scanpos.next; }  if (this.jj_rescan) { byte b = 0; Token token = this.token; while (token != null && token != this.jj_scanpos) { b++; token = token.next; }  if (token != null)
/*      */         jj_add_error_token(paramInt, b);  }  if (this.jj_scanpos.kind != paramInt)
/*      */       return true;  if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos)
/* 3514 */       throw this.jj_ls;  return false; } private void jj_add_error_token(int paramInt1, int paramInt2) { if (paramInt2 >= 100)
/* 3515 */       return;  if (paramInt2 == this.jj_endpos + 1)
/* 3516 */     { this.jj_lasttokens[this.jj_endpos++] = paramInt1; }
/* 3517 */     else if (this.jj_endpos != 0)
/* 3518 */     { this.jj_expentry = new int[this.jj_endpos];
/* 3519 */       for (byte b = 0; b < this.jj_endpos; b++) {
/* 3520 */         this.jj_expentry[b] = this.jj_lasttokens[b];
/*      */       }
/* 3522 */       label31: for (int[] arrayOfInt : this.jj_expentries) {
/*      */         
/* 3524 */         if (arrayOfInt.length == this.jj_expentry.length) {
/* 3525 */           for (byte b1 = 0; b1 < this.jj_expentry.length; b1++) {
/* 3526 */             if (arrayOfInt[b1] != this.jj_expentry[b1]) {
/*      */               continue label31;
/*      */             }
/*      */           } 
/* 3530 */           this.jj_expentries.add(this.jj_expentry);
/*      */           break;
/*      */         } 
/*      */       } 
/* 3534 */       if (paramInt2 != 0) this.jj_lasttokens[(this.jj_endpos = paramInt2) - 1] = paramInt1;  }  }
/*      */   public final Token getNextToken() { if (this.token.next != null) { this.token = this.token.next; } else { this.token = this.token.next = this.token_source.getNextToken(); }  this.jj_ntk = -1; this.jj_gen++; return this.token; }
/*      */   public final Token getToken(int paramInt) { Token token = this.token; for (byte b = 0; b < paramInt; b++) { if (token.next != null) { token = token.next; } else { token = token.next = this.token_source.getNextToken(); }
/*      */        }
/*      */      return token; }
/*      */   private int jj_ntk() { if ((this.jj_nt = this.token.next) == null)
/* 3540 */       return this.jj_ntk = (this.token.next = this.token_source.getNextToken()).kind;  return this.jj_ntk = this.jj_nt.kind; } public ParseException generateParseException() { this.jj_expentries.clear();
/* 3541 */     boolean[] arrayOfBoolean = new boolean[109];
/* 3542 */     if (this.jj_kind >= 0) {
/* 3543 */       arrayOfBoolean[this.jj_kind] = true;
/* 3544 */       this.jj_kind = -1;
/*      */     }  byte b1;
/* 3546 */     for (b1 = 0; b1 < 101; b1++) {
/* 3547 */       if (this.jj_la1[b1] == this.jj_gen) {
/* 3548 */         for (byte b = 0; b < 32; b++) {
/* 3549 */           if ((jj_la1_0[b1] & 1 << b) != 0) {
/* 3550 */             arrayOfBoolean[b] = true;
/*      */           }
/* 3552 */           if ((jj_la1_1[b1] & 1 << b) != 0) {
/* 3553 */             arrayOfBoolean[32 + b] = true;
/*      */           }
/* 3555 */           if ((jj_la1_2[b1] & 1 << b) != 0) {
/* 3556 */             arrayOfBoolean[64 + b] = true;
/*      */           }
/* 3558 */           if ((jj_la1_3[b1] & 1 << b) != 0) {
/* 3559 */             arrayOfBoolean[96 + b] = true;
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/* 3564 */     for (b1 = 0; b1 < 109; b1++) {
/* 3565 */       if (arrayOfBoolean[b1]) {
/* 3566 */         this.jj_expentry = new int[1];
/* 3567 */         this.jj_expentry[0] = b1;
/* 3568 */         this.jj_expentries.add(this.jj_expentry);
/*      */       } 
/*      */     } 
/* 3571 */     this.jj_endpos = 0;
/* 3572 */     jj_rescan_token();
/* 3573 */     jj_add_error_token(0, 0);
/* 3574 */     int[][] arrayOfInt = new int[this.jj_expentries.size()][];
/* 3575 */     for (byte b2 = 0; b2 < this.jj_expentries.size(); b2++) {
/* 3576 */       arrayOfInt[b2] = this.jj_expentries.get(b2);
/*      */     }
/* 3578 */     return new ParseException(this.token, arrayOfInt, tokenImage); }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void enable_tracing() {}
/*      */ 
/*      */   
/*      */   public final void disable_tracing() {}
/*      */ 
/*      */   
/*      */   private void jj_rescan_token() {
/* 3590 */     this.jj_rescan = true;
/* 3591 */     for (byte b = 0; b < 15; b++) {
/*      */       try {
/* 3593 */         JJCalls jJCalls = this.jj_2_rtns[b];
/*      */         do {
/* 3595 */           if (jJCalls.gen > this.jj_gen) {
/* 3596 */             this.jj_la = jJCalls.arg; this.jj_lastpos = this.jj_scanpos = jJCalls.first;
/* 3597 */             switch (b) { case 0:
/* 3598 */                 jj_3_1(); break;
/* 3599 */               case 1: jj_3_2(); break;
/* 3600 */               case 2: jj_3_3(); break;
/* 3601 */               case 3: jj_3_4(); break;
/* 3602 */               case 4: jj_3_5(); break;
/* 3603 */               case 5: jj_3_6(); break;
/* 3604 */               case 6: jj_3_7(); break;
/* 3605 */               case 7: jj_3_8(); break;
/* 3606 */               case 8: jj_3_9(); break;
/* 3607 */               case 9: jj_3_10(); break;
/* 3608 */               case 10: jj_3_11(); break;
/* 3609 */               case 11: jj_3_12(); break;
/* 3610 */               case 12: jj_3_13(); break;
/* 3611 */               case 13: jj_3_14(); break;
/* 3612 */               case 14: jj_3_15(); break; }
/*      */           
/*      */           } 
/* 3615 */           jJCalls = jJCalls.next;
/* 3616 */         } while (jJCalls != null);
/* 3617 */       } catch (LookaheadSuccess lookaheadSuccess) {}
/*      */     } 
/* 3619 */     this.jj_rescan = false;
/*      */   }
/*      */   
/*      */   private void jj_save(int paramInt1, int paramInt2) {
/* 3623 */     JJCalls jJCalls = this.jj_2_rtns[paramInt1];
/* 3624 */     while (jJCalls.gen > this.jj_gen) {
/* 3625 */       if (jJCalls.next == null) { jJCalls = jJCalls.next = new JJCalls(); break; }
/* 3626 */        jJCalls = jJCalls.next;
/*      */     } 
/* 3628 */     jJCalls.gen = this.jj_gen + paramInt2 - this.jj_la; jJCalls.first = this.token; jJCalls.arg = paramInt2;
/*      */   }
/*      */   
/*      */   static final class JJCalls {
/*      */     int gen;
/*      */     Token first;
/*      */     int arg;
/*      */     JJCalls next;
/*      */   }
/*      */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZqlJJParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */