---
title: Material UI 커스텀
date: 2023-02-28 05:43:00 +0900
category: react

---

## Material UI 테이블 커스텀

- 요구사항

  - 한 컬럼에 3개의 데이터가 들어가는 경우 필요

  - 예시

    | Pjt       | 주제들                  |
    | --------- | ----------------------- |
    | H23-KM-01 | Km<br/>test<br/>sw Test |

먼저, `@emotion/react`와 `@emotion/styled` 패키지를 설치합니다.

```
s
npm install @emotion/react @emotion/styled
```

그 다음, Material-UI 테마를 `ThemeProvider`로 감싸주는 과정에서 Emotion을 활용하여 스타일을 적용할 수 있습니다. 예를 들어, 다음과 같이 작성할 수 있습니다.

```

import { ThemeProvider } from '@mui/material/styles';
import { createTheme } from '@mui/material/styles';
import { CssBaseline } from '@mui/material';
import { Box } from '@mui/material';
import styled from '@emotion/styled';
import { Theme } from '@mui/material/styles';

const theme: Theme = createTheme({
  palette: {
    primary: {
      main: '#0d47a1',
    },
    secondary: {
      main: '#f50057',
    },
  },
});

const StyledBox = styled(Box)`
  background-color: ${(props) => props.theme.palette.background.paper};
  color: ${(props) => props.theme.palette.text.primary};
  padding: ${(props) => props.theme.spacing(2)}px;
`;

export default function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <StyledBox>
        <h1>Hello, MUI Emotion!</h1>
      </StyledBox>
    </ThemeProvider>
  );
}
```

위 코드에서 `styled` 함수를 사용하여 `Box` 컴포넌트에 스타일을 적용했습니다. `ThemeProvider`의 `theme` prop에서 정의된 Material-UI 테마를 활용하여 `background-color`, `color`, `padding` 스타일을 설정하였습니다. 이와 같은 방식으로 Material-UI 컴포넌트에 스타일을 적용할 수 있습니다.

MUI Emotion을 사용하기 위해서는 일반적인 MUI와 마찬가지로 MUI의 컴포넌트를 사용해야 합니다. MUI Emotion은 MUI의 스타일을 작성할 때 Emotion을 이용하여 스타일링합니다. 이 때, MUI의 컴포넌트들에 Emotion으로 작성된 스타일을 적용하기 위해서는 일반적으로 MUI의 컴포넌트와 스타일 파일들을 구분하여 폴더 구조를 구성하는 것이 좋습니다.

일반적으로 사용하는 방법은 아래와 같습니다.

```

src/
├── components/
│   ├── Button/
│   │   ├── index.tsx
│   │   ├── Button.styles.ts
│   ├── Card/
│   │   ├── index.tsx
│   │   ├── Card.styles.ts
├── theme/
│   ├── index.ts
```

위 예시에서는 `src/components` 폴더 내부에 Button, Card와 같은 컴포넌트 폴더를 생성하여 컴포넌트 파일과 컴포넌트의 스타일 파일을 함께 두었습니다. 이후에는 `Button.styles.ts`와 같이 Emotion으로 작성된 스타일 파일에서 MUI의 컴포넌트를 스타일링합니다. 그리고 `index.tsx` 파일에서는 MUI의 컴포넌트를 불러와서, `Button.styles.ts`에서 작성한 스타일을 적용합니다.

`theme` 폴더는 MUI의 테마 관련 파일을 저장하는 폴더입니다. MUI의 테마 관련 파일은 대부분 `index.ts` 파일로 작성하며, 이 파일에서 MUI의 테마 설정을 할 수 있습니다. 이렇게 작성된 테마 파일은 컴포넌트에서 사용되는 스타일링 속성을 관리하며, MUI Emotion에서도 같은 방식으로 사용됩니다.

다음은 간단한 예제 소스 코드입니다. 이 예제는 Material-UI의 Button 컴포넌트를 사용하여 버튼을 만들고, emotion으로 스타일링하는 방법을 보여줍니다.

```

import React from 'react';
import { Button } from '@mui/material';
import { styled } from '@mui/system';

const StyledButton = styled(Button)({
  background: 'linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)',
  border: 0,
  borderRadius: 3,
  boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
  color: 'white',
  height: 48,
  padding: '0 30px',
});

export default function EmotionButton() {
  return <StyledButton>Styled with emotion</StyledButton>;
}
```

이 코드에서는 `styled` 함수를 사용하여 `Button` 컴포넌트를 스타일링하고 있습니다. `styled` 함수는 `@mui/system` 패키지에서 가져올 수 있습니다.

`StyledButton` 컴포넌트는 `Button` 컴포넌트에 `background`, `border`, `borderRadius`, `boxShadow`, `color`, `height`, `padding` 등의 스타일 속성을 적용한 것입니다. 이렇게 생성된 `StyledButton` 컴포넌트는 `Button` 컴포넌트와 동일한 속성을 가지면서, emotion으로 스타일링된 버튼을 만들 수 있습니다.

위 코드를 실행하면 다음과 같은 결과물이 나옵니다:

## 재정의 하는법

1. `createMuiTheme` 함수를 사용하여 새로운 테마를 만듭니다. 이 함수는 Mui에서 기본적으로 제공하는 테마를 복제하여 수정하는 방식으로 사용됩니다.

```

import { createMuiTheme } from '@material-ui/core/styles';

const theme = createMuiTheme({
  palette: {
    primary: {
      main: '#1b5e20',
    },
    secondary: {
      main: '#ff9100',
    },
  },
});
```

위 코드에서는 `createMuiTheme` 함수를 사용하여 `palette` 속성을 재정의 하고 있습니다. `palette`는 Mui에서 사용하는 색상을 정의하는 객체이며, 위 코드에서는 `primary`와 `secondary` 색상을 재정의하고 있습니다.

1. `ThemeProvider` 컴포넌트를 사용하여 애플리케이션 전체에 새로운 테마를 적용합니다. 이 컴포넌트는 Mui에서 기본적으로 제공하는 컴포넌트입니다.

```

import { ThemeProvider } from '@material-ui/core/styles';
import { Button } from '@material-ui/core';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Button variant="contained" color="primary">
        Primary Button
      </Button>
      <Button variant="contained" color="secondary">
        Secondary Button
      </Button>
    </ThemeProvider>
  );
}
```

위 코드에서는 `ThemeProvider` 컴포넌트를 사용하여 전체 애플리케이션에 새로운 테마를 적용하고 있습니다. `theme` 변수에 저장된 새로운 테마를 `theme` prop으로 전달하고 있습니다. 이렇게 하면 모든 Mui 컴포넌트에서 새로운 테마가 적용됩니다.

## 참고 자료

[[React] Material-UI 라이브러리 테이블 커스텀하기](https://velog.io/@eunjin/React-Material-UI-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%BB%A4%EC%8A%A4%ED%85%80%ED%95%98%EA%B8%B0)

https://mui.com/material-ui/customization/theming/