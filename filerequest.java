import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.http.*;

public class filedownload extends HttpServlet 
{ 
public void doPost(HttpServletRequest sReq ,HttpServletResponse sRes) 
throws IOException,ServletException 
{ 

String fileWanted="nowork.exe"
String pathOfFile = "c:/"+ "Downloadablefiles"+"\\" + fileWanted;

File F = new File(pathOfFile); 
sRes.setContentType("application/x-msword");

//the next statement is the most IMPORTANT statement 
sRes.setHeader("Content-Disposition", "attachment;filename=\"" + fileWanted +"\"");

ServletOutputStream out = sRes.getOutputStream(); 
InputStream in = null; 
try 
{ 
in = new BufferedInputStream(new FileInputStream(F)); 
int ch; 
while ((ch = in.read()) !=-1) 
{ 
out.print((char)ch); 
} 
} 
catch(Exception e)

{ 
System.out.println(e.toString()); 
}

finally 
{ 
if (in != null) in.close();
}


} 
