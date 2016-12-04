import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ServletRegistrationFile 
{
    public static void main(String qwe[]) throws Exception
    {
        FileReader fr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletRegistrationDetails\\outputRegister.txt");
        BufferedReader br = new BufferedReader(fr);
        String allLines, firstToken, secondToken = "//", thirdToken = "//", fourthToken = "//";
        TreeMap<Integer,String> mapValue=new TreeMap<>();
        while((allLines = br.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(allLines);
            while(st.hasMoreTokens())
            {
                firstToken = st.nextToken();
                //System.out.println(firstToken);                
                if(firstToken.contains("Country:USA"))
                {                
                    secondToken = secondToken.concat(firstToken);
                    mapValue.put(1, secondToken);
                }
                if(firstToken.contains("Country:UK"))
                {
                    thirdToken = thirdToken.concat(firstToken);
                    mapValue.put(2, thirdToken);
                }
                if(firstToken.contains("Country:UAE"))
                {
                    fourthToken = fourthToken.concat(firstToken);
                    mapValue.put(3, fourthToken);
                }
            }
        }        
        br.close();
        String countryWise;
        String singleLine[] = new String[10];
        int i=0;
        for(int key=1; key<=3; key++)
        {
            countryWise = mapValue.get(key);
            StringTokenizer mapTokens = new StringTokenizer(countryWise, "//");
            while(mapTokens.hasMoreTokens())
            {
                singleLine[i] = mapTokens.nextToken();
                i++;
            }            
        }        
        int count=1;
        for(String Words: singleLine)
        {
            String tempString = Words;
            System.out.println("\n"+"Registered Data "+count+"\n");
            String finalData[] = tempString.split(",");
            for(String printData: finalData)
            {            
                System.out.println(printData);            
            }
            count++;
        }        
    }
}
