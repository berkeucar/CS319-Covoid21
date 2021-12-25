
import React from "react";
import "../sass/Appointments.scss";

function Appointments() {
    return (
        <div className="appointments">
            <div className="container">
                <div className="appointment-dropdowns">
                    <div className="appointment-type">
                        <div className="appointment-type-title">
                            <p>Appointment: </p>
                        </div>
                        <div className="dropdown">
                            <select id="dropdown-type">
                                <option value="test">Test</option>
                                <option value="doctor">Doctor</option>
                                <option value="sports">Sports</option>
                            </select>
                        </div>
                    </div>

                    <div className="appointment-date">
                        <div className="appointment-date-title">
                            <p>Date:</p>
                        </div>
                        <div className="dropdown-date">
                            <div className="dropdown">
                                <select id="dropdown-day">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select>
                            </div>
                            <div className="dropdown">
                                <select id="dropdown-month">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div className="dropdown">
                                <select id="dropdown-year">
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div className="appointment-time">
                        <div className="appointment-time-title">
                            <p>Time:</p>
                        </div>
                        <div className="dropdown-time">
                            <div className="dropdown">
                                <select id="dropdown-hour">
                                    <option value="0">00</option>
                                    <option value="1">01</option>
                                    <option value="2">02</option>
                                    <option value="3">03</option>
                                    <option value="4">04</option>
                                    <option value="5">05</option>
                                    <option value="6">06</option>
                                    <option value="7">07</option>
                                    <option value="8">08</option>
                                    <option value="9">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                </select>
                            </div>
                            <div className="dropdown">
                                <select id="dropdown-minute">
                                    <option value="0">00</option>
                                    <option value="1">05</option>
                                    <option value="2">10</option>
                                    <option value="3">15</option>
                                    <option value="4">20</option>
                                    <option value="5">25</option>
                                    <option value="6">30</option>
                                    <option value="7">35</option>
                                    <option value="8">40</option>
                                    <option value="9">45</option>
                                    <option value="10">50</option>
                                    <option value="11">55</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="schedule">
                    
                </div>

                <div className="list">

                </div>
            </div>
        </div>
    );
}

export default Appointments;