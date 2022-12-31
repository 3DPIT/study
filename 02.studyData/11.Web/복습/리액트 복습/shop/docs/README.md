## 이미지 넣기 & public 폴더 이용

```js
<img src={process.env.PUBLIC_URL + 'img/logo.png'0}>
```

## import, export

### 1개 데이터인경우

```js
let data = [
  {
    id: 0,
    title: "White and Black",
    content: "Born in France",
    price: 120000,
  },

  {
    id: 1,
    title: "Red Knit",
    content: "Born in Seoul",
    price: 110000,
  },

  {
    id: 2,
    title: "Grey Yordan",
    content: "Born in the States",
    price: 130000,
  },
];
export default data;
```

### 2개이상인 경우

```js
let data = [
  {
    id: 0,
    title: "White and Black",
    content: "Born in France",
    price: 120000,
  },

  {
    id: 1,
    title: "Red Knit",
    content: "Born in Seoul",
    price: 110000,
  },

  {
    id: 2,
    title: "Grey Yordan",
    content: "Born in the States",
    price: 130000,
  },
];
let data1 = [
  {
    id: 0,
    title: "White and Black",
    content: "Born in France",
    price: 120000,
  },

  {
    id: 1,
    title: "Red Knit",
    content: "Born in Seoul",
    price: 110000,
  },

  {
    id: 2,
    title: "Grey Yordan",
    content: "Born in the States",
    price: 130000,
  },
];
export { data, data1 };
```

## map 사용 function

```js
//1번방식
[1, 2, 3].map(function () {});
//2번방식
[(1, 2, 3)].map(() => {});
```

## 라우터 사용 설치

```sh
npm install react-router-dom@6

// index.js
import { BrowserRouter } from 'react-router-dom';

<BrowserRouter>
</BrowserRouter>
```

## 라우터 사용

```js
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";

<Routes>
  <Route
    path="/"
    element={
      <>
        <div className="main-bg"></div>
        </div>
      </>
    }
  />
  <Route path="/detail" element={<Detail></Detail>} />
</Routes>;
```

## Link사용

```js
<Link to="/detail">상세페이지</Link>
```

- 좀 꼴뵈기 싫음

- 비교

  ```js
  //Link 사용시
  <Nav.Link>
    <Link to="/">홈</Link>
  </Nav.Link>

  //navigate 사용시
    <Nav.Link
    onClick={() => {
      navigate("./detail");
    }}
  >Detail</Nav.Link>

  //뒤로가기 앞으로가기 구현
  navigate(-1); //뒤로 가기
  navigate(1); //앞으로 가기
  ```

- 404 페이지

```js
<Route path="*" element={<div>없는 페이지임</div>} />
```

## Nested Routes

- about 페이지

```js
<Route path="/about" element={<About></About>}>
  <Route path="member" element={<div>멤버</div>} />
  <Route path="location" element={<div>위치</div>} />
</Route>;

//About 페이지에 구멍 뚫어놔야 보임
function About() {
  return (
    <div>
      ABOUT 페이지
      <Outlet></Outlet>
    </div>
  );
}
```

## 상품 100개 있는경우

```js
- url 파라미터 이용
  <Route path="/detail/:id" element={<div>멤버</div>} />
```

## find 쓰는 방식

```js
//function
const findProduct = shoes.find(function (x) {
  return x.id == id;
});

// () =>
const findProduct = shoes.find((x) => x.id == id);
```

## styled-components

```js
npm install styled-components

import styled from 'styled-components';

//간단한 노란 버튼 만들기
const YellowButton = styled.button`
  background: yellow;
  color: black;
  padding: 10px;
`;

//사용
<YellowButton/>

//검정 박스 만들기
const BlackBox = styled.div`
  background:black;
  padding: 10px;
`

//사용
<BlackBox></BlackBox>
```

- 장점 오염이 안됨
- 근데 다른것은 그렇다면 오염이 된다는 것인가
  - 빌드시 축약하기 때문에 오염이된다.
    - 오염을 막기위한 방법
    - App.css => App.module.css 로 작명하면됨

## props로 컴포넘츠 재활용하기

```js
const YellowButton = styled.button`
  background: ${(props) => props.bg};
  color: black;
  padding: 10px;
`;

<YellowButton bg="blue" />;

const ColorButton = styled.button`
  background: ${({ color }) => color};
  color: black;
  padding: 10px;
`;

<ColorButton color={"blue"}></ColorButton>;
```

- 조건 별로 색상 변경 가능

```js
const ColorButton = styled.button`
  background: ${({ color }) => color};
  color: ${({ color }) => (color === "blue" ? "white" : "black")};
  padding: 10px;
`;

<ColorButton color={"blue"}>123123</ColorButton>;
```

- 기존 스타일 복사

```js
const NewBtn = styled.button(ColorButton);

//가공도 가능
const NewBtn = styled.button(ColorButton)`

`;
```

## 컴포넌트 Lifecycle

- mount
  - 페이지 장착
- update
  - 업데이트
- unmount
  - 제거

### 예전 클래스 방식

```js
class Detail2 extends React.Component {
  componentDidMount() {}
  componentDidUpdate() {}
  componentDidMount() {}
}
```

## 요즘 스타일

```js
useEffect(() => {
  console.log("안녕");
});
```

- 그냥 밖에다 console.log하는것도 비슷한데 왜 쓸까?
- 렌더링 후에 동작한다.
  - 복잡한 연산을 해야한다고 했을때 그냥 쓰면 그것먼저하고 랜더링이 됨
  - useEffect를 사용하면 페이지먼저 나오고 연산을 하니까 좀더 효율적으로 동작함

## 초사용하는 법

```js
setTimeout(()=>{실행할 코드},1000)
```

## useEffect

```js
// 한번만
function Detail({ shoes }) {
  useEffect(() => {
    setTimeout(() => {setHidden(1) }, 2000);
  },[]);

//count 동작시
function Detail({ shoes }) {
  useEffect(() => {
    setTimeout(() => {setHidden(1) }, 2000);
  },[count]);

// 리턴 useEffect 동작 전에 실행되는것
function Detail({ shoes }) {
  useEffect(() => {
    setTimeout(() => {setHidden(1) }, 2000)
    return ()=>{
      //코드
    }
  },[]);
```

- 위의 return은 clean up function이라고함
- 타이머 같은 것도 만든것 재랜더링 될때 100 - 1000개 될 수 있는데
  - 기존 타이머 제거해주라고 하면 더 효율적으로 됨
    ```js
    function Detail({ shoes }) {
    useEffect(() => {
    const timer = setTimeout(() => {setHidden(1) }, 2000)
    return ()=>{
      //코드
      clearTimeout(timer);
    }
    },[]);
    ```
- clean up function의 경우
  - mount시 실행안됨
  - unmount시 실행됨

## useEffect 정리

```js
// 1.재렌더링마다 코드 실행하고 싶은경우
useEffect(() => {});
// 2.mount시 1회 코드 시행하고 싶은 경우
useEffect(() => {}, []);
// 3.unmount 1회 코드 실행하고 싶은 경우
useEffect(() => {
  return () => {};
}, []);
// 4.useEffect 실행전에 뭔가 실행 하고 싶은 경우 clean up 하고 싶은때
return () => {}; // 이곳에 넣으면됨
// 5.특정 state 변경시에만 실행하려면 [state명]
useEffect(() => {}, [count]);
```
