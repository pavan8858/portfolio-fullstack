function ClientCard({ client }) {
  return (
    <div style={styles.card}>
      <img
        src={client.logoUrl}
        alt={client.name}
        style={styles.logo}
      />

      <h3>{client.name}</h3>
      <p>{client.description}</p>

      <a href={client.websiteUrl} target="_blank" rel="noreferrer">
        Visit Website
      </a>
    </div>
  );
}

const styles = {
  card: {
    border: "1px solid #ddd",
    padding: "16px",
    borderRadius: "8px",
    width: "250px",
  },
  logo: {
    width: "100%",
    height: "120px",
    objectFit: "contain",
  },
};

export default ClientCard;
