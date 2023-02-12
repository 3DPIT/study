# emotion install

```sh
npm install --save @emotion/react
```

- vite.config.js에 이렇게 해줘야 제대로 적용됨
  ```js
  import { defineConfig } from "vite";
  import react from "@vitejs/plugin-react";
  export default defineConfig({
    plugins: [
      react({
        jsxImportSource: "@emotion/react",
        babel: {
          plugins: [
            [
              "@emotion/babel-plugin",
              {
                autoLabel: "dev-only",
                labelFormat: "[dirname]--[filename]--[local]___",
              },
            ],
          ],
        },
      }),
    ],
  });
  ```

## 코드 적용하기

```js
import styled from "@emotion/styled";
const Button = styled.button`
  color: hotpink;
`;

const SomeComponent = ({ children }) => (
  <div css={style}>
    Some hotpink text.
    {children}
  </div>
);

const anotherStyle = css({
  textDecoration: "underline",
});

const AnotherComponent = () => (
  <div css={anotherStyle}>Some text with an underline.</div>
);

function App() {
  return (
    <div>
      <SomeComponent>
        <AnotherComponent />
      </SomeComponent>
    </div>
  );
}

export default App;
```

## stlyed 적용

```sh
npm install --save @emotion/styled
```

## 코드로 확인

```js
import styled from "@emotion/styled";
const Button = styled.button`
  color: hotpink;
`;

<Button> this is pink</Button>;
```

## @emotion/babel-plugin

```sh
npm install --save-dev @emotion/babel-plugin
```

## storybook에 추가할것

```js
// main.cjs
    config.plugins.push(
      react({
        exclude: [/\.stories\.(t|j)sx?$/, /node_modules/],
        jsxImportSource: '@emotion/react',
        babel: {
          plugins: ['@emotion/babel-plugin'],
        },
      }),
    );
	return config;
  },
```

### 참조글

[리액트 초기 설정](https://ms3864.tistory.com/441)
