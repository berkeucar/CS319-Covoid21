import React from "react";
import '../sass/Profile.scss';
import panmanhead from "../images/panman-head.png";
function Profile() {
    return (
        <div className="profile">
            <div className="profile-container">
                    <div className="profile-brief">
                        <h1>My Profile</h1>
                        <img src={panmanhead} className="profile-brief-pp" alt="pp" />
                        <table className="profile-status-table">
                            <tr>
                                <th>Status:</th>
                                <td>Healthy</td>
                            </tr>
                        </table>
                        <div className="profile-brief-info">
                            <table className="profile-table">
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
                            <button className="button-edit-profile">Edit Profile</button>
                        </div>
                    </div>
                    <div className="profile-info">
                        <h1>My Data</h1>
                        <div className="dormmate">
                            <h3>Dormmates</h3>
                            <h5>•Elon Musk</h5>
                            <h5>•Nicola Tesla</h5>
                        </div>
                        <div className="deskmate">
                            <h3>Deskmates</h3>
                            <h5>•Eckstein</h5>
                            <h5>•Einstein</h5>
                        </div>
                        <div className="results">
                            <h3>Past Test Results</h3>
                            <h5>•31/02/2023 - (Negative)</h5>
                            <h5>•31/12/2022 - (Positive)</h5>
                        </div>
                    </div>
            </div>
        </div>
    );
}

export default Profile;