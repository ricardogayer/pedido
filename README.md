# Pedido (exemplo)

Spring Boot and JPA sample project 

## Docker p/ PostgreSQL
```ssh
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name postgres -e POSTGRES_USER=comercio -e POSTGRES_PASSWORD=comercio -e POSTGRES_DB=comercio -p 5432:5432 postgres:11.5
```

# Teste
