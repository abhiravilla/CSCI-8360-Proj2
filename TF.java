import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class TF{
	HashMap<String,HashMap<File,Double>> create(HashMap<String,HashMap<File,Integer>> Index){
		HashMap<String,HashMap<File,Double>> tf=new HashMap<String, HashMap<File,Double>>();
		HashMap<File,Integer> doc=new HashMap<File,Integer>();
		HashMap<File,Double> doc1=new HashMap<File,Double>();
		for(String str:Index.keySet()){
            doc=Index.get(str);
            for(File key:doc.keySet())
            {
                int a=doc.get(key);
                double b=1+(Math.log(a)/Math.log(2));
                doc1.put(key,b);
            }
            tf.put(str,doc1);
		}
		return tf;
	}
}