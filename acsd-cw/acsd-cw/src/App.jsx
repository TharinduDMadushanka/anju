import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './pages/Home/Home'
import FilterPage from './pages/FilterPage/FilterPage'
import PropertyDetail from './pages/PropertyDetail/PropertyDetail'
import Favourite from './pages/Favorite/Favourite'

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home/>} />
          <Route path='/search-page' element={<FilterPage/>} />
          <Route path='/favoutite' element={<Favourite/>} />
          <Route path='/property-detail/:id' element={<PropertyDetail/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
