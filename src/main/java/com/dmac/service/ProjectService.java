package com.dmac.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmac.entity.Projects;

@Service
public class ProjectService {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Autowired
	public UsersService usersService;
	
	@Transactional
	public List<Projects> fetchAllProjects(String userName) {
		 
		
		String userID = usersService.fetchUserID(userName);
		int userIDInt = Integer.parseInt(userID);
		
		List<Projects> listOfProjects = entityManager.createQuery("select projects from Projects projects where userID=:value", Projects.class)
													 .setParameter("value", userIDInt)
													 .getResultList();
		return listOfProjects;
	}
	
	
	@Transactional
	public boolean persistProject(String projectName, int userID, String projectSchema) {
		 
		Objects.requireNonNull(projectName, "projectName null in persistProject() of ProjectService component");
		Objects.requireNonNull(userID, "userName null in persistProject() of ProjectService component");
		Objects.requireNonNull(projectSchema, "projectSchema null in persistProject() of ProjectService component");
		
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Date createdAt = new java.sql.Date(date.getTime());
		
		
		Projects projects = new Projects();
		projects.setProjectName(projectName);
		projects.setUserID(userID);
		projects.setProjectSchema(projectSchema);
		projects.setCreatedAt(createdAt);
		projects.setUpdatedAt(createdAt);
		
		entityManager.persist(projects);
		
		return true;
	}
}
