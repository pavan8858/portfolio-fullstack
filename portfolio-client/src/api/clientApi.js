import api from "./axios";

// GET all clients
export const fetchClients = () => {
  return api.get("/clients");
};
