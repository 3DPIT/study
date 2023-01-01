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

## ajax 사용하기

### 설치

```js
npm install axios

import axios from "axios";

//여러 상태까지 나옴
axios.get('https://codingapple1.github.io/shop/data2.json ')
.then((data)=>{
  console.log(data);
})

//현재 원하는 값이 나옴
axios.get('https://codingapple1.github.io/shop/data2.json ')
.then((data)=>{
  console.log(data.data);
})

//실패시
axios
  .get("https://codingapple1.github.io/shop/data2.json ")
  .then((data) => {
    console.log(data.data);
  })
  .catch(()=>{
    console.log("실패함")
  });

// 서버에 데이터 전송하는 POST 요청
axios.post('/asdf',{name:park})

//여러개에 한번에 하고 싶은 경우 두개다 성공한 경우만
Promis.all([axios.get('/url1),axios.get('/url1)])
.then(()=>{

})

//서버에서는 array, object도  따옴표 쓰면 가능
//fetch()를 쓰면 아래와 같이 변환이 필요, axios는 알아서 변환해줌
fetch('url')
.then(결과 => 결과.json())
.then(data=>{})
```

## tab UI 만들기

```js

      <Nav variant="tabs" defaultActiveKey="link0">
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(0);
            }}
            eventKey="link0"
          >
            버튼0
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(1);
            }}
            eventKey="link1"
          >
            버튼1
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(2);
            }}
            eventKey="link2"
          >
            버튼2
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <TabContent tab={tab}> </TabContent>

function TabContent({ tab }) {
// 삼항연산자로 하기
  return tab === 0 ? (
    <div>내용0</div>
  ) : tab == 1 ? (
    <div>내용1</div>
  ) : (
    <div>내용2</div>
  );

// if elseif else
  if (tab === 0) {
    return <div>내용0</div>;
  } else if (tab === 1) {
    return <div>내용1</div>;
  } else {
    return <div>내용2</div>;
  }

// 배열로 하기
  return [<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab];
}
}
```

- if else 이런거 쓰려면 컴포넌트 같이 만들엇 사용하면됨

## 애니메이션 넣기

- 1.애니메이션 동작 전 className 만들기
- 2.애니메이션 동작 후 className 만들기
- 3.className에 transition 속성 추가
- 4.원할 때 2번 className 부착

### useEffect로 css 넣기

```js
// 일반적인 방법
const [fade, setFade] = useState("");
useEffect(() => {}, [tab]);
return (
  <div className={"strat " + fade}>
    {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab]}
  </div>
);

// `` 을 이용한 방법
const [fade, setFade] = useState("");
useEffect(() => {}, [tab]);
return (
  <div className={`strat ${fade}`}>
    {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab]}
  </div>
);

// 실제 사용법
function TabContent({ tab }) {
  const [fade, setFade] = useState("");

  useEffect(() => {
    setTimeout(() => {
      setFade("end");
    }, 100);
    return () => {
      setFade("");
    };
  }, [tab]);

  return (
    <div className={`start ${fade}`}>
      {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab]}
    </div>
  );
}
```

## automatic bathing 기능

- 리액트 18버전 이후 나온것
  - 주변에 있는 state중 마지막 하나만 재렌더링해서 좀 지연해주거나 다른 방법을 써야함
  - 시간차를 둬서 실행해주면 좋음

# state 전체 공유 하기

## Context API 사용해보기

```js
/*
App{
  Detail{
    TabContent{

    }
  }
}
이런 경우라면 ? 어떻게 App에 있는 State를 공유할까?
*/

//app.js

import React, { createContext, useState } from "react";

export const ContextAPI = createContext();

<ContextAPI.Provider value={{재고, shoes}}>
<Detail/>
<ContextAPI.Provider>

//Detail.js
import React, { useContext, useState } from "react";
import {ContextAPI} from './../App.js';

const {재고} = useContext(ContextAPI);// 분해시키는 것

```

