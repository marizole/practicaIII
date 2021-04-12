package com.emergentes.controlador;


import com.emergentes.modelo.GestorProductos;
import com.emergentes.modelo.producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        producto objproducto = new producto();
        int id;
        int pos;
        String op = request.getParameter("op");
        if(op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorProductos agenda = (GestorProductos) ses.getAttribute("agenda");
            objproducto.setId(agenda.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miproducto",objproducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("modificar")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorProductos agenda = (GestorProductos) ses.getAttribute("agenda");
            pos = agenda.ubicarproducto(id);
            objproducto = agenda.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miproducto", objproducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if(op.equals("eliminar")){
            id=Integer.parseInt(request.getParameter("agenda"));
            HttpSession ses = request.getSession();
            GestorProductos agenda = (GestorProductos) ses.getAttribute("agenda");
            pos=agenda.ubicarproducto(id);
            agenda.eliminarproducto(pos);
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        producto objproducto = new producto();
        int pos;
        String op = request.getParameter("op");
                
        if(op.equals("grabar")){
            objproducto.setId(Integer.parseInt(request.getParameter("id")));
            objproducto.setProducto(request.getParameter("producto"));
            objproducto.setPrecio(Integer.parseInt(request.getParameter("precio")));
            objproducto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                       
            
            HttpSession ses = request.getSession();
            GestorProductos agenda = (GestorProductos) ses.getAttribute("agenda");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                agenda.insertarproducto(objproducto);
            }
            else{
                pos = agenda.ubicarproducto(objproducto.getId());
                agenda.modificarproducto(pos, objproducto);
            }
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }

    } 
}


