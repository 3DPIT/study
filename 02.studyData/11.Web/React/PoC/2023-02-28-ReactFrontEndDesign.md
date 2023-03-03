---
title: ReactFront Design
date: 2023-02-28 05:43:00 +0900
category: react
---

# 확정

## Feature 아키텍처 개요

```sh
src/
├── features/
│   ├── [FeatureName]/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── utils/
│   │   ├── hooks/
│   │   ├── types/
│   │   ├── constants/
│   │   ├── [FeatureName].tsx
│   │   ├── [FeatureName].spec.tsx
│   │   └── styles.ts
│   ├── [OtherFeature]/
│   └── ...
├── shared/
│   ├── components/
│   ├── utils/
│   ├── hooks/
│   ├── types/
│   ├── constants/
│   ├── App.tsx
│   ├── index.tsx
│   └── ...
└── ...


각 폴더와 파일에 대한 역할은 다음과 같습니다.

src/features/: 기능(feature)별로 폴더를 만듭니다. 예를 들어 User 기능이 있다면 src/features/User/ 폴더를 만듭니다.
components/: 해당 기능에서 사용하는 컴포넌트를 모아둡니다. 이 폴더 안에서도 atoms/, molecules/, organisms/와 같이 컴포넌트 유형에 따라 세분화할 수 있습니다.
pages/: 해당 기능에서 사용하는 페이지 컴포넌트를 모아둡니다.
utils/: 해당 기능에서 사용하는 유틸리티 함수나 헬퍼 함수 등을 모아둡니다.
hooks/: 해당 기능에서 사용하는 커스텀 훅을 모아둡니다.
types/: 해당 기능에서 사용하는 타입 정의 파일을 모아둡니다.
constants/: 해당 기능에서 사용하는 상수를 모아둡니다.
[FeatureName].tsx: 해당 기능을 구현한 메인 컴포넌트입니다.
[FeatureName].spec.tsx: 해당 기능의 테스트 파일입니다.
styles.ts: 해당 기능에서 사용하는 스타일 파일입니다.
위와 같은 폴더 구조를 사용하면 기능(feature)을 중심으로 모듈화하여 개발할 수 있어 유지보수와 확장성이 좋아집니다.
```

## 생각한 Feature 디자인 구조

```
src/
├── features/
│   ├── [FeatureName]/
│   │   ├── components/ #해당 기능에서 사용하는 컴포넌트를 모아둡니다.
│   │   ├── utils/ #해당 기능에서 사용하는 유틸리티 함수나 헬퍼 함수 등을 모아둡니다.
│   │   ├── hooks/ #해당 기능에서 사용하는 커스텀 훅을 모아둡니다.
│   │   ├── types/ #해당 기능에서 사용하는 타입 정의 파일을 모아둡니다.
│   │   ├── [FeatureName].tsx #해당 기능을 구현한 메인 컴포넌트입니다.
│   │   ├── [FeatureName].stories.tsx #해당 기능을 구현한 스토리보드 코드
│   │   ├── [FeatureName].spec.tsx # 해당 기능의 테스트 파일입니다.
│   │   └── styles.ts #해당 기능에서 사용하는 스타일 파일입니다.
│   ├── [OtherFeature]/
│   └── ...
├── shared/
│   ├── components/
|   |   ├── atoms/
|   |   ├── molecules/
│   ├── utils/
│   ├── hooks/
│   ├── types/
│   ├── constants/
├── App.tsx
├── index.tsx
│
└── ...
```

- shared
  - components의 경우 공동으로 쓰는 경우 이기 때문에 
  - 비즈니스 요소가 없는 atoms와 molecules요소를 저장
- feature
  - components의 경우 비즈니스가 들어가는 경우 이기 때문에
  - 비즈니스 요소가 있는 organisms 요소를 저장
  - types
    - 이것의 [FeatureName].tsx에 types을 쓰는 경우 코드의 길이가 길어 질 수 있으니 이곳에 관리하는 것을 원칙으로 한다.
    - constants등 역시 최대한 분리하는 쪽으로 개발하기

# 조사 목록

## 아키텍쳐

```
Atomic Design
Atomic Design은 웹 사이트나 어플리케이션의 디자인을 재사용 가능한 독립적인 구성 요소로 분해하는 디자인 패턴입니다. Atomic Design은 디자인을 분해하고 이를 구성하는 작은 구성 요소를 설명하는 아토믹 디자인 시스템을 구축하는 방식으로 작동합니다.

Component-Driven Design
Component-Driven Design은 Atomic Design과 비슷한 개념이지만, Atomic Design과는 달리 컴포넌트를 기반으로 하며, 컴포넌트의 재사용성과 가독성을 강조합니다. 이 방법은 React와 같은 컴포넌트 중심의 프레임워크에서 더욱 효과적입니다.

Material Design
Material Design은 Google에서 만든 디자인 시스템으로, 머터리얼 디자인이라고도 합니다. 머터리얼 디자인은 재사용 가능한 디자인 패턴, 컴포넌트 및 가이드라인을 제공하여 일관성 있는 디자인을 제공합니다.

Fluent Design
Fluent Design은 마이크로소프트에서 만든 디자인 시스템으로, 마이크로소프트의 제품군에서 사용되는 통일된 디자인 시스템입니다. Fluent Design은 애니메이션과 이펙트를 중심으로 한 사용자 경험을 제공합니다.

위의 디자인 구조는 대표적인 방법이며, 프로젝트의 특성에 따라 다양한 디자인 구조를 선택할 수 있습니다. 선택한 디자인 구조를 프로젝트 전반에 걸쳐 일관성 있게 적용하여 개발의 생산성을 높이는 것이 중요합니다.
```

