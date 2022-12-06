import logo from './logo.svg';
import './App.css';
import {useState} from 'react';

function App() {
  let post = '강남 우동 맛집';
  let [blogTitle, setBlogTitle] = useState('React Blog'); 
  let [subTitle, setSubTitle] = useState(['남자 코드 추천','강남 우동 맛집', '리액트 독학']); 
  let [like, setLike]=useState([0,0,0]);
  let [modal, setModal]=useState(false);
  let [title,setTitle] =useState(0);

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그용 내용</h4>
        <button onClick={()=>{
          let copySubTitle = [...subTitle];
          copySubTitle[0]='여자 코드 추천';
          setSubTitle(copySubTitle);
          }}>change</button>
        <button onClick={()=>{
          let copySubTitle = [...subTitle];
          copySubTitle.sort();
          setSubTitle(copySubTitle);
        }}>글자순 정렬</button>
      </div>
      {/* <div className="list">
        <h4 onClick={()=>{
          setModal(!true);
        }}>{subTitle[0]}<span onClick={()=>{setLike(like+1)}}>❤️</span>{like}</h4>
        <p>12월 04일 발행</p>
      </div>
      <div className="list">
        <h4>{subTitle[1]}</h4>
        <p>12월 04일 발행</p>
      </div>
      <div className="list">
        <h4>{subTitle[2]}</h4>
        <p>12월 04일 발행</p>
      </div> */}
      {/* <h4 style={{color:'red', fontSize:'45apx'}}>{post}</h4> */}
    {
      subTitle.map(function(index, number){
        return (
          <div className="list" key={number}>
            <h4 onClick={()=>{
              setTitle(number);
              setModal(!modal);
            }}>{subTitle[number]}
            <span onClick={()=>{
              let copyLike = [...like];
              copyLike[number]=copyLike[number]+1;
              setLike(copyLike);
            }}>❤️</span>
            {like[number]}
            </h4>
          </div>
        )
      })
    }
            {
          modal == true ? <Modal title={title} color = {'skyblue'} subTitle = {subTitle} setSubTitle ={setSubTitle}/> : null
        }
    </div>
  );

  function Modal(props){
    return(
      <div class="modal" style={{backgournd: props.color}}>
        <h4>{props.subTitle[props.title]}</h4>
        <p>날짜</p>
        <p>상세내용</p>
        <button onClick={()=>{
                  {props.setSubTitle(['여자 코드 추천','강남 우동 맛집', '리액트 독학'])}
                }}>
          제목 바꾸기
        </button>
      </div>
    )
  }
}

export default App;
