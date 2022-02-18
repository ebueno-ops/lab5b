
package ca.sait.lab5b.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emman
 */
public class ShoppingListServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            String query = request.getQueryString();

            if (query != null && query.contains("logout"))
            {
                session.invalidate();

                request.setAttribute("message", "Successfully logged out.");
            }        
         else {
            //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            response.sendRedirect("register");
                return;
        }
        }   
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");

        HttpSession session = request.getSession();

        session.setAttribute("name", name);
        }else if (action != null && action.equals("delete")) {
            String item = request.getParameter("item");
           
            ArrayList<String> items =(ArrayList<String>) session.getAttribute("items");

            items.remove(item);

            session.setAttribute("items", items);


        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }


}
