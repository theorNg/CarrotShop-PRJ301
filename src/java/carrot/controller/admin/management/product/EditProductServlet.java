/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrot.controller.admin.management.product;

import carrot.dao.CategoryDAO;
import carrot.dao.ProductDAO;
import carrot.dao.SupplierDAO;
import carrot.dao.TypeDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import carrot.model.CategoryDTO;
import carrot.model.ProductDTO;
import carrot.model.SupplierDTO;
import carrot.model.TypeDTO;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author Dell
 */
@WebServlet(name = "EditProductServlet", urlPatterns = {"/EditProductServlet"})
public class EditProductServlet extends HttpServlet {

    private static final String EDIT_PAGE = "view/jsp/admin/admin_edit_product.jsp";
    private static final String MANAGE_PRODUCT_CONTROLLER = "ManageProductServlet";

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
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            String url = EDIT_PAGE;
            if (action == null) {
                ProductDAO dao = new ProductDAO();
                String pid_raw = request.getParameter("product_id");

                ProductDAO pDao = new ProductDAO();
                CategoryDAO cDao = new CategoryDAO();
                SupplierDAO sDao = new SupplierDAO();
                TypeDAO tDao = new TypeDAO();

                List<CategoryDTO> listCategories = cDao.getData();
                List<SupplierDTO> listSuppliers = sDao.getData();
                List<TypeDTO> listTypes = tDao.getAllType();
                ProductDTO product = pDao.getProductByID(Integer.parseInt(pid_raw));

                request.setAttribute("LIST_SUPPLIERS", listSuppliers);
                request.setAttribute("LIST_TYPES", listTypes);
                request.setAttribute("LIST_CATEGORIES", listCategories);
                request.setAttribute("pid", product.getId());
                request.setAttribute("pstock", product.getStock());
                request.setAttribute("pname", product.getName());
                request.setAttribute("pcolors", product.getColors());
                request.setAttribute("psize", product.getSize());
                request.setAttribute("pprice", product.getPrice());
                request.setAttribute("psupplier", product.getSupplier());
                request.setAttribute("pdescription", product.getDescription());
                request.setAttribute("preleasedate", product.getReleasedate());
                request.setAttribute("pimages", product.getImages());
                request.setAttribute("pcategory", product.getCategory());
                request.setAttribute("pdiscount", product.getDiscount());
                request.setAttribute("ptype", product.getType());
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                url = MANAGE_PRODUCT_CONTROLLER;
                String pid_raw = request.getParameter("product_id");
                String pname = request.getParameter("product_name");
                String[] pimages = request.getParameterValues("product_img");
                String pcolors = request.getParameter("product_color");
                String psizes = request.getParameter("product_size");
                String pprice_raw = request.getParameter("product_price");
                String pdescription = request.getParameter("product_description");
                String pstock_raw = request.getParameter("product_stock");
                String pcategory_raw = request.getParameter("category_id");
                String psupplier_raw = request.getParameter("supplier_id");
                String ptype_raw = request.getParameter("type_id");
                String pdate = request.getParameter("date");
                String pdiscount_raw = request.getParameter("product_discount");

                ProductDAO dao = new ProductDAO();
                double pprice, pdiscount;
                int pstock, psupplier, pcategory, ptype, pid;
                String image = "";
                pprice = Double.parseDouble(pprice_raw);
                pstock = Integer.parseInt(pstock_raw);
                pid = Integer.parseInt(pid_raw);
                pdiscount = Double.parseDouble(pdiscount_raw);
                ptype = Integer.parseInt(ptype_raw);
                psupplier = Integer.parseInt(psupplier_raw);
                pcategory = Integer.parseInt(pcategory_raw);
                if (pimages[0] != null && !pimages[0].equals("")) {
                    for (int i = 0; i < pimages.length; i++) {
                        image += "view/assets/home/img/products/" + pimages[i] + " ";
                    }
                }
                dao.editProduct(pid, pname, pdescription, pstock, image, pcolors, psizes, pdate, pdiscount, pprice, pcategory, psupplier, ptype);

                request.setAttribute("mess", "Edit successfully!");
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (Exception ex) {
            log("EditProductServlet error:" + ex.getMessage());
        }
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
