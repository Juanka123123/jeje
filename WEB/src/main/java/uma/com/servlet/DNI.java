package uma.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DNI")
public class DNI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("text/html");

        String DNI = request.getParameter("DNI");
      
        try(PrintWriter writer = response.getWriter()){
            writer.printf("<html><body> El dni es: %s </body></html>", DNI);
        }
    } 
}
