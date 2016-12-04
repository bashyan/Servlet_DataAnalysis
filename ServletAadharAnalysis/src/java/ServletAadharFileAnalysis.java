import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ServletAadharFileAnalysis 
{
    public static void main(String qwe[]) throws Exception
    {
        FileReader fr = new FileReader("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletAadharAnalysis\\outputAadhar.txt");
        BufferedReader br = new BufferedReader(fr);
        String allLines, firstToken, maleToken, femaleToken;
        int countVote, countMale = 0, countFemale = 0, countMarried = 0, countPension = 0, countGraduates = 0, countWorking = 0;
        int maleage, femaleage, countSalary = 0, countDependent = 0;
        int countTokenizer = 0;
        while((allLines = br.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(allLines);
            while(st.hasMoreTokens())
            {
                firstToken = st.nextToken();
                countTokenizer++;
                System.out.println("\n"+countTokenizer+".\n");
                //System.out.println(firstToken);
                if(firstToken.contains("Working:No"))
                {
                    countWorking++;
                }
                if(firstToken.contains("Marital:Yes"))
                {
                    countMarried++;
                }
                if(firstToken.contains("Education:PhD")||firstToken.contains("Education:PG")||firstToken.contains("Education:UG"))
                {
                    countGraduates++;
                }
                if(firstToken.contains("Gender:Male"))
                {
                    maleToken = firstToken;
                    StringTokenizer mapmaleToken = new StringTokenizer(maleToken, "//");
                    while(mapmaleToken.hasMoreTokens())
                    {
                        String mapmale = mapmaleToken.nextToken();
                        //System.out.println(mapmale);
                        String finalData[] = mapmale.split(",");
                        for(String S: finalData)
                        {
                            System.out.println(S);
                            if(S.contains("Age:"))
                            {
                                String getAge = S.substring(4);
                                maleage = Integer.parseInt(getAge);
                                if(maleage>18)
                                {
                                    countMale++;
                                }
                                if(maleage>=60)
                                {
                                    countPension++;
                                }
                            }
                            if(S.contains("Salary:"))
                            {
                                String getmaleSal = S.substring(7);
                                int maleSal = Integer.parseInt(getmaleSal);
                                if(maleSal>10000)
                                {
                                    countSalary++;
                                }
                            }
                            if(S.contains("Dependent:"))
                            {
                                String getmaleDep = S.substring(10);
                                int maleDep = Integer.parseInt(getmaleDep);
                                if(maleDep>4)
                                {
                                    countDependent++;
                                } 
                            }
                        }
                    }                                        
                }
                if(firstToken.contains("Gender:Female"))
                {
                    femaleToken = firstToken;
                    StringTokenizer mapfemaleToken = new StringTokenizer(femaleToken, "//");
                    while(mapfemaleToken.hasMoreTokens())
                    {
                        String mapfemale = mapfemaleToken.nextToken();
                        //System.out.println(mapfemale);
                        String finalfemaleData[] = mapfemale.split(",");
                        for(String F: finalfemaleData)
                        {
                            System.out.println(F);
                            if(F.contains("Age:"))
                            {
                                String getfemaleAge = F.substring(4);
                                femaleage = Integer.parseInt(getfemaleAge);
                                if(femaleage>18)
                                {
                                    countFemale++;
                                }
                                if(femaleage>=60)
                                {
                                    countPension++;
                                }
                            }
                            if(F.contains("Salary:"))
                            {
                                String getfemaleSal = F.substring(7);
                                int femaleSal = Integer.parseInt(getfemaleSal);
                                if(femaleSal>10000)
                                {
                                    countSalary++;
                                }
                            }
                            if(F.contains("Dependent:"))
                            {
                                String getfemaleDep = F.substring(10);
                                int femaleDep = Integer.parseInt(getfemaleDep);
                                if(femaleDep>4)
                                {
                                    countDependent++;
                                } 
                            }
                        }
                    }
                }
            }
        }
        countVote = countMale+countFemale;
        System.out.println("\nTotal Citizen Voting\t\t: "+countVote);
        System.out.println("Total Male Voting\t\t: "+countMale);
        System.out.println("Total Female Voting\t\t: "+countFemale);
        System.out.println("Total Not Working\t\t: "+countWorking);
        System.out.println("Total Married\t\t\t: "+countMarried);
        System.out.println("Total Salary >10000\t\t: "+countSalary);
        System.out.println("Total Senior Citizen[Pension]\t: "+countPension);
        System.out.println("Total Dependent >4\t\t: "+countDependent);
        System.out.println("Total Graduates\t\t\t: "+countGraduates);
    }
    
}
