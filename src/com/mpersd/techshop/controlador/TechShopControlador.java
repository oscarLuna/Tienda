package com.mpersd.techshop.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.techshop.dominio.Producto;
import com.mpersd.techshop.dominio.Usuario;
import com.mpersd.techshop.modelo.CarritoCompra;
import com.mpersd.techshop.modelo.Orden;
import com.mpersd.techshop.servicio.IProductoServicio;
import com.mpersd.techshop.servicio.IUsuarioServicio;
import com.mpersd.techshop.util.GeneradorPDF;

@Controller
public class TechShopControlador {

	@Autowired
	IProductoServicio pServ;
	@Autowired
	IUsuarioServicio uServ;

	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String index(ModelMap model, HttpSession sesion) {
		
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		
		return "index";
	}
	
	@RequestMapping(value = { "/carrito" }, method = RequestMethod.GET)
	public String shopCart(ModelMap model,  HttpSession sesion) {
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		
		CarritoCompra carrito = (CarritoCompra) sesion.getAttribute("carrito");
		model.addAttribute("carrito",carrito);
		return "carrito";
	}
	
	@RequestMapping(value = { "/orden" }, method = RequestMethod.GET)
	public String checkout(ModelMap model,  HttpSession sesion) {
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		
		CarritoCompra carrito = (CarritoCompra) sesion.getAttribute("carrito");
		model.addAttribute("carrito",carrito);
		return "orden";
	}
	
	@RequestMapping(value = { "/RealizarOrden" }, method = RequestMethod.GET)
	public String getCheckout(ModelMap model,  HttpSession sesion) {
		Usuario user = getUsuario(getPrincipal());
		CarritoCompra carrito = (CarritoCompra) sesion.getAttribute("carrito");
		
		Orden ordenCompra = new Orden();
		
		ordenCompra.setCarrito(carrito);
		ordenCompra.setUsuario(user);
		
		//File file = new File("C:/Users/oscarluna/Desktop/hello.pdf");
        //file.getParentFile().mkdirs();
        try {
			new GeneradorPDF().createPdf(ordenCompra);
			carrito = new CarritoCompra();
			sesion.setAttribute("carrito", carrito);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
   
		return "index";
	}
	
	@RequestMapping(value = { "/producto" }, method = RequestMethod.GET)
	public String singleProduct(ModelMap model,  HttpSession sesion, @RequestParam("codigo") int id) {
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		
		Producto p = pServ.getProducto(id);
		model.addAttribute("producto",p);
		
		return "producto";
	}
	
	@RequestMapping(value = { "/categorias" }, method = RequestMethod.GET)
	public String categorias(ModelMap model) {
		
		return "categorias";
	}
	
	@RequestMapping(value = { "/micuenta" }, method = RequestMethod.GET)
	public String myAccount(HttpSession sesion) {
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		
		return "micuenta";
	}
	
	@RequestMapping(value = { "/tienda" }, method = RequestMethod.GET)
	public String shopPage(HttpSession sesion) {
		
		Usuario user = getUsuario(getPrincipal());
		sesion.setAttribute("user", user);
		return "tienda";
	}

	
	@RequestMapping(value = { "/busqueda" }, method = RequestMethod.GET)
	public String busqueda(ModelMap model, @RequestParam("search") String search) {
		List<Producto> productos = pServ.getProductoBusqueda(search);
		model.addAttribute("productos", productos);
		return "busqueda";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registryPage() {
		return "registro";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	private Usuario getUsuario(String userName){
		Usuario usuario = null;
		if(!userName.equals("anonymousUser")){
			usuario=uServ.getUsuario(userName);
		}
		return usuario;
	}

}
