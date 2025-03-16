/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrot.controller.admin.management.order;

import carrot.dao.OrderDAO;
import carrot.dao.OrderItemDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import carrot.model.OrderDTO;
import carrot.model.OrderItem;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ManageOrderServlet", urlPatterns = {"/ManageOrderServlet"})
public class ManageOrderServlet extends HttpServlet {

    private final static String ORDER_PAGE = "view/jsp/admin/admin_order.jsp";
    private final static String ORDER_DETAIL_PAGE = "view/jsp/admin/admin_order_detail.jsp";
    private final static String CHANGE_STATUS = "changeStatus";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ORDER_PAGE;
        try {
            OrderDAO oDao = new OrderDAO();
            OrderItemDAO oIDao = new OrderItemDAO();
            List<OrderDTO> listOrders = oDao.getAllOrders();
            System.out.println("listOrder:" + listOrders);
            String action = request.getParameter("action");

            if ("showdetail".equals(action)) {
                url = ORDER_DETAIL_PAGE;
                String bill_id = request.getParameter("bill_id");
                OrderDTO order = oDao.getOrdersByID(bill_id);
                int id = order.getOrderID();
                List<OrderItem> list = oIDao.getOrderItemByOrderId(id);
                request.setAttribute("LIST_PRODUCTS_IN_ORDER", list);

            } else if (CHANGE_STATUS.equals(action)) {
                oDao.UpdateStatus(request.getParameter("id"));
            }

            request.setAttribute("CURRENTSERVLET", "Order");
            request.setAttribute("LIST_ORDERS", listOrders);
        } catch (Exception ex) {
            log("ManageOrderServlet error:" + ex.getMessage());
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
