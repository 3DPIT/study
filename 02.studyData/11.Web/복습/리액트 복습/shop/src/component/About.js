// import { Outlet } from "react-router-dom";

// function About(){

//     return (
//         <div>
//             ABOUT 페이지
//             <Outlet></Outlet>
//         </div>
//     );
// }

// export default About;

// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';

function About() {
    const [hello, setHello] = useState('')
    const [hello1, setHello1] = useState([{}])

    useEffect(() => {
        axios.get('/api/books')
        .then(response => setHello(response.data[0].id))
        .catch(error => console.log(error))
    }, []);

//     useEffect(() => {
//         axios.get('/books')
//         .then(response => setHello1(response.data))
//         .catch(error => console.log(error))
//     }, []);

//     useEffect(() => {
//     axios.post("/add", {
// 	"id": "3",
//   	"name": "aa",
//     "author": "kmp",
//   	"price": 111
// })
//     .then(function (response) {
//          // response  
//     }).catch(function (error) {
//         // 오류발생시 실행
//     }).then(function() {
//         // 항상 실행
//     });
// }, []);  
// async await 함수를 사용할 때, 


    return (
        <div>
            백엔드에서 가져온 데이터입니다 : {hello}<p/>
            백엔드에서 가져온 데이터입니다 : {hello1[0].id}


        </div>
    );
}

export default About;