- 성능 이슈와 컴포넌트 재활용이 어려운 단점이 있어서 잘 안쓰긴함
- 저렇게 하면 아무곳에서도 가져다 쓸수 있음
- Context API 특징
  - 1.state 변경시 -> 쓸데없는 것까지 재 렌더링함
  - 2.Detail.js에 useContext로 분리하는 것에서 다른곳에서쓰면 없는 것이라고 나오니까 컴포넌트 재사용이 어려움

## 리덕스 설치

```sh
npm install @reduxjs/toolkit react-redux


// store.js
import {configureStore} from '@reduxjs/toolkit'

export default configureStore({
    reducer:{

    }
})

// index.js 파일에
import { Provider } from "react-redux";
import store from './redux/store.js'

<Provider store={store}> //쓰면 되는데

// 이렇게 해주기

    <Provider store={store}>
    <BrowserRouter>
      <App />
    </BrowserRouter>
    </Provider>
```

### 리덕스 쓰는 이유

- 컴포넌트간 state 공유 편해짐
  - props 안써도 되는 점 이 있음

#### 사용해보기

```js
import { createSlice, configureStore } from "@reduxjs/toolkit";

const user = createSlice({
  name: "user",
  initialState: "park",
});

export default configureStore({
  reducer: {
    user: user.reducer,
  },
});
```

- 이렇게 하면 state 만들고 등록한것

- 원하는 곳에 사용하기

  ```js
  import { useSelector } from "react-redux";

  const { user } = useSelector((state) => {
    return state;
  });
  ```

### 응용사용

```js
const a = useSelector((state) => {
  return state.user;
});
// 여러개 있다면 한개만 가져오고 싶은 경우

//구조분해할당 하는법
const { user, stock } = useSelector((state) => {
  return state;
});

//리턴 생략 하기
useSelector((state) => state.user);
```

## 리덕스 state 변경하기

- 1.state 수정해주는 함수 만들기

  ```js
  reducers:{
    changeName(){
      return 'john park'
    }
  }

    reducers:{
    changeName(state){
      return 'john '+ state
    }
  }
  ```

- 2.export 하기
  ```js
  export const { changeName } = user.actions;
  ```
- 3.만든 함수 import 해서 쓰기

  ```js
  import { changeName } from "./../redux/store.js";
  import { useDispatch } from "react-redux";

  const dispatch = useDispatch(); // store.js에서 요청 보내주는 함수

  onClick={()=>{
    dispatch(changeName())
  }}
  ```

## 리덕스 state 변경하기

```js
const user = createSlice({
  name: "user",
  initialState: { name: "park", age: 20 },
  reducers: {
    changeName(state) {
      return { name: "kim", age: 20 };
    },
  },
});
```

- 저렇게 return 해서 수정해도 되지만
- array/object의 경우는 직접 수정해도 됨

  ```js
  const user = createSlice({
    name: "user",
    initialState: { name: "park", age: 20 },
    reducers: {
      changeName(state) {
        state.naem = "park";
      },
    },
  });
  ```

- 함수 파라미터 문법 사용해보기

  ```js
  const user = createSlice({
    name: "user",
    initialState: { name: "park", age: 20 },
    reducers: {
      changeName(state) {
        return { name: "kim", age: 20 };
      },
      addAge(state, action) {
        state.age += action.payload;
      },
    },
  });

  // 사용법
  dispatch(addAge(10));
  ```

## 리덕스 파일 분할하기

- user를 분리해보면

  - userSlice.js 만들고

    ```js
    import { createSlice } from "@reduxjs/toolkit";
    const user = createSlice({
      name: "user",
      initialState: { name: "park", age: 20 },
      reducers: {
        changeName(state) {
          return { name: "kim", age: 20 };
        },
        addAge(state, action) {
          state.age += action.payload;
        },
      },
    });
    export const { changeName, addAge } = user.actions;
    export default user;

    //기존 store.js에서 import
    import { user } from "./store/userSlice.js";
    ```
