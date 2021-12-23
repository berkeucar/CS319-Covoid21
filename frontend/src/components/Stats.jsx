import React from "react";
import '../sass/Stats.scss';

function Stats() {
    return (
        <div className="stats">
            <div className="container">
                <table className="stats-table">
                    <tr>
                        <th>Name:</th>
                        <td>Alexandre Chancourtois</td>
                    </tr>
                    <tr>
                        <th>Role:</th>
                        <td>Student</td>
                    </tr>
                    <tr>
                        <th>HES:</th>
                        <td>S2P7-1923-09</td>
                    </tr>
                    <tr>
                        <th>ID No:</th>
                        <td>83801666</td>
                    </tr>
                </table>
            </div>
        </div>
    );
}

export default Stats;