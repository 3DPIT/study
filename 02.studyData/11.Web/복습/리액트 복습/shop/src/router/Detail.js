import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

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

  const [inputValue, setInputValue] = useState("");

  useEffect(() => {
    if (isNaN(inputValue)) {
      alert("숫자만 입력하세요.");
    }
  }, [inputValue]);

  const [count, setCount] = useState(0);
  const { id } = useParams();
  const [hidden, setHidden] = useState(0);
  // const findProduct = shoes.find(function (x) {
  //   return x.id == id;
  // });
  const findProduct = shoes.find((x) => x.id == id);
  console.log(findProduct);
  return (
    <div className="container">
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
          <button className="btn btn-danger">주문하기</button>
        </div>
      </div>
    </div>
  );
}

export default Detail;
