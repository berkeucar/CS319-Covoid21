
import React from "react";
import '../sass/About.scss'
import panmanlogo from "../images/panman_writing_1.png";

function About() {
    return (
        <div className="about">
            <div class="container">
                <div className="about-logo">
                    <img src={panmanlogo} className="about-logo" alt="pp" />
                </div>
                <div className="about-text">
                    <h1>TEAM COVOID21</h1>
                    <h3>Group 3E</h3>
                    <h3>Kutay Demiray</h3>
                    <h3>Gökberk Keskinkılıç</h3>
                    <h3>Berke Uçar</h3>
                    <h3>Yağız Yaşar</h3>
                    <h3>Burak Yıldıran</h3>
                    <a
                        className="App-link"
                        href="https://github.com/berkeucar/CS319-Covoid21"
                        target="_blank"
                        rel="noopener noreferrer"
                    > Visit Our Github Repository
                    </a>
                </div>
            </div>
        </div>
    );
}

export default About;