import api from "./axios";

// GET all projects
export const getProjects = () => {
  return api.get("/projects");
};

// GET project by id (future use)
export const getProjectById = (id) => {
  return api.get(`/projects/${id}`);
};
