Take the docker container using the following command:
$ docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

After downloading and running the target image, you need to create two queues:
FirstQueue
SecondQueue

Log in to the RabbitMQ Queue Management Dashboard
http://localhost:15672
Login: guest
Password: guest



