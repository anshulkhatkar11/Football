# Football Task

Make a project and implement spring security with JWT, restrict access for these APIs as they cannot
be accessed by anyone that is not authorised.
Save user detail and date Time of when the token is created, set 10 minutes timeout for JWT, it must
expire after 10 min and that user cannot get data when the token is expired.

Task1. Create an API in which you will pass the JWT token and retrieve the values saved in that token
with its expiration time.

Task2. The Task Will is the REST API contains information about football matches. The Provided API
allows querying matches by year. The Task is to get the number of matches for a given year that
ended in a draw. A match is drawn when both teams scored the same number of goals.

API created ->

1. Api to create JwtToken using userName and password
curl --location 'localhost:9092/authenticate' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=134346B87CE8E9822406DF032C4D63D7' \
--data '{
    "userName":"DemoUsername",
    "password":"DemoPassword"
}'


2.  REST API to get information about football matches. It will require JwtToken created using API 1

curl --location 'localhost:9092/matches/draws/2011' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEZW1vVXNlcm5hbWUiLCJleHAiOjE2Nzk0NTg4NTIsImlhdCI6MTY3OTQ1ODI1Mn0.qSoNsuOo72a7D0ei--9UaWwQrvE9DrXCqmpr4jcnllo' \
--header 'Cookie: JSESSIONID=134346B87CE8E9822406DF032C4D63D7'

3. API in which we pass the JWT token and retrieve the values saved in that token with its expiration time.

curl --location 'localhost:9092/jwt' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEZW1vVXNlcm5hbWUiLCJleHAiOjE2Nzk0NTg4NTIsImlhdCI6MTY3OTQ1ODI1Mn0.qSoNsuOo72a7D0ei--9UaWwQrvE9DrXCqmpr4jcnllo' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=134346B87CE8E9822406DF032C4D63D7' \
--data '{
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEZW1vVXNlcm5hbWUiLCJleHAiOjE2Nzk0NTg4NTIsImlhdCI6MTY3OTQ1ODI1Mn0.qSoNsuOo72a7D0ei--9UaWwQrvE9DrXCqmpr4jcnllo"
}'

Both APIs 2 and 3 will require JwtToken that we create using API 1.
