# springboot-redis-cache

### **Steps to start this application**

1. Execute docker composer to start redish locally ($> <span style="color:#D2DE32">docker compose up</span>
2. Create a local folder and keep **<span style="color:#D2DE32">redis.conf</span>** and point in docker-compose volume section
3. Start your spring application 

### **Test confirmation**
1. Use below curl to create a user. Hence, it should save in cache

```ruby
   curl --location 'http://localhost:8080/user' \
    --header 'Content-Type: application/json' \
    --data '{
    "id": "100",
    "name": "Raj",
    "address": "BBS"
}'
```

2. We created user with name **Raj** with id=100(cache key) but, GET api return a constant value of user **Ritu**(id=100) 
But, Get call should return cashed user(Raj) with id "100" instead of constant user(Ritu)
```ruby 
    curl --location 'http://localhost:8080/user/100'
    
    Response: (Recieved cached user)
    
    {
        "id": "100",
        "name": "Raj",
        "address": "BBS"
    }
```