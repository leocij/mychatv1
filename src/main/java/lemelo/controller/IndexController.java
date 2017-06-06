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
	private List<String> usuarios = new ArrayList<>();
	private int cont = 0;

	@RequestMapping("/index")
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {

		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		ModelAndView modelView = new ModelAndView("index");
		
		for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).equals(usuario))
			{
				cont++;
			}
			//System.out.println("usuario[" + i + "] : " + usuarios.get(i));
		}
		//System.out.println("--------------------");
		if(cont == 0){
			usuarios.add(usuario);
		} else {
			cont = 0;
		}
		
		modelView.addObject("usuarioLogado", usuario);
		modelView.addObject("usuarios", usuarios);
		
		return modelView;
	}
	
}