import React from "react";
import panman from "../images/panman.png";

function Home() {
    return (
        <div className="Home">
            <div class="container">
                <div class="row align-items-center my-5">
                    <div class="col-lg-7">
                        <img
                            class="img-fluid rounded mb-4 mb-lg-0"
                            src={panman}
                            alt=""
                        />
                    </div>
                    <div class="col-lg-5">
                        <h1 class="font-weight-light">Home</h1>
                        <p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting
                            industry. Lorem Ipsum has been the industry's standard dummy text
                            ever since the 1500s, when an unknown printer took a galley of
                            type and scrambled it to make a type specimen book.
                        </p>
                    </div>
                    <div class="below">
                        <header className="Home-header">
                            <p>
                                Trying PANMAN!
                            </p>
                            <a
                                className="Home-link"
                                href="https://github.com/berkeucar/CS319-Covoid21"
                                target="_blank"
                                rel="noopener noreferrer"
                            > Visit Our Github Repository
                            </a>
                        </header>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;