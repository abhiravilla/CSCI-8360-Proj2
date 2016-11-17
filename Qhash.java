import java.util.*;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.math.*;
class Qhash{
		void create(HashMap<String,HashMap<File,Integer>> Index,HashMap<String,Double> idf,HashMap<String,HashMap<File,Double>> tf ){
			HashMap<String,Integer> n1=new HashMap<String,Integer>();
			HashMap<File,Double> sim=new HashMap<File,Double>();
			HashMap<File,Integer> tfe=new HashMap<File,Integer>();
			
			Qtf qt=new Qtf();
				try{
				int value=0;
				File input=new File("Queryset/");
				File[] listFile = input.listFiles();
				int i=0;
				for(File f:listFile){	
						LineNumberReader lr=new LineNumberReader(new FileReader(f));
					String line="";
					while((line=lr.readLine())!=null){
						String[] words={""};
						words=line.split(" ");
						for(String term:words){
							term=term.trim();
							if(n1.containsKey(term)){
                                value=n1.get(term);
                                value++;
                                n1.put(term,value);
                            }
                            else{
                                n1.put(term,1);
                            }
						}
					}
					sim=qt.create(Index,n1,idf,tf);
					double[] dArr=new double[10];
					File[] fArr=new File[10];
					double value1=0.0;
					i++;
					int count=0;
					while(count==0){
					for(File f1:sim.keySet()){
						value1=sim.get(f1);
						for(int k=0;k<10;k++){
							if(dArr[k]>0.0 && dArr[k]>value1){
								continue;
							}
							else if(dArr[k]!=0.0 && dArr[k]<value1){
								File efile=fArr[k];
								double db=dArr[k];
								double temp;
								File ftemp;
								fArr[k]=f1;
								dArr[k]=value1;
								for(int j=k+1;j<10;j++){
									if(efile!=null){
									temp=dArr[j];
									ftemp=fArr[j];
									dArr[j]=db;
									fArr[j]=efile;
									db=temp;
									efile=ftemp;
									}
									
								}
								break ;
							}
							else{
								dArr[k]=value1;
								fArr[k]=f1;
								break ;
							}
						}
					}
					count++;
					}
					System.out.println("For Query file "+f);
					for(int k=0;k<10;k++){
						System.out.println(" File name: "+fArr[k]+" Similaity value: "+dArr[k]);
					}
				
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
}