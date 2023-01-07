import React, {
  lazy,
  Suspense,
  createContext,
  useEffect,
  useState,
} from "react";
import logo from "./logo.svg";
import "./App.css";
import { Button, Container, Nav, Navbar } from "react-bootstrap";
import data from "./data/data.js";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import About from "./component/About.js";
import axios from "axios";
import { useQuery } from "react-query";
// import Detail from "./router/Detail.js"
// import Cart from "./router/Cart.js";

const Detail = lazy(() => import("./router/Detail.js"));
const Cart = lazy(() => import("./router/Cart.js"));

const ContextAPI = createContext();

function App() {
  const [addBtn, setAsddBtn] = useState(0);
  const [shoes, setShoes] = useState(data);
  const [재고] = useState(10, 11, 12);
  let navigate = useNavigate();

  // const result = useQuery("작명", () => {
  //   axios.get("https://codingapple1.github.io/userdata.json").then((a) => {
  //     return a.data;
  //   });
  // });
  let result = useQuery(
    "작명",
    () =>
      axios.get("https://codingapple1.github.io/userdata.json").then((a) => {
        return a.data;
      }),
    { staleTime: 2000 }
  );
  console.log(result.data);
  console.log(result.isLoading);

  useEffect(() => {
    if (localStorage.getItem("watched") == null) {
      localStorage.setItem("watched", JSON.stringify([]));
    }
  }, []);

  function onAddItem() {
    axios
      .get("https://codingapple1.github.io/shop/data2.json ")
      .then((data) => {
        console.log(data.data);
        const copyShoes = [...shoes, ...data.data];
        setShoes(copyShoes);
      })
      .catch(() => {
        console.log("실패함");
      });
  }

  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="ms-auto">
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
            <Nav.Link
              onClick={() => {
                navigate("./cart");
              }}
            >
              Cart
            </Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
          <Nav className="ms-auto">
            {result.isLoading && "로딩중"}
            {result.error && "에러남"}
            {result.data && result.data.name}
          </Nav>
        </Container>
      </Navbar>
      <Suspense fallback={<div>로딩중입니다.</div>}>
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
                <button
                  onClick={() => {
                    onAddItem();
                  }}
                >
                  더보기
                </button>
                <RecentItem></RecentItem>
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
          <Route path="cart" element={<Cart></Cart>} />
        </Routes>
      </Suspense>
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

function RecentItem() {
  let getItem1 = JSON.parse(localStorage.getItem("watched"));

  return (
    <div>
      {/* {getItem1.map((obj, index) => {
        return obj;
      })} */}
    </div>
  );
}
