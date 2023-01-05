import { Outlet } from "react-router-dom";

function About(){

    return (
        <div>
            ABOUT 페이지
            <Outlet></Outlet>
        </div>
    );
}

export default About;


// import React, { useEffect, useState } from "react";
// import axios from "axios";
// function About() {
//   const [hello, setHello] = useState("");
//   useEffect(() => {
//     axios
//       .get("/api/books")
//       .then((response) => setHello(response.data))
//       .catch((error) => console.log(error));
//   }, []);

//   return <div>백엔드에서 가져온 데이터입니다 : {hello}</div>;
// }
// export default About;