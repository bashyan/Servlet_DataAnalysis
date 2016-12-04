import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ServletRegistrationDetails"})
public class ServletRegistrationDetails extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter printDetails = response.getWriter();
        response.setContentType("text/html");        
        
        String Name = request.getParameter("Name");
        String Gender = request.getParameter("Gender");
        String EMail = request.getParameter("EMail");
        String Address = request.getParameter("Address");
        String Contact = request.getParameter("Contact");
        String DOB = request.getParameter("DOB");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Country = request.getParameter("Country");
        
        printDetails.println("<h1>Registred Data</h1>");
        printDetails.println("<br/>");
        printDetails.println("Name   : "+Name);
        printDetails.println("<br/>");
        printDetails.println("Gender     : "+Gender);
        printDetails.println("<br/>");
        printDetails.println("EMail  : "+EMail);
        printDetails.println("<br/>");
        printDetails.println("Address    : "+Address);
        printDetails.println("<br/>");
        printDetails.println("Contact    : "+Contact);
        printDetails.println("<br/>");
        printDetails.println("DOBirth    : "+DOB);
        printDetails.println("<br/>");
        printDetails.println("City   : "+City);
        printDetails.println("<br/>");
        printDetails.println("State  : "+State);
        printDetails.println("<br/>");
        printDetails.println("Country    : "+Country);
        printDetails.println("<br/>");        
        
        String s[] = new String[9];
        String s1[] = new String[9];
        s[0] = "Name:";
        s[1] = "Gender:";
        s[2] = "EMail:";     
        s[3] = "Address:";
        s[4] = "Contact:";
        s[5] = "DOBirth:";
        s[6] = "City:";
        s[7] = "State:";
        s[8] = "Country:";
        s1[0] = Name;
        s1[1] = Gender;
        s1[2] = EMail;
        s1[3] = Address;
        s1[4] = Contact;
        s1[5] = DOB;
        s1[6] = City;
        s1[7] = State;
        s1[8] = Country;
        
        FileWriter fout = new FileWriter("C:\\Users\\Bashyan PC\\Documents\\NetBeansProjects\\ServletRegistrationDetails\\outputRegister.txt",true);
        try (BufferedWriter bw = new BufferedWriter(fout)) 
        {
            bw.newLine();
            bw.write("//");
            for(int i=0; i<9; i++)
            {
                bw.write(s[i]+s1[i]+",");                
            }
            bw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