- CDD

  ```
  Component-Driven Design(CDD)은 UI를 구축하는 방식 중 하나로, 컴포넌트를 기반으로 UI를 설계하고 개발하는 방법론입니다.
  
  CDD는 UI의 레이아웃, 기능, 상태 등을 작은 단위의 컴포넌트로 분해하고, 이를 다시 조합하여 큰 단위의 컴포넌트를 만들어나가는 방식으로 UI를 구성합니다. 이를 통해 재사용성과 유지보수성을 높일 수 있습니다.
  
  또한 CDD는 컴포넌트를 중심으로 한 UI 설계를 지향하기 때문에, 개발자와 디자이너 간의 협업을 용이하게 만들어줍니다. 디자이너는 컴포넌트 라이브러리를 활용하여 UI 요소를 디자인하고, 개발자는 이를 바탕으로 실제 UI를 개발합니다.
  
  CDD를 활용하기 위해서는, 먼저 컴포넌트의 특성과 역할을 파악하고, 이를 기반으로 컴포넌트를 재사용 가능하게 만드는 작업이 필요합니다. 또한 스토리북과 같은 툴을 활용하여 컴포넌트를 미리 시각화하고 테스트하는 것이 좋습니다.
  
  요약하면, CDD는 UI 설계를 컴포넌트 중심으로 하는 방법론으로, 재사용성과 유지보수성을 높이고 개발자와 디자이너 간의 협업을 용이하게 만들어줍니다. 이를 위해서는 컴포넌트의 특성과 역할을 파악하고, 재사용 가능하게 만드는 작업이 필요합니다.
  ```

## Feature 디자인으로 구성

```
- features/
  - feature1/
    - components/
      - Component1.tsx
      - Component2.tsx
      - ...
    - services/
      - Service1.ts
      - Service2.ts
      - ...
    - routes/
      - Route1.tsx
      - Route2.tsx
      - ...
    - index.ts
    - types.ts
  - feature2/
    - ...
```

```
Feature Design 패턴은 기능(Feature)별로 구성된 폴더 구조로, 해당 기능에 필요한 컴포넌트, 스타일, 페이지, 유틸리티 등이 모두 포함되어 있습니다. 각 폴더는 독립적인 공간으로서 개별적인 상태(state), 기능(functionality), 유틸리티(utility) 등을 가지고 있으며, 이들을 조합하여 전체 애플리케이션을 구성합니다.

아래는 Feature Design 패턴의 폴더 구조와 간단한 예제입니다.
```

- 사용자 인증을 만드는 경우

  ```
  - features/
    - auth/
      - components/
        - LoginForm.tsx
        - SignupForm.tsx
        - ...
      - services/
        - AuthService.ts
        - ...
      - routes/
        - LoginRoute.tsx
        - SignupRoute.tsx
        - ...
      - index.ts
      - types.ts
  
  ```

  ```
  이 구조에서는 LoginForm, SignupForm 등의 컴포넌트, AuthService 등의 서비스, LoginRoute, SignupRoute 등의 라우터 등이 정의됩니다. types.ts 파일에서는 각각의 컴포넌트, 서비스, 라우터 등에 대한 인터페이스, 타입 등이 정의됩니다.
  
  이와 같은 Feature 디자인 패턴은 코드 유지보수성과 확장성을 높일 수 있어, 큰 규모의 소프트웨어를 개발할 때 유용합니다.
  ```

  ```
  Feature Design에는 Features, Components, Utils, Tests 폴더 구조 외에도, Pages와 Services 등의 폴더 구조가 추가로 사용되기도 합니다.
  
  Features 폴더는 기능별로 구현된 코드를 모아둔 폴더입니다. Components 폴더는 Features 폴더에서 사용되는 컴포넌트들을 모아둔 폴더입니다. Utils 폴더는 헬퍼 함수나 유틸리티 함수들을 모아둔 폴더입니다. Tests 폴더는 컴포넌트나 기능 등에 대한 테스트 코드를 모아둔 폴더입니다.
  
  Pages 폴더는 실제 페이지 컴포넌트를 모아둔 폴더이며, Services 폴더는 API 요청과 같은 데이터 통신 기능들을 모아둔 폴더입니다. 이러한 폴더 구조는 특정 기능에 대한 코드들을 좀 더 체계적으로 관리할 수 있도록 해줍니다.
  ```

## 또다른 느낌의 Feature

