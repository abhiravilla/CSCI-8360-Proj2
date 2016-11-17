import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class index{
	HashMap<String, HashMap<File,Integer>> create(){
		HashMap<String,HashMap<File,Integer>> Index=new HashMap<String, HashMap<File,Integer>>();
		HashMap<File,Integer> doc=new HashMap<File,Integer>();
		try{
            File input=new File("Dataset/");
            File[] listFile = input.listFiles(); 
                        int i=0;
			for(File f:listFile){ 
				i++;
                LineNumberReader lr=new LineNumberReader(new FileReader(f));
                String line="";
                String[] words={""};
                while((line=lr.readLine())!=null){
                    words=line.split(" ");
                    for(String term:words){
                        term=term.trim();
						term=term.replaceAll("[\\-\\+\\.^:,/\\)\\(\\[\\]]","");
                        if(Index.containsKey(term)){
                            doc=Index.get(term);
                            if(doc.containsKey(f)){
                                int value=doc.get(f);
                                value++;
                                doc.put(f,value);
                                doc=null;
                            }
                            else{
                                doc.put(f,1);
                                doc=null;
                            }
                        }
                        else{
                            doc=new HashMap<File,Integer>();
                            doc.put(f,1);
                            Index.put(term,doc);
                            doc=null;
                        }
                    }
				}
			} 
		}
		catch(Exception e){
			System.out.println(e);
		}
		//System.out.println("In function "+Index.size());
		return Index;
	}
}
