#!/bin/bash
curl localhost:8080
curl localhost:8080/account/400123456
curl http://localhost:8080/add -d"id=400999999&amount=20.5"
curl http://localhost:8080/add -d"id=400123456&amount=20.5"
curl -X PUT localhost:8080/transfer -H "Content-Type:application/json" --data "{\"fromAccountId\":"400123456", \"toAccountId\":"400234567", \"amount\":"50.25"}"
curl http://localhost:8080/
curl http://localhost:8080/account/400123456
curl http://localhost:8080/account/400234567
curl -X PUT localhost:8080/transfer -H "Content-Type:application/json" --data "{\"fromAccountId\":"400123456", \"toAccountId\":"400234567", \"amount\":"100"}"
curl -X PUT localhost:8080/transfer -H "Content-Type:application/json" --data "{\"fromAccountId\":"400123456", \"toAccountId\":"400123456", \"amount\":"50.25"}"
curl -X PUT localhost:8080/transfer -H "Content-Type:application/json" --data "{\"fromAccountId\":"400123456", \"toAccountId\":"400123456", \"amount\":"0"}"
read -p "Press enter to continue"