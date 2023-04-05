/*     */ package Zql;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.sql.SQLException;
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
/*     */ public class ZEval
/*     */ {
/*     */   public boolean eval(ZTuple paramZTuple, ZExp paramZExp) throws SQLException {
/*  23 */     if (paramZTuple == null || paramZExp == null) {
/*  24 */       throw new SQLException("ZEval.eval(): null argument or operator");
/*     */     }
/*  26 */     if (!(paramZExp instanceof ZExpression)) {
/*  27 */       throw new SQLException("ZEval.eval(): only expressions are supported");
/*     */     }
/*  29 */     ZExpression zExpression = (ZExpression)paramZExp;
/*  30 */     String str = zExpression.getOperator();
/*     */     
/*  32 */     if (str.equals("AND")) {
/*  33 */       boolean bool = true;
/*  34 */       for (byte b = 0; b < zExpression.nbOperands(); b++) {
/*  35 */         bool &= eval(paramZTuple, zExpression.getOperand(b));
/*     */       }
/*  37 */       return bool;
/*  38 */     }  if (str.equals("OR")) {
/*  39 */       boolean bool = false;
/*  40 */       for (byte b = 0; b < zExpression.nbOperands(); b++) {
/*  41 */         bool |= eval(paramZTuple, zExpression.getOperand(b));
/*     */       }
/*  43 */       return bool;
/*  44 */     }  if (str.equals("NOT")) {
/*  45 */       return !eval(paramZTuple, zExpression.getOperand(0));
/*     */     }
/*  47 */     if (str.equals("="))
/*  48 */       return (evalCmp(paramZTuple, zExpression.getOperands()) == 0.0D); 
/*  49 */     if (str.equals("!="))
/*  50 */       return (evalCmp(paramZTuple, zExpression.getOperands()) != 0.0D); 
/*  51 */     if (str.equals("<>"))
/*  52 */       return (evalCmp(paramZTuple, zExpression.getOperands()) != 0.0D); 
/*  53 */     if (str.equals("#"))
/*  54 */       throw new SQLException("ZEval.eval(): Operator # not supported"); 
/*  55 */     if (str.equals(">"))
/*  56 */       return (evalCmp(paramZTuple, zExpression.getOperands()) > 0.0D); 
/*  57 */     if (str.equals(">="))
/*  58 */       return (evalCmp(paramZTuple, zExpression.getOperands()) >= 0.0D); 
/*  59 */     if (str.equals("<"))
/*  60 */       return (evalCmp(paramZTuple, zExpression.getOperands()) < 0.0D); 
/*  61 */     if (str.equals("<=")) {
/*  62 */       return (evalCmp(paramZTuple, zExpression.getOperands()) <= 0.0D);
/*     */     }
/*  64 */     if (str.equals("BETWEEN") || str.equals("NOT BETWEEN")) {
/*     */ 
/*     */       
/*  67 */       ZExpression zExpression1 = new ZExpression("AND", new ZExpression(">=", zExpression.getOperand(0), zExpression.getOperand(1)), new ZExpression("<=", zExpression.getOperand(0), zExpression.getOperand(2)));
/*     */ 
/*     */ 
/*     */       
/*  71 */       if (str.equals("NOT BETWEEN")) {
/*  72 */         return !eval(paramZTuple, zExpression1);
/*     */       }
/*  74 */       return eval(paramZTuple, zExpression1);
/*     */     } 
/*  76 */     if (str.equals("LIKE") || str.equals("NOT LIKE")) {
/*  77 */       throw new SQLException("ZEval.eval(): Operator (NOT) LIKE not supported");
/*     */     }
/*  79 */     if (str.equals("IN") || str.equals("NOT IN")) {
/*     */       
/*  81 */       ZExpression zExpression1 = new ZExpression("OR");
/*     */       
/*  83 */       for (byte b = 1; b < zExpression.nbOperands(); b++) {
/*  84 */         zExpression1.addOperand(new ZExpression("=", zExpression.getOperand(0), zExpression.getOperand(b)));
/*     */       }
/*     */ 
/*     */       
/*  88 */       if (str.equals("NOT IN")) {
/*  89 */         return !eval(paramZTuple, zExpression1);
/*     */       }
/*  91 */       return eval(paramZTuple, zExpression1);
/*     */     } 
/*  93 */     if (str.equals("IS NULL")) {
/*     */       
/*  95 */       if (zExpression.nbOperands() <= 0 || zExpression.getOperand(0) == null) return true; 
/*  96 */       ZExp zExp = zExpression.getOperand(0);
/*  97 */       if (zExp instanceof ZConstant) {
/*  98 */         return (((ZConstant)zExp).getType() == 1);
/*     */       }
/* 100 */       throw new SQLException("ZEval.eval(): can't eval IS (NOT) NULL");
/*     */     } 
/*     */     
/* 103 */     if (str.equals("IS NOT NULL")) {
/*     */       
/* 105 */       ZExpression zExpression1 = new ZExpression("IS NULL");
/* 106 */       zExpression1.setOperands(zExpression.getOperands());
/* 107 */       return !eval(paramZTuple, zExpression1);
/*     */     } 
/*     */     
/* 110 */     throw new SQLException("ZEval.eval(): Unknown operator " + str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double evalCmp(ZTuple paramZTuple, Vector paramVector) throws SQLException {
/* 117 */     if (paramVector.size() < 2) {
/* 118 */       throw new SQLException("ZEval.evalCmp(): Trying to compare less than two values");
/*     */     }
/*     */     
/* 121 */     if (paramVector.size() > 2) {
/* 122 */       throw new SQLException("ZEval.evalCmp(): Trying to compare more than two values");
/*     */     }
/*     */ 
/*     */     
/* 126 */     Object object1 = null, object2 = null;
/*     */     
/* 128 */     object1 = evalExpValue(paramZTuple, paramVector.elementAt(0));
/* 129 */     object2 = evalExpValue(paramZTuple, paramVector.elementAt(1));
/*     */     
/* 131 */     if (object1 instanceof String || object2 instanceof String) {
/* 132 */       return (object1.equals(object2) ? false : -1);
/*     */     }
/*     */     
/* 135 */     if (object1 instanceof Number && object2 instanceof Number) {
/* 136 */       return ((Number)object1).doubleValue() - ((Number)object2).doubleValue();
/*     */     }
/* 138 */     throw new SQLException("ZEval.evalCmp(): can't compare (" + object1.toString() + ") with (" + object2.toString() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double evalNumericExp(ZTuple paramZTuple, ZExpression paramZExpression) throws SQLException {
/* 146 */     if (paramZTuple == null || paramZExpression == null || paramZExpression.getOperator() == null) {
/* 147 */       throw new SQLException("ZEval.eval(): null argument or operator");
/*     */     }
/*     */     
/* 150 */     String str = paramZExpression.getOperator();
/*     */     
/* 152 */     Object object = evalExpValue(paramZTuple, paramZExpression.getOperand(0));
/* 153 */     if (!(object instanceof Double))
/* 154 */       throw new SQLException("ZEval.evalNumericExp(): expression not numeric"); 
/* 155 */     Double double_ = (Double)object;
/*     */     
/* 157 */     if (str.equals("+")) {
/*     */       
/* 159 */       double d = double_.doubleValue();
/* 160 */       for (byte b = 1; b < paramZExpression.nbOperands(); b++) {
/* 161 */         Object object1 = evalExpValue(paramZTuple, paramZExpression.getOperand(b));
/* 162 */         d += ((Number)object1).doubleValue();
/*     */       } 
/* 164 */       return d;
/*     */     } 
/* 166 */     if (str.equals("-")) {
/*     */       
/* 168 */       double d = double_.doubleValue();
/* 169 */       if (paramZExpression.nbOperands() == 1) return -d; 
/* 170 */       for (byte b = 1; b < paramZExpression.nbOperands(); b++) {
/* 171 */         Object object1 = evalExpValue(paramZTuple, paramZExpression.getOperand(b));
/* 172 */         d -= ((Number)object1).doubleValue();
/*     */       } 
/* 174 */       return d;
/*     */     } 
/* 176 */     if (str.equals("*")) {
/*     */       
/* 178 */       double d = double_.doubleValue();
/* 179 */       for (byte b = 1; b < paramZExpression.nbOperands(); b++) {
/* 180 */         Object object1 = evalExpValue(paramZTuple, paramZExpression.getOperand(b));
/* 181 */         d *= ((Number)object1).doubleValue();
/*     */       } 
/* 183 */       return d;
/*     */     } 
/* 185 */     if (str.equals("/")) {
/*     */       
/* 187 */       double d = double_.doubleValue();
/* 188 */       for (byte b = 1; b < paramZExpression.nbOperands(); b++) {
/* 189 */         Object object1 = evalExpValue(paramZTuple, paramZExpression.getOperand(b));
/* 190 */         d /= ((Number)object1).doubleValue();
/*     */       } 
/* 192 */       return d;
/*     */     } 
/* 194 */     if (str.equals("**")) {
/*     */       
/* 196 */       double d = double_.doubleValue();
/* 197 */       for (byte b = 1; b < paramZExpression.nbOperands(); b++) {
/* 198 */         Object object1 = evalExpValue(paramZTuple, paramZExpression.getOperand(b));
/* 199 */         d = Math.pow(d, ((Number)object1).doubleValue());
/*     */       } 
/* 201 */       return d;
/*     */     } 
/*     */     
/* 204 */     throw new SQLException("ZEval.evalNumericExp(): Unknown operator " + str);
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
/*     */   public Object evalExpValue(ZTuple paramZTuple, ZExp paramZExp) throws SQLException {
/* 217 */     Double double_ = null;
/*     */     
/* 219 */     if (paramZExp instanceof ZConstant)
/*     */     { Object object2;
/* 221 */       ZConstant zConstant = (ZConstant)paramZExp;
/*     */       
/* 223 */       switch (zConstant.getType())
/*     */       
/*     */       { 
/*     */         case 0:
/* 227 */           object2 = paramZTuple.getAttValue(zConstant.getValue());
/* 228 */           if (object2 == null) {
/* 229 */             throw new SQLException("ZEval.evalExpValue(): unknown column " + zConstant.getValue());
/*     */           }
/*     */           try {
/* 232 */             double_ = new Double(object2.toString());
/* 233 */           } catch (NumberFormatException numberFormatException) {
/* 234 */             object1 = object2;
/*     */           } 
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
/* 250 */           return object1;case 2: object1 = new Double(zConstant.getValue()); return object1; }  Object object1 = zConstant.getValue(); } else if (paramZExp instanceof ZExpression) { double_ = new Double(evalNumericExp(paramZTuple, (ZExpression)paramZExp)); }  return double_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     try {
/* 257 */       BufferedReader bufferedReader = new BufferedReader(new FileReader("test.db"));
/* 258 */       String str = bufferedReader.readLine();
/* 259 */       ZTuple zTuple = new ZTuple(str);
/*     */       
/* 261 */       ZqlParser zqlParser = new ZqlParser();
/* 262 */       ZEval zEval = new ZEval();
/*     */       
/* 264 */       while ((str = bufferedReader.readLine()) != null) {
/* 265 */         zTuple.setRow(str);
/* 266 */         BufferedReader bufferedReader1 = new BufferedReader(new FileReader("test.sql"));
/*     */         String str1;
/* 268 */         while ((str1 = bufferedReader1.readLine()) != null) {
/* 269 */           zqlParser.initParser(new ByteArrayInputStream(str1.getBytes()));
/* 270 */           ZExp zExp = zqlParser.readExpression();
/* 271 */           System.out.print(str + ", " + str1 + ", ");
/* 272 */           System.out.println(zEval.eval(zTuple, zExp));
/*     */         } 
/* 274 */         bufferedReader1.close();
/*     */       } 
/* 276 */       bufferedReader.close();
/* 277 */     } catch (Exception exception) {
/* 278 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZEval.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */