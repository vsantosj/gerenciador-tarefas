package com.nomedaempresa.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nomedaempresa.taskmanager.entity.Task;

@Controller
@RequestMapping("/tarefas")
public class TaskController {
	
			
	List<Task> tasksList = new ArrayList<>();
	@GetMapping("/cadastro")
	public String registrationTask(Task task){
		return "tasks/task-registration";
	}
	@GetMapping("/lista")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("/tasks/task-list");
		mv.addObject("tasks", tasksList);
		return mv;
	}
	
	@PostMapping("/salvar")
	public String createTask(Task task) {
	    System.out.println("DEBUG: Task recebida do formulário: " + task); // Isso vai imprimir no console quando o formulário for submetido
	    Task t = new Task();
	    Long id = tasksList.size() + 1L;
	    t.setId(id);
	    t.setTitle(task.getTitle());
	    t.setDueDate(task.getDueDate());
	    t.setAssignedTo(task.getAssignedTo());

	    tasksList.add(t);
	    System.out.println("DEBUG: tasksList após adição: " + tasksList); // Isso também vai imprimir no console
	    return "redirect:/tarefas/lista";
	}
}

