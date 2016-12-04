import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ServletMovieAnalysisFile 
{
   public static void main(String qwe[]) throws Exception
    {
        FileReader fr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletMovieAnalysis\\outputMovie.txt");
        BufferedReader br = new BufferedReader(fr);
        String dateToken;
        String getName = "";
        int countMovies = 0, countRating = 0, countDuration = 0;
        TreeMap<String,String> mapData = new TreeMap();
        while((dateToken = br.readLine())!=null)
        {            
            StringTokenizer getToken = new StringTokenizer(dateToken, "//");
            while(getToken.hasMoreTokens())
            {
                countMovies++;
                String mapdate = getToken.nextToken();
                System.out.println("\n"+countMovies+". \n");
                String finalData[] = mapdate.split(",");
                for(String S: finalData)
                {
                    System.out.println(S);
                    if(S.contains("Name:"))
                    {
                        getName = S.substring(5);
                    }
                    if(S.contains("Date:"))
                    {
                        String getDate = S.substring(5);
                        String datestr[] = getDate.split("-");
                        int date[] = new int[3], i=0;                                
                        for(String Q:datestr)
                        {                                   
                            date[i] = Integer.parseInt(Q);
                            if((date[0]>=13 && date[0]<=15) && (date[1]>=1 && date[1]<=12) && (date[2]>=1 && date[2]<=31))
                            {
                                mapData.put(getDate,getName);
                            }
                            i++;
                        }
                    }
                    if(S.contains("Rating:"))
                    {
                        String getRate = S.substring(7);
                        int rateint = Integer.parseInt(getRate);
                        if(rateint>4)
                        {
                            countRating++;
                        }
                    }
                    if(S.contains("Duration:"))
                    {
                        String getDuration = S.substring(9);
                        int Duraint = Integer.parseInt(getDuration);
                        if(Duraint>9000)
                        {
                            countDuration++;
                        }
                    }                           
                }
            }
        }        
        System.out.println("\nTotal Movies\t\t: "+countMovies);
        System.out.println("Rating >4\t\t: "+countRating);
        System.out.println("Duration >2.5 hrs\t: "+countDuration);
        System.out.println("\nMovies Released Between Jan,01,2013 and Dec,31,2015:\n");
        for(Map.Entry<String, String> MapKey: mapData.entrySet())
        {            
            System.out.println(MapKey.getKey()+"\t"+MapKey.getValue());
        }
    }     
}
