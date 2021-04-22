
<a name="paths"></a>
## Paths

<a name="createusingpost"></a>
### create
```
POST /chapter23/user
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**user**  <br>*required*|user|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|integer (int32)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* my-user-controller


<a name="deleteallusersusingdelete"></a>
### deleteAllUsers
```
DELETE /chapter23/user/all
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|integer (int32)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* my-user-controller


<a name="getallusersusingget"></a>
### getAllUsers
```
GET /chapter23/user/count
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|integer (int32)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* my-user-controller


<a name="getbynameusingget"></a>
### getByName
```
GET /chapter23/user/{name}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**name**  <br>*required*|name|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [User](#user) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* my-user-controller


<a name="deletebynameusingdelete"></a>
### deleteByName
```
DELETE /chapter23/user/{name}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**name**  <br>*required*|name|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|integer (int32)|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* my-user-controller


<a name="indexusingpost"></a>
### index
```
POST /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingget"></a>
### index
```
GET /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingput"></a>
### index
```
PUT /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingdelete"></a>
### index
```
DELETE /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingpatch"></a>
### index
```
PATCH /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusinghead"></a>
### index
```
HEAD /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingoptions"></a>
### index
```
OPTIONS /customer
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* customer-controller


<a name="indexusingpost_1"></a>
### index
```
POST /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusingget_1"></a>
### index
```
GET /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusingput_1"></a>
### index
```
PUT /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusingdelete_1"></a>
### index
```
DELETE /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusingpatch_1"></a>
### index
```
PATCH /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusinghead_1"></a>
### index
```
HEAD /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="indexusingoptions_1"></a>
### index
```
OPTIONS /index
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* hello-controller


<a name="aausingget"></a>
### 获取学生清单
```
GET /student/aa
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 学生管理
* 教学管理


<a name="bbusingget"></a>
### 获取某个老师的学生清单
```
GET /student/bb
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 学生管理


<a name="ausingget"></a>
### 获取老师清单
```
GET /teacher/a
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 教学管理
* 教师管理


<a name="busingget"></a>
### 获取某个学生的老师清单
```
GET /teacher/b
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* 教学管理
* 教师管理


<a name="handlerequestusingpost"></a>
### handleRequest
```
POST /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusingget"></a>
### handleRequest
```
GET /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusingput"></a>
### handleRequest
```
PUT /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusingdelete"></a>
### handleRequest
```
DELETE /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusingpatch"></a>
### handleRequest
```
PATCH /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusinghead"></a>
### handleRequest
```
HEAD /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="handlerequestusingoptions"></a>
### handleRequest
```
OPTIONS /test
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* test-controller


<a name="indexusingpost_2"></a>
### index
```
POST /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusingget_2"></a>
### index
```
GET /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusingput_2"></a>
### index
```
PUT /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusingdelete_2"></a>
### index
```
DELETE /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusingpatch_2"></a>
### index
```
PATCH /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusinghead_2"></a>
### index
```
HEAD /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="indexusingoptions_2"></a>
### index
```
OPTIONS /user
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* user-controller


<a name="postusersusingpost"></a>
### 添加新用户
```
POST /users/
```


#### Description
根据user创建用户


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**user**  <br>*required*|user|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|object|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 用户信息接口


<a name="getuserlistusingget"></a>
### 获取用户列表
```
GET /users/
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|< [User](#user) > array|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/json;charset=UTF-8`


#### Tags

* 用户信息接口


<a name="getuserusingget"></a>
### 根据id查询用户的接口
```
GET /users/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|用户id|string|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[User](#user)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Produces

* `application/json;charset=UTF-8`


#### Tags

* 用户信息接口


<a name="putuserusingput"></a>
### 根据id修改用户信息的接口
```
PUT /users/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|
|**Body**|**user**  <br>*required*|user|[User](#user)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `\*/*`


#### Tags

* 用户信息接口


<a name="deleteuserusingdelete"></a>
### 根据id删除用户的接口
```
DELETE /users/{id}
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Path**|**id**  <br>*required*|id|integer (int64)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**204**|No Content|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|


#### Produces

* `\*/*`


#### Tags

* 用户信息接口



