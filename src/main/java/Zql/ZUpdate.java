//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zql;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class ZUpdate implements ZStatement {
    String table_;
    String alias_ = null;
    Hashtable set_;
    ZExp where_ = null;
    Vector columns_ = null;

    public ZUpdate(String var1) {
        this.table_ = new String(var1);
    }

    public String getTable() {
        return this.table_;
    }

    public void setAlias(String var1) {
        this.alias_ = var1;
    }

    public String getAlias() {
        return this.alias_;
    }

    public void addSet(Hashtable var1) {
        this.set_ = var1;
    }

    public Hashtable getSet() {
        return this.set_;
    }

    public void addColumnUpdate(String var1, ZExp var2) {
        if (this.set_ == null) {
            this.set_ = new Hashtable();
        }

        this.set_.put(var1, var2);
        if (this.columns_ == null) {
            this.columns_ = new Vector();
        }

        this.columns_.addElement(var1);
    }

    public ZExp getColumnUpdate(String var1) {
        return (ZExp)this.set_.get(var1);
    }

    public ZExp getColumnUpdate(int var1) {
        --var1;
        if (var1 < 0) {
            return null;
        } else if (this.columns_ != null && var1 < this.columns_.size()) {
            String var2 = (String)this.columns_.elementAt(var1);
            return (ZExp)this.set_.get(var2);
        } else {
            return null;
        }
    }

    public String getColumnUpdateName(int var1) {
        --var1;
        if (var1 < 0) {
            return null;
        } else {
            return this.columns_ != null && var1 < this.columns_.size() ? (String)this.columns_.elementAt(var1) : null;
        }
    }

    public int getColumnUpdateCount() {
        return this.set_ == null ? 0 : this.set_.size();
    }

    public void addWhere(ZExp var1) {
        this.where_ = var1;
    }

    public ZExp getWhere() {
        return this.where_;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer("update " + this.table_);
        if (this.alias_ != null) {
            var1.append(" " + this.alias_);
        }

        var1.append(" set ");
        Enumeration var2;
        if (this.columns_ != null) {
            var2 = this.columns_.elements();
        } else {
            var2 = this.set_.keys();
        }

        for(boolean var3 = true; var2.hasMoreElements(); var3 = false) {
            String var4 = var2.nextElement().toString();
            if (!var3) {
                var1.append(", ");
            }

            var1.append(var4 + "=" + this.set_.get(var4).toString());
        }

        if (this.where_ != null) {
            var1.append(" where " + this.where_.toString());
        }

        return var1.toString();
    }
}
