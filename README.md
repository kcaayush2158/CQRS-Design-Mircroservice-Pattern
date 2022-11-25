# Command Query Responsibility Segregator (CQRS) Design Pattern

Every microservices design has either the database per service model or the shared database per service. But, in the database per service model, we cannot implement a query as the data access is only limited to one single database. So, in such scenario you can use the CQRS pattern. According to this pattern, the application will be divided into two parts: Command and Query. The command part will handle all the requests related to CREATE, UPDATE, DELETE while the query part will take care of the materialized views. The materialized views are updated through a sequence of events which are creating using the event source pattern discussed below.

![1_TaPzEj91HM06UgZoajqGwA](https://user-images.githubusercontent.com/28734661/203921346-eb120701-7279-4819-8fad-124454922c28.png)


AXON Server 

Download Link : https://developer.axoniq.io/download
