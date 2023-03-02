---
title: reactQuery study
date: 2022-02-18 23:21:00 +0900
category: react
draft: false
---

# 2022-02-18-reactQuery-study

# 리액트 쿼리 왜쓰나?

- 서버에서 가져온 데이터 웹 브라우저 앱에서 사용하기 쉽게 도와줌

- 서버에서 가져온 데이터 서버 state
- 모든 어플리케이션 state 가지고 있음

![image-20230218232443937](../../assets/img/post/2022-02-18-reactQuery-study/image-20230218232443937.png)

## 클라이언트 state

- 클라이언트가 최초 발생지
- 서버가 최초 발생지

### external state

- 리덕스, 몹엑스, 저스탠드, 조타이, 리코일등등

### internal state

- Context api, useState

## 클라이언트가 자체적으로 만드는 state

- 대개 UI를 담당하는 부분으로 모다이 열리고 닫히는지
- 어떤 버튼이 클릭되었는지
- 지금 창이 리사이징 되고 있는지 여부등 메타 정보를 담은 상태값

## React query가 해결해주는 문제

- 간편한 server state 수급 방식
  - 실시간 데이터가 필요한 경우 더 좋은 경우로 사용됨
- 캐시
  - 몇초 이후에는 데이터가 유효하지 않은 거으로 간주하고 데이터를 다시 불러오
  - 데이터에 변경점이 있는 경우에만 리렌더링을 유발
  - 유저가 탭을 이동했다가 다시 돌아왔을때 데이터를 다시 불러옴
  - 데이터를 다시 호출할 때 응답이 오기 전까지 이전 데이터를 계속 보여줌
  - 필요에 따라서 로딩바와 같은 대안 UI를 보여주기 위해 loading state를 기본적으로 제공

## React query 사용법

```tsx
   useQuery("작명", ()=>{
      return axios.get("https://codingapple1.github.io/userdata.json").then((a)=>{
      return a.data
      })
   })

   let result = useQuery("작명", ()=>
      axios.get("https://codingapple1.github.io/userdata.json").then((a)=>{
      console.log("요청확인")
      return a.data
      })
   )
```

### 2초후 리패치

```tsx
   let result = useQuery("작명", ()=>
      axios.get("https://codingapple1.github.io/userdata.json").then((a)=>{
      console.log("요청확인")
      return a.data
      }),
      {staleTime:2000}
   )
```

## 사용 상태

```
result.data
result.isLoading
result.error
```

## 사용법

```tsx
// 로딩중
result.isLoading?"로딩중":<div>홈</div>
result.isLoading&&"로딩중"

//에러도 위와 같이 사용 가능

//실데이터 출력
result.data
```

## 참고자료

https://tanstack.com/query/v4/docs/react/overview

