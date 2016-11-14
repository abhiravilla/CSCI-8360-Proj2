
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Queries {
void stopwords()	{
		try
		{
		File fr = new File("/home/aravilla/stopwords.txt");
		Map<String,Integer> swords = new HashMap<String,Integer>();
		LineNumberReader lr = new LineNumberReader(new FileReader(fr));
		String line="";
        while((line=lr.readLine())!=null){
			   swords.put(line,1);
		}
		lr.close();
			File fr1=new File("/home/aravilla/ISR/query.txt");
			LineNumberReader lr1=new LineNumberReader(new FileReader(fr1));
			String line1=" ";
			File file=null;
            BufferedWriter bw=null;
            FileWriter fw =null;
			while(( line1= lr1.readLine())!=null)
			{ 
				line1=line1.trim();
				String[] words=line1.split(" ");
                if(words[0].equals(".I"))
				{  
				        file=new File("/home/aravilla/ISR/Queryset/query"+words[1]+".txt/");
				        fw = new FileWriter(file,true);					   
						 bw = new BufferedWriter(fw);			
				}
				else{		 
					for(String x:words)
					{
						if(swords.containsKey(x))
						{
							continue;
						}
						else
						{   if(file.exists()){
							x=x.trim();
							String result = x.replaceAll("[-+^:,]"," ");
							result=result.trim();
//						    String s1 = result.replace(" ", "-");

							if(!(result.length()==0)){
								bw.write(result);
								bw.write(" ");
								bw.flush();
							}
							}
                            else{
                                System.out.println("File not exists\n");
                            }
                        }
					}
				}
            }
            System.out.println("Done");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		Queries pr=new Queries();
		pr.stopwords();
	}
}

