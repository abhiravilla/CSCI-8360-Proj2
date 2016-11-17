import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class Qset{
		HashMap<File,Double> create(HashMap<String,HashMap<File,Integer>> Index,HashMap<String,Integer> n1,HashMap<String,Double> idf,HashMap<String,Double> tfq,HashMap<String,HashMap<File,Double>> tf){
			HashMap<File,Double> sim=new HashMap<File,Double>();
			HashMap<File,Integer> doc=new HashMap<File,Integer>();
			Set<File> se=new HashSet<File>();
			simmeasure si=new simmeasure();
			for(String str:n1.keySet()){
				if(Index.containsKey(str)){
					doc=Index.get(str);
					for(File f1:doc.keySet()){
						se.add(f1);
					}
				}
			}
			sim=si.create(Index,n1,idf,tfq,tf,se);
			//System.out.println("Size of similarity matrix; "+sim.size());
			
			return sim;
		}		
}