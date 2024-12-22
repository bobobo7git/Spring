# REST API
## Annotations / Class
![img](https://github.com/user-attachments/assets/8d78ff92-68b4-4798-bb2c-424dcf58f2ea)

### `@ResponseBody`
- Controller 메서드가 HTTP 응답의 본문(Body)을 직접 반환함을 나타내는 Annotation
- 기존의 `@Controller`는 뷰 리졸버를 통해 `View`를 찾지만 데이터를 반환하기 위해서는 `@ResponseBody` Annotation을 사용해야 함
- Spring은 반환된 객체를 `JSON`, `XML`등의 형식으로 변환하여 HTTP 응답 본문으로 클라이언트에게 전송

```java
@Controller
public class RestController {
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello";
	}
}
```
- 문자열이 HTTP 본문에 담긴다.

```java
public class RestController {
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, String> test2 () {
		Map<String, String> data = new HashMap<>();
		data.put("id", "id");
		data.put("pw", "1234");
		return data;
	}
}
```
- `json` 형식으로 응답이 반환된다.

#### Jaskon Databind
> Jakson 라이브러리의 일부  
> Java 객체와 Json 데이터간의 변환을 담당한다.
- 별도 Annotation 없이 자동으로 java 객체와 json 데이터를 매핑할 수 있다.
- json 외에도 다양한 데이터 변환을 지원한다.
- 라이브러리를 별도로 추가하지 않아도 Spring Boot에서 알아서 추가해준다.

```java
public class RestController {
	@GetMapping("/test3")
	@ResponseBody
	public User test3 () {
		User user = new User("id", "pw", "username");
		return user;
	}
}
```
- `user`객체가 json 형식으로 반환된다.

```java
public class RestController {
	@GetMapping("/test4")
	@ResponseBody
	public List<User> test4 () {
		List<User> list = new ArrayList<>();
		list.add(new User("id1", "pw1", "username1"));
		list.add(new User("id2", "pw2", "username2"));
		list.add(new User("id3", "pw3", "username3"));
		return list;
	}
}
```
- `user`객체가 여러개 담긴 형식으로 반환된다.

### `@RestController`
- Spring MVC에서 RESTful 서비스를 개발할 때 주로 사용한다.
- 해당 어노테이션을 사용하면 모든 메서드가 `@ResponseBody`를 포함하게 된다.
- 따라서 반환객체가 HTTP 응답 본문에 작성되며, JSON 또는 XML등의 형태로 전송 가능
- `@Controller` + `@ResponseBody`
```java
@RestController
public class RestController {
	@GetMapping("/test1")
	// @ResponseBody
	public String test1 () {

	}
}
```

### `@RequestMapping`
- `RequestMapping`에 들어있는 주소는 모두 이 어노테이션이 적힌 컨트롤러로 매핑된다.
```java
@RestController
@RequestMapping("/rest")
public class RestController {

}
```

### `@PathVariable`
- `URI`의 일부를 변수로 가져와 메서드의 매개변수로 전달할 때 사용한다.
- `RESTful` 웹서비스에서 경로 변수를 처리하는 데 사용

```java
@RestController
@RequestMapping("/rest")
public class RestController {
	@GetMapping("/board/{id}")
	public String board(@PathVariable("id") int id) {
		return id + "번 board";
	}
}
```

### `@RequestBody`
- HTTP 요청 본문에 포함되어있는 데이터를 Java 객체로 변환할 때 사용
- RESTful 웹 서비스에서 클라이언트가 전송한 데이터를 서버에서 받아서 처리하는 데 사용
- `form-data`로 요청 : `@ModelAttribute`
- `JSON`으로 요청 : `@RequestBody`

```java
@RestController
@RequestMapping("/rest")
public class RestController {
	@PostMapping("/board")
	public String create(@ModelAttribute User user) {
		return user.toString();
	}
}
```
- `form-data`형식으로 요청이 보내왔을 때

```java
@RestController
@RequestMapping("/rest")
public class RestController {
	@PostMapping("/board")
	public String createByJson(@RequestBody User user) {
		return user.toString();
	}
}
```
- `JSON`으로 요청이 보내왔을 때

### `@ResponseEntity`
> HTTP 응답을 나타내는 클래스
- 상태코드 지정, 헤더 추가, 본문 설정 가능