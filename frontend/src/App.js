import panman from './images/panman.png';
import './App.css';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={panman} className="App-logo" alt="logo" />
        <p>
          Trying PANMAN!
        </p>
        <a
          className="App-link"
          href="https://github.com/berkeucar/CS319-Covoid21"
          target="_blank"
          rel="noopener noreferrer"
        > Visit Our Github Repository
        </a>
      </header>
    </div>
  );
}

export default App;
