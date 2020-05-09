package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HomeController {

	@Autowired
	PersonRepositioy personRepositioy;
	
	/**@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String myName, HttpSession session) {
		//session.setAttribute("name", myName);
		//return "home"; Person
		
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("name",myName);
		modelview.setViewName("home");
		return modelview;
	}
	
	@RequestMapping("person")
	public ModelAndView home(Person person, HttpSession session) {
		//session.setAttribute("name", myName);
		//return "home"; 
		
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("person",person);
		modelview.setViewName("home");
		return modelview;
	}**/
	
	@RequestMapping("addperson")
	@ResponseBody
	public void addperson(Person person) {
		personRepositioy.save(person);
	}
	
	
	@RequestMapping("getallpersons")
	@ResponseBody
	public List<Person> getAllPerson() {
		return (List<Person>) personRepositioy.findAll();
	}
	
	
	
}
