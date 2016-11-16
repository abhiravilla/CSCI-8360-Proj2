import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class IDF{
	HashMap<String,Double> create(HashMap<String,HashMap<File,Integer>> Index){
		HashMap<File, Integer> doc=new HashMap<File,Integer>();
		HashMap<String,Double> idf=new HashMap<String,Double>();
		for(String str:Index.keySet()){
			doc=Index.get(str);
			double a=Math.log((1400/doc.size()))/(Math.log(2));
			idf.put(str,a);
		}
		return idf;
	}
}