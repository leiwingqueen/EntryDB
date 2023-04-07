//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zql;

import java.util.Vector;

public class ZExpression implements ZExp {
    String op_ = null;
    Vector operands_ = null;

    public ZExpression(String var1) {
        this.op_ = new String(var1);
    }

    public ZExpression(String var1, ZExp var2) {
        this.op_ = new String(var1);
        this.addOperand(var2);
    }

    public ZExpression(String var1, ZExp var2, ZExp var3) {
        this.op_ = new String(var1);
        this.addOperand(var2);
        this.addOperand(var3);
    }

    public String getOperator() {
        return this.op_;
    }

    public void setOperands(Vector var1) {
        this.operands_ = var1;
    }

    public Vector getOperands() {
        return this.operands_;
    }

    public void addOperand(ZExp var1) {
        if (this.operands_ == null) {
            this.operands_ = new Vector();
        }

        this.operands_.addElement(var1);
    }

    public ZExp getOperand(int var1) {
        return this.operands_ != null && var1 < this.operands_.size() ? (ZExp)this.operands_.elementAt(var1) : null;
    }

    public int nbOperands() {
        return this.operands_ == null ? 0 : this.operands_.size();
    }

    public String toReversePolish() {
        StringBuffer var1 = new StringBuffer("(");
        var1.append(this.op_);

        for(int var2 = 0; var2 < this.nbOperands(); ++var2) {
            ZExp var3 = this.getOperand(var2);
            if (var3 instanceof ZExpression) {
                var1.append(" " + ((ZExpression)var3).toReversePolish());
            } else if (var3 instanceof ZQuery) {
                var1.append(" (" + var3.toString() + ")");
            } else {
                var1.append(" " + var3.toString());
            }
        }

        var1.append(")");
        return var1.toString();
    }

    public String toString() {
        if (this.op_.equals("?")) {
            return this.op_;
        } else if (ZUtils.isCustomFunction(this.op_) >= 0) {
            return this.formatFunction();
        } else {
            StringBuffer var1 = new StringBuffer();
            if (this.needPar(this.op_)) {
                var1.append("(");
            }

            ZExp var2;
            switch(this.nbOperands()) {
                case 1:
                    var2 = this.getOperand(0);
                    if (var2 instanceof ZConstant) {
                        if (ZUtils.isAggregate(this.op_)) {
                            var1.append(this.op_ + "(" + var2.toString() + ")");
                        } else if (!this.op_.equals("IS NULL") && !this.op_.equals("IS NOT NULL")) {
                            if (this.op_.equals(",")) {
                                var1.append(var2.toString());
                            } else {
                                var1.append(this.op_ + " " + var2.toString());
                            }
                        } else {
                            var1.append(var2.toString() + " " + this.op_);
                        }
                    } else if (var2 instanceof ZQuery) {
                        var1.append(this.op_ + " (" + var2.toString() + ")");
                    } else if (!this.op_.equals("IS NULL") && !this.op_.equals("IS NOT NULL")) {
                        if (this.op_.equals(",")) {
                            var1.append(var2.toString());
                        } else {
                            var1.append(this.op_ + " " + var2.toString());
                        }
                    } else {
                        var1.append(var2.toString() + " " + this.op_);
                    }
                    break;
                case 3:
                    if (this.op_.toUpperCase().endsWith("BETWEEN")) {
                        var1.append(this.getOperand(0).toString() + " " + this.op_ + " " + this.getOperand(1).toString() + " AND " + this.getOperand(2).toString());
                        break;
                    }
                default:
                    boolean var3 = this.op_.equals("IN") || this.op_.equals("NOT IN");
                    int var4 = this.nbOperands();

                    for(int var5 = 0; var5 < var4; ++var5) {
                        if (var3 && var5 == 1) {
                            var1.append(" " + this.op_ + " (");
                        }

                        var2 = this.getOperand(var5);
                        if (var2 instanceof ZQuery && !var3) {
                            var1.append("(" + var2.toString() + ")");
                        } else {
                            var1.append(var2.toString());
                        }

                        if (var5 < var4 - 1) {
                            if (this.op_.equals(",") || var3 && var5 > 0) {
                                var1.append(", ");
                            } else if (!var3) {
                                var1.append(" " + this.op_ + " ");
                            }
                        }
                    }

                    if (var3) {
                        var1.append(")");
                    }
            }

            if (this.needPar(this.op_)) {
                var1.append(")");
            }

            return var1.toString();
        }
    }

    private boolean needPar(String var1) {
        String var2 = var1.toUpperCase();
        return !var2.equals("ANY") && !var2.equals("ALL") && !var2.equals("UNION") && !ZUtils.isAggregate(var2);
    }

    private String formatFunction() {
        StringBuffer var1 = new StringBuffer(this.op_ + "(");
        int var2 = this.nbOperands();

        for(int var3 = 0; var3 < var2; ++var3) {
            var1.append(this.getOperand(var3).toString() + (var3 < var2 - 1 ? "," : ""));
        }

        var1.append(")");
        return var1.toString();
    }
}
