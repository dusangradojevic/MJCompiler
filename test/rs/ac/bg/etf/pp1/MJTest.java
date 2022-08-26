package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.mj.runtime.Code;

public class MJTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws IOException {
		Logger log = Logger.getLogger(MJTest.class);
		Reader br = null;
		try {
			
			File sourceCode = new File("test/program.mj");	
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
	        Symbol s;
			try {
				s = p.parse();
				SyntaxNode prog = (SyntaxNode)(s.value);
				System.out.println(prog.toString());
				
				SemanticAnalyzer semanticCheck = new SemanticAnalyzer();
				prog.traverseBottomUp(semanticCheck);
		        
				Tab.dump();
				
				File dest = new File("test/program.obj");

	            if (dest.exists()) {
	                log.info("Destination file already exists. Its content is being deleted.");
	                dest.delete();
	            }
				
				CodeGenerator codeGen = new CodeGenerator();
				prog.traverseBottomUp(codeGen);
				
				Code.write(new FileOutputStream(dest));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //pocetak parsiranja
	        
			
			Symbol currToken = null;
			while ((currToken = lexer.next_token()).sym != sym.EOF) {
				if (currToken != null && currToken.value != null)
					log.info(currToken.toString() + " " + currToken.value.toString());
			}
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}
	}
	
}