```
src/
├── features/
│   ├── [FeatureName]/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── utils/
│   │   ├── hooks/
│   │   ├── types/
│   │   ├── constants/
│   │   ├── [FeatureName].tsx
│   │   ├── [FeatureName].spec.tsx
│   │   └── styles.ts
│   ├── [OtherFeature]/
│   └── ...
├── shared/
│   ├── components/
│   ├── utils/
│   ├── hooks/
│   ├── types/
│   ├── constants/
│   ├── App.tsx
│   ├── index.tsx
│   └── ...
└── ...

```

## Feature

```
src/
├── features/
│   ├── [FeatureName]/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── utils/
│   │   ├── hooks/
│   │   ├── types/
│   │   ├── constants/
│   │   ├── [FeatureName].tsx
│   │   ├── [FeatureName].spec.tsx
│   │   └── styles.ts
│   ├── [OtherFeature]/
│   └── ...
├── shared/
│   ├── components/
│   ├── utils/
│   ├── hooks/
│   ├── types/
│   ├── constants/
│   ├── App.tsx
│   ├── index.tsx
│   └── ...
└── ...


각 폴더와 파일에 대한 역할은 다음과 같습니다.

src/features/: 기능(feature)별로 폴더를 만듭니다. 예를 들어 User 기능이 있다면 src/features/User/ 폴더를 만듭니다.
components/: 해당 기능에서 사용하는 컴포넌트를 모아둡니다. 이 폴더 안에서도 atoms/, molecules/, organisms/와 같이 컴포넌트 유형에 따라 세분화할 수 있습니다.
pages/: 해당 기능에서 사용하는 페이지 컴포넌트를 모아둡니다.
utils/: 해당 기능에서 사용하는 유틸리티 함수나 헬퍼 함수 등을 모아둡니다.
hooks/: 해당 기능에서 사용하는 커스텀 훅을 모아둡니다.
types/: 해당 기능에서 사용하는 타입 정의 파일을 모아둡니다.
constants/: 해당 기능에서 사용하는 상수를 모아둡니다.
[FeatureName].tsx: 해당 기능을 구현한 메인 컴포넌트입니다.
[FeatureName].spec.tsx: 해당 기능의 테스트 파일입니다.
styles.ts: 해당 기능에서 사용하는 스타일 파일입니다.
위와 같은 폴더 구조를 사용하면 기능(feature)을 중심으로 모듈화하여 개발할 수 있어 유지보수와 확장성이 좋아집니다.
```

### 로그인 페이지 폴더구조 

```
src/
├── features/
|   ├── Login/out
|   |   ├── components/
|   |   |   ├── atoms/
|   |   |   |   ├── Input
|   |   |   |   ├── Button
|   |   |   ├── molecules/
|   |   |   |   ├── IconButton
|   |   |   |   ├── AvataIcon
|   |   |   ├── organisms/
|   |   ├── pages/
|   |   ├── utils/
|   |   ├── hooks/
|   |   ├── types/
|   |   ├── constants/
|   |   ├── Login.tsx
|   |   ├── Login.spec.tsx
|   |   ├── style.ts
|   |   ├── index.ts
|   ├── PjtDashBoard
|   |   ├── components/
|   |   |   ├── atoms/
|   |   |   ├── molecules/
|   |   |   ├── organisms/
|   |   ├── pages/
|   |   ├── utils/
|   |   ├── hooks/
|   |   |   ├── useLogin
|   |   ├── types/
|   |   ├── constants/
|   |   ├── PjtDashBoard.tsx
|   |   ├── PjtDashBoard.spec.tsx
|   |   ├── style.ts
|   |   ├── index.ts
|   ├── [FeatureName]
├── shared/
|   ├── components/
|   ├── utils/
|   ├── hooks/
|   ├── types/
|   ├── constants/
├── store/
App.tsx
main.tsx
....
```

### Login.tsx

```tsx
import React from "react";
import { Link } from "react-router-dom";
import { Input } from "./components/atoms";
import { Button } from "./components/molecules";
import { useLogin } from "./hooks";

const Login = () => {
  const { email, setEmail, password, setPassword, handleLogin } = useLogin();

  return (
    <div>
      <Input value={email} onChange={(e) => setEmail(e.target.value)} />
      <Input
        value={password}
        type="password"
        onChange={(e) => setPassword(e.target.value)}
      />
      <Button onClick={() => handleLogin(email, password)}>Login</Button>
      <Link to="/register">Don't have an account? Register here.</Link>
    </div>
  );
};
```

###  hooks/useLogin

```tsx
import { useState } from "react";

const useLogin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (email: string, password: string) => {
    // 로그인 처리 로직
  };

  return {
    email,
    setEmail,
    password,
    setPassword,
    handleLogin,
  };
};

export default useLogin;
```

### style.ts

```ts
import { createStyles, makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles(() =>
  createStyles({
    input: {
      border: "1px solid black",
      borderRadius: "5px",
      padding: "5px",
    },
    button: {
      backgroundColor: "blue",
      color: "white",
      border: "none",
      borderRadius: "5px",
      padding: "5px",
      cursor: "pointer",
    },
  })
);

export default useStyles;
```

### index.ts

```
export { default as Login } from "./Login";
```

