/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrot.controller.admin.management.category;

import carrot.dao.CategoryDAO;
import carrot.dao.TypeDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import carrot.model.CategoryDTO;
import carrot.model.TypeDTO;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ManageCategoryServlet", urlPatterns = {"/ManageCategoryServlet"})
public class ManageCategoryServlet extends HttpServlet {

    private static final String MANAGE_CATEGORY_PAGE = "view/jsp/admin/admin_categories.jsp";
    private static final String INSERT_CATEGORY_PAGE = "view/jsp/admin/admin_categories_insert.jsp";
    private static final String INSERT = "Insert";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = MANAGE_CATEGORY_PAGE;
        try {
            CategoryDAO cDao = new CategoryDAO();
            TypeDAO tDao = new TypeDAO();

            List<TypeDTO> listTypes = tDao.getAllType();

            String action = request.getParameter("action");
            if (INSERT.equals(action)) {
                url = INSERT_CATEGORY_PAGE;
            }
            List<CategoryDTO> list = cDao.getData();
            request.setAttribute("LIST_CATEGORIES", list);
            request.setAttribute("LIST_TYPES", listTypes);
            request.setAttribute("CURRENTSERVLET", "Category");
        } catch (Exception ex) {
            log("ManageCategoryServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
