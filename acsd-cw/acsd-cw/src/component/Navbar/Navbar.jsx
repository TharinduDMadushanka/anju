import React from 'react';
import './Navbar.css';

import nav_logo from '../../assets/logo.jpg'
import { useNavigate } from 'react-router-dom';


const Navbar = () => {

    const navigate = useNavigate();

  return (
    <div id="navbar">
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
          <a className="navbar-brand nav-logo" href="#"><img src={nav_logo} alt="" /></a>
          
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            
            <div className="nav-links">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                    <a className="nav-link " aria-current="page" href="#" onClick={()=>{navigate('/')}}>
                    Home
                    </a>
                </li>

                <li className="nav-item">
                    <a className="nav-link " aria-current="page" href="#" onClick={()=>{navigate('/search-page')}}>
                    Property List
                    </a>
                </li>  

                <li className="nav-item">
                    <a className="nav-link " aria-current="page" href="#" onClick={()=>{navigate('/favoutite')}}>
                    Favourite
                    </a>
                </li>

                </ul>
            </div>

            <div className="nav-search">
                <form className="d-flex" role="search">
                <input
                    className="form-control me-2"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                />
                <button className="search-btn" type="submit">
                    Search
                </button>
                </form>
            </div>
            
          </div>
       
      </nav>
    </div>
  );
};

export default Navbar;
