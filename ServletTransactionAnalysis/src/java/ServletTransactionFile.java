
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ServletTransactionFile 
{
    public static void main(String qwe[]) throws Exception
    {
        FileReader fr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletTransactionAnalysis\\outputCustomer.txt");
        BufferedReader br = new BufferedReader(fr);        
        String allLines, sallLines, firstToken;        
        TreeMap<String,String> mapValue=new TreeMap<>();
        TreeMap<Integer,String> mapData=new TreeMap<>();
        while((allLines = br.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(allLines,"//");            
            while(st.hasMoreTokens())
            {                
                firstToken = st.nextToken();
                String cusID[] = firstToken.split(",");
                String cuid = cusID[0];
                //System.out.println(")"+firstToken);
                
                FileReader sfr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletTransactionAnalysis\\outputTransaction.txt");
                BufferedReader sbr = new BufferedReader(sfr);
                while((sallLines = sbr.readLine())!=null)
                {
                    StringTokenizer sst = new StringTokenizer(sallLines);
                    
                    while(sst.hasMoreTokens())
                    {                        
                        String scheck = sst.nextToken();
                        if(scheck.contains(cuid))
                        {                            
                            mapValue.put(cuid,firstToken.concat(scheck));
                        }
                    }
                }
                sbr.close();                
            }
        }        
        br.close();
        
        String toSet;
        String fromSet = "";
        String allData[] = new String[10];
        int i =0;
        String secondToken = "//", thirdToken = "//", fourthToken = "//", fifthToken = "//";
        int spo=1, app=1,home=1,kitc=1;
        for(Map.Entry<String,String> MAPS:mapValue.entrySet())
        {
            //System.out.println("MAPS "+MAPS);
            toSet = MAPS.getValue();
            String checkDup[] = toSet.split(",");
            LinkedHashSet<String> remDup = new LinkedHashSet<String>();
            remDup.addAll(Arrays.asList(checkDup));
            for(String sET : remDup)
            {
                fromSet = fromSet+sET+",";
            }
            remDup.clear();
            allData[i] = fromSet;
            if(allData[i].contains("ProductCategory:Sports"))
            {
                secondToken = secondToken.concat("//"+spo+".,"+allData[i]+"\n");
                mapData.put(1, secondToken);
                spo++;
            }
            if(allData[i].contains("ProductCategory:Apparel"))
            {
                thirdToken = thirdToken.concat("//"+app+".,"+allData[i]+"\n");
                mapData.put(2, thirdToken);
                app++;
            }
            if(allData[i].contains("ProductCategory:HomeAppliance"))
            {
                fourthToken = fourthToken.concat("//"+home+".,"+allData[i]+"\n");
                mapData.put(3, fourthToken);
                home++;
            }
            if(allData[i].contains("ProductCategory:KitchenAppliance"))
            {
                fifthToken = fifthToken.concat("//"+kitc+".,"+allData[i]+"\n");
                mapData.put(4, fifthToken);
                kitc++;
            }
            i++;
            fromSet = "";           
        }        
        int count =1;
        System.out.println("Customer ID wise Transactions");
        for(String print : allData)
        {
            String cusPrint[] = print.split(",");
            System.out.println("\n"+count+". ");
            for(String fina : cusPrint)
            {
               System.out.println(""+fina);
               
            }
            count++;
        }
        int j=0;
        String product[] = {"SPORTS","APPAREL","HOME APPLIANCE","KITCHEN APPLIANCE"};
        System.out.println("\nPRODUCT CATEGORY WISE TRANSACTION");
        for(int key=1; key<=4; key++)
        {
            String productWise = mapData.get(key);
            System.out.print("\n"+product[j]);
            String splits[] = productWise.split("//");
            for(String G : splits)
            {
                //System.out.println(G);
                String last[] = G.split(",");
                for(String L : last)
                {
                   System.out.println(L);                 
                }
            }
            j++;
        }        
    }    
}
