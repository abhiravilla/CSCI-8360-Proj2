import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class Qtf{
	HashMap<File,Double> create(HashMap<String,HashMap<File,Integer>> Index,HashMap<String,Integer> n1,HashMap<String,Double> idf,HashMap<String,HashMap<File,Double>> tf){
		Qset si=new Qset();
		HashMap<File,Double> sim=new HashMap<File,Double>();
		HashMap<String,Double> tfq=new HashMap<String,Double>();
		for(String str:n1.keySet()){
				int a=n1.get(str);
				double b=1+(Math.log(a)/Math.log(2));
				//System.out.println(" term: "+str+" "+d);
				tfq.put(str,b);
		}
		sim=si.create(Index,n1,idf,tfq,tf);
		return sim;
	}
}