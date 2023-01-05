import { Table } from "react-bootstrap";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { changeName, addAge } from "./../redux/userSlice.js";
import { addCount, sortItem } from "./../redux/store.js";
import { memo, useMemo, useState } from "react";
import About from "./../component/About.js"

let Child = memo(function Child() {
  console.log("재렌더링 됨");
  return <div>자식임</div>;
});

// function Child() {
//   console.log('재렌더링 됨')
//   return <div>자식임</div>;
// }

function 함수() {
  return "반복 10억";
}
function Cart() {
  let result = useMemo(() => {
    return 함수();
  });

  const { user, stock, cartItem } = useSelector((state) => {
    return state;
  });

  //console.log(user);
  //console.log(stock);
  //console.log(cartItem);

  let dispatch = useDispatch();
  const [count, setCount] = useState(0);
  return (
    <div>
      <About></About>
      <Child count={count}></Child>
      <button onClick={() => setCount(count + 1)}>+</button>

      <h6>
        {user.name}의 장바구니 {user.age}
      </h6>
      <button onClick={() => dispatch(sortItem())}>위치 바꾸기</button>
      <button onClick={() => dispatch(addAge(10))}>나이 증가 버튼</button>
      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>상품명</th>
            <th>수량</th>
            <th>변경하기</th>
          </tr>
        </thead>
        <tbody>
          {cartItem.map((obj, index) => (
            <tr index={index}>
              <td>{obj.id}</td>
              <td>{obj.name}</td>
              <td>{obj.count}</td>
              <td>
                <button onClick={() => dispatch(addCount(obj.id))}>+</button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}

export default Cart;
