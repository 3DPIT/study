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

## ajax 성공시/ 실패시 html 보여주려면?

- 몇초마다 자동으로 ajax 요청?
- 실패시 몇초 후 요청 재시도?
- prefetch?

  - React Query 쓰면됨

- React Query 설치

```sh
npm install react-query

//index.js

import { QueryClient, QueryClientProvider } from "react-query";

const queryClient= new QueryClient();


<QueryClientProvider client={queryClient}>
<App/>
</QueryClientProvider>
```

- useQuery사용

  ```js
  let result = useQuery("작명", () =>
    axios.get("https://codingapple1.github.io/userdata.json").then((a) => {
      return a.data;
    })
  );

  console.log(result.data); //성공시 데이터 나옴
  console.log(result.isLoading); // 로딩중일때 true
  console.log(result.error); //에러 발생시 true
  ```

  - 장점1

  ```js
  {
    result.isLoading && "로딩중";
  }
  {
    result.error && "에러남";
  }
  {
    result.data && result.data.name;
  }
  ```

  - 장점2 틈만 나면 재요청함 refetch함

  ```js
  let result = useQuery(
    "작명",
    () =>
      axios.get("https://codingapple1.github.io/userdata.json").then((a) => {
        return a.data;
      }),
    { staleTime: 2000 }
  );
  ```

- 2초마다 데이터 받아옴
- 3.실패시 retry해줌
- 4.state 공유 안해도 됨
  - 요청 같은것 해도 알아서 한번만 해도
- 5.ajax 결과 캐싱

  - 이전에 했던거 유지 해줌

  ## RTK Query

  -

RTK Query는 실은 다른 용도로도 많이 쓰는데

ajax 요청후 Redux state 변경을 하고 싶다면...

원래 Redux state변경함수 안에선 ajax요청하면 안되어서 컴포넌트 안에서 해야합니다.

근데 ajax 요청하는 코드가 다양하고 많으면 컴포넌트 안의 코드가 길어지고 관리도 귀찮은데

그런걸 Slice 안에서 관리가능하게 도와줍니다.

그리고 ajax 요청하는 코드가 100만개 있으면 그걸 편리하게 관리할 수 있게 도와줍니다.

근데 코드가 약간 더러울 뿐
