package uma.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("text/html");
        
        HttpSession session = request.getSession();
        Map<String,usuario> mapa=(Map) session.getAttribute("Mapa");
       
        for (String s : mapa.keySet()) {
            if(mapa.get(s).getConectado() == true){
                mapa.get(s).setConectado(false);
                try(PrintWriter writer = response.getWriter()){
                    writer.printf("<html><body> Usuario %s descoenctado </body></html>",s);
                }
            }
        }
            
    }
}
