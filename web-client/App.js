import React, { Component } from 'react';
import logo from './logo.svg';
import background from './background.jpg';
import './App.css';
import { runInNewContext } from 'vm';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      apiResponse: "",
      apiResponse2: ""
    };
  }

  callAPI() {
    fetch("http://localhost:9000/users")
      .then(res => console.log(res.json()
        .then(data => this.setState({
          apiResponse: data.values[0].first_name,
          apiResponse2: data.values[0].last_name
        })))

      )
    // .then(res => {
    //   this.setState({ apiResponse: res.values })});
  }

  componentWillMount() {
    this.callAPI();
  }

  render() {
    return (
      <div >

        <div class="grid home" id="home" style={{
          width: "100%",
          height: "1000px",
          backgroundImage: "url(" + background + ")"
        }}>
          {/* <div class="menu">
            <ul>
              <li><a href="landing.html">Home</a></li>
              <li><a href="page2.html">About Us</a></li>
              <li><a href="page3.html">Contact Us</a></li>
            </ul>
          </div> */}
          <div class="space">
            <h1>Welcome To My Web</h1>
            Mari Belajar bersama
            <div class="logo">
              <img src={logo} />
              <img src={logo} />
              <img src={logo} />
              <img src={logo} />
            </div>
            <div class="data">
              <a>{this.state.apiResponse}</a>
              <a class="data1">{this.state.apiResponse2}</a>
            </div>
          </div>
        </div>
      </div>
    );
  }
}


export default App;
