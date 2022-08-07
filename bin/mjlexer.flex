
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol; 

%%

%{

	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn);
	}
	
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT_STATE

%eofval{
    return new_symbol(sym.EOF);
%eofval}

%%

" "			{ }
"\b"		{ }
"\t"		{ }
"\r\n"		{ }
"\f"		{ }


"program" 	{ return new_symbol(sym.PROGRAM, yytext()); }
"break" 	{ return new_symbol(sym.BREAK, yytext()); }
"class" 	{ return new_symbol(sym.CLASS, yytext()); }
"enum" 		{ return new_symbol(sym.ENUM, yytext()); }
"else" 		{ return new_symbol(sym.ELSE, yytext()); }
"const" 	{ return new_symbol(sym.CONST, yytext()); }
"if" 		{ return new_symbol(sym.IF, yytext()); }
"do" 		{ return new_symbol(sym.DO, yytext()); }
"while" 	{ return new_symbol(sym.WHILE, yytext()); }
"new" 		{ return new_symbol(sym.NEW, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 		{ return new_symbol(sym.READ, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"extends" 	{ return new_symbol(sym.EXTENDS, yytext()); }
"continue"	{ return new_symbol(sym.CONTINUE, yytext()); }
"this" 		{ return new_symbol(sym.THIS, yytext()); }
"super" 	{ return new_symbol(sym.SUPER, yytext()); }
"goto" 		{ return new_symbol(sym.GOTO, yytext()); }
"record" 	{ return new_symbol(sym.RECORD, yytext()); }


"+" 		{ return new_symbol(sym.ADDITION, yytext()); }
"-" 		{ return new_symbol(sym.SUBTRACTION, yytext()); }
"*" 		{ return new_symbol(sym.MULTIPLICATION, yytext()); }
"/" 		{ return new_symbol(sym.DIVISION, yytext()); }
"%" 		{ return new_symbol(sym.MODULO, yytext()); }
"==" 		{ return new_symbol(sym.EQUALS_TO, yytext()); }
"!=" 		{ return new_symbol(sym.NOT_EQUALS_TO, yytext()); }
">" 		{ return new_symbol(sym.GREATER_THAN, yytext()); }
">=" 		{ return new_symbol(sym.GRT_OR_EQUAL, yytext()); }
"<" 		{ return new_symbol(sym.LESS_THAN, yytext()); }
"<=" 		{ return new_symbol(sym.LESS_OR_EQUAL, yytext()); }
"&&" 		{ return new_symbol(sym.LOGICAL_AND, yytext()); }
"||" 		{ return new_symbol(sym.LOGICAL_OR, yytext()); }
"=" 		{ return new_symbol(sym.ASSIGNMENT, yytext()); }
"++" 		{ return new_symbol(sym.INCREMENT, yytext()); }
"--" 		{ return new_symbol(sym.DECREMENT, yytext()); }
";" 		{ return new_symbol(sym.SEMICOLON, yytext()); }
":" 		{ return new_symbol(sym.COLON, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"(" 		{ return new_symbol(sym.L_PARENTHESES, yytext()); }
")" 		{ return new_symbol(sym.R_PARENTHESES, yytext()); }
"[" 		{ return new_symbol(sym.L_BRACKETS, yytext()); }
"]" 		{ return new_symbol(sym.R_BRACKETS, yytext()); }
"{" 		{ return new_symbol(sym.L_BRACES, yytext()); }
"}" 		{ return new_symbol(sym.R_BRACES, yytext()); }


[0-9]+						{ return new_symbol(sym.NUM_CONST, new Integer(yytext())); }
([a-z]|[A-Z])[a-zA-Z0-9_]*	{ return new_symbol(sym.IDENT, yytext()); }
\".\"                       { return new_symbol(sym.CHAR_CONST, new Character(yytext().charAt(1))); }
[true|false]				{ return new_symbol(sym.BOOL_CONST, new Boolean(yytext())); }


"//"					{ yybegin(COMMENT_STATE); }
<COMMENT_STATE> . 		{ yybegin(COMMENT_STATE); }
<COMMENT_STATE> "\r\n"	{ yybegin(YYINITIAL); }


. { System.err.println("Lexical error (" + yytext() + ") on line: " + (yyline + 1)); }

