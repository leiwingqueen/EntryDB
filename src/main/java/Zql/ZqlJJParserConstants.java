/*     */ package Zql;
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
/*     */ public interface ZqlJJParserConstants
/*     */ {
/*     */   public static final int EOF = 0;
/*     */   public static final int K_ALL = 5;
/*     */   public static final int K_AND = 6;
/*     */   public static final int K_ANY = 7;
/*     */   public static final int K_AS = 8;
/*     */   public static final int K_ASC = 9;
/*     */   public static final int K_AVG = 10;
/*     */   public static final int K_BETWEEN = 11;
/*     */   public static final int K_BINARY_INTEGER = 12;
/*     */   public static final int K_BOOLEAN = 13;
/*     */   public static final int K_BY = 14;
/*     */   public static final int K_CHAR = 15;
/*     */   public static final int K_COMMENT = 16;
/*     */   public static final int K_COMMIT = 17;
/*     */   public static final int K_CONNECT = 18;
/*     */   public static final int K_COUNT = 19;
/*     */   public static final int K_DATE = 20;
/*     */   public static final int K_DELETE = 21;
/*     */   public static final int K_DESC = 22;
/*     */   public static final int K_DISTINCT = 23;
/*     */   public static final int K_EXCLUSIVE = 24;
/*     */   public static final int K_EXISTS = 25;
/*     */   public static final int K_EXIT = 26;
/*     */   public static final int K_FLOAT = 27;
/*     */   public static final int K_FOR = 28;
/*     */   public static final int K_FROM = 29;
/*     */   public static final int K_GROUP = 30;
/*     */   public static final int K_HAVING = 31;
/*     */   public static final int K_IN = 32;
/*     */   public static final int K_INSERT = 33;
/*     */   public static final int K_INTEGER = 34;
/*     */   public static final int K_INTERSECT = 35;
/*     */   public static final int K_INTO = 36;
/*     */   public static final int K_IS = 37;
/*     */   public static final int K_LIKE = 38;
/*     */   public static final int K_LOCK = 39;
/*     */   public static final int K_MAX = 40;
/*     */   public static final int K_MIN = 41;
/*     */   public static final int K_MINUS = 42;
/*     */   public static final int K_MODE = 43;
/*     */   public static final int K_NATURAL = 44;
/*     */   public static final int K_NOT = 45;
/*     */   public static final int K_NOWAIT = 46;
/*     */   public static final int K_NULL = 47;
/*     */   public static final int K_NUMBER = 48;
/*     */   public static final int K_OF = 49;
/*     */   public static final int K_ONLY = 50;
/*     */   public static final int K_OR = 51;
/*     */   public static final int K_ORDER = 52;
/*     */   public static final int K_PRIOR = 53;
/*     */   public static final int K_QUIT = 54;
/*     */   public static final int K_READ = 55;
/*     */   public static final int K_REAL = 56;
/*     */   public static final int K_ROLLBACK = 57;
/*     */   public static final int K_ROW = 58;
/*     */   public static final int K_SELECT = 59;
/*     */   public static final int K_SET = 60;
/*     */   public static final int K_SHARE = 61;
/*     */   public static final int K_SMALLINT = 62;
/*     */   public static final int K_START = 63;
/*     */   public static final int K_SUM = 64;
/*     */   public static final int K_TABLE = 65;
/*     */   public static final int K_TRANSACTION = 66;
/*     */   public static final int K_UNION = 67;
/*     */   public static final int K_UPDATE = 68;
/*     */   public static final int K_VALUES = 69;
/*     */   public static final int K_VARCHAR2 = 70;
/*     */   public static final int K_VARCHAR = 71;
/*     */   public static final int K_WHERE = 72;
/*     */   public static final int K_WITH = 73;
/*     */   public static final int K_WORK = 74;
/*     */   public static final int K_WRITE = 75;
/*     */   public static final int S_NUMBER = 76;
/*     */   public static final int FLOAT = 77;
/*     */   public static final int INTEGER = 78;
/*     */   public static final int DIGIT = 79;
/*     */   public static final int LINE_COMMENT = 80;
/*     */   public static final int MULTI_LINE_COMMENT = 81;
/*     */   public static final int S_IDENTIFIER = 82;
/*     */   public static final int LETTER = 83;
/*     */   public static final int SPECIAL_CHARS = 84;
/*     */   public static final int S_BIND = 85;
/*     */   public static final int S_CHAR_LITERAL = 86;
/*     */   public static final int S_QUOTED_IDENTIFIER = 87;
/*     */   public static final int DEFAULT = 0;
/* 184 */   public static final String[] tokenImage = new String[] { "<EOF>", "\" \"", "\"\\t\"", "\"\\r\"", "\"\\n\"", "\"ALL\"", "\"AND\"", "\"ANY\"", "\"AS\"", "\"ASC\"", "\"AVG\"", "\"BETWEEN\"", "\"BINARY_INTEGER\"", "\"BOOLEAN\"", "\"BY\"", "\"CHAR\"", "\"COMMENT\"", "\"COMMIT\"", "\"CONNECT\"", "\"COUNT\"", "\"DATE\"", "\"DELETE\"", "\"DESC\"", "\"DISTINCT\"", "\"EXCLUSIVE\"", "\"EXISTS\"", "\"EXIT\"", "\"FLOAT\"", "\"FOR\"", "\"FROM\"", "\"GROUP\"", "\"HAVING\"", "\"IN\"", "\"INSERT\"", "\"INTEGER\"", "\"INTERSECT\"", "\"INTO\"", "\"IS\"", "\"LIKE\"", "\"LOCK\"", "\"MAX\"", "\"MIN\"", "\"MINUS\"", "\"MODE\"", "\"NATURAL\"", "\"NOT\"", "\"NOWAIT\"", "\"NULL\"", "\"NUMBER\"", "\"OF\"", "\"ONLY\"", "\"OR\"", "\"ORDER\"", "\"PRIOR\"", "\"QUIT\"", "\"READ\"", "\"REAL\"", "\"ROLLBACK\"", "\"ROW\"", "\"SELECT\"", "\"SET\"", "\"SHARE\"", "\"SMALLINT\"", "\"START\"", "\"SUM\"", "\"TABLE\"", "\"TRANSACTION\"", "\"UNION\"", "\"UPDATE\"", "\"VALUES\"", "\"VARCHAR2\"", "\"VARCHAR\"", "\"WHERE\"", "\"WITH\"", "\"WORK\"", "\"WRITE\"", "<S_NUMBER>", "<FLOAT>", "<INTEGER>", "<DIGIT>", "<LINE_COMMENT>", "<MULTI_LINE_COMMENT>", "<S_IDENTIFIER>", "<LETTER>", "<SPECIAL_CHARS>", "<S_BIND>", "<S_CHAR_LITERAL>", "<S_QUOTED_IDENTIFIER>", "\"(\"", "\",\"", "\")\"", "\";\"", "\"=\"", "\".\"", "\"!=\"", "\"#\"", "\"<>\"", "\">\"", "\">=\"", "\"<\"", "\"<=\"", "\"+\"", "\"-\"", "\"*\"", "\".*\"", "\"?\"", "\"||\"", "\"/\"", "\"**\"" };
/*     */ }


/* Location:              /Users/liyongquan/Documents/file.nosync/private_project/EntryDB/lib/zql.jar!/Zql/ZqlJJParserConstants.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */