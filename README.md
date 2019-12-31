# fitness-data-dashboard

A scalable fitness data collecting system with RESTful APIs in microservices architecture using Spring Framework (Boot/MVC/Data) to receive data from client, pre-process data and publish to message queue, save data to database or send for real-time display.

Combined with data ingestion to pre-process raw input data from client and publish to RabbitMQ as data buffer & data broker for decoupling. Implemented three kind of consumer handling data from message queue.

- Rule engine triggers actions based on data.
- Real-time queue return data for display.
- Data saved in MySQL, MongoDB via JPA.

Use Netflix Eureka to discover and register those microservices above for higher availability.

For testing, a data simulator is implemented to generate random data for data APIs testing.

