---
title: core JS this
date: 2022-01-09 21:27:00 +09:00
category: JS
draft: false
---

## 2022-01-09-core-JS-this

## 01.JS의 this

- 자바스크립트에서는 this 어디서든 사용 가능
- 상황에 따라서 바라보는 대상이 달라짐
- 함수와 객체(메서드)의 구분이 느슨한 자바스크립트에서 this는 실질적으로 이 둘을 구분하는 거의 유일한 기능

## 02.상황에 따라 달라지는 this

- JS에서 this는 기본적으로 실행 컨텍스트가 생성될 때 함께 결정
  - 실행 컨텍스트는 함수 호출할 때 생성
    - 즉, 바꿔말하면 this는 `함수를 호출할 때 결정된다.`
      - 함수를 어떤 방식으로 호출하느냐에 따라 값이 달라지는 것

## 03.전역 공간에서 this

- 전역 공간에서 this는 전역 객체를 가리킴
  - 개념상 전역 컨텍스트를 생성하는 주체가 바로 전역 객체이기 때문
- 브라우저 환경에서는 window
- Node.js환경에서는 global

#### 예제 03-1 브라우저 환경

```js
console.log(this);
console.log(windows);
donsole.log(this === window); //true
```

#### 예제 03-2 Node.js환경

```js
console.log(this);
console.log(global);
console.log(this === global); //true
```

#### this 전역 공간에서만 발생하는 특이한 성질

- 전역 변수를 선언하면 JS 엔진은 이를 전역객체의 프로퍼티로도 할당
  - 즉, 변수이면서 객체의 프로퍼티

#### 예제 03-3 전역변수와 전역객체(1)

```js
var a = 1; 
console.log(a); //1
console.log(window.a); //1
console.log(this.a); //1
```

- 전역 공간의 변수 a에 1을 할당 했는데 
  - window.a와 this.a 모두 1이 출력
    - JS의 모든 변수는 실은 특정 객체의 프로퍼티로서 동작하기 떄문에 같은 값을 가짐
      - 특정 객체란 실행컨텍스트의 LexicalEnvironment
    - 실행컨텍스트는 변수를 수집해서 L.E프로퍼티로 저장
      - 이후 어떤 변수를 호출하면 L.E를 조회해서 일치하는 프로퍼티가 있을 경우 그 값을 반환
  - 전역 컨텍스트의 경우 L.E는 전역객체를 그대로 참조

- **전역변수를 선언하면 JS엔진은 이를 전역 객체의 프로퍼티로 할당이 올바른 말**
  - a를 직접 호출할 때도 1이 나오는 이유는
    - 변수 a에 접근하고자 하면 스코프 체인에서 a검색하다가
      - 가장 마지막에 도달하는 전역 스코프의 L.E, 즉 전역 객체에서 해당 프로퍼티 a를 발견해서 그값을 반환하기 때문
      - 원리는 위와 같지만 사실 window. 이 생략된것이라고 생각하면됨

- 차이점이 나오는 곳

#### 예제 03-5 전역변수와 전역객체(3)

````js
var a =1;
delete window.a; //false
console.log(a, window.a, this.a);

var b =2;
delete window.b; //false
console.log(b, window.b, this.b);

window.c = 3;
delete window.c //true
console.log(c, window.c, this.c);//uncaught refer...

window.d = 4;
delete window.d // true
console.log(d, window.d ,this.d);//uncaught refer...
````

- 위를 보면 전역 객체의 프로퍼티로 할당한 경우 삭제가 되지만
- 전역변수로 선언한 경우 삭제가 되지 않음
  - 사용자가 의도치 않게 삭제하는 것을 방지하는 차원의 방어 전략이라고 생각하자.
  - 즉, 전역변수를 선언하면 자바스크립트 엔지이 이를 자동으로 전연객체의 프로퍼티로 할당하면서
    - 추가적으로 해당 프로퍼티의 configurable속성을 false로 정의하는 것
- 정리하자면 var로 선언한 전역변수와 전역객체의 프로퍼티는 호이스팅 여부 및 configurable여부에서 차를 보임

