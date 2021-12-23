import React from "react";
//import panman from "../images/panman.png";
import '../sass/Home.scss';

function Home() {
    return (
        <div className="Home">
            <div className="container">
                <div className="home-status">
                    <div className="home-status-text">
                        <h1>Your Status:</h1>
                    </div>
                    <div className="home-status-safe">
                        <h1>Safe</h1>
                    </div>
                    <div className="home-status-risky">
                        <h1>Risky</h1>
                    </div>
                </div>
                <div className="home-last">
                    <div className="home-last-title">
                        <h1>Last Activities</h1>
                    </div>
                    <div className="home-last-container">
                        <div className="home-last-box">
                            <div className="home-last-box-title">
                                <p>CS319 Seating Plan</p>
                            </div>
                            <div className="home-last-box-status">
                                <p>Riskless</p>
                            </div>
                        </div>
                        <div className="home-last-box">
                            <div className="home-last-box-title">
                                <p>Test Appointment</p>
                            </div>
                            <div className="home-last-box-status">
                                <p>Negative</p>
                            </div>
                        </div>
                        <div  className="home-last-box">
                            <div className="home-last-box-title">
                                <p>My Contacts</p>
                            </div>
                            <div className="home-last-box-status">
                                <p>Riskless ben</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;