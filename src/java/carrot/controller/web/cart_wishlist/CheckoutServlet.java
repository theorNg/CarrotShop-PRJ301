/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrot.controller.web.cart_wishlist;

import carrot.utils.CartUtil;
import carrot.dao.OrderDAO;
import carrot.dao.OrderItemDAO;
import carrot.dao.PaymentDAO;
import carrot.dao.ProductDAO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import carrot.model.CartItem;
import carrot.model.Email;
import carrot.model.OrderDTO;
import carrot.model.PaymentDTO;
import carrot.model.UserDTO;
import jakarta.servlet.http.Cookie;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    private static final String CHECKOUT_PAGE = "view/jsp/home/checkout.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CHECKOUT_PAGE;
        PaymentDAO pmDAO = new PaymentDAO();
        ProductDAO pDAO = new ProductDAO();
        OrderDAO oDAO = new OrderDAO();
        OrderItemDAO oiDAO = new OrderItemDAO();
        CartUtil cUtil = new CartUtil();
        OrderDTO orderLatest = null;
        double total = 0;
        int totalQuantity = 0;
        String message = "";
        String check = "false";
        String emptyCart = "[]";
        Email emailHandle = new Email();
        try {
            HttpSession session = request.getSession();
            Cookie cookie = null;
            List<PaymentDTO> pms = pmDAO.getPaymentData();
            // Check out
            String paymentId = request.getParameter("check_method");
            UserDTO user = (UserDTO) session.getAttribute("account");
            List<CartItem> carts = (List<CartItem>) session.getAttribute("CART");
            if (user != null && user.getRoleID() != 1 && paymentId != null) {
                PaymentDTO payment = pmDAO.getPaymentById(Integer.parseInt(paymentId));
                for (CartItem cart : carts) {
                    // Check quanity of product in stock
                    if(pDAO.getStock(cart.getProduct().getId()) > 5 && cart.getQuantity() < cart.getProduct().getStock()) {
                        total += (cart.getQuantity() * cart.getProduct().getSalePrice());
                        totalQuantity += cart.getQuantity();
                    }
                }
                LocalDateTime daynow = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = daynow.format(format);

                // Create new order
                if (oDAO.CreateNewOrder(date, total, payment, user)) {
                    message = "Order Success";
                    // create orderdetails
                    orderLatest = oDAO.getTheLatestOrder();
                    // Send email to user
//                    String subEmail = emailHandle.subjectNewOrder();
//                    String messageEmail = emailHandle.messageNewOrder(user.getFirstName(), totalQuantity, orderLatest.getTotalPrice());
//                    emailHandle.sendEmail(subEmail, messageEmail, user.getEmail());
                    for (CartItem cart : carts) {
                        oiDAO.createNewOrderDetail(cart, orderLatest);
                        // Update product quantity
                        pDAO.updateQuanityProduct(cart);
                    }
                    carts = null;
                    cookie = cUtil.getCookieByName(request, "Cart");
                    cUtil.saveCartToCookie(request, response, emptyCart);

                    session.setAttribute("CART", carts);
                    check = "true";

                } else {
                    message = "Order failed";
                }
            } else {
                if (user == null) {
                    message = "You need to log in to your account to checkout";
                } else if (user.getRoleID() == 1) {
                    message = "Admin cannot perform this task";
                }
            }

            request.setAttribute("PAYMENTS", pms);
            request.setAttribute("MESSAGE", message);
            request.setAttribute("CHECK", check);
        } catch (Exception e) {
            log("CheckoutServlet Error:" + e.getMessage());
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
