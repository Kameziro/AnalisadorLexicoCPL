package TabelaHash;

import java.util.HashMap;

    public class TabelaSimbolosReservados {
        public HashMap<String, Simbolo> tabela = new HashMap<>();
        public static int end = -1;
    
        public final byte FINAL = 0;
        public final byte INT = 1;
        public final byte BYTE = 2;
        public final byte STRING = 3;
        public final byte WHILE = 4;
        public final byte IF = 5;
        public final byte ELSE = 6;
        public final byte AND = 7;
        public final byte OR = 8;
        public final byte NOT = 9;
        public final byte EQUAL = 10;
        public final byte RECIEVE = 11;
        public final byte OPPAR = 12;
        public final byte CLPAR = 13;
        public final byte MORETHAN = 14;
        public final byte LESSTHAN = 15;
        public final byte DIFFERENT = 16;
        public final byte MOREEQUAL = 17;
        public final byte LESSEQUAL = 18;
        public final byte COMMA = 19;
        public final byte PLUS = 20;
        public final byte MINUS = 21;
        public final byte MULT = 22;
        public final byte DIVIDE = 23;
        public final byte DOTCOMMA = 24;
        public final byte BEGIN = 25;
        public final byte END = 26;
        public final byte READ = 27;
        public final byte READLN = 28;
        public final byte WRITE = 29;
        public final byte WRITELN = 30;
        public final byte TRUE = 31;
        public final byte FALSE = 32;
        public final byte BOOLEAN = 33;
        public final byte ID = 34;
        public final byte CONST = 35;
        public final byte DIV = 36;
        public final byte MOD = 37;
        public final byte PROCEDURE = 38;
        public final byte FUNCTION = 39;
        public final byte VAR = 40;
        public final byte ARRAY = 41;
        public final byte OF = 42;
        public final byte TYPE = 43;
        public final byte RECORD = 44;
        public final byte REPEAT = 45;
        public final byte UNTIL = 46;
        public final byte FOR = 47;
        public final byte TO = 48;
        public final byte DOWNTO = 49;
        public final byte DO = 50;
        public final byte CASE = 51;
        public final byte WITH = 52;
        public final byte LABEL = 53;
        public final byte GOTO = 54;
        public final byte EXIT = 55;
        public final byte PROGRAM = 56;
        public final byte DOT = 57;
    
        public TabelaSimbolosReservados() {
            this.tabela.put("final", new Simbolo(FINAL, "final", "KEYWORD", ++end));
            this.tabela.put("int", new Simbolo(INT, "int", "KEYWORD", ++end));
            this.tabela.put("byte", new Simbolo(BYTE, "byte", "KEYWORD", ++end));
            this.tabela.put("string", new Simbolo(STRING, "string", "KEYWORD", ++end));
            this.tabela.put("while", new Simbolo(WHILE, "while", "KEYWORD", ++end));
            this.tabela.put("if", new Simbolo(IF, "if", "KEYWORD", ++end));
            this.tabela.put("else", new Simbolo(ELSE, "else", "KEYWORD", ++end));
            this.tabela.put("and", new Simbolo(AND, "and", "KEYWORD", ++end));
            this.tabela.put("or", new Simbolo(OR, "or", "KEYWORD", ++end));
            this.tabela.put("not", new Simbolo(NOT, "not", "KEYWORD", ++end));
            this.tabela.put("==", new Simbolo(EQUAL, "==", "LOGIC_OPERATOR", ++end));
            this.tabela.put("=", new Simbolo(RECIEVE, "=", "OPERATOR", ++end));
            this.tabela.put("(", new Simbolo(OPPAR, "(", "DELIMITER", ++end));
            this.tabela.put(")", new Simbolo(CLPAR, ")", "DELIMITER", ++end));
            this.tabela.put(">", new Simbolo(MORETHAN, ">", "LOGIC_OPERATOR", ++end));
            this.tabela.put("<", new Simbolo(LESSTHAN, "<", "LOGIC_OPERATOR", ++end));
            this.tabela.put("!=", new Simbolo(DIFFERENT, "!=", "LOGIC_OPERATOR", ++end));
            this.tabela.put(">=", new Simbolo(MOREEQUAL, ">=", "LOGIC_OPERATOR", ++end));
            this.tabela.put("<=", new Simbolo(LESSEQUAL, "<=", "LOGIC_OPERATOR", ++end));
            this.tabela.put(",", new Simbolo(COMMA, ",", "DELIMITER", ++end));
            this.tabela.put("+", new Simbolo(PLUS, "+", "MAT_OPERATOR", ++end));
            this.tabela.put("-", new Simbolo(MINUS, "-", "MAT_OPERATOR", ++end));
            this.tabela.put("*", new Simbolo(MULT, "*", "MAT_OPERATOR", ++end));
            this.tabela.put("/", new Simbolo(DIVIDE, "/", "MAT_OPERATOR", ++end));
            this.tabela.put(";", new Simbolo(DOTCOMMA, ";", "DELIMITER", ++end));
            this.tabela.put(".", new Simbolo(DOT, ".", "DELIMITER", ++end));
            this.tabela.put("begin", new Simbolo(BEGIN, "begin", "KEYWORD", ++end));
            this.tabela.put("end", new Simbolo(END, "end", "KEYWORD", ++end));
            this.tabela.put("readln", new Simbolo(READLN, "readln", "KEYWORD", ++end));
            this.tabela.put("write", new Simbolo(WRITE, "write", "KEYWORD", ++end));
            this.tabela.put("writeln", new Simbolo(WRITELN, "writeln", "KEYWORD", ++end));
            this.tabela.put("read", new Simbolo(READ, "read", "KEYWORD", ++end));
            this.tabela.put("true", new Simbolo(TRUE, "true", "KEYWORD", ++end));
            this.tabela.put("false", new Simbolo(FALSE, "false", "KEYWORD", ++end));
            this.tabela.put("boolean", new Simbolo(BOOLEAN, "boolean", "KEYWORD", ++end));
            this.tabela.put("div", new Simbolo(DIV, "div", "KEYWORD", ++end));
            this.tabela.put("mod", new Simbolo(MOD, "mod", "KEYWORD", ++end));
            this.tabela.put("procedure", new Simbolo(PROCEDURE, "procedure", "KEYWORD", ++end));
            this.tabela.put("function", new Simbolo(FUNCTION, "function", "KEYWORD", ++end));
            this.tabela.put("var", new Simbolo(VAR, "var", "KEYWORD", ++end));
            this.tabela.put("array", new Simbolo(ARRAY, "array", "KEYWORD", ++end));
            this.tabela.put("of", new Simbolo(OF, "of", "KEYWORD", ++end));
            this.tabela.put("type", new Simbolo(TYPE, "type", "KEYWORD", ++end));
            this.tabela.put("record", new Simbolo(RECORD, "record", "KEYWORD", ++end));
            this.tabela.put("const", new Simbolo(CONST, "const", "KEYWORD", ++end));
            this.tabela.put("repeat", new Simbolo(REPEAT, "repeat", "KEYWORD", ++end));
            this.tabela.put("until", new Simbolo(UNTIL, "until", "KEYWORD", ++end));
            this.tabela.put("for", new Simbolo(FOR, "for", "KEYWORD", ++end));
            this.tabela.put("to", new Simbolo(TO, "to", "KEYWORD", ++end));
            this.tabela.put("downto", new Simbolo(DOWNTO, "downto", "KEYWORD", ++end));
            this.tabela.put("do", new Simbolo(DO, "do", "KEYWORD", ++end));
            this.tabela.put("case", new Simbolo(CASE, "case", "KEYWORD", ++end));
            this.tabela.put("with", new Simbolo(WITH, "with", "KEYWORD", ++end));
            this.tabela.put("label", new Simbolo(LABEL, "label", "KEYWORD", ++end));
            this.tabela.put("goto", new Simbolo(GOTO, "goto", "KEYWORD", ++end));
            this.tabela.put("exit", new Simbolo(EXIT, "exit", "KEYWORD", ++end));
            this.tabela.put("begin", new Simbolo(BEGIN, "begin", "KEYWORD", ++end));
            this.tabela.put("end", new Simbolo(END, "end", "KEYWORD", ++end));
            this.tabela.put("program", new Simbolo(PROGRAM, "program", "KEYWORD", ++end));
        }
    
        public int Pesquisar(String lexema) {
            lexema = lexema.toLowerCase();
            Simbolo aux = this.tabela.get(lexema);
            if (aux != null) {
                return aux.getEndereco();
            }
    
            return 0;
        }
    
        public Simbolo BuscarSimbolo(String lexema) {
            lexema = lexema.toLowerCase();
            return tabela.get(lexema);
        }
    
        public Simbolo InserirID(String lexema) {
            lexema = lexema.toLowerCase();
            Simbolo simbolo = new Simbolo(ID, lexema, "IDENTIFIER", ++end);
            tabela.put(lexema, simbolo);
            return tabela.get(lexema);
        }
    
        public Simbolo inserirConst(String lexema, String tipo) {
            lexema = lexema.toLowerCase();
            Simbolo simbolo = new Simbolo(CONST, lexema, tipo, ++end);
            tabela.put(lexema, simbolo);
            return tabela.get(lexema);
        }
    }

