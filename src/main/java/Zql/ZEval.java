//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zql;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Vector;

public class ZEval {
    public ZEval() {
    }

    public boolean eval(ZTuple var1, ZExp var2) throws SQLException {
        if (var1 != null && var2 != null) {
            if (!(var2 instanceof ZExpression)) {
                throw new SQLException("ZEval.eval(): only expressions are supported");
            } else {
                ZExpression var3 = (ZExpression)var2;
                String var4 = var3.getOperator();
                int var6;
                boolean var8;
                if (var4.equals("AND")) {
                    var8 = true;

                    for(var6 = 0; var6 < var3.nbOperands(); ++var6) {
                        var8 &= this.eval(var1, var3.getOperand(var6));
                    }

                    return var8;
                } else if (var4.equals("OR")) {
                    var8 = false;

                    for(var6 = 0; var6 < var3.nbOperands(); ++var6) {
                        var8 |= this.eval(var1, var3.getOperand(var6));
                    }

                    return var8;
                } else if (var4.equals("NOT")) {
                    return !this.eval(var1, var3.getOperand(0));
                } else if (var4.equals("=")) {
                    return this.evalCmp(var1, var3.getOperands()) == 0.0D;
                } else if (var4.equals("!=")) {
                    return this.evalCmp(var1, var3.getOperands()) != 0.0D;
                } else if (var4.equals("<>")) {
                    return this.evalCmp(var1, var3.getOperands()) != 0.0D;
                } else if (var4.equals("#")) {
                    throw new SQLException("ZEval.eval(): Operator # not supported");
                } else if (var4.equals(">")) {
                    return this.evalCmp(var1, var3.getOperands()) > 0.0D;
                } else if (var4.equals(">=")) {
                    return this.evalCmp(var1, var3.getOperands()) >= 0.0D;
                } else if (var4.equals("<")) {
                    return this.evalCmp(var1, var3.getOperands()) < 0.0D;
                } else if (var4.equals("<=")) {
                    return this.evalCmp(var1, var3.getOperands()) <= 0.0D;
                } else {
                    ZExpression var5;
                    if (!var4.equals("BETWEEN") && !var4.equals("NOT BETWEEN")) {
                        if (!var4.equals("LIKE") && !var4.equals("NOT LIKE")) {
                            if (!var4.equals("IN") && !var4.equals("NOT IN")) {
                                if (var4.equals("IS NULL")) {
                                    if (var3.nbOperands() > 0 && var3.getOperand(0) != null) {
                                        ZExp var7 = var3.getOperand(0);
                                        if (var7 instanceof ZConstant) {
                                            return ((ZConstant)var7).getType() == 1;
                                        } else {
                                            throw new SQLException("ZEval.eval(): can't eval IS (NOT) NULL");
                                        }
                                    } else {
                                        return true;
                                    }
                                } else if (var4.equals("IS NOT NULL")) {
                                    var5 = new ZExpression("IS NULL");
                                    var5.setOperands(var3.getOperands());
                                    return !this.eval(var1, var5);
                                } else {
                                    throw new SQLException("ZEval.eval(): Unknown operator " + var4);
                                }
                            } else {
                                var5 = new ZExpression("OR");

                                for(var6 = 1; var6 < var3.nbOperands(); ++var6) {
                                    var5.addOperand(new ZExpression("=", var3.getOperand(0), var3.getOperand(var6)));
                                }

                                if (var4.equals("NOT IN")) {
                                    return !this.eval(var1, var5);
                                } else {
                                    return this.eval(var1, var5);
                                }
                            }
                        } else {
                            throw new SQLException("ZEval.eval(): Operator (NOT) LIKE not supported");
                        }
                    } else {
                        var5 = new ZExpression("AND", new ZExpression(">=", var3.getOperand(0), var3.getOperand(1)), new ZExpression("<=", var3.getOperand(0), var3.getOperand(2)));
                        if (var4.equals("NOT BETWEEN")) {
                            return !this.eval(var1, var5);
                        } else {
                            return this.eval(var1, var5);
                        }
                    }
                }
            }
        } else {
            throw new SQLException("ZEval.eval(): null argument or operator");
        }
    }

    double evalCmp(ZTuple var1, Vector var2) throws SQLException {
        if (var2.size() < 2) {
            throw new SQLException("ZEval.evalCmp(): Trying to compare less than two values");
        } else if (var2.size() > 2) {
            throw new SQLException("ZEval.evalCmp(): Trying to compare more than two values");
        } else {
            Object var3 = null;
            Object var4 = null;
            var3 = this.evalExpValue(var1, (ZExp)var2.elementAt(0));
            var4 = this.evalExpValue(var1, (ZExp)var2.elementAt(1));
            if (!(var3 instanceof String) && !(var4 instanceof String)) {
                if (var3 instanceof Number && var4 instanceof Number) {
                    return ((Number)var3).doubleValue() - ((Number)var4).doubleValue();
                } else {
                    throw new SQLException("ZEval.evalCmp(): can't compare (" + var3.toString() + ") with (" + var4.toString() + ")");
                }
            } else {
                return (double)(var3.equals(var4) ? 0 : -1);
            }
        }
    }

    double evalNumericExp(ZTuple var1, ZExpression var2) throws SQLException {
        if (var1 != null && var2 != null && var2.getOperator() != null) {
            String var3 = var2.getOperator();
            Object var4 = this.evalExpValue(var1, var2.getOperand(0));
            if (!(var4 instanceof Double)) {
                throw new SQLException("ZEval.evalNumericExp(): expression not numeric");
            } else {
                Double var5 = (Double)var4;
                double var6;
                int var8;
                Object var9;
                if (var3.equals("+")) {
                    var6 = var5;

                    for(var8 = 1; var8 < var2.nbOperands(); ++var8) {
                        var9 = this.evalExpValue(var1, var2.getOperand(var8));
                        var6 += ((Number)var9).doubleValue();
                    }

                    return var6;
                } else if (var3.equals("-")) {
                    var6 = var5;
                    if (var2.nbOperands() == 1) {
                        return -var6;
                    } else {
                        for(var8 = 1; var8 < var2.nbOperands(); ++var8) {
                            var9 = this.evalExpValue(var1, var2.getOperand(var8));
                            var6 -= ((Number)var9).doubleValue();
                        }

                        return var6;
                    }
                } else if (var3.equals("*")) {
                    var6 = var5;

                    for(var8 = 1; var8 < var2.nbOperands(); ++var8) {
                        var9 = this.evalExpValue(var1, var2.getOperand(var8));
                        var6 *= ((Number)var9).doubleValue();
                    }

                    return var6;
                } else if (var3.equals("/")) {
                    var6 = var5;

                    for(var8 = 1; var8 < var2.nbOperands(); ++var8) {
                        var9 = this.evalExpValue(var1, var2.getOperand(var8));
                        var6 /= ((Number)var9).doubleValue();
                    }

                    return var6;
                } else if (!var3.equals("**")) {
                    throw new SQLException("ZEval.evalNumericExp(): Unknown operator " + var3);
                } else {
                    var6 = var5;

                    for(var8 = 1; var8 < var2.nbOperands(); ++var8) {
                        var9 = this.evalExpValue(var1, var2.getOperand(var8));
                        var6 = Math.pow(var6, ((Number)var9).doubleValue());
                    }

                    return var6;
                }
            }
        } else {
            throw new SQLException("ZEval.eval(): null argument or operator");
        }
    }

    public Object evalExpValue(ZTuple var1, ZExp var2) throws SQLException {
        Object var3 = null;
        if (var2 instanceof ZConstant) {
            ZConstant var4 = (ZConstant)var2;
            switch(var4.getType()) {
                case 0:
                    Object var5 = var1.getAttValue(var4.getValue());
                    if (var5 == null) {
                        throw new SQLException("ZEval.evalExpValue(): unknown column " + var4.getValue());
                    }

                    try {
                        var3 = new Double(var5.toString());
                    } catch (NumberFormatException var7) {
                        var3 = var5;
                    }
                    break;
                case 1:
                case 3:
                default:
                    var3 = var4.getValue();
                    break;
                case 2:
                    var3 = new Double(var4.getValue());
            }
        } else if (var2 instanceof ZExpression) {
            var3 = new Double(this.evalNumericExp(var1, (ZExpression)var2));
        }

        return var3;
    }

    public static void main(String[] var0) {
        try {
            BufferedReader var1 = new BufferedReader(new FileReader("test.db"));
            String var2 = var1.readLine();
            ZTuple var3 = new ZTuple(var2);
            ZqlParser var4 = new ZqlParser();
            ZEval var5 = new ZEval();

            while((var2 = var1.readLine()) != null) {
                var3.setRow(var2);
                BufferedReader var6 = new BufferedReader(new FileReader("test.sql"));

                String var7;
                while((var7 = var6.readLine()) != null) {
                    var4.initParser(new ByteArrayInputStream(var7.getBytes()));
                    ZExp var8 = var4.readExpression();
                    System.out.print(var2 + ", " + var7 + ", ");
                    System.out.println(var5.eval(var3, var8));
                }

                var6.close();
            }

            var1.close();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }
}
