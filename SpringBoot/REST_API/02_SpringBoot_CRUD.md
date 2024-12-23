# CRUD
> Spring Boot REST API CRUD

## READ
### 게시글 전체 조회
```java
@RestController
public class BoardController {
	// Service 의존성 주입
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/board")
	// public ResponseEntity<?> list() {
	// 와일드카드 ?로 제네릭을 지정하지 않을 수 있다.
	public ResponseEntity<List<Board>> list() {
		List<Board> list = boardService.getBoardList();
		// 반환하는 방법 1
		return new ResponseEntity<>(list, HttpStatus.OK);
	} 
}
```

### 게시글 상세 조회
```java
@RestController
public class BoardController {
	// ...

	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id")int id) {
		Board board = boardService.getBoard(id);
		// 반환하는 방법 2
		return ResponseEntity.ok(board);
	} 
}
```
- 이렇게만 하면 게시글을 찾을 수 없을 때도 `200 OK`로 응답한다.

```java
@RestController
public class BoardController {
	// ...

	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id")int id) {
		Board board = boardService.getBoard(id);
		if (board != null) return ResponseEntity.ok(board);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	} 
}
```

## CREATE
```java
@RestController
public class BoardController {
	// ...
	// form-data로 요청
	@PostMapping("/board")
	public ResponseEntity<Board> create(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		// writeBoard: void
		return new ResponseEntity<Board>(board, HttpStatus.CREATED); 
	} 
}
```
- 이렇게 하면, 입력하지 않은 데이터(`id`)는 응답할 수 없다.
- `Mapper`에서 `keyProperty`, `useGeneratedKeys`를 지정하면 생성된 레코드의 `id`를 반환할 수 있다.
```xml
  <insert id="insertCoverLetter" parameterType="CoverLetter" keyProperty="coverId" useGeneratedKeys="true">
  	INSERT INTO cover_letter (apply_id, user_id, category, cover_title, cover_content)
  	VALUES (#{applyId}, #{userId}, #{category}, #{coverTitle}, #{coverContent});
  </insert>
```
![img](https://github.com/user-attachments/assets/742a6a9f-c893-4029-a59d-bd74ab6e79bb)

- `DB`관련은 `snake_case`, `JSON`입력, `DTO`는 `pascalCase`

## DELETE
`DAO` 인터페이스에서 반환타입을 `int`로 지정하면 테이블에서 건드리는 레코드의 개수가 리턴된다.
- `id`는 고유한 값이므로 0 또는 1만 리턴된다.
```java
public int deleteBoard(int id);
```
- `void`를 `int`로 수정한다.
`Service`, 서비스 구현체 `ServiceImpl`에서는 `boolean`로 바꿔주고 이 값에 따라 리턴한다.  

```java
public interface BoardService {
	public boolean removeBoard(int id);
}
```
```java
@Service
public BoardServiceImpl implements BoardService {
	//...
	@Transactional
	@Override
	public boolean removeBoard(int id) {
		int result = boardDao.deleteBoard(id);
		return result == 1;
	}
	//...
}
```

이제 컨트롤러로 돌아오면,
```java
@RestController
public class BoardController {
	// ...
	@DeleteMapping("/board/{id}")
	public String delete(@PathVariable("id")int id) {
		boolean isDeleted = boardService.removeBoard(id);
		if (isDeleted) return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	} 
}
```

## UPDATE
#### 잘못된 코드
```java
@RestController
public class BoardController {
	// ...
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id")int id) {
		// board.setId(id); // board id를 모른다면
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
	} 
}
```
- 이렇게 하면 입력하지 않은 데이터가 `null`로 수정된다.
	- 프론트에서 모든 데이터를 입력하도록 강제한다면 문제없다.
