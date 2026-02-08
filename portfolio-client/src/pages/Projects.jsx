import { useEffect, useState } from "react";
import { getProjects } from "../api/projectApi";

function Projects() {
  const [projects, setProjects] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getProjects()
      .then((res) => {
        setProjects(res.data);
      })
      .catch((err) => {
        console.error("Error fetching projects:", err);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  if (loading) return <h2>Loading projects...</h2>;

  return (
    <div style={{ padding: "20px" }}>
      <h1>My Projects</h1>

      {projects.length === 0 && <p>No projects found</p>}

      {projects.map((project) => (
        <div
          key={project.id}
          style={{
            border: "1px solid #ccc",
            padding: "16px",
            marginBottom: "15px",
            borderRadius: "8px",
          }}
        >
          <h3>{project.title}</h3>
          <p>{project.description}</p>

          {/* ✅ CLIENT INFO (ER Diagram aligned) */}
          {project.client && (
            <p>
              <strong>Client:</strong>{" "}
              {project.client.websiteUrl ? (
                <a
                  href={project.client.websiteUrl}
                  target="_blank"
                  rel="noreferrer"
                >
                  {project.client.name}
                </a>
              ) : (
                project.client.name
              )}
            </p>
          )}

          {/* ✅ PROJECT LINKS */}
          <div>
            {project.liveDemoUrl && (
              <a
                href={project.liveDemoUrl}
                target="_blank"
                rel="noreferrer"
              >
                Live Demo
              </a>
            )}

            {project.sourceCodeUrl && (
              <>
                {" | "}
                <a
                  href={project.sourceCodeUrl}
                  target="_blank"
                  rel="noreferrer"
                >
                  Source Code
                </a>
              </>
            )}
          </div>
        </div>
      ))}
    </div>
  );
}

export default Projects;

