package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {

	private ProjectDao projectDao = new ProjectDao();
	
	public Project addProject(Project project) {
		
		return projectDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}

	public Project fetchProjectById(Integer projectID) {
		return projectDao.fetchProjectByID(projectID).orElseThrow(
				() -> new NoSuchElementException(
						"Project with project ID = " + projectID
						+ " does not exist. "));
	}

	

}
