package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import projects.dao.ProjectDao;
import projects.entity.Project;
import projects.exception.DbException;

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

	public void modifyProjectDetails(Project project) {
		if(!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID =" 
					+ project.getProjectId() + " does not exist.");
		}
	}

	public void deleteProject(int projectId) {
		boolean value = projectDao.deleteProject(projectId);
		if(!value) {
			throw new DbException("The project: " + projectId + " doesn't exist.");
		}
		
	}

	

}
