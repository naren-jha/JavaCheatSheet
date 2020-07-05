package com.njha;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LineConcatinator - Used for converting Youtube subtitles into sentences
 *
 * @author Narendra Jha, njha.sde@gmail.com
 *
 */
public class LineConcatinator {
    
    private static final String relativePath = "E:\\eclipse-workspace\\JavaCheatSheet\\src\\com\\njha\\";
    private static final String inputFileName = "subtitle.txt";
    private static final String outputFileName = "subtitleOut.txt";
    
    public static void main(String[] args) {
        try {
            Scanner fileIn = new Scanner(new File(relativePath + inputFileName));
            String paragraph = "";
            List<String> document = new ArrayList<>();
            
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                
                paragraph = paragraph.trim();
                if (line == null || line.isEmpty()) {
                    if (!isSentenceEnd(paragraph))
                        paragraph += ".";
                    document.add(paragraph);
                    paragraph = "";
                    continue;
                }
                
                if (isSentenceEnd(paragraph)) line = line.substring(0, 1).toUpperCase() + line.substring(1);
                if (!paragraph.isEmpty()) paragraph += " ";
                
                paragraph += line;
            }
            
            //System.out.println(document);
            FileWriter fileOut = new FileWriter(relativePath + outputFileName);    
            for (String para : document) {
                fileOut.write(para);
                fileOut.write("\n");
            }
            fileOut.close();
            
        } catch (IOException e) {e.printStackTrace();}
    }
    
    public static boolean isSentenceEnd(String paragraph) {
        String lastCharacter = "";
        if (!paragraph.isEmpty())
            lastCharacter = paragraph.substring(paragraph.length()-1);
        return paragraph.isEmpty() || lastCharacter.equals(".") || lastCharacter.equals("?");
    }

}
