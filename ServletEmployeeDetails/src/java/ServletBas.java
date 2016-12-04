import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServletBas"})
public class ServletBas extends HttpServlet 
{    
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
        PrintWriter printDetails = response.getWriter();
        response.setContentType("text/html");
        
        String ID = request.getParameter("EmpID");
        String Name = request.getParameter("EmpName");
        String Age = request.getParameter("EmpAge");
        String Salary = request.getParameter("EmpSalary");
        String Email = request.getParameter("EmpEmail");
        String Citizen = request.getParameter("EmpCitizen");
        
        printDetails.println("<h1>Employee Retreived Data</h1>");
        printDetails.println("<br/>");
        printDetails.println("\tEmployee ID : "+ID);
        printDetails.println("<br/>");
        printDetails.println("Employee Name \t: "+Name);
        printDetails.println("<br/>");
        printDetails.println("Employee Age \t: "+Age);
        printDetails.println("<br/>");
        printDetails.println("Employee Salary \t: "+Salary);
        printDetails.println("<br/>");
        printDetails.println("Employee Email \t: "+Email);
        printDetails.println("<br/>");
        printDetails.println("Employee Citizen \t: "+Citizen);
        printDetails.println("<br/>");
        
        int eAge = Integer.parseInt(Age);
        float eSalary = Float.parseFloat(Salary);
        if(eAge>30)
        {
            eSalary += 3500;
            printDetails.println("<br/>");
            printDetails.println("Employee Medical Aid is added, and the new Salary is "+eSalary);
        }
        Citizen = Citizen.toUpperCase();
        if(!Citizen.equals("INDIAN"))
        {
            eSalary *= (0.9f);
        }
        if(!Email.contains("niit.com"))
        {
           Email = "Invalid EMail ID";
        }
        String s[] = new String[6];
        String s1[] = new String[6];
        s[0] = "Employee ID \t: ";
        s[1] = "Employee Name \t: ";
        s[2] = "Employee Age \t: ";     
        s[3] = "Employee Salary : ";
        s[4] = "Employee Email \t: ";
        s[5] = "Employee Citizen: ";
        s1[0] = String.valueOf(ID);
        s1[1] = Name;
        s1[2] = Age;
        s1[3] = String.valueOf(eSalary);
        s1[4] = Email;
        s1[5] = Citizen;        
        printDetails.println("<hr/>Employee Modified Data<hr/>");
        printDetails.println("<br/>");
        printDetails.println(s[0]+ID);
        printDetails.println("<br/>");
        printDetails.println(s[1]+Name);
        printDetails.println("<br/>");
        printDetails.println(s[2]+Age);
        printDetails.println("<br/>");
        printDetails.println(s[3]+eSalary);
        printDetails.println("<br/>");
        printDetails.println(s[4]+Email);
        printDetails.println("<br/>");
        printDetails.println(s[5]+Citizen);
        printDetails.println("<br/>");
        
        
        FileWriter fout = new FileWriter("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletBas\\Servlettext.txt");
        try (BufferedWriter bw = new BufferedWriter(fout)) 
        {
            for(int i=0; i<6; i++)
            {
                bw.write(s[i]+s1[i]);
                bw.newLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}