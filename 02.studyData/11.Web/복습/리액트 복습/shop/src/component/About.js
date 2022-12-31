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