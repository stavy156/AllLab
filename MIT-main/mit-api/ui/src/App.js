import * as React from 'react';
import AppBar from './component/AppBar';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Login from './pages/Login';
import Customer from './pages/Customer';
import Admin from './pages/AdminPage';

const theme = createTheme({
  palette: {
    primary:{
      main:'#000a00'
    },
    secondary: {
      main: '#000a00',
    },
  },
});

function App() {
  return (
    <div style={{overflow:'auto'}}>
      <ThemeProvider theme={theme}>
        <Router>
          <Routes>
            <Route path="/" element={<AppBar componentPage={<Login />} />} />
            <Route path="/customer" element={<AppBar componentPage={<Customer />} />} />
            <Route path="/admin" element={<AppBar componentPage={<Admin/>} />} />
          </Routes>
        </Router>
      </ThemeProvider>
    </div>
  );
}

export default App;
