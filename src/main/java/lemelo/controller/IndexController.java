package lemelo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private List<String> usuarios = new ArrayList<>();;

	@RequestMapping("/index")
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {

		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		
		usuarios.add(usuario);
		
		ModelAndView modelView = new ModelAndView("index");

			modelView.addObject("usuarios", usuarios);
		
		return modelView;
	}
	
}