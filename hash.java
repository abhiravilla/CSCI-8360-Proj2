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
		HashMap<String,HashMap<File,Double>> tf=new HashMap<String, HashMap<File,Double>>();
		HashMap<String,Double> idf=new HashMap<String,Double>();
		HashMap<File,Double> doc1=new HashMap<File,Double>();
	    HashMap<String,Double> tfq=new HashMap<String,Double>();
        HashMap<File,Double> sim=new HashMap<File,Double>();
		HashMap<File,Integer> docu=new HashMap<File,Integer>();
		HashMap<String,Integer> n1=new HashMap<String,Integer>();
		Set<File> se=new HashSet<File>();
		
		//Inverted Index starts
		index id =new index();
        System.out.println("Inverted Index created\n");
		Index=id.create();
		//IDF value starts
		IDF idfv=new IDF();
		idf=idfv.create(Index);
		System.out.println("IDF created\n");	
		//TF value Starts
		TF tfv=new TF();
		tf=tfv.create(Index);
		System.out.println("TF created\n");
		Qhash qt=new Qhash();
		qt.create(Index,idf,tf);
	
    }
}
