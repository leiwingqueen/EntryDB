//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zql;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ZqlJJParser implements ZqlJJParserConstants {
    public ZqlJJParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    public Token token;
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos;
    private Token jj_lastpos;
    private int jj_la;
    private int jj_gen;
    private final int[] jj_la1;
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private static int[] jj_la1_3;
    private final ZqlJJParser.JJCalls[] jj_2_rtns;
    private boolean jj_rescan;
    private int jj_gc;
    private final ZqlJJParser.LookaheadSuccess jj_ls;
    private List jj_expentries;
    private int[] jj_expentry;
    private int jj_kind;
    private int[] jj_lasttokens;
    private int jj_endpos;

    public static void main(String[] var0) throws ParseException {
        ZqlJJParser var1 = null;
        if (var0.length < 1) {
            System.out.println("Reading from stdin (exit; to finish)");
            var1 = new ZqlJJParser(System.in);
        } else {
            try {
                var1 = new ZqlJJParser(new DataInputStream(new FileInputStream(var0[0])));
            } catch (FileNotFoundException var3) {
                System.out.println("File " + var0[0] + " not found. Reading from stdin");
                var1 = new ZqlJJParser(System.in);
            }
        }

        if (var0.length > 0) {
            System.out.println(var0[0]);
        }

        ZStatement var2 = null;

        while((var2 = var1.SQLStatement()) != null) {
            System.out.println(var2.toString());
        }

        System.out.println("Parse Successful");
    }

    public final void BasicDataTypeDeclaration() throws ParseException {
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 12:
                this.jj_consume_token(12);
                break;
            case 13:
                this.jj_consume_token(13);
                break;
            case 15:
            case 27:
            case 34:
            case 44:
            case 48:
            case 56:
            case 70:
            case 71:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 15:
                        this.jj_consume_token(15);
                        break;
                    case 27:
                        this.jj_consume_token(27);
                        break;
                    case 34:
                        this.jj_consume_token(34);
                        break;
                    case 44:
                        this.jj_consume_token(44);
                        break;
                    case 48:
                        this.jj_consume_token(48);
                        break;
                    case 56:
                        this.jj_consume_token(56);
                        break;
                    case 70:
                        this.jj_consume_token(70);
                        break;
                    case 71:
                        this.jj_consume_token(71);
                        break;
                    default:
                        this.jj_la1[0] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }

                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 88:
                        this.jj_consume_token(88);
                        this.jj_consume_token(76);
                        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                            case 89:
                                this.jj_consume_token(89);
                                this.jj_consume_token(76);
                                break;
                            default:
                                this.jj_la1[1] = this.jj_gen;
                        }

                        this.jj_consume_token(90);
                        return;
                    default:
                        this.jj_la1[2] = this.jj_gen;
                        return;
                }
            case 20:
                this.jj_consume_token(20);
                break;
            default:
                this.jj_la1[3] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

    }

    public final Vector SQLStatements() throws ParseException {
        Vector var1 = new Vector();

        while(true) {
            ZStatement var2 = this.SQLStatement();
            if (var2 == null) {
                return var1;
            }

            var1.addElement(var2);
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 17:
                case 21:
                case 26:
                case 33:
                case 39:
                case 54:
                case 57:
                case 59:
                case 60:
                case 68:
                    break;
                default:
                    this.jj_la1[4] = this.jj_gen;
                    return var1;
            }
        }
    }

    public final ZStatement SQLStatement() throws ParseException {
        ZUpdate var1 = null;
        ZTransactStmt var2;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 17:
                var2 = this.CommitStatement();
                return var2;
            case 21:
                ZDelete var6 = this.DeleteStatement();
                return var6;
            case 26:
            case 54:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 26:
                        this.jj_consume_token(26);
                        break;
                    case 54:
                        this.jj_consume_token(54);
                        break;
                    default:
                        this.jj_la1[5] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }

                this.jj_consume_token(91);
                return null;
            case 33:
                ZInsert var5 = this.InsertStatement();
                return var5;
            case 39:
                ZLockTable var4 = this.LockTableStatement();
                return var4;
            case 57:
                var2 = this.RollbackStatement();
                return var2;
            case 59:
                ZQuery var3 = this.QueryStatement();
                return var3;
            case 60:
                var2 = this.SetTransactionStatement();
                return var2;
            case 68:
                var1 = this.UpdateStatement();
                return var1;
            default:
                this.jj_la1[6] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final ZTransactStmt CommitStatement() throws ParseException {
        ZTransactStmt var2 = new ZTransactStmt("COMMIT");
        this.jj_consume_token(17);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 74:
                this.jj_consume_token(74);
                break;
            default:
                this.jj_la1[7] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 16:
                this.jj_consume_token(16);
                Token var1 = this.jj_consume_token(86);
                var2.setComment(var1.toString());
                break;
            default:
                this.jj_la1[8] = this.jj_gen;
        }

        this.jj_consume_token(91);
        return var2;
    }

    public final ZLockTable LockTableStatement() throws ParseException {
        ZLockTable var1 = new ZLockTable();
        Vector var2 = new Vector();
        this.jj_consume_token(39);
        this.jj_consume_token(65);
        String var3 = this.TableReference();
        var2.addElement(var3);

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 89:
                    this.jj_consume_token(89);
                    var3 = this.TableReference();
                    var2.addElement(var3);
                    break;
                default:
                    this.jj_la1[9] = this.jj_gen;
                    this.jj_consume_token(32);
                    var3 = this.LockMode();
                    var1.setLockMode(var3);
                    this.jj_consume_token(43);
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 46:
                            this.jj_consume_token(46);
                            var1.nowait_ = true;
                            break;
                        default:
                            this.jj_la1[10] = this.jj_gen;
                    }

                    this.jj_consume_token(91);
                    var1.addTables(var2);
                    return var1;
            }
        }
    }

    public final ZTransactStmt RollbackStatement() throws ParseException {
        ZTransactStmt var2 = new ZTransactStmt("ROLLBACK");
        this.jj_consume_token(57);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 74:
                this.jj_consume_token(74);
                break;
            default:
                this.jj_la1[11] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 16:
                this.jj_consume_token(16);
                Token var1 = this.jj_consume_token(86);
                var2.setComment(var1.toString());
                break;
            default:
                this.jj_la1[12] = this.jj_gen;
        }

        this.jj_consume_token(91);
        return var2;
    }

    public final ZTransactStmt SetTransactionStatement() throws ParseException {
        ZTransactStmt var2 = new ZTransactStmt("SET TRANSACTION");
        boolean var3 = false;
        this.jj_consume_token(60);
        this.jj_consume_token(66);
        this.jj_consume_token(55);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 50:
                this.jj_consume_token(50);
                var3 = true;
                break;
            case 75:
                this.jj_consume_token(75);
                break;
            default:
                this.jj_la1[13] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

        this.jj_consume_token(91);
        var2.readOnly_ = var3;
        return var2;
    }

    public final String LockMode() throws ParseException {
        StringBuffer var1 = new StringBuffer();
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 24:
                this.jj_consume_token(24);
                return new String("EXCLUSIVE");
            case 58:
                this.jj_consume_token(58);
                var1.append("ROW ");
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 24:
                        this.jj_consume_token(24);
                        var1.append("EXCLUSIVE");
                        break;
                    case 61:
                        this.jj_consume_token(61);
                        var1.append("SHARE");
                        break;
                    default:
                        this.jj_la1[14] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }

                return var1.toString();
            case 61:
                this.jj_consume_token(61);
                var1.append("SHARE");
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 58:
                    case 68:
                        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                            case 58:
                                this.jj_consume_token(58);
                                this.jj_consume_token(24);
                                var1.append(" ROW EXCLUSIVE");
                                return var1.toString();
                            case 68:
                                this.jj_consume_token(68);
                                var1.append(" UPDATE");
                                return var1.toString();
                            default:
                                this.jj_la1[15] = this.jj_gen;
                                this.jj_consume_token(-1);
                                throw new ParseException();
                        }
                    default:
                        this.jj_la1[16] = this.jj_gen;
                        return var1.toString();
                }
            default:
                this.jj_la1[17] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final ZUpdate UpdateStatement() throws ParseException {
        this.jj_consume_token(68);
        String var4 = this.TableReference();
        ZUpdate var1 = new ZUpdate(var4);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 82:
                Token var5 = this.jj_consume_token(82);
                var1.setAlias(var5.toString());
                break;
            default:
                this.jj_la1[18] = this.jj_gen;
        }

        this.jj_consume_token(60);
        this.ColumnValues(var1);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 72:
                this.jj_consume_token(72);
                ZExp var2 = this.SQLExpression();
                var1.addWhere(var2);
                break;
            default:
                this.jj_la1[19] = this.jj_gen;
        }

        this.jj_consume_token(91);
        return var1;
    }

    public final void ColumnValues(ZUpdate var1) throws ParseException {
        String var2 = this.TableColumn();
        this.jj_consume_token(92);
        ZExp var3 = this.UpdatedValue();
        var1.addColumnUpdate(var2, var3);

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 89:
                    this.jj_consume_token(89);
                    var2 = this.TableColumn();
                    this.jj_consume_token(92);
                    var3 = this.UpdatedValue();
                    var1.addColumnUpdate(var2, var3);
                    break;
                default:
                    this.jj_la1[20] = this.jj_gen;
                    return;
            }
        }
    }

    public final ZExp UpdatedValue() throws ParseException {
        if (this.jj_2_1(2147483647)) {
            this.jj_consume_token(88);
            ZQuery var2 = this.SelectStatement();
            this.jj_consume_token(90);
            return var2;
        } else {
            ZExp var1;
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 10:
                case 19:
                case 25:
                case 40:
                case 41:
                case 45:
                case 47:
                case 53:
                case 64:
                case 76:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 101:
                case 102:
                    var1 = this.SQLExpression();
                    return var1;
                case 105:
                    var1 = this.PreparedCol();
                    return var1;
                default:
                    this.jj_la1[21] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    public final ZInsert InsertStatement() throws ParseException {
        ZInsert var1;
        Vector var3;
        this.jj_consume_token(33);
        this.jj_consume_token(36);
        String var2 = this.TableReference();
        var1 = new ZInsert(var2);
        label40:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 88:
                this.jj_consume_token(88);
                var2 = this.TableColumn();
                var3 = new Vector();
                var3.addElement(var2);

                while(true) {
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 89:
                            this.jj_consume_token(89);
                            var2 = this.TableColumn();
                            var3.addElement(var2);
                            break;
                        default:
                            this.jj_la1[22] = this.jj_gen;
                            this.jj_consume_token(90);
                            var1.addColumns(var3);
                            break label40;
                    }
                }
            default:
                this.jj_la1[23] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 59:
                ZQuery var4 = this.SelectStatement();
                var1.addValueSpec(var4);
                break;
            case 69:
                this.jj_consume_token(69);
                this.jj_consume_token(88);
                var3 = this.SQLExpressionList();
                this.jj_consume_token(90);
                ZExpression var5 = new ZExpression(",");
                var5.setOperands(var3);
                var1.addValueSpec(var5);
                break;
            default:
                this.jj_la1[24] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

        this.jj_consume_token(91);
        return var1;
    }

    public final ZDelete DeleteStatement() throws ParseException {
        this.jj_consume_token(21);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 29:
                this.jj_consume_token(29);
                break;
            default:
                this.jj_la1[25] = this.jj_gen;
        }

        String var3 = this.TableReference();
        ZDelete var1 = new ZDelete(var3);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 72:
                this.jj_consume_token(72);
                ZExp var2 = this.SQLExpression();
                var1.addWhere(var2);
                break;
            default:
                this.jj_la1[26] = this.jj_gen;
        }

        this.jj_consume_token(91);
        return var1;
    }

    public final ZQuery QueryStatement() throws ParseException {
        ZQuery var1 = this.SelectStatement();
        this.jj_consume_token(91);
        return var1;
    }

    public final String TableColumn() throws ParseException {
        StringBuffer var1 = new StringBuffer();
        String var2 = this.OracleObjectName();
        var1.append(var2);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 93:
                this.jj_consume_token(93);
                var2 = this.OracleObjectName();
                var1.append("." + var2);
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 93:
                        this.jj_consume_token(93);
                        var2 = this.OracleObjectName();
                        var1.append("." + var2);
                        return var1.toString();
                    default:
                        this.jj_la1[27] = this.jj_gen;
                        return var1.toString();
                }
            default:
                this.jj_la1[28] = this.jj_gen;
                return var1.toString();
        }
    }

    public final String OracleObjectName() throws ParseException {
        Token var1;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 82:
                var1 = this.jj_consume_token(82);
                return var1.toString();
            case 87:
                var1 = this.jj_consume_token(87);
                return var1.toString();
            default:
                this.jj_la1[29] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final String Relop() throws ParseException {
        Token var1;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 92:
                var1 = this.jj_consume_token(92);
                return var1.toString();
            case 93:
            default:
                this.jj_la1[30] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            case 94:
                var1 = this.jj_consume_token(94);
                return var1.toString();
            case 95:
                var1 = this.jj_consume_token(95);
                return var1.toString();
            case 96:
                var1 = this.jj_consume_token(96);
                return var1.toString();
            case 97:
                var1 = this.jj_consume_token(97);
                return var1.toString();
            case 98:
                var1 = this.jj_consume_token(98);
                return var1.toString();
            case 99:
                var1 = this.jj_consume_token(99);
                return var1.toString();
            case 100:
                var1 = this.jj_consume_token(100);
                return var1.toString();
        }
    }

    public final String TableReference() throws ParseException {
        StringBuffer var1 = new StringBuffer();
        String var2 = this.OracleObjectName();
        var1.append(var2);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 93:
                this.jj_consume_token(93);
                var2 = this.OracleObjectName();
                var1.append("." + var2);
                break;
            default:
                this.jj_la1[31] = this.jj_gen;
        }

        return var1.toString();
    }

    public final void NumOrID() throws ParseException {
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 76:
            case 101:
            case 102:
                label27:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 101:
                    case 102:
                        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                            case 101:
                                this.jj_consume_token(101);
                                break label27;
                            case 102:
                                this.jj_consume_token(102);
                                break label27;
                            default:
                                this.jj_la1[32] = this.jj_gen;
                                this.jj_consume_token(-1);
                                throw new ParseException();
                        }
                    default:
                        this.jj_la1[33] = this.jj_gen;
                }

                this.jj_consume_token(76);
                break;
            case 82:
                this.jj_consume_token(82);
                break;
            default:
                this.jj_la1[34] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

    }

    public final ZQuery SelectStatement() throws ParseException {
        ZQuery var1 = this.SelectWithoutOrder();
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 52:
                Vector var2 = this.OrderByClause();
                var1.addOrderBy(var2);
                break;
            default:
                this.jj_la1[35] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 28:
                this.ForUpdateClause();
                var1.forupdate_ = true;
                break;
            default:
                this.jj_la1[36] = this.jj_gen;
        }

        return var1;
    }

    public final ZQuery SelectWithoutOrder() throws ParseException {
        ZQuery var1;
        ZExp var4;
        ZGroupBy var5;
        ZExpression var6;
        var1 = new ZQuery();
        var4 = null;
        var5 = null;
        var6 = null;
        this.jj_consume_token(59);
        label60:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 5:
            case 23:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 5:
                        this.jj_consume_token(5);
                        break label60;
                    case 23:
                        this.jj_consume_token(23);
                        var1.distinct_ = true;
                        break label60;
                    default:
                        this.jj_la1[37] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }
            default:
                this.jj_la1[38] = this.jj_gen;
        }

        Vector var2 = this.SelectList();
        Vector var3 = this.FromClause();
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 72:
                var4 = this.WhereClause();
                break;
            default:
                this.jj_la1[39] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 18:
            case 63:
                this.ConnectClause();
                break;
            default:
                this.jj_la1[40] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 30:
                var5 = this.GroupByClause();
                break;
            default:
                this.jj_la1[41] = this.jj_gen;
        }

        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 35:
            case 42:
            case 67:
                var6 = this.SetClause();
                break;
            default:
                this.jj_la1[42] = this.jj_gen;
        }

        var1.addSelect(var2);
        var1.addFrom(var3);
        var1.addWhere(var4);
        var1.addGroupBy(var5);
        var1.addSet(var6);
        return var1;
    }

    public final Vector SelectList() throws ParseException {
        Vector var1 = new Vector(8);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
            case 19:
            case 40:
            case 41:
            case 47:
            case 64:
            case 76:
            case 82:
            case 85:
            case 86:
            case 87:
            case 88:
            case 101:
            case 102:
                ZSelectItem var2 = this.SelectItem();
                var1.addElement(var2);

                while(true) {
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 89:
                            this.jj_consume_token(89);
                            var2 = this.SelectItem();
                            var1.addElement(var2);
                            break;
                        default:
                            this.jj_la1[43] = this.jj_gen;
                            return var1;
                    }
                }
            case 103:
                this.jj_consume_token(103);
                var1.addElement(new ZSelectItem("*"));
                return var1;
            default:
                this.jj_la1[44] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final ZSelectItem SelectItem() throws ParseException {
        String var1;
        if (this.jj_2_2(2147483647)) {
            var1 = this.SelectStar();
            return new ZSelectItem(var1);
        } else {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 10:
                case 19:
                case 40:
                case 41:
                case 47:
                case 64:
                case 76:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 101:
                case 102:
                    ZExp var3 = this.SQLSimpleExpression();
                    ZSelectItem var2 = new ZSelectItem(var3.toString());
                    var2.setExpression(var3);
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 8:
                        case 82:
                        case 87:
                            var1 = this.SelectAlias();
                            var2.setAlias(var1);
                            break;
                        default:
                            this.jj_la1[45] = this.jj_gen;
                    }

                    return var2;
                default:
                    this.jj_la1[46] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    public final String SelectAlias() throws ParseException {
        StringBuffer var2 = null;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 8:
                this.jj_consume_token(8);
                break;
            default:
                this.jj_la1[47] = this.jj_gen;
        }

        Token var1;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 82:
                while(true) {
                    var1 = this.jj_consume_token(82);
                    if (var2 == null) {
                        var2 = new StringBuffer(var1.toString().trim());
                    } else {
                        var2.append(" " + var1.toString().trim());
                    }

                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 82:
                            break;
                        default:
                            this.jj_la1[48] = this.jj_gen;
                            return var2.toString().trim();
                    }
                }
            case 87:
                var1 = this.jj_consume_token(87);
                return var1.toString().trim();
            default:
                this.jj_la1[49] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final String SelectStar() throws ParseException {
        String var1;
        if (this.jj_2_3(2)) {
            var1 = this.OracleObjectName();
            this.jj_consume_token(104);
            return new String(var1 + ".*");
        } else if (this.jj_2_4(4)) {
            var1 = this.OracleObjectName();
            this.jj_consume_token(93);
            String var2 = this.OracleObjectName();
            this.jj_consume_token(104);
            return new String(var1 + "." + var2 + ".*");
        } else {
            this.jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public final Vector FromClause() throws ParseException {
        Vector var1 = new Vector(8);
        this.jj_consume_token(29);
        ZFromItem var2 = this.FromItem();
        var1.addElement(var2);

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 89:
                    this.jj_consume_token(89);
                    var2 = this.FromItem();
                    var1.addElement(var2);
                    break;
                default:
                    this.jj_la1[50] = this.jj_gen;
                    return var1;
            }
        }
    }

    public final ZFromItem FromItem() throws ParseException {
        String var2 = this.TableReference();
        ZFromItem var1 = new ZFromItem(var2);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 82:
                Token var3 = this.jj_consume_token(82);
                var1.setAlias(var3.toString());
                break;
            default:
                this.jj_la1[51] = this.jj_gen;
        }

        return var1;
    }

    public final ZExp WhereClause() throws ParseException {
        this.jj_consume_token(72);
        ZExp var1 = this.SQLExpression();
        return var1;
    }

    public final void ConnectClause() throws ParseException {
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 63:
                this.jj_consume_token(63);
                this.jj_consume_token(73);
                this.SQLExpression();
                break;
            default:
                this.jj_la1[52] = this.jj_gen;
        }

        this.jj_consume_token(18);
        this.jj_consume_token(14);
        this.SQLExpression();
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 63:
                this.jj_consume_token(63);
                this.jj_consume_token(73);
                this.SQLExpression();
                break;
            default:
                this.jj_la1[53] = this.jj_gen;
        }

    }

    public final ZGroupBy GroupByClause() throws ParseException {
        ZGroupBy var1 = null;
        this.jj_consume_token(30);
        this.jj_consume_token(14);
        Vector var2 = this.SQLExpressionList();
        var1 = new ZGroupBy(var2);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 31:
                this.jj_consume_token(31);
                ZExp var3 = this.SQLExpression();
                var1.setHaving(var3);
                break;
            default:
                this.jj_la1[54] = this.jj_gen;
        }

        return var1;
    }

    public final ZExpression SetClause() throws ParseException {
        Token var3;
        label34:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 35:
                var3 = this.jj_consume_token(35);
                break;
            case 42:
                var3 = this.jj_consume_token(42);
                break;
            case 67:
                var3 = this.jj_consume_token(67);
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 5:
                        this.jj_consume_token(5);
                        break label34;
                    default:
                        this.jj_la1[55] = this.jj_gen;
                        break label34;
                }
            default:
                this.jj_la1[56] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

        ZExpression var1 = new ZExpression(var3.toString());
        ZQuery var2;
        if (this.jj_2_5(2147483647)) {
            this.jj_consume_token(88);
            var2 = this.SelectWithoutOrder();
            var1.addOperand(var2);
            this.jj_consume_token(90);
        } else {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 59:
                    var2 = this.SelectWithoutOrder();
                    var1.addOperand(var2);
                    break;
                default:
                    this.jj_la1[57] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }

        return var1;
    }

    public final Vector OrderByClause() throws ParseException {
        Vector var1;
        ZExp var2;
        ZOrderBy var3;
        var1 = new Vector();
        this.jj_consume_token(52);
        this.jj_consume_token(14);
        var2 = this.SQLSimpleExpression();
        var3 = new ZOrderBy(var2);
        label54:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 9:
            case 22:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 9:
                        this.jj_consume_token(9);
                        break label54;
                    case 22:
                        this.jj_consume_token(22);
                        var3.setAscOrder(false);
                        break label54;
                    default:
                        this.jj_la1[58] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }
            default:
                this.jj_la1[59] = this.jj_gen;
        }

        var1.addElement(var3);

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 89:
                    this.jj_consume_token(89);
                    var2 = this.SQLSimpleExpression();
                    var3 = new ZOrderBy(var2);
                    label44:
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 9:
                        case 22:
                            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                                case 9:
                                    this.jj_consume_token(9);
                                    break label44;
                                case 22:
                                    this.jj_consume_token(22);
                                    var3.setAscOrder(false);
                                    break label44;
                                default:
                                    this.jj_la1[61] = this.jj_gen;
                                    this.jj_consume_token(-1);
                                    throw new ParseException();
                            }
                        default:
                            this.jj_la1[62] = this.jj_gen;
                    }

                    var1.addElement(var3);
                    break;
                default:
                    this.jj_la1[60] = this.jj_gen;
                    return var1;
            }
        }
    }

    public final void ForUpdateClause() throws ParseException {
        this.jj_consume_token(28);
        this.jj_consume_token(68);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 49:
                this.jj_consume_token(49);
                this.TableColumn();

                while(true) {
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 89:
                            this.jj_consume_token(89);
                            this.TableColumn();
                            break;
                        default:
                            this.jj_la1[63] = this.jj_gen;
                            return;
                    }
                }
            default:
                this.jj_la1[64] = this.jj_gen;
        }
    }

    public final ZExp SQLExpression() throws ParseException {
        ZExpression var3 = null;
        boolean var4 = true;
        ZExp var1 = this.SQLAndExpression();

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 51:
                    this.jj_consume_token(51);
                    ZExp var2 = this.SQLAndExpression();
                    if (var4) {
                        var3 = new ZExpression("OR", var1);
                    }

                    var4 = false;
                    var3.addOperand(var2);
                    break;
                default:
                    this.jj_la1[65] = this.jj_gen;
                    return (ZExp)(var4 ? var1 : var3);
            }
        }
    }

    public final ZExp SQLAndExpression() throws ParseException {
        ZExpression var3 = null;
        boolean var4 = true;
        ZExp var1 = this.SQLUnaryLogicalExpression();

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 6:
                    this.jj_consume_token(6);
                    ZExp var2 = this.SQLUnaryLogicalExpression();
                    if (var4) {
                        var3 = new ZExpression("AND", var1);
                    }

                    var4 = false;
                    var3.addOperand(var2);
                    break;
                default:
                    this.jj_la1[66] = this.jj_gen;
                    return (ZExp)(var4 ? var1 : var3);
            }
        }
    }

    public final ZExp SQLUnaryLogicalExpression() throws ParseException {
        boolean var3 = false;
        if (this.jj_2_6(2)) {
            ZExpression var4 = this.ExistsClause();
            return var4;
        } else {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 10:
                case 19:
                case 40:
                case 41:
                case 45:
                case 47:
                case 53:
                case 64:
                case 76:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 101:
                case 102:
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 45:
                            this.jj_consume_token(45);
                            var3 = true;
                            break;
                        default:
                            this.jj_la1[67] = this.jj_gen;
                    }

                    ZExp var1 = this.SQLRelationalExpression();
                    Object var2;
                    if (var3) {
                        var2 = new ZExpression("NOT", var1);
                    } else {
                        var2 = var1;
                    }

                    return (ZExp)var2;
                default:
                    this.jj_la1[68] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    public final ZExpression ExistsClause() throws ParseException {
        boolean var3 = false;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 45:
                this.jj_consume_token(45);
                var3 = true;
                break;
            default:
                this.jj_la1[69] = this.jj_gen;
        }

        this.jj_consume_token(25);
        this.jj_consume_token(88);
        ZQuery var2 = this.SubQuery();
        this.jj_consume_token(90);
        ZExpression var4 = new ZExpression("EXISTS", var2);
        ZExpression var1;
        if (var3) {
            var1 = new ZExpression("NOT", var4);
        } else {
            var1 = var4;
        }

        return var1;
    }

    public final ZExp SQLRelationalExpression() throws ParseException {
        ZExpression var3 = null;
        boolean var5 = false;
        Object var2;
        if (this.jj_2_7(2147483647)) {
            this.jj_consume_token(88);
            Vector var4 = this.SQLExpressionList();
            this.jj_consume_token(90);
            var2 = new ZExpression(",");
            ((ZExpression)var2).setOperands(var4);
        } else {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 10:
                case 19:
                case 40:
                case 41:
                case 47:
                case 53:
                case 64:
                case 76:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 101:
                case 102:
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 53:
                            this.jj_consume_token(53);
                            var5 = true;
                            break;
                        default:
                            this.jj_la1[70] = this.jj_gen;
                    }

                    ZExp var1 = this.SQLSimpleExpression();
                    if (var5) {
                        var2 = new ZExpression("PRIOR", var1);
                    } else {
                        var2 = var1;
                    }
                    break;
                default:
                    this.jj_la1[71] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }

        label60:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 11:
            case 32:
            case 37:
            case 38:
            case 45:
            case 92:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 92:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                        var3 = this.SQLRelationalOperatorExpression();
                        break label60;
                    case 93:
                    default:
                        this.jj_la1[72] = this.jj_gen;
                        if (this.jj_2_8(2)) {
                            var3 = this.SQLInClause();
                        } else if (this.jj_2_9(2)) {
                            var3 = this.SQLBetweenClause();
                        } else if (this.jj_2_10(2)) {
                            var3 = this.SQLLikeClause();
                        } else {
                            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                                case 37:
                                    var3 = this.IsNullClause();
                                    break label60;
                                default:
                                    this.jj_la1[73] = this.jj_gen;
                                    this.jj_consume_token(-1);
                                    throw new ParseException();
                            }
                        }
                }
                break;
            default:
                this.jj_la1[74] = this.jj_gen;
        }

        if (var3 == null) {
            return (ZExp)var2;
        } else {
            Vector var6 = var3.getOperands();
            if (var6 == null) {
                var6 = new Vector();
            }

            var6.insertElementAt(var2, 0);
            var3.setOperands(var6);
            return var3;
        }
    }

    public final Vector SQLExpressionList() throws ParseException {
        Vector var1 = new Vector(8);
        ZExp var2 = this.SQLSimpleExpressionOrPreparedCol();
        var1.addElement(var2);

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 89:
                    this.jj_consume_token(89);
                    var2 = this.SQLSimpleExpressionOrPreparedCol();
                    var1.addElement(var2);
                    break;
                default:
                    this.jj_la1[75] = this.jj_gen;
                    return var1;
            }
        }
    }

    public final ZExpression SQLRelationalOperatorExpression() throws ParseException {
        String var5 = null;
        String var4 = this.Relop();
        ZExpression var1 = new ZExpression(var4);
        Object var3;
        if (this.jj_2_11(2147483647)) {
            label44:
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 5:
                case 7:
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 5:
                            this.jj_consume_token(5);
                            var5 = "ALL";
                            break label44;
                        case 7:
                            this.jj_consume_token(7);
                            var5 = "ANY";
                            break label44;
                        default:
                            this.jj_la1[76] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                    }
                default:
                    this.jj_la1[77] = this.jj_gen;
            }

            this.jj_consume_token(88);
            ZQuery var2 = this.SubQuery();
            this.jj_consume_token(90);
            if (var5 == null) {
                var3 = var2;
            } else {
                var3 = new ZExpression(var5, var2);
            }
        } else {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 10:
                case 19:
                case 40:
                case 41:
                case 47:
                case 53:
                case 64:
                case 76:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 101:
                case 102:
                case 105:
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 53:
                            this.jj_consume_token(53);
                            var5 = "PRIOR";
                            break;
                        default:
                            this.jj_la1[78] = this.jj_gen;
                    }

                    ZExp var6 = this.SQLSimpleExpressionOrPreparedCol();
                    if (var5 == null) {
                        var3 = var6;
                    } else {
                        var3 = new ZExpression(var5, var6);
                    }
                    break;
                default:
                    this.jj_la1[79] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
            }
        }

        var1.addOperand((ZExp)var3);
        return var1;
    }

    public final ZExp SQLSimpleExpressionOrPreparedCol() throws ParseException {
        ZExp var1;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
            case 19:
            case 40:
            case 41:
            case 47:
            case 64:
            case 76:
            case 82:
            case 85:
            case 86:
            case 87:
            case 88:
            case 101:
            case 102:
                var1 = this.SQLSimpleExpression();
                return var1;
            case 105:
                var1 = this.PreparedCol();
                return var1;
            default:
                this.jj_la1[80] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final ZExp PreparedCol() throws ParseException {
        this.jj_consume_token(105);
        return new ZExpression("?");
    }

    public final ZExpression SQLInClause() throws ParseException {
        boolean var3 = false;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 45:
                this.jj_consume_token(45);
                var3 = true;
                break;
            default:
                this.jj_la1[81] = this.jj_gen;
        }

        this.jj_consume_token(32);
        ZExpression var1 = new ZExpression(var3 ? "NOT IN" : "IN");
        this.jj_consume_token(88);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
            case 19:
            case 40:
            case 41:
            case 47:
            case 64:
            case 76:
            case 82:
            case 85:
            case 86:
            case 87:
            case 88:
            case 101:
            case 102:
            case 105:
                Vector var4 = this.SQLExpressionList();
                var1.setOperands(var4);
                break;
            case 59:
                ZQuery var2 = this.SubQuery();
                var1.addOperand(var2);
                break;
            default:
                this.jj_la1[82] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

        this.jj_consume_token(90);
        return var1;
    }

    public final ZExpression SQLBetweenClause() throws ParseException {
        boolean var4 = false;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 45:
                this.jj_consume_token(45);
                var4 = true;
                break;
            default:
                this.jj_la1[83] = this.jj_gen;
        }

        this.jj_consume_token(11);
        ZExp var2 = this.SQLSimpleExpressionOrPreparedCol();
        this.jj_consume_token(6);
        ZExp var3 = this.SQLSimpleExpressionOrPreparedCol();
        ZExpression var1;
        if (var4) {
            var1 = new ZExpression("NOT BETWEEN", var2, var3);
        } else {
            var1 = new ZExpression("BETWEEN", var2, var3);
        }

        return var1;
    }

    public final ZExpression SQLLikeClause() throws ParseException {
        boolean var3 = false;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 45:
                this.jj_consume_token(45);
                var3 = true;
                break;
            default:
                this.jj_la1[84] = this.jj_gen;
        }

        this.jj_consume_token(38);
        ZExp var1 = this.SQLSimpleExpressionOrPreparedCol();
        ZExpression var2;
        if (var3) {
            var2 = new ZExpression("NOT LIKE", var1);
        } else {
            var2 = new ZExpression("LIKE", var1);
        }

        return var2;
    }

    public final ZExpression IsNullClause() throws ParseException {
        boolean var1 = false;
        this.jj_consume_token(37);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 45:
                this.jj_consume_token(45);
                var1 = true;
                break;
            default:
                this.jj_la1[85] = this.jj_gen;
        }

        this.jj_consume_token(47);
        return var1 ? new ZExpression("IS NOT NULL") : new ZExpression("IS NULL");
    }

    public final ZExp SQLSimpleExpression() throws ParseException {
        ZExpression var4 = null;
        Object var2 = this.SQLMultiplicativeExpression();

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 101:
                case 102:
                case 106:
                    Token var1;
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 101:
                            var1 = this.jj_consume_token(101);
                            break;
                        case 102:
                            var1 = this.jj_consume_token(102);
                            break;
                        case 106:
                            var1 = this.jj_consume_token(106);
                            break;
                        default:
                            this.jj_la1[87] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                    }

                    ZExp var3 = this.SQLMultiplicativeExpression();
                    var4 = new ZExpression(var1.toString(), (ZExp)var2);
                    var4.addOperand(var3);
                    var2 = var4;
                    break;
                default:
                    this.jj_la1[86] = this.jj_gen;
                    return (ZExp)var2;
            }
        }
    }

    public final ZExp SQLMultiplicativeExpression() throws ParseException {
        ZExpression var4 = null;
        Object var2 = this.SQLExpotentExpression();

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 103:
                case 107:
                    Token var1;
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 103:
                            var1 = this.jj_consume_token(103);
                            break;
                        case 107:
                            var1 = this.jj_consume_token(107);
                            break;
                        default:
                            this.jj_la1[89] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                    }

                    ZExp var3 = this.SQLExpotentExpression();
                    var4 = new ZExpression(var1.toString(), (ZExp)var2);
                    var4.addOperand(var3);
                    var2 = var4;
                    break;
                default:
                    this.jj_la1[88] = this.jj_gen;
                    return (ZExp)var2;
            }
        }
    }

    public final ZExp SQLExpotentExpression() throws ParseException {
        ZExpression var4 = null;
        boolean var5 = true;
        ZExp var2 = this.SQLUnaryExpression();

        while(true) {
            switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 108:
                    Token var1 = this.jj_consume_token(108);
                    ZExp var3 = this.SQLUnaryExpression();
                    if (var5) {
                        var4 = new ZExpression(var1.toString(), var2);
                    }

                    var5 = false;
                    var4.addOperand(var3);
                    break;
                default:
                    this.jj_la1[90] = this.jj_gen;
                    return (ZExp)(var5 ? var2 : var4);
            }
        }
    }

    public final ZExp SQLUnaryExpression() throws ParseException {
        Token var1;
        var1 = null;
        label25:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 101:
            case 102:
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 101:
                        var1 = this.jj_consume_token(101);
                        break label25;
                    case 102:
                        var1 = this.jj_consume_token(102);
                        break label25;
                    default:
                        this.jj_la1[91] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                }
            default:
                this.jj_la1[92] = this.jj_gen;
        }

        ZExp var2 = this.SQLPrimaryExpression();
        Object var3;
        if (var1 == null) {
            var3 = var2;
        } else {
            var3 = new ZExpression(var1.toString(), var2);
        }

        return (ZExp)var3;
    }

    public final ZExp SQLPrimaryExpression() throws ParseException {
        String var4 = "";
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 47:
                this.jj_consume_token(47);
                return new ZConstant("NULL", 1);
            default:
                this.jj_la1[94] = this.jj_gen;
                String var2;
                if (this.jj_2_12(2147483647)) {
                    var2 = this.OuterJoinExpression();
                    return new ZConstant(var2, 0);
                } else if (this.jj_2_13(3)) {
                    this.jj_consume_token(19);
                    this.jj_consume_token(88);
                    this.jj_consume_token(103);
                    this.jj_consume_token(90);
                    return new ZExpression("COUNT", new ZConstant("*", 0));
                } else if (this.jj_2_14(3)) {
                    var2 = this.AggregateFunc();
                    this.jj_consume_token(88);
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 5:
                            this.jj_consume_token(5);
                            var4 = "all ";
                            break;
                        case 23:
                            this.jj_consume_token(23);
                            var4 = "distinct ";
                            break;
                        default:
                            this.jj_la1[93] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                    }

                    String var3 = this.TableColumn();
                    this.jj_consume_token(90);
                    return new ZExpression(var2, new ZConstant(var4 + var3, 0));
                } else if (this.jj_2_15(2)) {
                    ZExpression var6 = this.FunctionCall();
                    return var6;
                } else {
                    Token var1;
                    switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 76:
                            var1 = this.jj_consume_token(76);
                            return new ZConstant(var1.toString(), 2);
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 83:
                        case 84:
                        default:
                            this.jj_la1[95] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                        case 82:
                        case 87:
                            var2 = this.TableColumn();
                            return new ZConstant(var2, 0);
                        case 85:
                            var1 = this.jj_consume_token(85);
                            return new ZConstant(var1.toString(), 3);
                        case 86:
                            var1 = this.jj_consume_token(86);
                            var2 = var1.toString();
                            if (var2.startsWith("'")) {
                                var2 = var2.substring(1);
                            }

                            if (var2.endsWith("'")) {
                                var2 = var2.substring(0, var2.length() - 1);
                            }

                            return new ZConstant(var2, 3);
                        case 88:
                            this.jj_consume_token(88);
                            ZExp var5 = this.SQLExpression();
                            this.jj_consume_token(90);
                            return var5;
                    }
                }
        }
    }

    public final String AggregateFunc() throws ParseException {
        Token var1;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
                var1 = this.jj_consume_token(10);
                return var1.toString();
            case 19:
                var1 = this.jj_consume_token(19);
                return var1.toString();
            case 40:
                var1 = this.jj_consume_token(40);
                return var1.toString();
            case 41:
                var1 = this.jj_consume_token(41);
                return var1.toString();
            case 64:
                var1 = this.jj_consume_token(64);
                return var1.toString();
            default:
                this.jj_la1[96] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final ZExpression FunctionCall() throws ParseException {
        Vector var4 = null;
        String var2;
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
            case 19:
            case 40:
            case 41:
            case 64:
                var2 = this.AggregateFunc();
                break;
            case 82:
                Token var1 = this.jj_consume_token(82);
                var2 = var1.toString();
                break;
            default:
                this.jj_la1[97] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
        }

        this.jj_consume_token(88);
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 10:
            case 19:
            case 40:
            case 41:
            case 47:
            case 64:
            case 76:
            case 82:
            case 85:
            case 86:
            case 87:
            case 88:
            case 101:
            case 102:
            case 105:
                var4 = this.SQLExpressionList();
                break;
            default:
                this.jj_la1[98] = this.jj_gen;
        }

        this.jj_consume_token(90);
        int var5 = ZUtils.isCustomFunction(var2);
        if (var5 < 0) {
            var5 = ZUtils.isAggregate(var2) ? 1 : -1;
        }

        if (var5 < 0) {
            throw new ParseException("Undefined function: " + var2);
        } else if (var5 == 10000 || var5 <= 0 || var4 != null && var4.size() == var5) {
            ZExpression var3 = new ZExpression(var2);
            var3.setOperands(var4);
            return var3;
        } else {
            throw new ParseException("Function " + var2 + " should have " + var5 + " parameter(s)");
        }
    }

    public final String OuterJoinExpression() throws ParseException {
        String var1;
        var1 = null;
        String var2 = "";
        var1 = this.OracleObjectName();
        label19:
        switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 93:
                this.jj_consume_token(93);
                var2 = this.OracleObjectName();
                var1 = var1 + "." + var2;
                switch(this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 93:
                        this.jj_consume_token(93);
                        var2 = this.OracleObjectName();
                        var1 = var1 + "." + var2;
                        break label19;
                    default:
                        this.jj_la1[99] = this.jj_gen;
                        break label19;
                }
            default:
                this.jj_la1[100] = this.jj_gen;
        }

        this.jj_consume_token(88);
        this.jj_consume_token(101);
        this.jj_consume_token(90);
        return var1 + "(+)";
    }

    public final ZQuery SubQuery() throws ParseException {
        ZQuery var1 = this.SelectWithoutOrder();
        return var1;
    }

    private boolean jj_2_1(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_1();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(0, var1);
        }

        return var3;
    }

    private boolean jj_2_2(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_2();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(1, var1);
        }

        return var3;
    }

    private boolean jj_2_3(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_3();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(2, var1);
        }

        return var3;
    }

    private boolean jj_2_4(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_4();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(3, var1);
        }

        return var3;
    }

    private boolean jj_2_5(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_5();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(4, var1);
        }

        return var3;
    }

    private boolean jj_2_6(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_6();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(5, var1);
        }

        return var3;
    }

    private boolean jj_2_7(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_7();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(6, var1);
        }

        return var3;
    }

    private boolean jj_2_8(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_8();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(7, var1);
        }

        return var3;
    }

    private boolean jj_2_9(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_9();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(8, var1);
        }

        return var3;
    }

    private boolean jj_2_10(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_10();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(9, var1);
        }

        return var3;
    }

    private boolean jj_2_11(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_11();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(10, var1);
        }

        return var3;
    }

    private boolean jj_2_12(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_12();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(11, var1);
        }

        return var3;
    }

    private boolean jj_2_13(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_13();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(12, var1);
        }

        return var3;
    }

    private boolean jj_2_14(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_14();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(13, var1);
        }

        return var3;
    }

    private boolean jj_2_15(int var1) {
        this.jj_la = var1;
        this.jj_lastpos = this.jj_scanpos = this.token;

        boolean var3;
        try {
            boolean var2 = !this.jj_3_15();
            return var2;
        } catch (ZqlJJParser.LookaheadSuccess var7) {
            var3 = true;
        } finally {
            this.jj_save(14, var1);
        }

        return var3;
    }

    private boolean jj_3R_52() {
        if (this.jj_scan_token(108)) {
            return true;
        } else {
            return this.jj_3R_51();
        }
    }

    private boolean jj_3R_138() {
        return this.jj_scan_token(82);
    }

    private boolean jj_3R_46() {
        if (this.jj_3R_51()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_52());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_137() {
        if (this.jj_3R_138()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_138());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_78() {
        if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_70()) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_76() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_78()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_79()) {
                return true;
            }
        }

        var1 = this.jj_scanpos;
        if (this.jj_3R_80()) {
            this.jj_scanpos = var1;
        }

        return false;
    }

    private boolean jj_3R_135() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(8)) {
            this.jj_scanpos = var1;
        }

        var1 = this.jj_scanpos;
        if (this.jj_3R_136()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_137()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3_1() {
        if (this.jj_scan_token(88)) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_scan_token(88));

            this.jj_scanpos = var1;
            return this.jj_scan_token(59);
        }
    }

    private boolean jj_3R_134() {
        return this.jj_3R_135();
    }

    private boolean jj_3_2() {
        return this.jj_3R_16();
    }

    private boolean jj_3R_47() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(103)) {
            this.jj_scanpos = var1;
            if (this.jj_scan_token(107)) {
                return true;
            }
        }

        return this.jj_3R_46();
    }

    private boolean jj_3R_32() {
        if (this.jj_3R_46()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_47());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_130() {
        if (this.jj_3R_19()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_134()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_31() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_129() {
        return this.jj_3R_16();
    }

    private boolean jj_3R_109() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_129()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_130()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_18() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_31()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(25)) {
            return true;
        } else if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_77()) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_33() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(101)) {
            this.jj_scanpos = var1;
            if (this.jj_scan_token(102)) {
                this.jj_scanpos = var1;
                if (this.jj_scan_token(106)) {
                    return true;
                }
            }
        }

        return this.jj_3R_32();
    }

    private boolean jj_3R_75() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_19() {
        if (this.jj_3R_32()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_33());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_110() {
        if (this.jj_scan_token(89)) {
            return true;
        } else {
            return this.jj_3R_109();
        }
    }

    private boolean jj_3R_74() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_75()) {
            this.jj_scanpos = var1;
        }

        return this.jj_3R_76();
    }

    private boolean jj_3R_96() {
        if (this.jj_3R_109()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_110());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3_6() {
        return this.jj_3R_18();
    }

    private boolean jj_3R_71() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3_6()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_74()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_95() {
        return this.jj_scan_token(103);
    }

    private boolean jj_3R_86() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_95()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_96()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_108() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_72() {
        if (this.jj_scan_token(6)) {
            return true;
        } else {
            return this.jj_3R_71();
        }
    }

    private boolean jj_3R_94() {
        return this.jj_scan_token(23);
    }

    private boolean jj_3R_93() {
        if (this.jj_scan_token(37)) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_108()) {
                this.jj_scanpos = var1;
            }

            return this.jj_scan_token(47);
        }
    }

    private boolean jj_3R_67() {
        if (this.jj_3R_71()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_72());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_45() {
        return this.jj_3R_25();
    }

    private boolean jj_3R_77() {
        return this.jj_3R_81();
    }

    private boolean jj_3R_85() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(5)) {
            this.jj_scanpos = var1;
            if (this.jj_3R_94()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_91() {
        return this.jj_3R_102();
    }

    private boolean jj_3R_90() {
        return this.jj_3R_101();
    }

    private boolean jj_3R_37() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_89() {
        return this.jj_3R_100();
    }

    private boolean jj_3R_22() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_37()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(38)) {
            return true;
        } else {
            return this.jj_3R_36();
        }
    }

    private boolean jj_3R_88() {
        return this.jj_3R_99();
    }

    private boolean jj_3R_68() {
        if (this.jj_scan_token(51)) {
            return true;
        } else {
            return this.jj_3R_67();
        }
    }

    private boolean jj_3R_38() {
        if (this.jj_scan_token(93)) {
            return true;
        } else if (this.jj_3R_17()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_50()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_50() {
        if (this.jj_scan_token(93)) {
            return true;
        } else {
            return this.jj_3R_17();
        }
    }

    private boolean jj_3R_64() {
        if (this.jj_3R_67()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_68());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_24() {
        if (this.jj_3R_17()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_38()) {
                this.jj_scanpos = var1;
            }

            if (this.jj_scan_token(88)) {
                return true;
            } else if (this.jj_scan_token(101)) {
                return true;
            } else {
                return this.jj_scan_token(90);
            }
        }
    }

    private boolean jj_3R_81() {
        if (this.jj_scan_token(59)) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_85()) {
                this.jj_scanpos = var1;
            }

            if (this.jj_3R_86()) {
                return true;
            } else if (this.jj_3R_87()) {
                return true;
            } else {
                var1 = this.jj_scanpos;
                if (this.jj_3R_88()) {
                    this.jj_scanpos = var1;
                }

                var1 = this.jj_scanpos;
                if (this.jj_3R_89()) {
                    this.jj_scanpos = var1;
                }

                var1 = this.jj_scanpos;
                if (this.jj_3R_90()) {
                    this.jj_scanpos = var1;
                }

                var1 = this.jj_scanpos;
                if (this.jj_3R_91()) {
                    this.jj_scanpos = var1;
                }

                return false;
            }
        }
    }

    private boolean jj_3R_35() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_21() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_35()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(11)) {
            return true;
        } else if (this.jj_3R_36()) {
            return true;
        } else if (this.jj_scan_token(6)) {
            return true;
        } else {
            return this.jj_3R_36();
        }
    }

    private boolean jj_3R_106() {
        return this.jj_3R_70();
    }

    private boolean jj_3R_30() {
        return this.jj_scan_token(87);
    }

    private boolean jj_3R_107() {
        return this.jj_3R_77();
    }

    private boolean jj_3_5() {
        return this.jj_scan_token(88);
    }

    private boolean jj_3R_34() {
        return this.jj_scan_token(45);
    }

    private boolean jj_3R_20() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_34()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(32)) {
            return true;
        } else if (this.jj_scan_token(88)) {
            return true;
        } else {
            var1 = this.jj_scanpos;
            if (this.jj_3R_106()) {
                this.jj_scanpos = var1;
                if (this.jj_3R_107()) {
                    return true;
                }
            }

            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_66() {
        return this.jj_3R_70();
    }

    private boolean jj_3R_133() {
        return this.jj_scan_token(7);
    }

    private boolean jj_3R_118() {
        return this.jj_3R_81();
    }

    private boolean jj_3R_44() {
        return this.jj_scan_token(82);
    }

    private boolean jj_3R_28() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_44()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_45()) {
                return true;
            }
        }

        if (this.jj_scan_token(88)) {
            return true;
        } else {
            var1 = this.jj_scanpos;
            if (this.jj_3R_66()) {
                this.jj_scanpos = var1;
            }

            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_117() {
        if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_81()) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_23() {
        if (this.jj_scan_token(88)) {
            return true;
        } else {
            return this.jj_scan_token(59);
        }
    }

    private boolean jj_3R_116() {
        if (this.jj_scan_token(67)) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_scan_token(5)) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_53() {
        return this.jj_scan_token(105);
    }

    private boolean jj_3R_131() {
        if (this.jj_scan_token(93)) {
            return true;
        } else {
            return this.jj_3R_17();
        }
    }

    private boolean jj_3R_102() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_116()) {
            this.jj_scanpos = var1;
            if (this.jj_scan_token(35)) {
                this.jj_scanpos = var1;
                if (this.jj_scan_token(42)) {
                    return true;
                }
            }
        }

        var1 = this.jj_scanpos;
        if (this.jj_3R_117()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_118()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_27() {
        return this.jj_scan_token(23);
    }

    private boolean jj_3R_111() {
        if (this.jj_3R_17()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_131()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_43() {
        return this.jj_scan_token(19);
    }

    private boolean jj_3R_49() {
        return this.jj_3R_53();
    }

    private boolean jj_3R_42() {
        return this.jj_scan_token(41);
    }

    private boolean jj_3R_36() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_48()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_49()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_48() {
        return this.jj_3R_19();
    }

    private boolean jj_3R_41() {
        return this.jj_scan_token(40);
    }

    private boolean jj_3R_40() {
        return this.jj_scan_token(10);
    }

    private boolean jj_3R_25() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_39()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_40()) {
                this.jj_scanpos = var1;
                if (this.jj_3R_41()) {
                    this.jj_scanpos = var1;
                    if (this.jj_3R_42()) {
                        this.jj_scanpos = var1;
                        if (this.jj_3R_43()) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean jj_3R_39() {
        return this.jj_scan_token(64);
    }

    private boolean jj_3R_115() {
        if (this.jj_scan_token(31)) {
            return true;
        } else {
            return this.jj_3R_64();
        }
    }

    private boolean jj_3_11() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(7)) {
            this.jj_scanpos = var1;
            if (this.jj_scan_token(5)) {
                this.jj_scanpos = var1;
                if (this.jj_3R_23()) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean jj_3R_128() {
        return this.jj_scan_token(53);
    }

    private boolean jj_3R_126() {
        return this.jj_scan_token(100);
    }

    private boolean jj_3R_125() {
        return this.jj_scan_token(99);
    }

    private boolean jj_3R_105() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_128()) {
            this.jj_scanpos = var1;
        }

        return this.jj_3R_36();
    }

    private boolean jj_3R_101() {
        if (this.jj_scan_token(30)) {
            return true;
        } else if (this.jj_scan_token(14)) {
            return true;
        } else if (this.jj_3R_70()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_115()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_124() {
        return this.jj_scan_token(98);
    }

    private boolean jj_3R_123() {
        return this.jj_scan_token(97);
    }

    private boolean jj_3R_62() {
        if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_64()) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_122() {
        return this.jj_scan_token(96);
    }

    private boolean jj_3R_61() {
        return this.jj_scan_token(85);
    }

    private boolean jj_3R_121() {
        return this.jj_scan_token(95);
    }

    private boolean jj_3R_132() {
        return this.jj_scan_token(5);
    }

    private boolean jj_3R_127() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_132()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_133()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_120() {
        return this.jj_scan_token(94);
    }

    private boolean jj_3R_119() {
        return this.jj_scan_token(92);
    }

    private boolean jj_3R_103() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_119()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_120()) {
                this.jj_scanpos = var1;
                if (this.jj_3R_121()) {
                    this.jj_scanpos = var1;
                    if (this.jj_3R_122()) {
                        this.jj_scanpos = var1;
                        if (this.jj_3R_123()) {
                            this.jj_scanpos = var1;
                            if (this.jj_3R_124()) {
                                this.jj_scanpos = var1;
                                if (this.jj_3R_125()) {
                                    this.jj_scanpos = var1;
                                    if (this.jj_3R_126()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean jj_3R_114() {
        if (this.jj_scan_token(63)) {
            return true;
        } else if (this.jj_scan_token(73)) {
            return true;
        } else {
            return this.jj_3R_64();
        }
    }

    private boolean jj_3R_113() {
        if (this.jj_scan_token(63)) {
            return true;
        } else if (this.jj_scan_token(73)) {
            return true;
        } else {
            return this.jj_3R_64();
        }
    }

    private boolean jj_3R_104() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_127()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_77()) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_60() {
        return this.jj_scan_token(86);
    }

    private boolean jj_3R_59() {
        return this.jj_scan_token(76);
    }

    private boolean jj_3R_100() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_113()) {
            this.jj_scanpos = var1;
        }

        if (this.jj_scan_token(18)) {
            return true;
        } else if (this.jj_scan_token(14)) {
            return true;
        } else if (this.jj_3R_64()) {
            return true;
        } else {
            var1 = this.jj_scanpos;
            if (this.jj_3R_114()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_58() {
        return this.jj_3R_63();
    }

    private boolean jj_3R_29() {
        return this.jj_scan_token(82);
    }

    private boolean jj_3R_17() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_29()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_30()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3_15() {
        return this.jj_3R_28();
    }

    private boolean jj_3R_26() {
        return this.jj_scan_token(5);
    }

    private boolean jj_3_12() {
        return this.jj_3R_24();
    }

    private boolean jj_3R_92() {
        if (this.jj_3R_103()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_104()) {
                this.jj_scanpos = var1;
                if (this.jj_3R_105()) {
                    return true;
                }
            }

            return false;
        }
    }

    private boolean jj_3R_99() {
        if (this.jj_scan_token(72)) {
            return true;
        } else {
            return this.jj_3R_64();
        }
    }

    private boolean jj_3_14() {
        if (this.jj_3R_25()) {
            return true;
        } else if (this.jj_scan_token(88)) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_26()) {
                this.jj_scanpos = var1;
                if (this.jj_3R_27()) {
                    return true;
                }
            }

            if (this.jj_3R_63()) {
                return true;
            } else {
                return this.jj_scan_token(90);
            }
        }
    }

    private boolean jj_3R_69() {
        if (this.jj_scan_token(93)) {
            return true;
        } else {
            return this.jj_3R_17();
        }
    }

    private boolean jj_3R_65() {
        if (this.jj_scan_token(93)) {
            return true;
        } else if (this.jj_3R_17()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_69()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3_13() {
        if (this.jj_scan_token(19)) {
            return true;
        } else if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_scan_token(103)) {
            return true;
        } else {
            return this.jj_scan_token(90);
        }
    }

    private boolean jj_3R_63() {
        if (this.jj_3R_17()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_65()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_57() {
        return this.jj_3R_24();
    }

    private boolean jj_3R_112() {
        return this.jj_scan_token(82);
    }

    private boolean jj_3R_55() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_56()) {
            this.jj_scanpos = var1;
            if (this.jj_3R_57()) {
                this.jj_scanpos = var1;
                if (this.jj_3_13()) {
                    this.jj_scanpos = var1;
                    if (this.jj_3_14()) {
                        this.jj_scanpos = var1;
                        if (this.jj_3_15()) {
                            this.jj_scanpos = var1;
                            if (this.jj_3R_58()) {
                                this.jj_scanpos = var1;
                                if (this.jj_3R_59()) {
                                    this.jj_scanpos = var1;
                                    if (this.jj_3R_60()) {
                                        this.jj_scanpos = var1;
                                        if (this.jj_3R_61()) {
                                            this.jj_scanpos = var1;
                                            if (this.jj_3R_62()) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean jj_3R_56() {
        return this.jj_scan_token(47);
    }

    private boolean jj_3R_73() {
        if (this.jj_scan_token(89)) {
            return true;
        } else {
            return this.jj_3R_36();
        }
    }

    private boolean jj_3R_97() {
        if (this.jj_3R_111()) {
            return true;
        } else {
            Token var1 = this.jj_scanpos;
            if (this.jj_3R_112()) {
                this.jj_scanpos = var1;
            }

            return false;
        }
    }

    private boolean jj_3R_70() {
        if (this.jj_3R_36()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_73());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_98() {
        if (this.jj_scan_token(89)) {
            return true;
        } else {
            return this.jj_3R_97();
        }
    }

    private boolean jj_3R_87() {
        if (this.jj_scan_token(29)) {
            return true;
        } else if (this.jj_3R_97()) {
            return true;
        } else {
            Token var1;
            do {
                var1 = this.jj_scanpos;
            } while(!this.jj_3R_98());

            this.jj_scanpos = var1;
            return false;
        }
    }

    private boolean jj_3R_84() {
        return this.jj_3R_93();
    }

    private boolean jj_3_10() {
        return this.jj_3R_22();
    }

    private boolean jj_3_9() {
        return this.jj_3R_21();
    }

    private boolean jj_3_8() {
        return this.jj_3R_20();
    }

    private boolean jj_3R_54() {
        Token var1 = this.jj_scanpos;
        if (this.jj_scan_token(101)) {
            this.jj_scanpos = var1;
            if (this.jj_scan_token(102)) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_83() {
        return this.jj_3R_92();
    }

    private boolean jj_3R_80() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_83()) {
            this.jj_scanpos = var1;
            if (this.jj_3_8()) {
                this.jj_scanpos = var1;
                if (this.jj_3_9()) {
                    this.jj_scanpos = var1;
                    if (this.jj_3_10()) {
                        this.jj_scanpos = var1;
                        if (this.jj_3R_84()) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean jj_3R_51() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_54()) {
            this.jj_scanpos = var1;
        }

        return this.jj_3R_55();
    }

    private boolean jj_3_4() {
        if (this.jj_3R_17()) {
            return true;
        } else if (this.jj_scan_token(93)) {
            return true;
        } else if (this.jj_3R_17()) {
            return true;
        } else {
            return this.jj_scan_token(104);
        }
    }

    private boolean jj_3_3() {
        if (this.jj_3R_17()) {
            return true;
        } else {
            return this.jj_scan_token(104);
        }
    }

    private boolean jj_3R_16() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3_3()) {
            this.jj_scanpos = var1;
            if (this.jj_3_4()) {
                return true;
            }
        }

        return false;
    }

    private boolean jj_3R_82() {
        return this.jj_scan_token(53);
    }

    private boolean jj_3_7() {
        if (this.jj_scan_token(88)) {
            return true;
        } else if (this.jj_3R_19()) {
            return true;
        } else {
            return this.jj_scan_token(89);
        }
    }

    private boolean jj_3R_136() {
        return this.jj_scan_token(87);
    }

    private boolean jj_3R_79() {
        Token var1 = this.jj_scanpos;
        if (this.jj_3R_82()) {
            this.jj_scanpos = var1;
        }

        return this.jj_3R_19();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{134250496, 0, 0, 135311360, 69337088, 67108864, 69337088, 0, 65536, 0, 0, 0, 65536, 0, 16777216, 0, 0, 16777216, 0, 0, 0, 34079744, 0, 0, 0, 536870912, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268435456, 8388640, 8388640, 0, 262144, 1073741824, 0, 0, 525312, 256, 525312, 256, 0, 0, 0, 0, 0, 0, -2147483648, 32, 0, 0, 4194816, 4194816, 0, 4194816, 4194816, 0, 0, 0, 64, 0, 525312, 0, 0, 525312, 0, 0, 2048, 0, 160, 160, 0, 525312, 525312, 0, 525312, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388640, 0, 0, 525312, 525312, 525312, 0, 0};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{16846852, 0, 0, 16846852, 440402050, 4194304, 440402050, 0, 0, 0, 16384, 0, 0, 262144, 536870912, 67108864, 67108864, 603979776, 0, 0, 0, 2138880, 0, 0, 134217728, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048576, 0, 0, 0, 0, -2147483648, 0, 1032, 0, 33536, 0, 33536, 0, 0, 0, 0, 0, -2147483648, -2147483648, 0, 0, 1032, 134217728, 0, 0, 0, 0, 0, 0, 131072, 524288, 0, 8192, 2138880, 8192, 2097152, 2130688, 0, 32, 8289, 0, 0, 0, 2097152, 2130688, 33536, 8192, 134251264, 8192, 8192, 8192, 0, 0, 0, 0, 0, 0, 0, 0, 32768, 0, 768, 768, 33536, 0, 0};
    }

    private static void jj_la1_init_2() {
        jj_la1_2 = new int[]{192, 33554432, 16777216, 192, 16, 0, 16, 1024, 0, 33554432, 0, 1024, 0, 2048, 0, 16, 16, 0, 262144, 256, 33554432, 31723521, 33554432, 16777216, 32, 0, 256, 536870912, 536870912, 8650752, -805306368, 536870912, 0, 0, 266240, 0, 0, 0, 0, 256, 0, 0, 8, 33554432, 31723521, 8650752, 31723521, 0, 262144, 8650752, 33554432, 262144, 0, 0, 0, 0, 8, 0, 0, 0, 33554432, 0, 0, 33554432, 0, 0, 0, 0, 31723521, 0, 0, 31723521, -805306368, 0, -805306368, 33554432, 0, 0, 0, 31723521, 31723521, 0, 31723521, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31723520, 1, 262145, 31723521, 536870912, 536870912};
    }

    private static void jj_la1_init_3() {
        jj_la1_3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 608, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 96, 96, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 224, 0, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 96, 0, 0, 96, 31, 0, 31, 0, 0, 0, 0, 608, 608, 0, 608, 0, 0, 0, 1120, 1120, 2176, 2176, 4096, 96, 96, 0, 0, 0, 0, 0, 608, 0, 0};
    }

    public ZqlJJParser(InputStream var1) {
        this(var1, (String)null);
    }

    public ZqlJJParser(InputStream var1, String var2) {
        this.jj_la1 = new int[101];
        this.jj_2_rtns = new ZqlJJParser.JJCalls[15];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new ZqlJJParser.LookaheadSuccess();
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];

        try {
            this.jj_input_stream = new SimpleCharStream(var1, var2, 1, 1);
        } catch (UnsupportedEncodingException var4) {
            throw new RuntimeException(var4);
        }

        this.token_source = new ZqlJJParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var3;
        for(var3 = 0; var3 < 101; ++var3) {
            this.jj_la1[var3] = -1;
        }

        for(var3 = 0; var3 < this.jj_2_rtns.length; ++var3) {
            this.jj_2_rtns[var3] = new ZqlJJParser.JJCalls();
        }

    }

    public void ReInit(InputStream var1) {
        this.ReInit(var1, (String)null);
    }

    public void ReInit(InputStream var1, String var2) {
        try {
            this.jj_input_stream.ReInit(var1, var2, 1, 1);
        } catch (UnsupportedEncodingException var4) {
            throw new RuntimeException(var4);
        }

        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var3;
        for(var3 = 0; var3 < 101; ++var3) {
            this.jj_la1[var3] = -1;
        }

        for(var3 = 0; var3 < this.jj_2_rtns.length; ++var3) {
            this.jj_2_rtns[var3] = new ZqlJJParser.JJCalls();
        }

    }

    public ZqlJJParser(Reader var1) {
        this.jj_la1 = new int[101];
        this.jj_2_rtns = new ZqlJJParser.JJCalls[15];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new ZqlJJParser.LookaheadSuccess();
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.jj_input_stream = new SimpleCharStream(var1, 1, 1);
        this.token_source = new ZqlJJParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var2;
        for(var2 = 0; var2 < 101; ++var2) {
            this.jj_la1[var2] = -1;
        }

        for(var2 = 0; var2 < this.jj_2_rtns.length; ++var2) {
            this.jj_2_rtns[var2] = new ZqlJJParser.JJCalls();
        }

    }

    public void ReInit(Reader var1) {
        this.jj_input_stream.ReInit(var1, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var2;
        for(var2 = 0; var2 < 101; ++var2) {
            this.jj_la1[var2] = -1;
        }

        for(var2 = 0; var2 < this.jj_2_rtns.length; ++var2) {
            this.jj_2_rtns[var2] = new ZqlJJParser.JJCalls();
        }

    }

    public ZqlJJParser(ZqlJJParserTokenManager var1) {
        this.jj_la1 = new int[101];
        this.jj_2_rtns = new ZqlJJParser.JJCalls[15];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new ZqlJJParser.LookaheadSuccess();
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = var1;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var2;
        for(var2 = 0; var2 < 101; ++var2) {
            this.jj_la1[var2] = -1;
        }

        for(var2 = 0; var2 < this.jj_2_rtns.length; ++var2) {
            this.jj_2_rtns[var2] = new ZqlJJParser.JJCalls();
        }

    }

    public void ReInit(ZqlJJParserTokenManager var1) {
        this.token_source = var1;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;

        int var2;
        for(var2 = 0; var2 < 101; ++var2) {
            this.jj_la1[var2] = -1;
        }

        for(var2 = 0; var2 < this.jj_2_rtns.length; ++var2) {
            this.jj_2_rtns[var2] = new ZqlJJParser.JJCalls();
        }

    }

    private Token jj_consume_token(int var1) throws ParseException {
        Token var2;
        if ((var2 = this.token).next != null) {
            this.token = this.token.next;
        } else {
            this.token = this.token.next = this.token_source.getNextToken();
        }

        this.jj_ntk = -1;
        if (this.token.kind != var1) {
            this.token = var2;
            this.jj_kind = var1;
            throw this.generateParseException();
        } else {
            ++this.jj_gen;
            if (++this.jj_gc > 100) {
                this.jj_gc = 0;

                for(int var3 = 0; var3 < this.jj_2_rtns.length; ++var3) {
                    for(ZqlJJParser.JJCalls var4 = this.jj_2_rtns[var3]; var4 != null; var4 = var4.next) {
                        if (var4.gen < this.jj_gen) {
                            var4.first = null;
                        }
                    }
                }
            }

            return this.token;
        }
    }

    private boolean jj_scan_token(int var1) {
        if (this.jj_scanpos == this.jj_lastpos) {
            --this.jj_la;
            if (this.jj_scanpos.next == null) {
                this.jj_lastpos = this.jj_scanpos = this.jj_scanpos.next = this.token_source.getNextToken();
            } else {
                this.jj_lastpos = this.jj_scanpos = this.jj_scanpos.next;
            }
        } else {
            this.jj_scanpos = this.jj_scanpos.next;
        }

        if (this.jj_rescan) {
            int var2 = 0;

            Token var3;
            for(var3 = this.token; var3 != null && var3 != this.jj_scanpos; var3 = var3.next) {
                ++var2;
            }

            if (var3 != null) {
                this.jj_add_error_token(var1, var2);
            }
        }

        if (this.jj_scanpos.kind != var1) {
            return true;
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            throw this.jj_ls;
        } else {
            return false;
        }
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            this.token = this.token.next = this.token_source.getNextToken();
        }

        this.jj_ntk = -1;
        ++this.jj_gen;
        return this.token;
    }

    public final Token getToken(int var1) {
        Token var2 = this.token;

        for(int var3 = 0; var3 < var1; ++var3) {
            if (var2.next != null) {
                var2 = var2.next;
            } else {
                var2 = var2.next = this.token_source.getNextToken();
            }
        }

        return var2;
    }

    private int jj_ntk() {
        return (this.jj_nt = this.token.next) == null ? (this.jj_ntk = (this.token.next = this.token_source.getNextToken()).kind) : (this.jj_ntk = this.jj_nt.kind);
    }

    private void jj_add_error_token(int var1, int var2) {
        if (var2 < 100) {
            if (var2 == this.jj_endpos + 1) {
                this.jj_lasttokens[this.jj_endpos++] = var1;
            } else if (this.jj_endpos != 0) {
                this.jj_expentry = new int[this.jj_endpos];

                for(int var3 = 0; var3 < this.jj_endpos; ++var3) {
                    this.jj_expentry[var3] = this.jj_lasttokens[var3];
                }

                Iterator var6 = this.jj_expentries.iterator();

                label41:
                while(true) {
                    int[] var4;
                    do {
                        if (!var6.hasNext()) {
                            break label41;
                        }

                        var4 = (int[])((int[])var6.next());
                    } while(var4.length != this.jj_expentry.length);

                    for(int var5 = 0; var5 < this.jj_expentry.length; ++var5) {
                        if (var4[var5] != this.jj_expentry[var5]) {
                            continue label41;
                        }
                    }

                    this.jj_expentries.add(this.jj_expentry);
                    break;
                }

                if (var2 != 0) {
                    this.jj_lasttokens[(this.jj_endpos = var2) - 1] = var1;
                }
            }

        }
    }

    public ParseException generateParseException() {
        this.jj_expentries.clear();
        boolean[] var1 = new boolean[109];
        if (this.jj_kind >= 0) {
            var1[this.jj_kind] = true;
            this.jj_kind = -1;
        }

        int var2;
        int var3;
        for(var2 = 0; var2 < 101; ++var2) {
            if (this.jj_la1[var2] == this.jj_gen) {
                for(var3 = 0; var3 < 32; ++var3) {
                    if ((jj_la1_0[var2] & 1 << var3) != 0) {
                        var1[var3] = true;
                    }

                    if ((jj_la1_1[var2] & 1 << var3) != 0) {
                        var1[32 + var3] = true;
                    }

                    if ((jj_la1_2[var2] & 1 << var3) != 0) {
                        var1[64 + var3] = true;
                    }

                    if ((jj_la1_3[var2] & 1 << var3) != 0) {
                        var1[96 + var3] = true;
                    }
                }
            }
        }

        for(var2 = 0; var2 < 109; ++var2) {
            if (var1[var2]) {
                this.jj_expentry = new int[1];
                this.jj_expentry[0] = var2;
                this.jj_expentries.add(this.jj_expentry);
            }
        }

        this.jj_endpos = 0;
        this.jj_rescan_token();
        this.jj_add_error_token(0, 0);
        int[][] var4 = new int[this.jj_expentries.size()][];

        for(var3 = 0; var3 < this.jj_expentries.size(); ++var3) {
            var4[var3] = (int[])((int[])this.jj_expentries.get(var3));
        }

        return new ParseException(this.token, var4, tokenImage);
    }

    public final void enable_tracing() {
    }

    public final void disable_tracing() {
    }

    private void jj_rescan_token() {
        this.jj_rescan = true;

        for(int var1 = 0; var1 < 15; ++var1) {
            try {
                ZqlJJParser.JJCalls var2 = this.jj_2_rtns[var1];

                do {
                    if (var2.gen > this.jj_gen) {
                        this.jj_la = var2.arg;
                        this.jj_lastpos = this.jj_scanpos = var2.first;
                        switch(var1) {
                            case 0:
                                this.jj_3_1();
                                break;
                            case 1:
                                this.jj_3_2();
                                break;
                            case 2:
                                this.jj_3_3();
                                break;
                            case 3:
                                this.jj_3_4();
                                break;
                            case 4:
                                this.jj_3_5();
                                break;
                            case 5:
                                this.jj_3_6();
                                break;
                            case 6:
                                this.jj_3_7();
                                break;
                            case 7:
                                this.jj_3_8();
                                break;
                            case 8:
                                this.jj_3_9();
                                break;
                            case 9:
                                this.jj_3_10();
                                break;
                            case 10:
                                this.jj_3_11();
                                break;
                            case 11:
                                this.jj_3_12();
                                break;
                            case 12:
                                this.jj_3_13();
                                break;
                            case 13:
                                this.jj_3_14();
                                break;
                            case 14:
                                this.jj_3_15();
                        }
                    }

                    var2 = var2.next;
                } while(var2 != null);
            } catch (ZqlJJParser.LookaheadSuccess var3) {
            }
        }

        this.jj_rescan = false;
    }

    private void jj_save(int var1, int var2) {
        ZqlJJParser.JJCalls var3;
        for(var3 = this.jj_2_rtns[var1]; var3.gen > this.jj_gen; var3 = var3.next) {
            if (var3.next == null) {
                var3 = var3.next = new ZqlJJParser.JJCalls();
                break;
            }
        }

        var3.gen = this.jj_gen + var2 - this.jj_la;
        var3.first = this.token;
        var3.arg = var2;
    }

    static {
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
        jj_la1_init_3();
    }

    static final class JJCalls {
        int gen;
        Token first;
        int arg;
        ZqlJJParser.JJCalls next;

        JJCalls() {
        }
    }

    private static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }
    }
}
