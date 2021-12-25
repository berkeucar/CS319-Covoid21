import React from "react";
import panmanlogo from "../images/panman_writing_1.png";
import '../sass/About.scss';

function About() {
    return (
        <div className="about">
            <div className="container">
                <div className="logo">
                    <img src={panmanlogo} alt="logo"/>
                </div>
                <div className="info">
                    <h1>TEAM COVOID21</h1>
                    <h3>Group 3E</h3>
                    <h3>Kutay Demiray</h3>
                    <h3>Gökberk Keskinkılıç</h3>
                    <h3>Berke Uçar</h3>
                    <h3>Yağız Yaşar</h3>
                    <h3>Burak Yıldıran</h3>
                </div>
            </div>
        </div>
    );
}

export default About;