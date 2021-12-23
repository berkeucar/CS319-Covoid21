/*import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();*/

import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import * as serviceWorker from "./serviceWorker";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import {
    Navigation,
    Footer,
    Home,
    About,
    Appointments,
    Contact,
    Courses,
    Profile,
    Stats,

} from "./components";

ReactDOM.render(
    <Router>
        <Navigation />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="/appointments" element={<Appointments />} />
            {/*<Route path="/blog" element={<Blog />}>
                <Route path="" element={<Posts />} />
                <Route path=":postSlug" element={<Post />} />
            </Route>*/}
            <Route path="/courses" element={<Courses />} />
            <Route path="/navigation" element={<Navigation />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/stats" element={<Stats />} />
        </Routes>
        <Footer />
    </Router>,

    document.getElementById("root")
);

serviceWorker.unregister();