import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import data from "./data/data.js";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import Detail from "./router/Detail.js";
import About from "./component/About.js";

function App() {
  const [shoes, setShoes] = useState(data);
  let navigate = useNavigate();

  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link
              onClick={() => {
                navigate("./detail");
              }}
            >
              Detail
            </Nav.Link>
            <Nav.Link>
              <Link to="/detail">상세페이지</Link>
            </Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <Routes>
        <Route
          path="/"
          element={
            <>
              <div className="main-bg"></div>
              <div className="container">
                <div className="row">
                  {shoes.map((obj, index) => (
                    <Item shoes={obj} index={index + 1} key={index}></Item>
                  ))}
                </div>
              </div>
            </>
          }
        />
        <Route path="/detail/:id" element={<Detail shoes={shoes}></Detail>} />
        <Route path="/about" element={<About></About>}>
          <Route path="member" element={<div>멤버</div>} />
          <Route path="location" element={<div>위치</div>} />
        </Route>
        <Route path="*" element={<div>없는 페이지임</div>} />
        <Route
          path="event"
          element={
            <div>
              <h1>오늘의 이벤트</h1>
              <Outlet></Outlet>
            </div>
          }
        >
          <Route path="one" element={<div>첫 주문시 양배추즙 서비스</div>} />
          <Route path="two" element={<div>생일기념 쿠폰받기</div>} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;

function Item({ shoes, index }) {
  return (
    <div className="col-md-4">
      <img
        src={"https://codingapple1.github.io/shop/shoes" + index + ".jpg"}
        width="80%"
      ></img>
      <h4>{shoes.title}</h4>
      <p>{shoes.price}</p>
    </div>
  );
}
