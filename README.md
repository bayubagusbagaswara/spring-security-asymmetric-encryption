# Kalau sebelumnya kamu sudah pernah memakai volume PostgreSQL lama, lalu ingin benar-benar fresh dari awal, gunakan:
```bash
docker compose down -v
docker compose up -d
```
Tapi hati-hati, -v akan menghapus data database lama.


# Menjalankan docker compose:
```bash
docker compose down
docker compose pull
docker compose up -d
```

# Iya, kalau yang ingin kamu nyalakan adalah PostgreSQL di Docker, cukup jalankan:
```bash
docker compose up -d
```

# Perintah itu akan menjalankan service yang ada di docker-compose.yml, yaitu PostgreSQL kamu:

```bash
services:
  postgres:
```

# Setelah itu, baru kamu run project Spring Boot dari IntelliJ seperti biasa, misalnya klik tombol Run pada main class:

```bash
SpringSecurityAsymmetricEncryptionApplication
```

# Kalau PostgreSQL sudah running sebelumnya, sebenarnya kamu tidak perlu menjalankan docker compose up -d terus-menerus. Cukup cek di Docker Desktop apakah container spring_sec_asymmetric masih running.

##  Beberapa perintah yang berguna:
## Untuk cek status container.
```bash
docker compose ps
```
## Untuk mematikan container
```bash
docker compose down
```

# Generate Private Key

```bash
openssl genrsa -out src/main/resources/keys/local-only/private-key.pem 2048
```

# Generate Public Key dari Private Key

```bash
openssl rsa -in src/main/resources/keys/local-only/private-key.pem -pubout -out src/main/resources/keys/local-only/public-key.pem
```