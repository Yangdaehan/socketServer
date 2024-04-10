# Web Server with socket API

소켓 API를 활용하여 나만의 간단한 웹서버 만들기


## Introduction

Highlevel HTTP level APIS 대신에 소켓 API를 사용하여 웹서버를 구현합니다. 


## Requirements

rules
```

1. You need to open 80 listening port

2. You need to accept the connection request from the port

3. You need to read the data from the port

4. Parse the input and print out the data according to the HTTP GET request.

5. Prepare your response, according to the GET request. Make some HTTP header and body. If you need to read data, read it from the file

6. Send it to the client

7. Check it from the web brower

8. You can add some functions such as multi-threaded clients supports, handling dynamic contents, or the other HTTP requests format such as POST.

9. Submit the documents with git repo. address, if don't know how to use git/github, attach the compressed source file in the submission. 

```

## Implementation details

* Http GET 메소드를 읽고 처리할 수 있습니다.
* 특정 시점에 동시에 발생하는 트래픽을 처리합니다.


## Language & Build Environment

* Java
* IntelliJ
