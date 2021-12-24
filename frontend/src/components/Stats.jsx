import React from "react";
import '../sass/Stats.scss';

function Stats() {
    return (
        <div className="stats">
            <div className="container">
                <table className="stats-table">
                    <tr>
                        <th>Total Cases in Campus:</th>
                        <td>37</td>
                    </tr>
                    <tr>
                        <th>Number of Students Infected:</th>
                        <td>23</td>
                    </tr>
                    <tr>
                        <th>Number of Instructors Infected:</th>
                        <td>9</td>
                    </tr>
                    <tr>
                        <th>Number of Personnel Infected:</th>
                        <td>5</td>
                    </tr>
                </table>
            </div>
        </div>
    );
}

export default Stats;