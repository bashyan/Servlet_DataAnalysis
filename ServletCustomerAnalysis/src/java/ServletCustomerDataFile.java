import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class ServletCustomerDataFile 
{
    public static void main(String qwe[]) throws Exception
    {
        FileReader fr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletCustomerAnalysis\\outputCustomerAnalysis.txt");
        BufferedReader br = new BufferedReader(fr);
        String allLines, firstToken, secondToken = "//", thirdToken = "//", fourthToken = "//", fifthToken = "//", sixthToken = "//";
        TreeMap<Integer,String> mapValue=new TreeMap<>();
        int countMale = 0, countFemale = 0, countUSA = 0, countUK = 0, countInd = 0, countChina = 0, countAus = 0;
        int read = 0, travel = 0;
        int age = 0, countAge = 0, noPhone = 0;
        while((allLines = br.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(allLines);
            while(st.hasMoreTokens())
            {
                firstToken = st.nextToken();
                //System.out.println(firstToken);
                if(firstToken.contains("Male"))
                {
                    countMale++;
                }
                if(firstToken.contains("Female"))
                {
                    countFemale++;
                }
                if(firstToken.contains("AOInterest:Reading"))
                {
                    read++;
                }
                if(firstToken.contains("AOInterest:Travelling"))
                {
                    travel++;
                }
                if(firstToken.contains("Contact:null"))
                {
                    noPhone++;
                }
                if(firstToken.contains("Country:USA"))
                {                
                    secondToken = secondToken.concat(firstToken);
                    mapValue.put(1, secondToken);
                    countUSA++;
                }
                if(firstToken.contains("Country:UK"))
                {
                    thirdToken = thirdToken.concat(firstToken);
                    mapValue.put(2, thirdToken);
                    countUK++;
                }
                if(firstToken.contains("Country:India"))
                {
                    fourthToken = fourthToken.concat(firstToken);
                    mapValue.put(3, fourthToken);
                    countInd++;
                }
                if(firstToken.contains("Country:China"))
                {
                    fifthToken = fifthToken.concat(firstToken);
                    mapValue.put(4, fifthToken);
                    countChina++;
                }
                if(firstToken.contains("Country:Australia"))
                {
                    sixthToken = sixthToken.concat(firstToken);
                    mapValue.put(5, sixthToken);
                    countAus++;
                }                
            }
        }        
        br.close();
        String countryWise;
        String singleLine[] = new String[10];
        int i=0;
        for(int key=1; key<=5; key++)
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
            System.out.println("\n"+count+".");
            String finalData[] = tempString.split(",");
            for(String printData: finalData)
            {            
                System.out.println("@"+printData);
                if(printData.contains("Age:"))
                {
                    String getAge = printData.substring(4);
                    age = Integer.parseInt(getAge);
                    if(age>18)
                    {
                        countAge++;
                    }
                }
            }
            count++;            
        }
        System.out.println("\nTotal Customer\t\t: "+(count-1));
        System.out.println("Total Male\t\t: "+countMale);
        System.out.println("Total Female\t\t: "+countFemale);
        System.out.println("Total USA\t\t: "+countUSA);
        System.out.println("Total UK\t\t: "+countUK);
        System.out.println("Total India\t\t: "+countInd);
        System.out.println("Total China\t\t: "+countChina);
        System.out.println("Total Australia\t\t: "+countAus);
        System.out.println("Total Age >18 \t\t: "+countAge);
        System.out.println("Customer like Travelling: "+travel);
        System.out.println("Customer like Reading\t: "+read);
        System.out.println("Customer without phone\t: "+noPhone);
    }    
}