docker stop rabbitmq
docker rm rabbitmq
docker run -d --hostname localhost -p 5672:5672 --name rabbitmq rabbitmq:3