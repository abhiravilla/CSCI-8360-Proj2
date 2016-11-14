import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class hash{
    public static void main(String args[]){
        HashMap<String,HashMap<File,Integer>> Index=new HashMap<String, HashMap<File,Integer>>();
        HashMap<File,Integer> doc=new HashMap<File,Integer>();
        try{
            File input=new File("/home/aravilla/ISR/Dataset/");
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
        System.out.println("Hash Table created.......");    
        System.out.println("Inverted Index size....."+Index.size());
        /*
	   doc=new HashMap<File,Integer>();
        doc=Index.get("result");
        File keys[]=null;
        System.out.println("The documents containing result word are....."+doc.size());
        keys=doc.keySet().toArray(new File[doc.size()]);
        Arrays.sort(keys, new Comparator<File>() {
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }
            private int extractNumber(String name) {
                int i = 0;
                try {
                    int s = name.lastIndexOf('/')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0;
                }
                return i;
            }
        });
        int val=0;
        for(File f:keys){
            String value = doc.get(f).toString();  
            val+=Integer.parseInt(value);
            System.out.println(f+"\n"+value);  
        }
        System.out.println("The total word occurance is....."+val);
        */
        }
    catch(Exception e){
        System.out.println(e);
    }
    HashMap<String,Double> idf=new HashMap<String,Double>();
    for(String str:Index.keySet()){
        HashMap<File,Integer> docu=new HashMap<File,Integer>();
        docu=Index.get(str);
        double a=Math.log((1400/docu.size()))/(Math.log(2));
        idf.put(str,a);
    }
    HashMap<String,HashMap<File,Double>> tf=new HashMap<String, HashMap<File,Double>>();
        for(String str:Index.keySet()){
            HashMap<File,Double> doc1=new HashMap<File,Double>();
            doc=Index.get(str);
            for(File key:doc.keySet())
            {
                int a=doc.get(key);
                double b=1+(Math.log(a)/Math.log(2));
                doc1.put(key,b);
            }
            tf.put(str,doc1);
            //doc1=null; 
        }
/*
    System.out.println(idf.get("result"));

HashMap<File,Double> doc1=new HashMap<File,Double>();
    doc1=tf.get("result");
File keys2[]=null;
 System.out.println("The documents containing result word are....."+doc.size());
 keys2=doc1.keySet().toArray(new File[doc1.size()]);
 Arrays.sort(keys2, new Comparator<File>() {
     public int compare(File o1, File o2) {
         int n1 = extractNumber(o1.getName());
         int n2 = extractNumber(o2.getName());
         return n1 - n2;
     }
     private int extractNumber(String name) {
         int i = 0;
         try {
             int s = name.lastIndexOf('/')+1;
             int e = name.lastIndexOf('.');
             String number = name.substring(s, e);
             i = Integer.parseInt(number);
         } catch(Exception e) {
             i = 0;
         }
         return i;
     } });
 for(File f:keys2){
     String value = doc1.get(f).toString();
     System.out.println(value);
 }
*/
    }
}
