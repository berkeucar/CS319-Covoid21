import React from "react";
import '../sass/Stats.scss';
import 'react-dropdown/style.css';
/*
const options = [
    'one', 'two', 'three'
];
const defaultOption = options[0];
<Dropdown options={options} onChange={this._onSelect} value={defaultOption} placeholder="Select an option" />;
 */


function Stats() {
    return (
        <div className="stats">
            <div className="container">
                <div className="heat-map">
                    <img
                        className="img-fluid rounded mb-4 mb-lg-0"
                        src="http://placehold.it/400x400"
                        alt=""
                    />
                </div>
                <div className="statistics">
                    <div className="stats-title">
                        <div>
                            <p>Show Statistics: </p>
                        </div>
                        <div className="dropdown">
                            <select id="dropdown">
                                <option value="daily">Daily</option>
                                <option value="weekly">Weekly</option>
                                <option value="monthly">Monthly</option>
                                <option value="alltime">All Time</option>
                            </select>
                        </div>
                    </div>

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
        </div>
    );
}

export default Stats;