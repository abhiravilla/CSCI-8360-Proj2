import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class simmeasure{
	HashMap<File,Double> create(HashMap<String,HashMap<File,Integer>> Index,HashMap<String,Integer> n1,HashMap<String,Double> idf,HashMap<String,Double> tfq,HashMap<String,HashMap<File,Double>> tf,Set<File> se){
		HashMap<File,Double> doc1=new HashMap<File,Double>();
		HashMap<File,Double> sim= new HashMap<File,Double>();
		for(File f2:se){
			double num=1.0,deno1=1.0,deno2=1.0;
			for(String str:n1.keySet()){
				if(tf.containsKey(str)){
					doc1=tf.get(str);
					if(doc1.containsKey(f2)){
						num+=(doc1.get(f2)*idf.get(str))*(tfq.get(str)*idf.get(str));
						deno1+=(doc1.get(f2)*idf.get(str))*(doc1.get(f2)*idf.get(str));
						deno2+=(tfq.get(str)*idf.get(str))*(tfq.get(str)*idf.get(str));
					}
				}
				double simi=(num)/(Math.sqrt(deno1)+Math.sqrt(deno2));
				sim.put(f2,simi);
			}
		}
		return sim;
	}
}