package com.nomedaempresa.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nomedaempresa.taskmanager.entity.Task;

@Controller
@RequestMapping("/tarefas")
public class TaskController {

    List<Task> tasksList = new ArrayList<>();
    private Long nextId = 1L;

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
        if (task.getId() != null) {
            for (int i = 0; i < tasksList.size(); i++) {
                if (tasksList.get(i).getId().equals(task.getId())) {
                    tasksList.get(i).setTitle(task.getTitle());
                    tasksList.get(i).setDueDate(task.getDueDate());
                    tasksList.get(i).setAssignedTo(task.getAssignedTo());
                    break;
                }
            }
        } else {
            task.setId(nextId++);
            tasksList.add(task);
        }
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id ) {
        tasksList.removeIf(t -> t.getId().equals(id));
        return "redirect:/tarefas/lista";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tasks/task-registration");

        Task task = null;
        for (Task t : tasksList) {
            if (t.getId().equals(id)) {
                task = t;
                break;
            }
        }

        if (task == null) {
            mv.setViewName("redirect:/tarefas/lista");
        } else {
            mv.addObject("task", task);
        }

        return mv;
    }
}

