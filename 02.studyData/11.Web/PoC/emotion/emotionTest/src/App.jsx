import { useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";
import { css } from "@emotion/react";
import styled from "@emotion/styled";
const Button = styled.button`
  color: hotpink;
`;

const style = css`
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
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <Button> this is pink</Button>
    </div>
  );
}

export default App;


