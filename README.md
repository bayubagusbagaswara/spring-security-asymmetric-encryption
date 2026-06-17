# Generate Private Key

```bash
openssl genrsa -out src/main/resources/keys/local-only/private-key.pem 2048
```

# Generate Public Key dari Private Key

```bash
openssl rsa -in src/main/resources/keys/local-only/private-key.pem -pubout -out src/main/resources/keys/local-only/public-key.pem
```

# Run Docker Compose

```bash
docker compose up -d
```