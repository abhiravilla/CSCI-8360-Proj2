import java.util.*;
import java.io.File;
import java.io.*;
class hash{
    public static void main(String args[]){
        HashMap<String,HashMap<File,Integer>> Index=new HashMap<String, HashMap<File,Integer>>();
        HashMap<File,Integer> doc=new HashMap<File,Integer>();
        try{
            File input=new File("/home/aravilla/ISR/Dataset/");
            File[] filesList = input.listFiles();
            int i=0;
            for(File f:filesList){ 
                i++;
                LineNumberReader lr=new LineNumberReader(new FileReader(f));
                String line="";
                String[] words={""};
                while((line=lr.readLine())!=null){
                    words=line.split(" ");
                    for(String term:words){
                        term=term.trim();
                       /* if(term.equals("comparative")){
                            System.out.println(f);
                        }*/
                        if(Index.containsKey(term)){
                           /*  if(term.equals("comparative")){
                                 System.out.println("Has term Comparative");
                             }*/
                            doc=Index.get(term);
                            if(doc.containsKey(f)){
                                /* if(term.equals("comparative")){
                                     System.out.println("Has file "+f);
                                 }*/

                                int value=doc.get(f);
                                value++;
                              /*   if(term.equals("comparative")){
                                     System.out.println("the value is "+value);
                                 }*/

                                doc.put(f,value);
                                doc=null;
                            }
                            else{
                                doc.put(f,1);
                                doc=null;
                            }
                        }
                        else{
                            /* if(term.equals("comparative")){
                                 System.out.println("First Time");
                             }*/
                                                                                     
                            doc=new HashMap<File,Integer>();
                            doc.put(f,1);
                            Index.put(term,doc);
                            doc=null;
                        }
                    }
            }
        }
        System.out.println("Hash Table created.......");    
        doc=new HashMap<File,Integer>();
        doc=Index.get("result");
        for(File f:doc.keySet()){
            String value = doc.get(f).toString();  
            System.out.println(f+"\n"+value);  
        }
        }
    catch(Exception e){
        System.out.println(e);
    }
}
}
