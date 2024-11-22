# Read Me

The original idea is from  
https://vladmihalcea.com/log-sql-spring-boot/

This project uses DataSource-Proxy to log SQL statements.

Change application.properties

```
logging.level.net.ttddyy.dsproxy.listener=debug
```

And now Spring Boot can print meaningful SQL statements that were generated by any data access technology:

```
Name:dataSource, Connection:5, Time:1, Success:True
Type:Prepared, Batch:False, QuerySize:1, BatchSize:0
Query:["
    SELECT
        u.id AS id1_7_,
        u.email AS email5_7_,
        u.external_id AS external6_7_,
        u.first_name AS first_na7_7_,
        u.last_name AS last_nam9_7_,
    FROM users u
    WHERE u.email = ?
"]
Params:[(
john.doe@acme.com
)]
```