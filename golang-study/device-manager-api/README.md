# Project
> Device manager to practice Golang.

# Technologies
- mux (Restful API)
- gorm (GO ORM)

# Build
- Build and generate bin `go build -o dmi cmd/device_manager_api.go`

# Endpoints
- `GET .../device&page=0&size=10` (Get all devices)
- `POST .../device` (Create a new device)
- `PUT .../device/{id}` (Update an existing device)
- `DELETE .../device/{id}` (Delete an existing device)

JSON example for request `POST` and `PUT or PATCH`:
```
{
    "nickname": "example",
    "owner": "example",
    "ip" : "example
}
```

# Docker
- Build image `docker build -t device-manager-api .`
- Run container from local image `docker run -p8000:8000 -d --rm device-manager-api`
- Set a tag on local image `docker tag device-manager-api jclaudiocf/device-manager-api`
- Publish an image `docker push jclaudiocf/device-manager-api`
- Run container from docker hub image `docker run -p8000:8000 -d --rm jclaudiocf/device-manager-api`

# Docker compose
- Run container `docker-compose up -d`
