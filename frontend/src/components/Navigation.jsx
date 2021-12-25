import React from "react";
import { NavLink } from "react-router-dom";
import navlogo from "../images/navlogo.png";
import '../sass/Navigation.scss';


function Navigation() {
    return (
        <div className="navigation">
            <nav className="navbar">
                <div className="container">
                    <NavLink className="navbar-brand" to="/">
                        <img src={navlogo} className="navbar-logo" alt="logo" />
                    </NavLink>
                    <nav className= "navbar-div">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/">
                                    Home
                                    <span className="sr-only">(current)</span>
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/about">
                                    About
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/contact">
                                    Contact
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/stats">
                                    Stats
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/appointments">
                                    Appointments
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/courses">
                                    Courses
                                </NavLink>
                            </li>
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/profile">
                                    Profile
                                </NavLink>
                            </li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
    );
}

export default Navigation;

