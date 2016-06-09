package webapp.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(ModelMap model) {
		model.addAttribute("todos", todoService.retrieveTodos("webapp"));
        return "list-todos";
    }
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "webapp", "", new Date(), false));
        return "addTodo";
    }
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap model, @Valid Todo todo, BindingResult result ) {
		
		if(result.hasErrors()){
			return "addTodo";
		}
		//clears the url
		model.clear();
		todoService.addTodo("webapp", todo.getDesc(), new Date(), false);
		//redirect to the url so that ${todos} can be available in jsp
        return "redirect:list-todos";
    }
	
	@RequestMapping(value= "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, ModelMap model){
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
        model.addAttribute("todo", todoService.retrieveTodo(id));
        return "updateTodo";
    }
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
        	return "updateTodo";        	
        }

        todo.setUser("webapp"); //TODO:Remove Hardcoding Later
        todoService.updateTodo(todo);

        model.clear();// to prevent request parameter "name" to be passed
        return "redirect:/list-todos";
    }

	
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		if(!auth.isUserValid(name, password)){
//			model.put("errorMessage", "Invalid Credentials");
//			return "login";
//		}
//		
//		model.put("name", name);
//		model.put("password", password);
//		return "welcome";			
//    }
}

