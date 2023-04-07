/*    */ package Zql;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZUtils
/*    */ {
/*  9 */   private static Hashtable fcts_ = null;
/*    */   
/*    */   public static final int VARIABLE_PLIST = 10000;
/*    */   
/*    */   public static void addCustomFunction(String paramString, int paramInt) {
/* 14 */     if (fcts_ == null) fcts_ = new Hashtable(); 
/* 15 */     if (paramInt < 0) paramInt = 1; 
/* 16 */     fcts_.put(paramString.toUpperCase(), new Integer(paramInt));
/*    */   }
/*    */   
/*    */   public static int isCustomFunction(String paramString) {
/*    */     Integer integer;
/* 21 */     if (paramString == null || paramString.length() < 1 || fcts_ == null || (integer = (Integer)fcts_.get(paramString.toUpperCase())) == null)
/*    */     {
/* 23 */       return -1; } 
/* 24 */     return integer.intValue();
/*    */   }
/*    */   
/*    */   public static boolean isAggregate(String paramString) {
/* 28 */     String str = paramString.toUpperCase().trim();
/* 29 */     return (str.equals("SUM") || str.equals("AVG") || str.equals("MAX") || str.equals("MIN") || str.equals("COUNT") || (fcts_ != null && fcts_.get(str) != null));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getAggregateCall(String paramString) {
/* 35 */     int i = paramString.indexOf('(');
/* 36 */     if (i <= 0) return null; 
/* 37 */     String str = paramString.substring(0, i);
/* 38 */     if (isAggregate(str)) return str.trim(); 
/* 39 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */