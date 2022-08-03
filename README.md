
# Dunder-Mifflin Paper Company

Dunder-Mifflin deals with the paper stock production where various attributes
are considered like paper color, paper age, paper size. Papers are srored with
stocks.


## API Reference

#### Get all paper stocks

```http
  GET http://localhost:8080/paper/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `json` | **Required**. Your API key |

#### Get single paper stock

```http
  GET http://localhost:8080/paper/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of paper stock to fetch |


```http
  POST http://localhost:8080/paper/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{ "paperSize" : "A4", "paperAgeingInYears" : 4, "paperColor" : "yellow" }`| `json` | **Required**. All the values in json |

```http
  PUT http://localhost:8080/paper/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{ "paperStockId" : 1,"paperSize" : "A4", "paperAgeingInYears" : 4, "paperColor" : "yellow" }`| `json` | **Required**. All the values in json |

```http
  DELETE http://localhost:8080/paper/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of paper stock to delete |

## Deployment

To deploy this project go to the target folder and open command prompt if in windows or terminal if using ubuntu and type the below command

```bash
  java -jar dunder-mifflin-0.0.1-SNAPSHOT.jar
```


## Screenshots

![Screenshot from 2022-08-03 09-23-08](https://user-images.githubusercontent.com/59513691/182521682-95f55f88-2a82-4ce8-b135-214cf5c5ae72.png)


