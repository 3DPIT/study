import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import { Nav } from "react-bootstrap";
import "./Detail.css";
import { addItem } from "./../redux/store.js";
import { useDispatch } from "react-redux";
const YellowButton = styled.button`
  background: yellow;
  color: black;
  padding: 10px;
`;
const ColorButton = styled.button`
  background: ${({ color }) => color};
  color: ${({ color }) => (color === "blue" ? "white" : "black")};
  padding: 10px;
`;
const BlackBox = styled.div`
  background: black;
  padding: 10ㄴpx;
`;
const NewBtn = styled.button(ColorButton);

function Detail({ shoes }) {
  const dispatch = useDispatch();
  useEffect(() => {
    console.log(2);
    const setTImer = setTimeout(() => {
      setHidden(1);
    }, 2000);
    return () => {
      //코드
      console.log(1);
      clearTimeout(setTImer);
    };
  }, []);

  useEffect(() => {
    const getItem = JSON.parse(localStorage.getItem("watched"));
    getItem.push(id);
    const setItem1 = new Set(getItem);
    console.log(setItem1);
    const setItem2 = Array.from(setItem1);
    localStorage.setItem("watched", JSON.stringify(setItem2));
    console.log(setItem2);
  });
  const [inputValue, setInputValue] = useState("");

  useEffect(() => {
    if (isNaN(inputValue)) {
      alert("숫자만 입력하세요.");
    }
  }, [inputValue]);

  const [count, setCount] = useState(0);
  const { id } = useParams();
  const [hidden, setHidden] = useState(0);
  const [tab, setTab] = useState(0);

  // const findProduct = shoes.find(function (x) {
  //   return x.id == id;
  // });
  const findProduct = shoes.find((x) => x.id == id);
  console.log(findProduct);
  const [fade, setFade] = useState("");
  useEffect(() => {
    setTimeout(() => {
      setFade("end-scale");
    }, 100);
    return () => {
      clearTimeout();
      setFade("");
    };
  }, []);

  //localStorage.setItem("watched");
  return (
    <div className={`container start-scale ${fade}`}>
      {hidden == 0 && (
        <div className="alert alert-warning">2초이내 구매시 할인</div>
      )}
      <input onChange={(e) => setInputValue(e.target.value)}></input>
      {count}
      <ColorButton
        color={"blue"}
        onClick={() => {
          setCount(count + 1);
        }}
      >
        123123
      </ColorButton>
      <YellowButton>버튼</YellowButton>
      <BlackBox>박스</BlackBox>
      <div className="row">
        <div className="col-md-6">
          <img
            src={
              "https://codingapple1.github.io/shop/shoes" +
              (findProduct.id + 1) +
              ".jpg"
            }
            width="100%"
          />
        </div>
        <div className="col-md-6">
          <h4 className="pt-5">{findProduct.title}</h4>
          <p>{findProduct.content}</p>
          <p>{findProduct.price}원</p>
          <button
            className="btn btn-danger"
            onClick={() =>
              dispatch(addItem({ id: 1, name: "3dpit", count: 3 }))
            }
          >
            주문하기
          </button>
        </div>
      </div>

      <Nav variant="tabs" defaultActiveKey="link0">
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(0);
            }}
            eventKey="link0"
          >
            버튼0
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(1);
            }}
            eventKey="link1"
          >
            버튼1
          </Nav.Link>
        </Nav.Item>
        <Nav.Item>
          <Nav.Link
            onClick={() => {
              setTab(2);
            }}
            eventKey="link2"
          >
            버튼2
          </Nav.Link>
        </Nav.Item>
      </Nav>
      <TabContent shoes={shoes} tab={tab} />
    </div>
  );
}

function TabContent({ shoes, tab }) {
  // return tab === 0 ? (
  //   <div>내용0</div>
  // ) : tab == 1 ? (
  //   <div>내용1</div>
  // ) : (
  //   <div>내용2</div>
  // );

  // if (tab === 0) {
  //   return <div>내용0</div>;
  // } else if (tab === 1) {
  //   return <div>내용1</div>;
  // } else {
  //   return <div>내용2</div>;
  // }

  const [fade, setFade] = useState("");
  useEffect(() => {
    setTimeout(() => {
      setFade("end");
    }, 100);
    return () => {
      clearTimeout();
      setFade("");
    };
  }, [tab]);
  return (
    <div className={`start ${fade}`}>
      {[<div>{shoes[0].id}</div>, <div>내용1</div>, <div>내용2</div>][tab]}
    </div>
  );
}

export default Detail;
