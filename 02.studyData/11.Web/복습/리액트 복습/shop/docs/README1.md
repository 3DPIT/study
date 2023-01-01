## localStorage 사용해보기

```js
// 생성
localStorage.setItem("age", "20");

// 조회
localStorage.getItem("age");

// 삭제
localStorage.removeItem("age");
```

- 수정 하는법?

  - 수정하는것 없고, 빼서 수정해서 다시 넣어야함
  - localStorage 대신 sessionStorage 붙이면 세션에 저장된 이것은 휘발성임

## array/object 저장하는법

- json으로 바꾸면됨

```js
const obj = { name: "park" };

localStorage.setItem("date", JSON.stringify(obj));

const output = localStorage.getItem("data");
console.log(JSON.parse(outpur));
```

- obj 는 저장이 안되서 JSON.stringify()를 이용해서 JSON으로 바꿔서 저장
- 다시 그것을 쓰려면 그자체로는 문자열이라서 이를또 변환해줘야함 JSON.parse()이용하면 된다.

## state 저장 localStorage

- redux-persist 쓰면
  - 자동으로 저장됨
- Jotai
- Zustand 도 리덕스랑 비슷함
