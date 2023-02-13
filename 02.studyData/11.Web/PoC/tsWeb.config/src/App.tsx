import { useState } from "react";
import { useStore } from "@store/useStore";
import { Checkbox } from "@mui/material";
import { Button } from "@components/atomic";
import { IconButton } from "@components/molecules";
import { css } from "@emotion/react";
import {
  useParams,
  Routes,
  Route,
  Link,
  useNavigate,
  Outlet,
} from "react-router-dom";
import "./App.css";

const color = "white";
const colors = {
  default: "rgb(36,41,47)",
  danger: "rgb(207,34,46)",
  outline: "rgb(9,105,218)",
};

const sizeStyles = {
  sm: {
    fontSize: "12px",
    padding: "3px 12px",
  },
  md: {
    fontSize: "14px",
    padding: "5px 16px",
  },
  lg: {
    fontSize: "16px",
    padding: "9px 20px",
  },
};

const style = css`
  color: hotpink;
  &:hover {
    background: blue;
    color: ${color};
  }
`;
const label = { inputProps: { "aria-label": "Checkbox demo" } };

export function Cutton({ children, size = "md", variant = "default" }) {
  return (
    <button
      css={{
        borderRadius: "6px",
        border: "1px solid rgba(27, 31, 36, 0.15)",
        backgroundColor: "rgb(246, 248, 250)",
        color: colors[variant],
        fontFamily: "-apple-system, BlinkMacSystemFont, sans-serif",
        fontWeight: "600",
        lineHeight: "20px",
        ...sizeStyles[size],
        padding: "5px 16px",
        textAlign: "center",
        cursor: "pointer",
        appearance: "none",
        userSelect: "none",
      }}
    >
      {children}
    </button>
  );
}

function App() {
  const { bears } = useStore();
  return (
    <div className="App">
      <NavTest></NavTest>
      <Routes>
        <Route
          path="/"
          element={
            <div css={style}>
              홈
              <Cutton variant="danger" size="lg">
                dd
              </Cutton>
            </div>
          }
        />
        <Route
          path="/biz"
          element={
            <div>
              영업
              <Checkbox {...label} defaultChecked />
              <Checkbox {...label} />
              <Checkbox {...label} disabled />
              <Checkbox {...label} disabled checked />
            </div>
          }
        />
        <Route path="/deploy" element={<div>운영</div>} />
        <Route path="/tech" element={<div>기술</div>} />
      </Routes>
    </div>
  );
}

export default App;

export function NavTest() {
  let navigate = useNavigate();
  return (
    <div>
      <Button
        varient="Default"
        onClick={() => {
          navigate("./");
        }}
      >
        홈화면
      </Button>
      <Button
        varient="Danger"
        onClick={() => {
          navigate("./biz");
        }}
      >
        영업
      </Button>
      <Button
        varient="Info"
        onClick={() => {
          navigate("./deploy");
        }}
      >
        운영
      </Button>
      <Button
        varient="Warn"
        onClick={() => {
          navigate("./tech");
        }}
      >
        기술
      </Button>
    </div>
  );
}
