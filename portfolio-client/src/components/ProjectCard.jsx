function ProjectCard({ project }) {
  return (
    <div className="card">
      <h3>{project.title}</h3>
      <p>{project.description}</p>
      <a href={project.liveDemoUrl} target="_blank">Live</a>
      <a href={project.sourceCodeUrl} target="_blank">Code</a>
    </div>
  );
}

export default ProjectCard;
