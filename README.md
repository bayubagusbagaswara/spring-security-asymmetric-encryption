# 1. Generate Private Key

```bash
openssl genrsa -out src/main/resources/keys/local-only/private-key.pem 2048
```

# 2. Generate Public Key dari Private Key

```bash
openssl rsa -in src/main/resources/keys/local-only/private-key.pem -pubout -out src/main/resources/keys/local-only/public-key.pem
```
