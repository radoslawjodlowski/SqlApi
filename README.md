# SqlApi - library for database

## Description

This is my library to communicate with MSSQL. I use it in a few of my projects, when it communicates with the database using the execution of stored procedures instead of mapping such as Hibernate.

> This code is an example of saying: 'makeshift proves to be the most durable'.

### Technological stack

MS SQL Server, Java/Spring

## How it works ?

1. Object of class `SqlApi` during construction opens the connection to the database using the provided sql string.

2. Method `query` transmits the query to the database.

3. The feedback data is received in the form of a map list, like `List<Map<String, Object>>`

4. All exceptions are wrapped in my exception `SqlApiException`

5. Additionally, library uses a type logger like `slf4j`, for logging all queries, receiving data and exceptions in `debug` mode.

## TODO
[ ] Automatic reconnect

# Example usage

```java
@Component
class someClass()
{
    private SqlApi sqlApi;

    @Autowired
    someClass(SqlApi sqlApi)
    {
        this.sqlApi = sqlApi;
    }

    void someQuery(Integer count) throws SqlApiException
    {
        List<Map<String, Object>> mapList = sqlApi.query("exec dbo.getLastNews @count=" + count);
        for (Map<String, Object> item : mapList)
        {
            News a = new News((item));
            ...    
        }
    }
}
```
