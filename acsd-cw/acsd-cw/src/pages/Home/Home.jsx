import React from 'react';
import './Home.css';
import Navbar from '../../component/Navbar/Navbar';

// import home_bg from '../../assets/home-bg.jpg';
import home_bg from '../../assets/home-bg-2.jpg';


import townHouseImg from '../../assets/home-bg.jpg';
import modernVillaImg from '../../assets/home-bg.jpg';
import apartmentImg from '../../assets/home-bg.jpg';
import singleFamilyImg from '../../assets/home-bg.jpg';
import officeImg from '../../assets/home-bg.jpg';
import Footer from '../../component/Footer/Footer';

const Home = () => {
  return (
    <div className="home-container">
      <Navbar />
      <header className="hero-section">
        <div className="hero-bg">
          <img src={home_bg} alt="Background" />
        </div>
        <div className="hero-content">
          <h1 className="hero-title">
            The <span className="highlight">#1</span> site real estate professionals trust*
          </h1>
          <p className="hero-subtitle">
            From as low as $10 per day with limited time offer discounts.
          </p>
        </div>
      </header>

      {/* Explore Our Properties Section */}
      <section className="properties-section">
        <h2 className="section-title">Explore Our Properties</h2>
        <p className="section-subtitle">Lorem ipsum dolor sit amet</p>
        <div className="properties-grid">
          <div className="property-card">
            <img src={townHouseImg} alt="Town House" />
            <h3>Town House</h3>
            <p>2 Properties</p>
          </div>
          <div className="property-card">
            <img src={modernVillaImg} alt="Modern Villa" />
            <h3>Modern Villa</h3>
            <p>10 Properties</p>
          </div>
          <div className="property-card">
            <img src={apartmentImg} alt="Apartment" />
            <h3>Apartment</h3>
            <p>3 Properties</p>
          </div>
          <div className="property-card">
            <img src={singleFamilyImg} alt="Single Family" />
            <h3>Single Family</h3>
            <p>5 Properties</p>
          </div>
          <div className="property-card">
            <img src={officeImg} alt="Office" />
            <h3>Office</h3>
            <p>3 Properties</p>
          </div>
        </div>
      </section>

      {/* Mission Section */}
      <section className="mission-section">
        <h2 className="section-title">Our mission is to redefine real estate in the customer's favor.</h2>
        <p className="section-subtitle">Lorem ipsum dolor sit amet</p>
        <div className="stats-grid">
          {[
            { value: '5.2M', text: 'Owned from properties transactions' },
            { value: '7K+', text: 'Properties For Buy' },
            { value: '4K+', text: 'Properties Buy Sell' },
            { value: '221+', text: 'Daily Completed Transactions' },
          ].map((stat, index) => (
            <div className="stat-card" key={index}>
              <h3>{stat.value}</h3>
              <p>{stat.text}</p>
            </div>
          ))}
        </div>
      </section>

      <Footer/>    

    </div>
  );
};

export default Home;
