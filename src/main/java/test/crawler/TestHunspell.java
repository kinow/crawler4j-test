package test.crawler;

import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.PortugueseBrazil;
import org.languagetool.rules.RuleMatch;

public class TestHunspell {

    public static void main(String[] args) throws Exception {
        JLanguageTool langTool = new JLanguageTool(new PortugueseBrazil());
        langTool.activateDefaultPatternRules();
        List<RuleMatch> matches = langTool.check("Eae Bruno, como vão as coisas? " + "Nada de errdo?");
        for (RuleMatch match : matches) {
            System.out.println("Potential error at line " + match.getLine() + ", column " + match.getColumn() + ": " + match.getMessage());
            System.out.println("Suggested correction: " + match.getSuggestedReplacements());
        }
    }
    
    public static void main2(String[] args) throws Exception {
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
        langTool.activateDefaultPatternRules();
        List<RuleMatch> matches = langTool
                .check("A sentence " + "with a error in the Hitchhiker's Guide tot he Galaxy");
        for (RuleMatch match : matches) {
            System.out.println("Potential error at line " + match.getLine() + ", column " + match.getColumn() + ": "
                    + match.getMessage());
            System.out.println("Suggested correction: " + match.getSuggestedReplacements());
        }
    }

}
