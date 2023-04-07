//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zql;

import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class ZTuple {
    private Vector attributes_;
    private Vector values_;
    private Hashtable searchTable_;

    public ZTuple() {
        this.attributes_ = new Vector();
        this.values_ = new Vector();
        this.searchTable_ = new Hashtable();
    }

    public ZTuple(String var1) {
        this();
        StringTokenizer var2 = new StringTokenizer(var1, ",");

        while(var2.hasMoreTokens()) {
            this.setAtt(var2.nextToken().trim(), (Object)null);
        }

    }

    public void setRow(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ",");

        for(int var3 = 0; var2.hasMoreTokens(); ++var3) {
            String var4 = var2.nextToken().trim();

            try {
                Double var5 = new Double(var4);
                this.setAtt(this.getAttName(var3), var5);
            } catch (Exception var6) {
                this.setAtt(this.getAttName(var3), var4);
            }
        }

    }

    public void setRow(Vector var1) {
        for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.setAtt(this.getAttName(var2), var1.elementAt(var2));
        }

    }

    public void setAtt(String var1, Object var2) {
        if (var1 != null) {
            boolean var3 = this.searchTable_.containsKey(var1);
            int var4;
            if (var3) {
                var4 = (Integer)this.searchTable_.get(var1);
                this.values_.setElementAt(var2, var4);
            } else {
                var4 = this.attributes_.size();
                this.attributes_.addElement(var1);
                this.values_.addElement(var2);
                this.searchTable_.put(var1, new Integer(var4));
            }
        }

    }

    public String getAttName(int var1) {
        try {
            return (String)this.attributes_.elementAt(var1);
        } catch (ArrayIndexOutOfBoundsException var3) {
            return null;
        }
    }

    public int getAttIndex(String var1) {
        if (var1 == null) {
            return -1;
        } else {
            Integer var2 = (Integer)this.searchTable_.get(var1);
            return var2 != null ? var2 : -1;
        }
    }

    public Object getAttValue(int var1) {
        try {
            return this.values_.elementAt(var1);
        } catch (ArrayIndexOutOfBoundsException var3) {
            return null;
        }
    }

    public Object getAttValue(String var1) {
        boolean var2 = false;
        if (var1 != null) {
            var2 = this.searchTable_.containsKey(var1);
        }

        if (var2) {
            int var3 = (Integer)this.searchTable_.get(var1);
            return this.values_.elementAt(var3);
        } else {
            return null;
        }
    }

    public boolean isAttribute(String var1) {
        return var1 != null ? this.searchTable_.containsKey(var1) : false;
    }

    public int getNumAtt() {
        return this.values_.size();
    }

    public String toString() {
        StringBuffer var5 = new StringBuffer();
        var5.append("[");
        Object var1;
        Object var2;
        String var3;
        String var4;
        if (this.attributes_.size() > 0) {
            var1 = this.attributes_.elementAt(0);
            if (var1 == null) {
                var3 = "(null)";
            } else {
                var3 = var1.toString();
            }

            var2 = this.values_.elementAt(0);
            if (var2 == null) {
                var4 = "(null)";
            } else {
                var4 = var2.toString();
            }

            var5.append(var3 + " = " + var4);
        }

        for(int var6 = 1; var6 < this.attributes_.size(); ++var6) {
            var1 = this.attributes_.elementAt(var6);
            if (var1 == null) {
                var3 = "(null)";
            } else {
                var3 = var1.toString();
            }

            var2 = this.values_.elementAt(var6);
            if (var2 == null) {
                var4 = "(null)";
            } else {
                var4 = var2.toString();
            }

            var5.append(", " + var3 + " = " + var4);
        }

        var5.append("]");
        return var5.toString();
    }
}
