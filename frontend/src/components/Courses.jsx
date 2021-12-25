import React from "react";
import "../sass/Courses.scss";

function Courses() {
    return (
        <div className="courses">
            <div class="container">
               <div className="courses-taken-title">
                    <h3>Courses Taken</h3>
               </div>
                <div className="courses-taken-list">
                    <table className="stats-table">
                        <tr>
                            <th>CS319</th>
                        </tr>
                        <tr>
                            <th>CS315</th>
                        </tr>
                        <tr>
                            <th>CS202</th>
                        </tr>
                        <tr>
                            <th>MATH225</th>
                        </tr>
                        <tr>
                            <th>MATH230</th>
                        </tr>
                        <tr>
                            <th>GE301</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Courses;