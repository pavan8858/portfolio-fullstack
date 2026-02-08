import { useEffect } from "react";
import api from "../api/axios";

function Clients() {

  useEffect(() => {
    api.get("/clients")
      .then(res => {
        console.log("CLIENTS DATA 👉", res.data);
      })
      .catch(err => {
        console.error("CLIENT API ERROR ❌", err);
      });
  }, []);

  return (
    <div>
      <h1>Clients Page</h1>
      <p>Check console for clients data</p>
    </div>
  );
}

export default Clients;
