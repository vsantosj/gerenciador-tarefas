package com.nomedaempresa.taskmanager.entity;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	
	private Long id;
	private String title;
	
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
	private LocalDate dueDate;
	private String assignedTo;
	
    public Task() {
    }

    public Task(Long id, String title, LocalDate dueDate, String assignedTo) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", dueDate=" + dueDate + ", assignedTo=" + assignedTo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(assignedTo, dueDate, id, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(assignedTo, other.assignedTo) && Objects.equals(dueDate, other.dueDate)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}
	
	
	
	

}
