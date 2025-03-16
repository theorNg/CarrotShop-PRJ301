/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrot.controller.web.cart_wishlist;

import carrot.utils.WishlistUtil;
import carrot.utils.CartUtil;
import carrot.dao.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import carrot.model.CartItem;
import carrot.model.ProductDTO;

/**
 *
 * @author lvhho
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    private static final String CART_PAGE = "view/jsp/home/cart.jsp";
    private static final String CART_AJAX = "view/jsp/ajax/cart_ajax.jsp";
    private static final String CART_PAGE_AJAX = "view/jsp/ajax/cart_page_ajax.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = CART_AJAX;
        ProductDAO pDao = new ProductDAO();
        CartUtil cartUtil = new CartUtil();
        List<CartItem> carts = null;
        HashMap<Integer, CartItem> listItem = null;

        WishlistUtil wUtil = new WishlistUtil();
        List<ProductDTO> wishlists = null;
        HashMap<Integer, ProductDTO> listWishlist = null;
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            if (action == null) {
                url = CART_PAGE;
            } else {
                String product_id = request.getParameter("product_id");
                ProductDTO product = pDao.getProductByID(Integer.parseInt(product_id));
                if ("Add".equals(action)) {
                    String quantity = request.getParameter("quantity");
                    CartItem item = new CartItem(product, Integer.parseInt(quantity));
                    carts = (List<CartItem>) session.getAttribute("CART");
                    if (carts == null) {
                        listItem = cartUtil.createCart(item);
                    } else {
                        listItem = cartUtil.addItemToCart(item);
                    }
                    // Delete product in wishlist
                    wishlists = (List<ProductDTO>) session.getAttribute("WISHLIST");
                    if (wishlists != null) {
                        listWishlist = wUtil.removeItem(product);
                        wishlists = new ArrayList<>(listWishlist.values());
                        session.setAttribute("WISHLIST", wishlists);
                    }
                } else if ("Delete".equals(action)) {
                    String curPage = request.getParameter("curPage");
                    if ("cart.jsp".equals(curPage)) {
                        url = CART_PAGE_AJAX;
                    } else if ("header.jsp".equals(curPage)) {
                        url = CART_AJAX;
                    }

                    listItem = cartUtil.removeItem(product);
                } else if ("Update".equals(action)) {
                    url = CART_PAGE_AJAX;
                    String quantity = request.getParameter("quantity");
                    CartItem item = new CartItem(product, Integer.parseInt(quantity));
                    listItem = cartUtil.updateItemToCart(item);
                }
            }
            carts = new ArrayList<>(listItem.values());
            session.setAttribute("CART", carts);
            // Save to cookie
            String strCarts = cartUtil.convertToString();
            cartUtil.saveCartToCookie(request, response, strCarts);

            String strWishlist = wUtil.convertToString();
            wUtil.saveWishlistToCookie(request, response, strWishlist);

        } catch (Exception ex) {
            log("CartServlet error:" + ex.getMessage());
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
