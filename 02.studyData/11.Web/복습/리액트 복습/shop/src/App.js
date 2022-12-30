import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import data from "./data.js";

function App() {
  const [shoes, setShoes] = useState(data);

  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <div className="main-bg"></div>
      <div className="container">
        <div className="row">
          {shoes.map((obj, index) => (
            <div className="col-md-4">
              <Item shoes={obj} index={index + 1} key={index}></Item>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;

function Item({ shoes, index }) {
  return (
    <>
      <img
        src={"https://codingapple1.github.io/shop/shoes" + index + ".jpg"}
        width="80%"
      ></img>
      <h4>{shoes.title}</h4>
      <p>{shoes.price}</p>
    </>
  );
}
